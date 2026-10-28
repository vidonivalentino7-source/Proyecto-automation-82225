package pruebas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticaM6 {
 
	private WebDriver driver;
	// urls test
	//String url = "https://demo.guru99.com/test/upload/";
	//String url = "https://demo.guru99.com/test/table.html";
	String url = "https://practice-automation.com/popups/";

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
	}
	
	@AfterMethod	
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	@Test (enabled = false)
	public void uploadFile() {
		WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
		uploadElement.sendKeys("C:\\Users\\Valentino\\eclipse-workspace\\eduit_85255\\prueba.txt");
		
	}
	@Test (enabled = false)
	public void getCell() {
		WebElement cell =  driver.findElement(By.xpath("//tbody/tr[4]/td[3]"));
		String cellText = cell.getText();
		Assert.assertEquals(cellText, "8");
	}
	//alert test
	@Test
	public void notification() throws InterruptedException {
		WebElement btnButton = driver.findElement(By.id("alert"));
		btnButton.click();
		Alert Notification = driver.switchTo().alert();
		Notification.accept();
		Thread.sleep(2000);
		
	}
	
}
