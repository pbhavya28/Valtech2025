package day2;

public class ControlStatements {

	public void testIfElse(int a) {
		
		if(a % 2 == 0) {
			System.out.println("A is "+a + ". A is even");
		}
		else {
			System.out.println("A is "+a + ". A is odd");
		}
		
	}
	public void testfor(int[]a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public void testSwitch(int a) {
		
		switch (a) {
		
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		default:
			System.out.println("Others");
		}
	}
	
	public int add(int ... a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
		}
		System.out.println("Sum ="+ sum);
		return sum;
	}
	
	public static void main(String[] args) {
		ControlStatements cs = new ControlStatements();
		cs.testIfElse(7);
		cs.testIfElse(8);
		cs.testIfElse(0);
		cs.testfor(new int[] {1,2,3});
		cs.testfor(new int[] {4,5,6,7,8,9,0});
		cs.testSwitch(1);
		cs.testSwitch(2);
		cs.testSwitch(3);
		cs.testSwitch(144);
		cs.add(1,2,3,4);
	
}
}
