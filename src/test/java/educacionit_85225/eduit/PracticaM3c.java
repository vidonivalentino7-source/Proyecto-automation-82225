package educacionit_85225.eduit;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PracticaM3c {
		
	private WebDriver driver;
	private WebDriverWait wait;
	String url ="https://www.automationexercise.com/login";
	
	@BeforeSuite 
	public void initSuite() {
		System.out.println("inicianodo la suite de pruebas");
	}
	
	@AfterSuite
	public void endSuite() {
		System.out.println("finalizando la suite de pruebas");
	}
	
	@BeforeClass 
	public void setUp() {
		System.out.println("abriendo el navegador");
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--start-maximized");		
		options.addArguments("--incognito");
		
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	}
	@BeforeMethod
	public void abrirPagina() {
		System.out.println("abriendo pagina");
		driver.get(url);
	}
	@AfterMethod
	public void tearDown() throws IOException {
		System.out.println("finalizando test");
		capturaPantalla();
	}
	
	@AfterClass 
	public void cerrarNavegador() {
		if (driver!=null) {
			driver.quit();
		}
		
	}
	@Test 
	public void registerNewAccount_1() {
		System.out.println("iniciando el test de registro de cuenta");
			String uniqueEmail = "test" + UUID.randomUUID().toString().substring(0,5) + "@test.com";
			
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
			
			
			//assertion to verify that the account was created successfully
			WebElement accountCreatedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@data-qa='account-created']")));
			String expectedText = "ACCOUNT CREATED!";
			
			String actualText = accountCreatedMessage.getText();
			
			Assert.assertEquals(actualText,expectedText , "El mensaje de cuenta creada no es el esperado");
			
		}
	
	@Test 
	public void registerNewAccount_2() {
		System.out.println("iniciando el test de registro de cuenta");
	
			String uniqueEmail = "test" + UUID.randomUUID().toString().substring(0,5) + "@test.com";
			
			WebElement btn_btncookies = driver.findElement(By.className("fc-button-label"));
			btn_btncookies.click();
					
			WebElement txt_name = driver.findElement(By.name("name"));
			txt_name.sendKeys("Anto");
			
			WebElement txt_email = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
			txt_email.sendKeys(uniqueEmail);
			
			WebElement btn_signup = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
			btn_signup.click();
					
			WebElement rdbtn_gender = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2")));
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
			txt_firstname.sendKeys("anto");
			
			WebElement txt_lastname = driver.findElement(By.id("last_name"));
			txt_lastname.sendKeys("rocuzzo");
			
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
			//assertion to verify that the account was created successfully
			WebElement accountCreatedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@data-qa='account-created']")));
			String expectedText = "ACCOUNT CREATED!";
			String actualText = accountCreatedMessage.getText();
			Assert.assertEquals(actualText,expectedText , "El mensaje de cuenta creada no es el esperado");
}

	private void capturaPantalla() throws IOException {
		if(driver==null)return;
		File screen =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Path destDir=Path.of("../","eduit_85255","evidencias");
		Files.createDirectories(destDir);	
		Path dest = destDir.resolve("pantalla_" + System.currentTimeMillis() + ".png");
		Files.copy(screen.toPath(), dest , StandardCopyOption.REPLACE_EXISTING);
		System.out.println("captura de pantalla guardada en: " + dest.toAbsolutePath());
		
	}
	
}