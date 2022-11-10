package webdriver;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_25_ImplicitWait_ExplicitWait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait explicitWait;
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		
	}

	
	public void TC_01_Element_Found() {
		// Element xuất hiện không cần chờ hết timeout
		// Dù có set cả 2 loại wait thì cũng ko ảnh hưởng
		explicitWait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//ImplicitWait chỉ apply cho viên find Element findElement/ findElements
		//ExplicitWait dùng cho các điều kiện của Element
		
		driver.get("https://www.facebook.com/");
		//ExxplicitWait
		System.out.println("Start time : " + getTimeStamp());
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
		System.out.println("End Time : " + getTimeStamp());
		
		//ImplicitWait
		System.out.println("Start time : " + getTimeStamp());
		driver.findElement(By.cssSelector("input#email"));
		System.out.println("End Time : " + getTimeStamp());
		
	}
	
	

	
	public void TC_02_Element_Not_Found_ImplicitWait() {
		//3.1 Implicit = explicit
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		//ImplicitWait
		System.out.println("Start time : " + getTimeStamp());
		try {
			driver.findElement(By.cssSelector("input#selenium"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("End Time : " + getTimeStamp());
		}
		
		//Output : 
		// Có cơ chế tìm lại sau mỗi nửa giây (0.5s)
		// Khi hết timeout sẽ thực hiện đánh fail testcase này
		// Throw ra 1 exception : NóuchElement
		
		
		
	}


	public void TC_03_Element_Not_Found_Implicit_Explicit() {
		// 1. Implicit = Explicit
		// 2. Implicit > Explicit
		// 3. Implicit < Explicit
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 7);
		
		driver.get("https://www.facebook.com/");
//		System.out.println("Start time im : " + getTimeStamp());
//		try {
//			driver.findElement(By.cssSelector("input#selenium"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("End Time im : " + getTimeStamp());
//		}
		
		//ExxplicitWait
		System.out.println("Start time ex : " + getTimeStamp());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#selenium")));
		} catch (NoSuchElementException noSuchException) {
			// TODO Auto-generated catch block
			System.out.println("End Time explicit - no such element: " + getTimeStamp());
		} catch(TimeoutException timeoutException){
			System.out.println("End Time explicit - timeout Exception : " + getTimeStamp());
		}
		
		
		
	}
	
	
	public void TC_04_Element_Not_Found_Explicit() {
		explicitWait = new WebDriverWait(driver, 5);
		driver.get("https://www.facebook.com/");
		// Explicit -By là tham số nhận vào của hàm explicit - visibilityOfElemementLocated(By)
		// Implicit =0
		// Tổng thời gian timeout = thời gian của explicit
		
		System.out.println("Start time ex : " + getTimeStamp());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#selenium")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("End Time explicit - no such element: " + getTimeStamp());
		}
		
	}
	
	@Test
	public void TC_05_Element_Not_Found_Explicit_Element() {
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 5);
		driver.get("https://www.facebook.com/");
		
		System.out.println("Start time ex : " + getTimeStamp());
		try {
			explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#selenium"))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("End Time explicit - no such element: " + getTimeStamp());
		}
		
	}
	
	public void sleepInSecond (long timeSecond) {
		try {
			Thread.sleep(timeSecond * 1000);
		}catch (InterruptedException e ) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public String getTimeStamp() {
		Date date = new Date();
		return date.toString();
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
