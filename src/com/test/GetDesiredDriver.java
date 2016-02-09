package com.test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GetDesiredDriver {

	public Object getRemoteDriver(String strBrowserType) throws Exception{
		
		RemoteWebDriver driver = null;
		DesiredCapabilities ds = null;
		
		switch (strBrowserType.toLowerCase()) {
		case "firefox":
			ds = DesiredCapabilities.firefox();
			break;
			
		case "chrome":
			ds = DesiredCapabilities.chrome();
			break;
			
		case "internet explorer":
			ds = DesiredCapabilities.firefox();
			break;
		
//		case "remote execution":
//			break;

		default:
			ds = DesiredCapabilities.firefox();
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), ds);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;

	}
	
	public Object getLocalDriver(String strBrowserType) throws Exception{
		
		WebDriver driver = null;
		
		switch (strBrowserType.toLowerCase()) {
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "E:/isha_selenium/chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "internet explorer":
			System.setProperty("webdriver.ie.driver", "E:/isha_selenium/IEdriver.exe");
			driver = new InternetExplorerDriver();
			break;
			
		case "remote execution":
			break;

		default:
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;

	}
}
