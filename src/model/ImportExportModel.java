package model;

import java.util.Date;

public class ImportExportModel {
	private String id; 
	private String ingreID;
	private Date ieDate;
	private double amount;
	
	
	
	public ImportExportModel(String id, String ingreID, Date ieDate, double amount) {
		super();
		this.id = id;
		this.ingreID = ingreID;
		this.ieDate = ieDate;
		this.amount = amount;
	}



	public Object[] toObject() {
		return new Object[] {ingreID, ieDate, Math.abs(amount)};
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
