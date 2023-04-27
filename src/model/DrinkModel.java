package model;

import java.util.ArrayList;
import java.util.Map;

public class DrinkModel  extends ProductModel{
	private String typeOfDrink ; 
	private ArrayList<DrinkModel> toppingList = null;



	public DrinkModel(String drinkID, String drinkName, int drinkPrice, boolean isTopping, String imageUri,
			ArrayList<IngredientModel> ingredientList, String typeOfDrink, ArrayList<DrinkModel> toppingList) {
		super(drinkID, drinkName, drinkPrice, isTopping, imageUri, ingredientList);
		this.typeOfDrink = typeOfDrink;
		this.toppingList = toppingList;
	}


	public String getTypeOfDrink() {
		return typeOfDrink;
	}


	public void setTypeOfDrink(String typeOfDrink) {
		this.typeOfDrink = typeOfDrink;
	}


	public ArrayList<DrinkModel> getToppingList() {
		return toppingList;
	}


	public void setToppingList(ArrayList<DrinkModel> toppingList) {
		this.toppingList = toppingList;
	} 

	
}
