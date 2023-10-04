package com.dieutester.Bai17_POM.pages;

import com.dieutester.keywords.ActionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddNewCategoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By headerAddNewCategory = By.xpath("//h5[normalize-space()='Category Information']");
    private By inputName = By.xpath("//input[@id='name']");
    private By dropdownParentCategory = By.xpath("//button[@title='No Parent']");
    private By inputSearchParentCategory = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By optionParentCategory = By.xpath("//span[normalize-space()='Demo category 1']");
    private By inputOrderingNumber = By.xpath("//input[@id='order_level']");
    private By dropdownType = By.xpath("//button[@title='No Parent']");
    private By listOptionType = By.xpath("//select[@name='digital']");
    private By buttonBrowserBanner = By.xpath("(//div[contains(text(),'Browse')])[1]");
    private By inputSearchBannerFile = By.xpath("//input[@placeholder='Search your files']");
    private By ImageBanner = By.xpath("//div[@title='icon.jpg']//img[@class='img-fit']");
    private By buttonAddFilesBanner = By.xpath("//button[normalize-space()='Add Files']");
    private By inputSearchIconFile = By.xpath("//input[@placeholder='Search your files']");
    private By ImageIcon = By.xpath("//div[@title='Fpt-icon.png']//img[@class='img-fit']");
    private By buttonAddFilesIcon = By.xpath("//button[normalize-space()='Add Files']");
    private By buttonBrowserIcon = By.xpath("(//div[contains(text(),'Browse')])[2]");
    private By inputMetaTitle = By.xpath("//input[@placeholder='Meta Title']");
    private By inputMetaDescription = By.xpath("//textarea[@name='meta_description']");
    private By dropdownFilteringAttributes = By.xpath("//button[@title='Nothing selected']");
    private By inputSearchFilteringAttributes = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By buttonSave = By.xpath("//button[normalize-space()='Save']");

    public AddNewCategoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        new ActionKeywords(driver);
    }

    public void selectDropdownParentCategory(String parentCategoryName) {
        ActionKeywords.clickElementBy(dropdownParentCategory);
        driver.findElement(inputSearchParentCategory).sendKeys(parentCategoryName);
        driver.findElement(inputSearchParentCategory).sendKeys(Keys.ENTER);
    }

    public void AddNewCategory(String CATEGORY_NAME) {
        ActionKeywords.waitForPageLoaded();
        ActionKeywords.setTextBy(inputName, CATEGORY_NAME);
        selectDropdownParentCategory("Demo category 1");
        ActionKeywords.setTextBy(inputOrderingNumber, "1");
        ActionKeywords.selectDropdownDynamic(listOptionType, "Digital");

    }


}
