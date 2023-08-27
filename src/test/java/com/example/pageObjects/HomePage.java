package com.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccount;
    @FindBy(css = "div[class='nav float-end'] li[class='list-inline-item'] li:nth-child(2) a:nth-child(1)")
    WebElement login;

    public void clickMyAccount(){
        myAccount.click();
    }

    public void clickLogin(){
        login.click();
    }

}
