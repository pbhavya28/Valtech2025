package servlets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import jakarta.servlet.ServletContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeptDAOImpl implements DeptDAO {

	ServletContext sc;
//	static {
//		try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//						e.printStackTrace();
//		}
//	}
	
	
	public DeptDAOImpl(ServletContext sc) {
		this.sc = sc;
	}

	private Connection getConnection(ServletContext sc) throws SQLException {
		String url = (String)sc.getAttribute("url");
		String username = (String)sc.getAttribute("username");
		String password = (String)sc.getAttribute("password");

//		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgres");
		return DriverManager.getConnection(url,username,password);

	}


	@Override
	public Dept first() {
			
		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement("select id, name, location  from dept where id = (select min(id) from dept)");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			 //if this returns true then we have another row. next return false, we are at the end of resultset.
			 Dept dept = populateDept(rs);
			 return dept;
			}
			else {
				new RuntimeException("No Department found.");
			}
			
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		
		return null;
	}

	@Override
	public Dept last() {
		
		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement("select id, name, location  from dept where id = (select max(id) from dept)");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			 //if this returns true then we have another row. next return false, we are at the end of resultset.
			 Dept dept = populateDept(rs);
			 return dept;
			}
			else {
				new RuntimeException("No Department found.");
			}
			
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		return null;
	}

	@Override
	public Dept next(int id) {
		DeptDAO dao = new DeptDAOImpl(this.sc);
		if(id == dao.last().getId()) {
			return dao.first();
		}
		else {		
		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement("select id, name, location  from dept where id = (select MIN(id) from dept where id > ?)");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			 //if this returns true then we have another row. next return false, we are at the end of resultset.
			 Dept dept = populateDept(rs);
			 return dept;
			}
			else {
				new RuntimeException("No Department with id "+id+" found.");
			}
			
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		return null;
	}
	}

	@Override
	public Dept previous(int id) {
		DeptDAO dao = new DeptDAOImpl(this.sc);
		if(id == dao.first().getId()) {
			return dao.last();
		}
		else {		
		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement("select id, name, location  from dept where id = (select MAX(id) from dept where id < ?)");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			 //if this returns true then we have another row. next return false, we are at the end of resultset.
			 Dept dept = populateDept(rs);
			 return dept;
			}
			else {
				new RuntimeException("No Department with id "+id+" found.");
			}
			
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		return null;
		}
	}

	private void setValuesToPreparedStatement(Dept dept, PreparedStatement ps) throws SQLException {
		ps.setInt(1, dept.getId());
		ps.setString(2, dept.getName());
		ps.setString(3, dept.getLocation());
		ps.setInt(4, dept.getId());


	
	}
	@Override
	public void save(Dept dept) {
				
		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement
					("INSERT INTO DEPT(ID, NAME, LOCATION) VALUES (?,?,?)");
//			setValuesToPreparedStatement(dept, ps);
			ps.setInt(1, dept.getId());
			ps.setString(2, dept.getName());
			ps.setString(3, dept.getLocation());
			
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Inserted: "+rowsAffected);
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void update(Dept dept) {
				
		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement
					("UPDATE DEPT SET ID=?, NAME=?, LOCATION=? WHERE ID=?");
			setValuesToPreparedStatement(dept, ps);
			
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Updated: "+rowsAffected);
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public Dept getDept(int id) {
		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement("Select ID,NAME,LOCATION from Dept where ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			 //if this returns true then we have another row. next return false, we are at the end of resultset.
			 Dept dept = populateDept(rs);
			 return dept;
			}
			else {
				new RuntimeException("No Department with id "+id+" found.");
			}
			
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		return null;
	}

	@Override
	public void delete(int id) {
			
		try(Connection conn = getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement("Delete from Dept where ID=?");
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Deleted: "+rowsAffected);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Dept> getAll() {
		
		List<Dept> depts = new ArrayList<Dept>();
		try(Connection conn  =getConnection(this.sc)){
			PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,LOCATION FROM Dept");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				depts.add(populateDept(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				return depts;
	}
	
	private Dept populateDept(ResultSet rs) throws SQLException {
		Dept dept = new Dept();
		dept.setId(rs.getInt(1));
		dept.setName(rs.getString(2));
		dept.setLocation(rs.getString(3));
		return dept;
	}

}
	
//	private Map<Integer,Dept> depts;
//	
//	public DeptDAOImpl() {
//		depts = new HashMap<Integer,Dept>();
//	}
//	
//	@Override
//	public void save(Dept dept) {
//		depts.put(dept.getId(),dept);
//	}
//	
//	@Override
//	public void update(Dept dept) {
//		depts.put(dept.getId(), dept);
//	}
//	
//	@Override
//	public Dept getDept(int id) {
//		return depts.get(id);
//	}
//	
//	@Override
//	public void delete(int id) {
//		depts.remove(id);
//	}
//	@Override
//	public Set<Dept> getAll(){
//		Set<Dept> all =  new HashSet<Dept>();
//		for(int id: depts.keySet()) {
//			all.add(depts.get(id));
//		}
//		return all;
//	}
//
//	@Override
//	public Dept first() {
//		return depts.get(depts.keySet().stream().min((a,b)->(a - b)).get());
//	}
//
//	@Override
//	public Dept last() {
//		return depts.get(depts.keySet().stream().max((a,b)->(a - b)).get());
//	}
//
//	@Override
//	public Dept next(int id) {
//		if(id == depts.size()) {
//			return depts.get(depts.size());
//		}
//		return depts.get(id+1);
//	}
//
//	@Override
//	public Dept previous(int id) {
//		if(id == 1) {
//			return depts.get(1);
//		}
//		return depts.get(id - 1);
//	}
//}
