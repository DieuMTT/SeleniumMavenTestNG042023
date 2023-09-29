package com.dieutester.Bai17_POM.testcases;

import com.dieutester.Bai17_POM.pages.CustomersPage;
import com.dieutester.Bai17_POM.pages.DashboardPage;
import com.dieutester.Bai17_POM.pages.LoginPage;
import com.dieutester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;

    @Test
    public void testOpenMenuOnDashboardPage() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboardPage();
        dashboardPage.openCustomerPage();

        customersPage = new CustomersPage(driver);
        customersPage.verifyCustomersPage();
    }
}
