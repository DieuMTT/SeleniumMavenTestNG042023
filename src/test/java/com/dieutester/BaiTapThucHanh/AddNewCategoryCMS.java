package com.dieutester.BaiTapThucHanh;
import com.dieutester.common.BaseTest;
import com.dieutester.locators.LocatorCMS;
import com.dieutester.locators.LocatorCRM;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AddNewCategoryCMS extends BaseTest{
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
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.headerCategoriesPage)).isDisplayed(), "Không đến được trang All Categories.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCMS.headerAllCategoriesPage)).getText(), "All categories", "Tên header All Categories page không đúng.");
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.buttonAddNewCategory)).click();


        //TC Add New Category
        // Input Name
        String Name = "DMTT1";
        driver.findElement((By.xpath(LocatorCMS.inputName))).sendKeys(Name);

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
        sleep(8);

        //Click on Save button
        driver.findElement(By.xpath(LocatorCMS.buttonSave)).click();

        //Search lại Category vừa Add New
        sleep(2);
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys(Name);
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys(Keys.ENTER);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.firstItemCategoryOnTable)).isDisplayed(), "Không tìm thấy Category");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCMS.firstItemCategoryOnTable)).getText(),Name,"Không tìm thấy Category");
    }
    @Test(priority = 2)
    public void testEditCategory(){
        testAddNewCategory();
        driver.findElement(By.xpath(LocatorCMS.buttonEditCategory)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.inputName)).clear();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.inputName)).sendKeys("EditName");
        sleep(2);
        driver.findElement(By.xpath(LocatorCMS.buttonSave)).click();


        //Search lại Category vừa Edit
        driver.findElement(By.xpath(LocatorCMS.menuProducts)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.menuCategory)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys("EditName");
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys(Keys.ENTER);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCMS.firstItemCategoryOnTable)).isDisplayed(), "Không tìm thấy Category");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCMS.firstItemCategoryOnTable)).getText(),"EditName","Không tìm thấy Category");
}
    @Test(priority = 3)
    public void testDeleteCategory(){
        loginCMS();
        driver.findElement(By.xpath(LocatorCMS.menuProducts)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.menuCategory)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys("Dieu");
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys(Keys.ENTER);
        sleep(2);
        driver.findElement(By.xpath(LocatorCMS.buttonDeleteCategory)).click();
        sleep(1);
        driver.findElement(By.xpath("//a[contains(@class,'btn btn-primary mt-2')]")).click();

        //Search lại Category vừa Delete
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys("Dieu");
        driver.findElement(By.xpath(LocatorCMS.inputSearchType)).sendKeys(Keys.ENTER);
        sleep(2);
    }
}

