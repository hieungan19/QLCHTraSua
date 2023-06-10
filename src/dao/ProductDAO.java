package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ProductModel;
import model.IngredientModel;
import model.ProductDetail;

public class ProductDAO {
	//
	public static final String COMMIT = "COMMIT";
	// ADMINDOAN.SANPHAM
	public static final String COLUMN_SPID = "MASP";
	public static final String COLUMN_SPNAME = "TENSP";
	public static final String COLUMN_SPPRICE = "GIA";
	public static final String COLUMN_SPTYPE = "LOAISP";
	public static final String COLUMN_IMAGE = "HINHANH";

	// CHI TIET SP
	public static final String COLUMN_CTAMOUNT = "SOLUONG";

	// NGUYEN LIEU
	public static final String COLUMN_NLID = "MANL";
	public static final String COLUMN_NLNAME = "TENNL";
	public static final String COLUMN_NLPRICE = "GIA";
	public static final String COLUMN_NLAMOUNT = "SOLUONG";
	public static final String COLUMN_NLUNIT = "DONVI";

	// sql query

	public static final String GET_ALL_PRODUCT = "SELECT * FROM ADMINDOAN.SANPHAM";
	public static final String GET_ALL_PRODUCT_DETAILS = "SELECT * FROM CHITIETSP";
	private static final String GET_MAXID_INSERTED_PRODUCT = "SELECT * FROM ADMINDOAN.SANPHAM WHERE ROWID = (SELECT MAX(ROWID) FROM ADMINDOAN.SANPHAM)";
	private static final String GET_PRODUCT_BY_ID = "SELECT * FROM ADMINDOAN.SANPHAM WHERE MASP = ?";
	private static final String INSERT_PRODUCT = "INSERT INTO ADMINDOAN.SANPHAM (TENSP, HINHANH, GIA, LOAISP) VALUES (?,?,?,?)";
	private static final String DELETE_PRODUCT_BY_ID = "DELETE FROM ADMINDOAN.SANPHAM WHERE MASP = ?";
	private static final String UPDATE_PRODUCT = "UPDATE ADMINDOAN.SANPHAM SET TENSP = ?, HINHANH = ?,GIA = ?, LOAISP = ? WHERE MASP = ?";
	// get ingredient list

	public static List<IngredientModel> getIngredientList() {
		return IngredientDAO.getIngredientList();
	}

	// get product List không bao gồm thông tin nguyên liệu chi tiết của sản phẩm đó
	public static List<ProductModel> getAllProducts() {
		List<ProductModel> result = new ArrayList<>();
		Connection con;
		int test = 0;
		try {
			con = MyDB.getInstance().getConnection();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(GET_ALL_PRODUCT);
			while (rs.next()) {
				++test;
				String productID = rs.getString(COLUMN_SPID);
				String name = rs.getNString(COLUMN_SPNAME);
				String loai = rs.getNString(COLUMN_SPTYPE);
				double price = rs.getDouble(COLUMN_SPPRICE);
				String imageUri = rs.getString(COLUMN_IMAGE);
				ProductModel product = new ProductModel(productID, name, price, loai, imageUri);
				result.add(product);
			}
			System.out.println(test);
			return result;
		} catch (SQLException e) {
			System.out.println("Error in getProductListWithoutIngredients() " + e.getMessage());

		}

		return result;

	}

	

	public static ProductModel getMaxIDProduct() {
		try {
			Connection c = MyDB.getInstance().getConnection();
			Statement state = c.createStatement();
			ResultSet rs = state.executeQuery(GET_MAXID_INSERTED_PRODUCT);
			if (rs.next()) {
				System.out.println("VUA INSERT VAO: " + rs.getString(COLUMN_SPNAME));
				ProductModel model = new ProductModel(rs.getString(COLUMN_SPID), rs.getString(COLUMN_SPNAME),
						rs.getDouble(COLUMN_SPPRICE), rs.getString(COLUMN_SPTYPE), rs.getString(COLUMN_IMAGE));
				return model;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// lấy 1 sản phẩm có bao gồm chi tiết sản phẩm bằng cách sử dụng ID
	public static ProductModel getProductByID(String productID) {
		try {
			Connection c = MyDB.getInstance().getConnection();
			PreparedStatement psGet = c.prepareStatement(GET_PRODUCT_BY_ID);
			psGet.setString(1, productID);
			ResultSet rs = psGet.executeQuery(); // Execute a SELECT query
			if (rs.next()) {
				ProductModel product = new ProductModel();
				product.setProductID(rs.getString(COLUMN_SPID));
				product.setName(rs.getString(COLUMN_SPNAME));
				product.setType(rs.getString(COLUMN_SPTYPE));
				product.setPrice(rs.getDouble(COLUMN_SPPRICE));
				product.setImageUri(rs.getString(COLUMN_IMAGE));
				return product;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// chèn 1 sản phẩm bao gồm chi tiết sp
	public static int insertProduct(ProductModel product) {

		try {
			Connection c = MyDB.getInstance().getConnection();
			PreparedStatement psInsertProduct = c.prepareStatement(INSERT_PRODUCT);
			psInsertProduct.setString(1, product.getName());
			psInsertProduct.setString(2, product.getImageUri());
			psInsertProduct.setDouble(3, product.getPrice());
			psInsertProduct.setString(4, product.getType());

			int check = psInsertProduct.executeUpdate();
			Statement st = c.createStatement();
			st.execute(COMMIT);

			if (check > 0) {
				
				return 1;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public static int deleteProductByID(String id) {
		try {
			int check = 0;
			Connection c = MyDB.getInstance().getConnection();
			PreparedStatement psDelete = c.prepareStatement(DELETE_PRODUCT_BY_ID);
			psDelete.setString(1, id);
			check = psDelete.executeUpdate();
			if (check > 0)
				return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	// update 1 product;
	public static int updateProduct(ProductModel product) {
		try {
			int check = 0;
			Connection c = MyDB.getInstance().getConnection();
			PreparedStatement psUpdate = c.prepareStatement(UPDATE_PRODUCT);
			psUpdate.setString(1, product.getName());
			psUpdate.setString(2, product.getImageUri());
			psUpdate.setDouble(3, product.getPrice());
			psUpdate.setString(4, product.getType());
			psUpdate.setString(5, product.getProductID());

			check = psUpdate.executeUpdate();
			Statement st = c.createStatement();
			st.execute(COMMIT);

			if (check > 0) {
				
				return 1;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("UPDATE KHÔNG THÀNH CÔNG");
		return 0;
	}

}
