package io.github.bhuwanupadhyay.ordering;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class GlueSteps {

    private OrderService orderService = new OrderService();
    private PaymentService paymentService = new PaymentService();
    private String customerId;

    @Given("CustomerId {string}")
    public void customerId(String customerId) {
        this.customerId = customerId;
    }

    @When("Add")
    public void add() {
        orderService.addOrder(customerId);
    }

    @Then("Total orders is {int}")
    public void totalOrdersIs(int size) {
        assertEquals(size, orderService.totalOrders());
    }

    @When("Pay {string}")
    public void pay(String amount) {
        paymentService.pay("NOTEXIST", new BigDecimal(amount));
    }

    @Then("Mark as paid")
    public void markAsPaid() {

    }
}
