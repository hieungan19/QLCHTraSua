package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.BillModel;
import model.ProductModel;

public class BillDAO {
	public static final String COLUMN_BILL_ID = "MAHD";
	public static final String COLUMN_CUSTOMER_ID = "MAKH";
	public static final String COLUMN_EMPLOYEE_ID = "MANV";
	public static final String COLUMN_SUBTOTAL = "TAMTINH";
	public static final String COLUMN_TOTAL ="TONGCONG";
	public static final String COLUMN_DISCOUNT_VALUE = "SOTIENKM"; 
	public static final String COLUMN_DISCOUNT_ID = "MAKM";
	public static final String COLUMN_TENDER_AMOUNT = "TIENKHACHDUA";
	public static final String COLUMN_DATE = "NGHD"; 
	
	public static final String GET_ALL_BILLS = "SELECT * FROM HOADON";
	public static final String INSERT_BILL = "INSERT INTO HOADON (MANV, MAKH,TAMTINH,MAKM,SOTIENKM,TONGCONG,TIENKHACHDUA) VALUES(?,?,?,?,?,?,?)";
	public static final String INSERT_DRINK = "INSERT INTO CHITIETHD(MAHD, MASP, SOLUONG) VALUES (?,?,?)";
	public static final String INSERT_DRINK_TOPPING = "INSERT INTO CHITIETTHUCUONG(MACTHD, MATOPPING, SOLUONG) VALUES (?,?,?)"; 
	public static final String GET_MAX_ID_BILL = "SELECT * FROM HOADON WHERE ROWID = (SELECT MAX(ROWID) FROM HOADON)";
	public static final String GET_MAX_ID_PRODUCT = "SELECT * FROM CHITIETHD WHERE ROWID = (SELECT MAX(ROWID) FROM CHITIETHD)"; 
	
	public static int insertDrink(String billID, ProductModel pro) {
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT_DRINK); 
			ps.setString(1,billID);
			ps.setString(2, pro.getProductID());
			ps.setInt(3, pro.getAmount());
			
			int check = ps.executeUpdate(); 
			if (check>0) return 1; 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0; 
	}
	public static int insertTopping(String detailID, ProductModel topping) {
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT_DRINK_TOPPING);
			ps.setString(1, detailID);
			ps.setString(2, topping.getProductID());
			ps.setInt(3, topping.getAmount());
			
			int check = ps.executeUpdate();
			if (check >0) return 1; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0; 
	}
	public static ProductModel getProductDataFromResultSetNoToppingList(ResultSet rs) {
		String detailID;
		try {
			if (rs.next()) {
				detailID = rs.getString("MACTHD");
				String billID = rs.getString("MAHD");
				String productID = rs.getString("MASP");
				int amount = rs.getInt("SOLUONG"); 
				ProductModel pro = new ProductModel(); 
				pro.setAmount(amount);
				pro.setBillID(billID);
				pro.setDetailID(detailID);
				pro.setProductID(productID);
				
				return pro; 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
		

	}
	public static BillModel getBillDataFromResultSetNoProductList(ResultSet rs) {
		try {
				String  billID = rs.getString(COLUMN_BILL_ID) ;
				String employeeID = rs.getString(COLUMN_EMPLOYEE_ID);
				String customerID = rs.getString(COLUMN_CUSTOMER_ID); 
				String discountID = rs.getString(COLUMN_DISCOUNT_ID); 
				double subtotal = rs.getDouble(COLUMN_SUBTOTAL);
				double total = rs.getDouble(COLUMN_TOTAL); 
				double discountValue = rs.getDouble(COLUMN_DISCOUNT_VALUE); 
				double tenderAmount = rs.getDouble(COLUMN_TENDER_AMOUNT);
				Date billDate = rs.getDate(COLUMN_DATE); 
				return new BillModel(billID, employeeID, customerID, null, discountID, subtotal, total, discountValue, tenderAmount, billDate); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null; 
	}
	public static BillModel getMaxIDBill() {
		BillModel  bill = null; 
		try {
			Connection con = MyDB.getInstance().getConnection();
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery(GET_MAX_ID_BILL); 
			if (rs.next())bill = getBillDataFromResultSetNoProductList(rs); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bill; 
	}
	
	// SAN PHAM TRONG BILL
	public static ProductModel getMaxIDProduct() {
		try {
			Connection con = MyDB.getInstance().getConnection();
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery(GET_MAX_ID_PRODUCT); 
			ProductModel pro =  getProductDataFromResultSetNoToppingList(rs);
			return pro; 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	
	
	public static int insertBill(BillModel bill) {
		BillModel result; 
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT_BILL);
			ps.setString(1, bill.getEmployeeID());
			ps.setString(2, bill.getCustomerID());
			ps.setDouble(3, bill.getSubtotal());
			ps.setString(4, bill.getDiscountID());
			ps.setDouble(5, bill.getDiscountValue());
			ps.setDouble(6, bill.getTotal());
			ps.setDouble(7,bill.getTenderAmount());
			
			int check = ps.executeUpdate(); 
			
			
			if (check >0 ) {
				  result = getMaxIDBill(); 
				  System.out.println("MAX ID BILL: "+result.getBillID());
				  String billID = result.getBillID(); 
				  for (ProductModel pro: bill.getProductList()) {
					 insertDrink(billID, pro); 
					 ProductModel resultPro = getMaxIDProduct();
					 String detailID = resultPro.getDetailID();
					 for (ProductModel topping: pro.getToppingList()) {
						 insertTopping(detailID, topping); 
					 }
					 
				  }
				  return 1; 
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0; 
	}
	
	public static List<BillModel> getAllBill (){
		List<BillModel> result = new ArrayList<>(); 
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement ps = con.prepareStatement(GET_ALL_BILLS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BillModel bill = getBillDataFromResultSetNoProductList(rs); 
				result.add(bill); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result; 
	}
	
}
