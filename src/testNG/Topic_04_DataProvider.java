package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Topic_04_DataProvider {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	By emailTextBox = By.xpath("//*[@id='email']");
	By passwordTextBox = By.xpath("//*[@id='pass']");
	By loginButton = By.xpath("//*[@id='send2']");
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider = "login")
	public void TC_01LoginToSystem(String userName, String passWord) throws InterruptedException {
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		driver.findElement(emailTextBox).sendKeys(userName);
		driver.findElement(passwordTextBox).sendKeys(passWord);
		driver.findElement(loginButton).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains(userName));
		driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();

	}
	@DataProvider(name = "login")
	public Object[][] UserAndPasswordData() {
		return new Object[][] { 
			{ "selenium_11_01@gmail.com", "111111" }, 
			{ "selenium_11_02@gmail.com", "111111" }, 
			{ "selenium_11_03@gmail.com", "111111" } };
	}
	
	@DataProvider(name = "register")
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

}
