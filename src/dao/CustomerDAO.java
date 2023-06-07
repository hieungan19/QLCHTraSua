package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.CustomerModel;



public class CustomerDAO {
	public static final String COLUMN_ID = "MAKH";
	public static final String COLUMN_NAME = "HOTEN";
	public static final String COLUMN_PHONE = "SDT";
	public static final String COLUMN_POINT = "DIEMTICHLUY";
	public static final String COLUMN_LEVEL = "CAPDO";
	public static final String COLUMN_REGISTRATION_DATE = "NGDANGKY";
	private static final String GET_ALL_CUSTOMER = "SELECT * FROM ADMINDOAN.KHACHHANG";
	private static final String INSERT_CUSTOMER = "INSERT INTO ADMINDOAN.KHACHHANG (HOTEN, SDT) VALUES(?,?)";
	private static final String GET_MAXID_INSERTED_CUSTOMER = "SELECT * FROM ADMINDOAN.KHACHHANG WHERE ROWID = (SELECT MAX(ROWID) FROM ADMINDOAN.KHACHHANG)";
	private static final String GET_CUSTOMER_BY_ID = "SELECT * FROM ADMINDOAN.KHACHHANG WHERE MAKH = ?"; 
	private static final String DELETE_CUSTOMER_BY_ID = "DELETE FROM ADMINDOAN.KHACHHANG WHERE MAKH = ? ";
	private static final String UPDATE_CUSTOMER_INFO = "UPDATE ADMINDOAN.KHACHHANG SET HOTEN = ?, SDT = ? WHERE MAKH = ?"; 
	private static final String COMMIT = "COMMIT"; 
	public static List<CustomerModel> getCustomerList (){
		List<CustomerModel> result = new ArrayList<>();
		int test = 0; 
		try {
			Connection con = MyDB.getInstance().getConnection();
            Statement state = con.createStatement();
            state.execute(COMMIT); 
            ResultSet rs = state.executeQuery(GET_ALL_CUSTOMER);
            while(rs.next()) {
            	++test; 
            	String customerID = rs.getString(COLUMN_ID);
            	String name = rs.getNString(COLUMN_NAME); 
            	String phoneNumber = rs.getString(COLUMN_PHONE);
            	int point = rs.getInt(COLUMN_POINT);
            	String level = rs.getString(COLUMN_LEVEL); 
            	Date registration = rs.getDate(COLUMN_REGISTRATION_DATE);
            	CustomerModel customer = new CustomerModel(customerID, name, phoneNumber, point, level, registration);
            	result.add(customer); 
            }
            System.out.println(test);
            return result; 
		}
		catch(SQLException e) {
			System.out.println("Error in CustomerDAO at get CustomerList: "+e.getMessage());
		
		}
		
		return result; 
	}
	
	public static int insertCustomer(CustomerModel model) {
		 try {
			Connection c = MyDB.getInstance().getConnection();
			PreparedStatement psInsert = c.prepareStatement(INSERT_CUSTOMER);
			psInsert.setString(1,model.getName());
			psInsert.setString(2,model.getPhoneNumber());
			int check = psInsert.executeUpdate();
			Statement st = c.createStatement();
			st.execute(COMMIT); 
			Statement state = c.createStatement();
            state.execute(COMMIT);
			if (check >0 )
				return 1; 
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return 0; 
	}
	
	public static CustomerModel getMaxIDCustomer() {
		try {
			Connection c = MyDB.getInstance().getConnection();
			Statement state = c.createStatement();
			ResultSet rs = state.executeQuery(GET_MAXID_INSERTED_CUSTOMER); 
			if (rs.next()) {
				CustomerModel model = new CustomerModel(rs.getString(COLUMN_ID), rs.getString(COLUMN_NAME), rs.getString(COLUMN_PHONE), rs.getInt(COLUMN_POINT), rs.getString(COLUMN_LEVEL), rs.getDate(COLUMN_REGISTRATION_DATE));
				return model; 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	
	public static CustomerModel getCustomerByID(String id) {
		try {
			Connection c = MyDB.getInstance().getConnection();
			PreparedStatement psGet = c.prepareStatement(GET_CUSTOMER_BY_ID);	
			psGet.setString(1, id);
			ResultSet rs = psGet.executeQuery(); // Execute a SELECT query
	        if (rs.next()) {
	            // Retrieve data from the ResultSet and create a CustomerModel object
	            CustomerModel customer = new CustomerModel();
	            customer.setCustomerID(rs.getString(COLUMN_ID));
	            customer.setName(rs.getString(COLUMN_NAME));
	            customer.setPhoneNumber(rs.getString(COLUMN_PHONE));
	            customer.setPoint(rs.getInt(COLUMN_POINT));
	            customer.setLevel(rs.getString(COLUMN_LEVEL));
	            customer.setRegistration(rs.getDate(COLUMN_REGISTRATION_DATE));
	            // Set other attributes as needed
	            System.out.println("ID+ "+customer.getName());
	            
	            Statement state = c.createStatement();
	            state.execute(COMMIT); 
	            return customer;
	         
	        } 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	public static int deleteCustomerByID(String id) {
		try {
			int check = 0; 
			Connection c = MyDB.getInstance().getConnection();
			PreparedStatement psDelete = c.prepareStatement(DELETE_CUSTOMER_BY_ID);
			psDelete.setString(1, id);
			check = psDelete.executeUpdate();
			Statement state = c.createStatement();
            state.execute(COMMIT); 
			if (check >0) return 1; 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0; 
	}
	
	public static int updateCustomer(String id,String name, String phoneNumber) {
		try {
			int check = 0; 
			Connection c = MyDB.getInstance().getConnection();
			PreparedStatement psUpdate = c.prepareStatement(UPDATE_CUSTOMER_INFO);
			psUpdate.setString(1,name );
			psUpdate.setString(2,phoneNumber); 
			psUpdate.setString(3, id);
			check = psUpdate.executeUpdate();
			if (check >0) return 1; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	
	}
	
}
