package com.dieutester.Bai17_POM.pages;

import com.dieutester.constants.ConfigData;
import com.dieutester.keywords.ActionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DashboardPage {
    //Khai báo driver cục bộ trong chính class này
    private WebDriver driver;
    private WebDriverWait wait;

    //Khai báo các element dạng đối tượng By
    private By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    private By buttonOptionDashboard = By.xpath("//div[@class='screen-options-btn']");

    //Hàm xây dựng
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        new ActionKeywords(driver);
    }

    //Hàm xử lý
    public void verifyDashboardPage() {
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "Fail. Can not navigate to Dashboard page.");
        Assert.assertEquals(driver.getCurrentUrl(), ConfigData.URL_DB, "Fail.URL is not Dashboard page.");
        Assert.assertTrue(ActionKeywords.checkElementExist(buttonOptionDashboard), "Fail.The Option Dashboard button is not existing ");
    }

    public void openCustomerPage() {
        ActionKeywords.waitForPageLoaded();
        driver.findElement(menuCustomer).click();
    }


}
