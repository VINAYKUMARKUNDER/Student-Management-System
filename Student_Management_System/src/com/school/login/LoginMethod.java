package com.school.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.school.been.Admin;
import com.school.been.Student;
import com.school.connenction.ProvideConnenction;
import com.school.exception.AdminException;
import com.school.exception.StudentException;

public class LoginMethod implements LoginInterface{

	@Override
	public Admin loginAdmin(String email, String password) throws AdminException {
		Admin admin=null;
		
		try(Connection conn=ProvideConnenction.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from administar where adminemail=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
		ResultSet rs=	ps.executeQuery();
		
		if(rs.next()) {
			int adminId=rs.getInt("adminid");
			String AdminName=rs.getString("adminname");
			String address=rs.getString("adminaddress");
			String adminemail=rs.getString("adminemail");
			String adminMobile=rs.getString("adminmobile");
			
			admin=new Admin(adminId, AdminName, address, adminemail, adminMobile);
			
		}else throw new AdminException("Email or password does't Exit.");
			
		} catch (SQLException e) {
			throw new AdminException("Email or password does't Exit.");
		}
		return admin;
	}

	@Override
	public Student loginStudent(String email, String password) throws StudentException {
		Student student=null;
		
		try(Connection conn=ProvideConnenction.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from student where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
		ResultSet rs=	ps.executeQuery();
		
		if(rs.next()) {
			
			int studentId=rs.getInt("stdid");
			String studentName=rs.getString("stdname");
			String address=rs.getString("address");
			String studentmail=rs.getString("email");
			String studentMobile=rs.getString("mobile");
			
			student= new Student(studentId, studentName, address, studentmail, studentMobile);
			
		}else throw new StudentException("Email or password does't Exit.");
			
		} catch (SQLException e) {
			throw new StudentException("Email or password does't Exit.");
		}
		return student;
	}

}
