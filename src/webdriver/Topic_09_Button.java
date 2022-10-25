package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Button {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01() {
		driver.get("https://www.fahasa.com/customer/account/create");
		sleepInSecond(8);
		
		driver.findElement(By.cssSelector("button#moe-dontallow_button")).click();
		sleepInSecond(3);
		
		//switch qua iframe
		
			WebElement iFrameElement = driver.findElement(By.xpath("//iframe[contains(@id,'moe-onsite-campaign')]"));
			driver.switchTo().frame(iFrameElement);
			driver.findElement(By.xpath("//button[@id='close-icon']")).click();
		
			driver.switchTo().defaultContent();
		//chuyen sang tab login
		    driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
		
		//vertify button dang nhap
		Assert.assertFalse(driver.findElement(By.cssSelector("button.fhs-btn-login")).isEnabled());
		
		//Input data
		driver.findElement(By.cssSelector("input#login_username")).sendKeys("Quynh@gmail.com");
		driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");
		
		String rgbaColor = driver.findElement(By.xpath("//button[@class='fhs-btn-login']")).getCssValue("background-color");
		
		//convert to hexa color
		String hexaColor = Color.fromString(rgbaColor).asHex().toUpperCase();
		
		//vertify button login color
		Assert.assertEquals(hexaColor, "#C92127");
		
	}

	public void sleepInSecond (long timeSecond) {
		try {
			Thread.sleep(timeSecond * 1000);
		}catch (InterruptedException e ) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
