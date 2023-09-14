package com.dieutester.BaiTapThucHanh;

import com.dieutester.common.BaseTest;
import com.dieutester.locators.LocatorCMS;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class BT4AddProductCMS extends BaseTest {
    @Test
    public void TestAddNewProduct() throws AWTException {
        BT3AddNewCategoryCMS addNewCategories = new BT3AddNewCategoryCMS(driver);
//    addNewCategories.testAddNewCategory();
        addNewCategories.loginCMS();
        Robot robot = new Robot();
        Actions action = new Actions(driver);
        action.click(driver.findElement(By.xpath(LocatorCMS.menuProducts))).perform();
        action.click(driver.findElement(By.xpath(LocatorCMS.menuAddNewProduct))).perform();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.headerAddNewProductPage)).isDisplayed(), "Header không tồn tại, không phải trang Login");
        action.pause(2000);
        //Input Product Information
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.headerProductInformationPage)).isDisplayed(), "Header không tồn tại, không phải trang Login");
        action.sendKeys(driver.findElement(By.xpath(LocatorCMS.inputProductName)), "ProductNameD").perform();
        action.click(driver.findElement(By.xpath(LocatorCMS.dropdownCategory)))
                .pause(2000)
                .sendKeys(driver.findElement(By.xpath(LocatorCMS.inputSearchCategory)), "DMTT1")
                .pause(2000)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        action.click(driver.findElement(By.xpath(LocatorCMS.dropdownBrand)))
                .pause(2000)
                .sendKeys(driver.findElement(By.xpath(LocatorCMS.inputSearchBrand)), "CMS brand 01")
                .pause(2000)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        action.sendKeys(driver.findElement(By.xpath(LocatorCMS.inputUnit)), "KG").perform();
        WebElement weight = driver.findElement(By.xpath(LocatorCMS.inputWeight));
        weight.clear();
        action.sendKeys(weight, "1.25").perform();

        WebElement MinimumPurchaseQty = driver.findElement(By.xpath(LocatorCMS.inputMinimumPurchaseQty));
        MinimumPurchaseQty.clear();
        action.sendKeys(MinimumPurchaseQty, "1").perform();
        action.sendKeys(driver.findElement(By.xpath(LocatorCMS.inputTags)), "Product1").perform();
        sleep(1);

        //Product Variation
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.headerProductVariation)).isDisplayed(), "Header không tồn tại, không phải trang Login");
        action.click(driver.findElement(By.xpath(LocatorCMS.buttonActiveColor))).perform();
        sleep(1);
        action.click(driver.findElement(By.xpath(LocatorCMS.dropdownColors))).perform();
//        sleep(2);
//        robot.keyPress(KeyEvent.VK_DOWN);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        sleep(3);
//        robot.keyPress(KeyEvent.VK_DOWN);
//        robot.keyPress(KeyEvent.VK_DOWN);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        sleep(3);
        WebElement inputSearchColor = driver.findElement(By.xpath(LocatorCMS.inputSearchColors));
        action.sendKeys(inputSearchColor, "Aqua")
                .sendKeys(Keys.ENTER)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys(inputSearchColor, "Azure")
                .sendKeys(Keys.ENTER)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys(inputSearchColor, "Black")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        sleep(2);
        //Kiểm tra giá trị trong dropdown đúng sau khi đã chọn thành công
        String numberItemSelected = driver.findElement(By.xpath(LocatorCMS.dropdownColors)).getText();
        System.out.println(numberItemSelected);
        Assert.assertEquals(numberItemSelected, "3 items selected", "numberItemSelected không đúng.");

        driver.findElement(By.xpath(LocatorCMS.dropdownAttributes)).click();
        sleep(2);
        driver.findElement(By.xpath(LocatorCMS.inputSearchAttributes)).sendKeys("Fabric");
        robot.keyPress(KeyEvent.VK_ENTER);

        //Input Product price + stock
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.headerProductPriceStock)).isDisplayed(), "Header không tồn tại, không phải trang Login");
        WebElement unitPrice = driver.findElement(By.xpath(LocatorCMS.inputUnitPrice));
        unitPrice.clear();
        action.sendKeys(unitPrice, "11").perform();
        WebElement discount = driver.findElement(By.xpath(LocatorCMS.inputDiscount));
        discount.clear();
        action.sendKeys(discount, "1").perform();
        Select select = new Select(driver.findElement(By.xpath(LocatorCMS.listDiscountType)));
        select.selectByVisibleText("Percent");
        sleep(1);
        //Kiểm tra dropdown có hổ trợ dạng multi-select không
        Assert.assertFalse(select.isMultiple());
        //Kiểm tra dropdown có 2 giá trị
        Assert.assertEquals(select.getOptions().size(), 2);
        //Kiểm tra giá trị trong dropdown đúng sau khi đã chọn thành công
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Percent");
        sleep(5);
//        driver.findElement(By.xpath(LocatorCMS.inputQuantity)).sendKeys("1");
//        driver.findElement(By.xpath(LocatorCMS.inputSKU)).sendKeys("1");
        action.sendKeys(driver.findElement(By.xpath(LocatorCMS.inputExternalLink)), "https://anhtester.com/").perform();
        action.sendKeys(driver.findElement(By.xpath(LocatorCMS.inputExternalLinkButtonText)), "https://anhtester.com/").perform();
        action.click(driver.findElement(By.xpath(LocatorCMS.SaveAndUnpublish))).perform();

    }
}
