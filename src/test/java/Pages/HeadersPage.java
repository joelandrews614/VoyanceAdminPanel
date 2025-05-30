package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HeadersPage {

	private static WebDriver dri = null;
	
	public HeadersPage(WebDriver dri) {
		
		this.dri = dri;
		PageFactory.initElements(dri, this);
		
	}
	
	@FindBy(xpath = "//img[@class='Logo']")
	WebElement logo_img;
	
	@FindBy(xpath = "//h1[@class='Header']")
	WebElement title_txt;
	
	@FindBy(xpath = "//button[@class='fullScreenButton']")
	WebElement fullscreen_button;
	
	@FindBy(xpath = "//button[@class='LogoutButton']")
	WebElement logout_button;
	
	public void validateHeaderPanel() {
		
		Assert.assertEquals(logo_img.isDisplayed(), true);
		Assert.assertEquals(title_txt.isDisplayed(), true);
		Assert.assertEquals(fullscreen_button.isDisplayed(), true);
		Assert.assertEquals(logout_button.isDisplayed(), true);
	}
	
	public void clickLogoutButton() {
		
		logout_button.click();
		
	}
	
}