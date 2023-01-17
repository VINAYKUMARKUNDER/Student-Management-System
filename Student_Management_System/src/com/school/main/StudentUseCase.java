package com.school.main;

import java.util.Scanner;

import com.school.exception.BranchException;
import com.school.exception.StudentException;
import com.school.student.StudentServiceImpl;

public class StudentUseCase {
	
	public static void StudentRun() {
		Scanner sc= new Scanner(System.in);
		StudentServiceImpl stm= new StudentServiceImpl();
		
		boolean status = true;
		
		while(status) {
			System.out.println("\n Choose Option only press Number.. \n");
			System.out.println("         1. Register himself in a course with a username and password \r\n"
					+ "	2. can update this details.\r\n"
					+ "	3. can see all the available course list and their seat availability.\r\n"
					+ "         4. Student Exit.\r\n");
			
			System.out.println("=================================================== \n");
			int num=sc.nextInt();
			
			switch (num) {
			case 1: {
				System.out.println("Register himself in a course with a username and password ");
				
				System.out.println("Enter Student Email id : ");
				String email=sc.next();
				
				System.out.println("Enter Student Password : ");
				String password=sc.next();
				
				System.out.println("Enter Course Name : ");
				String courseName=sc.next();
				
				System.out.println("Enter Batch name : ");
				String batch=sc.next();
				
				System.out.println("Enter Course id : ");
				int id=sc.nextInt();
				
				try {
					String ss=stm.ragistarHimselfinCourse(email, password, courseName, batch, id);
					System.out.println(ss);
				} catch (StudentException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			break;
			
			case 2:{
				System.out.println("can update this details.");
				
				System.out.println("Enetr CourseName which course update. : ");
				String coursename=sc.next();
				
				System.out.print("Enter Course id : ");
				int pid=sc.nextInt();
				
				
				System.out.print("Enter new Course name : ");
				String newCourseName=sc.next();
				
				System.out.print("Enter new Course Id : ");
				int newCourseId=sc.nextInt();
				
				System.out.print("Enter new Batch Name : ");
				String newBatchName=sc.next();
				
				try {
					String s=stm.updateData(coursename, pid, newCourseName, newCourseId, newBatchName);
					System.out.println(s);
				} catch (BranchException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			
			}
			break;
			case 4:{
				System.out.println("Student Logout..");
				status=false;
			}
			break;
			default:
				System.out.println("Enter Valid Number.");
			}
			
		}
		
		
	}

}
