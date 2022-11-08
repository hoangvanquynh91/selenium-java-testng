package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Upload_File {
	WebDriver driver;
	JavascriptExecutor jsEcutor;
	String projectPath = System.getProperty("user.dir");
	
	
	
	String compuFileName = "computer.jpg";
	String mountainFileName = "mountain.jpg";
	String mouLanCapeName = "mountainlandca.jpg";
	
	String comfilePath = projectPath +"\\fileupload\\" + compuFileName;
	String moufilePath = projectPath +"\\fileupload\\" + mountainFileName;
	String moucapfilePath = projectPath +"\\fileupload\\" + mouLanCapeName;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		jsEcutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	public void TC_01_One_File_Per_Time() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(comfilePath);
		sleepInSecond(1);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(moufilePath);
		sleepInSecond(1);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(moucapfilePath);
		sleepInSecond(1);
		
		//Verify được load lên thành công
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + compuFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ mountainFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + mouLanCapeName + "']")).isDisplayed());
		
		// CLick UpLoad
		List<WebElement> buttonUploads = driver.findElements(By.xpath("//table//button[contains(@class,'start')]"));
		for (WebElement buttonUpload : buttonUploads) {
			buttonUpload.click();
			sleepInSecond(3);
			
		}
		
		//Verify upload thành công (link)
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + compuFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + mountainFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + mouLanCapeName + "']")).isDisplayed());
		
		//Verify upload thành công (image)
		Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + compuFileName +"')]"));
		Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + mountainFileName +"')]"));
		Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + mouLanCapeName +"')]"));
		
	}

	@Test
	public void TC_02_Upload_Multifile() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(comfilePath + "\n" + moufilePath + "\n" + moucapfilePath);
		sleepInSecond(1);
		
		
		//Verify được load lên thành công
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + compuFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ mountainFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + mouLanCapeName + "']")).isDisplayed());
		
		// CLick UpLoad
		List<WebElement> buttonUploads = driver.findElements(By.xpath("//table//button[contains(@class,'start')]"));
		for (WebElement buttonUpload : buttonUploads) {
			buttonUpload.click();
			sleepInSecond(3);
			
		}
		
		//Verify upload thành công (link)
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + compuFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + mountainFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + mouLanCapeName + "']")).isDisplayed());
		
		//Verify upload thành công (image)
		Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + compuFileName +"')]"));
		Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + mountainFileName +"')]"));
		Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + mouLanCapeName +"')]"));
		
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
	
	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) jsEcutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'underfined' && arguments[0].naturalWidth >0", getElement(locator));
		return status;
	}
	
	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
