package tikiuser;

import org.testng.annotations.Test;

public class User_Order {
	@Test(groups = "user")
	public void Order_Add() {
		System.out.println("Order_Add");
	}
	@Test(groups = "user")
	public void Order_Update() {
		System.out.println("Order_Update");
	}
	@Test(groups = "user")
	public void Order_Delete() {
		System.out.println("Order_Delete");
	}
	@Test(groups = "user")
	public void Order_View() {
		System.out.println("Order_View");
	}

}
