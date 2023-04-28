package model;

public class ActorModel extends EmployeeModel{
	private AccountModel account;

	public ActorModel(String employeeID, String name, String email, String phoneNumber, String coefficientsSalary,
			AccountModel account) {
		super(employeeID, name, email, phoneNumber, coefficientsSalary);
		this.account = account;
	} 
	
	
	
	
}
