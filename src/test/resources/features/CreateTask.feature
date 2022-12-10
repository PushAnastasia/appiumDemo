Feature: Create New Task
  Scenario: The user can add new task
    Given Click Add new Task
    Given Enter Task Name
    Given Enter TaskDesk
    When Click Save
    Then Task added successfully