package com.seleniumtaf.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.seleniumtaf.utils.Constants;
	
	public class HomePage extends BasePage {
		
		//******Constructor*******
		public HomePage(WebDriver driver) {
			super(driver);
		}

		//******Web-Elements**********
		By checkboxFilter = By.id("searchbox");
		By buttonFilter = By.id("searchsubmit");
		By buttonAddNewComputer = By.id("add");
		By getSearchedElement = By.xpath("//tbody/tr[1]/td[1]/a");
		
		
		
		//******Page-Methods***********
		public HomePage navigateToHome() {
			driver.get(Constants.URL);
			return this;
		}
		
		public HomePage searchComputer(String computerName) {
			click(checkboxFilter);
			clear(checkboxFilter);
			writeText(checkboxFilter, computerName);
			click(buttonFilter);
			return this;
		}
		
		public HomePage verifySearchedResult(String computerName) {
			assertEquals(getSearchedElement, computerName);
			return this;
		}
		
		public HomePage verifySearchedResultDoesNotMatch(String computerName) {
			assertNotEquals(getSearchedElement, computerName);
			return this;
		}
		
		public ComputerDetailsPage navigateToAddComputerPage() {
			click(buttonAddNewComputer);
			return new ComputerDetailsPage(driver);
		}
		
		 public ComputerDetailsPage navigateToSearchedComputer() {
			 click(getSearchedElement);
			 return new ComputerDetailsPage(driver);
		 }

}
