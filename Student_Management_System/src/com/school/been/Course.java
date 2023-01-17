package com.school.been;

public class Course {
	
	private int courseId;
	private String courseName;
	private int courseFee;
	private int courseSeat;
	private String courseDuration;
	
	
	
	public int getCourseId() 
	{
		return courseId;
	}
	public void setCourseId(int courseId) 
	{
		this.courseId = courseId;
	}
	public String getCourseName() 
	{
		return courseName;
	}
	public void setCourseName(String courseName) 
	{
		this.courseName = courseName;
	}
	public int getCourseFee() 
	{
		return courseFee;
	}
	public void setCourseFee(int courseFee) 
	{
		this.courseFee = courseFee;
	}
	public int getCourseSeat()
	{
		return courseSeat;
	}
	public void setCourseSeat(int courseSeat) 
	{
		this.courseSeat = courseSeat;
	}
	public String getCourseDuration() 
	{
		return courseDuration;
	}
	public void setCourseDuration(String courseDuration)
	{
		this.courseDuration = courseDuration;
	}
	
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(int courseId, String courseName, int courseFee, int courseSeat, String courseDuration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.courseSeat = courseSeat;
		this.courseDuration = courseDuration;
	}
	@Override
	public String toString() 
	{
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseFee=" + courseFee
				+ ", courseSeat=" + courseSeat + ", courseDuration=" + courseDuration + "]";
	}
	
	

}
