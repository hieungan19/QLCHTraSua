package model;

import java.util.Date;

public class InventoryModel {
	private String itemCode;
    private String itemName;
    private int itemQuantity;
    private String itemCategory;
    private Date itemEntryDate;
    private int itemShelfLife;
    
	public InventoryModel(String itemCode, String itemName, int itemQuantity, String itemCategory, Date itemEntryDate, int itemShelfLife) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemCategory = itemCategory;
		this.itemEntryDate = itemEntryDate;
		this.itemShelfLife = itemShelfLife;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Date getItemEntryDate() {
		return itemEntryDate;
	}

	public void setItemEntryDate(Date itemEntryDate) {
		this.itemEntryDate = itemEntryDate;
	}

	public int getItemShelfLife() {
		return itemShelfLife;
	}

	public void setItemShelfLife(int itemShelfLife) {
		this.itemShelfLife = itemShelfLife;
	}
	
	
    
    
}
