package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_27_Page_Ready {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	JavascriptExecutor jsExcutor;
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		
		//driver.manage().window().maximize();
	}

	@Test
	public void TC_01() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Assert.assertTrue(isPageLoadedSuccess());
		//sleepInSecond(10);
		String employeeName = "Peter Mac Anderson";
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
		Assert.assertTrue(isPageLoadedSuccess());
		sleepInSecond(5);
		
		Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Time at Work']")).getText(), "Time at Work");
		
		driver.findElement(By.xpath("//a[@class='oxd-main-menu-item']/span[text()='PIM']")).click();
		
		
		
	}



	
	public boolean isPageLoadedSuccess() {
		explicitWait = new WebDriverWait(driver, 50);
		jsExcutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				// TODO Auto-generated method stub
				try {
					return (Boolean) jsExcutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					return true;
				}
			}		
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				// TODO Auto-generated method stub
				try {
					return jsExcutor.executeScript("return document.readyState").toString().equals("complete");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					return true;
				}
			}
			
		};
		return explicitWait.until(jsLoad);
		
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
