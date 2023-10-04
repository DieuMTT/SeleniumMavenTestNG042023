package com.dieutester.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ActionKeywords {
    private static WebDriver driver;

    public ActionKeywords(WebDriver driver) {
        this.driver = driver;
    }

    public static void logConsole(String message){
        System.out.println(message);
    }

    public static void clickElement(String locator){
        driver.findElement(By.xpath(locator)).click();
    }

    public static void setText(String locator, String text){
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }
    public static void setTextBy(By by, String text){
        waitForElementVisible(by );
        driver.findElement(by).sendKeys(text);
        logConsole("Set Text" + text + "on element" + by);
    }
  public static void clickElementBy(By by){
        waitForElementVisible(by);
        driver.findElement(by).click();
        logConsole("Click on Element"+ by);
  }
  public static void selectDropdownDynamic(By by, String text){
        waitForElementVisible(by);
      Select select = new Select(driver.findElement(by));
      select.selectByVisibleText(text);
  }
    public static boolean checkElementExist(By by) {
        List<WebElement> listElement = driver.findElements(by);

        if (listElement.size() > 0) {
            System.out.println("Element " + by + " existing.");
            return true;
        } else {
            System.out.println("Element " + by + " NOT exist.");
            return false;
        }
    }
    public static  void waitForElementVisible(By by){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30),Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }

}
