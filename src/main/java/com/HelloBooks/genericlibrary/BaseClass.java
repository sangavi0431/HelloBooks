package com.HelloBooks.genericlibrary;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

public class BaseClass {
	public static WebDriver driver;
	public FileUtility f=new FileUtility();
	public SeleniumUtilities s=new SeleniumUtilities();
	@BeforeTest
	public void launchingBrowser(@Optional("chrome") String BROWSER) throws IOException {
		if (BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver=new EdgeDriver();		
		} else {
            driver=new ChromeDriver();
		}
		
		s.maximizeBrowser(driver);
		s.implicitwait(driver);
		driver.manage().deleteAllCookies();
		
		String URL = f.readDataFromPropertyFile("url");	
		driver.get(URL);
		
		 if (!driver.getCurrentUrl().endsWith("/login")) {
		        driver.get(URL); // Re-navigate to the base URL (which should be the Login Page)
		    }
		 
		Reporter.log("browser launched",true);
	}

	@AfterTest
	public void closebrowser() {
		 s.closeBrowser(driver);
		 Reporter.log("Browser closed");
}
	
}
  








