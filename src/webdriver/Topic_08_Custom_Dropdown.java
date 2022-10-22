package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.Locator;

public class Topic_08_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait explicitWait;
	Select select;
	JavascriptExecutor jsExcutor;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		//Khoi tao wait
		explicitWait = new WebDriverWait(driver, 30);
		
		//khoi tao jsExcutor
		jsExcutor = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	/*
	@Test
	public void TC_01_jQuery() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
	
		//Click vao 1 phần tử để hiện ra dropdow
		driver.findElement(By.cssSelector("span#number-button")).click();
		
		//Chờ tất cả item được load ra xong
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));
		//Viết code để duyệt qua từng item và kiểm tra điều kiện
		// Duyệt qua từng item để kiểm tra text - nếu đúng text mình muốn thì click vào
		//1. Lưu trữ tất cả các item -> Thì mới có thể duyệt qua được
		List<WebElement> allItem = driver.findElements(By.cssSelector("ul#number-menu div"));
		
		//Duyệt qua từng item
		for (WebElement item : allItem) {
			//Lấy ra text
			String textItem = item.getText();
			
			if (textItem.equals("10")) {
				item.click();
			}
		}
		selectItemInDropdown("span#number-button", "ul#number-menu div", "10");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "10");
		
		selectItemInDropdown("span#speed-button", "ul#speed-menu div", "Fast");
		sleepInSecond(2);
		
	}

	@Test
	public void TC_02_Honda() {
		driver.get("https://www.honda.com.vn/o-to/du-toan-chi-phi");
		
		scrollToElement("div.carousel-item");
		sleepInSecond(3);
		//driver.manage().window().setSize(null);
		
		selectItemInDropdown("button#selectize-input", "button#selectize-input +div>a", "CITY L (Đỏ)");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("button#selectize-input")).getText(), "CITY L (Đỏ)");
		
		select = new Select(driver.findElement(By.cssSelector("select#province")));
		select.selectByVisibleText("Bắc Kạn");
		sleepInSecond(3);
		
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Bắc Kạn");
		
		select = new Select(driver.findElement(By.cssSelector("select#registration_fee")));
		select.selectByVisibleText("Khu vực II");
		sleepInSecond(3);
		
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Khu vực II");
		
		
	}

	@Test
	public void TC_03_React() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		selectItemInDropdown("div.dropdown","div.menu span","Jenny Hess");
		
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Jenny Hess");
		
		
		
	}

	@Test
	public void TC_04_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		
		selectItemInDropdown("div.btn-group", "ul.dropdown-menu a", "First Option");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "First Option");
		
		selectItemInDropdown("div.btn-group", "ul.dropdown-menu a", "Second Option");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");
		
		selectItemInDropdown("div.btn-group", "ul.dropdown-menu a", "Third Option");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Third Option");
		
		
	}
	*/	
	@Test
	public void TC_05_Reactable() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		editItemInDropdown("input.search","div.menu span.text","Aland Islands");
		
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Aland Islands");
		
		
		
	}
	
	public void sleepInSecond (long timeSecond) {
		try {
			Thread.sleep(timeSecond * 1000);
		}catch (InterruptedException e ) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	public void selectItemInDropdown(String parentLocator, String childLocator, String ExpectedLocator) {
        driver.findElement(By.cssSelector(parentLocator)).click();
		
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		List<WebElement> allItem = driver.findElements(By.cssSelector(childLocator));
		
		for (WebElement item : allItem) {
			String textActualItem = item.getText();
			if (textActualItem.equals(ExpectedLocator)) {
				item.click();
				break;
			}
		}
		
	}
	
	public void editItemInDropdown(String parentLocator, String childLocator, String ExpectedLocator) {
        driver.findElement(By.cssSelector(parentLocator)).sendKeys(ExpectedLocator);;
		sleepInSecond(2);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		List<WebElement> allItem = driver.findElements(By.cssSelector(childLocator));
		
		for (WebElement item : allItem) {
			String textActualItem = item.getText();
			if (textActualItem.equals(ExpectedLocator)) {
				item.click();
				break;
			}
		}
		
	}
	public void scrollToElement(String cssLocator) {
		
		jsExcutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(cssLocator)));
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
