package com.HelloBooks.genericlibrary;

	import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
	/**
	 * @author sangavi
	 * this class is a generic class which is used to perform all the seleneium utilities.
	 */
	public class SeleniumUtilities {
		/**
		 * this method is a generic method usedto maximize  the browser.
		 * @param driver
		 */
		public void maximizeBrowser(WebDriver driver) {
			driver.manage().window().maximize();
		}
		/**
		 * this method is a generic method used for an element to be visible on the page.
		 * @param driver
		 */
		public WebElement waitforVisibility (WebDriver driver, WebElement element , int timeoutSeconds) {
			WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
			return wait.until(ExpectedConditions.visibilityOf(element));			
			
		}
		/**
		 * this method is a generic method used for implicitwait.
		 * @param driver
		 */
		public void implicitwait(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		/**
	     * Clears the field and enters the specified text.
	     */
		public void enterText(WebElement element, String data) {
			element.clear();
			element.sendKeys(data);
		}
		/**
	     * Clicks a specific WebElement.
	     */
		public void clickElement(WebElement element) {
			element.click();
		}
		/**
	     * Checks if an element is currently displayed on the page.
	     */
		public boolean isElementDisplayed(WebElement element) {
			try {
				return element.isDisplayed();
			} catch ( Exception e) {
			return false;
			}	
		}
		/**
	     * Gets the text from a WebElement.
	     */
		public String getText(WebElement element) {
			return element.getText();
		}
		/**
		 * this method is used for close the browser.
		 * @param driver
		 */
		public void closeBrowser(WebDriver driver) {
			driver.quit();
		}
		 /**
	     * Handles selection from a standard HTML dropdown menu (<select> tag) 
	     * using the visible text of the option.
	     */
	    public void selectDropdownByVisibleText(WebElement element, String visibleText) {
	        Select s = new Select(element);
	        s.selectByVisibleText(visibleText);
	}
	}


