package model;


public class IngredientModel {
	private String ingredientID;
	private String name; 
	private String unit; // đơn vị tính 
	private double amount; 
	private double price;
	
	public IngredientModel() {
		// TODO Auto-generated constructor stub
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
		return new Object[] {ingredientID,name,unit,amount,price}; 
	}
	
	
}
