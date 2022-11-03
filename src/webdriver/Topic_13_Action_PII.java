package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Action_PII {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Actions action;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	public void TC_01_Right_Click() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		//Click chuột phải vào button
		action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
		sleepInSecond(3);
		
		//Hover chuột và paste
		action.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
		
		//Verify Paste có trạng thái là Hover, Visible
		Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-paste.context-menu-hover.context-menu-visible")).isDisplayed());
		
		//Click vaof Paste
		action.click(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
		
		driver.switchTo().alert().accept();
		
		//Verify Paste có trạng thái là InVisible
		Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());
			
		
	}

	@Test
	public void TC_02_Drag_Drop_HTML4() {
		driver.get("https://automationfc.github.io/kendo-drag-drop/");
		WebElement smallCricle = driver.findElement(By.cssSelector("div#draggable"));
		WebElement bigCricle = driver.findElement(By.cssSelector("div#droptarget"));
		
		action.dragAndDrop(smallCricle, bigCricle).perform();
		sleepInSecond(3);
		
		Assert.assertEquals(bigCricle.getText(), "You did great!");
		
		
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

