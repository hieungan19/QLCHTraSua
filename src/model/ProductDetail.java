package model;

public class ProductDetail {
	private double iAmount; 
	private String productID;
	private String ingredientID;
	private String iName; 
	public double getiAmount() {
		return iAmount;
	}
	public String getProductID() {
		return productID;
	}
	public String getIngredientID() {
		return ingredientID;
	}
	public void setiAmount(double iAmount) {
		this.iAmount = iAmount;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public void setIngredientID(String ingredientID) {
		this.ingredientID = ingredientID;
	}
	
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public ProductDetail( String productID, String ingredientID, String iName, double iAmount) {
		super();
		this.iAmount = iAmount;
		this.productID = productID;
		this.ingredientID = ingredientID;
		this.iName = iName; 
	}
	
	public ProductDetail() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
