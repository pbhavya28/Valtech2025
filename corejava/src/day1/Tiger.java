package day1;

public class Tiger implements Animal {

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Roar...");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Deer Meat...");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("Snore...");
	}
	public static void main(String[] args) {
		System.out.println(ZERO);
		Tiger tiger1 = new Tiger();
		tiger1.eat();
	}
}
