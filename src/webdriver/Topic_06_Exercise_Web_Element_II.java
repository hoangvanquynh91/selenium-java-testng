package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Exercise_Web_Element_II {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	By emailTextBox = By.id("mail");
	By ageUnder18Radio = By.cssSelector("#under_18");
	By ageDisable = By.cssSelector("#radio-disabled");
	By educationTextarea = By.cssSelector("#edu");
	By nameUser5Text = By.xpath("//h5[text()='Name: User5']");
	By biographyTextarea = By.cssSelector("#bio");
	By jobRole1 = By.cssSelector("#job1");
	By jobRole2 = By.cssSelector("#job2");
	By jobRole3 = By.cssSelector("#job3");
	By develop = By.cssSelector("#development");
	By slider1 = By.cssSelector("#slider-1");
	By disablePass = By.cssSelector("#disable_password");
	By diableRadio = By.cssSelector("#radio-disabled");
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	/*
	@Test
	public void TC_01() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Textbox
		if(driver.findElement(emailTextBox).isDisplayed()) {
			driver.findElement(emailTextBox).sendKeys("Quynh@gmail.com");
			System.out.println("Element is display");
		}else {
			System.out.println("Element is not display");
		}
		
		
		//Textarea
		if (driver.findElement(educationTextarea).isDisplayed()) {
			driver.findElement(emailTextBox).sendKeys("Quynh@gmail.com");
			System.out.println("Element is display");
		}else {
			System.out.println("Element is not display");
		}
		
		//radio
		if(driver.findElement(ageUnder18Radio).isDisplayed()) {
			driver.findElement(ageUnder18Radio).click();
			System.out.println("Element is display");
		}else {
			System.out.println("Element is not display");
		}
		if(driver.findElement(ageDisable).isDisplayed()) {
			System.out.println("Element is display");
		}else {
			System.out.println("Element is not display");
		}
		
		//User5
		if (driver.findElement(nameUser5Text).isDisplayed()) {
			System.out.println("Element is display");
		} else {
			System.out.println("Element is not display");
		}
	}


	@Test
	public void TC_02() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Email
		if(driver.findElement(emailTextBox).isEnabled()) {
			System.out.println("Email is enable");
		}else {
			System.out.println("Email is not enable");
		}
		
		//Education
		if(driver.findElement(educationTextarea).isEnabled()) {
			System.out.println("Education is enable");
		}else {
			System.out.println("Education is not enable");
		}
		
		//radio
		if(driver.findElement(ageUnder18Radio).isEnabled()) {
			System.out.println("Radio is enable");
		}else {
			System.out.println("Radio is disable");
		}
		
		//jobRole1
		if(driver.findElement(jobRole1).isEnabled()) {
			System.out.println("JobRole1 is enable");
		}else {
			System.out.println("JobRole1 is disable");
		}
		
		//jobRole2
		if(driver.findElement(jobRole2).isEnabled()) {
			System.out.println("JobRole2 is enable");
		}else {
			System.out.println("JobRole2 is disable");
		}
		
		//develop
		if(driver.findElement(develop).isEnabled()) {
			System.out.println("Development is enable");
		}else {
			System.out.println("Development is disable");
		}
		
		
		//slider1
		if(driver.findElement(slider1).isEnabled()) {
			System.out.println("Slider 1 is enable");
		}else {
			System.out.println("Slider 1 is disable");
		}
		
		//disablePass
		if(driver.findElement(disablePass).isEnabled()) {
			System.out.println("Password is enable");
		}else {
			System.out.println("Password is disable");
		}
		
		//diableRadio
		if(driver.findElement(diableRadio).isEnabled()) {
			System.out.println("Radio is enable");
		}else {
			System.out.println("Radio is disable");
		}
		
		//biographyTextarea
		if(driver.findElement(biographyTextarea).isEnabled()) {
			System.out.println("Biography is enable");
		}else {
			System.out.println("Biography is disable");
		}
		
		
		//jobRole3
		if(driver.findElement(jobRole3).isEnabled()) {
			System.out.println("JobRole3 is enable");
		}else {
			System.out.println("JobRole3 is disable");
		}
		
	   }


	@Test
	public void TC_03_Selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		
		//vertify checkbox, 
		Assert.assertFalse(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("#java")).isSelected());
		
		
		driver.findElement(ageUnder18Radio).click();
		driver.findElement(By.cssSelector("#java")).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("#java")).isSelected());
		
	}
	
*/	
	@Test
	public void TC_04_MailChimp() {
		
		driver.get("https://login.mailchimp.com/signup/post");
		
		driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("johnwick2022@gmail.com");
		
		By passwordTextbox = By.id("new_password");
		By signupButton = By.id("create-account-enabled");
		
		driver.findElement(passwordTextbox).sendKeys("abc");
		//driver.findElement(signupButton).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = '8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("ABC");
		//driver.findElement(signupButton).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = '8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("123");
		//driver.findElement(signupButton).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = '8-char not-completed']")).isDisplayed());
		
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("@@@");
		//driver.findElement(signupButton).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = '8-char not-completed']")).isDisplayed());
		
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("abcfhhgrt");
		//driver.findElement(signupButton).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = 'special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class = '8-char completed']")).isDisplayed());
		
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("abcABC#@!1");
		//driver.findElement(signupButton).click();
		sleepInSecond(3);
		
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class = 'lowercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class = 'uppercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class = 'number-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class = 'special-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class = '8-char completed']")).isDisplayed());
		
		
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