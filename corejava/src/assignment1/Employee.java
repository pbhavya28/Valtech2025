package assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import assignment1.Employee.Gender;



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

	
	
	
	
	public Employee() {

	}
	
	public Employee(long id, String name, int age, float salary, int experience, int level, Gender gender ) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.experience = experience;
		this.level = level;
		this.gender = gender;
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
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Employee)) return false;
		Employee employee = (Employee)obj;
		return id==employee.id && age==employee.age && name.equals(employee.name) && salary ==employee.salary && experience == employee.experience && gender.equals(employee.gender) ;
	
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
		
	    
		
	}


}
