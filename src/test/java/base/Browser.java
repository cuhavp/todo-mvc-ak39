package base;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class Browser {
    private static WebDriver driver;
    public static void open(String name){
        switch (name){
            case "Chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "Firefox": {
                driver = new FirefoxDriver();
                break;
            }
        }
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void captureScreen(String name){
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File DestFile = new File("./target/screenshot/"
                + name
                + "-"
                + System.currentTimeMillis() + ".png");
        try {
            FileUtils.copyFile(file, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void quit(){
        if(driver !=null){
            driver.quit();
        }
    }
}
