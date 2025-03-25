<%@ page import = "entities.Employee"
	import = "dao.EmployeeDAO"
	import = "java.util.List"
	language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
    String sortOrder = (String) request.getAttribute("sortOrder");
    String newSortOrder = "ascending".equals(sortOrder) ? "descending" : "ascending";
    String sortIcon = "ascending".equals(sortOrder) ? "↓" : "↑";
%>
Search By:
<form action="employees" method="GET">
    <select name="searchOption" id="searchOption">
        <option value="select" selected>--Select--</option>
        <option value="name">Name</option>
        <option value="salary">Salary (>=)</option>
        <option value="level">Level</option>
        <option value="age">Age</option>
        <option value="exp">Experience</option>
    </select>
    
    <input type = "text" name = "search_value" value=""/>
    <input type="submit" value="Search">
    </br>
    
<!--         <label for="nameComb">Name: </label>
        <input type="text" id="nameComb" name="nameComb">
        <label for="salaryComb">Salary(>=): </label>
        <input type="text" id="salaryComb" name="salaryComb">
        <label for="levelComb">Level: </label>
        <input type="text" id="levelComb" name="levelComb">
        <label for="ageComb">Age: </label>
        <input type="text" id="ageComb" name="ageComb">
        <label for="expComb">Experience: </label>
        <input type="text" id="expComb" name="expComb"> -->
</form>
<table>
<tr>
		<th><a href="employees?sortOrder=<%=newSortOrder%>&sortBy=idSort">ID<%=sortIcon%></a></th>
		<th><a href="employees?sortOrder=<%=newSortOrder%>&sortBy=nameSort">Name<%=sortIcon%></a></th>
		<th><a href="employees?sortOrder=<%=newSortOrder%>&sortBy=ageSort">Age<%=sortIcon%></a></th>
		<th><a href="employees?sortOrder=<%=newSortOrder%>&sortBy=genderSort">Gender<%=sortIcon%></a></th>
		<th><a href="employees?sortOrder=<%=newSortOrder%>&sortBy=salarySort">Salary<%=sortIcon%></a></th>
		<th><a href="employees?sortOrder=<%=newSortOrder%>&sortBy=expSort">Experience<%=sortIcon%></a></th>
		<th><a href="employees?sortOrder=<%=newSortOrder%>&sortBy=levelSort">Level<%=sortIcon%></a></th>
		<th><a href="employees?sortOrder=<%=newSortOrder%>&sortBy=depSort">DeptId<%=sortIcon%></a></th>
		<th>Actions</th>
		
</tr>
<c:forEach items="${emps}" var="e">
	<tr>
		<td><c:out value="${e.id}"></c:out></td>
		<td>${e.name}</td>
		<td>${e.age}</td>
		<td>${e.gender}</td>
		<td>${e.salary}</td>
		<td>${e.experience}</td>
		<td>${e.level}</td>
		<td>${e.deptId}</td>
		<td>
			<a href="employees?operation=Update&id=${e.id}">Update</a>
			<a href="employees?operation=Delete&id=${e.id}">Delete</a>
		</td>
	</tr>
</c:forEach>	
<tr>
	<td colspan="7">
		<a href="employees?operation=new">New Employee</a>
	</td>
</tr>
</table>
<table>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Gender</th>
		<th>Salary</th>
		<th>Experience</th>
		<th>Level</th>
		<th>DeptId</th>
		
	</tr>
	<% 
	List<Employee> emps = (List<Employee>)request.getAttribute("emps");
	for(Employee e:emps){
	
	%>
	<tr>
		<td><%=e.getId() %></td>
		<td><%=e.getName() %></td>
		<td><%=e.getAge() %></td>
		<td><%=e.getGender() %></td>
		<td><%=e.getSalary() %></td>
		<td><%=e.getExperience() %></td>
		<td><%=e.getLevel() %></td>
		<td><%=e.getDeptId() %></td>
		
	</tr>
	
	<%} %>

</table>


</body>
</html>