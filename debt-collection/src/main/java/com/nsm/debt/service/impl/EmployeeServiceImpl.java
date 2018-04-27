package com.nsm.debt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsm.debt.dao.EmployeeMapper;
import com.nsm.debt.entities.Employee;
import com.nsm.debt.entities.ObjectEmployee;
import com.nsm.debt.service.EmployeeService;
import com.nsm.debt.vo.Page;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeMapper employeeDao;

	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return employeeDao.selectAll();
	}

	@Override
	public List<ObjectEmployee> getObjectEmployeeList() {
		// TODO Auto-generated method stub
		return employeeDao.queryAllEmployee();
	}

	@Override
	public void setObjectEmployeePage(Page<ObjectEmployee> page) {
		// TODO Auto-generated method stub
		Integer count = employeeDao.queryCount();
		page.setTotalno(count);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("page", page);
		List<ObjectEmployee> list=employeeDao.queryObjectEmployeePage(param);
		page.setDatas(list);
	} 
}
