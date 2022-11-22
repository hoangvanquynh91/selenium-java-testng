package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Parameter_Enviroment {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	By emailTextBox = By.xpath("//*[@id='email']");
	By passwordTextBox = By.xpath("//*[@id='pass']");
	By loginButton = By.xpath("//*[@id='send2']");
	
	@Parameters("brower")
	@BeforeClass
	public void beforeClass(@Optional("Edge") String browerName) {
		//If Else
//		if (browerName.equals("Edge")) {
//			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
//			driver = new EdgeDriver();
//			
//		} else if(browerName.equals("Chrome")) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//			driver = new ChromeDriver();
//
//		} else if(browerName.equals("Firefox")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		} else {
//			throw new RuntimeException("Please check brower name");
//		}
		
		//Switch
		switch (browerName) {
		case "Edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "Chrome":	
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Please check brower name");
		}
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Parameters("environment")
	@Test
	public void TC_01_LoginToSystem(String envName) {
		String envUrl = getEnvironmentURL(envName);
		
		
		driver.get(envUrl +"/index.php/customer/account/login/");
		driver.findElement(emailTextBox).sendKeys("selenium_11_01@gmail.com");
		driver.findElement(passwordTextBox).sendKeys("111111");
		driver.findElement(loginButton).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("selenium_11_01"));
		driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();

	}
	public String getEnvironmentURL(String envName) {
		if (envName.equals("dev")) {
			return "http://dev.techpanda.org";
		} else if(envName.equals("test")){
			return "http://test.techpanda.org";
		}else if(envName.equals("live")) {
			return "http://live.techpanda.org";
		} else {
			return null;
		}
	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

}
