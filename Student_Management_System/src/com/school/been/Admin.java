package com.school.been;

public class Admin {
	
	private int AdminId;
	private String AdminName;
	private String AdminAddress;
	private String AdminEmail;
	private String adminMobile;
	
	
	public int getAdminId() {
		return AdminId;
	}
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}
	public String getAdminAddress() {
		return AdminAddress;
	}
	public void setAdminAddress(String adminAddress) {
		AdminAddress = adminAddress;
	}
	public String getAdminEmail() 
	{
		return AdminEmail;
	}
	public void setAdminEmail(String adminEmail) 
	{
		AdminEmail = adminEmail;
	}
	public String getAdminMobile()
	{
		return adminMobile;
	}
	public void setAdminMobile(String adminMobile) 
	{
		this.adminMobile = adminMobile;
	}
	
	
	
	public String getAdminName() 
	{
		return AdminName;
	}
	public void setAdminName(String adminName) 
	{
		AdminName = adminName;
	}
	
	
	public Admin() 
	{
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminId, String adminName, String adminAddress, String adminEmail, String adminMobile) {
		super();
		AdminId = adminId;
		AdminName = adminName;
		AdminAddress = adminAddress;
		AdminEmail = adminEmail;
		this.adminMobile = adminMobile;
	}
	
	@Override
	public String toString() 
	{
		return "Admin [AdminId=" + AdminId + ", AdminName=" + AdminName + ", AdminAddress=" + AdminAddress
				+ ", AdminEmail=" + AdminEmail + ", adminMobile=" + adminMobile + "]";
	}
	
	

}
