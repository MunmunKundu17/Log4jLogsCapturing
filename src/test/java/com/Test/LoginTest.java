package com.Test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
//What is a log? Helps in capturing info/activities at the time of program execution
//Types of Logs:
    //1. info
    //2. warn
    //3. error
    //4. fatal
// How to generate logs? using Apache log4jAPI(log4j jar)
//How it works? It reads log 4j configuration from log4j properties file to generate the logs
// Where to create this file? create inside resources folder source folder
    public static final Logger LOGGER = LogManager.getLogger(LoginTest.class);
    WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        LOGGER.info("I am in Info Logging Mode");
        System.setProperty("webdriver.chrome.driver","C://Users//HP//IdeaProjects//GenerateLogsUsingLog4j//Driver//chromedriver.exe");
        driver = new ChromeDriver();
        LOGGER.debug("ChromeDriver setup is completed");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        LOGGER.debug("Chrome browser is launched");
        driver.get("https://freecrm.com/");
    }
    @Test(priority=1)
    public void freeCRMTitleTest()
    {
        LOGGER.info("Test is started");
        String Title = driver.getTitle();
        System.out.println(Title);
        Assert.assertEquals(Title,"#1 Free CRM Software Power Up your Entire Business Free Forever");
        LOGGER.info("Test 1 is completed");
    }
    @Test(priority=2)
    public void freeCRMLogoTest()
    {   LOGGER.info("Test 2 is started");
        boolean b = driver.findElement(By.xpath("//div[@class='rd-navbar-brand']//span[text()='Free CRM Software']")).isDisplayed();
        Assert.assertTrue(b);
        LOGGER.info("Test 2 is completed");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
        LOGGER.debug("Browser Instance is closed");
    }

}
