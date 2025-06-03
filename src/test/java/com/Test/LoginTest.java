package com.Test;

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

    WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","/Users/HP/IdeaProjects/GenerateLogsUsingLog4j");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://freecrm.com/");
    }
    @Test(priority=1)
    public void freeCRMTitleTest()
    {
        String Title = driver.getTitle();
        System.out.println(Title);
        Assert.assertEquals(Title,"#1 Free CRM Software Power Up your Entire Business Free Forever");
    }
    @Test(priority=2)
    public void freeCRMLogoTest()
    {
        boolean b = driver.findElement(By.xpath("//div[@class='rd-navbar-brand']//span[text()='Free CRM Software']")).isDisplayed();
        Assert.assertTrue(b);
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
