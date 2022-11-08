package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class demo {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01() {
		driver.get("http://192.168.50.6:8480/nts.uk.com.web/view/ccg/007/d/index.xhtml");
		sleepInSecond(3);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='window_1']")));
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//input[@id='contract-code-inp']")).sendKeys("000000000004");
		driver.findElement(By.xpath("//input[@id='password-input']")).sendKeys("0");
		
		driver.findElement(By.xpath("//button[@id='login-btn' and text()='認証']")).click();
		
		driver.switchTo().defaultContent();
		sleepInSecond(5);
		
		driver.findElement(By.xpath("//div[@class='login-form']/table//div[@class='ui-igcombo-wrapper ntsControl']")).click();
		
		List<WebElement> companies = driver.findElements(By.xpath("//ul[@class='ui-igcombo-listitemholder']//div[@class='nts-combo-item']/div[contains(@class,'companycode')]"));
		
		for (WebElement com : companies) {
			if(com.getText().equals("0007 ")) {
				com.click();
				break;
			}
			
		}
		
		driver.findElement(By.xpath("//td[text()='社員コード']/following-sibling::td//input")).sendKeys("930001");
		driver.findElement(By.xpath("//td[text()='パスワード']/following-sibling::td//input")).sendKeys("0");
		
		driver.findElement(By.xpath("//button[@id='login-btn']")).click();
		sleepInSecond(5);
		
	      
		
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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}