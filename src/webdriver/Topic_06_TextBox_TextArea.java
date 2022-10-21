package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_TextBox_TextArea {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstName, lastName,midName, editFirstName,editMidName, editLastName,employyeID;
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		firstName = "Lucas";
		midName = "Jonh";
		lastName = "Smith";
		editFirstName = "David";
		editMidName = "Tom";
		editLastName = "Cruse";
	}

	@Test
	public void TC_01_TextBox_TextArea() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// Đăng nhập vào hệ thống
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[contains(@class,'orangehrm-login-button')]")).click();
		
		sleepInSecond(10);
		
		// Mở màn hinh add employee
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
		
		//Input data
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys(midName);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
		
		
		// Lưu giá trị employee vào biến
		// 1. Lấy ra giá trị
		// 2. Gán  vào biến
		
		employyeID = driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div//following-sibling::div/input")).getAttribute("value");
		sleepInSecond(3);
		
		
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
		sleepInSecond(10);
		
		System.out.println(driver.findElement(By.xpath("//input[@name= 'lastName']")).getAttribute("_value"));
	
		//Vertify filed
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name= 'firstName']")).getAttribute("_value"),firstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name= 'middleName']")).getAttribute("_value"),midName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name= 'lastName']")).getAttribute("_value"),lastName);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"),employyeID);
		sleepInSecond(20);
		
		//edit gia tri
		driver.findElement(By.xpath("//input[@name= 'firstName']")).clear();
		driver.findElement(By.xpath("//input[@name= 'middleName']")).clear();
		driver.findElement(By.xpath("//input[@name= 'lastName']")).clear();
		
		sleepInSecond(20);
		driver.findElement(By.xpath("//input[@name= 'firstName']")).sendKeys(editFirstName);
		driver.findElement(By.xpath("//input[@name= 'middleName']")).sendKeys(editMidName);
		driver.findElement(By.xpath("//input[@name= 'lastName']")).sendKeys(editLastName);
		sleepInSecond(5);
		
		driver.findElement(By.xpath("//button[text() = ' Save ']"));
		sleepInSecond(5);
		
		//Vertify gia tri sau khi edit
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name= 'firstName']")).getAttribute("_value"),firstName + editFirstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name= 'middleName']")).getAttribute("_value"),midName + editMidName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name= 'lastName']")).getAttribute("_value"),lastName + editLastName);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"),employyeID);
		
		driver.findElement(By.xpath("//a[text() = 'Immigration']")).click();
		driver.findElement(By.xpath("//button[text() = ' Add ']")).click();
	
		
		
		
		
		
		
	}

	@Test
	public void TC_02() {
		
	}

	@Test
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

