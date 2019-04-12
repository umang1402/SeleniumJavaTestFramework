package com.seleniumtaf.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.seleniumtaf.utils.Browser;
 
public class BaseTest {
    public WebDriver driver;
    
    public WebDriver getDriver() {
        return driver;
    }
    
    @Parameters("browser")
    // Passing Browser parameter from TestNG xml---
    @BeforeClass
    public void setup (String browser) {    
    	driver = Browser.getBrowser(browser.toLowerCase());	  
		driver.manage().window().maximize();
    }
 
    //Destroying the browser instance once test is completed---
    @AfterClass
    public void teardown () {
        driver.quit();
    }
    
}
