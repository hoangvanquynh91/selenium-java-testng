package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_XPath_Part1 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01() {
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		
		//Click vaof my account link duoi footer
		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title='My Account']")).click();
	}

	@Test
	public void TC_02() {
		
		driver.get("https://automationfc.github.io/basic-form/");
		
		
		System.out.println(driver.findElement(By.xpath("//h5[@id = 'nested']")).getText());
		
	}

	@Test
	public void TC_03() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
