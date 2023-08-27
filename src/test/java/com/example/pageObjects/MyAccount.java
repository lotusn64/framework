package com.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{
    public MyAccount(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "body main h2:nth-child(1)")
    WebElement msgHeading;

    public boolean isMyAccountPageExists(){
        try {
            return (msgHeading.isDisplayed());
        }catch (Exception e){
            return false;
        }
    }


}
