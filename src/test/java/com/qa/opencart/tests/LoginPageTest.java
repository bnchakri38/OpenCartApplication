package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {
	
	@Test
	public void loginTest() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertTrue(accountsPage.isLogoutLinkExist());
		Assert.assertTrue(accountsPage.isMyAccountLinkExist());
		Assert.assertTrue(accountsPage.getAccountPageTitle().equals("My Account"));
		System.out.println("4");
	}
	
	@Test
	public void forgotPasswordLinkExist() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
		System.out.println("1");
	}
	
	@Test
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, "Account Login");
		System.out.println("2");
	}
	
	@Test
	public void loginPageURLTest() {
		String actualURL = loginPage.getLoginPageURL();	
		Assert.assertTrue(actualURL.contains("?route=account/login"));
		System.out.println("3");
	}
	
	// Assignment: Logo, Search field, Returning Logo & New Customer Logo
	
}
