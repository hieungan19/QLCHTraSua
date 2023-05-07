package model;
import java.util.List;

public class ProductModel {
	protected String productID;
	protected String name;
	protected double price; 
	protected String imageUri; 
	protected String type;
	protected int amount; 
	protected List<ProductDetail> ingredientList; 
	
	public ProductModel(String productID, String name, double price, String type, String imageUri, List<ProductDetail> ingreList ) {
		this.productID = productID; 
		this.name = name;
		this.price = price;
		this.type = type; 
		this.imageUri = imageUri;
		this.ingredientList = ingreList; 
	}
	
	public ProductModel() {
		// TODO Auto-generated constructor stub
	}
	public String getProductID() {
		return productID;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String getImageUri() {
		return imageUri;
	}
	public String getType() {
		return type;
	}
	public List<ProductDetail> getIngredientList() {
		return ingredientList;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setIngredientList(List<ProductDetail> ingredientList) {
		this.ingredientList = ingredientList;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String toStringIngredientList() {
		String ingreListString = ""; 
		for (ProductDetail ingre: ingredientList) {
			if (ingre.getiAmount()!=0)
			ingreListString+=ingre.getiName()+",";
		}
		return ingreListString; 
	}
	
	
	public Object[] toOject() {
		String ingreListString = toStringIngredientList(); 
		return new Object[] {productID,imageUri,name, type, String.valueOf(price),ingreListString}; 
	}

}
