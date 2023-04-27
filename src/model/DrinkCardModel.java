package model;

import java.util.ArrayList;
import java.util.Map;

public class DrinkCardModel {
	private String drinkID;
	private String drinkName;
	private int drinkPrice;
	private String typeOfDrink;
	private String imageUri; 
	private ArrayList<DrinkCardModel> toppingList = null; 
	private ArrayList<Map<String, ?>> ingredient = new ArrayList<>();
	
	
	
	public DrinkCardModel(String drinkID, String drinkName, int drinkPrice, String typeOfDrink, String imageUri,
			ArrayList<DrinkCardModel> toppingList, ArrayList<Map<String, ?>> ingredient) {
		super();
		this.drinkID = drinkID;
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.typeOfDrink = typeOfDrink;
		this.imageUri = imageUri;
		this.toppingList = toppingList;
		this.ingredient = ingredient;
	}
	public String getDrinkID() {
		return drinkID;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public int getDrinkPrice() {
		return drinkPrice;
	}
	public String getTypeOfDrink() {
		return typeOfDrink;
	}
	public ArrayList<DrinkCardModel> getToppingList() {
		return toppingList;
	}
	public ArrayList<Map<String, ?>> getIngredient() {
		return ingredient;
	}
	public void setDrinkID(String drinkID) {
		this.drinkID = drinkID;
	}
	public String getImageUri() {
		return imageUri;
	}
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public void setDrinkPrice(int drinkPrice) {
		this.drinkPrice = drinkPrice;
	}
	public void setTypeOfDrink(String typeOfDrink) {
		this.typeOfDrink = typeOfDrink;
	}
	public void setToppingList(ArrayList<DrinkCardModel> toppingList) {
		this.toppingList = toppingList;
	}
	public void setIngredient(ArrayList<Map<String, ?>> ingredient) {
		this.ingredient = ingredient;
	}

	
	
	
}
