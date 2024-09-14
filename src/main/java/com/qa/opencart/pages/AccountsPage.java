package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver; // Encapsulation
	private ElementUtil elementUtil;

	// 1. Constructor of the class
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// 2. create private By Locators
	private By logout = By.linkText("Logout");
	private By myAccount = By.linkText("My Account");
	private By pageHeaders = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	
	// 3. page Actions
	public String getAccountPageTitle() {
		return elementUtil.waitForTitleIsAndCapture("My Account", 5);
	}
	
	public boolean isLogoutLinkExist() {
		return elementUtil.checkElementIsDisplayed(logout);
	}
	
	public boolean isMyAccountLinkExist() {
		return elementUtil.checkElementIsDisplayed(myAccount);
	}
	
	public List<String> getAccountsPageHeadersList() {
		List<WebElement> headersList = elementUtil.waitForElementsVisible(pageHeaders, 5);
		List<String> headersValueList = new ArrayList<String>();
		for(WebElement e : headersList) {
			String text = e.getText();
			headersValueList.add(text);
		}
		return headersValueList;
	}
	
	public ResultsPage doSearch(String searchTerm) {
		elementUtil.waitForElementVisible(search, 10).sendKeys(searchTerm);
		elementUtil.doClick(searchIcon);
		return new ResultsPage(driver);
	}
	
	
}
