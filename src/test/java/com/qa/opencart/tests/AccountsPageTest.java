package com.qa.opencart.tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountPageSetup() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void getAccountsPageTitle() throws InterruptedException {
		Thread.sleep(3000);
		String actualTitle = accountsPage.getAccountPageTitle();
		Assert.assertEquals(actualTitle, "My Account");
	}

	@Test
	public void isLogoutLinkExist() {
		Assert.assertTrue(accountsPage.isLogoutLinkExist());
	}

	@Test
	public void isMyAccountLinkExist() {
		Assert.assertTrue(accountsPage.isMyAccountLinkExist());
	}

	@Test
	public void accountHeadersCountTest() {
		List<String> actualAccountsHeadersList = accountsPage.getAccountsPageHeadersList();
		Assert.assertEquals(actualAccountsHeadersList.size(), 4);
	}

	@Test
	public void accountsPageHeaderTest() {
		List<String> actualAccountsHeadersList = accountsPage.getAccountsPageHeadersList();
		List<String> expectedAccountsHeaderList = Arrays.asList("My Account", "My Affiliate Account", "Newsletter",
				"My Orders");
		// In case order is not same at all the time(My Order is first and My Accounts
		// is next then you need sort the both list and compare the lists.
		// Sort both lists
		Collections.sort(actualAccountsHeadersList);
		Collections.sort(expectedAccountsHeaderList);
		// Compare the sorted lists
		boolean headersListMatch = actualAccountsHeadersList.equals(expectedAccountsHeaderList);
		if (headersListMatch) {
			System.out.println("Both Lists have same values");
		} else {
			System.out.println("Both Lists does not same values");
		}
		Assert.assertTrue(headersListMatch);

//		Assert.assertEquals(actualAccountsHeadersList, expectedAccountsHeaderList);
//		System.out.println(actualAccountsHeadersList);
//		System.out.println(expectedAccountsHeaderList);s
	}
}