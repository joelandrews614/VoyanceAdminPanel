package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	private static WebDriver dri = null;
	
	public HomePage(WebDriver dri) {
		this.dri = dri;
		PageFactory.initElements(dri, this);
	}
	
	@FindBy(xpath = "(//div/span)[1]")
	WebElement devices;
	
	@FindBy(xpath = "(//div/span)[2]")
	WebElement users;
	
	@FindBy(xpath = "(//div/span)[3]")
	WebElement cardio;
	
	@FindBy(xpath = "(//div/span)[4]")
	WebElement ota;
	
	@FindBy(xpath = "(//div/span)[5]")
	WebElement offers;
	
	@FindBy(xpath = "(//div/span)[6]")
	WebElement subscription;
	
	@FindBy(css = "[class='LogoutButton']")
	public WebElement logOutBtn;
	
	
	public void validateSideNavBars() {
		
		Assert.assertEquals(devices.isDisplayed(), true);
		Assert.assertEquals(users.isDisplayed(), true);
		Assert.assertEquals(cardio.isDisplayed(), true);
		Assert.assertEquals(ota.isDisplayed(), true);
		Assert.assertEquals(offers.isDisplayed(), true);
//		Assert.assertEquals(subscription.isDisplayed(), true);
		
	}
	
}
