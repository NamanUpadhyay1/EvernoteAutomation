package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginDetails extends Utils
{
    public void emailAddress()
    {
        waitForUrlToBe("https://www.evernote.com/Login.action",10);
        typeText(By.id("username"),"upadhyay.naman29@gmail.com");
        clickOnElement(By.id("loginButton"));
        waitForElementToBeVisible(By.id("password"),20);
        typeText(By.id("password"),"password123");
        clickOnElement(By.id("loginButton"));
    }
    public void assertingUrl()
    {
        waitForElementToBeVisible(By.id("qa-NAV_HOME"),30);
        Assert.assertTrue(driver.getCurrentUrl().contains("&login=Sign+in&login=true&"),"log in failed or redirected to the wrong url");
    }
}