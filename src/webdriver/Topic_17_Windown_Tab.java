package webdriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Windown_Tab {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	public void TC_01() {
		//Parent Page
		driver.get("https://automationfc.github.io/basic-form/");
		
		//Window, Tab có 2 hàm để lấy ra ID
		
		//Case 1: Chỉ có 2 Windown hoặc 2 Tab
		//1 Lấy ra ID ccuar Tab hoặc Windown mà nó đang đứng
		//String parentPageWindownID = driver.getWindowHandle();
		
		// Click vào google link để bật ra 1 tab mới
		driver.findElement(By.xpath("//a[text() = 'GOOGLE']")).click();
		sleepInSecond(2);
		
		//switchToWindowByID(parentPageWindownID);
		switchToWindownByPageTitle("Google");
		sleepInSecond(3);
		
		//2 Lấy ra tất cả cả ID
		// Dùng vòng lặp để duyệt
		// Trường hợp ID không trùng với parentID thì switch qua
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com.vn/");
		//String childPageWindownID = driver.getWindowHandle();
		
		//switchToWindowByID(childPageWindownID);
		switchToWindownByPageTitle("SELENIUM WEBDRIVER FORM DEMO");
		sleepInSecond(2);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/");
		
		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
		
		switchToWindownByPageTitle("Facebook - Đăng nhập hoặc đăng ký");
		sleepInSecond(3);
		driver.findElement(By.cssSelector("input#email")).sendKeys("Quynh@gmal.com");
		driver.findElement(By.cssSelector("input#pass")).sendKeys("123456789");
		
		switchToWindownByPageTitle("SELENIUM WEBDRIVER FORM DEMO");
		sleepInSecond(2);
		
		driver.findElement(By.xpath("//a[text()='TIKI']")).click();

		
		// Set ko cho phép trùng
		// List cho phép trùng, Null
		
		
		
		//Case 2 : Có nhiều 2 Window hoặc 2 Tab
		
		
	}

	@Test
	public void TC_02() {
		driver.get("http://live.techpanda.org/index.php/mobile.html");
		driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Sony Xperia has been added to comparison list.");
		
		driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Samsung Galaxy has been added to comparison list.");
		
		driver.findElement(By.xpath("//button[@title='Compare']")).click();
		
		switchToWindownByPageTitle("Products Comparison List - Magento Commerce");
		sleepInSecond(2);
		
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Compare Products']")).isDisplayed());
		
		driver.findElement(By.xpath("//button[@title='Close Window']")).click();
		
		switchToWindownByPageTitle("Mobile");
		
		driver.findElement(By.xpath("//h2[@class='product-name']/a[@title='IPhone']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='product-name']/span")).getText(), "IPHONE");
		
		
		
		
	}

	
	public void TC_03() {
		
	}
	
	public void switchToWindowByID(String otherID) {
		Set<String> allWindownIDs = driver.getWindowHandles();
		
		for (String id : allWindownIDs) {
			if(!id.equals(otherID)) {
				driver.switchTo().window(id);
				sleepInSecond(2);
			}
		}
	
	}
	
    public void switchToWindownByPageTitle(String expectedPageTitle) {
    	Set<String> allWindownTitle = driver.getWindowHandles();
    	for (String id : allWindownTitle) {
    		//Switch vao tung ID
			driver.switchTo().window(id);
			sleepInSecond(2);
			//Get title của từng Page
			String actualTitle = driver.getTitle();
			if(actualTitle.equals(expectedPageTitle)) {
				break;
			}
			
		}
    }
    
    public void closeWindownWithoutParent(String parentID) {
    	Set<String> allWindownID = driver.getWindowHandles();
    	
    	for (String id : allWindownID) {
    		if(!id.equals(parentID)) {
    			driver.switchTo().window(id);
        		driver.close();
        		sleepInSecond(3);
    		}
    		
			
		}
    	driver.switchTo().window(parentID);
    	
    	
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
