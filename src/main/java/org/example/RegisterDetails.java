package org.example;

import org.openqa.selenium.By;

public class RegisterDetails extends Utils
{
    public void credentialsForRegistration()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        typeText(By.xpath("//input[@type=\"text\"]"),"upadhyay.naman29"+getTimeStamp()+"@gmail.com");
        //getTimeStamp method recalled to get a unique mail id every test.

        waitForElementToBeVisible(By.id("passwordInput"),15);
        typeText(By.id("passwordInput"),"password123");
        clickOnElement(By.id("register"));
    }
}
