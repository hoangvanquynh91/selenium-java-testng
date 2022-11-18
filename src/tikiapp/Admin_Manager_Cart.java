package tikiapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	
	

	public class Admin_Manager_Cart {
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");
	
	@BeforeTest(alwaysRun = true)
	public void initBrower() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
			
	}
		
	@Test(groups = {"admin","Cart"})
	public void Cart_Add() {
		System.out.println("Cart_Add");
		
	}
	@Test(groups = {"admin","Cart"})
	public void Cart_Update() {
		System.out.println("Cart_Update");
		
	}
	@Test(groups = {"admin","Cart"})
	public void Cart_Delete() {
		System.out.println("Cart_Delete");
		
	}
	@Test(groups = {"admin","Cart"})
	public void Cart_View() {
		System.out.println("Cart_View");
		
	}
	
	@AfterTest(alwaysRun = true)
	public void cleanBrower() {
		driver.quit();
	}
	
}
