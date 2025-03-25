package com.valtech.training.employee.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.employee.entities.Employee;
import com.valtech.training.employee.repos.EmployeeRepo;
import com.valtech.training.employee.vos.EmployeeVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public EmployeeVO saveOrUpdateEmployee(EmployeeVO employee) {
		Employee manager = employee.managerId()==0 ? null :  employeeRepo.getReferenceById(employee.managerId());
		return EmployeeVO.from(employeeRepo.save(employee.to(manager)));
	}
	@Override
	public EmployeeVO getEmployee(long id) {
		return EmployeeVO.from(employeeRepo.getReferenceById(id));
	}
	@Override
	public List<EmployeeVO> getAllEmployees(){
		return employeeRepo.findAll().stream().map(e -> EmployeeVO.from(e)).collect(Collectors.toList());
	}
}
