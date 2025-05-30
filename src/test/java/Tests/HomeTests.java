package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Utils.BaseTest;

public class HomeTests extends BaseTest{
	
	@Test
	public void validateSideNavbars() throws InterruptedException {
	
		dri.get(EnvironmentBaseURL);
		
		loginPage.login(phoneNumber, password);
		
		Thread.sleep(2000);
		
		homePage.validateSideNavBars();
		
	}
	
	@AfterMethod
	public void logOut() {
		
		homePage.logOutBtn.click();
		
		Assert.assertEquals(dri.getCurrentUrl(), "http://dev.admin.voyanceecg.com/");
		
	}
	
}
