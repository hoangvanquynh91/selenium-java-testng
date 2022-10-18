package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Exercise_Web_Element {
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
	public void TC_01_Vertify_url() {
		driver.get("http://live.techpanda.org/");
		//Click vao link My Account ở footer
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text() = 'My Account']")).click();
		
		//Vertify url cua page login = http://live.techpanda.org/index.php/customer/account/login/
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		
		//Click button CREATE AN ACCOUNT
		driver.findElement(By.xpath("//div[@class='col-1 new-users']//a")).click();
		
		//Vertify url cua page Register =http://live.techpanda.org/index.php/customer/account/create/
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
		
	}

	@Test
	public void TC_02_Vertify_Tittle() {
		driver.get("http://live.techpanda.org/");
		//Click vao link My Account ở footer
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text() = 'My Account']")).click();
		
		//Vertify title cua page login = Customer Login
		Assert.assertEquals(driver.getTitle(), "Customer Login");
		
		//Click button CREATE AN ACCOUNT
		driver.findElement(By.xpath("//div[@class='col-1 new-users']//a")).click();
		
		//Vertify title cua page Register = Create New Customer Account
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
		
	}

	@Test
	public void TC_03_Navigate() {
		
		driver.get("http://live.techpanda.org/");
		//Click vao link My Account ở footer
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text() = 'My Account']")).click();
		
		//Click button CREATE AN ACCOUNT
		driver.findElement(By.xpath("//div[@class='col-1 new-users']//a")).click();
		
		//Vertify url cua page Register =http://live.techpanda.org/index.php/customer/account/create/
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
		
		//Back lại trang Login Page
		driver.navigate().back();
		
		//Vertify url cua page login = http://live.techpanda.org/index.php/customer/account/login/
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		
		//Forward tới trang register
		driver.navigate().forward();
		
		
		//Vertify title cua page Register = Create New Customer Account
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
		
		
	}

	
	@Test
	public void TC_04_Get_Page_Source_Code() {
		driver.get("http://live.techpanda.org/");
		//Click vao link My Account ở footer
		driver.findElement(By.xpath("//div[@class='footer-container']//a[@title = 'My Account']")).click();
		
		//Vertify login page chứa text Login or Create an Acccount
		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
		
		
		//Click button CREATE AN ACCOUNT
		driver.findElement(By.xpath("//div[@class='col-1 new-users']//a")).click();
		
		//Vertify login page chứa text Create an Account
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
		
		
	}
	

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
