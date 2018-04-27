package com.nsm.debt.entities;

import java.util.ArrayList;
import java.util.List;

public class ObjectOrgIds {
	private Integer id;
	private Integer pid;
	private List<ObjectOrgIds> childs=new ArrayList<ObjectOrgIds>();
	public ObjectOrgIds() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public List<ObjectOrgIds> getChilds() {
		return childs;
	}
	public void setChilds(List<ObjectOrgIds> childs) {
		this.childs = childs;
	}
	@Override
	public String toString() {
		return "ObjectOrgIds [id=" + id + ", pid=" + pid + ", childs=" + childs + "]";
	}
}
