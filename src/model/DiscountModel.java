package model;

import java.util.Date;

public class DiscountModel {
	private String discountID;
	private String name;
	private double totalBill  ;
	private double percent;
	private Date startDate;
	private Date endDate; 
	private String customerType;
	public DiscountModel(String discountID, String name, double totalBill, double percent, Date startDate, Date endDate,
			String customerType) {
		super();
		this.discountID = discountID;
		this.name = name;
		this.totalBill = totalBill;
		this.percent = percent;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customerType = customerType;
	}
	public String getDiscountID() {
		return discountID;
	}
	public String getName() {
		return name;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public double getPercent() {
		return percent;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setDiscountID(String discountID) {
		this.discountID = discountID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	
	public DiscountModel() {
		// TODO Auto-generated constructor stub
	}
	
	public Object[] toObject() {
		return new Object[] {discountID, name, totalBill, percent, startDate, endDate, customerType}; 
	}
	public DiscountModel(String name, double totalBill, double percent, Date startDate, Date endDate,
			String customerType) {
		super();
		this.name = name;
		this.totalBill = totalBill;
		this.percent = percent;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customerType = customerType;
	}
	
}
