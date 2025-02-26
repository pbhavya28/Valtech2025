package spring.tx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.tx.Employee.Gender;

//import assignment1.Employee;
//import assignment1.Employee.Gender;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
						e.printStackTrace();
		}
	}
	
	@Autowired
	private javax.sql.DataSource dataSource;
	
	public void setDataSource(javax.sql.DataSource dataSource) {
		this.dataSource = dataSource;
	}
	private Connection getConnection() throws SQLException {
//		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgres");
		return dataSource.getConnection();
	}

	@Override
	public void save(Employee e) {
		new JdbcTemplate(dataSource)
		.update("INSERT INTO EMPLOYEE(NAME, AGE, GENDER,SALARY, EXPERIENCE, LEVEL, ID) VALUES (?,?,?,?,?,?,?)"
				,e.getName(),e.getAge(),e.getGender().name(),e.getSalary(),e.getExperience(),e.getLevel(),e.getId());
//		try(Connection conn = getConnection()){
//			PreparedStatement ps = conn.prepareStatement
//					("INSERT INTO EMPLOYEE(NAME, AGE, GENDER,SALARY, EXPERIENCE, LEVEL, ID) VALUES (?,?,?,?,?,?,?)");
//			setValuesToPreparedStatement(e, ps);
//			
//			int rowsAffected = ps.executeUpdate();
//			System.out.println("Rows Inserted: "+rowsAffected);
//		}catch(Exception ex) {
//			throw new RuntimeException(ex);
//		}
	}

	private void setValuesToPreparedStatement(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setFloat(4, e.getSalary());
		ps.setInt(5, e.getExperience());
		ps.setInt(6, e.getLevel());
		ps.setLong(7, e.getId());
	}

	@Override
	public void update(Employee e) {

		new JdbcTemplate(dataSource)
		.update("update Employee set Name=? ,Age=?,Gender=?,Salary=?,Experience=?,Level=? where id = ?"
				,e.getName(),e.getAge(),e.getGender().name(),e.getSalary(),e.getExperience(),e.getLevel(),e.getId());
//		try(Connection conn = getConnection()){
//			PreparedStatement ps = conn.prepareStatement("update Employee set Name=? ,Age=?,Gender=?,Salary=?,Experience=?,Level=? where id = ?");
//			setValuesToPreparedStatement(e,ps);
//			int rowsAffected = ps.executeUpdate();
//			System.out.println("Rows Updated: "+rowsAffected);
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//		}
	}

	@Override
	public void delete(int id) {
		 new JdbcTemplate(dataSource).update("delete FROM EMPLOYEE where ID=?",id);
//		try(Connection conn = getConnection()){
//			PreparedStatement ps = conn.prepareStatement("delete FROM EMPLOYEE where ID=? ");
//			ps.setInt(1, id);
//			int rowsAffected = ps.executeUpdate();
//			System.out.println("Rows Deleted: "+rowsAffected);
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
		
	}

	@Override
	public Employee get(int id) {
		
		return new JdbcTemplate(dataSource).queryForObject("Select ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE where ID=?", new Object[] {id}, new EmployeeRowMapper());
//		try(Connection conn = getConnection()){
//			PreparedStatement ps = conn.prepareStatement("Select ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE where ID=?");
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()) {
//			 //if this returns true then we have another row. next return false, we are at the end of resultset.
//			 Employee e = populateEmployee(rs);
//			 return e;
//			}
//			else {
//				new RuntimeException("No Employee with id "+id+" found.");
//			}
//			
//		}
//		catch(Exception ex) {
//			throw new RuntimeException(ex);
//		}
//		return null;
	}
	

	private static class EmployeeRowMapper implements RowMapper<Employee>{

		@Override
		public Employee mapRow(ResultSet rs, int index) throws SQLException {
			return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3))
					.gender(Gender.valueOf(rs.getString(4))).salary(rs.getFloat(5)).experience(rs.getInt(6))
					.level(rs.getInt(7)).build();
		}
		
	
	}

	private Employee populateEmployee(ResultSet rs) throws SQLException {
		return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3))
				.gender(Gender.valueOf(rs.getString(4))).salary(rs.getFloat(5)).experience(rs.getInt(6))
				.level(rs.getInt(7)).build();
	}

	@Override
	public List<Employee> getAll() {
		return new JdbcTemplate(dataSource)
				.query("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE", new EmployeeRowMapper());
//		List<Employee> emps = new ArrayList<Employee>();
//		try(Connection conn  =getConnection()){
//			PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				emps.add(populateEmployee(rs));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//				return emps;
//	}

	}
}
