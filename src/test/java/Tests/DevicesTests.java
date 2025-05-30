package Tests;

import org.testng.annotations.Test;

import Utils.BaseTest;

public class DevicesTests extends BaseTest{
		
	@Test
	public void TC_01_Verify_The_Devices_Section() {
		
		loginPage.login(phoneNumber, password);
		
		devicesPage.validateFields();
		
	}
	
	@Test(enabled = false)
	public void TC_02_Verify_Add_Device_Details_Form() throws InterruptedException {
				
		devicesPage.clickAddNewButton();
		
		devicesPage.validateFormFields();
		
		Thread.sleep(2500);
		devicesPage.clickFormCloseButton();
		
	}
	
	@Test(enabled = false)
	public void TC_03_Verify_The_Paginations() throws InterruptedException {
		
        //devicesPage.changePagenationCount("5");
		
		//25 Limit Verification:
		devicesPage.changePagenationCount("25");
		devicesPage.validatePagenationCount("25");
		
		//50 Limit Verification:
		devicesPage.changePagenationCount("50");
		Thread.sleep(1000);		
		devicesPage.validatePagenationCount("50");
		
		//100 Limit Verification:
		devicesPage.changePagenationCount("100");
		Thread.sleep(1000);
		devicesPage.validatePagenationCount("100");
		
	}
	
	@Test(enabled = false)
	public void TC_04_Verify_Adding_A_New_Device() {
		
		devicesPage.isDeviceExists("TEST");
		
		String deviceId = "TEST";
		String serialNumber = "TEST";
		String deviceVersion = "TEST";
		String userVersion = "TEST";
		
		devicesPage.clickAddNewButton();
		
		devicesPage.enterAddDeviceDetails(deviceId, serialNumber, deviceVersion, userVersion);
		
//		devicesPage.clickProccedButton();
		
	}
}
