package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import entities.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Override
	public List<Employee> sortByIdAsc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparingLong(Employee::getId))  // Sort by ID
                .collect(Collectors.toList());	
	}
	
	@Override
	public List<Employee> sortByAgeDesc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparingLong(Employee::getAge).reversed())  // Sort by ID
                .collect(Collectors.toList());	
	}
	
	@Override
	public List<Employee> sortByAgeAsc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparingLong(Employee::getAge))  // Sort by ID
                .collect(Collectors.toList());	
	}
	
	@Override
	public List<Employee> sortByIdDesc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparingLong(Employee::getId).reversed())  // Sort by ID
                .collect(Collectors.toList());
		
	}
	
	@Override
	public List<Employee> sortByNameDesc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())  // Sort by ID
                .collect(Collectors.toList());	
	}
	
	@Override
	public List<Employee> sortByNameAsc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparing(Employee::getName))  // Sort by ID
                .collect(Collectors.toList());	
	}
	
	@Override
	public List<Employee> sortByGenderDesc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparing(Employee::getGender).reversed())  // Sort by ID
                .collect(Collectors.toList());
		
	}
	
	@Override
	public List<Employee> sortByGenderAsc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparing(Employee::getGender))  // Sort by ID
                .collect(Collectors.toList());	
	}
	
	@Override
	public List<Employee> sortBySalaryDesc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())  // Sort by ID
                .collect(Collectors.toList());	
	}
	
	@Override
	public List<Employee> sortBySalaryAsc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))  // Sort by ID
                .collect(Collectors.toList());
	}
	
	@Override
	public List<Employee> sortByExpDesc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getExperience).reversed())  // Sort by ID
                .collect(Collectors.toList());
	}
	
	@Override
	public List<Employee> sortByExpAsc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getExperience))  // Sort by ID
                .collect(Collectors.toList());		
	}
	
	@Override
	public List<Employee> sortByLevelDesc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getLevel).reversed())  // Sort by ID
                .collect(Collectors.toList());	
	}
	
	@Override
	public List<Employee> sortByLevelAsc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getLevel))  // Sort by ID
                .collect(Collectors.toList());	
	}
	
	@Override
	public List<Employee> sortByDepDesc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getDeptId).reversed())  // Sort by ID
                .collect(Collectors.toList());
	}
	
	@Override
	public List<Employee> sortByDepAsc(List<Employee> employees){
		return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getDeptId))  // Sort by ID
                .collect(Collectors.toList());	
	}

	@Override
	public List<Employee> getSearchByName(String name,List<Employee> employees){
	return employees.stream().filter(employee -> employee.getName().toLowerCase().contains(name))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Employee> getSearchBySal (long salary,List<Employee> employees){
		return employees.stream().filter(employee -> employee.getSalary() >=salary)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Employee> getSearchByLevel (int level,List<Employee> employees){
		return employees.stream().filter(employee -> employee.getLevel()== level)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Employee> getSearchByAge (int age,List<Employee> employees){
		return employees.stream().filter(employee -> employee.getAge()== age)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Employee> getSearchByExp (int exp,List<Employee> employees){
		return employees.stream().filter(employee -> employee.getExperience()== exp)
				.collect(Collectors.toList());
	}
}
