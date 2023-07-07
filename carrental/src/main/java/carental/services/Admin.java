package carental.services;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import carental.entities.Student;
import carrental.util.HibernateUtil;

public class Admin {

	public void forAdmin() {
		Scanner scan = new Scanner(System.in);

		

		
		  int i=0; 
		  String vehicleID=""; 
		  int seats=0; 
		int vehicleStatus; 
		int perDayRent=0; 
		  System.out.print("Vehicle Type(Van or Car): ");
		  
		  
		 
		  
		 String vehicleType = scan.nextLine();
		  
		  
		  while (!(vehicleType.equalsIgnoreCase("car")
		  ||vehicleType.equalsIgnoreCase("van"))) {
		  System.out.print("Please enter either van or car: "); vehicleType =
		  scan.nextLine();
		  
		  } 
		  System.out.println("enter vehical id:"); vehicleID= scan.nextLine();
		  System.out.print("Year: ");
		  
		  int year = Integer.parseInt(scan.nextLine());
		 
		  
		  while (year<1980 || year >2022) {
		  System.out.println("Please enter a valid year");
		  year=Integer.parseInt(scan.nextLine()); }
		 
		  System.out.print("Make: "); String make = scan.nextLine();
		  
		  System.out.print("Model: ");
		 
		  String model = scan.nextLine();
		 
		  System.out.println("enter vehical status"); 
		  vehicleStatus=Integer.parseInt(scan.nextLine());
		  
		  
		 
		  System.out.print("Number of seats: "); 
		  seats =
		  Integer.parseInt(scan.nextLine());
		  
		 while ((seats != 4 && seats != 7)) {
		  System.out.println("Please enter seats as either 4 or 7"); 
		  seats = Integer.parseInt(scan.nextLine());
		 
	}
	}
}
