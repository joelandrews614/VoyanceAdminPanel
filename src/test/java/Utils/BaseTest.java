package Utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Pages.DevicesPage;
import Pages.HeadersPage;
import Pages.HomePage;
import Pages.LoginPage;

public class BaseTest {
	
	public static WebDriver dri = null;
	
	public static LoginPage loginPage = null;
	public static HeadersPage headersPage = null;
	public static HomePage homePage = null;
	public static DevicesPage devicesPage = null;
	
	public String EnvironmentBaseURL = "http://dev.admin.voyanceecg.com";
	public String phoneNumber = "9597337509";
	public String password = "123456";

	@BeforeClass
	public void setUp() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
		
		dri = new ChromeDriver(options);
		dri.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		dri.navigate().to(EnvironmentBaseURL);
		
		loginPage = new LoginPage(dri);
		headersPage = new HeadersPage(dri);
		homePage = new HomePage(dri);
		devicesPage = new DevicesPage(dri);
	}
	
	@AfterClass
	public void tearDown() {
		if(dri != null)
			dri.quit();
	}
	
}