package model;

import java.sql.Date;

public class IngredientModel {
	private String ingredientID;
	private String ingredientName; 
	private String unitOfCalculation; // đơn vị tính 
	private Date entryDate; 
	private Date expiryDate; //ngày nhập kho
	private double amount; 
}
