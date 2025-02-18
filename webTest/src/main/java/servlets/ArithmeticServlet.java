package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ArithmeticServlet extends HttpServlet {

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.getWriter().print("");
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String content = """ 
//				<!DOCTYPE html>
//<html>
//<head>
//<meta charset="UTF-8">
//<title>Insert title here</title>
//</head>
//<body>
//
//	<form method ="post" action = "arithmetic">
//	   A = <input type="text" name="a"/></br>
//	   B = <input type="text" name="b"/></br>
//	   <input type="submit" name="operation" value="add"/>
//	   <input type="submit" name="operation" value="subtract"/>
//	   <input type="submit" name="operation" value="multiply"/>
//	   <input type="submit" name="operation" value="division"/>
//	   
//	   
//	</form>
//
//</body>
//</html>
//				""";
//		resp.getWriter().print(content);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int a = Integer.parseInt(req.getParameter("a"));
		int b = Integer.parseInt(req.getParameter("b"));
		
		String operation = req.getParameter("operation");
//from the servlet, we have to only call the business logic, not write it.
		
		int result=0;
		if("add".equals(operation)) {
			 result = a+b;
		}
		else if("subtract".equals(operation)) {
			 result = a-b;
		}
		else if("multiply".equals(operation)) {
			 result = a*b;
		}
		else {
			 result = a/b;
		}
		
		System.out.println(MessageFormat.format("A = {0} {1} B = {2} = {3}",a,operation,b,result));
		PrintWriter out = resp.getWriter();
		
		/*
		 * we need to storenand pass the result to arithmetic.jsp page
		 * we have to go to the arithmetic.jsp page
		 */
		
		req.setAttribute("result", result);
		req.getRequestDispatcher("arithmetic.jsp").forward(req, resp);
		
		
//		System.out.println("A "+operation+" B= "+result);
		
//		String content = """ 
//				<!DOCTYPE html>
//<html>
//<head>
//<meta charset="UTF-8">
//<title>Insert title here</title>
//</head>
//<body>
//A = {0}<br/>
//B = {1}<br/>
//
//Operation = {2}<br/>
//Result = {3}<br/>
//	<form method ="post" action = "arithmetic">
//	   A = <input type="text" name="a"/></br>
//	   B = <input type="text" name="b"/></br>
//	   <input type="submit" name="operation" value="add"/>
//	   <input type="submit" name="operation" value="subtract"/>
//	   <input type="submit" name="operation" value="multiply"/>
//	   <input type="submit" name="operation" value="division"/>
//	   
//	   
//	</form>
//
//</body>
//</html>
//				""";
//		out.print(MessageFormat.format(content, a,b,operation,result));
//		
	}
		
}
