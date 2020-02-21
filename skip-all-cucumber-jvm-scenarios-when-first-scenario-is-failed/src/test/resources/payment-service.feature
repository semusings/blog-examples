Feature: Add an order

  Background: Add Order

  Scenario: Add order with customer 1234

    Given CustomerId "1234"
    When Add
    Then Total orders is 1

  Scenario: Pay order with customer 63455

    Given CustomerId "63455"
    When Pay "121.232"
    Then Mark as paid

  Scenario: Add order with customer 1234

    Given CustomerId "1234"
    When Add
    Then Total orders is 2


  Scenario: Add order with customer 1234

    Given CustomerId "1234"
    When Add
    Then Total orders is 3
