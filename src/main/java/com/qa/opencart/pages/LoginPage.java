package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver; // Encapsulation
	private ElementUtil elementUtil;

	// 1. Constructor of the class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// 2. create private By Locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPasswordLink = By.linkText("Forgotten Password");
	private By footerLinks = By.xpath("//footer//a");

	// 3. create public Page Actions/Methods -> behavior of that page or component
	public String getLoginPageTitle() {
		String title = elementUtil.waitForFullTitleAndCapture("Account Login", 5);
		System.out.println("Login Page title is: " + title);
		return title;
	}

	public String getLoginPageURL() {
		String url = elementUtil.waitForURLContainsAndCapture("route=account/login", 5);
		System.out.println("Login Page URL is: " + url);
		return url;
	}

	public boolean isForgotPasswordLinkExist() {
		return elementUtil.checkElementIsDisplayed(forgotPasswordLink);
	}

	public List<String> getFooterLinksList() {
		List<WebElement> footerLinksList = elementUtil.waitForElementsVisible(footerLinks, 10);
		List<String> footerLinkstext = new ArrayList<String>();
		for(WebElement e : footerLinksList) {
			String text = e.getText();
			footerLinkstext.add(text);
		}
		return footerLinkstext;
	}

	public AccountsPage doLogin(String userName, String pwd) {
		elementUtil.waitForElementVisible(emailId, 10).sendKeys(userName);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		
		// return the next landing page --> AccountsPage -> Page Changing model
		return new AccountsPage(driver);
	}

}
