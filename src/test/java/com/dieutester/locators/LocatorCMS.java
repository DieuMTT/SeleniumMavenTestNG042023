package com.dieutester.locators;

public class LocatorCMS {
    //Login CRS
    public static String headerLoginPage ="//h1[normalize-space()='Welcome to Active eCommerce CMS']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot password ?']";

    //Menu
    public static String menuProducts = "//span[normalize-space()='Products']";
    public static String menuCategory = "//span[normalize-space()='Category']";

    //All Categories
    public static String buttonAddNewCategory = "//span[normalize-space()='Add New category']";
    public static String headerAllCategoriesPage ="//h1[normalize-space()='All categories']";
    public static String headerCategoriesPage ="//h5[normalize-space()='Categories']";
    public static String inputSearchType ="//input[@id='search']";
    public static String firstItemCategoryOnTable ="//tbody/tr[1]/td[2]";
    public static String buttonEditCategory ="//i[contains(@class,'las la-edit')]";
    public static String buttonDeleteCategory ="(//i[contains(@class,'las la-trash')])[1]";






    //Add New Category  page
    public static String inputName = "//input[@id='name']";
    public static String dropdownParentCategory = "//button[@title='No Parent']";
    public static String inputSearchParentCategory = "//div[@class='dropdown-menu show']//input[@aria-label='Search']";
    public static String optionParentCategory = "//span[normalize-space()='Demo category 1']";
    public static String inputOrderingNumber = "//input[@id='order_level']";
    public static String dropdownType = "//button[@title='No Parent']";
    public static String listOptionType = "//select[@name='digital']";

    public static String buttonBrowserBanner = "(//div[contains(text(),'Browse')])[1]";
    public static String inputSearchBannerFile = "//input[@placeholder='Search your files']";
    public static String ImageBanner = "//div[@title='icon.jpg']//img[@class='img-fit']";
    public static String buttonAddFilesBanner = "//button[normalize-space()='Add Files']";
    public static String inputSearchIconFile = "//input[@placeholder='Search your files']";
    public static String ImageIcon= "//div[@title='Fpt-icon.png']//img[@class='img-fit']";
    public static String buttonAddFilesIcon = "//button[normalize-space()='Add Files']";
    public static String buttonBrowserIcon = "(//div[contains(text(),'Browse')])[2]";
    public static String inputMetaTitle = "//input[@placeholder='Meta Title']";
    public static String inputMetaDescription = "//textarea[@name='meta_description']";
    public static String dropdownFilteringAttributes = "//button[@title='Nothing selected']";
    public static String inputSearchFilteringAttributes= "//div[@class='dropdown-menu show']//input[@aria-label='Search']";
    public static String buttonSave = "//button[normalize-space()='Save']";

}
