package com.seleniumtaf.utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

public static WebDriver driver;
	
	public static WebDriver getBrowser(String browserType) {
		switch (browserType) {
		
		case "firefox":
			return	driver = new FirefoxDriver();
			
		case "chrome":
			System.setProperty("webdriver.chrome.driver", new File("chromedriver.exe").getAbsolutePath());
			return	driver = new ChromeDriver();
			
		case "ie":
			System.setProperty("webdriver.ie.driver", new File("IEDriverServer.exe").getAbsolutePath());
    		return driver = new InternetExplorerDriver();
    		
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			return driver = new FirefoxDriver();
		}
	}
}
