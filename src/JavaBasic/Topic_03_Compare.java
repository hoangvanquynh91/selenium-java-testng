package JavaBasic;

import java.util.Iterator;

public class Topic_03_Compare {
	
	//Primitive type / value type : Kiểu dữ liệu nguyên thủy
	byte BNumber = 1;
	short sNumber;
	
	long lNumber;
	float fNumber;
	double dnumber;
	char cChar;
	
	
	
	
	//Reference type : Kiểu dữ liệu tham chiếu
	
	public static void main(String[] args) {
		
		int iNumber = 10;
		int iNumber1 = 20;
		iNumber = iNumber1;
		iNumber1 = 30;
		System.out.println(iNumber);
		System.out.println(iNumber1);
		
		
		Integer iNumber3 = 10;
		Integer iNumber4 = 20;
		iNumber3 = iNumber4;
		iNumber4 = 30;
		System.out.println(iNumber3);
		System.out.println(iNumber4);
		
	}
	

}
