package com.seleniumtaf.test;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.seleniumtaf.utils.Constants;
import com.seleniumtaf.utils.Reporter.ExtentTestManager;
import com.seleniumtaf.pageobject.ComputerDetailsPage;
import com.seleniumtaf.pageobject.HomePage;


public class RegressionTest extends BaseTest {
	
	@Test (priority = 0, description = "Search filter results in item searched for")
	public void validateSearchFilter(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search filter results in item searched for");
		HomePage homePage = new HomePage(driver);
		homePage.navigateToHome();
		homePage.searchComputer(Constants.SEARCH_COMPUTER);
		homePage.verifySearchedResult(Constants.SEARCH_COMPUTER);
	}
	
	@Test (priority = 1, description = "Add a new computer in to the database")
	public void validateComputerIsAdded(Method method){
		ExtentTestManager.startTest(method.getName(), "Add a new computer in to the database");
		HomePage homePage = new HomePage(driver);
		homePage.searchComputer(Constants.SEARCH_COMPUTER);
		ComputerDetailsPage computerPage = homePage.navigateToAddComputerPage();
		computerPage.addNewComputer(Constants.COMPUTER_NAME,
								Constants.COMPUTER_INTRODATE,
								Constants.COMPUTER_ENDDATE,
								Constants.SELECT_COMPANY);
		homePage.searchComputer(Constants.COMPUTER_NAME);
		homePage.verifySearchedResult(Constants.COMPUTER_NAME);
	}
	
	@Test (priority = 3, description = "Edit an already existing computer in the database or Create one before")
	public void validateComputerIsEdited(Method method) {
		ExtentTestManager.startTest(method.getName(), "Edit an already existing computer in the database or Create one before");
		HomePage homePage = new HomePage(driver);
		homePage.searchComputer(Constants.COMPUTER_NAME);
		try { homePage.verifySearchedResult(Constants.COMPUTER_NAME);}
		
		catch (Exception e) {
			ComputerDetailsPage computerPage = homePage.navigateToAddComputerPage();
			computerPage.addNewComputer(Constants.COMPUTER_NAME,
										Constants.COMPUTER_INTRODATE,
										Constants.COMPUTER_ENDDATE,
										Constants.SELECT_COMPANY);
			homePage.searchComputer(Constants.COMPUTER_NAME);}
		
		ComputerDetailsPage computerPagehomePage = homePage.navigateToSearchedComputer();
		computerPagehomePage.editCreatedComputer(Constants.COMPUTER_EDITED_NAME);
		homePage.searchComputer(Constants.COMPUTER_EDITED_NAME);
		homePage.verifySearchedResult(Constants.COMPUTER_EDITED_NAME);
	}
	
	@Test (priority = 2, description = "Delete already added computer system from warehouse and validate")
	public void validateComputerIsDeleted(Method method) {
		ExtentTestManager.startTest(method.getName(), "Delete already added computer system from warehouse and validate");
		HomePage homePage = new HomePage(driver);
		homePage.searchComputer(Constants.COMPUTER_NAME);
		ComputerDetailsPage computerPage = homePage.navigateToSearchedComputer();
		computerPage.deleteComputer();
		homePage.verifySearchedResultDoesNotMatch(Constants.COMPUTER_NAME);
	}

}
