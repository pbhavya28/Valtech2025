package servlets;

import java.io.IOException;

import dao.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import dao.Employee.Gender;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/employees")
public class EmployeesServlet extends HttpServlet {

	private EmployeeDAO dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new EmployeeDAOImpl(config.getServletContext());		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		if("Cancel".equals(operation)) {
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
			Employee emp = Employee.builder().id(Integer.parseInt(req.getParameter("id"))).
					name(req.getParameter("name"))
					.age(Integer.parseInt(req.getParameter("age")))
					.gender(Gender.valueOf(req.getParameter("gender").toUpperCase()))
					.salary(Integer.parseInt(req.getParameter("salary")))
					.experience(Integer.parseInt(req.getParameter("experience")))
					.level(Integer.parseInt(req.getParameter("level")))
					.deptId(Integer.parseInt(req.getParameter("deptId"))).build();
		if("Save".equals(operation)) {
			dao.save(emp);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			
			return;
		}
		if("Update".equals(operation)) {
		dao.update(emp);
		req.setAttribute("emps", dao.getAll());
		req.getRequestDispatcher("employees.jsp").forward(req, resp);
		return;
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		

		String operation = req.getParameter("operation");
		if("Update".equals(operation)) {
			
			int id = Integer.parseInt(req.getParameter("id"));
			Employee e = dao.get(id);
			req.setAttribute("readonly","readonly");
			req.setAttribute("emp", e);
			req.setAttribute("mode", "Update");
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
			return;
		}
		if("new".equals(operation)) {
			req.setAttribute("mode", "Save");
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
			return;
		}
		if("Delete".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			dao.delete(id);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		System.out.println("DAO = "+dao.getAll().size());
//		req.setAttribute("emps", dao.getAll());
//		req.getRequestDispatcher("employees.jsp").forward(req, resp);
//		
		//-------------------------------------------------
		
//		String nameComb = req.getParameter("nameComb");
//		String salaryComb = req.getParameter("salaryComb");
//		String levelComb = req.getParameter("levelComb");
//		String ageComb = req.getParameter("ageComb");
//		String expComb = req.getParameter("nameComb");
//
//		List<Employee>
//		System.out.println("qqqqqqqqqqqqqq"+nameComb + " "+ salaryComb+" "+levelComb+" "+ageComb+" "+expComb);
//		------------------------------------------
		String searchOption = req.getParameter("searchOption");
		if("name".equals(searchOption)) {
//			String search_value = (String)req.getParameter("search_value");
//			System.out.println(search_value);
//			System.out.println(dao.getSearchByName(req.getParameter("search_value")));
     		req.setAttribute("emps", dao.getSearchByName(req.getParameter("search_value").toLowerCase()));
//     		System.out.println(req.getAttribute("emps")+"jjjj");
            req.getRequestDispatcher("employees.jsp").forward(req, resp);
            return;		
		}
		else if("salary".equals(searchOption)) {
//			String search_value = (String)req.getParameter("search_value");
//			System.out.println(search_value);
//			System.out.println(dao.getSearchByName(req.getParameter("search_value")));
     		req.setAttribute("emps", dao.getSearchBySal(Long.parseLong(req.getParameter("search_value"))));
//     		System.out.println(req.getAttribute("emps")+"jjjj");
            req.getRequestDispatcher("employees.jsp").forward(req, resp);
            return;		
		}
		else if("level".equals(searchOption)) {
//			String search_value = (String)req.getParameter("search_value");
//			System.out.println(search_value);
//			System.out.println(dao.getSearchByName(req.getParameter("search_value")));
     		req.setAttribute("emps", dao.getSearchByLevel(Integer.parseInt(req.getParameter("search_value"))));
//     		System.out.println(req.getAttribute("emps")+"jjjj");
            req.getRequestDispatcher("employees.jsp").forward(req, resp);
            return;		
		}
		else if("age".equals(searchOption)) {
//			String search_value = (String)req.getParameter("search_value");
//			System.out.println(search_value);
//			System.out.println(dao.getSearchByName(req.getParameter("search_value")));
     		req.setAttribute("emps", dao.getSearchByAge(Integer.parseInt(req.getParameter("search_value"))));
//     		System.out.println(req.getAttribute("emps")+"jjjj");
            req.getRequestDispatcher("employees.jsp").forward(req, resp);
            return;		
		}
		else if("exp".equals(searchOption)) {
//			String search_value = (String)req.getParameter("search_value");
//			System.out.println(search_value);
//			System.out.println(dao.getSearchByName(req.getParameter("search_value")));
     		req.setAttribute("emps", dao.getSearchByExp(Integer.parseInt(req.getParameter("search_value"))));
//     		System.out.println(req.getAttribute("emps")+"jjjj");
            req.getRequestDispatcher("employees.jsp").forward(req, resp);
            return;		
		}

		else {

			String sortBy = req.getParameter("sortBy");
	        String sortOrder = req.getParameter("sortOrder");
	        if (sortOrder == null) {
	            sortOrder = "ascending";
	        }
	        if("idSort".equals(sortBy)) {
	             	if ("descending".equals(sortOrder)) {
	             		req.setAttribute("emps", dao.sortByIdDesc());
	             	} 
	             	else {
	        		req.setAttribute("emps", dao.sortByIdAsc());

	             	}
	        }
	        else if("nameSort".equals(sortBy)){
	        	 	if ("descending".equals(sortOrder)) {
	        	 		req.setAttribute("emps", dao.sortByNameDesc());
	        	 	} 
	        	 	else {
	        	 		req.setAttribute("emps", dao.sortByNameAsc());

	        	 	}
	        	
	        	
	        }
	        else if("ageSort".equals(sortBy)){
	    	 	if ("descending".equals(sortOrder)) {
	    	 		req.setAttribute("emps", dao.sortByAgeDesc());
	    	 	} 
	    	 	else {
	    	 		req.setAttribute("emps", dao.sortByAgeAsc());

	    	 	}
	        }
	    	else if("genderSort".equals(sortBy)){
	        	 	if ("descending".equals(sortOrder)) {
	        	 		req.setAttribute("emps", dao.sortByGenderDesc());
	        	 	} 
	        	 	else {
	        	 		req.setAttribute("emps", dao.sortByGenderAsc());

	        	 	}	
	    	}
	    	else if("salarySort".equals(sortBy)){
	    	 	if ("descending".equals(sortOrder)) {
	    	 		req.setAttribute("emps", dao.sortBySalaryDesc());
	    	 	} 
	    	 	else {
	    	 		req.setAttribute("emps", dao.sortBySalaryAsc());

	    	 	}	
		}
	    	else if("expSort".equals(sortBy)){
	    	 	if ("descending".equals(sortOrder)) {
	    	 		req.setAttribute("emps", dao.sortByExpDesc());
	    	 	} 
	    	 	else {
	    	 		req.setAttribute("emps", dao.sortByExpAsc());

	    	 	}	
		}
	    	else if("levelSort".equals(sortBy)){
	    	 	if ("descending".equals(sortOrder)) {
	    	 		req.setAttribute("emps", dao.sortByLevelDesc());
	    	 	} 
	    	 	else {
	    	 		req.setAttribute("emps", dao.sortByLevelAsc());

	    	 	}	
		}
	    	else if("depSort".equals(sortBy)){
	    	 	if ("descending".equals(sortOrder)) {
	    	 		req.setAttribute("emps", dao.sortByDepDesc());
	    	 	} 
	    	 	else {
	    	 		req.setAttribute("emps", dao.sortByDepAsc());

	    	 	}	
		}
	    	else {
	         	if ("descending".equals(sortOrder)) {
	         		req.setAttribute("emps", dao.sortByIdDesc());
	         	} 
	         	else {
	    		req.setAttribute("emps", dao.sortByIdAsc());

	         	}
	    }



	        req.setAttribute("sortOrder", sortOrder); // Pass current sort order to the JSP

	         req.getRequestDispatcher("employees.jsp").forward(req, resp);
		}
		
		//-------------------------------------------------
	
//		String sortBy = req.getParameter("sortBy");
//        String sortOrder = req.getParameter("sortOrder");
//        if (sortOrder == null) {
//            sortOrder = "ascending";
//        }
//        if("idSort".equals(sortBy)) {
//             	if ("descending".equals(sortOrder)) {
//             		req.setAttribute("emps", dao.sortByIdDesc());
//             	} 
//             	else {
//        		req.setAttribute("emps", dao.sortByIdAsc());
//
//             	}
//        }
//        else if("nameSort".equals(sortBy)){
//        	 	if ("descending".equals(sortOrder)) {
//        	 		req.setAttribute("emps", dao.sortByNameDesc());
//        	 	} 
//        	 	else {
//        	 		req.setAttribute("emps", dao.sortByNameAsc());
//
//        	 	}
//        	
//        	
//        }
//        else if("ageSort".equals(sortBy)){
//    	 	if ("descending".equals(sortOrder)) {
//    	 		req.setAttribute("emps", dao.sortByAgeDesc());
//    	 	} 
//    	 	else {
//    	 		req.setAttribute("emps", dao.sortByAgeAsc());
//
//    	 	}
//        }
//    	else if("genderSort".equals(sortBy)){
//        	 	if ("descending".equals(sortOrder)) {
//        	 		req.setAttribute("emps", dao.sortByGenderDesc());
//        	 	} 
//        	 	else {
//        	 		req.setAttribute("emps", dao.sortByGenderAsc());
//
//        	 	}	
//    	}
//    	else if("salarySort".equals(sortBy)){
//    	 	if ("descending".equals(sortOrder)) {
//    	 		req.setAttribute("emps", dao.sortBySalaryDesc());
//    	 	} 
//    	 	else {
//    	 		req.setAttribute("emps", dao.sortBySalaryAsc());
//
//    	 	}	
//	}
//    	else if("expSort".equals(sortBy)){
//    	 	if ("descending".equals(sortOrder)) {
//    	 		req.setAttribute("emps", dao.sortByExpDesc());
//    	 	} 
//    	 	else {
//    	 		req.setAttribute("emps", dao.sortByExpAsc());
//
//    	 	}	
//	}
//    	else if("levelSort".equals(sortBy)){
//    	 	if ("descending".equals(sortOrder)) {
//    	 		req.setAttribute("emps", dao.sortByLevelDesc());
//    	 	} 
//    	 	else {
//    	 		req.setAttribute("emps", dao.sortByLevelAsc());
//
//    	 	}	
//	}
//    	else if("depSort".equals(sortBy)){
//    	 	if ("descending".equals(sortOrder)) {
//    	 		req.setAttribute("emps", dao.sortByDepDesc());
//    	 	} 
//    	 	else {
//    	 		req.setAttribute("emps", dao.sortByDepAsc());
//
//    	 	}	
//	}
//    	else {
//         	if ("descending".equals(sortOrder)) {
//         		req.setAttribute("emps", dao.sortByIdDesc());
//         	} 
//         	else {
//    		req.setAttribute("emps", dao.sortByIdAsc());
//
//         	}
//    }
//
//
//
//        req.setAttribute("sortOrder", sortOrder); // Pass current sort order to the JSP
//
//         req.getRequestDispatcher("employees.jsp").forward(req, resp);
//       
		//-------------------------------------------------
	}
}
