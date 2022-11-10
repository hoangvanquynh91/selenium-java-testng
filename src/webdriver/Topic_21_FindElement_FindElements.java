package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_21_FindElement_FindElements {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		//Apply 10s cho việc tìm element
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_FindElement() {
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		
		//1.Tìm thấy duy nhất 1 element /node
		// Thao tác trực tiếp lên node đấy
		// Vì nó tìm thấy nên ko cần phải chờ hết timeout (10)
		driver.findElement(By.cssSelector("input#email"));
		
		//2.Tìm thấy nhiều hơn 1 node
		// thao tác với node đầu tiên
		// Không quan tâm đến các node còn lại
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Quynh");
		
		//3.Không tìm thấy node nào
		// Có cơ chế tìm lại
		// Nếu trong thời gian mà tìm thấy element thì thỏa mãn điều kiên -> Pass
		// Trường hợp hết thời gian mà không tìm thấy 
		// Đánh fail test case tại bước này luôn
		// Throw ra ngoại lệ
		
		
	}

	@Test
	public void TC_02_FindElements() {
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		//1.Tìm thấy duy nhất 1 element /node
		List<WebElement> emailTextBox = driver.findElements(By.cssSelector("input#email"));
		System.out.println(emailTextBox.size());
		
		//2.Tìm thấy nhiều hơn 1 node
		// Tìm thấy thì sẽ lưu vào list tương ứng
		List<WebElement> elements = driver.findElements(By.xpath("//input[@type='email']"));
		System.out.println(elements.size());
		
		//3.Không tìm thấy node nào
		// Có cơ chế tìm lại
				// Nếu trong thời gian mà tìm thấy element thì thỏa mãn điều kiên -> Pass
				// Trường hợp hết thời gian mà không tìm thấy 
				// Không đánh fail test case
		// Trả về 1 list rỗng (Empty) = 0
		
		
		
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
