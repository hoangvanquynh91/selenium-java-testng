package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Alert {
	WebDriver driver;
	Alert alert;
	
	String projectPath = System.getProperty("user.dir");
	//String homePageUrl;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		sleepInSecond(3);
		alert = driver.switchTo().alert();
		
		//switch sang alert (alert đã xuất hiện)
//		alert.accept();//Accept 1 alert
//		alert.dismiss();// Cancel 1 alert
//		alert.sendKeys("");
//		alert.getText(); // lấy ra title của alert
		
		//Verify alert title trước khi accept alert
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		
		alert.accept();
		//verify accept thành công
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked an alert successfully");
		
		
		
		
	}


	public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		alert = driver.switchTo().alert();
		
		//Verify alert title
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		
		//Cancel alert
		alert.dismiss();
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked: Cancel");
		
	}


	public void TC_03_Prompt_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		alert = driver.switchTo().alert();
		
		//Verify alert tittle
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		
		//Send text for alert
		String keyword = "Hoang Van Quynh";
		alert.sendKeys(keyword);
		
		alert.accept();
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You entered: " + keyword);
		
		
		
		
	}

	public void TC_04_Accept_Alert_Login() {
		driver.get("https://demo.guru99.com/v4");
		
		driver.findElement(By.name("btnLogin")).click();
		sleepInSecond(3);
		
		alert = driver.switchTo().alert();
		
		//Verify title
		Assert.assertEquals(alert.getText(), "User or Password is not valid");
		
		alert.accept();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/v4/index.php");
		
	}
	
	

	public void TC_05_Authentication_Alert() {
		//Selenium  ver2.x có hàm trong thư việc alert để xử lý loại này nhưng không hoạt động do hàm này ở bản BETA
		// Pass hẳn user và pasword vào Url trước khi open nó ra.
		//Url: http://the-internet.herokuapp.com/basic_auth
		//Pass: UserName và Password và url 
		//http://username:password@the-internet.herokuapp.com/basic_auth
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		sleepInSecond(5);
		
		Assert.assertTrue(driver.findElement(By.cssSelector("div.example>p")).getText().contains("Congratulations! You must have the proper credentials."));
		
		
		
		
	}
	
	@Test
	public void TC_06_Authentication_Alert() {
		
		driver.get("http://the-internet.herokuapp.com");
		sleepInSecond(5);
		
		String basicAuthenUrl = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
		driver.get(getAuthenticationUrl(basicAuthenUrl, "admin", "admin"));
		
		sleepInSecond(5);
		
		Assert.assertTrue(driver.findElement(By.cssSelector("div.example>p")).getText().contains("Congratulations! You must have the proper credentials."));
		
	}
	public String getAuthenticationUrl(String basicAuthenUrl, String username, String password) {
		String[] authenArray = basicAuthenUrl.split("//");
		return basicAuthenUrl = authenArray[0] + "//" + username + ":" + password +"@" + authenArray[1];
		
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
