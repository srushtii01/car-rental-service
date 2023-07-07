package carrental.DAO;

import carrental.util.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import carental.entities.DateTime;
import carental.entities.RentalRecord;
import carental.entities.Student;
import carental.services.Admin;
import carental.services.RentRunable;
import carental.entities.CustDetails;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class MainDAO {
	public static void main(String str[]) throws ParseException {
		Scanner sc = new Scanner(System.in);
		int j;
		
		  
		  
		
		System.out.println("Enter 0 for Admin  1 for User ");
		System.out.println("Enter ur Choice");
		j=sc.nextInt();
		switch (j) {
			case 0:
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
				 Student s1 = new Student();
				 s1.setV_type(vehicleType);
				  s1.setV_ID(vehicleID);
				  s1.setYear(year);
				  s1.setMake(make);
				  s1.setModel(model);
				  s1.setVehicleStatus( vehicleStatus);
				  s1.setNoofseats(seats);
				  Transaction transaction = null;
					try (Session session = HibernateUtil.getSessionFactory().openSession()) {
						// start a transaction
						transaction = session.beginTransaction();
						// save the student objects
						session.save(s1);
						// session.save(v1);
						// commit transaction
						transaction.commit();
					} catch (Exception e) {
						// if (transaction != null) {
						// transaction.rollback();
						// }
						e.printStackTrace();
					}
				  
				break;
			case 1:
				Scanner scan1 = new Scanner( System.in);
				DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			System.out.print("Vehicle id: ");
			String id = scan1.nextLine();
			

		//System.out.print("Customer ID: ");
		//String cusId = scan.next();
		System.out.print("Rent date( dd/mm/yyyy): ");
		String date = scan1.next();
			format.setLenient(false);
			while(date.trim().length() != ((SimpleDateFormat) format).toPattern().length())
			{
				System.out.println("Please enter a valid date in the format dd/mm/yyyy: ");
				date = scan1.nextLine();
			}
		
		//DateTime rentDate= new DateTime(Integer.parseInt(dates[0]),Integer.parseInt(dates[1]),Integer.parseInt(dates[2]));
		System.out.print("How many days?: ");
		int days= scan1.nextInt();
		
		
		System.out.println("Hi..Welcome...");
		
	     
		System.out.println("enter your Adharno");
		int ano=scan1.nextInt();
		
		System.out.println("enter your Mobile no");
		long mno=scan1.nextInt();
		
		CustDetails details = new CustDetails();
		details.setCname("Srushtii");
		details.setAdharno(ano);
		details.setC_ID(ano);
		details.setMobile_no(mno);
		
		
		System.out.println("Vehicle "+id+" is now rented by customer "+ano);
			
			//LocalDate d =LocalDate.parse(date);
		//	LocalDate d1= d.plusDays(days);
			//System.out.println("Estimated Return Date is --->" +d1);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
			 Calendar cal = Calendar.getInstance(); 
			 cal.add(Calendar.DAY_OF_MONTH, -days);  
		     String d= sdf.format(cal.getTime()); 
			
		     Date dateBefore = null;
			try {
				dateBefore = sdf.parse(date);
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
			System.out.print("Return date( dd/mm/yyyy): ");
			   String dater = scan1.next();
			   String datesr[] = dater.split("/");
			  
			DateTime returnDate= new DateTime(Integer.parseInt(datesr[0]),Integer.parseInt(datesr[1]),Integer.parseInt(datesr[2]));
			
			
			Date dateAfter = null;
			try {
				dateAfter = sdf.parse(dater);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int timediff= (int) Math.abs(dateAfter.getTime()- dateBefore.getTime());
			int daysdiff= (int) TimeUnit.DAYS.convert(timediff,TimeUnit.MILLISECONDS);
			System.out.println("the total no of days for which the Vehical is rented id  "+daysdiff);
			int delay= daysdiff -days;
			
			
			double total=89*daysdiff;
			System.out.println("the total payable amount id "+total);
			System.out.println("The fine due to late fee is  "+delay*100);
			System.out.println(" The total payable amout is "+(delay*100 +total));
			long rtId=  System.currentTimeMillis();
	         double c= (delay*100 +total);
			RentalRecord r1=new RentalRecord();
			r1.setV_ID(id);
			r1.setRentId(rtId);
			r1.setRentDate(date);
			r1.setEstimatedReturnDate(d);
			r1.setActualReturnDate(dater);
			r1.setRentalFee(c);
			
			
			Transaction transact = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				// start a transaction
				transact = session.beginTransaction();
				// save the student objects
				session.save(r1);
				session.save(details);
				// session.save(v1);
				// commit transaction
				transact.commit();
			} catch (Exception e) {
				// if (transaction != null) {
				// transaction.rollback();
				// }
				e.printStackTrace();
			
			}
				 break;
		}
	}
}


		
		
		
	
	


	
	
	
	


