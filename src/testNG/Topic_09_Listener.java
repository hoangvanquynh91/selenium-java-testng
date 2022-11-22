package testNG;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listener.EntendReportListener;

@Listeners(EntendReportListener.class)
public class Topic_09_Listener {
	public static WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void TC_01LoginToSystem() throws InterruptedException {
		driver.get("http://live.techpanda.org/index.php/customer/account/create/");
		driver.findElement(By.id("firstname")).sendKeys("Automation");
		driver.findElement(By.id("lastname")).sendKeys("FC");
		driver.findElement(By.id("email_address")).sendKeys("QTQT" + getRandomNumber() +"@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("confirmation")).sendKeys("123456");
		
		
		
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='success-msg']//span[text()='Thank you for registering with Main Website Store.']")).isDisplayed());

	}
	
	
	private int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(99999);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

}

