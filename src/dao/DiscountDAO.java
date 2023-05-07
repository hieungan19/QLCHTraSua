package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DiscountModel;

public class DiscountDAO {
	public static final String COLUMN_ID = "MAKM";
	public static final String COLUMN_NAME = "TENKM";
	public static final String COLUMN_TOTAL_BILL = "TONGHD";
	public static final String COLUMN_PERCENT = "PHANTRAMGIAM";
	public static final String COLUMN_START_DATE = "NGBATDAU";
	public static final String COLUMN_END_DATE = "NGKETTHUC";
	public static final String COLUMN_CUSTOMER = "DOITUONG"; 
	
	public static final String GET_ALL_DISCOUNT = "SELECT * FROM KHUYENMAI";
	public static final String GET_DISCOUNT_BY_ID = "SELECT * FROM KHUYENMAI WHERE MAKM = ?";
	public static final String GET_DISCOUNT_BY_CUSTOMER_AND_TIME = ""; 
	public static final String INSERT_DISCOUNT = "INSERT INTO KHUYENMAI (TENKM, TONGHD, PHANTRAMGIAM, NGBATDAU, NGKETTHUC, DOITUONG) VALUES (?,?,?,?,?,?) ";
	public static final String UPDATE_DISCOUNT = "UPDATE KHUYENMAI SET TENKM = ?, TONGHD = ?, PHANTRAMGIAM = ?, NGBATDAU = ?, NGKETTHUC = ?, DOITUONG = ? WHERE MAKM = ?"; 
	public static final String GET_MAX_ID_DISCOUNT = "SELECT * FROM KHUYENMAI WHERE ROWID = (SELECT MAX(ROWID) FROM KHUYENMAI)";;
	public static final String DELETE_DISCOUNT_BY_ID = "DELETE FROM KHUYENMAI WHERE MAKM = ?"; 
	public static final String COMMIT = "COMMIT"; 
	
	public static List<DiscountModel> getDiscountList (){
		List<DiscountModel> result = new ArrayList<>();
		int test = 0; 
		try {
			Connection con = MyDB.getInstance().getConnection();
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(GET_ALL_DISCOUNT);
            while(rs.next()) {
            	++test; 
            	String discountID = rs.getString(COLUMN_ID); 
            	String name = rs.getNString(COLUMN_NAME); 
            	double totalBill = rs.getDouble(COLUMN_TOTAL_BILL); 
            	double percent = rs.getDouble(COLUMN_PERCENT);
            	Date start = rs.getDate(COLUMN_START_DATE);
            	Date end = rs.getDate(COLUMN_END_DATE);
            	String customer = rs.getString(COLUMN_CUSTOMER);
            	DiscountModel discount  = new DiscountModel(discountID, name, totalBill, percent, start, end, customer);
            	result.add(discount);  	
            	
            }
            System.out.println("So luong nguyen lieu: "+test);
            return result; 
		}
		catch(SQLException e) {
			System.out.println("Error in InventoryItemDAO at get item list: "+e.getMessage());
		
		}
		
		return result; 
	}
	
	public static int insertDiscount(DiscountModel discount) {
		try {
			Connection con = MyDB.getInstance().getConnection();
			Statement st = con.createStatement(); 
			PreparedStatement psInsert = con.prepareStatement(INSERT_DISCOUNT);
			psInsert.setNString(1, discount.getName());
			psInsert.setDouble(2, discount.getTotalBill());
			psInsert.setDouble(3, discount.getPercent());
			java.sql.Date sqlStartDate = null;
			java.sql.Date sqlEndDate = null;
			if (discount.getStartDate() != null) {
			    sqlStartDate = new java.sql.Date(discount.getStartDate().getTime());
			}
			if (discount.getEndDate() != null) {
			    sqlEndDate = new java.sql.Date(discount.getEndDate().getTime());
			}
			psInsert.setDate(4, sqlStartDate);
			psInsert.setDate(5, sqlEndDate);

			psInsert.setString(6, discount.getCustomerType());
			
			st.execute(COMMIT); 
			int check = psInsert.executeUpdate(); 
			if (check>0) return 1; 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0; 
	}
	
	public static DiscountModel getMaxIDDiscount() {
		try {
			Connection con = MyDB.getInstance().getConnection();
			Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(GET_MAX_ID_DISCOUNT);
            if(rs.next()) { 
            	String discountID = rs.getString(COLUMN_ID); 
            	String name = rs.getNString(COLUMN_NAME); 
            	double totalBill = rs.getDouble(COLUMN_TOTAL_BILL); 
            	double percent = rs.getDouble(COLUMN_PERCENT);
            	Date start = rs.getDate(COLUMN_START_DATE);
            	Date end = rs.getDate(COLUMN_END_DATE);
            	String customer = rs.getString(COLUMN_CUSTOMER);
            	DiscountModel discount  = new DiscountModel(discountID, name, totalBill, percent, start, end, customer);
            	 
            	return discount; 
            	
            }
            
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
        
	}
	
	public static DiscountModel getDiscountByID(String discountID) {
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psGetByID = con.prepareStatement(GET_DISCOUNT_BY_ID); 
			psGetByID.setString(1, discountID);
            ResultSet rs = psGetByID.executeQuery(); 
            if(rs.next()) {  
            	String name = rs.getNString(COLUMN_NAME); 
            	double totalBill = rs.getDouble(COLUMN_TOTAL_BILL); 
            	double percent = rs.getDouble(COLUMN_PERCENT);
            	Date start = rs.getDate(COLUMN_START_DATE);
            	Date end = rs.getDate(COLUMN_END_DATE);
            	String customer = rs.getString(COLUMN_CUSTOMER);
            	DiscountModel discount  = new DiscountModel(discountID, name, totalBill, percent, start, end, customer);
            	return discount; 
            	
            }
            
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	
	public static int updateDiscount(DiscountModel discount) {
		
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psUpdate = con.prepareStatement(UPDATE_DISCOUNT);
			psUpdate.setNString(1, discount.getName());
			psUpdate.setDouble(2, discount.getTotalBill());
			psUpdate.setDouble(3, discount.getPercent());
			java.sql.Date sqlStartDate = null;
			java.sql.Date sqlEndDate = null;
			if (discount.getStartDate() != null) {
			    sqlStartDate = new java.sql.Date(discount.getStartDate().getTime());
			}
			if (discount.getEndDate() != null) {
			    sqlEndDate = new java.sql.Date(discount.getEndDate().getTime());
			}
			psUpdate.setDate(4, sqlStartDate);
			psUpdate.setDate(5, sqlEndDate);

			psUpdate.setString(6, discount.getCustomerType());
			
			psUpdate.setString(7, discount.getDiscountID());
			
			int check = psUpdate.executeUpdate();
			
			if (check >0) return 1;
			Statement st = con.createStatement(); 
			st.execute(COMMIT);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0; 
	}
	
	public static int deleteDiscountByID(String id) {
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psDelete = con.prepareStatement(DELETE_DISCOUNT_BY_ID);
			psDelete.setString(1, id);
			int check = psDelete.executeUpdate();
			if (check >0) return 1; 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0; 
	}
	
	
}
