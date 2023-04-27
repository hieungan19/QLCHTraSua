package model;

import java.util.ArrayList;
import java.util.Map;

public class ProductModel {
	protected String drinkID;
	protected String drinkName;
	protected int drinkPrice;
	protected boolean isTopping;  
	protected String imageUri; 
	private ArrayList<IngredientModel> ingredientList = new ArrayList<IngredientModel>();
	public String getDrinkID() {
		return drinkID;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public int getDrinkPrice() {
		return drinkPrice;
	}
	public boolean isTopping() {
		return isTopping;
	}
	public String getImageUri() {
		return imageUri;
	}
	public ArrayList<IngredientModel> getIngredientList() {
		return ingredientList;
	}
	public void setDrinkID(String drinkID) {
		this.drinkID = drinkID;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public void setDrinkPrice(int drinkPrice) {
		this.drinkPrice = drinkPrice;
	}
	public void setIsTopping(boolean isTopping) {
		this.isTopping = isTopping;
	}
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	public void setIngredientList(ArrayList<IngredientModel> ingredientList) {
		this.ingredientList = ingredientList;
	}
	public ProductModel(String drinkID, String drinkName, int drinkPrice, boolean isTopping, String imageUri,
			ArrayList<IngredientModel> ingredientList) {
		super();
		this.drinkID = drinkID;
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.isTopping = isTopping;
		this.imageUri = imageUri;
		this.ingredientList = ingredientList;
	}
	
	
	
}
