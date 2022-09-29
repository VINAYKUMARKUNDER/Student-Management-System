package com.school.login;

import com.school.been.Admin;
import com.school.been.Student;
import com.school.exception.AdminException;
import com.school.exception.StudentException;

public interface LoginInterface {
	public Admin loginAdmin(String email,String password) throws AdminException;
	public Student loginStudent(String email,String password) throws StudentException;
}
