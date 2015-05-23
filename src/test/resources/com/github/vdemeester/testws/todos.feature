Feature: TodoService tests

  Scenario: Find all Todos
    When I run findAll
    Then I get a list of size 3

  Scenario: Find an existent Todo
    When I run findOne with id 1
    Then I get a Todo object
    And  It is completed
    And  It has no due date

  Scenario: Find a non-existent Todo
    When I run findOne with id 4
    Then I get an IllegalArgumentException

  # (Bonus)
  Scenario: Find an existend not completed Todo
    When I run findOne with id 3
    Then I get a Todo object
    And  It is not completed
    And  It has a due date that is 2015-08-01 00:00

