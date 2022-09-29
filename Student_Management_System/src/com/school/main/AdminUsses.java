package com.school.main;

import java.util.Scanner;

import com.school.Department.MethodImpl;
import com.school.been.Course;
import com.school.exception.CourseException;

public class AdminUsses {
	
	public static void administarRun() {
		Scanner sc= new Scanner(System.in);
		MethodImpl all= new MethodImpl();
		
		boolean status=true;
		
		while(status) {
			System.out.println("\n \n Choose Option only press Number.. \n");
			System.out.println("  1. Add a new Courses\r\n"
					+ "  2. Update Fees of course.\r\n"
					+ "  3. Delete  a course from any Training session.\r\n"
					+ "  4. Search information about a course.\r\n"
					+ "  5. Create Batch under a course.\r\n"
					+ "  6. Allocate students in a Batch under a course.\r\n"
					+ "  7. Update total seats of a batch.\r\n"
					+ "  8. View the students of every batch.");
			System.out.println("=================================================== \n");
			int num=sc.nextInt();
			if(num==1) {
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
			
			else if(num==2) {
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
			else if(num==3) {
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
			
			else if(num==4) {
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
			
			else {
				System.out.println("Thank You.");
				status=false;
			}
		}
	}
	
	
	
	
	

}
