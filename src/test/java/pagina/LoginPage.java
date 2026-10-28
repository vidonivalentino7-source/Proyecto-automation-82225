package pagina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By txtEmail = By.cssSelector("input[data-qa='login-email']");
	By txtPassword = By.cssSelector("input[data-qa='login-password']");
	By btnLogin = By.cssSelector("button[data-qa='login-button']");
	By lblLogged = By.xpath("//a[contains(text(),'Logged in as')]");
	By btnCookies = By.className("fc-button-label");
	By lblError = By.xpath("//p[contains(text(),'Your email')]");
	
	
	public void LoginPag(String email, String password) {
		driver.findElement(btnCookies).click();
		driver.findElement(txtEmail).sendKeys(email);
		driver.findElement(txtPassword).sendKeys(password);
		driver.findElement(btnLogin).click();
	}
	
	public boolean isLoggedIn() {
		return driver.findElement(lblLogged).isDisplayed();
	}
	
	public boolean isNotLoggedIn() {
		return driver.findElement(lblError).isDisplayed();
	}
}
