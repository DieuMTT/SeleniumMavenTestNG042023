package com.dieutester.Bai17_POM.testcases;

import com.dieutester.Bai17_POM.pages.AddNewCategoryPage;
import com.dieutester.Bai17_POM.pages.LoginPageCMS;
import com.dieutester.common.BaseTest;
import org.testng.annotations.Test;

public class AddNewCategoryTest extends BaseTest {
    AddNewCategoryPage addNewCategoryPage;
    LoginPageCMS loginPageCMS;
    @Test
    public void testAddNewCategory(){
     loginPageCMS = new LoginPageCMS(driver);
     loginPageCMS.loginCMS("admin@example.com", "123456");
     addNewCategoryPage = new AddNewCategoryPage(driver);
     addNewCategoryPage.AddNewCategory("123");

    }
}
