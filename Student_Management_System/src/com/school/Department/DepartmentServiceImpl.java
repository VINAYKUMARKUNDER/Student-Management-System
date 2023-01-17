package com.school.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.school.been.Course;
import com.school.been.Student;
import com.school.connenction.ProvideConnenction;
import com.school.exception.BranchException;
import com.school.exception.CourseException;
import com.school.exception.StudentException;

public class DepartmentServiceImpl implements DepartmentService{

	@Override
	public String AddNewCourse(int cid, String name, int fee, int seat, String duration) {
		String msg="Data not Inserted !!";
		
		try (Connection conn=ProvideConnenction.provideConnection()){
			
		PreparedStatement ps=	conn.prepareCall("insert into course values(?,?,?,?,?)");
			
		ps.setInt(1, cid);
		ps.setString(2, name);
		ps.setInt(3, fee);
		ps.setInt(4, seat);
		ps.setString(5, duration);
		
		int x= ps.executeUpdate();
		
		if(x>0)msg="Data Inserted Successfully.";
			
		} catch (SQLException e) {
			msg=e.getMessage();
		}
		return msg;
	}

	@Override
	public String updateFee(String name, int fee) throws CourseException {
		String msg="Course not found..";
		
		try {
			int id=Integer.parseInt(name);
			
			try(Connection conn=ProvideConnenction.provideConnection()) {
				
				PreparedStatement ps= conn.prepareStatement("update course set coursefee=? where courseid=?");
				ps.setInt(1, fee);
				ps.setInt(2, id);
				
				int x=ps.executeUpdate();
				
				PreparedStatement ps1=conn.prepareStatement("select * from course where courseid=?");
				ps1.setInt(1, id);
				
				ResultSet rs=ps1.executeQuery();
				
				if(rs.next()) {
					System.out.println("Course id : "+ rs.getInt("courseid")+"---------- CourseName : "+rs.getString("coursename")+
							"--------------- Current fee : "+ rs.getInt("coursefee"));
					
					msg="Course Fee Update Successfully.";
				}else throw new CourseException("Data not faund.");
				
				
				
				
			} catch (SQLException e) {
				throw new CourseException("Data not found..");
			}
			
		} catch (Exception e) {
			try(Connection conn=ProvideConnenction.provideConnection()) {
				
				PreparedStatement ps= conn.prepareStatement("update course set coursefee=? where coursename=?");
				ps.setInt(1, fee);
				ps.setString(2, name);
				
				int x=ps.executeUpdate();
				
				PreparedStatement ps1=conn.prepareStatement("select * from course where coursename=?");
				ps1.setString(1, name);
				
				ResultSet rs=ps1.executeQuery();
				
				if(rs.next()) {
					System.out.println("Course id : "+ rs.getInt("courseid")+"---------- CourseName : "+rs.getString("coursename")+
							"--------------- Current fee : "+ rs.getInt("coursefee"));
				}else throw new CourseException("Data not faund.");	
				
			} catch (SQLException bd) {
				throw new CourseException("Data not found..");
			}
		}
		
		return msg;
	}

	@Override
	public String DeleteCouurse(String name) throws CourseException {
		String msg="Data not found.";
		
		try {
			try (Connection conn=ProvideConnenction.provideConnection()){
				int id=Integer.parseInt(name);
				PreparedStatement ps=conn.prepareStatement("delete from course where courseid=?");
				ps.setInt(1, id);
				int x=ps.executeUpdate();
				
				if(x>0)msg="Delete Successfully..";
				else throw new CourseException("Data Not Found.");
				
			} catch (SQLException e) {
				throw new CourseException(e.getMessage());
			}
			
		} catch (Exception e) {
			try(Connection conn=ProvideConnenction.provideConnection()) {
				
				PreparedStatement ps=conn.prepareStatement("delete from course where coursename=?");
				ps.setString(1, name);
				int x=ps.executeUpdate();
				
				if(x>0)msg="Delete Successfully..";
				else throw new CourseException("Data Not Found.");
				
			} catch (SQLException ss) {
				throw new CourseException(ss.getMessage());
			}
		}
		return msg;
	}
	
	
	@Override
	public Course searchInfo(String name) throws CourseException {
		Course course=null;
		
		
		try {
			try(Connection conn=ProvideConnenction.provideConnection())
			{
			    int id=Integer.parseInt(name);
				PreparedStatement ps=conn.prepareStatement("select * from course where courseid=?");
				ps.setInt(1, id);
			    ResultSet rs=ps.executeQuery();
				
			    if(rs.next()) 
			    {
					int courseid=rs.getInt("courseid");
					String coursename=rs.getString("coursename");
					int coursefee=rs.getInt("coursefee");
					int courseSeat=rs.getInt("courseseat");
					String duration =rs.getString("courseDuration");
				
				     course=new Course(courseid, coursename, coursefee, courseSeat, duration);
			    }
			  else throw new CourseException("Data not found.");	
				
			} 
			catch (SQLException e) 
			{
				throw new CourseException("Data not found.");
			} 
		} catch (Exception e) {
			try(Connection conn=ProvideConnenction.provideConnection())
			{
			  
				PreparedStatement ps=conn.prepareStatement("select * from course where coursename=?");
				ps.setString(1, name);
			    ResultSet rs=ps.executeQuery();
				
			    if(rs.next()) 
			    {
					int courseid=rs.getInt("courseid");
					String coursename=rs.getString("coursename");
					int coursefee=rs.getInt("coursefee");
					int courseSeat=rs.getInt("courseseat");
					String duration =rs.getString("courseDuration");
				
				     course=new Course(courseid, coursename, coursefee, courseSeat, duration);
			    }
			  else throw new CourseException("Data not found.");	
				
			} 
			catch (SQLException ss) 
			{
				throw new CourseException("data not found..");
			} 
		}
		
		return course;
		
	}
	
	
	@Override
	public String createNewBatch(String batchName,String courseName) throws BranchException {
		String msg="Batch already Exist!";
		
	String table=	("create table " +batchName+"("+batchName+" varchar(20),"+courseName+" varchar(20),corid int unique,stdid int unique,seat int(5))");
		
		try (Connection conn=ProvideConnenction.provideConnection()){
			
			PreparedStatement cor=conn.prepareStatement("Select * from course where courseName=?");
			cor.setString(1, courseName);
			
			ResultSet rs=cor.executeQuery();
			if(rs.next()) {

				Statement st=conn.createStatement();
				  st.executeUpdate(table);
				  msg=("Batch created successfully.");
			}else throw new CourseException("Please enter valid course.");
			
		
			
			
		} catch (Exception e) {
			throw new BranchException(e.getMessage());
		}
		return msg;
	}
	
	
	

	
	
	
	

	@Override
	public String AlocateStudentBatch(String batchName,String CourseName,int courseid,int studentid){
		String msg="please data puted currectly.";
		boolean branchStatus=false;
		
		try(Connection conn=ProvideConnenction.provideConnection()) {
			
			PreparedStatement cor=conn.prepareStatement("Select * from course where courseid=? and coursename=?");
			cor.setInt(1, courseid);
			cor.setString(2, CourseName);
			
			ResultSet rs= cor.executeQuery();
			
			if(rs.next()) {
				PreparedStatement std=conn.prepareStatement("Select * from student where stdid=?");
				std.setInt(1, studentid);
				
				ResultSet rs1=std.executeQuery();
				if(rs1.next()) {
					
					
					branchStatus=true;
					
					
				}else throw new StudentException("Student id does't Exist ");
				
			}else throw new CourseException("Course id does not Exist");
			
			
			
			
			if(branchStatus) {

				PreparedStatement branch=conn.prepareStatement("insert into "+batchName+" values(?,?,?,?,?)");
				
				branch.setString(1, batchName);
				branch.setString(2, CourseName);
				branch.setInt(3, courseid);
				branch.setInt(4, studentid);
				branch.setInt(5, studentid);
			
				
				branch.executeUpdate();
				msg="Student Insrted  Successfully.";
				
			}else throw new BranchException("Batch already Exist..");
			
			
		} catch (Exception e) {
			msg=e.getMessage();
		}
		
		return msg;
	}
	
	
	
	@Override
	public Student viewAllStudent(String CourseName,String BranchName) throws BranchException {
		Student student=null;
		
		try (Connection conn=ProvideConnenction.provideConnection()){
			
PreparedStatement ps= conn.prepareStatement("select s.stdid, s.stdname, s.address,s.email,s.mobile, "
		+ "m."+CourseName+" from student s, "+BranchName+" m where s.stdid=m.stdid");
//			ps.setString(1, CourseName);
//			ps.setString(2, BranchName);
			
			ResultSet rs= ps.executeQuery();
		
			
			if(rs.next()) {
				int id=rs.getInt("stdid");
				String name=rs.getString("stdname");
				String address= rs.getString("Address");
				String email=rs.getString("email");
				String mobile=rs.getString("mobile");
				
				student=new Student(id, name, address, email, mobile);
				
			}else throw new BranchException("Student not found.");
			
		} catch (SQLException e) {
			throw new BranchException("Batch not found.");
		}
		
		return student;
	}
	
}
	
	
	
	
	

