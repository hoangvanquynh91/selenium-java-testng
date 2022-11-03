package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Actions {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Actions action;
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		action = new Actions(driver);
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	public void TC_01_Hover() {
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		
		//Hover vào element
		action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
		
		// Không nên sử dụng chuột và bàn phím khi chạy test nhất là đối với những case liên quan đến thư viện actions
		
	}

	public void TC_02_Hover() {
		driver.get("https://www.myntra.com/");
		sleepInSecond(8);
		//Hover vaof kids menu
		action.moveToElement(driver.findElement(By.xpath("//header[@id='desktop-header-cnt']//a[text()='Kids']"))).perform();
		sleepInSecond(5);
		action.click(driver.findElement(By.xpath("//header[@id='desktop-header-cnt']//a[text()='Home & Bath']"))).perform();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("span.breadcrumbs-crumb")).getText(), "Kids Home Bath");
		
		
	}

	public void TC_03_Hover() {
		driver.get("https://www.fahasa.com/");
		action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
		
		action.click(driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text()='Kỹ Năng Sống']"))).perform();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.xpath("//ol[@class='breadcrumb']/li/strong[text()='Kỹ năng sống']")).getText(), "KỸ NĂNG SỐNG");	
		
	}
	
	
	public void TC_04_Click_And_Hover_Block() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		List<WebElement> listNumber = driver.findElements(By.cssSelector("ol#selectable>li"));
		//- Click vào số bắt đầu và giữ chuột trái
		//- Di chuột đến số kết thúc
		//- Nhả chuột trái ra
		
		action.clickAndHold(listNumber.get(0)).moveToElement(listNumber.get(11)).release().perform();
		sleepInSecond(5);
		
//		List<WebElement> listNumberselected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
//		
//		
//		Assert.assertEquals(listNumberselected.size(), 6);
//		
//		
//		//define ra 1 mảng chứa text mình cần verify
//		String[] listNumberSelectedActual = {"1","2","5","6","9","10"};
//		
//		//Khai báo 1 ArrayList để lưu giá trị get được ở list bên trên (listBlockselected)
//		ArrayList<String> listNumberSelectedExpected = new ArrayList<String>();
//		
//		for (WebElement number : listNumberselected) {
//			listNumberSelectedExpected.add(number.getText());
//			
//		}
//		
//		Assert.assertEquals(listNumberSelectedExpected, Arrays.asList(listNumberSelectedActual));
		
	}
	

	public void TC_05_Click_And_Hover_Random() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		List<WebElement> listNumber = driver.findElements(By.cssSelector("ol#selectable>li"));
		//ấn phím CONTROL
		action.keyDown(Keys.CONTROL).perform();
		
		action.click(listNumber.get(1))
		.click(listNumber.get(3))
		.click(listNumber.get(4))
		.click(listNumber.get(6))
		.click(listNumber.get(10))
		.perform();
		
		//nhả phím CONTROL
		action.keyDown(Keys.CONTROL).perform();
		
		List<WebElement> listNumberselected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
		
		
		Assert.assertEquals(listNumberselected.size(), 5);
	}
	
	@Test
	public void TC_06_Double_Click() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
//		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[text()='Double click me']")));
//		sleepInSecond(3);
		
		action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
		sleepInSecond(3);
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='demo']")).getText(), "Hello Automation Guys!");
		
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
