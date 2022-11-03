package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_14_Fixed_Popup {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	public void TC_01() {
		driver.get("https://ngoaingu24h.vn/");
		By modalPopup = By.xpath("(//div[@id='modal-login-v1'])[1]");
		
		Assert.assertFalse(driver.findElement(modalPopup).isDisplayed());
		
		driver.findElement(By.xpath("//button[@class= 'login_ icon-before']")).click();
		
		//Popup login hien thi
		Assert.assertTrue(driver.findElement(modalPopup).isDisplayed());
		
		//Nhap thong tin khong hop le
		driver.findElement(By.cssSelector("div#modal-login-v1[style] input#account-input")).sendKeys("Quynh@gmail.com.vn");
		driver.findElement(By.cssSelector("div#modal-login-v1[style] input#password-input")).sendKeys("123456789");
		
		driver.findElement(By.cssSelector("div#modal-login-v1[style] button.btn-login-v1")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#modal-login-v1[style] div.error-login-panel")).getText(), "Tài khoản không tồn tại!");
		
	}

	public void TC_02_Tiki() {
		driver.get("https://tiki.vn/");
		
		//Click vaof dang nhap 
		driver.findElement(By.xpath("//span[contains(@class,'Userstyle__ItemText')]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@role='dialog']")).isDisplayed());
		
		//Click vao text dang nhap bang email
		driver.findElement(By.cssSelector("p.login-with-email")).click();
		sleepInSecond(2);
		driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Email không được để trống']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Mật khẩu không được để trống']")).isDisplayed());
		
		driver.findElement(By.xpath("//img[@class='close-img']")).click();
		
		Assert.assertEquals(driver.findElements(By.xpath("//div[@role='dialog']")).size(), 0);
		
	}

	@Test
	public void TC_03_Facebook() {
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Đăng ký']/parent::div/parent::div")).isDisplayed());
		
		driver.findElement(By.xpath("//div[text()='Đăng ký']/parent::div/parent::div/img")).click();
		
		Assert.assertEquals(driver.findElements(By.xpath("//div[text()='Đăng ký']/parent::div/parent::div")).size(), 0);
		
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
