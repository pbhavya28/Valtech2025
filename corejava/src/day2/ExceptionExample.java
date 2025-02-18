package day2;

public class ExceptionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Authenticator auth = new Authenticator();
		
		long code;
		try {
			code = auth.authenticate("scott", "tiger");
			System.out.println("Authentication code:- "+code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("I will always be executed");
		}
		

		
	}

}
