package io.github.cleanarch.springdata.specificationexecutor.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PizzaOrder {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String orderReference;

  @Convert(converter = HashMapConverter.class)
  private Map<String, Object> amendment = new HashMap<>();

  private Amount amount;
}
