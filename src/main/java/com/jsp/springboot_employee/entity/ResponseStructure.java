package com.jsp.springboot_employee.entity;

public class ResponseStructure<E>
{
	private int statuscode;
	private String message;
	private E data;
	
	public int getStatuscode() 
	{
		return statuscode;
	}
	public void setStatuscode(int statuscode)
	{
		this.statuscode = statuscode;
	}
	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
	}
	public E getData()
	{
		return data;
	}
	public void setData(E data)
	{
		this.data = data;
	}
	
	
	
	

}
