package com.nsm.debt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nsm.debt.entities.Organization;
import com.nsm.debt.service.OrganizationService;

@Controller
public class IndexController {
	
	
	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping("manager_main.htm")
	public String gotoManagerMain() {
		return "manager/main";
	}
	
	@RequestMapping("employee_main.htm")
	public String gotoEmployeeMain() {
		return "manager/employee/employee_main";
	}
	
	@RequestMapping("employee_add.htm")
	public String gotoEmployeeAdd() {
		return "manager/employee/employee_add";
	}
	@RequestMapping("organization_main.htm")
	public String gotoOrganizationMain() {
		return "manager/organization/organization_main";
	}
	
	@RequestMapping("organization_add.htm")
	public String gotoOrganizationAdd() {
		return "manager/organization/organization_add";
	}
	
	@RequestMapping("organization_edit.htm")
	public String gotoOrganizationEdit(@RequestParam(value="id") Integer id,ModelMap map) {
		Organization org = organizationService.getOrganizationById(id);
		map.addAttribute("org", org);
		return "manager/organization/organization_edit";
	}
}
