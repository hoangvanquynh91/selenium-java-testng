package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Default_Radio_Checkbox {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
/*
	@Test
	public void TC_01() {
		
		driver.get("https://automationfc.github.io/multiple-fields/");
		
		//chọn Asthma, Diabetes
		checkToCheckboxOrRadio("//label[contains(text(),'Asthma')]/preceding-sibling::input");
		checkToCheckboxOrRadio("//label[contains(text(),'Diabetes')]/preceding-sibling::input");
		
		//Verify được chọn thành công
		
		Assert.assertTrue(isElementSelected("//label[contains(text(),'Asthma')]/preceding-sibling::input"));
		Assert.assertTrue(isElementSelected("//label[contains(text(),'Diabetes')]/preceding-sibling::input"));
		
		//CHọn radio 5+ days,1-2 cups/day
		
		checkToCheckboxOrRadio("//input[@value='5+ days']");
		checkToCheckboxOrRadio("//input[@value='1-2 cups/day']");
		
		//Verify chọn thành công
		Assert.assertTrue(isElementSelected("//input[@value='5+ days']"));
		Assert.assertTrue(isElementSelected("//input[@value='1-2 cups/day']"));
		
		sleepInSecond(5);
		
		
		//bỏ chọn Asthma, Diabetes	
		uncheckToCheckboxOrRadio("//label[contains(text(),'Asthma')]/preceding-sibling::input");
		uncheckToCheckboxOrRadio("//label[contains(text(),'Diabetes')]/preceding-sibling::input");
		
		
		//Verify bỏ chọn thành công
		Assert.assertFalse(isElementSelected("//label[contains(text(),'Asthma')]/preceding-sibling::input"));
		Assert.assertFalse(isElementSelected("//label[contains(text(),'Diabetes')]/preceding-sibling::input"));
		
		
		
				
		//Bỏ CHọn radio 5+ days, chọn 1-2 days, chọn 1-2 days, 5+ cups/day
		
		
		checkToCheckboxOrRadio("//input[@value='1-2 days']");
		checkToCheckboxOrRadio("//input[@value='5+ cups/day']");
				
		//Verify chọn thành công
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='5+ days']")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='1-2 cups/day']")).isSelected());
		
	}
	*/
	
	@Test
	public void TC_02() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		List<WebElement>  allCheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement checkBox : allCheckBox) {
			checkAllToCheckbox(checkBox);
			sleepInSecond(1);
			
		}
		
		for (WebElement checkBox : allCheckBox) {
			Assert.assertTrue(isElementSelected(checkBox));
			
		}
		
		for (WebElement checkBox : allCheckBox) {
			checkAllToCheckbox(checkBox);
			sleepInSecond(1);
			
		}
		for (WebElement checkBox : allCheckBox) {
			Assert.assertFalse(isElementSelected(checkBox));
			
		}
		
	}

	
	
	
	public void checkToCheckboxOrRadio(String xpathLocator) {
		//Kiểm tra xem nó chọn hay chưa
		// Trường hợp chọn rồi -> Không click nữa
		// Trường hợp chưa chọn -> Click vào
		
		if(!driver.findElement(By.xpath(xpathLocator)).isSelected()) {
			driver.findElement(By.xpath(xpathLocator)).click();
		}
		
	}
	public void uncheckToCheckboxOrRadio(String xpathLocator) {
		if(driver.findElement(By.xpath(xpathLocator)).isSelected()) {
			driver.findElement(By.xpath(xpathLocator)).click();
		}
	}
	
	public boolean isElementSelected(String xpathLocator) {
		return driver.findElement(By.xpath(xpathLocator)).isSelected();
	}
	
	public void checkAllToCheckbox(WebElement element) {
		if(!element.isSelected()) {
			element.click();
		}else {
			element.click();
		}
	}
	
	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
		
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
