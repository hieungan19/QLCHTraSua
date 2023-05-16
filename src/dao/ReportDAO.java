package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.AttendanceTrackingModel;
import model.ProductModel;

public class ReportDAO {
	public static String GET_TOTAL_BILLS_BY_DATE = "SELECT TONGCONG FROM HOADON "
			+ "WHERE EXTRACT(DAY FROM NGHD) <= ? AND EXTRACT(MONTH FROM NGHD) <= ? AND EXTRACT(YEAR FROM NGHD) <= ? "
			+ "AND EXTRACT(DAY FROM NGHD) >= ? AND EXTRACT(MONTH FROM NGHD) >= ? AND EXTRACT(YEAR FROM NGHD) >= ?";
	public static final String GET_ALL_EMPLOYEE_SALARY_BY_DATE = "SELECT * FROM CHAMCONG "
			+ "WHERE EXTRACT(DAY FROM GIOKT) <= ? AND EXTRACT(MONTH FROM GIOKT) <= ? AND EXTRACT(YEAR FROM GIOKT) <= ? "
			+ "AND EXTRACT(DAY FROM GIOBD) >= ? AND EXTRACT(MONTH FROM GIOBD) >= ? AND EXTRACT(YEAR FROM GIOBD) >= ?";
	
	public static final String GET_LIST_DRINK_SALE = "SELECT MASP, SUM(SOLUONG) FROM CHITIETHD "
			+ "WHERE MASP NOT IN (SELECT MASP FROM SANPHAM WHERE LOAISP = 'TOPPING') "
			+ "	AND MAHD IN (SELECT MAHD FROM HOADON WHERE  EXTRACT(DAY FROM NGHD) <= ? AND EXTRACT(MONTH FROM NGHD) <= ? AND EXTRACT(YEAR FROM NGHD) <= ? "
			+ "	AND EXTRACT(DAY FROM NGHD) >= ? AND EXTRACT(MONTH FROM NGHD) >= ? AND EXTRACT(YEAR FROM NGHD) >= ?)"
			+ "	GROUP BY MASP"
			+ " ORDER BY SUM(SOLUONG) DESC"; 
	
//	public static final String GET_NUMBER_OF_CUSTOMER = "SELECT * FROM "
	
	public static double getBillByDate(Date start, Date end) {
		double result = 0; 
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psGet = con.prepareStatement(GET_TOTAL_BILLS_BY_DATE);
			psGet.setInt(1,end.getDate() );
			psGet.setInt(2,end.getMonth()+1 );
			psGet.setInt(3,end.getYear()+1900) ;
			psGet.setInt(4,start.getDate() );
			psGet.setInt(5,start.getMonth()+1 );
			psGet.setInt(6,start.getYear()+1900) ;
			ResultSet rs = psGet.executeQuery();
			
			while (rs.next()) {
				double total = rs.getDouble("TONGCONG"); 
				result+=total; 

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	
	public static double getAllSalary(java.util.Date startDate, java.util.Date endDate) {
		double result = 0; 
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psGet = con.prepareStatement(GET_ALL_EMPLOYEE_SALARY_BY_DATE);
			psGet.setInt(1,endDate.getDate() );
			psGet.setInt(2,endDate.getMonth()+1 );
			psGet.setInt(3,endDate.getYear()+1900) ;
			psGet.setInt(4,startDate.getDate() );
			psGet.setInt(5,startDate.getMonth()+1 );
			psGet.setInt(6,startDate.getYear()+1900) ;
			ResultSet rs = psGet.executeQuery();
			while (rs.next()) {
				double salary  = rs.getDouble("LUONG"); 
				result+=salary; 
				

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	
	public static List<ProductModel> getListDrinkSaleDecs(Date startDate, Date endDate) {
		List<ProductModel> result = new ArrayList<>(); 
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psGet = con.prepareStatement(GET_LIST_DRINK_SALE); 
			psGet.setInt(1,endDate.getDate() );
			psGet.setInt(2,endDate.getMonth()+1 );
			psGet.setInt(3,endDate.getYear()+1900) ;
			psGet.setInt(4,startDate.getDate() );
			psGet.setInt(5,startDate.getMonth()+1 );
			psGet.setInt(6,startDate.getYear()+1900) ;
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
	
}
