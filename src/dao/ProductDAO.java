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
	// SANPHAM
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

	public static final String GET_ALL_PRODUCT = "SELECT * FROM SANPHAM";
	public static final String GET_ALL_PRODUCT_DETAILS = "SELECT * FROM CHITIETSP";
	public static final String GET_PRODUCT_DETAILS_BY_ID = "SELECT * FROM CHITIETSP WHERE MASP = ?";
	private static final String GET_MAXID_INSERTED_PRODUCT = "SELECT * FROM SANPHAM WHERE ROWID = (SELECT MAX(ROWID) FROM SANPHAM)";
	private static final String GET_PRODUCT_BY_ID = "SELECT * FROM SANPHAM WHERE MASP = ?";
	private static final String INSERT_PRODUCT = "INSERT INTO SANPHAM (TENSP, HINHANH, GIA, LOAISP) VALUES (?,?,?,?)";
	private static final String INSERT_PRODUCT_DETAIL = "INSERT INTO CHITIETSP (MASP, MANL, SOLUONG) VALUES (?,?,?)";
	private static final String DELETE_PRODUCT_BY_ID = "DELETE FROM SANPHAM WHERE MASP = ?";
	private static final String UPDATE_PRODUCT = "UPDATE SANPHAM SET TENSP = ?, HINHANH = ?,GIA = ?, LOAISP = ? WHERE MASP = ?";
	private static final String DELETE_ALL_PRODUCT_DETAILS_BY_ID = "DELETE FROM CHITIETSP WHERE MASP = ?";
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
				ProductModel product = new ProductModel(productID, name, price, loai, imageUri, null);
				result.add(product);
			}
			System.out.println(test);
			return result;
		} catch (SQLException e) {
			System.out.println("Error in getProductListWithoutIngredients() " + e.getMessage());

		}

		return result;

	}

	// lấy danh sách chi tiết nguyên liệu của 1 sản phẩm

	public static List<ProductDetail> getProductDetailsByProductID(String iID) {
		List<ProductDetail> result = new ArrayList<ProductDetail>();
		Connection con;
		int test = 0;
		try {
			con = MyDB.getInstance().getConnection();
			PreparedStatement psGet = con.prepareStatement(GET_PRODUCT_DETAILS_BY_ID);
			psGet.setString(1, iID);
			ResultSet rs = psGet.executeQuery();
			while (rs.next()) {
				++test;
				String productID = rs.getString(COLUMN_SPID);
				String ingredientID = rs.getNString(COLUMN_NLID);
				double iAmount = rs.getDouble(COLUMN_CTAMOUNT);
				String iName = IngredientDAO.getIngredientByID(ingredientID).getName(); // ingredient amount
				ProductDetail pDetail = new ProductDetail(productID, ingredientID, iName, iAmount);
				result.add(pDetail);
			}
			System.out.println(test);
			return result;
		} catch (SQLException e) {
			System.out.println("Error in getProductDetailsByProductID() " + e.getMessage());

		}

		return result;

	}

	// get product list có đầy đủ chi tiết
	public static List<ProductModel> getProductList() {
		List<ProductModel> productList = ProductDAO.getAllProducts();
		for (ProductModel product : productList) {
			List<ProductDetail> detailsList = ProductDAO.getProductDetailsByProductID(product.getProductID());
			product.setIngredientList(detailsList);

		}
		return productList;

	}

	public static ProductModel getMaxIDProduct() {
		try {
			Connection c = MyDB.getInstance().getConnection();
			Statement state = c.createStatement();
			ResultSet rs = state.executeQuery(GET_MAXID_INSERTED_PRODUCT);
			if (rs.next()) {
				System.out.println("VUA INSERT VAO: " + rs.getString(COLUMN_SPNAME));
				ProductModel model = new ProductModel(rs.getString(COLUMN_SPID), rs.getString(COLUMN_SPNAME),
						rs.getDouble(COLUMN_SPPRICE), rs.getString(COLUMN_SPTYPE), rs.getString(COLUMN_IMAGE), null);
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
				product.setIngredientList(getProductDetailsByProductID(productID));
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
				ProductModel insertedProduct = getMaxIDProduct();
				List<ProductDetail> productDetailList = product.getIngredientList();
				for (int i = 0; i < product.getIngredientList().size(); ++i) {
					PreparedStatement psInsertProductDetail = c.prepareStatement(INSERT_PRODUCT_DETAIL);
					psInsertProductDetail.setString(1, insertedProduct.getProductID());
					psInsertProductDetail.setString(2, productDetailList.get(i).getIngredientID());
					psInsertProductDetail.setDouble(3, productDetailList.get(i).getiAmount());

					psInsertProductDetail.executeUpdate();
				}
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
				PreparedStatement psDeleteAllProductDetail = c.prepareStatement(DELETE_ALL_PRODUCT_DETAILS_BY_ID);
				psDeleteAllProductDetail.setString(1, product.getProductID());
				psDeleteAllProductDetail.executeUpdate();
				List<ProductDetail> productDetailList = product.getIngredientList();
				for (int i = 0; i < productDetailList.size(); ++i) {
					if (productDetailList.get(i).getiAmount() > 0) {
						PreparedStatement psInsertProductDetail = c.prepareStatement(INSERT_PRODUCT_DETAIL);
						psInsertProductDetail.setString(1, product.getProductID());
						psInsertProductDetail.setString(2, productDetailList.get(i).getIngredientID());
						psInsertProductDetail.setDouble(3, productDetailList.get(i).getiAmount());
						psInsertProductDetail.executeUpdate();

					}
				}
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
