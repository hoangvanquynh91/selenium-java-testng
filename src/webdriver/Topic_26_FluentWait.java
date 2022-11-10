package webdriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Topic_26_FluentWait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait explicit;
	FluentWait<WebDriver> fluentDriver;
	FluentWait<WebElement> fluentElement;
	long allTime = 15; //second
	long pollingTime = 100; //milisecond
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	}

	
	public void TC_01_FluentWait() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		finElement("//div[@id='start']/button").click();
		
		Assert.assertEquals(finElement("//div[@id='finish']/h4").getText(), "Hello World!");
		
		
		
	}
	public WebElement finElement(String xpathlocator) {
		fluentDriver = new FluentWait<WebDriver>(driver);
		//Set tổng thời gian check
		fluentDriver.withTimeout(Duration.ofSeconds(allTime)).
		//1/3 giây check 1 lần
		pollingEvery(Duration.ofMillis(pollingTime)).
		ignoring(NoSuchElementException.class);
		
		//Appply điều kiện
		WebElement element = fluentDriver.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(By.xpath(xpathlocator));
			}
			
		});
		return element;
		
		
	}

	@Test
	public void TC_02_FlentWait() {
		driver.get("https://automationfc.github.io/fluent-wait/");
		
		WebElement countDown = finElement("//div[@id='javascript_countdown_time']");
		fluentElement = new FluentWait<WebElement>(countDown);
		fluentElement.withTimeout(Duration.ofSeconds(allTime)).pollingEvery(Duration.ofMillis(pollingTime)).ignoring(NoSuchElementException.class);
		
		fluentElement.until(new Function<WebElement, Boolean>(){
			

			@Override
			public Boolean apply(WebElement element) {
				// TODO Auto-generated method stub
				return element.getText().endsWith("00");
			}
			
		});
		
		
		
		
		
		
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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
