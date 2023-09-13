package com.dieutester.BaiTapThucHanh;
import com.dieutester.common.BaseTest;
import com.dieutester.locators.LocatorCMS;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
public class BT3AddNewCategoryCMS extends BaseTest{
    public String NameCategory = "DMTT11";
    public BT3AddNewCategoryCMS(WebDriver _driver) {
        driver = _driver;
    }

    public void loginCMS() {
        driver.get("https://cms.anhtester.com/login");
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.headerLoginPage)).isDisplayed(), "Header không tồn tại, không phải trang Login");
        driver.findElement(By.xpath(LocatorCMS.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCMS.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCMS.buttonLogin)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.menuProducts)).isDisplayed(), "Không đến được trang Products.");
    }
    @Test(priority = 1)
    public void testAddNewCategory(){
        loginCMS();
        driver.findElement(By.xpath(LocatorCMS.menuProducts)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.menuCategory)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.headerCategoriesPage)).isDisplayed(),
                "Không đến được trang All Categories.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCMS.headerAllCategoriesPage)).getText(),
                "All categories",
                "Tên header All Categories page không đúng.");
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.buttonAddNewCategory)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.headerAddNewCategory)).isDisplayed(),
                "Không đến được trang  Add New Category\"");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCMS.headerAddNewCategory)).getText(),
                "Category Information",
                "Header không tồn tại, không phải trang Add New Category");
        // Input Name
        driver.findElement((By.xpath(LocatorCMS.inputName))).sendKeys(NameCategory);
       // Input Search Parent Category
        driver.findElement(By.xpath(LocatorCMS.dropdownParentCategory)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.inputSearchParentCategory)).sendKeys("Demo category 1");
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.inputSearchParentCategory)).sendKeys(Keys.ENTER);
       //InputOrderingNumber
        driver.findElement((By.xpath(LocatorCMS.inputOrderingNumber))).sendKeys("1");
        //Input Type
        Select select = new Select(driver.findElement(By.xpath(LocatorCMS.listOptionType)));
        select.selectByVisibleText("Digital");
        //Kiểm tra dropdown có hổ trợ dạng multi-select không
        Assert.assertFalse(select.isMultiple());
        //Kiểm tra dropdown có 2 giá trị
        Assert.assertEquals(select.getOptions().size(),2);
        //Kiểm tra giá trị trong dropdown đúng sau khi đã chọn thành công
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Digital");
        //Input Banner
        driver.findElement(By.xpath(LocatorCMS.buttonBrowserBanner)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.inputSearchBannerFile)).sendKeys("icon");
        sleep(3);
        driver.findElement(By.xpath(LocatorCMS.ImageBanner)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.buttonAddFilesBanner)).click();
        sleep(1);
        //Input Icon
        driver.findElement(By.xpath(LocatorCMS.buttonBrowserIcon)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.inputSearchIconFile)).sendKeys("icon");
        sleep(3);
        driver.findElement(By.xpath(LocatorCMS.ImageIcon)).click();
        sleep(2);
        driver.findElement(By.xpath(LocatorCMS.buttonAddFilesBanner)).click();
        sleep(1);
        //Input MetaDescription
        driver.findElement(By.xpath(LocatorCMS.inputMetaDescription)).sendKeys("abc");
        sleep(1);
       //Input FilteringAttributes
        driver.findElement(By.xpath(LocatorCMS.dropdownFilteringAttributes)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.inputSearchFilteringAttributes)).sendKeys("Fabric");
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.inputSearchFilteringAttributes)).sendKeys(Keys.ENTER);
        sleep(2);
        //Click on Save button
        driver.findElement(By.xpath(LocatorCMS.buttonSave)).click();
        //Search lại Category vừa Add New
        sleep(2);
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys(NameCategory);
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys(Keys.ENTER);
        sleep(2);
        //BT1
        String itemName = driver.findElement(By.xpath(LocatorCMS.firstItemCategoryOnTable)).getText();
        if(itemName==NameCategory){
            System.out.println("Add Category  successfully");
        }else {
            System.out.println(("Add Category  unsuccessfully"));
        }
       //BT3
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.firstItemCategoryOnTable)).isDisplayed(),
                "Không tìm thấy Category");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCMS.firstItemCategoryOnTable)).getText(),NameCategory,
                "Không tìm thấy Category");
    }
    @Test(priority = 2)
    public void testEditCategory(){
        testAddNewCategory();
        driver.findElement(By.xpath(LocatorCMS.buttonEditCategory)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.inputName)).clear();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.inputName)).sendKeys("EditName1111");
        sleep(2);
        driver.findElement(By.xpath(LocatorCMS.buttonSave)).click();
        sleep(10);

        //Search lại Category vừa Edit
        driver.findElement(By.xpath(LocatorCMS.menuCategory)).click();
        sleep(4);
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys("EditName1111");
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys(Keys.ENTER);
        sleep(5);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.firstItemCategoryOnTable)).isDisplayed(),
                "Không tìm thấy Category");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCMS.firstItemCategoryOnTable)).getText(),
                "EditName1111",
                "Không tìm thấy Category");

        //Kiểm tra giá trị sau khi Edit
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCMS.inputName)).getAttribute("value"),
                "EditName1111 ",
                "Name đã update không đúng.");
}
    @Test(priority = 3)
    public void testDeleteCategory(){
        loginCMS();
        driver.findElement(By.xpath(LocatorCMS.menuProducts)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.menuCategory)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys("EditName1111");
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys(Keys.ENTER);
        sleep(2);
        driver.findElement(By.xpath(LocatorCMS.buttonDeleteCategory)).click();
        sleep(1);
        driver.findElement(By.xpath("//a[contains(@class,'btn btn-primary mt-2')]")).click();

        //Search lại Category vừa Delete
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys("EditName1111");
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys(Keys.ENTER);
        sleep(2);
       String messageSearchNotFoundCategory = driver.findElement(By.xpath(LocatorCMS.messageNothingFound)).getText();
       Assert.assertEquals(messageSearchNotFoundCategory,
               "Nothing found",
               "Message Search Not Found Category  không tồn tại");
    }
}

