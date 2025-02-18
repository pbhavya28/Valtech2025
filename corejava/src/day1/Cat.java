package day1;

public class Cat implements Animal {

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Meow...");
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Eating Rat...");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("Snoring...");

	}
	public static void main(String[] args) {
		System.out.println(ZERO);
		Cat cat1 = new Cat();
		cat1.eat();
	}

}
