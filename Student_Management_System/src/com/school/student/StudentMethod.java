package com.school.student;

import com.school.Department.MethodImpl;
import com.school.been.Student;
import com.school.exception.StudentException;
import com.school.login.LoginMethod;

public class StudentMethod implements StudentInterface{

	@Override
	public String ragistarHimselfinCourse(String email, String password,String course,String batchName, int corseid) throws StudentException {
		String msg="Student not found";
		
		LoginMethod lm= new LoginMethod();
		MethodImpl mpl=new MethodImpl();
		
		Student std=	lm.loginStudent(email, password);
		
	msg=	mpl.AlocateStudentBatch(batchName, course, corseid, std.getStdID());
		
		
		return msg;
	}

}
