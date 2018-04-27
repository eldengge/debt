package com.nsm.debt.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.nsm.debt.entities.Employee;
import com.nsm.debt.entities.Organization;
import com.nsm.debt.service.EmployeeService;
import com.nsm.debt.service.OrganizationService;
import com.nsm.debt.vo.ResponseData;

@Controller
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping("getOrganizationList.do")
	public String getOrganizationList(Map<Object,Object> map) {
		List<Organization> list = organizationService.getOrganizationList();
		map.put("orgList", list);
		return "manager/organization/organizationListInner";
	}
	
	@ResponseBody
	@RequestMapping("getOrganizationListJson.do")
	public List<Organization> getOrganizationListJson() {
		List<Organization> list = organizationService.getOrganizationList();
		return list;
	}
	
	@ResponseBody
	@RequestMapping("getOrganizationMapJson.do")
	public Map<String,Object> getOrganizationMapJson() {
		List<Organization> list = organizationService.getOrganizationList();
		/*for (Organization organization : list) {
			System.out.println(organization);
		}*/
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("rows", list);
		return map;
	}
	
	@RequestMapping("organization_add.do")
	public ModelAndView addOrganization(Organization org) {
		organizationService.addOrganization(org);
		ModelAndView mv=new ModelAndView("redirect:/organization_main.htm");
		return mv;
	}
	
	
	@RequestMapping("organization_edit.do")
	public ModelAndView editOrganization(Organization org) {
		organizationService.updateOrganization(org);
		ModelAndView mv=new ModelAndView("redirect:/organization_main.htm");
		return mv;
	}
	@ResponseBody
	@RequestMapping("organization_del.do")
	public ResponseData<Organization> organizationDel(@RequestParam("ids[]") Integer[] ids){
		ResponseData<Organization> data=new ResponseData<Organization>();
		organizationService.delOrganization(ids);
		data.setMessage("删除成功");
		return data;
	}
	
}
