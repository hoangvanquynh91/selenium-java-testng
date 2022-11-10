package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_24_ExplicitWait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait explicitWait;
	String iphone11 = "iphone11.jpeg";
	String iphone12 = "iphone12.jpg";
	String iphone13 = "iphone13.jpg";
	
	String pathIphone11 = projectPath +"\\fileupload\\" + iphone11;
	String pathIphone12 = projectPath +"\\fileupload\\" + iphone12;
	String pathIphone13 = projectPath +"\\fileupload\\" + iphone13;


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	public void TC_01_Ajax_Loading() {
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		explicitWait = new WebDriverWait(driver, 15);
		
		//Wait cho date Picker được hiển thị
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.RadCalendar")));
		
		//Verify cho selected date không có ngày nào được chọn
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "No Selected Dates to display.");
		
		//Wait cho ngày 9 được phép click
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='9']")));
		//Click vao ngay 9
		driver.findElement(By.xpath("//a[text()='9']")).click();
		
		
		//Wait cho ajax icon biến mất
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));
		//Wait cho đến ngày vừa click có thể click able
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='rcSelected']/a[text()='9']")));
		//Verify selected date
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']")).getText(), "Wednesday, November 9, 2022");	
		
	}

	@Test
	public void TC_02_Upload_File() {
		driver.get("https://gofile.io/uploadFiles");
		explicitWait = new WebDriverWait(driver, 60);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#rowUploadButton button.uploadButton")));
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(pathIphone11 + "\n" + pathIphone12 + "\n" + pathIphone13);
		
		//Wait cho loading icon của từng file biến mất
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div#rowUploadProgress div.progress"))));
		
		//Wait cho uploaded messsage thành công được hiển thị
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Your files have been successfully uploaded']")));
		
		Assert.assertTrue(driver.findElement(By.xpath("//h5[text()='Your files have been successfully uploaded']")).isDisplayed());
		
		//Wait button showfile có thể click
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='rowUploadSuccess-showFiles']")));
		
		driver.findElement(By.xpath("//button[@id='rowUploadSuccess-showFiles']")).click();
		
		
		//Wait cho đến khi button download được hiển thị
		//explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+iphone11+"']/parent::a/parent::div/following-sibling::div//button[@id='contentId-download']")));
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//span[text()='"+iphone11+"']/parent::a/parent::div/following-sibling::div//button[@id='contentId-download']"))).isDisplayed());
		
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//span[text()='"+iphone12+"']/parent::a/parent::div/following-sibling::div//button[@id='contentId-download']"))).isDisplayed());
		
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//span[text()='"+iphone13+"']/parent::a/parent::div/following-sibling::div//button[@id='contentId-download']"))).isDisplayed());
		
		
		
		
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

