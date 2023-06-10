package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.AttendanceTrackingModel;
import model.DiscountModel;
import model.EmployeeModel;

public class EmployeeDAO {
	public static final String COLUMN_ID_EMPLOYEE = "MANV";
	public static final String COLUMN_ID = "CCCD";
	public static final String COLUMN_PHONE_NUMBER = "SDT";
	public static final String COLUMN_ADDRESS = "DIACHI";
	public static final String COLUMN_GENDER = "GIOITINH";
	public static final String COLUMN_SALARY = "LUONGCB";
	public static final String COLUMN_START_DATE = "NGVAOLAM";
	public static final String COLUMN_DOB = "NGSINH";
	public static final String COLUMN_POSITION = "CHUCVU";
	public static final String COLUMN_NAME = "HOTEN";
	public static final String COLUMN_PASS = "MATKHAU";


	// ADMINDOAN.CHAMCONG
	public static final String COLUMN_AID = "MACC";
	public static final String COLUMN_START_TIME = "GIOBD";
	public static final String COLUMN_END_TIME = "GIOKT";
	public static final String COLUMN_PENALTY = "TIENTRU";
	public static final String COLUMN_SALARY_CC = "LUONG"; 
	
	public static final String GET_ALL_EMPLOYEE = "SELECT * FROM ADMINDOAN.NHANVIEN";
	public static final String GET_EMPLOYEE_BY_EMP_ID = "SELECT * FROM ADMINDOAN.NHANVIEN WHERE MANV = ?";
	public static final String GET_MAX_ID_EMPLOYEE = "SELECT * FROM ADMINDOAN.NHANVIEN WHERE ROWID = (SELECT MAX(ROWID) FROM ADMINDOAN.NHANVIEN)";
	public static final String INSERT_EMPLOYEE = "INSERT INTO ADMINDOAN.NHANVIEN (HOTEN, CCCD, SDT, DIACHI, NGSINH,GIOITINH,LUONGCB,NGVAOLAM,CHUCVU) VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String INSERT_ACCOUNT = "INSERT INTO ADMINDOAN.TAIKHOAN (MANV,MATKHAU) VALUES (?,?)";
	public static final String DELETE_EMPLOYEE_BY_EMP_ID = "DELETE FROM ADMINDOAN.NHANVIEN WHERE MANV = ?";
	public static final String DELETE_ACCOUNT_BY_EMP_ID = "DELETE FROM ADMINDOAN.TAIKHOAN WHERE MANV = ?";
	public static final String UPDATE_EMPLOYEE = "UPDATE ADMINDOAN.NHANVIEN SET HOTEN = ?, CCCD = ?, SDT= ?, DIACHI= ?, NGSINH=?,GIOITINH=?,LUONGCB=?,NGVAOLAM=?,CHUCVU=? WHERE MANV = ?";
	public static final String INSERT_ATTENDANCE = "INSERT INTO ADMINDOAN.CHAMCONG (MANV, GIOBD, GIOKT, TIENTRU,LUONG) VALUES(?,?,?,?,?)";
	public static final String GET_ATTENDANCE_BY_EMP_ID = "SELECT * FROM ADMINDOAN.CHAMCONG WHERE MANV = ? AND TRUNC(GIOBD) >=? AND TRUNC(GIOKT) <= ?";

	public static List<EmployeeModel> getAllEmployee() {
		List<EmployeeModel> result = new ArrayList<>();
		int test = 0;
		try {
			Connection con = MyDB.getInstance().getConnection();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(GET_ALL_EMPLOYEE);
			while (rs.next()) {
				++test;
				EmployeeModel employee = getDataFromResultSet(rs);
				result.add(employee);

			}
			System.out.println("So luong nhân viên: " + test);
			return result;
		} catch (SQLException e) {
			System.out.println("Error in EmployeeDAO at get all employee: " + e.getMessage());

		}

		return result;
	}

	public static EmployeeModel getDataFromResultSet(ResultSet rs) {

		try {
			String employeeID = rs.getString(COLUMN_ID_EMPLOYEE);
			String name = rs.getNString(COLUMN_NAME);
			String id = rs.getString(COLUMN_ID);
			String phoneNumber = rs.getString(COLUMN_PHONE_NUMBER);
			String address = rs.getNString(COLUMN_ADDRESS);
			Date birthday = rs.getDate(COLUMN_DOB);
			String gender = rs.getNString(COLUMN_GENDER);
			double salary = rs.getDouble(COLUMN_SALARY);
			Date startDate = rs.getDate(COLUMN_START_DATE);
			String position = rs.getString(COLUMN_POSITION);

			EmployeeModel employee = new EmployeeModel(employeeID, name, id, phoneNumber, address, birthday, gender,
					salary, startDate, position);
			return employee;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static EmployeeModel getEmployeeByEmpID(String id) {
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psGetByID = con.prepareStatement(GET_EMPLOYEE_BY_EMP_ID);
			psGetByID.setString(1, id);
			ResultSet rs = psGetByID.executeQuery();
			if (rs.next()) {
				EmployeeModel emp = getDataFromResultSet(rs);
				return emp;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static EmployeeModel getMaxIDEmployeeModel() {
		try {
			Connection con = MyDB.getInstance().getConnection();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(GET_MAX_ID_EMPLOYEE);
			if (rs.next()) {
				EmployeeModel emp = getDataFromResultSet(rs);
				System.out.println("getMaxIDEmployeeModel: " + emp.getEmployeeID());
				return emp;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static int insertEmployee(EmployeeModel emp, String password) {
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psInsert = con.prepareStatement(INSERT_EMPLOYEE);
			setPrepareStatement(emp, psInsert);
			int check = psInsert.executeUpdate();
			if (check > 0)
				return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public static void setPrepareStatement(EmployeeModel emp, PreparedStatement ps) {
		try {
			ps.setNString(1, emp.getName());
			ps.setString(2, emp.getId());
			ps.setString(3, emp.getPhoneNumber());
			ps.setNString(4, emp.getAddress());
			java.sql.Date sqlBirthDate = null;
			if (emp.getBirthday() != null) {
				sqlBirthDate = new java.sql.Date(emp.getBirthday().getTime());
			}

			ps.setDate(5, sqlBirthDate);
			ps.setNString(6, emp.getGender());
			ps.setDouble(7, emp.getSalary());
			java.sql.Date sqlStartDate = null;
			if (emp.getBirthday() != null) {
				sqlBirthDate = new java.sql.Date(emp.getBirthday().getTime());
			}
			if (emp.getStartDate() != null) {
				sqlStartDate = new java.sql.Date(emp.getStartDate().getTime());
			}
			ps.setDate(8, sqlStartDate);
			ps.setString(9, emp.getPosition());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int insertAccount(EmployeeModel emp, String password) {
		if (emp.getPosition().equalsIgnoreCase("QUẢN LÝ") || emp.getPosition().equalsIgnoreCase("THU NGÂN")) {
			try {
				Connection con = MyDB.getInstance().getConnection();
				PreparedStatement psInsertAcc = con.prepareStatement(INSERT_ACCOUNT);
				psInsertAcc.setString(1, emp.getEmployeeID());
				psInsertAcc.setString(2, password);

				int check = psInsertAcc.executeUpdate();
				if (check > 0)
					return 1;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static int deleteEmployee(String id) {
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psDeleteEmp = con.prepareStatement(DELETE_EMPLOYEE_BY_EMP_ID);
			psDeleteEmp.setString(1, id);
			int check = psDeleteEmp.executeUpdate();
			if (check > 0)
				return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public static int updateEmployee(EmployeeModel emp, String password) {
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psUpdate = con.prepareStatement(UPDATE_EMPLOYEE);
			setPrepareStatement(emp, psUpdate);
			psUpdate.setString(10, emp.getEmployeeID());
			if (!password.isEmpty()) insertAccount(emp, password); 
			int check = psUpdate.executeUpdate();

			if (check > 0)
				return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static int attendanceTracking(AttendanceTrackingModel a) {
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psInsert = con.prepareStatement(INSERT_ATTENDANCE);
			psInsert.setString(1, a.getEmpID());
			psInsert.setTimestamp(2, a.getStart());
			psInsert.setTimestamp(3, a.getEnd());
			psInsert.setDouble(4, a.getPenalty());
			psInsert.setDouble(5, a.getSalary());

			int check = psInsert.executeUpdate();
			if (check > 0)
				return 1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static List<AttendanceTrackingModel> getAttendanceByEmpID(String id, java.util.Date startDate, java.util.Date endDate) {
		List<AttendanceTrackingModel> list = new ArrayList<>();
		try {
			Connection con = MyDB.getInstance().getConnection();
			PreparedStatement psGet = con.prepareStatement(GET_ATTENDANCE_BY_EMP_ID);
			psGet.setString(1, id);
			psGet.setDate(2,new java.sql.Date(startDate.getTime())) ;
			psGet.setDate(3, new java.sql.Date(endDate.getTime()));
			ResultSet rs = psGet.executeQuery();
			while (rs.next()) {
				String attID = rs.getString(COLUMN_AID);
				String empID = id;
				Timestamp start = rs.getTimestamp(COLUMN_START_TIME);
				Timestamp end = rs.getTimestamp(COLUMN_END_TIME);
				double penalty = rs.getDouble(COLUMN_PENALTY);
				double salary  = rs.getDouble(COLUMN_SALARY_CC); 
				
				AttendanceTrackingModel a = new AttendanceTrackingModel(attID, empID, start, end, penalty, salary);
				list.add(a);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

}
