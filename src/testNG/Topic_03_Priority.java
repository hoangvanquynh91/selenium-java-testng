package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_03_Priority {
	// Thứ tự chạy của testcase
	// 0-> 9
	// A->Z
	// Để set thứ tự chạy testcase có thể sử dụng từ khóa @Test(priority = 1,2,3,4...)
	
	@Test(enabled = false)
	public void User_01_Create() {
		
	}
	@Test
	public void User_02_Update() {
		
	}
	@Test
	public void User_03_Delete() {
		
	}
	@Test
	public void User_04_View() {
		
	}
	@Test
	public void User_05_View() {
		
	}
	@Test
	public void User_06_View() {
		
	}
	@Test
	public void User_07_View() {
		
	}
	@Test
	public void User_08_View() {
		
	}
	@Test
	public void User_09_View() {
		
	}
	@Test
	public void User_10_View() {
		
	}
	@Test
	public void User_11_View() {
		
	}

}
