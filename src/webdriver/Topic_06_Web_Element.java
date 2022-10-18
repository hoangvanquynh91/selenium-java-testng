package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
	}

	@Test
	public void TC_01() {
		WebElement element = driver.findElement(By.xpath("//button[@class='button-1 search-box-button']"));
/*	
		// Dùng cho textbox, dropdown (editable), textarea,..
		// Xóa data
		element.clear();
		
		// Dùng cho textbox, dropdown (editable), textarea,..
		// Input data
		element.sendKeys("");
		
		// click vào button, checkbox, radio, link, image ...
		element.click();
		
		
		// trả về dữ liệu
		String search = element.getAttribute(projectPath);
		
		// get attribute của css
		System.out.println(element.getCssValue("color"));
		
		System.out.println(element.getLocation());
		
		System.out.println(element.getSize());
		
		//Khi nào dùng getText, khi nào dung getAtribute
		//Khi cái value mình lấy nó nằm bên ngoài -> getText()
		//Khi value mình lấy nó nằm trong thẻ -> getAttribute
		
		
		// Dùng để vertify xem 1 element hiển thị hoặc không
		element.isDisplayed();
		Assert.assertTrue(element.isDisplayed());
		Assert.assertFalse(element.isDisplayed());
		
		
		//Dùng để vertify xem 1 element có thao tác được hay không
		Assert.assertTrue(element.isEnabled());
		Assert.assertFalse(element.isEnabled());
		
		//Dùng để vertify xem 1 element có được chọn hay chưa
		//Phạm vi : Dùng cho checkbox, radio
		Assert.assertTrue(element.isSelected());
		Assert.assertFalse(element.isSelected());*/
		
		// Chỉ có thể sử dụng nếu element nằm trong thẻ <form>
		element.submit();
		
	}

	@Test
	public void TC_02() {
		
	}

	@Test
	public void TC_03() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
