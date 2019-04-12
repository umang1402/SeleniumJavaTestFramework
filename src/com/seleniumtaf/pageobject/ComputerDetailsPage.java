package com.seleniumtaf.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	
	public class ComputerDetailsPage extends BasePage {
		
		//******Constructor*******
		public ComputerDetailsPage(WebDriver driver) {
			super(driver);
		}

		//******Web-Elements**********
		By textboxComputerName = By.id("name");
		By textboxIntroDate = By.id("introduced");
		By textboxDiscontinueDate = By.id("discontinued");
		By dropdownCompany = By.id("company");
		By buttonSaveAndCreate = By.xpath("//div[@class = 'actions']/input");
		By buttonCancel = By.xpath("//div[@class = 'actions']/a");
		By buttonDelete = By.xpath("//input[@value = \"Delete this computer\" ]");
				
				
			
		//******Page-Methods***********
		
		public ComputerDetailsPage addNewComputer(String name, String introDate, String endDate, String value) {
			writeText(textboxComputerName, name);
			writeText(textboxIntroDate, introDate);
			writeText(textboxDiscontinueDate, endDate);
			click(dropdownCompany);
			selectByValue(dropdownCompany).selectByValue(value);;
			click(buttonSaveAndCreate);
			return this;
		}
		
		public ComputerDetailsPage editCreatedComputer(String name) {
			clear(textboxComputerName);
			writeText(textboxComputerName, name);
			click(buttonSaveAndCreate);
			return this;
		}
		
		 public ComputerDetailsPage deleteComputer() {
			 click(buttonDelete);
			 return this;
		}
}
