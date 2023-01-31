package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class Utils extends BasePage
{


    //for screenshot after assert fail.
    public static void captureScreenShot(String screenShotName)
    {
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        //Call captureScreenShot method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //File is an import class of commons.io used for screenshots ability.

        File DestFile=new File("src/test/java/ScreenShots"+screenShotName+getTimeStamp()+".jpg");
        //all the screenshots will be saved at this location with the name of the testcase with unique id as current time.

        //Surrounded the captureScreenShot method with try and catch for exception handling.
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void clickOnElement(By by)
    //created a clickOnElement() action Method to reuse it for multiple occasions : 'By' is locator key and 'by' is the locator itself.
    {
        driver.findElement(by).click();
        //to perform select action on the locator.
    }
    public static void typeText(By by,String Data)
    // created a typeText() method to reuse the input data function with the usage of variable String Data.
    {
        driver.findElement(by).sendKeys(Data);
        //sendKeys(Data) will input the data inserted in the string 'Data'.
    }
    public static String getText(By by)
    // This getText() method will return string value of the locator. 'By' is locator key and 'by' is the locator itself.
    {
        return driver.findElement(by).getText();
        // this will return the data in the locator
    }

    public static String getTimeStamp()
    // getTimeStamp() method created to use unique calendar for unique value purpose {used in register email for unique email}.
    {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        //SimpleDateFormat will give the current date and time while execution in the given pattern.
    }

    public static void waitForElementToBeClickable(By by,int clickableSeconds)
    // waitForElementToBeClickable() will wait until "clickableSeconds" period will end and then click the locator.
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(clickableSeconds));
        // This is an Explicitly wait function.
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToBeVisible(By by,int visibleSeconds)
    //waitForElementToBeVisible() will wait until "visibleSeconds" period will end and then click the locator.
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(visibleSeconds));
        // This is an Explicitly wait function.
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public static void waitForUrlToBe(String url, int urlSecond)
    //waitForUrlToBe() will wait until "urlSeconds" period ends. here the url will be stored as 'String'.
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(urlSecond));
        // This is an Explicitly wait function.
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static void selectFromDropDownByVisibleTText(By by, String vText)
    // created this method selectFromDropDownByVisibleTText() inorder to select value by visible Text.
    {
        Select select = new Select(driver.findElement(by));
        //Select is a selenium import class through which we can use the drop-down select feature with the help from 'By' key of locator.
        select.selectByVisibleText(vText);
        //.selectByValue will select the drop-down item by 'vText'.
    }

    public static void selectFromDropDownByValue(By by,String dropValue)
    // created this method selectFromDropDownByValue() inorder to select value by Value.
    {
        Select select = new Select(driver.findElement(by));
        //Select is a selenium import class through which we can use the drop-down select feature with the help from 'By' key of locator.
        select.deselectByValue(dropValue);
        //.selectByValue will select the drop-down item by 'dropValue'.
    }

    public static void selectFromDropDownByIndex(By by, int indexnum)
    // created this method selectFromDropDownByIndex() inorder to select value by the index number.
    {
        Select select = new Select(driver.findElement(by));
        //Select is a selenium import class through which we can use the drop-down select feature with the help from 'By' key of locator.
        select.selectByIndex(indexnum);
        //.selectByValue will select the drop-down item by 'indexnum'.
    }
    public static void radioButtonSelect(By by)
    // a method to reuse the radio button feature. 'By' is locator key and 'by' is the locator itself.
    {
        WebElement radioButton =(driver.findElement(by));
        //WebElement is one of our import class which we used for radiobutton feature on our locator.
        radioButton.click();
        //to perform select action on the radio button(locator).
    }
    public static void assertURL(String categoryName)
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(categoryName));
        waitForUrlToBe(driver.getCurrentUrl(),30);
    }
}
