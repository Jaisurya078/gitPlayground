package com.example.simpleProject.common;

public class APIResponce 
{

	private Integer status;
	private Object data;
	private Object errors;
	
	
	public APIResponce() {
		super();
		this.status = 200;
		this.data = data;
		this.errors = errors;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getErrors() {
		return errors;
	}
	public void setErrors(Object errors) {
		this.errors = errors;
	}

}
