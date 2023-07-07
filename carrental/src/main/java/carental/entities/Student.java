package carental.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Column(name="V_type")
	String V_type;
	@Id
	@Column(name="V_ID")
	String V_ID;
	@Column(name="Year")
	int Year;
	@Column(name="Make")
	String Make;
	@Column(name="Model")
	String Model;
	@Column(name="vehicleStatus")
	int vehicleStatus;
	@Column(name="noofseats")
	int noofseats;
	public String getV_type() {
		return V_type;
	}
	public void setV_type(String v_type) {
		V_type = v_type;
	}
	public String getV_ID() {
		return V_ID;
	}
	public void setV_ID(String v_ID) {
		V_ID = v_ID;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public String getMake() {
		return Make;
	}
	public void setMake(String make) {
		Make = make;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public int getVehicleStatus() {
		return vehicleStatus;
	}
	public int setVehicleStatus(int vehicleStatus) {
		return this.vehicleStatus = vehicleStatus;
	}
	public int getNoofseats() {
		return noofseats;
	}
	public void setNoofseats(int noofseats) {
		this.noofseats = noofseats;
	}
	
   
}
