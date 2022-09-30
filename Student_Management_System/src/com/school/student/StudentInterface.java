package com.school.student;

import com.school.been.Student;
import com.school.exception.StudentException;

public interface StudentInterface {
	public String ragistarHimselfinCourse(String email,String password,String course,String batchName, int corseid)throws StudentException;

}
