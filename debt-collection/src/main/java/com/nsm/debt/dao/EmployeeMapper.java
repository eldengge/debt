package com.nsm.debt.dao;

import com.nsm.debt.entities.Employee;
import com.nsm.debt.entities.ObjectEmployee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Integer id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);
    
    int queryCount();
    
    List<ObjectEmployee> queryAllEmployee();

	List<ObjectEmployee> queryObjectEmployeePage(Map<String, Object> param);
	
    int updateStatusByOrgId(Map<String, Object> param);
}