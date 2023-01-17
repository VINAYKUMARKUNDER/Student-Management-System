package com.school.student;

import com.school.been.Student;
import com.school.exception.BranchException;
import com.school.exception.StudentException;

public interface StudentService {
	public String ragistarHimselfinCourse(String email,String password,String course,String batchName, int corseid)throws StudentException;
	public String updateData(String course,int stdId,String courseName1,int courseid1,String batch)throws BranchException;
	
}
