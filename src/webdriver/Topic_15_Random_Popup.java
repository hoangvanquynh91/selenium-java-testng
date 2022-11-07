package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_15_Random_Popup {
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

	
	public void TC_01_Java_Code_Greeks_HTML_In_DOM() {
		driver.get("https://www.javacodegeeks.com/");
		sleepInSecond(20);
		WebElement popup = driver.findElement(By.cssSelector("div.lepopup-popup-container>div:not([style*='display:none'])"));
		
		if(popup.isDisplayed()) {
			driver.findElement(By.xpath("//input[@name='lepopup-20']")).sendKeys(getRandomEmailAdd());
			sleepInSecond(3);
			driver.findElement(By.cssSelector("a[data-label='Get the Books']")).click();
			sleepInSecond(3);
		}
		//verify popup not display
		Assert.assertFalse(popup.isDisplayed());
		
		driver.findElement(By.cssSelector("input#s")).sendKeys("Automation");
		sleepInSecond(2);
		driver.findElement(By.cssSelector("button.search-button")).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='post-title']/a[contains(text(),'Accelerating App Testing')]")).isDisplayed());
		
	}

	public void TC_02_Java_Code_Greeks_HTML_In_DOM() {
		driver.get("https://kmplayer.com/home");
		
		WebElement popup = driver.findElement(By.cssSelector("img#support-home"));
		if(popup.isDisplayed()) {
			jsExcutor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("area#btn-r")));
		}
		
		driver.findElement(By.xpath("//li/a[text()='PC 64X']")).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='KMPlayer 64X']")).isDisplayed());
		
		
		
	}

	@Test
	public void TC_03_HTML_Not_In_Dom() {
		driver.get("https://dehieu.vn/");
		sleepInSecond(5);
		List<WebElement> popup = driver.findElements(By.cssSelector("div.popup-content"));
		
		if((popup.size()>0) &&(popup.get(0)).isDisplayed()) {
			driver.findElement(By.cssSelector("input#popup-name")).sendKeys("QuynhHV");
			driver.findElement(By.cssSelector("input#popup-email")).sendKeys("Quynh@gmail.com");
			driver.findElement(By.cssSelector("input#popup-phone")).sendKeys("09876543210");
			sleepInSecond(3);
			driver.findElement(By.cssSelector("button#close-popup")).click();
			sleepInSecond(3);
			
		}
		
		driver.findElement(By.xpath("//a[text()='Tất cả khóa học']")).click();
		sleepInSecond(3);
		driver.findElement(By.cssSelector("input#search-courses")).sendKeys("Khóa học Thiết kế tủ điện");
		driver.findElement(By.cssSelector("i.fa-search")).click();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("h4.name-course")).getText(), "Khóa học Thiết kế tủ điện");
		
		
		
	}
	
	public String getRandomEmailAdd() {
		Random rand = new Random();
		return "autotest" + rand.nextInt(999) + "@gmail.com";
		
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
