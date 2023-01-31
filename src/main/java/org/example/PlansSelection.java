package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;

public class PlansSelection extends Utils {
    public void selectingPlanForTheNewAccount() {


        waitForElementToBeVisible(By.id("qa-GENERIC_LIGHTBOX_CLOSE"), 100);
        clickOnElement(By.id("qa-GENERIC_LIGHTBOX_CLOSE"));


        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver.findElement(By.xpath("//button[@id=\"qa-GET_STARTED\"]")).isDisplayed()) {
            clickOnElement(By.id("qa-GET_STARTED"));

            waitForElementToBeVisible(By.xpath("/html/body/div[5]/div/div/div/div[2]/div[3]"), 20);
            clickOnElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div[3]"));

            waitForElementToBeVisible(By.xpath("//button[@aria-label=\"Next\"]"), 20);
            clickOnElement(By.xpath("//button[@aria-label=\"Next\"]"));

            waitForElementToBeVisible(By.xpath("//button[@aria-label=\"Next\"]"), 20);
            clickOnElement(By.xpath("//button[@aria-label=\"Next\"]"));

            waitForElementToBeVisible(By.xpath("//div[@class=\"_KrDTpqBqetn7PvcCCMP\"]//div[3]"), 20);
            clickOnElement(By.xpath("//div[@class=\"_KrDTpqBqetn7PvcCCMP\"]//div[1]"));
            clickOnElement(By.xpath("//div[@class=\"_KrDTpqBqetn7PvcCCMP\"]//div[2]"));

            clickOnElement(By.xpath("//button[@aria-label=\"Next\"]"));

            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        else
            {
                waitForElementToBeVisible(By.xpath("/html/body/div[5]/div/div/div/div[2]/div[3]"), 20);
                clickOnElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div[3]"));

                waitForElementToBeVisible(By.xpath("//button[@aria-label=\"Next\"]"), 20);
                clickOnElement(By.xpath("//button[@aria-label=\"Next\"]"));

                waitForElementToBeVisible(By.xpath("//button[@aria-label=\"Next\"]"), 20);
                clickOnElement(By.xpath("//button[@aria-label=\"Next\"]"));

                waitForElementToBeVisible(By.xpath("//div[@class=\"_KrDTpqBqetn7PvcCCMP\"]//div[3]"), 20);
                clickOnElement(By.xpath("//div[@class=\"_KrDTpqBqetn7PvcCCMP\"]//div[1]"));
                clickOnElement(By.xpath("//div[@class=\"_KrDTpqBqetn7PvcCCMP\"]//div[2]"));

                clickOnElement(By.xpath("//button[@aria-label=\"Next\"]"));

                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        clickOnElement(By.xpath("//button[@aria-label=\"Continue with free plan\"]"));
        waitForElementToBeVisible(By.id("qa-NAV_HOME"), 20);
        Assert.assertTrue(driver.getCurrentUrl().contains("eb?login=true&newReg"), "Register failed or redirected to incorrect page.");
    }
    }
