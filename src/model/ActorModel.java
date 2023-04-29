package model;

public class ActorModel extends EmployeeModel{
	private AccountModel account;

	public ActorModel(String employeeID, String name, String email, String phoneNumber, String baseSalary,
			String position, String address, AccountModel account) {
		super(employeeID, name, email, phoneNumber, baseSalary, position, address);
		this.account = account;
	}	
}
