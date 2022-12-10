package steps;

import page_object.CreateTaskPage;
import page_object.TasksListPage;
import page_object_tests.TestBase;

import java.net.MalformedURLException;

public class CreateNewTask extends TestBase {
    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;
    @io.cucumber.java.en.Given("Click Add new Task")
    public void clickAddNewTask() throws MalformedURLException {
        Android_setUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
    }

    @io.cucumber.java.en.Given("Enter Task Name")
    public void enterTaskName() {
        createTaskPage.enterTaskName("Task 1");
    }

    @io.cucumber.java.en.Given("Enter TaskDesk")
    public void enterTaskDesk() {
        createTaskPage.enterTaskDesc("Desc 1");
    }

    @io.cucumber.java.en.When("Click Save")
    public void clickSave() {
        createTaskPage.clickSaveBtn();
    }

    @io.cucumber.java.en.Then("Task added successfully")
    public void taskAddedSuccessfully() {
        driver.hideKeyboard();
        tearDown();
    }
}
