package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pagina.LoginPage;

public class PracticaM5 {
	
	String url = "https://automationexercise.com/login";
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				options.addArguments("--incognito");
				driver = new ChromeDriver(options);
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
				driver.get(url);
	}
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}
	
	@Test(dataProvider = "loginData")
	public void testLogin(String email, String password) {
		LoginPage login = new LoginPage(driver);
		login.LoginPag(email, password);
		Assert.assertTrue(login.isLoggedIn());
	}
	
	@Test(dataProvider = "loginDataInvalid")
	public void testLoginInvalid(String email, String password) {
		LoginPage login = new LoginPage(driver);
		login.LoginPag(email, password);
		Assert.assertTrue(login.isNotLoggedIn(), "El usuario no ha iniciado sesión correctamente.");
	}
	
	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		return new Object[][] {
			{"test_ar@test.com", "12345"},
			{"test_co@test.com", "12345" } };
	}
	
	@DataProvider(name = "loginDataInvalid")
	public Object[][] loginDataInvalid() {
		return new Object[][] {
			{"teeeeetr@test.com", "12345mesisi"},
			{"tesfwwo@test.com", "12345mesisi" } };
	}
	
}




