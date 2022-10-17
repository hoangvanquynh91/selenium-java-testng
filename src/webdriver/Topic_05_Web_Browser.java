package webdriver;

import java.lang.StackWalker.Option;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}
	// Tương tác với browser sẽ thông qua biến WebDriver driver
	// Tương tác với Element thì sẽ thông qua biến WebElement element
	// Tip 1 cứ hàm nào action thì không trả về (click, nhập, chọn, accept, hover, refresh, back, forwward)
	// Tip 2 cứ hàm nào lấy dữ liệu thì cần trả về (get Url, title, ID, WWindow, text, attribute, css, value...)

	@Test
	public void TC_01() {
		// Trường hợp >=2 sẽ đóng tab/ window mà nó đang đứng
		driver.close();
		// Đóng hết các tab/window đang mở
		driver.quit();
		
		driver.findElement(By.xpath(""));
		driver.getPageSource();
		
		Options opt = driver.manage();
	    Timeouts time = opt.timeouts();
		// Khoảng thời gian chờ element xuất hiện trong x giây
	    time.implicitlyWait(5, TimeUnit.SECONDS);
	    
	    // Khoảng thời gian chờ page được load xong
	    time.pageLoadTimeout(5, TimeUnit.SECONDS);
	    
	    // Khoảng thời gian chờ script được thực thi xong
	    time.setScriptTimeout(5, TimeUnit.SECONDS);
		
	    Window win = opt.window();
	    win.maximize();
	    win.getPosition();
	    win.setPosition(null);
	    win.setSize(null);
	    
	    Navigation nav = driver.navigate();
	    nav.refresh();
	    nav.back();
	    nav.forward();
	    
	    nav.to(""); // == driver.get
	    
	    driver.switchTo();
	    TargetLocator tar = driver.switchTo();
		
	}

	@Test
	public void TC_02() {
		
	}

	@Test
	public void TC_03() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
