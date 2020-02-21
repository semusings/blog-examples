Feature: Add an order

  Background: Add Order

  Scenario: Add order with customer 1234

    Given CustomerId "1234"
    When Add
    Then Total orders is 1

  Scenario: Add order with customer null

    Given CustomerId ""
    When Add
    Then Total orders is 1

  Scenario: Add order with customer 1234

    Given CustomerId "1234"
    When Add
    Then Total orders is 2


  Scenario: Add order with customer 1234

    Given CustomerId "1234"
    When Add
    Then Total orders is 3
