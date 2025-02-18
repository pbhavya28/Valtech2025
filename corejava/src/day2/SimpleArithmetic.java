package day2;

public class SimpleArithmetic implements Arithmetic {

	@Override
	public double add(double a, double b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public double sub(double a, double b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public double mul(double a, double b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public double div(double a, double b) {
		// TODO Auto-generated method stub
		return a / b;
	}
	
	public static void main(String[] args) {
		SimpleArithmetic simpleArt  =new SimpleArithmetic();
		System.out.println(simpleArt.add(3,5));
		System.out.println(simpleArt.sub(3,5));
		System.out.println(simpleArt.mul(3,5));
		System.out.println(simpleArt.div(3,5));
	}

	@Override
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		return a / b;
	}
	

}
