package model;

import java.sql.Date;
import java.util.List;

import dao.CustomerDAO;
import dao.MyDB;

public class CustomerModel {
	private String customerID;
	private String name;
	private String phoneNumber;
	private int point;
	private String level; 
	private Date registration;
	public CustomerModel() {}
	public CustomerModel(String customerID, String name, String phoneNumber, int point, String level,
			Date registration) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.point = point;
		this.level = level;
		this.registration = registration;
	}
	public String getCustomerID() {
		return customerID;
	}
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public int getPoint() {
		return point;
	}
	public String getLevel() {
		return level;
	}
	public Date getRegistration() {
		return registration;
	}
	
	//set
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setRegistration(Date registration) {
		this.registration = registration;
	} 
	
	public Object[] toObject () {
		return new Object[] {customerID,name,phoneNumber,point,level,registration}; 
	}
	
	
	public static List<CustomerModel>getAllCustomer() {
		return CustomerDAO.getCustomerList(); 
	}
	
	public void updateInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber; 
	}
	
}
