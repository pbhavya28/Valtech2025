package practice;

class AnnonymousClassExp1 {

	public void show() {
		
		System.out.println("In show method");
	}

	public void newShow() {
		// TODO Auto-generated method stub
		
	}
}

public class AnnonymousClassExp{
	
	
	
	public static void main(String[] args) {
		AnnonymousClassExp1 ax = new AnnonymousClassExp1() {
			
			public void show() {
				System.out.println("In new show..");
			}
			public void newShow() {
				System.out.println("In new new show.......");
			}
		};
		ax.show();
		ax.newShow();

	}
}