package webdriver;


import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Default_Dropdown {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Select select;
	JavascriptExecutor jsExcutor;
	Random rand = new Random();
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		//khoi tao jsExcutor
		jsExcutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
/*
	@Test
	public void TC_01_Default_Dropdow() {
		driver.get("https://demo.nopcommerce.com/");
		
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		
		//Input thong tin dang ky
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("David");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Ray");
		//Thao tac voi dropdown
		// Thao tác với day dropdown
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthDay']")));
		select.selectByVisibleText("6");
		
		// Thao tác với month dropdown
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthMonth']")));
		select.selectByVisibleText("March");
		
		// Thao tác với year dropdown
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthYear']")));
		select.selectByVisibleText("1995");
		
		String emailAddress = "Davidray" + rand.nextInt(9999) + "@hotmail.com";
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Company")).sendKeys("Nash");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		
		
		driver.findElement(By.cssSelector("button#register-button")).click();
		sleepInSecond(1);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
		
		driver.findElement(By.cssSelector("a.ico-account")).click();
		
		//Vertify
		Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), "David");
		Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), "Ray");
		//day
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthDay']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "6");
		
		//month
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthMonth']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "March");
		
		//year
		select = new Select(driver.findElement(By.cssSelector("select[name = 'DateOfBirthYear']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "1995");
		
		Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);
		Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), "Nash");

	}
*/

	@Test
	public void TC_02() {
		driver.get("https://rode.com/en/support/where-to-buy");
		
		scrollToElement("div.rode-text ");
		sleepInSecond(3);
		
		select = new Select(driver.findElement(By.cssSelector("select#country")));
		select.selectByVisibleText("Vietnam");
		sleepInSecond(3);
		
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Vietnam");
		
		List<WebElement> dealers = driver.findElements(By.cssSelector("div#map h4"));
		
		for(WebElement element : dealers) {
			System.out.println(element.getText());
		}
		
		
		
		
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
	
	public void scrollToElement(String cssLocator) {
		
		jsExcutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(cssLocator)));
		
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
