package educacionit_85225.eduit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticaM1 {
	//variables que necesito para ejecutar el test
	String url = "https://practicetestautomation.com/practice-test-login/";
	@Test @Disabled
	public void Laboratorio1() {
		System.out.println("Hola Mundo de Automation");
	}
	@Test @Disabled
	public void LoginTest() {
		//definir navegador a utilizar
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();//borrar cookies
		driver.manage().window().maximize();//maximizar ventana
		//paso 2 
		driver.get(url);//abrir el navegador con la url definida
		// pasar usuario
		WebElement txt_Username=driver.findElement(By.id("username"));//identificar el elemento de usuario
		txt_Username.sendKeys("student");//enviar el valor al elemento
		// ingresar password
		WebElement txt_Password=driver.findElement(By.id("password"));//identificar el elemento de password
		txt_Password.sendKeys("Password123");
		//login 
		WebElement btn_Login=driver.findElement(By.id("submit"));//identificar el elemento de login
		btn_Login.click();//click en el boton login
		//cerrar el navegador
		driver.quit();
		
	}@Test 
	public void LoginTestFirefox() {
		//definir navegador a utilizard
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();//borrar cookies
		driver.manage().window().maximize();//maximizar ventana
		//paso 2 
		driver.get(url);//abrir el navegador con la url definida
		// pasar usuario
		WebElement txt_Username=driver.findElement(By.id("username"));//identificar el elemento de usuario
		txt_Username.sendKeys("student");//enviar el valor al elemento
		// ingresar password
		WebElement txt_Password=driver.findElement(By.id("password"));//identificar el elemento de password
		txt_Password.sendKeys("Password123");
		//login 
		WebElement btn_Login=driver.findElement(By.id("submit"));//identificar el elemento de login
		btn_Login.click();//click en el boton login
		//cerrar el navegador
		driver.quit();
		
	}
}
