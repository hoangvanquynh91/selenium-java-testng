package JavaBasic;

public class Topic_01_Variable {
	static String stdName ="Quynh";
	String comName = "Nittsu";
	static int Number;
	
	public Topic_01_Variable() {
		
	}
	
	public static void main(String[] args) {
		String stdName = "QuynhHV";
		
		System.out.println(stdName);
		Topic_01_Variable topic01 = new Topic_01_Variable();
		System.out.println(topic01.comName);
		System.out.println(Topic_01_Variable.stdName);
		System.out.println(Number);
		
	}
	

}
