package com.school.student;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.school.Department.DepartmentServiceImpl;
import com.school.been.Student;
import com.school.connenction.ProvideConnenction;
import com.school.exception.BranchException;
import com.school.exception.StudentException;
import com.school.login.LoginMethod;

public class StudentServiceImpl implements StudentService{

	@Override
	public String ragistarHimselfinCourse(String email, String password,String course,String batchName, int corseid) throws StudentException {
		String msg="Student not found";
		
		LoginMethod lm= new LoginMethod();
		DepartmentServiceImpl mpl=new DepartmentServiceImpl();
		
		Student std=	lm.loginStudent(email, password);
		
	msg=	mpl.AlocateStudentBatch(batchName, course, corseid, std.getStdID());
		
		
		return msg;
	}

	@Override
	public String updateData(String course, int stdId,String courseName1,int courseid1,String batch) throws BranchException {
		String msg="Student is does't Ragistered..";
		
		try (Connection conn=ProvideConnenction.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("delet from "+course+" where stdid="+stdId);
			
			int x=ps.executeUpdate();
			if(x>0) {
				DepartmentServiceImpl mpl=new DepartmentServiceImpl();
				msg=mpl.AlocateStudentBatch(batch, courseName1, courseid1, stdId);
				
			}else throw new BranchException("Course not found.");
			
			
			
		} catch (Exception e) {
			throw new BranchException("Course not found.");
		}
		
		return msg;
	}

}
