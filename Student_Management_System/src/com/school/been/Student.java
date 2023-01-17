package com.school.been;

public class Student 
{
	
	private int stdID;
	private String StdName;
	private String Address;
	private String email;
	private String mobile;
	public int getStdID() {
		return stdID;
	}
	
	
	public void setStdID(int stdID) 
	{
		this.stdID = stdID;
	}
	public String getStdName() 
	{
		return StdName;
	}
	public void setStdName(String stdName)
	{
		StdName = stdName;
	}
	public String getAddress() 
	{
		return Address;
	}
	public void setAddress(String address) 
	{
		Address = address;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getMobile() 
	{
		return mobile;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}
	
	public Student()
	{
		// TODO Auto-generated constructor stub
	}
	public Student(int stdID, String stdName, String address, String email, String mobile)
	{
		super();
		this.stdID = stdID;
		StdName = stdName;
		Address = address;
		this.email = email;
		this.mobile = mobile;
	}
	@Override
	public String toString() 
	{
		return "Student [stdID=" + stdID + ", StdName=" + StdName + ", Address=" + Address + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}
	
	

}
