package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import entities.Employee;
import entities.Employee.Gender;
import jakarta.servlet.ServletContext;
//import day4.EmployeeDAO;
//import day4.EmployeeDAOImpl;

//import assignment1.Employee;
//import assignment1.Employee.Gender;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	
ServletContext sc;

public EmployeeDAOImpl(ServletContext sc) {
	this.sc = sc;
}
//	static {
//		try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//						e.printStackTrace();
//		}
//	}
	private Connection getConnection(ServletContext sc) throws SQLException {
		String url = (String)sc.getAttribute("url");
		String username = (String)sc.getAttribute("username");
		String password = (String)sc.getAttribute("password");
		
		System.out.println("nnnnnnnnnnnnnnnnnnnnnnnn" + url);
		System.out.println("nnnnnnnnnnnnnnnnnnnnnnnn" + username);
		System.out.println("nnnnnnnnnnnnnnnnnnnnnnnn" + password);


//		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgres");
		return DriverManager.getConnection(url,username,password);
	}

	@Override
	public void save(Employee e) {
		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement
					("INSERT INTO EMPLOYEE(NAME, AGE, GENDER,SALARY, EXPERIENCE, LEVEL, DEPTID, ID) VALUES (?,?,?,?,?,?,?,?)");
			setValuesToPreparedStatement(e, ps);
			
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Inserted: "+rowsAffected);
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private void setValuesToPreparedStatement(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setFloat(4, e.getSalary());
		ps.setInt(5, e.getExperience());
		ps.setInt(6, e.getLevel());
		ps.setInt(7, e.getDeptId());
		ps.setLong(8, e.getId());
	}

	@Override
	public void update(Employee e) {

		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement("update Employee set Name=? ,Age=?,Gender=?,Salary=?,Experience=?,Level=?,deptId=? where id = ?");
			setValuesToPreparedStatement(e,ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Updated: "+rowsAffected);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement("delete FROM EMPLOYEE where ID=? ");
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Deleted: "+rowsAffected);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public Employee get(int id) {
		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement("Select ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPTID FROM EMPLOYEE where ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			 //if this returns true then we have another row. next return false, we are at the end of resultset.
				System.out.println(rs.getInt(8));

			 Employee e = populateEmployee(rs);
			 return e;
			}
			else {
				new RuntimeException("No Employee with id "+id+" found.");
			}
			
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		return null;
	}

	private Employee populateEmployee(ResultSet rs) throws SQLException {
		return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3))
				.gender(Gender.valueOf(rs.getString(4))).salary(rs.getFloat(5)).experience(rs.getInt(6))
				.level(rs.getInt(7)).deptId(rs.getInt(8)).build();
	}

	@Override
	public List<Employee> getAll() {
		
		List<Employee> emps = new ArrayList<Employee>();
		
		System.out.println("---------4444-------"+this.sc);
		try(Connection conn  =getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPTID FROM EMPLOYEE");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emps.add(populateEmployee(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				return emps;
	}
	
	public List<Employee> getEmpByDept(int deptId){
		
		List<Employee> emps = new ArrayList<Employee>();
		try(Connection conn  =getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPTID FROM EMPLOYEE WHERE DEPTID = ?");
			ps.setInt(1, deptId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emps.add(populateEmployee(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				return emps;
		
	}
}	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public List<Employee> sortByIdAsc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparingLong(Employee::getId))  // Sort by ID
//                .collect(Collectors.toList());
//		
//	}
//	
//	public List<Employee> sortByAgeDesc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparingLong(Employee::getAge).reversed())  // Sort by ID
//                .collect(Collectors.toList());
//		
//	}
//	
//	public List<Employee> sortByAgeAsc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparingLong(Employee::getAge))  // Sort by ID
//                .collect(Collectors.toList());
//		
//	}
//	
//	public List<Employee> sortByIdDesc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparingLong(Employee::getId).reversed())  // Sort by ID
//                .collect(Collectors.toList());
//		
//	}
//	
//	public List<Employee> sortByNameDesc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparing(Employee::getName).reversed())  // Sort by ID
//                .collect(Collectors.toList());
//		
//	}
//	
//	public List<Employee> sortByNameAsc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparing(Employee::getName))  // Sort by ID
//                .collect(Collectors.toList());
//		
//	}
//	
//	public List<Employee> sortByGenderDesc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparing(Employee::getGender).reversed())  // Sort by ID
//                .collect(Collectors.toList());
//		
//	}
//	
//	public List<Employee> sortByGenderAsc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparing(Employee::getGender))  // Sort by ID
//                .collect(Collectors.toList());
//		
//	}
//	
//	public List<Employee> sortBySalaryDesc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())  // Sort by ID
//                .collect(Collectors.toList());
//		
//	}
//	
//	public List<Employee> sortBySalaryAsc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparingDouble(Employee::getSalary))  // Sort by ID
//                .collect(Collectors.toList());
//		
//	}
//	
//	public List<Employee> sortByExpDesc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparingInt(Employee::getExperience).reversed())  // Sort by ID
//                .collect(Collectors.toList());
//		
//	}
//	
//	public List<Employee> sortByExpAsc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparingInt(Employee::getExperience))  // Sort by ID
//                .collect(Collectors.toList());	
//	}
//	
//	public List<Employee> sortByLevelDesc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparingInt(Employee::getLevel).reversed())  // Sort by ID
//                .collect(Collectors.toList());	
//	}
//	
//	public List<Employee> sortByLevelAsc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparingInt(Employee::getLevel))  // Sort by ID
//                .collect(Collectors.toList());	
//	}
//	
//	public List<Employee> sortByDepDesc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparingInt(Employee::getDeptId).reversed())  // Sort by ID
//                .collect(Collectors.toList());	
//	}
//	
//	public List<Employee> sortByDepAsc(){
//		EmployeeDAO l_emp = new EmployeeDAOImpl(this.sc); 
//		return l_emp.getAll().stream()
//                .sorted(Comparator.comparingInt(Employee::getDeptId))  // Sort by ID
//                .collect(Collectors.toList());	
//	}
//	
//	public List<Employee> getSearchByName(String name){
//		EmployeeDAO dao = new EmployeeDAOImpl(this.sc);
//	return dao.getAll().stream().filter(employee -> employee.getName().toLowerCase().contains(name))
//				.collect(Collectors.toList());
//	}
//	
//	public List<Employee> getSearchBySal (long salary){
//		EmployeeDAO dao = new EmployeeDAOImpl(this.sc);
//
//		return dao.getAll().stream().filter(employee -> employee.getSalary() >=salary)
//				.collect(Collectors.toList());
//	}
//	
//	public List<Employee> getSearchByLevel (int level){
//		EmployeeDAO dao = new EmployeeDAOImpl(this.sc);
//
//		return dao.getAll().stream().filter(employee -> employee.getLevel()== level)
//				.collect(Collectors.toList());
//	}
//	
//	public List<Employee> getSearchByAge (int age){
//		EmployeeDAO dao = new EmployeeDAOImpl(this.sc);
//
//		return dao.getAll().stream().filter(employee -> employee.getAge()== age)
//				.collect(Collectors.toList());
//	}
//	
//	public List<Employee> getSearchByExp (int exp){
//		EmployeeDAO dao = new EmployeeDAOImpl(this.sc);
//
//		return dao.getAll().stream().filter(employee -> employee.getExperience()== exp)
//				.collect(Collectors.toList());
//	}




