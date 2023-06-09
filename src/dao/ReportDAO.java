package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.LoginController;
import model.AttendanceTrackingModel;
import model.ProductModel;

public class ReportDAO {
	public static String GET_TOTAL_BILLS_BY_DATE = "SELECT COUNT(MAHD), SUM(TONGCONG) FROM ADMINDOAN.HOADON "
			+ "WHERE NGHD>=? AND NGHD<=?"; 

	public static final String GET_LIST_DRINK_SALE = "SELECT MASP, SUM(SOLUONG) FROM ADMINDOAN.CHITIETHD "
			+ "WHERE MASP NOT IN (SELECT MASP FROM SANPHAM WHERE LOAISP = 'TOPPING') "
			+ "	AND MAHD IN (SELECT MAHD FROM ADMINDOAN.HOADON WHERE NGHD>=? AND NGHD<=? )"
			+ "	GROUP BY MASP" + " ORDER BY SUM(SOLUONG) DESC";

	public static final String GET_NUM_OF_CUSTOMER = "SELECT COUNT(MAKH) FROM ADMINDOAN.KHACHHANG WHERE NGDANGKY<=? OR (NGDANGKY>=? AND NGDANGKY<=?)";

	public static final String GET_INGRE_ID_IMPORT = "SELECT MANL, SUM(SOLUONG) FROM ADMINDOAN.XUATNHAPNL WHERE SOLUONG>0 AND NGAYNX>=? AND NGAYNX<=? GROUP BY MANL";
//	public static final String GET_NUMBER_OF_CUSTOMER = "SELECT * FROM "

	public static Map<String, Object> getBillByDate(Date start, Date end) {
		Map<String, Object> result = new HashMap<String, Object>(); 
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psGet = con.prepareStatement(GET_TOTAL_BILLS_BY_DATE);
			
			psGet.setDate(1,new java.sql.Date(start.getTime())) ;
			psGet.setDate(2, new java.sql.Date(end.getTime() ));
			
			ResultSet rs = psGet.executeQuery();

			if (rs.next()) {
				double total = rs.getDouble("SUM(TONGCONG)");
				int count = rs.getInt("COUNT(MAHD)"); 
				result.put("total", total);
				result.put("count", count); 

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}


	public static List<ProductModel> getListDrinkSaleDecs(Date startDate, Date endDate) {
		List<ProductModel> result = new ArrayList<>();
		if (LoginController.user.getPosition().equals("QUẢN LÝ"))
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psGet = con.prepareStatement(GET_LIST_DRINK_SALE);
			psGet.setDate(1,new java.sql.Date(startDate.getTime())) ;
			psGet.setDate(2, new java.sql.Date(endDate.getTime() ));
			ResultSet rs = psGet.executeQuery();
			while (rs.next()) {
				ProductModel pro = new ProductModel();
				pro.setProductID(rs.getString("MASP"));
				pro.setAmount(rs.getInt("SUM(SOLUONG)"));
				result.add(pro);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static int getNumberOfCustomer(Date startDate, Date endDate) {
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psGet = con.prepareStatement(GET_NUM_OF_CUSTOMER); 
			psGet.setDate(1,new java.sql.Date(startDate.getTime())) ;
			psGet.setDate(2,new java.sql.Date(startDate.getTime())) ;
			psGet.setDate(3,new java.sql.Date(endDate.getTime())) ;
			ResultSet rs = psGet.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("COUNT(MAKH)");
				return count; 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0; 
		
	}
	
	//tinh tong so tien da tieu xai cho nguyen lieu
	public static double getTotalAmountOfMoneySpentOnRawMaterials(Date startDate, Date endDate) {
		double result  = 0; 
		if (LoginController.user.getPosition().equals("QUẢN LÝ"))
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psGet = con.prepareStatement(GET_INGRE_ID_IMPORT); 
			psGet.setDate(1,new java.sql.Date(startDate.getTime())) ;
			psGet.setDate(2, new java.sql.Date(endDate.getTime() ));
			ResultSet rs = psGet.executeQuery();
			while (rs.next()) {
				String ingreID = rs.getString("MANL");
				System.out.println("INGRE ID: "+ ingreID);
				double count = rs.getDouble("SUM(SOLUONG)");
				double price = IngredientDAO.getIngredientByID(ingreID).getPrice();
				result+=price*count; 
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Math.abs(result); 
		
	}
	

}
