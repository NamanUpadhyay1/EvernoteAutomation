package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Dashboard extends Utils
{
    public void clickOnNewTask()

    {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitForElementToBeVisible(By.id("qa-NAV_TASKS"),1000);
        clickOnElement(By.id("qa-NAV_TASKS"));
        waitForElementToBeVisible(By.id("qa-TASK_DUCHY_CREATE_TASK"),1000);
        clickOnElement(By.id("qa-TASK_DUCHY_CREATE_TASK"));
        waitForElementToBeVisible(By.id("qa-TASKS_MODAL_TITLE"),1000);
        typeText(By.id("qa-TASKS_MODAL_TITLE"),"asdf");
        waitForElementToBeVisible(By.id("qa-TASKS_MODAL_SUBMIT"),1000);
        clickOnElement(By.id("qa-TASKS_MODAL_SUBMIT"));

        Assert.assertTrue(driver.getCurrentUrl().contains("D#?hm=true&"),"new task addition test failed.");
    }

    public void createANewNote()
    {
        waitForElementToBeVisible(By.id("qa-HOME_NOTE_WIDGET_CREATE_NOTE"),200);
        clickOnElement(By.id("qa-HOME_NOTE_WIDGET_CREATE_NOTE"));
        waitForElementToBeVisible(By.id("qa-INSERT_LABEL"),200);
        clickOnElement(By.id("qa-INSERT_LABEL"));
        waitForElementToBeVisible(By.xpath("//div[@data-tooltipmark=\"formattertable\"]"),200);
        clickOnElement(By.xpath("//div[@data-tooltipmark=\"formattertable\"]"));


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Actions builder = new Actions(driver);
        builder.moveByOffset(1041,201)
                .contextClick()
                .doubleClick()
                .build()
                .perform();


    }
    public void addingDummyData() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement frame1 = driver.findElement(By.id("qa-COMMON_EDITOR_IFRAME"));
        driver.switchTo().frame(frame1);
        typeText(By.xpath("//*[@id=\"en-note\"]/en-table/div[1]/table/tbody/tr[1]/td[1]/div"), "ID");

        clickOnElement(By.xpath("//en-table[@data-react-node-view-dom=\"true\"]//div//table//tbody//tr[1]//td[2]"));
        typeText(By.xpath("//en-table[@data-react-node-view-dom=\"true\"]//div//table//tbody//tr[1]//td[2]"), "F_Name");

        clickOnElement(By.xpath("//*[@id=\"en-note\"]/en-table/div[1]/table/tbody/tr[1]/td[3]/div"));
        typeText(By.xpath("//*[@id=\"en-note\"]/en-table/div[1]/table/tbody/tr[1]/td[3]/div"), "L_Name");

        clickOnElement(By.xpath("//*[@id=\"en-note\"]/en-table/div[1]/table/tbody/tr[1]/td[4]/div"));
        typeText(By.xpath("//*[@id=\"en-note\"]/en-table/div[1]/table/tbody/tr[1]/td[4]/div"), "Age");

        clickOnElement(By.xpath("//*[@id=\"en-note\"]/en-table/div[1]/table/tbody/tr[2]/td[1]/div"));
        typeText(By.xpath("//*[@id=\"en-note\"]/en-table/div[1]/table/tbody/tr[2]/td[1]/div"), "1");

        clickOnElement(By.xpath("//*[@id=\"en-note\"]/en-table/div[1]/table/tbody/tr[2]/td[2]/div"));
        typeText(By.xpath("//*[@id=\"en-note\"]/en-table/div[1]/table/tbody/tr[2]/td[2]/div"), "naman");

        clickOnElement(By.xpath("//*[@id=\"en-note\"]/en-table/div[1]/table/tbody/tr[2]/td[3]/div"));
        typeText(By.xpath("//*[@id=\"en-note\"]/en-table/div[1]/table/tbody/tr[2]/td[3]/div"), "upadhyay");

        clickOnElement(By.xpath("//*[@id=\"en-note\"]/en-table/div[1]/table/tbody/tr[2]/td[4]/div"));
        typeText(By.xpath("//*[@id=\"en-note\"]/en-table/div[1]/table/tbody/tr[2]/td[4]/div"), "20");

        driver.switchTo().defaultContent();

        clickOnElement(By.id("qa-INSERT_LABEL"));
        clickOnElement(By.id("photo"));

        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        StringSelection str = new StringSelection("C:\\Users\\troll\\OneDrive\\Desktop\\SElogooo.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        waitForElementToBeVisible(By.id("qa-NAV_HOME"),30);
        Assert.assertTrue(driver.getCurrentUrl().contains("false&login=&login=Sign+in&login=true"),"Table and image test failed.");
    }
}