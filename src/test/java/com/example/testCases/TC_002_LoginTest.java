package com.example.testCases;

import com.example.pageObjects.HomePage;
import com.example.pageObjects.LoginPage;
import com.example.pageObjects.MyAccount;
import com.example.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_002_LoginTest extends TestBase {




    @Test
    public void test_login_page(){
        try {

            logger.info("*******Starting TC_002_LoginTest******");
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            logger.info("click myAccount");
            homePage.clickLogin();
            logger.info("clicked on login");


            LoginPage loginPage = new LoginPage(driver);
            loginPage.setUserName(resourceBundle.getString("email"));
            logger.info("given user email");
            loginPage.setPassword(resourceBundle.getString("password"));
            logger.info("given user password");
            loginPage.clickSubmit();
            logger.info("clicked on submit button");

            MyAccount myAccount = new MyAccount(driver);
            boolean targetPage = myAccount.isMyAccountPageExists();
            Assert.assertEquals(targetPage, true, "Invalid login data");
        }catch (Exception e){
            Assert.fail();
        }
        logger.info("****Finished TC_002_LoginTest******");



    }



}
