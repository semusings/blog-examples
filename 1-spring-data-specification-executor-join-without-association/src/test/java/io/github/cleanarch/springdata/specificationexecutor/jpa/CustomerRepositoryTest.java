package io.github.cleanarch.springdata.specificationexecutor.jpa;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

  private static final String VALUE = "value";
  private static final String AMENDMENT = "amendment";
  private static final String REFERENCE = "orderReference";
  private static final String REF = "ref";
  private static final String REF2 = REF + "2";
  private static final String REF3 = REF + "3";
  private static final String REF4 = REF + "4";
  private static final String AMOUNT = "amount";
  @Autowired private OrderRepository orderRepository;
  @Autowired private CustomerRepository repository;

  private static Specification<Customer> isLessThanOrEqualLimit(BigDecimal limit) {
    return (Specification<Customer>)
        (root, cq, cb) -> {
          Subquery<PizzaOrder> subQuery = cq.subquery(PizzaOrder.class);

          Root<PizzaOrder> subRoot = subQuery.from(PizzaOrder.class);
          subQuery.select(subRoot);

          Predicate refPredicate = cb.equal(subRoot.get(REFERENCE), root.<String>get(REFERENCE));

          Path<Amount> amountPath =
              getAmountPath(subRoot.get(AMENDMENT)).orElseGet(() -> subRoot.get(AMOUNT));

          Predicate amountPredicate = cb.lessThanOrEqualTo(amountPath.get(VALUE), limit);

          subQuery.select(subRoot).where(refPredicate, amountPredicate);

          return cb.exists(subQuery);
        };
  }

  private static Optional<Path<Amount>> getAmountPath(Path<Map<String, Object>> path) {
    try {
      return Optional.of(path.get(AMOUNT));
    } catch (IllegalStateException ex) {
      return Optional.empty();
    }
  }

  @Test
  public void canFilterLessThan() {

    setup1();

    List<Customer> list = repository.findAll(isLessThanOrEqualLimit(BigDecimal.valueOf(99)));

    Assertions.assertThat(list)
        .isNotEmpty()
        .hasSize(1)
        .first()
        .hasFieldOrPropertyWithValue(REFERENCE, REF);
  }

  @Test
  public void canFilterLessThanOrEqualTo() {

    setup1();

    List<Customer> list = repository.findAll(isLessThanOrEqualLimit(BigDecimal.valueOf(100)));

    Assertions.assertThat(list).isNotEmpty().hasSize(2);
  }

  @Test
  public void canFilterLessThanWithAmendment() {

    setup2();

    List<Customer> list = repository.findAll(isLessThanOrEqualLimit(BigDecimal.valueOf(200)));

    Assertions.assertThat(list)
        .isNotEmpty()
        .hasSize(1)
        .first()
        .hasFieldOrPropertyWithValue(REFERENCE, REF3);
  }

  @Test
  public void canFilterLessThanOrEqualToWithAmendment() {

    setup2();

    List<Customer> list = repository.findAll(isLessThanOrEqualLimit(BigDecimal.valueOf(202)));

    Assertions.assertThat(list).isNotEmpty().hasSize(2);
  }

  @After
  public void tearDown() {
    repository.deleteAll();
    orderRepository.deleteAll();
  }

  private HashMap<String, Object> amendment(BigDecimal amount) {
    HashMap<String, Object> map = new HashMap<>();
    map.put("amount", new Amount(amount));
    return map;
  }

  private void setup2() {
    PizzaOrder order3 = order(BigDecimal.valueOf(188), REF3);
    order3.setAmendment(amendment(BigDecimal.valueOf(186)));
    orderRepository.save(order3);
    repository.save(new Customer(REF3));

    PizzaOrder order4 = order(BigDecimal.valueOf(201), REF4);
    order4.setAmendment(amendment(BigDecimal.valueOf(202)));
    orderRepository.save(order4);
    repository.save(new Customer(REF4));
  }

  private void setup1() {
    orderRepository.save(order(BigDecimal.valueOf(88), REF));
    repository.save(new Customer(REF));

    orderRepository.save(order(BigDecimal.valueOf(100), REF2));
    repository.save(new Customer(REF2));
  }

  private PizzaOrder order(BigDecimal amount, String reference) {
    PizzaOrder pizzaOrder = new PizzaOrder();
    pizzaOrder.setOrderReference(reference);
    pizzaOrder.setAmount(new Amount(amount));
    return pizzaOrder;
  }
}
