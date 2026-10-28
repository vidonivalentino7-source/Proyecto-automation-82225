package educacionit_85225.eduit;

import java.time.Duration;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticaM2 {
	//variables que necesito para ejecutar el test
	String url ="https://www.automationexercise.com/login";
	
	@Test
	public void registrerNewAccount() {
		String uniqueEmail = "test" + UUID.randomUUID().toString().substring(0,5) + "@test.com";
		
		ChromeOptions options = new ChromeOptions();
		// maximizar ventana
		options.addArguments("--start-maximized");
		// abrir en modo incognito
		options.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			
		driver.get(url);
		
		WebElement btn_btncookies = driver.findElement(By.className("fc-button-label"));
		btn_btncookies.click();
				
		WebElement txt_name = driver.findElement(By.name("name"));
		txt_name.sendKeys("Lionel");
		
		WebElement txt_email = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
		txt_email.sendKeys(uniqueEmail);
		
		WebElement btn_signup = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
		btn_signup.click();
				
		WebElement rdbtn_gender = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		rdbtn_gender.click();
			
		WebElement txt_password = driver.findElement(By.id("password"));
		txt_password.sendKeys("Messi123!");
		
		Select drp_day = new Select(driver.findElement(By.id("days")));
		drp_day.selectByVisibleText("10");
		
		Select drp_month = new Select(driver.findElement(By.id("months")));
		drp_month.selectByVisibleText("May");
		
		Select drp_year = new Select(driver.findElement(By.id("years")));
		drp_year.selectByVisibleText("1987");
		
		WebElement txt_firstname = driver.findElement(By.id("first_name"));
		txt_firstname.sendKeys("Lionel");
		
		WebElement txt_lastname = driver.findElement(By.id("last_name"));
		txt_lastname.sendKeys("Messi");
		
		WebElement txt_address = driver.findElement(By.id("address1"));
		txt_address.sendKeys("Calle Falsa 123");
		//seleccionar pais en select 
		Select drp_Country = new Select(driver.findElement(By.id("country")));
		drp_Country.selectByVisibleText("Canada");
		
		WebElement txt_state = driver.findElement(By.id("state"));
		txt_state.sendKeys("Ontario");
		
		WebElement txt_city = driver.findElement(By.id("city"));
		txt_city.sendKeys("Toronto");
		
		WebElement txt_zipcode = driver.findElement(By.id("zipcode"));
		txt_zipcode.sendKeys("M5H 2N2");
		
		WebElement txt_mobile = driver.findElement(By.id("mobile_number"));
		txt_mobile.sendKeys("4161234567");
		
		WebElement btn_createAccount = driver.findElement(By.cssSelector("button[data-qa='create-account']"));
		btn_createAccount.click();
		
		} finally {
			driver.quit();
		}
		
		
		
		
	}
}
