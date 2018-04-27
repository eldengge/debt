package com.nsm.debt.entities;

import java.util.Date;

public class Organization {
    private Integer id;

    private Date createTime;

    private Date modifyTime;

    private Integer version;

    private Integer status;

    private String name;

    private String parentId;

    private String address;

    private String phone;

    private String postCode;

    private String fax;

    private Byte type;

    private Integer orderNo;

    private String code;

    private String principalId;

    private String path;
    
    private Integer _parentId;
    

	public Integer get_parentId() {
		return Integer.parseInt(parentId);
	}

	public void set_parentId(Integer _parentId) {
		this._parentId = _parentId;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(String principalId) {
        this.principalId = principalId == null ? null : principalId.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

	@Override
	public String toString() {
		return "Organization [id=" + id + ", createTime=" + createTime + ", modifyTime=" + modifyTime + ", version="
				+ version + ", status=" + status + ", name=" + name + ", parentId=" + parentId + ", address=" + address
				+ ", phone=" + phone + ", postCode=" + postCode + ", fax=" + fax + ", type=" + type + ", orderNo="
				+ orderNo + ", code=" + code + ", principalId=" + principalId + ", path=" + path + ", _parentId="
				+ _parentId + "]";
	}
    
}