package carental.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.hibernate.Session;
import org.hibernate.Transaction;

import carental.entities.CustDetails;
import carental.entities.DateTime;
import carental.entities.RentalRecord;
import carrental.util.HibernateUtil;

public class RentRunable {

	
	public static void rent(){
		
		Scanner scan= new Scanner(System.in);
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Vehicle id: ");
		String id = scan.nextLine();
		

	//System.out.print("Customer ID: ");
	//String cusId = scan.next();
	System.out.print("Rent date( dd/mm/yyyy): ");
	String date = scan.next();
		format.setLenient(false);
		while(date.trim().length() != ((SimpleDateFormat) format).toPattern().length())
		{
			System.out.println("Please enter a valid date in the format dd/mm/yyyy: ");
			date = scan.nextLine();
		}
	
	//DateTime rentDate= new DateTime(Integer.parseInt(dates[0]),Integer.parseInt(dates[1]),Integer.parseInt(dates[2]));
	System.out.print("How many days?: ");
	int days= scan.nextInt();
	
	
	System.out.println("Hi..Welcome...");
	
     
	System.out.println("enter your Adharno");
	int ano=scan.nextInt();
	
	System.out.println("enter your Mobile no");
	long mno=scan.nextInt();
	
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
		   String dater = scan.next();
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
		
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student objects
			session.save(r1);
			session.save(details);
			// session.save(v1);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			// if (transaction != null) {
			// transaction.rollback();
			// }
			e.printStackTrace();
		
		}
		
		
		}
}
