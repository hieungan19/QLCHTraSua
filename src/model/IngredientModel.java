package model;

import java.util.Date;

public class IngredientModel {
	private String ingredientID;
	private String name; 
	private String unit; // đơn vị tính 
	private double amount; 
	private double price;
	private Date mfDate; // manufacturing date
	private Date expDate; 
	private String supplier; 
	
	
	
	public IngredientModel(String ingredientID, String name, String unit, double amount, double price, Date mfDate,
			Date expDate, String supplier) {
		super();
		this.ingredientID = ingredientID;
		this.name = name;
		this.unit = unit;
		this.amount = amount;
		this.price = price;
		this.mfDate = mfDate;
		this.expDate = expDate;
		this.supplier = supplier;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Date getMfDate() {
		return mfDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setMfDate(Date mfDate) {
		this.mfDate = mfDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public IngredientModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	public IngredientModel(String name, String unit, double amount, double price, Date mfDate, Date expDate,
			String supplier) {
		super();
		this.name = name;
		this.unit = unit;
		this.amount = amount;
		this.price = price;
		this.mfDate = mfDate;
		this.expDate = expDate;
		this.supplier = supplier;
	}

	public IngredientModel(String ingredientID, String name, String unit, double amount, double price) {
		super();
		this.ingredientID = ingredientID;
		this.name = name;
		this.unit = unit;
		this.amount = amount;
		this.price = price;
	}
	public String getIngredientID() {
		return ingredientID;
	}
	public String getName() {
		return name;
	}
	public String getUnit() {
		return unit.toUpperCase();
	}
	public double getAmount() {
		return amount;
	}
	public double getPrice() {
		return price;
	}
	public void setIngredientID(String ingredientID) {
		this.ingredientID = ingredientID;
	}
	public void setName(String name) {
		
		this.name = name;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setPrice(double price) {
		this.price = price;
	} 
	
	public Object[] toObject() {
		return new Object[] {ingredientID,name,unit,amount,price,mfDate,expDate,supplier}; 
	}
	
	
}
