package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;

@Epic("Validate the functionalities of Login Page")
public class LoginTests extends BaseTest{
		
	@Story("Validate the Design and WebElements of the Login Page")
	@Test
	public void TC_01_ValidateLoginPage() throws InterruptedException {
		
		Assert.assertEquals(loginPage.isTitleExists(), true);	
		Assert.assertEquals(loginPage.getTitle(), "Member Login");
		Assert.assertEquals(loginPage.isPhoneNumberInputExists(), true);
		Assert.assertEquals(loginPage.isPasswordInputExists(), true);
	}
	
	@Story("Validate Login without any values been filled in the fields")
	@Test
	public void TC_02_LoginWithoutAnyValuesInFields() throws InterruptedException {
		
		loginPage.clickLoginButton();
		
		Thread.sleep(2000);
		
		Assert.assertEquals(loginPage.getErrorMessageTxt(), "Please enter both phone number and password.");
	}
	
	@Story("Validate Login without one field empty and other having value")
	@Test
	public void TC_03_LoginWithOneFieldValueAndOtherAsEmpty() throws InterruptedException {
		
		loginPage.login("9597337509", "");
		
		Thread.sleep(2000);
		
		Assert.assertEquals(loginPage.getErrorMessageTxt(), "Please enter both phone number and password.");
	}
	
	
	@Story("Validate the Successfull Login and Logout")
	@Test
	public void TC_04_SuccessfulLoginAndLogout() throws InterruptedException {
	
		loginPage.login(phoneNumber, password);
		
		Thread.sleep(2000);
	
		headersPage.clickLogoutButton();
		
		Thread.sleep(1500);
	}
	
}