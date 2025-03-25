package services;

import java.util.List;

import entities.Employee;

public interface EmployeeService {

	List<Employee> sortByIdAsc(List<Employee> employees);

	List<Employee> sortByAgeDesc(List<Employee> employees);

	List<Employee> sortByAgeAsc(List<Employee> employees);

	List<Employee> sortByIdDesc(List<Employee> employees);

	List<Employee> sortByNameDesc(List<Employee> employees);

	List<Employee> sortByNameAsc(List<Employee> employees);

	List<Employee> sortByGenderDesc(List<Employee> employees);

	List<Employee> sortByGenderAsc(List<Employee> employees);

	List<Employee> sortBySalaryDesc(List<Employee> employees);

	List<Employee> sortBySalaryAsc(List<Employee> employees);

	List<Employee> sortByExpDesc(List<Employee> employees);

	List<Employee> sortByExpAsc(List<Employee> employees);

	List<Employee> sortByLevelDesc(List<Employee> employees);

	List<Employee> sortByLevelAsc(List<Employee> employees);

	List<Employee> sortByDepDesc(List<Employee> employees);

	List<Employee> sortByDepAsc(List<Employee> employees);

	List<Employee> getSearchByName(String name, List<Employee> employees);

	List<Employee> getSearchBySal(long salary, List<Employee> employees);

	List<Employee> getSearchByLevel(int level, List<Employee> employees);

	List<Employee> getSearchByAge(int age, List<Employee> employees);

	List<Employee> getSearchByExp(int exp, List<Employee> employees);

}