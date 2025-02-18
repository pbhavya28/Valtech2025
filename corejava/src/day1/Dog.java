package day1;

public class Dog implements Animal {

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Bark...");

	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Eat Pedigree...");

	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("Snore...");

	}
	public static void main(String[] args) {
		System.out.println(ZERO);
		Dog dog1 = new Dog();
		dog1.eat();
	}
}
