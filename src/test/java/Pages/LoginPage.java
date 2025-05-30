package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath = "//h1[@class='Title']")
	WebElement title_H1;
	
	@FindBy(name = "email")
	WebElement phonenumber_Input;
	
	@FindBy(name = "password")
	WebElement password_Input;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginIn_Button;
	
	@FindBy(xpath = "//li/div/div")
	WebElement errorMessage_txt;
	
	public LoginPage(WebDriver dri) {
		PageFactory.initElements(dri, this);
	}
	
	//	Page Title
	public boolean isTitleExists(){
		return title_H1.isDisplayed();
	}
	public String getTitle() {
		return title_H1.getText();
	}
	
	public boolean isPhoneNumberInputExists() {
		return phonenumber_Input.isDisplayed();
	}
	
	public boolean isPasswordInputExists() {
		return password_Input.isDisplayed();
	}
	
	public void clickLoginButton() {
		loginIn_Button.click();
	}
	
	public void login(String phoneNumber, String password) {

		phonenumber_Input.sendKeys(phoneNumber);
		password_Input.sendKeys(password);
		
		loginIn_Button.click();
		
	}
	
	public String getErrorMessageTxt() {
		return errorMessage_txt.getText();
	}
}
