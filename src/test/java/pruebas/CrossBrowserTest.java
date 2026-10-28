package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	WebDriver driver;
	String url = "https://practicetestautomation.com/practice-test-login/";


	@Parameters("navegador")
	@BeforeMethod
	public void SetUp(String navegador) {
	
		if(navegador.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else {
			driver = new FirefoxDriver();
		}
		
		driver.get(navegador);
	}
	@Test
	public void testLogin() {
		driver.get(url);//abrir el navegador con la url definida
		driver.manage().deleteAllCookies();//borrar cookies
		driver.manage().window().maximize();//maximizar ventana

		WebElement txt_Username=driver.findElement(By.id("username"));//identificar el elemento de usuario
		txt_Username.sendKeys("student");//enviar el valor al elemento
		// ingresar password
		WebElement txt_Password=driver.findElement(By.id("password"));//identificar el elemento de password
		txt_Password.sendKeys("Password123");
		//login 
		WebElement btn_Login=driver.findElement(By.id("submit"));//identificar el elemento de login
		btn_Login.click();//click en el boton login
		//cerrar el navegador
	}
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
