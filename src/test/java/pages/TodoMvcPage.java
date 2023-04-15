package pages;

import base.BasePage;
import base.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class TodoMvcPage extends BasePage {

    public void open(){
        driver.get("https://todomvc.com/examples/vanillajs/");
    }
    public void createNewTask(String name) {
        driver.findElement(By.className("new-todo")).sendKeys(name, Keys.ENTER);
    }

    public void markCompleted(String name) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getTaskByName(name)).perform();
        driver.findElement(By.xpath(String.format("//label[.='%s']/preceding-sibling::input",name))).click();
    }

    public void delete(String name) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getTaskByName(name)).perform();
        driver.findElement(By.xpath(String.format("//label[.='%s']/following-sibling::button",name))).click();

    }

    public void renameTask(String oldName, String newName) {
        Actions actions = new Actions(driver);
        actions.doubleClick(getTaskByName(oldName)).perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = ''",driver.findElement(By.cssSelector("input.edit")));
        driver.findElement(By.cssSelector("input.edit")).sendKeys(newName,Keys.ENTER);
    }

    WebElement getTaskByName(String name){
         return driver.findElement(By.xpath(String.format("//label[.='%s']",name)));
    }

    public int getTodoListSize() {
        return driver.findElements(By.cssSelector(".todo-list li")).size();
    }

    public int getItemLeft() {
        int itemLeft = 0;
        if (driver.findElement(By.cssSelector(".todo-count strong")).isDisplayed()) {
            itemLeft = Integer.parseInt(driver.findElement(By.cssSelector(".todo-count strong")).getText());
        }
        return itemLeft;
    }
    public boolean isTaskDisplayed(String name){
         return getTaskByName(name).isDisplayed();
    }
    public void selectTabView(String name){
        driver.findElement(By.linkText(name)).click();

    }
}
