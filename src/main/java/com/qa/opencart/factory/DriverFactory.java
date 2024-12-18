package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opencart.frameworkexception.FrameworkException;

public class DriverFactory {
	
	WebDriver driver;
	
	public WebDriver initDriver(Properties prop) {
		
		String browserName = prop.getProperty("browser").trim();
		
		System.out.println("Browser name is: "+ browserName);
		
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "safari":
			driver = new SafariDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Please pass the right browser: "+ browserName);
			throw new FrameworkException("NO-BROWSER-FOUND-EXCEPTION");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}
	
	public Properties initProp() {
		Properties prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/main/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
