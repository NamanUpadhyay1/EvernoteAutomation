package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.jetbrains.annotations.NotNull;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import static org.testng.ITestResult.*;

public class TestSuit extends BaseTest
{
    HomePage homePage = new HomePage();
    RegisterDetails registerDetails = new RegisterDetails();
    PlansSelection plansSelection = new PlansSelection();
    LoginDetails loginDetails = new LoginDetails();
    Dashboard dashboard = new Dashboard();



    @Test
    public void registeringAnAccount()
    {
        ExtentTest test1 = extent.createTest("Registering an account test");
        homePage.clickOnRegisterButton();
        registerDetails.credentialsForRegistration();
        plansSelection.selectingPlanForTheNewAccount();

    }

    @Test
    public void loggingInAnAccount()
    {
        ExtentTest test2 = extent.createTest("Logging in an account test");
        homePage.clickOnLogInButton();
        loginDetails.emailAddress();
        loginDetails.assertingUrl();
    }

    @Test
    public void creatingANewTask()
    {
        ExtentTest test3 = extent.createTest("Creating a new task test");
        homePage.clickOnLogInButton();
        loginDetails.emailAddress();
        dashboard.clickOnNewTask();
    }

    @Test
    public void addingTableAndImageInANote()
    {
        ExtentTest test4 = extent.createTest("Adding a table and an image test");
        homePage.clickOnLogInButton();
        loginDetails.emailAddress();
        dashboard.createANewNote();
        dashboard.addingDummyData();
    }
}
//C:/Users/troll/IdeaProjects/EvernoteAutomation/src/test/java/org/example/