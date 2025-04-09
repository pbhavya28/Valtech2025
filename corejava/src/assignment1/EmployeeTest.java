package assignment1;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import assignment1.Employee.Gender;


class EmployeeTest{
	
	@Test
	void testHashCode() {
		Employee e = new Employee(200,"Abhishek",22,30000,1,10,Gender.MALE);
		Employee e2  = new Employee(100,"Abhishek",22,30000,1,10,Gender.MALE);
		assertNotEquals(e.hashCode(),e2.hashCode());
		
	}
	@Test
	void testEquals() {
		Employee e = new Employee(200,"Abhishek",22,30000,1,10,Gender.MALE);
		Employee e2  = new Employee(100,"Dhruv",22,30000,1,10,Gender.MALE);
		assertFalse(e.equals(e2));
		
	}
	
	
	@Test
	void testToString() {
		Employee e = new Employee(136,"Sahil",43,90000,3,3,Gender.MALE);
		assertEquals(",id: 136 ,name:Sahil ,age: 43 ,gender: MALE ,experience: 3 ,salary: 90000.0 ,level: 3",e.toString());
	}
	

	
	private Set<Employee> addEmployees(){
		Set<Employee> employees = new TreeSet<Employee>();
		employees.add(Employee.builder().id(100).name("John")
				.age(22).salary(30000).gender(Gender.MALE)
				.experience(1).level(10).build());
		employees.add(Employee.builder().id(50).name("Sam")
				.age(25).salary(40000).gender(Gender.MALE)
				.experience(3).level(9).build());
		employees.add(Employee.builder().id(90).name("Sara")
				.age(30).salary(70000).gender(Gender.FEMALE)
				.experience(3).level(7).build());
		employees.add(Employee.builder().id(78).name("Abhishek")
				.age(28).salary(60000).gender(Gender.MALE)
				.experience(5).level(8).build());
		employees.add(Employee.builder().id(67).name("Sonali")
				.age(36).salary(130000).gender(Gender.FEMALE)
				.experience(15).level(2).build());
		employees.add(Employee.builder().id(128).name("Yusuf")
				.age(23).salary(33000).gender(Gender.MALE)
				.experience(1).level(10).build());
		employees.add(Employee.builder().id(105).name("Niyati")
				.age(32).salary(60000).gender(Gender.FEMALE)
				.experience(10).level(5).build());
		employees.add(Employee.builder().id(109).name("Cob")
				.age(42).salary(170000).gender(Gender.MALE)
				.experience(17).level(1).build());
		employees.add(Employee.builder().id(89).name("Jainik")
				.age(25).salary(40000).gender(Gender.MALE)
				.experience(3).level(7).build());
		employees.add(Employee.builder().id(130).name("Rahi")
				.age(25).salary(25000).gender(Gender.FEMALE)
				.experience(1).level(10).build());
		employees.add(Employee.builder().id(132).name("Kusum")
				.age(27).salary(40000).gender(Gender.FEMALE)
				.experience(3).level(6).build());
		employees.add(Employee.builder().id(134).name("Bob")
				.age(22).salary(40000).gender(Gender.MALE)
				.experience(1).level(9).build());
		employees.add(Employee.builder().id(135).name("Mitali")
				.age(40).salary(80000).gender(Gender.FEMALE)
				.experience(5).level(6).build());
		employees.add(Employee.builder().id(136).name("Sahil")
				.age(43).salary(90000).gender(Gender.MALE)
				.experience(3).level(3).build());
		employees.add(Employee.builder().id(137).name("Raj")
				.age(29).salary(41000).gender(Gender.MALE)
				.experience(7).level(4).build());
		return employees;
		
	}

	List<Employee> getEmployeeBySalary(float salary) {
		return addEmployees().stream().filter(employee -> employee.getSalary() > salary)
				.collect(Collectors.toList());
	}
	
	List<Employee> getEmployeeByName(String name) {
		return addEmployees().stream().filter(employee -> employee.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
	}
	
	List<Employee> getEmployeeByNameContains(String name) {
		return addEmployees().stream().filter(employee -> employee.getName().contains(name))
				.collect(Collectors.toList());
	}
	
	List<Employee> getEmployeeByLevel(int level) {
		return addEmployees().stream().filter(employee -> employee.getLevel()== level)
				.collect(Collectors.toList());
	}
	
	List<Employee> getEmployeeByLevelAndSalary(int level, float salary) {
		return addEmployees().stream().filter(employee -> employee.getLevel()== level && employee.getSalary() == salary)
				.collect(Collectors.toList());
	}
	
	double getSumOfSalByLevel(int level) {
		return addEmployees().stream().filter(employee -> employee.getLevel()== level).mapToDouble(Employee::getSalary).sum();
	}
	
	double getSumOfSalByAge(int age) {
		return addEmployees().stream().filter(employee -> employee.getAge()== age).mapToDouble(Employee::getSalary).sum();
	}

	List<Employee> sortedEmployees(){
		return addEmployees().stream().sorted().toList();
	}
	List<Employee> sortByNameDesc(){
		return addEmployees().stream()
                .sorted(Comparator.comparing(Employee::getName).reversed()) 
                .collect(Collectors.toList());	
	}
	public List<Employee> sortByGenderAsc(){
		return addEmployees().stream()
                .sorted(Comparator.comparing(Employee::getGender))  
                .collect(Collectors.toList());	
	}
	
	public List<Employee> sortBySalaryDesc(){
		return addEmployees().stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())  
                .collect(Collectors.toList());
	}
	
	public List<Employee> sortBySalaryAsc(){
		return addEmployees().stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)) 
                .collect(Collectors.toList());	
	}
	
	public List<Employee> sortByExpDesc(){
		return addEmployees().stream()
                .sorted(Comparator.comparingInt(Employee::getExperience).reversed())  
                .collect(Collectors.toList());	
	}
	
	
	List<Integer> MapEmployeesByAge(){
		return addEmployees().stream().map(employee -> employee.getAge())
				.collect(Collectors.toList());
	}
	
	Map<Gender, List<String>> employeesListByGender() { 
		return addEmployees().stream().collect(Collectors.groupingBy(
          Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));
	}
	
	
<<<<<<< HEAD
=======
	@Test
	void testNow() {
//		addEmployees().forEach(e -> System.out.println(e));
//		getEmployeeBySalary(80000f).forEach(e->System.out.println(e));
//		sortedEmployees().forEach(e->System.out.println(e));
//		getEmployeeByName("kusum").forEach(e->System.out.println(e));
//		getEmployeeByLevel(6).forEach(e->System.out.println(e));
//		getEmployeeByNameContains("um").forEach(e->System.out.println(e));
//		getEmployeeByLevelAndSalary(6,40000f).forEach(e->System.out.println(e));
//		System.out.println(getSumOfSalByLevel(6));
//		System.out.println(getSumOfSalByAge(25));
//		MapEmployeesByAge().forEach(e->System.out.println(e));
//		employeesListByGender().forEach((gender, names) -> {
//	          System.out.println("Gender: " + gender);
//	          System.out.println("Employees: " + names);});
//		System.out.println(sortByNameDesc());
>>>>>>> refs/remotes/origin/main

	
	@Test
	void testUsingAsserts() {
		assertEquals(15, addEmployees().size());
		assertEquals(3, getEmployeeBySalary(80000f).size());
		assertEquals(1, getEmployeeByName("kusum").size());
		assertEquals(2, getEmployeeByLevel(6).size());
		assertEquals(1, getEmployeeByNameContains("um").size());
		assertEquals(1, getEmployeeByLevelAndSalary(6,40000f).size());
		assertEquals(120000, getSumOfSalByLevel(6),0.00f);
		assertEquals(105000, getSumOfSalByAge(25),0.00f);
		assertFalse(employeesListByGender().isEmpty());
	}
	
	@Test
	void validate() {
//		System.out.println(addEmployees().size());
//		System.out.println(getEmployeeBySalary(80000f).size());
//		System.out.println(getEmployeeByLevel(6).size());
//		System.out.println(getEmployeeByLevelAndSalary(6,40000f).size());
	}
<<<<<<< HEAD
//	@Test
//	void testNow() {
//		addEmployees().forEach(e -> System.out.println(e));
//		getEmployeeBySalary(80000f).forEach(e->System.out.println(e));
//		sortedEmployees().forEach(e->System.out.println(e));
//		getEmployeeByName("kusum").forEach(e->System.out.println(e));
//		getEmployeeByLevel(6).forEach(e->System.out.println(e));
//		getEmployeeByNameContains("um").forEach(e->System.out.println(e));
//		getEmployeeByLevelAndSalary(6,40000f).forEach(e->System.out.println(e));
//		System.out.println(getSumOfSalByLevel(6));
//		System.out.println(getSumOfSalByAge(25));
//		MapEmployeesByAge().forEach(e->System.out.println(e));
//		employeesListByGender().forEach((gender, names) -> {
//	          System.out.println("Gender: " + gender);
//	          System.out.println("Employees: " + names);});
//		System.out.println(sortByNameDesc());

//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//		Set<Employee> employees = new TreeSet<Employee>();
//		employees.add(Employee.builder().id(100).name("John")
//				.age(22).salary(30000).gender(Gender.MALE)
//				.experience(1).level(10).build());
//		employees.add(Employee.builder().id(50).name("Sam")
//				.age(25).salary(40000).gender(Gender.MALE)
//				.experience(3).level(9).build());
//		employees.add(Employee.builder().id(90).name("Sara")
//				.age(30).salary(70000).gender(Gender.FEMALE)
//				.experience(3).level(7).build());
//		employees.add(Employee.builder().id(78).name("Abhishek")
//				.age(28).salary(60000).gender(Gender.MALE)
//				.experience(5).level(8).build());
//		employees.add(Employee.builder().id(67).name("Sonali")
//				.age(36).salary(130000).gender(Gender.FEMALE)
//				.experience(15).level(2).build());
//		employees.add(Employee.builder().id(128).name("Yusuf")
//				.age(23).salary(33000).gender(Gender.MALE)
//				.experience(1).level(10).build());
//		employees.add(Employee.builder().id(105).name("Niyati")
//				.age(32).salary(60000).gender(Gender.FEMALE)
//				.experience(10).level(5).build());
//		employees.add(Employee.builder().id(109).name("Cob")
//				.age(42).salary(170000).gender(Gender.MALE)
//				.experience(17).level(1).build());
//		employees.add(Employee.builder().id(89).name("Jainik")
//				.age(25).salary(40000).gender(Gender.MALE)
//				.experience(3).level(7).build());
//		employees.add(Employee.builder().id(130).name("Rahi")
//				.age(25).salary(25000).gender(Gender.FEMALE)
//				.experience(1).level(10).build());
//		employees.add(Employee.builder().id(132).name("Kusum")
//				.age(27).salary(40000).gender(Gender.FEMALE)
//				.experience(3).level(6).build());
//		employees.add(Employee.builder().id(134).name("Bob")
//				.age(22).salary(40000).gender(Gender.MALE)
//				.experience(1).level(9).build());
//		employees.add(Employee.builder().id(135).name("Mitali")
//				.age(40).salary(80000).gender(Gender.FEMALE)
//				.experience(5).level(6).build());
//		employees.add(Employee.builder().id(136).name("Sahil")
//				.age(43).salary(90000).gender(Gender.MALE)
//				.experience(3).level(3).build());
//		employees.add(Employee.builder().id(137).name("Raj")
//				.age(29).salary(41000).gender(Gender.MALE)
//				.experience(7).level(4).build());
//		employees.forEach(System.out::println);
//		System.out.println(" ");
//		System.out.println(" ");
//		System.out.println(" ");
//		System.out.println(" ");
//		System.out.println(" ");
//		System.out.println("*************************************************************************");
//		System.out.println("Filter Method: ");
//		System.out.println("*************************************************************************");
//		
//		List<Employee> myNewEmployees = employees.stream().filter(employee -> employee.getSalary() >50000)
//				.collect(Collectors.toList());
//		myNewEmployees.forEach(System.out::println);
//		
//
//
//		
//		System.out.println("*************************************************************************");
//		System.out.println("Filter Method (Name ignore case..): ");
//		System.out.println("*************************************************************************");
//		List<Employee> myNewEmployeesNameIgnoreCase = employees.stream().filter(employee -> employee.getName().equalsIgnoreCase("abhishek"))
//				.collect(Collectors.toList());
//		myNewEmployeesNameIgnoreCase.forEach(System.out::println);
//		
//		System.out.println("*************************************************************************");
//		System.out.println("Filter Method (Name contains..): ");
//		System.out.println("*************************************************************************");
//		List<Employee> myNewEmployeesNameContains = employees.stream().filter(employee -> employee.getName().toLowerCase().contains("abhi"))
//				.collect(Collectors.toList());
//		myNewEmployeesNameContains.forEach(System.out::println);
//		
//		
//		
//		System.out.println("*************************************************************************");
//		System.out.println("Age Map: ");
//		System.out.println("*************************************************************************");
//		
//		System.out.println(employees.stream().map(employee -> employee.getAge())
//				.collect(Collectors.toSet()));
//		
//		
//			
//        Map<Gender, List<String>> employeesByGender = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getGender, 
//                        Collectors.mapping(Employee::getName, Collectors.toList()) 
//                ));;
//       List<Employee> sortedByNameAsc = employees.stream()
//                .sorted(Comparator.comparing(Employee::getName))
//                .collect(Collectors.toList());
//       
//        
//       System.out.println("*************************************************************************");
//	   System.out.println("Map of Gender-> Employees: ");
//	   System.out.println("*************************************************************************");
//		
//
//        employeesByGender.forEach((gender, names) -> {
//            System.out.println("Gender: " + gender);
//            System.out.println("Employees: " + names);
//        });
//            
//        System.out.println("*************************************************************************");
// 		System.out.println("Employees sorted by their name: ");
// 		System.out.println("*************************************************************************");
// 			
//            
//        sortedByNameAsc.forEach(System.out::println);
//        
//        DoubleSummaryStatistics empSalary = employees.stream().collect(Collectors
//                .summarizingDouble(Employee::getSalary));
//      
//        Map<Integer, Double> sumOfSalByLevel = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getLevel, 
//                        Collectors.summingDouble(Employee::getSalary)) // Collect names into a list
//                );;
//       
//       
//        System.out.println("*************************************************************************");
// 		System.out.println("Levels and total salary: ");
// 		System.out.println("*************************************************************************");
//// 		for (Map.Entry<Integer, Double> entry: sumOfSalByLevel.entrySet() ) {
////	        System.out.println("Level: "+entry.getKey() + ". Total Salary: " +entry.getValue());
////	        	
////	    }	
//	    Map<Object, Object> sortedMapLevelSal = sumOfSalByLevel.entrySet()
//        	    .stream()
//        	    .sorted(Map.Entry.comparingByKey())
//        	    .collect(Collectors.toMap(
//        	        Map.Entry::getKey,
//        	        Map.Entry::getValue,
//        	        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
//
//        	System.out.println(sortedMapLevelSal);
//        	
//        	System.out.println("*************************************************************************");
//  	 		System.out.println("2nd Method: ");
//  	 		System.out.println("*************************************************************************");
////  	 		
//         	System.out.println("-------------------");
////         	Map<Integer,List<String>> levSalSum = employees.stream().collect(Collectors.groupingBy(Employee::getLevel
////         			,Collectors.mapping(Employee::getName, Collectors.toList())));
////         	System.out.println("-------------------");
////         	double totalSal = ((Collection<Employee>) levSalSum).stream().mapToDouble(Employee::getSalary).sum();
//         	
//
//  	 	
//         	List<Employee> sortedMapLevelSalSM = employees.stream().filter(employee -> employee.getLevel()==1)
// 					.collect(Collectors.toList());
//         	System.out.println(sortedMapLevelSalSM);
//         	double totalSalary = sortedMapLevelSalSM.stream().mapToDouble(Employee::getSalary).sum();
//         	System.out.println("Total Salary: "+ totalSalary);
// 		
// 		Map<String, Double> sumOfSalByName = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getName, 
//                        Collectors.summingDouble(Employee::getSalary)) // Collect names into a list
//                );;
////                System.out.println("#$#$#$#$#$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//
//
//       
//        System.out.println("*************************************************************************");
// 		System.out.println("Names and total salary: ");
// 		System.out.println("*************************************************************************");
//// 		for (Map.Entry<String, Double> entry: sumOfSalByName.entrySet() ) {
////	        	System.out.println("Name: "+entry.getKey() + ". Total Salary: " +entry.getValue());
////	        	
////	        }	
//	    Map<Object, Object> sortedMap = sumOfSalByName.entrySet()
//        	    .stream()
//        	    .sorted(Map.Entry.comparingByKey())
//        	    .collect(Collectors.toMap(
//        	        Map.Entry::getKey,
//        	        Map.Entry::getValue,
//        	        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
//
//        	System.out.println(sortedMap);
// 	    	
// 		
// 		 Map<Gender,Double> sumOfSalByGender = employees.stream()
//	                .collect(Collectors.groupingBy(
//	                        Employee::getGender,
//	                        Collectors.summingDouble(Employee::getSalary)) // Collect names into a list
//	                );;
//
//	       
//	        System.out.println("*************************************************************************");
//	 		System.out.println("Genders and total salary: ");
//	 		System.out.println("*************************************************************************");
////	 		for (Map.Entry<Gender, Double> entry: sumOfSalByGender.entrySet() ) {
////		        	System.out.println("Gender: "+entry.getKey() + ". Total Salary: " +entry.getValue());
////		        	
////		        }
////		    Map<Object, Object> sortedMapGenderSal = sumOfSalByGender.entrySet()
////    	    .stream()
////    	    .sorted(Map.Entry.comparingByKey())
////    	    .collect(Collectors.toMap(
////    	        Map.Entry::getKey,
////    	        Map.Entry::getValue,
////    	        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
////
////    	System.out.println(sortedMapGenderSal);
////    	
////    	System.out.println("*************************************************************************");
////	 		System.out.println("2nd Method: ");
////	 		System.out.println("*************************************************************************");
////	 		
//    	
//    	List<Employee> sortedMapGenderSalSM = employees.stream().filter(employee -> employee.getGender()==Gender.MALE)
//				.collect(Collectors.toList());
//    	System.out.println(sortedMapGenderSalSM);
//    	double totalSalary1 = sortedMapGenderSalSM.stream().mapToDouble(Employee::getSalary).sum();
//    	System.out.println("Total Salary: "+ totalSalary1);
//	 
//	 	
//
//            
//	}
=======
>>>>>>> refs/remotes/origin/main

}
