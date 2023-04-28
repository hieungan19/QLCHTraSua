package model;

public class EmployeeModel {
	protected String employeeID;
	protected String name;
	protected String email;
	protected String phoneNumber;
	protected String baseSalary; 
	protected String position; //he so luong
	public EmployeeModel(String employeeID, String name, String email, String phoneNumber, String baseSalary) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.baseSalary = baseSalary;
	}
	
	

}
