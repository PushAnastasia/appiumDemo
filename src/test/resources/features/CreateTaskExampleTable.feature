Feature: Create New Task
  Scenario Outline: The user can add new task button
    Given Click Add new Task
    Given Enter "<TaskName>" and "<TaskDesc>"
    When Save task
    Then Success!

    Examples:
    | TaskName | TaskDesc |
    | Cucumber Task 1 | Task 1 Details |
    | Cucumber Task 2 | Task 2 Details |