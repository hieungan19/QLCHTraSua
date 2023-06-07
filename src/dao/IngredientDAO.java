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
import model.ImportExportModel;
import model.IngredientModel;

public class IngredientDAO {
	public static final String COLUMN_ID = "MANL";
	public static final String COLUMN_NAME = "TENNL";
	public static final String COLUMN_PRICE = "GIA";
	public static final String COLUMN_UNIT = "DONVI";
	public static final String COLUMN_AMOUNT = "SOLUONG";
	public static final String COLUMN_NSX = "NSX";
	public static final String COLUMN_HSD = "HSD"; 
	public static final String COLUMN_SUPPLIER = "NHACUNGCAP"; 
	private static final String GET_ALL_INGREDIENTS = "SELECT * FROM ADMINDOAN.NGUYENLIEU";
	private static final String INSERT_INGREDIENT = "INSERT INTO ADMINDOAN.NGUYENLIEU (TENNL, DONVI,SOLUONG,GIA, NSX, HSD, NHACUNGCAP) VALUES(?,?,?,?,?,?,?)";
	private static final String GET_MAXID_INSERTED_INGREDIENT = "SELECT * FROM ADMINDOAN.NGUYENLIEU WHERE ROWID = (SELECT MAX(ROWID) FROM ADMINDOAN.NGUYENLIEU)";
	private static final String COMMIT = "COMMIT"; 
	private static final String UPDATE_INGREDIENT_BY_ID = "UPDATE ADMINDOAN.NGUYENLIEU SET SOLUONG= 0 WHERE MANL = ?"; 
	private static final String UPDATE_INGREDIENT_INFO = "UPDATE ADMINDOAN.NGUYENLIEU SET TENNL = ?, DONVI = ?, SOLUONG = ?, GIA=?, NSX = ?, HSD = ?, NHACUNGCAP = ? WHERE MANL = ?"; 
	private static final String GET_INGREDIENT_BY_ID = "SELECT * FROM ADMINDOAN.NGUYENLIEU WHERE MANL = ?"; 
	
	private static final String GET_ALL_NHAPXUAT = "SELECT * FROM ADMINDOAN.XUATNHAPNL"; 
	
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
            	Date mfDate = rs.getDate(COLUMN_NSX);
            	Date expDate = rs.getDate(COLUMN_HSD);
            	String supplier  = rs.getString(COLUMN_SUPPLIER); 
            	IngredientModel ingredient = new IngredientModel(ingredientID,name, unit, amount, price, mfDate, expDate, supplier); 
            	if (amount!=0)result.add(ingredient); 
            }
            System.out.println("So luong nguyen lieu: "+test);
            return result; 
		}
		catch(SQLException e) {
			System.out.println("Error in InventoryItemDAO at get item list: "+e.getMessage());
		
		}
		
		return result; 
	}
	public static void setDataForPrepareStatement(PreparedStatement ps, IngredientModel model) {
		try {
			ps.setString(1,model.getName());
			ps.setString(2,model.getUnit());
			ps.setDouble(3, model.getAmount());
			ps.setDouble(4, model.getPrice());
			java.sql.Date sqlDate = null;
			if (model.getMfDate() != null) {
				sqlDate = new java.sql.Date(model.getMfDate().getTime());
			}
			ps.setDate(5, sqlDate);
			if (model.getExpDate() != null) {
				sqlDate = new java.sql.Date(model.getExpDate().getTime());
			}
			ps.setDate(6, sqlDate);
			ps.setNString(7, model.getSupplier());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int insertIngredient(IngredientModel model) {
		 try {
			Connection c = MyDB.getInstance().getConnection();
			PreparedStatement psInsert = c.prepareStatement(INSERT_INGREDIENT);
			setDataForPrepareStatement(psInsert, model); 
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
				IngredientModel model = new IngredientModel(rs.getString(COLUMN_ID), rs.getString(COLUMN_NAME), rs.getString(COLUMN_UNIT), rs.getDouble(COLUMN_AMOUNT), rs.getDouble(COLUMN_PRICE), rs.getDate(COLUMN_NSX),rs.getDate(COLUMN_HSD),rs.getNString(COLUMN_SUPPLIER));
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
			PreparedStatement psDelete = c.prepareStatement(UPDATE_INGREDIENT_BY_ID);
			psDelete.setString(1, id);
			check = psDelete.executeUpdate();
			if (check >0) return 1; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0; 
	}
	
	public static int updateIngredient(IngredientModel model) {
		try {
			int check = 0; 
			Connection c = MyDB.getInstance().getConnection();
			PreparedStatement psUpdate = c.prepareStatement(UPDATE_INGREDIENT_INFO);
			setDataForPrepareStatement(psUpdate, model);
			psUpdate.setString(8, model.getIngredientID());
		
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
	            ingredient.setExpDate(rs.getDate(COLUMN_HSD));
	            ingredient.setMfDate(rs.getDate(COLUMN_NSX));
	            ingredient.setSupplier(rs.getNString(COLUMN_SUPPLIER));
	            return ingredient;
	         
	        } 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	

	public static List<ImportExportModel> getImportExportModelList(){
		List<ImportExportModel> result = new ArrayList<>(); 
		try {
			Connection c = MyDB.getInstance().getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(GET_ALL_NHAPXUAT);
			while (rs.next()) {
				String id = rs.getString("MAXN");
				String ingreID = rs.getString("MANL");
				Date ieDate = rs.getDate("NGAYNX");
				double amount = rs.getDouble("SOLUONG");
				
				ImportExportModel ie = new ImportExportModel(id, ingreID, ieDate, amount);
				result.add(ie); 
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result; 
		
	}
}
