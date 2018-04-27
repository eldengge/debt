package com.nsm.debt.service;

import java.util.List;

import com.nsm.debt.entities.Employee;
import com.nsm.debt.entities.ObjectEmployee;
import com.nsm.debt.vo.Page;

public interface EmployeeService {

	List<Employee> getEmployeeList();

	List<ObjectEmployee> getObjectEmployeeList();

	void setObjectEmployeePage(Page<ObjectEmployee> page);

}
