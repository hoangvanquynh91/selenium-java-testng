package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_18_JavaScript_Excutor {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	JavascriptExecutor jsExcutor;
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExcutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01() {
		navigateToUrlByJS("http://live.techpanda.org/");
		sleepInSecond(5);
		Assert.assertEquals(excuteForBrower("return document.domain;"), "live.techpanda.org");
		
		Assert.assertEquals(excuteForBrower("return document.URL;"), "http://live.techpanda.org/");
		
		excuteForBrower("return document.URL;");
		
	}

	
	public void TC_02() {
		
	}

	
	public void TC_03() {
		
	}
	public void sleepInSecond (long timeSecond) {
		try {
			Thread.sleep(timeSecond * 1000);
		}catch (InterruptedException e ) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void navigateToUrlByJS(String url) {
		jsExcutor.executeScript("window.location = '" + url + "'");
	}
	
	public String getDomainName() {
		return (String) jsExcutor.executeScript("document.domain();");
	}
	
	public Object excuteForBrower(String js) {
		return jsExcutor.executeScript(js);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
