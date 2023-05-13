package model;

import java.util.List;

public class ProductModel {
	private String billID;
	private String detailID; 
	
	public String getBillID() {
		return billID;
	}

	public String getDetailID() {
		return detailID;
	}

	public void setBillID(String billID) {
		this.billID = billID;
	}

	public void setDetailID(String detailID) {
		this.detailID = detailID;
	}

	protected String productID;
	protected String name;
	protected double price;
	protected String imageUri;
	protected String type;
	protected int amount;
	protected List<ProductDetail> ingredientList;
	protected List<ProductModel> toppingList;

	public ProductModel(ProductModel pro) {
		this.productID = pro.productID;
		this.name = pro.name;
		this.price = pro.price;
		this.type = pro.type;
		this.imageUri = pro.imageUri;
	}

	public ProductModel(String productID, String name, double price, String type, String imageUri,
			List<ProductDetail> ingreList) {
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.type = type;
		this.imageUri = imageUri;
		this.ingredientList = ingreList;
	}

	public String toStringToppingList() {
		String result = "";
		for (ProductModel topping : toppingList)
			result += topping.getName() + "-" + topping.getAmount() + "; ";
		return result;
	}
	public double getTotal() {
		double total = price*amount; 
		for (ProductModel topping: toppingList) {
			total+=topping.getPrice()*topping.getAmount()*amount; 
		}
	
		return total; 
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
		for (ProductDetail ingre : ingredientList) {
			if (ingre.getiAmount() != 0)
				ingreListString += ingre.getiName() + ",";
		}
		return ingreListString;
	}

	public Object[] toOject() {
		String ingreListString = toStringIngredientList();
		return new Object[] { productID, imageUri, name, type,  ingreListString };
	}

	public List<ProductModel> getToppingList() {
		return toppingList;
	}

	public void setToppingList(List<ProductModel> toppingList) {
		this.toppingList = toppingList;
	}
	
	public Object[] toObjectDrink() {
		return new Object[] {productID,name, toStringToppingList(), getTotal()}; 
	}

}
