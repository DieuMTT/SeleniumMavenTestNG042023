package com.dieutester.Bai16_ThucHanhCRM;

import com.dieutester.common.BaseTest;
import com.dieutester.locators.LocatorCRM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddNewCustomerCRMTest extends BaseTest {
    public void testLoginSuccess() {
        driver.get(InfoCRM.URL);
        waitForPageLoaded();
        setText(LocatorCRM.inputEmail, InfoCRM.EMAIL);
        setText(LocatorCRM.inputPassword, InfoCRM.PASSWORD);
        clickElement(LocatorCRM.buttonLogin);
        waitForPageLoaded();
        boolean checkURLNotAuthen = driver.getCurrentUrl().contains("authentication");
        Assert.assertFalse(checkURLNotAuthen);
        boolean checkURLContainsDashboard = driver.getCurrentUrl().contains("admin");
        Assert.assertTrue(checkURLContainsDashboard);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Can not navigate to  Dashboard page.");
    }

    @Test(priority = 1)
    public void testAddNewCustomerCRMSuccess() {
        testLoginSuccess();
        clickElement(LocatorCRM.menuCustomers);
        sleep(1);
        waitForPageLoaded();
        clickElement(LocatorCRM.buttonAddNewCustomer);
        sleep(1);
        waitForPageLoaded();
        setText(LocatorCRM.inputCompanyName, InfoCRM.CompanyName);
        setText(LocatorCRM.inputVatNumber, InfoCRM.VatNumber);
        setText(LocatorCRM.inputPhone, InfoCRM.Phone);
        setText(LocatorCRM.inputWebsite, InfoCRM.Website);
        clickElement(LocatorCRM.dropdownGroups);
        waitForPageLoaded();
        setText(LocatorCRM.inputSearchGroup, InfoCRM.SearchGroup);
        keysEnter(LocatorCRM.inputSearchGroup);
        clickElement(LocatorCRM.dropdownCurrency);
        waitForPageLoaded();
        setText(LocatorCRM.inputSearchCurrency, InfoCRM.SearchCurrency);
        keysEnter(LocatorCRM.inputSearchCurrency);
        clickElement(LocatorCRM.dropdownLanguage);
        waitForPageLoaded();
        clickElement(LocatorCRM.optionVietnamese);
        setText(LocatorCRM.inputAddress, InfoCRM.Address);
        setText(LocatorCRM.inputCity, InfoCRM.City);
        setText(LocatorCRM.inputState, InfoCRM.State);
        setText(LocatorCRM.inputZipCode, InfoCRM.ZipCode);
        clickElement(LocatorCRM.buttonCountry);
        waitForPageLoaded();
        setText(LocatorCRM.inputSearchCountry, InfoCRM.SearchCountry);
        keysEnter(LocatorCRM.inputSearchCountry);
        sleep(2);
        clickElement(LocatorCRM.buttonSaveCustomer);
        waitForPageLoaded();
        //Kiểm tra Save thành công chuyển hướng đến trang Customer Details
        Assert.assertTrue(checkElementExist(LocatorCRM.headerCustomerDetailsPage), "Fail.Can not navigate to Customer Details page.");
        verifyCustomerAdded();
        assertInFoCustomerAdded();
        VerifyDropdownCustomerExist();
    }

    public void verifyCustomerAdded() {
        //Click mở trang Customers lại
        clickElement(LocatorCRM.menuCustomers);
        waitForPageLoaded();
        //Search tên customer vừa add
        setText(LocatorCRM.inputSearchCustomers, InfoCRM.CompanyName);
        sleep(1);
        waitForPageLoaded();
        //Verify equals với data search
        Assert.assertEquals(getTextElement(LocatorCRM.firstItemCustomerOnTable), InfoCRM.CompanyName, "Fail.Customer Name not found");
    }

    public void assertInFoCustomerAdded() {
        //Click vào link Company added
        clickElement(LocatorCRM.firstItemCustomerOnTable);
        waitForPageLoaded();
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputCompanyName), InfoCRM.CompanyName, "Fail.CompanyName not match");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputVatNumber), InfoCRM.VatNumber, "Fail.VatNumber not match");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputPhone), InfoCRM.Phone, "Fail.Phone not match");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputWebsite), InfoCRM.Website, "Fail.Website not match");
        Assert.assertEquals(getTextElement(LocatorCRM.dropdownGroups), InfoCRM.SearchGroup, "Fail.Groups not match");
        Assert.assertEquals(getTextElement(LocatorCRM.dropdownCurrency), InfoCRM.SearchCurrency, "Fail.Currency not match");
        Assert.assertEquals(getTextElement(LocatorCRM.dropdownLanguage), "Vietnamese", "Fail.Language not match");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputAddress), InfoCRM.Address, "Fail.Address not match");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputCity), InfoCRM.City, "Fail.City not match");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputState), InfoCRM.State, "Fail.State not match");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputZipCode), InfoCRM.ZipCode, "Fail.ZipCode not match");
        Assert.assertEquals(getTextElement(LocatorCRM.buttonCountry), InfoCRM.SearchCountry, "Fail.Country not match");
    }

    //Click on Projects > New Project > Verify Dropdown Customer tồn tạiVerify Dropdown Customer tồn tại
    public void VerifyDropdownCustomerExist() {
        clickElement(LocatorCRM.menuProjects);
        clickElement(LocatorCRM.buttonAddNewProject);
        clickElement(LocatorCRM.dropdownCustomer);
        waitForElementVisible(LocatorCRM.inputSearchCustomer);
        sleep(2);
        waitForPageLoaded();
        setText(LocatorCRM.inputSearchCustomer, InfoCRM.CompanyName);
        sleep(2);
        Assert.assertTrue(checkElementExist(LocatorCRM.customerAdded), "Fail.Customer Name not exist");
    }

}
