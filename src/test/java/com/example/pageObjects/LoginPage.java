package com.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "input[name='email']")
    WebElement userName;

    @FindBy(css = "input[name='password']" )
    WebElement password;

    @FindBy(css = "button[type='submit']")
    WebElement submit;






    public void setUserName(String userEmail){
        userName.sendKeys(userEmail);
    }


    public void setPassword(String userPassword){
        password.sendKeys(userPassword);
    }

    public void clickSubmit(){
        submit.click();
    }






}


