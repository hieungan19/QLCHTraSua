package model;

enum CUSTOMER{
	ALL,
	MEMBERSHIP,
	VIP
}

public class DiscountModel {
	private String discountID;
	private String discountTitle;
	private String discountDescription;
	private String discountMoney;
	private String discountPercentage;
	private CUSTOMER qualifyingCustomers; 
	
	
}
