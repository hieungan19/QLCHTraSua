package controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import constant.AppValues;
import dao.EmployeeDAO;
import dao.MyDB;
import diaglog.AppDialog;
import diaglog.AppOptionPaneDialog;
import model.AttendanceTrackingModel;
import model.EmployeeModel;
import view.employee.AttendanceTrackingDialog;
import view.employee.CalculateSalaryDialog;
import view.employee.EmployeeInfoFormPanel;
import view.employee.EmployeePageView;

public class EmployeeController {
	EmployeePageView view;
	JTable table;
	List<EmployeeModel> empList;
	EmployeeInfoFormPanel form;
	int selectedRow;
	AttendanceTrackingDialog attDialog;
	EmployeeModel currentEmp;
	CalculateSalaryDialog salaryDialog;

	public EmployeeController(EmployeePageView view) {
		this.view = view;
		table = view.scrollPane_employee.jTable;

		getAllEmployeeAndDisplayToTable();

		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);

		// tinh luong
		salaryDialog = new CalculateSalaryDialog();
		salaryDialog.btn_cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				salaryDialog.dispose();

			}
		});
		salaryDialog.btn_ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getTotalSalary();

			}

		});

		// cham cong
		attDialog = new AttendanceTrackingDialog();

		attDialog.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int check = insertAttendanceTracking();
				if (check == 1) {
					Window window = SwingUtilities.getWindowAncestor(attDialog);
					window.dispose();
					AppOptionPaneDialog dialog = new AppOptionPaneDialog("Chấm công thành công", 1000);
				}
			}
		});

		view.btn_addEmployee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				form = new EmployeeInfoFormPanel();
				AppController.showPage(form);

				// add listener to combobox để hiện bảng tạo tài khoản
				form.comboBox.addItemListener(new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.SELECTED) {
							String selected = (String) form.comboBox.getSelectedItem();
							if (selected.equals("QUẢN LÝ") || selected.equals("THU NGÂN"))
								form.panel_account.setVisible(true);
							else
								form.panel_account.setVisible(false);
						}
					}
				});

				// lưu tài khoản
				form.btn_save.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int check = insertEmployeeAndDisplayToTable();
						if (check==1) {
							AppOptionPaneDialog dialog = new AppOptionPaneDialog(
									"Thêm thành công nhân viên", 1000);
							AppController.showPage(view);
						}
					}
				});
				
				form.btn_delete.setVisible(false);
				form.btn_attendance.setVisible(false);
				form.btn_getSalary.setVisible(false);
			}
		});
		view.searchBar.searchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				search(view.searchBar.searchField.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				search(view.searchBar.searchField.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				search(view.searchBar.searchField.getText());
			}

			private void search(String text) {
				if (text.trim().length() == 0) {
					sorter.setRowFilter(null);
				} else {
					// Tìm kiếm theo giá trị nhập vào
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
		});

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				form = new EmployeeInfoFormPanel();
				getSelectedEmployeeAndDisplayToForm();
				
				form.panel_account.setVisible(false);
				
				//CHANGE POSITION
				form.comboBox.addItemListener(new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.SELECTED) {
							String selected = (String) form.comboBox.getSelectedItem();
							if ((selected.equals("QUẢN LÝ") || selected.equals("THU NGÂN")) && (!currentEmp.getPosition().equals("QUẢN LÝ") 
									&& !currentEmp.getPosition().equals("THU NGÂN")))
								form.panel_account.setVisible(true);
							else
								form.panel_account.setVisible(false);
						}
					}
				});
				
				// delete employee
				form.btn_delete.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						AppDialog confirmDelete = new AppDialog("Xác nhận xóa dữ liệu");
						confirmDelete.setVisible(true);
						confirmDelete.okButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// Xử lý khi người dùng xác nhận xóa
								// đóng dialog yêu cầu xác nhận xóa
								Window window = SwingUtilities.getWindowAncestor(confirmDelete);
								window.dispose();
								deleteEmployeeFromDatabaseAndTable();
								AppOptionPaneDialog dialog = new AppOptionPaneDialog("Xóa thành công", 1000);
								AppController.showPage(view);

							}
						});
						confirmDelete.cancelButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								confirmDelete.dispose();
							}
						});

					}
				});

				// update employee
				form.btn_save.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int check = updateEmployeeAndDisplayOnTable();
						if (check == 1) {
							AppOptionPaneDialog dialog = new AppOptionPaneDialog("Lưu thành công!", 2000);
							AppController.showPage(view); 
						}
					}
				});

				// chấm công

				form.btn_attendance.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						// set tiền phạt = 0;
						attDialog.spinner_penalty.setValue(0);
						attDialog.setVisible(true);
					}
				});

				// tinh luong
				form.btn_getSalary.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						salaryDialog.setVisible(true);
					}
				});

			}
		});

	}

	public void getAllEmployeeAndDisplayToTable() {
		empList = EmployeeDAO.getAllEmployee();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setNumRows(0);
		if (empList.isEmpty()) {
			System.out.println("Khong co nhan vien.");
		} else {
			for (int i = 0; i < empList.size(); i++) {
				EmployeeModel emp = empList.get(i);
				dtm.addRow(emp.toObject());
			}
		}
		table.setModel(dtm);
	}

	public EmployeeModel getDataFromForm() {
		String empID = form.lbl_empID.getText();
		String gender = form.femaleRadioButton.isSelected()?"NỮ":"NAM"; 
		String name = form.textField_name.getText();
		String id = form.textField_ID.getText();
		String address = form.textField_address.getText();
		String phoneNumber = form.textField_phone.getText();
		double salary = form.spinner_salary.getNumber();
		Date birthday = form.datePicker_birth.getDate();
		Date startday = form.datePicker_start.getDate();
		String position = AppValues.positionList[form.comboBox.getSelectedIndex()];
		System.out.println("EMPLOYEE POSITION: " + position);
		

		EmployeeModel emp = new EmployeeModel(name, id, phoneNumber, address, birthday, gender, salary, startday,
				position);
		if (!empID.isEmpty())
			emp.setEmployeeID(empID);
		return emp;

	}

	public String getPasswordFromForm() {
		if (form.textField_confirm.getText().equals(form.textField_password.getText()) && form.textField_password.getText().length()>=6) {
			return form.textField_confirm.getText();
		} else

		{
			AppOptionPaneDialog dialog = new AppOptionPaneDialog("Vui lòng nhập lại mật khẩu và xác nhận", 2000);
			dialog.show();
			return null; 
		}
	}

	public void displayDataToForm(EmployeeModel emp) {
		form.lbl_empID.setText(emp.getEmployeeID());
		form.textField_name.setText(emp.getName());
		form.textField_ID.setText(emp.getId());
		form.textField_address.setText(emp.getAddress());
		form.spinner_salary.setValue(emp.getSalary());
		form.datePicker_birth.setDate(emp.getBirthday());
		form.datePicker_start.setDate(emp.getStartDate());
		form.comboBox.setSelectedItem(emp.getPosition());
		if (emp.getGender().equals(form.maleRadioButton.getText()))
			form.maleRadioButton.setSelected(true);
		else
			form.femaleRadioButton.setSelected(true);
		form.textField_phone.setText(emp.getPhoneNumber());

	}

	public void getSelectedEmployeeAndDisplayToForm() {
		selectedRow = table.getRowSorter().convertRowIndexToModel(table.getSelectedRow());
		if (selectedRow == -1)
			return;
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		String id = String.valueOf(tableModel.getValueAt(selectedRow, 0));
		currentEmp = EmployeeDAO.getEmployeeByEmpID(id);
		displayDataToForm(currentEmp);
		AppController.showPage(form);
	}

	public int insertEmployeeAndDisplayToTable() {
		EmployeeModel emp = getDataFromForm();
		String password = getPasswordFromForm();
		if (password == null && (emp.getPosition() == "QUẢN LÝ" || emp.getPosition() == "THU NGÂN"))
			return 0;
		int checkInsert = EmployeeDAO.insertEmployee(emp, password);

		if (checkInsert == 1) {
			emp = EmployeeDAO.getMaxIDEmployeeModel();
			int insertAccount = EmployeeDAO.insertAccount(emp, password);
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.addRow(emp.toObject());
		}
		return checkInsert;
	}

	public int deleteEmployeeFromDatabaseAndTable() {
		String id = form.lbl_empID.getText();
		int checkDelete = EmployeeDAO.deleteEmployee(id);
		if (checkDelete == 1) {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.removeRow(selectedRow);
		}
		return checkDelete;
	}

	public int updateEmployeeAndDisplayOnTable() {

		EmployeeModel emp = getDataFromForm();
		String pass = form.textField_password.getText(); 
		int checkUpdate = EmployeeDAO.updateEmployee(emp,pass);
		if (checkUpdate == 1) {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();

			dtm.setValueAt(emp.getName(), selectedRow, 1);
			dtm.setValueAt(emp.getPhoneNumber(), selectedRow, 2);
			dtm.setValueAt(emp.getId(), selectedRow, 3);
			dtm.setValueAt(emp.getAddress(), selectedRow, 4);
			dtm.setValueAt(emp.getBirthday(), selectedRow, 5);
			dtm.setValueAt(emp.getGender(), selectedRow, 6);
			dtm.setValueAt(emp.getSalary(), selectedRow, 7);
			dtm.setValueAt(emp.getStartDate(), selectedRow, 8);
			dtm.setValueAt(emp.getPosition(), selectedRow, 9);
		}
		return checkUpdate;
	}

	// lay du lieu tu dialog để chấm công
	public AttendanceTrackingModel getDataFromAttendanceTrackingDialog() {

		Object penalty = attDialog.spinner_penalty.getValue();
		Timestamp start = Timestamp.valueOf(attDialog.startTime.getTimeString());
		System.out.println("START TIME: " + start);
		Timestamp end = Timestamp.valueOf(attDialog.endTime.getTimeString());
		System.out.println("END TIME: " + end);
		String empID = currentEmp.getEmployeeID();
		double salary = ((end.getTime() - start.getTime()) * currentEmp.getSalary()) / 3600000;
		AttendanceTrackingModel a = new AttendanceTrackingModel(empID, start, end, Double.valueOf(penalty.toString()),
				salary);
		return a;
	}

	// cham cong
	public int insertAttendanceTracking() {
		AttendanceTrackingModel a = getDataFromAttendanceTrackingDialog();
		int check = EmployeeDAO.attendanceTracking(a);
		return check;
	}

	public double getTotalSalary() {
		// chọn ngày bắt đầu tính lương
		Date start = salaryDialog.startDate.getDate();
		Date end = salaryDialog.endDate.getDate();
		double total = 0;
		double hours = 0;
		double pen = 0;
		int result = 0; 
		Connection con;
		try {
		    con = MyDB.getInstance().getConnection();
		    CallableStatement cst = con.prepareCall("{ ? = call ADMINDOAN.F_TINH_LUONGNV(?,?, ?,?) }");
		    
		    System.out.println("ID: "+currentEmp.getEmployeeID());
		    System.out.println("Start date : "+ start);
		    System.out.println("Start date : "+ end);
		    
		    
		    cst.registerOutParameter(1, Types.INTEGER);
		    cst.setString(2, currentEmp.getId());

		    java.sql.Date sqlStart = null;
		    if (start != null) {
		        sqlStart = new java.sql.Date(start.getTime());
		    }
		    cst.setDate(3, sqlStart);

		    java.sql.Date sqlEnd = null;
		    if (end != null) {
		        sqlEnd = new java.sql.Date(end.getTime());
		    }
		    cst.setDate(4, sqlEnd);

		    cst.setInt(5, 0);

		    // Execute the function call
		    cst.execute();
		    // Get the result from the CallableStatement
		    result = cst.getInt(1);
		} catch (SQLException e) {
			System.out.println(e);
		    e.printStackTrace();
		}

		List<AttendanceTrackingModel> list = EmployeeDAO.getAttendanceByEmpID(currentEmp.getEmployeeID(), start, end);
		for (AttendanceTrackingModel a : list) {
			total += a.getSalary() - a.getPenalty();
			hours += (a.getEnd().getTime() - a.getStart().getTime()) / 3600000;
			pen += a.getPenalty();

		}
		total+= salaryDialog.spinner_bonus.getNumber(); 

		salaryDialog.lbl_hours.setText(String.valueOf(hours));
		salaryDialog.lbl_penalty.setText(String.valueOf(pen));
		salaryDialog.lbl_baseSalary.setText(String.valueOf(currentEmp.getSalary()));
		salaryDialog.lbl_total.setText(String.valueOf(total));

		return total;

	}

}
