package carental.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jakarta.persistence.OneToOne;

@Entity
@Table(name="RentalRecord")
public class RentalRecord {
  
	 
	@Id
	@Column(name="RentId")
	
    private long RentId;
	@Column(name="RentDate")
    private String RentDate;
    @Column(name="EstimatedReturnDate")
	private String EstimatedReturnDate;
    @Column(name="ActualReturnDate")
    private String ActualReturnDate;
    @Column(name="RentalFee")
    private Double RentalFee;
    @Column
	private String V_ID;
   

public String getV_ID() {
		return V_ID;
	}
	public void setV_ID(String v_ID) {
		V_ID = v_ID;
	}
public long getRentId() {
	return RentId;
}
public void setRentId(long rtId) {
	RentId = rtId;
}
public String getRentDate() {
	return RentDate;
}
public void setRentDate(String rentDate) {
	RentDate = rentDate;
}
public String getEstimatedReturnDate() {
	return EstimatedReturnDate;
}
public void setEstimatedReturnDate(String d) {
	EstimatedReturnDate = d;
}
public String getActualReturnDate() {
	return ActualReturnDate;
}
public void setActualReturnDate(String actualReturnDate) {
	ActualReturnDate = actualReturnDate;
}
public Double getRentalFee() {
	return RentalFee;
}
public void setRentalFee(Double rentalFee) {
	RentalFee = rentalFee;
}

   

    
	
}