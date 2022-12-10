package page_object_tests;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_object.CreateTaskPage;
import page_object.TasksListPage;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class ToDo_Android extends TestBase {

    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @DataProvider(name = "tasks data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJSONData(System.getProperty("user.dir") + "/data/TasksData.json", "Tasks Data", 2);
    }

    @Test(dataProvider = "tasks data")
    public void testAddTask(String taskName, String taskDesk) throws MalformedURLException {
        Android_setUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDesk);
        driver.hideKeyboard();
        createTaskPage.clickSaveBtn();
        tearDown();
    }
}
