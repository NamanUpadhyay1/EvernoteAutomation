package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class DriverManager extends Utils
{
    public static final String USERNAME = LoadProp.getProperty("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = LoadProp.getProperty("BROWSERSTACK_ACCESS_KEY");

    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    String browserName = LoadProp.getProperty("browser");

    boolean runIncloud = Boolean.parseBoolean(LoadProp.getProperty("cloud"));
    MutableCapabilities capabilities = new MutableCapabilities();

    public void openingBrowser()
    {
        //to run tests on cloud====================================================================================================================
        if(runIncloud)
        {
            System.out.println("Test Case running in the cloud.");
            //run on cloud.
            if (browserName.equalsIgnoreCase("Edge")) {
                ///connect with browserstack
                capabilities.setCapability("browserName", "Edge");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "10");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);

            } else if (browserName.equalsIgnoreCase("Firefox"))
            {
                ///connect with browserstack
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "11");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);
            } else {
                System.out.println("Your browser name is wrong or missing implementation:" + browserName);
            }
            try {
                driver = new RemoteWebDriver(new URL(URL), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        else
        {
            System.out.println("Test Case running locally.");
            //run locally.
            if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/java/Driver/chromedriver.exe");
                //setProperty is used to locate the Chrome web browser location in order to use Chrome browser later.
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("https://evernote.com/");
                waitForUrlToBe("https://evernote.com/",20);

                // used to open the Chrome browser.


            }
            else if (browserName.equalsIgnoreCase("Edge"))
            {
                System.setProperty("webdriver.edge.driver", "src/test/java/Driver/msedgedriver.exe");
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.get("https://evernote.com/");
                waitForUrlToBe("https://evernote.com/",20);

            }
            else if (browserName.equalsIgnoreCase("Firefox"))
            {
                System.setProperty("webdriver.gecko.driver", "src/test/java/Driver/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get("https://evernote.com/");
                waitForUrlToBe("https://evernote.com/",20);

            }
            else
            {
                System.out.println("Browser name is incorrect or missing." +browserName);
            }
        }




        driver.manage().window().maximize();
        driver.get("https://evernote.com/");
        waitForUrlToBe("https://evernote.com/",20);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void closingBrowser()
    {
        driver.quit();
    }
}