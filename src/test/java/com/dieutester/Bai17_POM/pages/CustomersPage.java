package com.dieutester.Bai17_POM.pages;

import com.dieutester.constants.ConfigData;
import com.dieutester.keywords.ActionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CustomersPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //Object
    private By headerCustomersPage = By.xpath("//div[@class='panel-body']//h4[contains(.,'Customers ')]");

    //Hàm xây dựng
    public CustomersPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        new ActionKeywords(driver);
    }

    //Hàm xử lí
    public void verifyCustomersPage() {
        Assert.assertEquals(driver.getCurrentUrl(), ConfigData.URL_Customers, "Fail.Cannot navigate to Customers page");
        Assert.assertTrue(ActionKeywords.checkElementExist(headerCustomersPage), "Fail.Cannot navigate to Customers page");
    }
}
