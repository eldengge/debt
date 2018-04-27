package com.nsm.debt.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nsm.debt.dao.EmployeeMapper;
import com.nsm.debt.dao.OrganizationMapper;
import com.nsm.debt.entities.Organization;
import com.nsm.debt.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService{
	
	@Autowired
	private OrganizationMapper organzationDao;
	
	@Autowired
	private EmployeeMapper employeeDao;

	@Override
	public List<Organization> getOrganizationList() {
		// TODO Auto-generated method stub
		return organzationDao.selectAll();
	}

	@Override
	public int addOrganization(Organization org) {
		// TODO Auto-generated method stub
		if(org.getType()==(byte)1) {
			org.setParentId(Integer.toString(0));
		}
		org.setCreateTime(new Date());
		org.setModifyTime(new Date());
		org.setVersion(1);
		org.setStatus(1);
		org.setOrderNo(0);
		org.setCode("1");
		org.setPath("1");
		return organzationDao.insert(org);
	}

	@Override
	public Organization getOrganizationById(Integer id) {
		// TODO Auto-generated method stub
		return organzationDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateOrganization(Organization org) {
		// TODO Auto-generated method stub
		if(org.getType()==(byte)1) {
			org.setParentId(Integer.toString(0));
		}
		org.setModifyTime(new Date());
		return organzationDao.updateByPrimaryKey(org);
	}

	@Override
	public void delOrganization(Integer[] ids) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("ids", ids);
		map.put("modifyTime", new Date());
		map.put("status", 0);
		organzationDao.deleteByPrimaryKeys(map);
		employeeDao.updateStatusByOrgId(map);
		//throw new RuntimeException();
	}

}
