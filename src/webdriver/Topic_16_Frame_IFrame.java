package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Frame_IFrame {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	public void TC_01_Kyna_Iframe() {
		driver.get("https://skills.kynaenglish.vn/");
		sleepInSecond(5);
		
		//Verify Facebook Iframe hiển thị
		Assert.assertTrue(driver.findElement(By.xpath("//iframe[contains(@src,'kyna.vn')]")).isDisplayed());
		
		//Switch vào thẻ Iframe
		//driver.switchTo().frame(0);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'kyna.vn')]")));
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Kyna.vn']/parent::div/following-sibling::div")).getText(), "165K lượt thích");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='cs_chat_iframe']")));
		
		driver.findElement(By.cssSelector("div.button_bar")).click();
		sleepInSecond(5);
		
		driver.findElement(By.cssSelector("input.input_name")).sendKeys("Jonh Smith");
		driver.findElement(By.cssSelector("input.input_phone")).sendKeys("0236598711111");
		new Select(driver.findElement(By.cssSelector("select#serviceSelect"))).selectByVisibleText("TƯ VẤN TUYỂN SINH");
		
		driver.findElement(By.name("message")).sendKeys("Tu Van khoa hoc Exxcel");
		
		sleepInSecond(3);
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("Excel");
		
		driver.findElement(By.cssSelector("button.search-button")).click();
		
		List<WebElement> courseNames = driver.findElements(By.cssSelector("div.content>h4"));
		
		for (WebElement course : courseNames) {
			Assert.assertTrue(course.getText().contains("Excel"));

		}
		
	}

	@Test
	public void TC_02_HDFCBank() {
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		sleepInSecond(8);
		
		driver.switchTo().frame(driver.findElement(By.name("login_page")));
		
		driver.findElement(By.name("fldLoginUserId")).sendKeys("Jonh2022");
		
		driver.findElement(By.cssSelector("a.login-btn")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input#fldPasswordDispId")).isDisplayed());
		
		
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
