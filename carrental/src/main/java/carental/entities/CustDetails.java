package carental.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CustDetails")
public class CustDetails  {

	@Column
	String Cname;
	
	@Column
	long Adharno;

	@Id
	@Column
	long C_ID;
	@Column
	long mobile_no;
	
	
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public long getAdharno() {
		return Adharno;
	}
	public void setAdharno(long adharno) {
		Adharno = adharno;
	}
	public long getC_ID() {
		return C_ID;
	}
	public void setC_ID(long c_ID) {
		C_ID = c_ID;
	}
	public long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	
	
}
