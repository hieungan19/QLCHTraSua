package model;

import java.util.Date;

public class EmployeeModel {
	protected String employeeID;
	protected String name;
	protected String id;
	protected String phoneNumber;
	protected String address;

	public String getAddress() {
		return address;
	}

	public String getGender() {
		return gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	protected Date birthday;
	protected String gender;
	protected double salary;
	protected Date startDate;
	protected String position;

	public String getEmployeeID() {
		return employeeID;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPosition() {
		return position;
	}

	public double getSalary() {
		return salary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public EmployeeModel(String employeeID, String name, String id, String phoneNumber, String address, Date birthday,
			String gender, double salary, Date startDate, String position) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.birthday = birthday;
		this.gender = gender;
		this.salary = salary;
		this.startDate = startDate;
		this.position = position;
	}

	public Object[] toObject() {
		return new Object[] { employeeID, name, id, phoneNumber, address, birthday, gender, salary, startDate,
				position };
	}
	
	public EmployeeModel() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeModel(String name, String id, String phoneNumber, String address, Date birthday, String gender,
			double salary, Date startDate, String position) {
		super();
		this.name = name;
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.birthday = birthday;
		this.gender = gender;
		this.salary = salary;
		this.startDate = startDate;
		this.position = position;
	}
	

}
