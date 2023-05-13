package model;
import java.util.Date;
import java.util.List;

import dao.DiscountDAO;

public class BillModel {
	private String  billID;
	private String employeeID;
	private String customerID; 
	private List<ProductModel> productList;
	private String discountID; 
	private double subtotal;
	private double total; 
	private double discountValue; 
	private double tenderAmount;
	private Date billDate; 
	
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public String getBillID() {
		return billID;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public List<ProductModel> getProductList() {
		return productList;
	}
	public String getDiscountID() {
		return discountID;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public double getTotal() {
		return total;
	}
	public double getDiscountValue() {
		return discountValue;
	}
	public double getTenderAmount() {
		return tenderAmount;
	}
	public void setBillID(String billID) {
		this.billID = billID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public void setProductList(List<ProductModel> productList) {
		this.productList = productList;
	}
	public void setDiscountID(String discountID) {
		this.discountID = discountID;
	}
	public void setSubtotal() {
		double result = 0; 
		for (ProductModel pro: productList) {
			result +=pro.getTotal(); 
		}
		this.subtotal = result; 
	}
	public void setTotal() {
		this.total = subtotal- discountValue; 
	}
	public void setDiscountValue() {
		if (discountID!=null)
		this.discountValue = subtotal * DiscountDAO.getDiscountByID(discountID).getPercent()/100; 
		this.discountValue = 0; 
	}
	public void setTenderAmount(double tenderAmount) {
		this.tenderAmount = tenderAmount;
	}
	public BillModel(String billID, String employeeID, String customerID, List<ProductModel> productList,
			String discountID, double subtotal, double total, double discountValue, double tenderAmount,
			Date billDate) {
		super();
		this.billID = billID;
		this.employeeID = employeeID;
		this.customerID = customerID;
		this.productList = productList;
		this.discountID = discountID;
		this.subtotal = subtotal;
		this.total = total;
		this.discountValue = discountValue;
		this.tenderAmount = tenderAmount;
		this.billDate = billDate;
	}
	public BillModel(String employeeID, String customerID, List<ProductModel> productList, String discountID,
			double subtotal, double total, double discountValue, double tenderAmount) {
		super();
		this.employeeID = employeeID;
		this.customerID = customerID;
		this.productList = productList;
		this.discountID = discountID;
		this.subtotal = subtotal;
		this.total = total;
		this.discountValue = discountValue;
		this.tenderAmount = tenderAmount;
	} 
	
	
	public Object[] toOject() {
		return new Object[] {billID, billDate, employeeID, customerID, total};
	}
	public String toStringConsoleTest() {
		return billID + " - "+ total + "\n"; 
	}
	
}
