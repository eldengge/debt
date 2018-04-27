package com.nsm.debt.vo;

import java.util.List;

public class ResponseData<T> {
	private String message;
	private T data;
	private List<T> datas;
	
	
	public ResponseData() {
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	
}
