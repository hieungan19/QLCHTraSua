package model;

import java.util.ArrayList;


public class DrinkModel  extends ProductModel{


	private ArrayList<ProductModel> toppingList ;

	public ArrayList<ProductModel> getToppingList() {
		return toppingList;
	}

	public void setToppingList(ArrayList<ProductModel> toppingList) {
		this.toppingList = toppingList;
	}

}
