package steps;

import page_object.CreateTaskPage;
import page_object.TasksListPage;
import page_object_tests.TestBase;

import java.net.MalformedURLException;

public class CreateNewTaskWithData extends TestBase {
    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;
    @io.cucumber.java.en.Given("The user can add new task button")
    public void clickAddNewTask() throws MalformedURLException {
        Android_setUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
    }

    @io.cucumber.java.en.Given("Enter {string} and {string}")
    public void enterAnd(String taskName, String taskDesc) {
        createTaskPage = new CreateTaskPage(driver);
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesc);
    }

    @io.cucumber.java.en.When("Save task")
    public void clickSave() {
        createTaskPage.clickSaveBtn();
    }

    @io.cucumber.java.en.Then("Success!")
    public void taskAddedSuccessfully() {
        driver.hideKeyboard();
        tearDown();
    }
}
