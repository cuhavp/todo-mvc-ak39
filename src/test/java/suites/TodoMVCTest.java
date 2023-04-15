package suites;

import base.BaseTest;
import base.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.TodoMvcPage;

public class TodoMVCTest extends BaseTest {
    TodoMvcPage todoMvcPage;

    @Parameters({"browser"})
    @BeforeClass
    void setup(String browser) {
        Browser.open("Chrome");
        todoMvcPage = new TodoMvcPage();
        todoMvcPage.open();
    }

    @Test
    void createNewTodoSuccessfully() {
        int numberTodoListBefore = todoMvcPage.getTodoListSize();

        int countItemBefore = todoMvcPage.getItemLeft();
        todoMvcPage.createNewTask("task 1");

        int numberTodoListAfter = todoMvcPage.getTodoListSize();
        int countItemAfter = todoMvcPage.getItemLeft();

        Assert.assertTrue(todoMvcPage.isTaskDisplayed("task 1"));
        Assert.assertEquals(numberTodoListAfter - numberTodoListBefore, 1);
        Assert.assertEquals(countItemAfter - countItemBefore, 1);
    }

    @Test
    void markATodoCompleted() {
        todoMvcPage.createNewTask("task 1");
        todoMvcPage.markCompleted("task 1");
        todoMvcPage.selectTabView("Completed");
        Assert.assertTrue(todoMvcPage.isTaskDisplayed("task 1"));
    }

    @Test
    void deleteATodoSuccessfully() {
        todoMvcPage.createNewTask("task 1");
        int numberTodoListBefore = todoMvcPage.getTodoListSize();

        todoMvcPage.delete("task 1");

        int numberTodoListAfter = todoMvcPage.getTodoListSize();
        Assert.assertEquals(numberTodoListBefore - numberTodoListAfter, 1);
    }

    @Test
    void editTodoNameSuccessfully() {
        todoMvcPage.createNewTask("task 1");
        todoMvcPage.renameTask("task 1", "task 2");
        Assert.assertTrue(todoMvcPage.isTaskDisplayed("task 2"));
    }

    @AfterClass
    void closeBrowser() {
        Browser.quit();
    }


}
