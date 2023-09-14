package com.dieutester.locators;

import org.openqa.selenium.By;

public class LocatorCMS {
    //Login CMS
    public static String headerLoginPage = "//h1[normalize-space()='Welcome to Active eCommerce CMS']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot password ?']";

    //Menu
    public static String menuProducts = "//span[normalize-space()='Products']";
    public static String menuAddNewProduct = "//span[normalize-space()='Add New Product']";
    public static String menuCategory = "//span[normalize-space()='Category']";


    //All Categories
    public static String buttonAddNewCategory = "//span[normalize-space()='Add New category']";
    public static String headerAllCategoriesPage = "//h1[normalize-space()='All categories']";
    public static String headerCategoriesPage = "//h5[normalize-space()='Categories']";
    public static String inputSearchType = "//input[@id='search']";
    public static String firstItemCategoryOnTable = "//tbody/tr[1]/td[2]";
    public static String buttonEditCategory = "//i[contains(@class,'las la-edit')]";
    public static String buttonDeleteCategory = "(//i[contains(@class,'las la-trash')])[1]";
    public static String messageNothingFound = "//td[normalize-space()='Nothing found']";

    //Add New Category  page
    public static String headerAddNewCategory = "//h5[normalize-space()='Category Information']";
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
    public static String ImageIcon = "//div[@title='Fpt-icon.png']//img[@class='img-fit']";
    public static String buttonAddFilesIcon = "//button[normalize-space()='Add Files']";
    public static String buttonBrowserIcon = "(//div[contains(text(),'Browse')])[2]";
    public static String inputMetaTitle = "//input[@placeholder='Meta Title']";
    public static String inputMetaDescription = "//textarea[@name='meta_description']";
    public static String dropdownFilteringAttributes = "//button[@title='Nothing selected']";
    public static String inputSearchFilteringAttributes = "//div[@class='dropdown-menu show']//input[@aria-label='Search']";
    public static String buttonSave = "//button[normalize-space()='Save']";

    //Add  New Product
    public static String headerAddNewProductPage = "//h5[normalize-space()='Add New Product']";
    public static String headerProductInformationPage = "//h5[normalize-space()='Product Information']";
    public static String inputProductName = "//label[.='Product Name *']/following-sibling::div//input";
    public static String dropdownCategory = "//button[@title='Demo category 1']";
    public static String inputSearchCategory = "//div[@id='category']//input[@type='search']";
    public static String dropdownBrand = "//label[normalize-space()='Brand']/following-sibling::div//button";
    public static String inputSearchBrand = "//label[normalize-space()='Brand']/following-sibling::div//input";
    public static String inputUnit = "//label[normalize-space()='Unit']/following-sibling::div//input";
    public static String inputWeight = "//label[.='Weight (In Kg)']/following-sibling::div//input";
    public static String inputMinimumPurchaseQty = "//label[.='Minimum Purchase Qty *']/following-sibling::div/input";
    public static String inputTags = "//label[.='Tags *']/following-sibling::div//tags";

    //Product Images
    public static String buttonBrowserGalleryImages = "//label[.='Gallery Images (600x600)']/following-sibling::div//div[normalize-space()='Choose File']";
    public static String buttonBrowserThumbnailImage = "//label[.='Thumbnail Image (300x300)']/following-sibling::div//div[normalize-space()='Choose File']";
    public static String inputSearchGalleryImages = "//input[@placeholder='Search your files']";
    public static String ImageGallery = "//div[@title='icon.jpg']//img[@class='img-fit']";
    public static String buttonAddFilesGalleryImages = "//button[normalize-space()='Add Files']";
    public static String inputSearchThumbnailImage = "//input[@placeholder='Search your files']";
    public static String ImageThumbnailI = "//div[@title='Fpt-icon.png']//img[@class='img-fit']";
    public static String buttonAddFilesThumbnailImage = "//button[normalize-space()='Add Files']";

    //Product Videos
    public static String headerProductVideo = "//h5[normalize-space()='Product Videos']";
    public static String dropdownVideoProvider = "//label[normalize-space()='Video Provider']/following-sibling::div//button";
    public static String inputVideoLink = "//label[normalize-space()='Video Link']/following-sibling::div/input";

    //Product Variation
    public static String headerProductVariation = "//h5[normalize-space()='Product Variation']";
    public static String dropdownColors = "//button[@data-id='colors']";
    public static String inputSearchColors = "//div[@class='dropdown-menu show']//input[@aria-label='Search']";

    public static String buttonActiveColor = "//div[@class='card-body']/div/div[3]/label/span";
    public static String listColors= "//div[@id='bs-select-4']/ul/li";
    public static String dropdownAttributes = "//button[@data-id='choice_attributes']";
    public static String inputSearchAttributes = "//div[@class='dropdown-menu show']//input[@aria-label='Search']";

    //Product price + stock
    public static String headerProductPriceStock = "//h5[normalize-space()='Product price + stock']";
    public static String inputUnitPrice = "//label[.='Unit price *']/following-sibling::div/input";
    public static String inputDiscountDateRange = "//label[normalize-space()='Discount Date Range']/following-sibling::div/input";
    public static String inputDiscount = "//label[normalize-space()='Discount *']/following-sibling::div/input";
    public static String listDiscountType = "//select[@name='discount_type']";
    public static String dropdownDiscount = "//label[normalize-space()='Discount *']/following-sibling::div//div/button";
    public static String inputQuantity = "//input[@name='current_stock']";
    public static String inputSKU = "//label[normalize-space()='SKU']/following-sibling::div/input";
    public static String inputExternalLink = "//label[normalize-space()='External link']/following-sibling::div/input";
    public static String inputExternalLinkButtonText = "//label[normalize-space()='External link button text']/following-sibling::div/input";

    //Product Description
    public static String headerProductDescription = "//h5[normalize-space()='Product Description']";
    public static String inputDescriptionProductDescription = "//label[normalize-space()='Description']/following-sibling::div/textarea[@class='aiz-text-editor']";

    //PDF Specification
    public static String headerPDFSpecification = "//h5[normalize-space()='PDF Specification']";
    public static String dropdownPDFSpecification = "//label[normalize-space()='PDF Specification']/following-sibling::div//div[contains(.,'Choose File')][contains(@class,'form-control file-amount')]";
    public static String inputSearchPDFSpecification = "//input[@placeholder='Search your files']";
    public static String filePDFSpecification = "//div[@title='DTest.pdf']//div[@class='card-body']";
    public static String buttonAddFilesPDFSpecification = "//button[normalize-space()='Add Files']";

    //SEO Meta Tags
    public static String headerSEOMetaTags = "//h5[normalize-space()='SEO Meta Tags']";
    public static String inputMetaTitleTags = "//label[normalize-space()='Meta Title']/following-sibling::div/input";
    public static String inputDescription = "//textarea[contains(@name,'meta_description')]";
    public static String dropdownMetaImage = "//label[normalize-space()='Meta Image']/following-sibling::div//div[@class='form-control file-amount']";

    //Low Stock Quantity Warning
    public static String headerLowStockQuantityWarning = "//h5[normalize-space()='Low Stock Quantity Warning']";
    public static String inputQuantityWarning = "//label[normalize-space()='Quantity']/following-sibling::input";

    //Flash Deal
    public static String headerFlashDeal = "//h5[normalize-space()='Flash Deal']";
    //    public static String dropdownAddToFlash= "//label[normalize-space()='Add To Flash']/following-sibling::div//button[@data-id='flash_deal']";
    public static String dropdownAddToFlash = "//button[@data-id='flash_deal']";
    public static String inputDiscountFlashDeal = "//input[@name='flash_discount']";
    public static String dropdownDiscountType = "//button[@data-id='flash_discount_type']";

    //Estimate Shipping Time
    public static String headerEstimateShippingTime = "//h5[normalize-space()='Estimate Shipping Time']";
    public static String inputShippingDays = "//label[normalize-space()='Shipping Days']/following-sibling::div/input";

    //Vat & TAX
    public static String headerVatAndTAX = "//h5[normalize-space()='Vat & TAX']";
    public static String inputTax = "//label[normalize-space()='Tax']/following-sibling::div/div/input[@name='tax[]']";
    public static String dropdownTax = "//label[normalize-space()='Tax']/following-sibling::div//div/button[@title='Flat']";

    public static String SaveAndUnpublish = "//button[normalize-space()='Save & Unpublish']";
    public static String SaveAndPublish = "//button[normalize-space()='Save & Publish']";


}
