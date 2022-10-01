package com.school.main;

import java.util.Scanner;

import com.school.Department.MethodImpl;
import com.school.been.Course;
import com.school.been.Student;
import com.school.exception.BranchException;
import com.school.exception.CourseException;

public class AdminUsses {
	
	public static void administarRun() {
		Scanner sc= new Scanner(System.in);
		MethodImpl all= new MethodImpl();
		
		boolean status=true;
		
		while(status) {
			System.out.println("\n Choose Option only press Number.. \n");
			System.out.println("  1. Add a new Courses\r\n"
					+ "  2. Update Fees of course.\r\n"
					+ "  3. Delete  a course from any Training session.\r\n"
					+ "  4. Search information about a course.\r\n"
					+ "  5. Create Batch under a course.\r\n"
					+ "  6. Allocate students in a Batch under a course.\r\n"
					+ "  7. Update total seats of a batch.\r\n"
					+ "  8. View the students of every batch.\r\n"
					+ "  9. Exit for Admin.");
			System.out.println("=================================================== \n");
			int num=sc.nextInt();
			
			switch (num) {
			case 1: {
				System.out.println("Add a new Course. \n");
				
				System.out.print("Enter course id : ");
				int id=sc.nextInt();
				
				System.out.print("Enter course Name : ");
				String name= sc.next();
				
				System.out.print("Enter Course fee : ");
				int fee=sc.nextInt();
				
				System.out.print("Enter course seat : ");
				int seats=sc.nextInt();
				
				System.out.print("Enter course Durtion : ");
				String duration =sc.next();
				
			String msg=	all.AddNewCourse(id, name, fee, seats, duration);
			System.out.println(msg);
				
				System.out.println("===========================================");
				
			}
			break;
			
			case 2:{
				System.out.println("update fee course.");
				
				System.out.print("Enter course Name : ");
				String name= sc.next();
				
				System.out.print("Enter Course fee : ");
				int fee=sc.nextInt();
				
				try {
					String msg=all.updateFee(name, fee);
					System.out.println(msg);
				} catch (CourseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("===========================================");
			}
			break;
			
			case 3:{
				System.out.println("Delete  a course from any Training session");
				
				System.out.print("Enter course name or id : ");
				String name=sc.next();
				
				try {
					String msg=all.DeleteCouurse(name);
					System.out.println(msg);
				} catch (CourseException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				System.out.println("===========================================");
			}
			break;
			case 4:{
				System.out.println("Search information about a course");
				
				System.out.print("Enter course name or id : ");
				String name=sc.next();
				
				try {
					Course course=all.searchInfo(name);
					System.out.println(course);
				} catch (CourseException e) {
					// TODO Auto-generated catch block
//				System.out.println(e.getMessage());
					System.out.println(e.getMessage());
				}
				System.out.println("===========================================");
			}
			break;
			
			case 5:{
				System.out.println("Create Batch under a course.");
				System.out.println("How many Batch Created.");
				int bat=sc.nextInt();
				int i=1;
				while(bat>0) {
					System.out.println("Enter Data of Batch nu. : "+i++);
					System.out.print("Enetr Batch Name : ");
					String batch=sc.next();
					
					System.out.print("Enetr Course Name : ");
					String course=sc.next();
					
					try {
						String s=all.createNewBatch(batch,course);
						System.out.println(s);
					} catch (BranchException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					System.out.println("==========================================");
					bat--;
				}
			}
			break;
			
			case 6:{
				System.out.println(" Allocate students in a Batch under a course");
				
				System.out.print("Enetr Batch Name : ");
				String batch=sc.next();
				System.out.print("Enetr Course Name : ");
				String course=sc.next();
				System.out.print("Enter course id : ");
				int corid=sc.nextInt();
				System.out.print("Enter Student id : ");
				int stdid=sc.nextInt();
				
			
				
			String ss=	all.AlocateStudentBatch(batch, course, corid, stdid);
				System.out.println(ss);
				System.out.println("==========================================");
				
			}
			break;
			
			
			case 8:{
				System.out.println("View the students of every batch");
				
				System.out.print("Enter Course Name : ");
				String course=sc.next();
				System.out.print("Enter batch Name : ");
				String name=sc.next();
				
				try {
				Student std=	all.viewAllStudent(course, name);
				System.out.println(std);
				} catch (BranchException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				System.out.println("=========================================== \n");
			}
			break;
			case 9:{
				System.out.println("Admin Logout.");
				status=false;
				break;
			}
			default:
				System.out.println("Plese Enter valid Number...");
			}
		
		}
	}
	
	
	
	
	

}
