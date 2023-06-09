package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.EmployeeDAO;
import dao.MyDB;
import diaglog.AppOptionPaneDialog;
import model.EmployeeModel;
import view.AppView;
import view.LoginView;

public class LoginController {
	LoginView view;
	public static EmployeeModel user; 
	
	public static String GET_EMP_INFO_FROM_ACCOUNT = "SELECT * FROM TAIKHOAN WHERE MANV = ? "; 
	public static String GET_EM_INFO_FROM_EMPLOYEE = "SELECT * FROM NHANVIEN WHERE MANV = ? "; 
	public static String COLUMN_EMP_ID = "MANV";
	public static String COLUMN_PASSWORD = "MATKHAU"; 

	public LoginController(LoginView view) {
		super();
		this.view = view;
		
		view.jButton_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = view.textField_username.getText();
				String password = view.textField_password.getText();
				user = getUser(id, password);
				
				if (user!=null) {
					
					AppView frameApp = new AppView();
			        frameApp.setSize(1040, 740);
			        frameApp.setLocationRelativeTo(null);
			        frameApp.setVisible(true); 
			        view.setVisible(false); 
				}
				else {
					AppOptionPaneDialog dialog = new AppOptionPaneDialog("Tài khoản hoặc mật khẩu không đúng.\nVui lòng nhập lại!", 2000); 
					dialog.show(); 
				}
			}
		});
		
	}
	
	public EmployeeModel getUser(String id, String password) {

		try {
			Connection c = MyDB.getInstance().getConnection();
			PreparedStatement psGetAccount = c.prepareStatement(GET_EMP_INFO_FROM_ACCOUNT);	
			psGetAccount.setString(1, id);
			
			PreparedStatement psGetEmployee = c.prepareStatement(GET_EM_INFO_FROM_EMPLOYEE);
			psGetEmployee.setString(1, id);
			
			
			ResultSet rs = psGetAccount.executeQuery();
			if (rs.next()) {
				System.out.println("USER ID: "+rs.getString(COLUMN_EMP_ID));
				String pass = rs.getString(COLUMN_PASSWORD); 
				if (pass.equals(password)) {
					ResultSet rsEmp = psGetEmployee.executeQuery();
					if (rsEmp.next()) {
						EmployeeModel emp = EmployeeDAO.getEmployeeByEmpID(id);
						if (emp.getPosition().equalsIgnoreCase("QUẢN LÝ")) MyDB.getInstance().phanquyen(MyDB.USER_NAME_MANAGER, MyDB.PASSWORD_MANAGER);
						if (emp.getPosition().equalsIgnoreCase("THU NGÂN")) MyDB.getInstance().phanquyen(MyDB.USER_NAME_CASHIER, MyDB.PASSWORD_CASHIER);
						return emp; 
					}
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated castch block
			e.printStackTrace();
		}
		
		return null; 
		
	}
}
