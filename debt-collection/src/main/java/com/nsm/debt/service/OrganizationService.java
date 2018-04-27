package com.nsm.debt.service;

import java.util.List;

import com.nsm.debt.entities.Organization;

public interface OrganizationService {

	List<Organization> getOrganizationList();

	int addOrganization(Organization org);

	Organization getOrganizationById(Integer id);

	int updateOrganization(Organization org);

	void delOrganization(Integer[] ids);

}
