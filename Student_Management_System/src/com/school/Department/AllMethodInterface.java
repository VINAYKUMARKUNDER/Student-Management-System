package com.school.Department;

import com.school.been.Course;
import com.school.exception.CourseException;

public interface AllMethodInterface {
	
	public String AddNewCourse(int cid, String name, int fee, int seat, String duration);
	public String updateFee(String name,int fee) throws CourseException;
	public String DeleteCouurse(String name) throws CourseException;
	public Course searchInfo(String name)throws CourseException;
	
	

}
