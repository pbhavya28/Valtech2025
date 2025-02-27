package dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

//import assignment1.Employee.Gender;



public class Employee implements Comparable<Employee> {

	private long id;
	private String name;
	private int age;
	private float salary;
	public enum Gender {
		MALE,
		FEMALE,
		OTHER;
	}
	private int experience;
	private int level;
	private Gender gender;
	private int deptId;

	
	
	
	
	public Employee() {

	}
	
	public Employee(long id, String name, int age, float salary, int experience, int level, Gender gender, int deptId ) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.experience = experience;
		this.level = level;
		this.gender = gender;
		this.deptId = deptId;
	}
	
	public static EmployeeBuilder builder() {
		return new EmployeeBuilder (new Employee());
	}
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Gender getGender() {
		return gender;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Employee)) return false;
		Employee employee = (Employee)obj;
		return id==employee.id && age==employee.age && name.equals(employee.name) && salary ==employee.salary && experience == employee.experience && gender.equals(employee.gender) && deptId == employee.deptId ;
	
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(",id: "+ id)
								  .append(" ")
								  .append(",name:" + name)
								  .append(" ")
								  .append(",age: "+ age)
								  .append(" ")
								  .append(",gender: "+ gender)
								  .append(" ")
								  .append(",experience: "+ experience)
								  .append(" ")
								  .append(",salary: "+ salary)
								  .append(" ")
								  .append(",level: "+ level)
								  .append(" ")
								  .append(",deptId: "+ deptId)
								  .toString();
	}
	
	
	 @Override
	    public int compareTo(Employee other) {

	        int levelComparison = Integer.compare(this.level, other.level);
	        if (levelComparison != 0) {
	            return levelComparison;
	        }
	        int experienceComparison = Integer.compare(this.experience, other.experience);
	        if (experienceComparison != 0) {
	            return experienceComparison;
	        }

	        int salaryComparison = Float.compare(this.salary, other.salary);
	        if (salaryComparison != 0) {
	            return salaryComparison;
	        }	
	        return other.gender.compareTo(this.gender);
	        
	 }
	
	public static class EmployeeBuilder{
		
		private Employee employee;

		public EmployeeBuilder() {

		}

		public EmployeeBuilder(Employee employee) {
			this.employee = employee;
		}
		
		public Employee build() {
			return employee;
		}
		
		
		public EmployeeBuilder id(long id) {
			employee.setId(id);
			return this;
		}
		
		public EmployeeBuilder name(String name) {
			employee.setName(name);
			return this;
		}
		
		public EmployeeBuilder age(int age) {
			employee.setAge(age);
			return this;
		}
		
		public EmployeeBuilder salary(float salary) {
			employee.setSalary(salary);
			return this;
		}
		
		public EmployeeBuilder gender(Gender gender) {
			employee.setGender(gender);
			return this;
		}
		
		public EmployeeBuilder level(int level) {
			employee.setLevel(level);
			return this;
		}
		
		public EmployeeBuilder experience(int experience) {
			employee.setExperience(experience);
			return this;
		}
		public EmployeeBuilder deptId(int deptId) {
			employee.setDeptId(deptId);
			return this;
		}
		
	    

		
//		public static void main(String[] args) {
//			Set<Employee> employees = new TreeSet<Employee>();
//			employees.add(Employee.builder().id(100).name("John")
//					.age(22).salary(30000).gender(Gender.MALE)
//					.experience(1).level(10).build());
//			employees.add(Employee.builder().id(50).name("Sam")
//					.age(25).salary(40000).gender(Gender.MALE)
//					.experience(3).level(9).build());
//			employees.add(Employee.builder().id(90).name("Sara")
//					.age(30).salary(70000).gender(Gender.FEMALE)
//					.experience(3).level(7).build());
//			employees.add(Employee.builder().id(78).name("Abhishek")
//					.age(28).salary(60000).gender(Gender.MALE)
//					.experience(5).level(8).build());
//			employees.add(Employee.builder().id(67).name("Sonali")
//					.age(36).salary(130000).gender(Gender.FEMALE)
//					.experience(15).level(2).build());
//			employees.add(Employee.builder().id(128).name("Yusuf")
//					.age(23).salary(33000).gender(Gender.MALE)
//					.experience(1).level(10).build());
//			employees.add(Employee.builder().id(105).name("Niyati")
//					.age(32).salary(60000).gender(Gender.FEMALE)
//					.experience(10).level(5).build());
//			employees.add(Employee.builder().id(109).name("Cob")
//					.age(42).salary(170000).gender(Gender.MALE)
//					.experience(17).level(1).build());
//			employees.add(Employee.builder().id(89).name("Jainik")
//					.age(25).salary(40000).gender(Gender.MALE)
//					.experience(3).level(7).build());
//			employees.add(Employee.builder().id(130).name("Rahi")
//					.age(25).salary(25000).gender(Gender.FEMALE)
//					.experience(1).level(10).build());
//			employees.add(Employee.builder().id(132).name("Kusum")
//					.age(27).salary(40000).gender(Gender.FEMALE)
//					.experience(3).level(6).build());
//			employees.add(Employee.builder().id(134).name("Bob")
//					.age(22).salary(40000).gender(Gender.MALE)
//					.experience(1).level(9).build());
//			employees.add(Employee.builder().id(135).name("Mitali")
//					.age(40).salary(80000).gender(Gender.FEMALE)
//					.experience(5).level(6).build());
//			employees.add(Employee.builder().id(136).name("Sahil")
//					.age(43).salary(90000).gender(Gender.MALE)
//					.experience(3).level(3).build());
//			employees.add(Employee.builder().id(137).name("Raj")
//					.age(29).salary(41000).gender(Gender.MALE)
//					.experience(7).level(4).build());
//			employees.forEach(System.out::println);
//			System.out.println(" ");
//			System.out.println(" ");
//			System.out.println(" ");
//			System.out.println(" ");
//			System.out.println(" ");
//			System.out.println("*************************************************************************");
//			System.out.println("Filter Method: ");
//			System.out.println("*************************************************************************");
//			
//			List<Employee> myNewEmployees = employees.stream().filter(employee -> employee.getSalary() >50000)
//					.collect(Collectors.toList());
//			myNewEmployees.forEach(System.out::println);
//			
//
//
//			
//			System.out.println("*************************************************************************");
//			System.out.println("Filter Method (Name contains..): ");
//			System.out.println("*************************************************************************");
//			List<Employee> myNewEmployeesNameContains = employees.stream().filter(employee -> employee.getName().toLowerCase().contains("abhi"))
//					.collect(Collectors.toList());
//			myNewEmployeesNameContains.forEach(System.out::println);
//			System.out.println("*************************************************************************");
//			System.out.println("Age Map: ");
//			System.out.println("*************************************************************************");
//			
//			System.out.println(employees.stream().map(employee -> employee.getAge())
//					.collect(Collectors.toSet()));
//			
//			
//				
//	        Map<Gender, List<String>> employeesByGender = employees.stream()
//	                .collect(Collectors.groupingBy(
//	                        Employee::getGender, 
//	                        Collectors.mapping(Employee::getName, Collectors.toList()) // Collect names into a list
//	                ));;
//	       List<Employee> sortedByNameAsc = employees.stream()
//	                .sorted(Comparator.comparing(Employee::getName))
//	                .collect(Collectors.toList());
//	       
//	        
//	       System.out.println("*************************************************************************");
//		   System.out.println("Map of Gender-> Employees: ");
//		   System.out.println("*************************************************************************");
//			
//
//	        employeesByGender.forEach((gender, names) -> {
//	            System.out.println("Gender: " + gender);
//	            System.out.println("Employees: " + names);
//	        });
//	            
//	        System.out.println("*************************************************************************");
//	 		System.out.println("Employees sorted by their name: ");
//	 		System.out.println("*************************************************************************");
//	 			
//	            
//	        sortedByNameAsc.forEach(System.out::println);
//	        
//	        DoubleSummaryStatistics empSalary = employees.stream().collect(Collectors
//                    .summarizingDouble(Employee::getSalary));
//	      
//	        Map<Integer, Double> sumOfSalByLevel = employees.stream()
//	                .collect(Collectors.groupingBy(
//	                        Employee::getLevel, 
//	                        Collectors.summingDouble(Employee::getSalary)) // Collect names into a list
//	                );;
//	       
//	       
//	        System.out.println("*************************************************************************");
//	 		System.out.println("Levels and total salary: ");
//	 		System.out.println("*************************************************************************");
////	 		for (Map.Entry<Integer, Double> entry: sumOfSalByLevel.entrySet() ) {
////		        System.out.println("Level: "+entry.getKey() + ". Total Salary: " +entry.getValue());
////		        	
////		    }	
//		    Map<Object, Object> sortedMapLevelSal = sumOfSalByLevel.entrySet()
//            	    .stream()
//            	    .sorted(Map.Entry.comparingByKey())
//            	    .collect(Collectors.toMap(
//            	        Map.Entry::getKey,
//            	        Map.Entry::getValue,
//            	        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
//
//            	System.out.println(sortedMapLevelSal);
//            	 System.out.println("*************************************************************************");
//     	 		System.out.println("2nd Method: ");
//     	 		System.out.println("*************************************************************************");
////     	 		
//            	
//            	List<Employee> sortedMapLevelSalSM = employees.stream().filter(employee -> employee.getLevel()==1)
//    					.collect(Collectors.toList());
//            	System.out.println(sortedMapLevelSalSM);
//            	double totalSalary = sortedMapLevelSalSM.stream().mapToDouble(Employee::getSalary).sum();
//            	System.out.println("Total Salary: "+ totalSalary);
//	 		
//	 		Map<String, Double> sumOfSalByName = employees.stream()
//	                .collect(Collectors.groupingBy(
//	                        Employee::getName, 
//	                        Collectors.summingDouble(Employee::getSalary)) // Collect names into a list
//	                );;
////	                System.out.println("#$#$#$#$#$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//
//
//	       
//	        System.out.println("*************************************************************************");
//	 		System.out.println("Names and total salary: ");
//	 		System.out.println("*************************************************************************");
////	 		for (Map.Entry<String, Double> entry: sumOfSalByName.entrySet() ) {
////		        	System.out.println("Name: "+entry.getKey() + ". Total Salary: " +entry.getValue());
////		        	
////		        }	
//		    Map<Object, Object> sortedMap = sumOfSalByName.entrySet()
//            	    .stream()
//            	    .sorted(Map.Entry.comparingByKey())
//            	    .collect(Collectors.toMap(
//            	        Map.Entry::getKey,
//            	        Map.Entry::getValue,
//            	        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
//
//            	System.out.println(sortedMap);
//            	
//	 
//	 		
//	 		 Map<Gender,Double> sumOfSalByGender = employees.stream()
//		                .collect(Collectors.groupingBy(
//		                        Employee::getGender,
//		                        Collectors.summingDouble(Employee::getSalary)) // Collect names into a list
//		                );;
//
//		       
//		        System.out.println("*************************************************************************");
//		 		System.out.println("Genders and total salary: ");
//		 		System.out.println("*************************************************************************");
////		 		for (Map.Entry<Gender, Double> entry: sumOfSalByGender.entrySet() ) {
////			        	System.out.println("Gender: "+entry.getKey() + ". Total Salary: " +entry.getValue());
////			        	
////			        }
//			    Map<Object, Object> sortedMapGenderSal = sumOfSalByGender.entrySet()
//        	    .stream()
//        	    .sorted(Map.Entry.comparingByKey())
//        	    .collect(Collectors.toMap(
//        	        Map.Entry::getKey,
//        	        Map.Entry::getValue,
//        	        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
//
//        	System.out.println(sortedMapGenderSal);
//        	
//        	System.out.println("*************************************************************************");
// 	 		System.out.println("2nd Method: ");
// 	 		System.out.println("*************************************************************************");
//// 	 		
//        	
//        	List<Employee> sortedMapGenderSalSM = employees.stream().filter(employee -> employee.getGender()==Gender.MALE)
//					.collect(Collectors.toList());
//        	System.out.println(sortedMapGenderSalSM);
//        	double totalSalary1 = sortedMapGenderSalSM.stream().mapToDouble(Employee::getSalary).sum();
//        	System.out.println("Total Salary: "+ totalSalary1);
//		 
//		 	
//
//	            
//
//	            
//
//		;
//		}
//		
//	}

	}
}
