package model;

import java.sql.Timestamp;
import java.util.Date;

public class AttendanceTrackingModel {
	private String attID;
	private String empID; 
	private Timestamp start;
	private Timestamp end;
	private double penalty;
	private double salary; 
	
	
	public AttendanceTrackingModel(String empID, Timestamp start, Timestamp end, double penalty, double salary) {
		super();
		this.empID = empID;
		this.start = start;
		this.end = end;
		this.penalty = penalty;
		this.salary = salary;
	}

	
	public AttendanceTrackingModel(String attID, String empID, Timestamp start, Timestamp end, double penalty,
			double salary) {
		super();
		this.attID = attID;
		this.empID = empID;
		this.start = start;
		this.end = end;
		this.penalty = penalty;
		this.salary = salary;
	}


	public String getEmpID() {
		return empID;
	}
	public Timestamp getStart() {
		return start;
	}
	public Timestamp getEnd() {
		return end;
	}
	public double getPenalty() {
		return penalty;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public void setStart(Timestamp start) {
		this.start = start;
	}
	public void setEnd(Timestamp end) {
		this.end = end;
	}
	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAttID() {
		return attID;
	}

	public void setAttID(String attID) {
		this.attID = attID;
	}
	
	
	
	
	
}
