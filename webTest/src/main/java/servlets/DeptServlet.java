package servlets;

import java.io.IOException;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/depts")
public class DeptServlet extends HttpServlet {

	private EmployeeDAO edao;
	private DeptDAO deptDAO;
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("1st..................");
		deptDAO = new DeptDAOImpl(config.getServletContext());
		edao = new EmployeeDAOImpl(config.getServletContext());
		System.out.println("2nd..................");

//		deptDAO.save(new Dept(1,"HR","Blr"));
//		deptDAO.save(new Dept(2,"HR","Ahm"));
//		deptDAO.save(new Dept(3,"Dev","Blr"));
//		deptDAO.save(new Dept(4,"Dev","Ahm"));


	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		String operation = req.getParameter("operation");
		HttpSession session = req.getSession();
		Dept current = (Dept) session.getAttribute("current");
		if(current == null) {
			current = deptDAO.first();
		}
		else {
			if("First".equals(operation)) {
				current = deptDAO.first();
			}
			else if("Last".equals(operation)){
				current = deptDAO.last();
			}
			else if("Previous".equals(operation)){
				current = deptDAO.previous(current.getId());
			}
			
			else if("Next".equals(operation)){
				current = deptDAO.next(current.getId());
			}
			else if("Update".equals(operation)) {
				req.setAttribute("mode", "Update");
				req.setAttribute("dep", current);
				req.setAttribute("readonly", "readonly");

				req.getRequestDispatcher("editDept.jsp").forward(req, resp);
				return;				
			}
			else if("New".equals(operation)) {
				req.setAttribute("mode", "New");
				req.setAttribute("dep", current);
				req.getRequestDispatcher("editDept.jsp").forward(req, resp);
				return;	
			}
			else if("Delete".equals(operation)) {
				deptDAO.delete(current.getId());
				current = deptDAO.first();
//				req.setAttribute("dept", deptDAO.first());
//				req.getRequestDispatcher("depts.jsp").forward(req, resp);
//				return;
			}
		}
		String mode = (String) req.getParameter("operationEdit");
		
		
					
		if("Update".equals(mode)) {
			Dept dept  = new Dept(Integer.parseInt(req.getParameter("eid")), req.getParameter("ename"), req.getParameter("elocation"));
			deptDAO.update(dept);
			req.setAttribute("dept", deptDAO.getDept(dept.getId()));
//			req.setAttribute("readonly", "readonly");
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
			}
		if("Cancel".equals(mode)) {
			req.setAttribute("dept", deptDAO.getDept(current.getId()));
//			req.setAttribute("readonly", "readonly");
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
			}
//		if("Delete".equals(mode)) {
////			Dept dept  = new Dept(Integer.parseInt(req.getParameter("eid")), req.getParameter("ename"), req.getParameter("elocation"));
//			deptDAO.delete(current.getId());
//			req.setAttribute("dept", deptDAO.first());
//			req.getRequestDispatcher("depts.jsp").forward(req, resp);
//			return;
//			}
		if("New".equals(mode)) {
			Dept dept  = new Dept(Integer.parseInt(req.getParameter("eid")), req.getParameter("ename"), req.getParameter("elocation"));
			deptDAO.save(dept);
			current = deptDAO.getDept(dept.getId());
//			req.setAttribute("dept", deptDAO.getDept(dept.getId()));
//			session.setAttribute("empByDept",edao.getEmpByDept(current.getId()));
//			req.getRequestDispatcher("depts.jsp").forward(req, resp);
//			return;
			}
		
//			System.out.println("Hi update............");
//			deptDAO.update(dept);
//			req.setAttribute("dept", deptDAO.getDept(dept.getId()));
//			System.out.println(req.getAttribute("dept"));
//			req.getRequestDispatcher("depts.jsp").forward(req, resp);
//			System.out.println("Hi update part 2..............................");
//
//			return;
//		}
		System.out.println(deptDAO.first());
		session.setAttribute("current", current);
		session.setAttribute("dept", current);
//		System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		System.out.println("tttttttttttttttt"+current.getId());
		session.setAttribute("empByDept",edao.getEmpByDept(current.getId()));
		System.out.println(session.getAttribute("empByDept"));
//		System.out.println(session.getAttribute("empByDept"));

		
//		Cookie[] cookies = req.getCookies();
//		for(int i = 0; i< cookies.length;i++) {
//			System.out.println(cookies[i].getName()+" "+cookies[i].getValue());
//		}
		resp.addCookie(new Cookie("operation",operation));
		req.getRequestDispatcher("depts.jsp").forward(req, resp);
		

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		System.out.println(deptDAO.first());
		req.setAttribute("dept", deptDAO.first());
//		System.out.println(deptDAO.first());
		HttpSession session = req.getSession();
		session.setAttribute("current",deptDAO.first());
		
		Dept current = (Dept) session.getAttribute("current");
//		int id = current.getId();
		session.setAttribute("empByDept", edao.getEmpByDept(current.getId()));
		System.out.println("uuuuuuuuuuuuuuuuuuu"+session.getAttribute("current"));
		req.getRequestDispatcher("depts.jsp").forward(req, resp);
		
	}
}
