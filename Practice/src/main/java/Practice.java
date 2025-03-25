import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Practice {

//	private  final int x;
//	{
//		x=10;
//	}

	int id;
	String name;
	
	
	public Practice() {
		
	}

	
	public Practice(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		}

	


//	int id = 4;
//	int a[]  = {1,2,3};
//	
//	public void nothing() {
//		System.out.println("without main() method");
//		for(int arr:a) {
//			System.out.println(arr);}
//		
//	}
	
	





	public static void main(String []args) {
		LocalDate date1 = LocalDate.parse("2021-01-07");
		LocalDate date2 = LocalDate.parse("2021-01-05");
		System.out.println(ChronoUnit.DAYS.between(date1, date2));
		if(ChronoUnit.DAYS.between(date1, date2) < 0) {System.out.println("Not valid");}
		
//		String s1 = "Daaku";
//		String s2 = "Daaku";
//		String s3 = s1;
//		System.out.println(s1==s3);
//		Practice p1 = new Practice(3,"Kiran");
//		Practice p2 = new Practice(4,"Hiran");
//		Practice p3 = new Practice(3,"Kiran");
//		Practice p4 = p1;
//		Practice p2 = new Practice(4,"Hiran");

//		System.out.println(p1.equals(p2));
//		System.out.println(p1.equals(p3));
//		System.out.println(p1.equals(p4));
		
//		String s1 = "Indrajeet";
//		System.out.println("Indrajeet".equals(s1));
//		System.out.println(s1=="Indrajeet");
		
//		System.out.println(p1.hashCode()==p4.hashCode());
//		System.out.println(p1.hashCode()==p3.hashCode());
//		System.out.println("p1: "+p1.hashCode());
//		System.out.println("p2: "+p2.hashCode());
//		System.out.println("p3: "+p3.hashCode());
//		System.out.println("p4: "+p4.hashCode());


		

		
		
//		StringBuffer sb = new StringBuffer("HelloWorld");
//		sb.insert(5, " ");
//		System.out.println(sb);
//		
//		String s = new String("HelloWorld");
//		s.insert(5, " ");
//		System.out.println(s);
//		Practice p = new Practice();
//		System.out.println(p.x);
//		Integer a = 2;
//		Integer b = 2;
//		System.out.println(a.hashCode(b));
//		System.out.println("Hi");
//		Practice p = new Practice();
//		p.nothing();
		
//		int x = 5;
//
//		int y = 10;
//
//		int z = (x++ > 5 && y-- < 10) ? x-- : y;
//		System.out.println(z);
		
//		System.out.println(x +" " +y);
//		System.out.println(y-- < 10);
//		int i, j;
//
//		i = 100;
//
//		j = 300;
//
//		while(++i < --j);
//
//		System.out.println(i);


		}
	}


