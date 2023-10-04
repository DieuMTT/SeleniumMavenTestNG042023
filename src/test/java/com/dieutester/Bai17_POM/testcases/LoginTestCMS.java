package com.dieutester.Bai17_POM.testcases;

import com.dieutester.Bai17_POM.pages.LoginPageCMS;
import com.dieutester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTestCMS extends BaseTest {
    LoginPageCMS loginPageCMS;

    @Test
    public void testLoginCMS() {
        loginPageCMS = new LoginPageCMS(driver);
        loginPageCMS.loginCMS("admin@example.com", "123456");

    }
}
