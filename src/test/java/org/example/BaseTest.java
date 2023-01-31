package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils
{
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");
    DriverManager driverManager = new DriverManager();

    @BeforeMethod
    public void opening()
    {
        extent.attachReporter(spark);
        driverManager.openingBrowser();
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("MyReport");
        extent.attachReporter(spark);
    }

    @AfterMethod
    public void closing(ITestResult result)
    {
        extent.flush();
        if (!result.isSuccess())
        {
            captureScreenShot(result.getName());
        }
        driverManager.closingBrowser();
    }
}