package com.example.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.example.testBase.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager  implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    String reportName;

    public void onStart(ITestContext testContext){

            try {
                String timeStamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
                reportName = "Test-Report-" + timeStamp + ".html";
                File file = new File(System.getProperty("user.dir") + "/reports/" + reportName);

                sparkReporter = new ExtentSparkReporter(file);
                sparkReporter.config().setDocumentTitle("Opencart Automation Report");
                sparkReporter.config().setReportName("Opencart Functional Testing");
                sparkReporter.config().setTheme(Theme.DARK);

                extentReports = new ExtentReports();
                extentReports.attachReporter(sparkReporter);
                extentReports.setSystemInfo("Application" , "opencart");
                extentReports.setSystemInfo("Module", "Admin");
                extentReports.setSystemInfo("Sub Module", "Customer");
                extentReports.setSystemInfo("Operating system", System.getProperty("os.name"));
                extentReports.setSystemInfo("User Name", "user.name");


            } catch (Exception e) {

                e.printStackTrace();
            }



    }


    public void onTestSuccess(ITestResult result){
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.PASS, "Test Passed");
    }


    public void onTestFailure(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.FAIL, "Test Failed");
        extentTest.log(Status.FAIL, result.getThrowable().getMessage());

        String imgPath = new TestBase().captureScreenShot(result.getName());
        extentTest.addScreenCaptureFromPath(imgPath);
    }

    public void onFinish(ITestContext context){
        extentReports.flush();
    }


}
