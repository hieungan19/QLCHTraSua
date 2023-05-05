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
import model.IngredientModel;

public class IngredientDAO {
	public static final String COLUMN_ID = "MANL";
	public static final String COLUMN_NAME = "TENNL";
	public static final String COLUMN_PRICE = "GIA";
	public static final String COLUMN_UNIT = "DONVI";
	public static final String COLUMN_AMOUNT = "SOLUONG";
	private static final String GET_ALL_INGREDIENTS = "SELECT * FROM NGUYENLIEU";
	private static final String INSERT_INGREDIENT = "INSERT INTO NGUYENLIEU (TENNL, DONVI,SOLUONG,GIA) VALUES(?,?,?,?)";
	private static final String GET_MAXID_INSERTED_INGREDIENT = "SELECT * FROM NGUYENLIEU WHERE ROWID = (SELECT MAX(ROWID) FROM NGUYENLIEU)";
	private static final String COMMIT = "COMMIT"; 
	private static final String DELETE_INGREDIENT_BY_ID = "DELETE FROM NGUYENLIEU WHERE MANL = ?"; 
	private static final String UPDATE_INGREDIENT_INFO = "UPDATE NGUYENLIEU SET TENNL = ?, DONVI = ?, SOLUONG = ?, GIA=? WHERE MANL = ?"; 
	private static final String GET_INGREDIENT_BY_ID = "SELECT * FROM NGUYENLIEU WHERE MANL = ?"; 
	
	public static List<IngredientModel> getIngredientList (){
		List<IngredientModel> result = new ArrayList<>();
		int test = 0; 
		try {
			Connection con = MyDB.getInstance().getConnection();
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(GET_ALL_INGREDIENTS);
            while(rs.next()) {
            	++test; 
            	String ingredientID = rs.getString(COLUMN_ID);
            	String name = rs.getNString(COLUMN_NAME); 
            	String unit = rs.getNString(COLUMN_UNIT);
            	double amount = rs.getDouble(COLUMN_AMOUNT); 
            	double price = rs.getDouble(COLUMN_PRICE); 
            	IngredientModel ingredient = new IngredientModel(ingredientID, name, unit, amount, price); 
            	result.add(ingredient); 
            }
            System.out.println("So luong nguyen lieu: "+test);
            return result; 
		}
		catch(SQLException e) {
			System.out.println("Error in InventoryItemDAO at get item list: "+e.getMessage());
		
		}
		
		return result; 
	}
	
	public static int insertIngredient(IngredientModel model) {
		 try {
			Connection c = MyDB.getInstance().getConnection();
			PreparedStatement psInsert = c.prepareStatement(INSERT_INGREDIENT);
			psInsert.setString(1,model.getName());
			psInsert.setString(2,model.getUnit());
			psInsert.setDouble(3, model.getAmount());
			psInsert.setDouble(4, model.getPrice());
			int check = psInsert.executeUpdate();
			Statement st = c.createStatement();
			st.execute(COMMIT); 
			if (check >0)
				return 1; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return 0; 
	}
	
	public static IngredientModel getMaxIDIngredient() {
		try {
			Connection c = MyDB.getInstance().getConnection();
			Statement state = c.createStatement();
			ResultSet rs = state.executeQuery(GET_MAXID_INSERTED_INGREDIENT); 
			if (rs.next()) {
				System.out.println("VUA INSERT VAO: "+ rs.getString(COLUMN_NAME));
				IngredientModel model = new IngredientModel(rs.getString(COLUMN_ID), rs.getString(COLUMN_NAME), rs.getString(COLUMN_UNIT), rs.getDouble(COLUMN_AMOUNT), rs.getDouble(COLUMN_PRICE));
				return model; 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	
	public static int deleteIngredientByID(String id) {
		try {
			int check = 0; 
			Connection c = MyDB.getInstance().getConnection();
			PreparedStatement psDelete = c.prepareStatement(DELETE_INGREDIENT_BY_ID);
			psDelete.setString(1, id);
			check = psDelete.executeUpdate();
			if (check >0) return 1; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0; 
	}
	
	public static int updateIngredient(String id,String name, String unit, double amount, double price) {
		try {
			int check = 0; 
			Connection c = MyDB.getInstance().getConnection();
			PreparedStatement psUpdate = c.prepareStatement(UPDATE_INGREDIENT_INFO);
			psUpdate.setString(1,name );
			psUpdate.setString(2,unit); 
			psUpdate.setDouble(3, amount);
			psUpdate.setDouble(4, price);
			psUpdate.setString(5, id);
			check = psUpdate.executeUpdate();
			if (check >0) return 1; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	
	}
	
	public static IngredientModel getIngredientByID(String id) {
		try {
			Connection c = MyDB.getInstance().getConnection();
			PreparedStatement psGet = c.prepareStatement(GET_INGREDIENT_BY_ID);	
			psGet.setString(1, id);
			ResultSet rs = psGet.executeQuery(); // Execute a SELECT query
	        if (rs.next()) {
	            // Retrieve data from the ResultSet and create a CustomerModel object
	            IngredientModel ingredient = new IngredientModel();
	            ingredient.setIngredientID(rs.getString(COLUMN_ID));
	            ingredient.setName(rs.getString(COLUMN_NAME));
	            ingredient.setPrice(rs.getDouble(COLUMN_PRICE));
	            ingredient.setAmount(rs.getDouble(COLUMN_AMOUNT));
	            ingredient.setUnit(rs.getString(COLUMN_UNIT));
	            return ingredient;
	         
	        } 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	

	
}
