package model;

public class AccountModel  {
	private String userID;
	private String password;
	public AccountModel(String userID, String password) {
		super();
		this.userID = userID;
		this.password = password;
	}
	public String getUserID() {
		return userID;
	}
	public String getPassword() {
		return password;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	
	
	
	
}
