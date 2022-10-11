package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register");
	}

	@Test
	public void TC_01_ID() {
		driver.findElement(By.id("FirstName")).sendKeys("Automation");
		
	}

	@Test
	public void TC_02_Class() {
		// Mở màn hình search
		driver.get("https://demo.nopcommerce.com/search");
		driver.findElement(By.className("search-text")).sendKeys("DELL");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
	}

	@Test
	public void TC_03_Name() {
		//Click vào addvanced search checkbox
		driver.findElement(By.name("advs")).click();
	}
	
	@Test
	public void TC_04_TagName() {
		// tìm số lượng thẻ input trên màn hình hiện tại
		
		System.out.print(driver.findElements(By.tagName("input")).size());
		
	}
	
	@Test
	public void TC_05_LinkText() {
		//Click vao duong link
		driver.findElement(By.linkText("Addresses")).click();
		
	}
	
	@Test
	public void TC_06_PartialLinkText() {
		
		driver.findElement(By.partialLinkText("Apply for vendor")).click();
		
	}
	
	@Test
	public void TC_07_CSS() {
		//Mo trang register
		driver.get("https://demo.nopcommerce.com/register");
		
		//1
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("SeleniumFirstName");
		
		//2
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("SeleniumLastName");
		
		//3
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("abc@gmail.com");
		
	}
	
	@Test
	public void TC_08_XPath() {
		//Mo trang register
		driver.get("https://demo.nopcommerce.com/register");
				
		//1
		//driver.findElement(By.xpath("//input[@data-val-required='First name is required.']")).sendKeys("SeleniumFirstName");
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("SeleniumFirstName");
				
		//2
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("SeleniumLastName");
				
		//3
		driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input")).sendKeys("QuynhHV@gmail.com");
		
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
