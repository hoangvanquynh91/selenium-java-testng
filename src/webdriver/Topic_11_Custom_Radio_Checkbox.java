package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Custom_Radio_Checkbox {
	WebDriver driver;
	JavascriptExecutor jsExcutor;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		jsExcutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	public void TC_01() {
		driver.get("https://material.angular.io/components/checkbox/examples");
		
		//Case 1 : Thẻ input bị ẩn nên không click được
		//Thẻ input dùng để verify được
		
		
		
		//Case 2: Không dùng thẻ input để click - thay thế bằng 1 thẻ đang hiển thị đại diện cho radio/checkbox /span, /div...
		//Nhưng các thẻ này lại không verify được
		
		
		//Case 3 
		//Dùng thẻ span để click
		// Dùng thẻ input để verify
		//Vấn đề : Trong 1 dự án 1 element mà cần 2 locator để define thì sinh ra nhiều code -> cần maintain nhiều
		// Dễ gây hiểu nhầm cho người khác đọc code
//		
//		driver.findElement(By.xpath("//span[text()='Checked']//preceding-sibling::span")).click();
//		sleepInSecond(3);
//		
//		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Checked']//preceding-sibling::span/input")).isSelected());
		
		//case 4 : Work-around 
		// Dùng thẻ input để click và verify
		// Nhưng hàm click của WebElement không click vào element ẩn được
		// Giải pháp : Dùng hàm click của JavaScriptExcutor : Không quan tâm Element bị ẩn hay không
		
		jsExcutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Checked']//preceding-sibling::span/input")));
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Checked']//preceding-sibling::span/input")).isSelected());
		
		
		
		
		
	}

	
	@Test
	public void TC_02_CustomRadio() {
		driver.get("https://material.angular.io/components/radio/examples");
		jsExcutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[contains(text(),'Spring')]//preceding-sibling::span/input")));
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Spring')]//preceding-sibling::span/input")).isSelected());
		
		
		
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

