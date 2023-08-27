package com.example.testBase;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

public class TestBase {
    public static WebDriver driver;
    public Logger logger;
    public ResourceBundle resourceBundle;


    @BeforeClass
    @Parameters("browser")
    public void setUp(String br)  {;


        logger = LogManager.getLogger(this);
        resourceBundle = ResourceBundle.getBundle("config");

        if(br.equals("chrome")) {
           driver = new ChromeDriver();
        }else if(br.equals("edge")){
            driver = new EdgeDriver();
        }else {
            driver = new SafariDriver();
        }


        driver.manage().window().maximize();
        driver.get(resourceBundle.getString("appUrl"));
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


    

    public String  captureScreenShot(String tname){

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/screenshots/" + tname +"_"+ timeStamp + ".png";
        try {
            FileUtils.copyFile(source, new File(destination));
        }catch (Exception e){
             e.getMessage();
        }
        return destination;
    }

}
