package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_08_Depend {
	@Test
	public void Product_Create() {
		Assert.assertTrue(false);
		
	}
	@Test(dependsOnMethods = "Product_Create")
	public void Product_Read() {
		System.out.println("Product_View");
		
	}
	@Test(dependsOnMethods = "Product_Read")
	public void Product_Update() {
		System.out.println("Product_Update");
		
	}
	@Test(dependsOnMethods = "Product_Update")
	public void Product_Delete() {
		System.out.println("Product_Delete");
		
	}
	
	

}
