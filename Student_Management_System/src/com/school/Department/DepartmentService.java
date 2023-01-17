package com.school.Department;

import com.school.been.Course;
import com.school.been.Student;
import com.school.exception.BranchException;
import com.school.exception.CourseException;

public interface DepartmentService {
	
	public String AddNewCourse(int cid, String name, int fee, int seat, String duration);
	public String updateFee(String name,int fee) throws CourseException;
	public String DeleteCouurse(String name) throws CourseException;
	public Course searchInfo(String name)throws CourseException;
	public String createNewBatch(String batchName,String CourseName)throws BranchException;
	public String AlocateStudentBatch(String batchName,String CourseName,int courseid,int studentid)throws BranchException;
	public Student viewAllStudent(String CourseName,String BranchName)throws BranchException;
	

}
