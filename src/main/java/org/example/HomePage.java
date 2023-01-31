package org.example;
import org.openqa.selenium.By;

public class HomePage extends Utils
{
    public void clickOnRegisterButton()

    {
            waitForUrlToBe("https://evernote.com/", 2000);
            waitForElementToBeVisible(By.xpath("/html/body/div[2]/div/div/div[1]/p[1]/a"),20);
            clickOnElement(By.xpath("//a[@href=\"/compare-plans\"][@class=\"button-primary\"]"));
            //register button
            waitForElementToBeVisible(By.xpath("//*[@id=\"pricing-table-mini\"]/div[3]/div/div[1]/div[7]/a"),10);

            clickOnElement(By.xpath("//a[@class='button-primary accept-cookies']"));

            clickOnElement(By.xpath("//*[@id=\"pricing-table-mini\"]/div[3]/div/div[1]/div[7]/a"));
            //plan selection

    }
    public void clickOnLogInButton()

    {
            waitForUrlToBe("https://evernote.com/", 2000);
            clickOnElement(By.linkText("Already have an account? Log in"));
    }


}