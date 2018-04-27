package com.nsm.debt.dao;

import com.nsm.debt.entities.Organization;
import java.util.List;
import java.util.Map;

public interface OrganizationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Organization record);

    Organization selectByPrimaryKey(Integer id);

    List<Organization> selectAll();

    int updateByPrimaryKey(Organization record);

	void deleteByPrimaryKeys(Map<String, Object> map);
    
}