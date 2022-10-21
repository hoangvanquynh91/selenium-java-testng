package webdriver;

import java.util.Random;

public class Topic_04_Random_Number {
	public static void main(String[] args) {
		Random rand = new Random();
		
		String emailAddress;
		System.out.println(emailAddress = "Davidray" + rand.nextInt(9999) + "@hotmail.com");
	}

}
