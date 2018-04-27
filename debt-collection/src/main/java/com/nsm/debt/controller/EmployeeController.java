package com.nsm.debt.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nsm.debt.entities.ObjectEmployee;
import com.nsm.debt.service.EmployeeService;
import com.nsm.debt.vo.Page;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@ResponseBody
	@RequestMapping("getEmployeeListJson.do")
	public List<ObjectEmployee> getEmployeeListJson() {
		List<ObjectEmployee> list=employeeService.getObjectEmployeeList();
		return list;
		
	}
	
	@ResponseBody
	@RequestMapping("getPageEmployeeListJson.do")
	public Page<ObjectEmployee> getPageEmployeeListJson(@RequestParam(value="pageno",defaultValue="1") Integer pageno,@RequestParam(value="pagesize",defaultValue="1")Integer pagesize){
		//System.out.println(pageno+"   "+pagesize);
		Page<ObjectEmployee> page=new Page<ObjectEmployee>(pagesize, pageno);
		employeeService.setObjectEmployeePage(page);
		System.out.println(page);
		return page;
	} 
}
