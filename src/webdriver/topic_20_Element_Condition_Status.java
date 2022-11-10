package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class topic_20_Element_Condition_Status {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		explicitWait = new WebDriverWait(driver,10);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	public void TC_01_Visible_Display_Visibility() {
		driver.get("https://www.facebook.com/");
		//1. Có trên UI
		//Có trong HTML
		//Wait cho đến khi email address hiển thị
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		
		
	}
		
	

	
	public void TC_02_Invisible_Undisplayed_Invisibility_I() {
		// Không có trên UI
		//Có trong HTML
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		//Chờ cho Re-enter không hiển thị trong vòng 10s
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
		
		
	}

	
	public void TC_03_Invisible_Undisplayed_Invisibility_II() {
		// Không có trên UI
		//Không có trong HTML
		driver.get("https://www.facebook.com/");
		
		//Chờ cho Re-enter không hiển thị trong vòng 10s
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
		
		
	}
	
	public void TC_04_Present_I() {
		//Có trên UI
		// Có trong HTML
		driver.get("https://www.facebook.com/");
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		
		
	}
	
	public void TC_05_Present_II() {
		//Không Có trên UI
		// Có trong HTML
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		//Chờ cho Re-enter không hiển thị trong vòng 10s
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.name("reg_email_confirmation__")));
		
		
	}
	@Test
	public void TC_06_Staleness() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.name("reg_email_confirmation__")));
		
		//Phase1 Element có trong HTML
		WebElement reenterEmailAddressTextBox = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		
		//Thao tác với element khác là cho element re-enter không còn trong DOM nữa
		//Close popup
		driver.findElement(By.xpath("//img[@class='_8idr img']")).click();
		
		//Chờ cho re-enter Email Text box không còn trong HTML nữa
		explicitWait.until(ExpectedConditions.stalenessOf(reenterEmailAddressTextBox));
		
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