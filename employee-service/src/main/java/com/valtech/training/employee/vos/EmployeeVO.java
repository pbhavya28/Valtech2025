package com.valtech.training.employee.vos;

import com.valtech.training.employee.entities.Employee;

public record EmployeeVO(long id, String name, long mobile, String email, long managerId) {

	public static EmployeeVO from(Employee employee) {
		long manId = employee.getManager() == null ? 0 : employee.getManager().getId();
		return new EmployeeVO(employee.getId(),employee.getName(),employee.getMobile(),
				employee.getEmail(),manId);
	}
	public Employee to(Employee manager) {
		Employee e = new Employee(id, name, mobile, email);
		e.setManager(manager);
		return e;
	}
}
