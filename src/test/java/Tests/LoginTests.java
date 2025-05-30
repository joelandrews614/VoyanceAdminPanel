package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.BaseTest;

public class LoginTests extends BaseTest{
		
	@Test
	public void TC_01_ValidateLoginPage() throws InterruptedException {
		
		Assert.assertEquals(loginPage.isTitleExists(), true);	
		Assert.assertEquals(loginPage.getTitle(), "Member Login");
		Assert.assertEquals(loginPage.isPhoneNumberInputExists(), true);
		Assert.assertEquals(loginPage.isPasswordInputExists(), true);
	}
	
	@Test
	public void TC_02_LoginWithoutAnyValuesInFields() throws InterruptedException {
		
		loginPage.clickLoginButton();
		
		Thread.sleep(2000);
		
		Assert.assertEquals(loginPage.getErrorMessageTxt(), "Please enter both phone number and password.");
	}
	
	@Test
	public void TC_03_LoginWithOneFieldValueAndOtherAsEmpty() throws InterruptedException {
		
		loginPage.login("9597337509", "");
		
		Thread.sleep(2000);
		
		Assert.assertEquals(loginPage.getErrorMessageTxt(), "Please enter both phone number and password.");
	}
	
	
	@Test
	public void TC_04_SuccessfulLoginAndLogout() throws InterruptedException {
	
		loginPage.login(phoneNumber, password);
		
		Thread.sleep(2000);
	
		headersPage.clickLogoutButton();
		
		Thread.sleep(1500);
	}
	
}