package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DevicesPage {

	private static WebDriver dri = null;
	
	public DevicesPage(WebDriver dri) {
		this.dri = dri;
		PageFactory.initElements(dri, this);
	}
	
	//	TotalDevices, ActiveDevices and InactiveDevices:
	@FindBy(xpath = "(//article[@class='Stat'])[1]")
	WebElement totalDevices_lbl;
	
	@FindBy(xpath = "(//article[@class='Stat'])[2]")
	WebElement activeDevices_lbl;
	
	@FindBy(xpath = "(//article[@class='Stat'])[3]")
	WebElement inactiveDevices_lbl;
	
	@FindBy(className =  "AddNewButton")
	WebElement addNew_button;

	//	Available Devices Columns:
	@FindBy(xpath = "(//div[@class='TableHeader']/h4)[1]")
	WebElement serialNumber_lbl;
	
	@FindBy(xpath = "(//div[@class='TableHeader']/h4)[2]")
	WebElement macAddress_lbl;
	
	@FindBy(xpath = "(//div[@class='TableHeader']/h4)[3]")
	WebElement email_lbl;
	
	@FindBy(xpath = "(//div[@class='TableHeader']/h4)[4]")
	WebElement phoneNumber_lbl;
	
	@FindBy(xpath = "(//div[@class='TableHeader']/h4)[5]")
	WebElement status_lbl;
	
	@FindBy(xpath = "(//div[@class='TableHeader']/h4)[6]")
	WebElement binVersion_lbl;
	
	@FindBy(xpath = "(//div[@class='TableHeader']/h4)[7]")
	WebElement delete_lbl;
	
	//	Add New Device Form:
	@FindBy(className = "CloseButton")
	WebElement formClose_btn;
	
	@FindBy(name = "device_id")
	WebElement deviceId_txt;
	
	@FindBy(name = "serial_number")
	WebElement serialNumber_txt;
	
	@FindBy(name = "device_bin_version")
	WebElement deviceVersion_txt;
	
	@FindBy(name = "user_device_version")
	WebElement userVersion_txt;
	
	@FindBy(className = "ProceedButton")
	WebElement proceed_btn;
	
	@FindAll(@FindBy(className = "PageNo"))
	WebElement pageNo_btns;
	
	@FindBy(xpath = "//select")
	WebElement countchanger_select;
	
	public void validateFields() {
		
		Assert.assertEquals(totalDevices_lbl.isDisplayed(), true);
		Assert.assertEquals(activeDevices_lbl.isDisplayed(), true);
		Assert.assertEquals(inactiveDevices_lbl.isDisplayed(), true);
		Assert.assertEquals(addNew_button.isDisplayed(), true);
		
		Assert.assertEquals(serialNumber_lbl.isDisplayed(), true);
		Assert.assertEquals(macAddress_lbl.isDisplayed(), true);
		Assert.assertEquals(email_lbl.isDisplayed(), true);
		Assert.assertEquals(phoneNumber_lbl.isDisplayed(), true);
		Assert.assertEquals(status_lbl.isDisplayed(), true);
		Assert.assertEquals(binVersion_lbl.isDisplayed(), true);
		Assert.assertEquals(delete_lbl.isDisplayed(), true);
	
	}
	public void clickAddNewButton() {
		addNew_button.click();
	}
	
	public void validateFormFields() {
		
		Assert.assertEquals(deviceId_txt.isDisplayed(), true);
		Assert.assertEquals(serialNumber_txt.isDisplayed(), true);
		Assert.assertEquals(deviceVersion_txt.isDisplayed(), true);
		Assert.assertEquals(userVersion_txt.isDisplayed(), true);
		Assert.assertEquals(proceed_btn.isDisplayed(), true);
	
	}
	public void clickFormCloseButton() {
		formClose_btn.click();
	}
	
	public void enterAddDeviceDetails(String deviceId, String serialNumber, String deviceVersion, String userVersion) {
		deviceId_txt.sendKeys(deviceId);
		serialNumber_txt.sendKeys(serialNumber);
		deviceVersion_txt.sendKeys(deviceVersion);
		userVersion_txt.sendKeys(userVersion);
	}
	
	public void clickProccedButton() {
		proceed_btn.click();
	}
	
	public void isDeviceExists(String serialNumber) {
		
		int pageNoCount = dri.findElements(By.className("PageNo")).size();
		int actualCount = dri.findElements(By.className("dataRow")).size();
		
		for(int i = 0; i < pageNoCount; i++) {
			for(int j = 1; j <= actualCount; j++) {
				
			}
		}
		
	}
	
	public void changePagenationCount(String count) {
		Select select = new Select(countchanger_select);
		select.selectByVisibleText(count);
	}
	public void validatePagenationCount(String count) {
		String actualCount = String.valueOf(dri.findElements(By.className("dataRow")).size());
		Assert.assertEquals(actualCount, count);
	}
	
}