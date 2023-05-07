package controller;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import constant.Utils;
import dao.CustomerDAO;
import diaglog.AppDialog;
import diaglog.AppOptionPaneDialog;
import model.CustomerModel;
import view.customer.CustomerInfoForm;
import view.customer.CustomerPageView;

public class CustomerController {
	private CustomerPageView view;
	private JTable table;
	private CustomerInfoForm form;
	CustomerModel selectedCustomer;
	int selectedRow; 
	

	public CustomerController(CustomerPageView view) {
		super();
		this.view = view;
		this.table = view.scrollPane_customer.jTable;
		
		this.form = new CustomerInfoForm(null);
		
		//find customer 
		// Khởi tạo TableRowSorter
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);

		// Lắng nghe sự kiện khi người dùng nhập vào ô tìm kiếm
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
		
		//add a customer
		view.btn_addCustomer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				form = new CustomerInfoForm(null); 
				showPage(form);
				form.btnDelete.setVisible(false);
				java.util.Date date = new java.util.Date(); 
				form.lblNewLabel_registrationDate.setText(Utils.getStringDate(date));
				form.btnSave.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						CustomerModel customer;
						String name = String.valueOf(form.textField_name.getText());
						String phoneNumber = String.valueOf(form.textField_phoneNumber.getText());
						customer = new CustomerModel(null, name, phoneNumber, 0, null, null);
						int testAdd = addCustomerToDB(customer);
						if (testAdd == 0) {
							AppOptionPaneDialog dialog = new AppOptionPaneDialog("Thêm không thành công!", 1000);

						} else {
							customer = CustomerDAO.getMaxIDCustomer();
							AppOptionPaneDialog dialog = new AppOptionPaneDialog(
									"Thêm thành công khách hàng.\nMã khách hàng:" + customer.getCustomerID(), 5000);
							showPage(view);
							addCustomerToTable(customer);
						}
					}
				});
				
			}
		});

		//select a customer then delete or update 
		this.table.addMouseListener(new MouseListener() {

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
				CustomerModel selectedCustomer = getCustomerBySelected();
				form = new CustomerInfoForm(selectedCustomer);
				form.textField_name.setText(selectedCustomer.getName());
				form.textField_phoneNumber.setText(selectedCustomer.getPhoneNumber());
				form.lblNewLabel_customerID.setText(selectedCustomer.getCustomerID());
				form.lblNewLabel_level.setText(selectedCustomer.getLevel());
				form.lblNewLabel_point.setText(String.valueOf(selectedCustomer.getPoint()));
				form.lblNewLabel_registrationDate.setText(String.valueOf(selectedCustomer.getRegistration()));
				showPage(form);

				// delete a customer
				form.btnDelete.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("DELETE CUSTOMER");
						AppDialog confirmDelete = new AppDialog("Xác nhận xóa dữ liệu"); 
						confirmDelete.setVisible(true);
						confirmDelete.okButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// Xử lý khi người dùng xác nhận xóa
								//đóng dialog yêu cầu xác nhận xóa
								Window window = SwingUtilities.getWindowAncestor(confirmDelete);
						        window.dispose(); 
						        deleteCustomerByIDFromDB(form.model.getCustomerID());
								AppOptionPaneDialog dialog = new AppOptionPaneDialog("Xóa thành công",1000);
								showPage(view);
								deleteCustomerFromTable(); 
								
							}});
					
						
						
					}
				});

				// save a customer
				form.btnSave.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("Clicked SAVE BUTTON!");
						String name = String.valueOf(form.textField_name.getText());
						String phoneNumber = String.valueOf(form.textField_phoneNumber.getText());
						selectedCustomer.setName(name);
						selectedCustomer.setPhoneNumber(phoneNumber);
						int testAdd = updateCustomerFromDB(selectedCustomer); 
						
						if (testAdd == 0) {
							AppOptionPaneDialog dialog = new AppOptionPaneDialog("Sửa không thành công!", 1000);
						} else {
							updateCustomerFromTable(selectedCustomer);
							AppOptionPaneDialog dialog = new AppOptionPaneDialog(
									"Sửa thành công khách hàng\n.Mã khách hàng:" + selectedCustomer.getCustomerID(), 5000);
							showPage(view);
						}
					}
				});

			}
		});
	}

	public void showPage(JPanel jpanel) {
		AppController.view.root.removeAll();
		AppController.view.root.setLayout(new GridLayout());
		AppController.view.root.add(jpanel);
		AppController.view.root.validate();
		AppController.view.root.repaint();
	}

	public void displayCustomerListToTable() {

		DefaultTableModel dtm = (DefaultTableModel) view.scrollPane_customer.jTable.getModel();
		List<CustomerModel> customerList = CustomerModel.getAllCustomer();
		dtm.setNumRows(0);
		if (customerList.isEmpty()) {
			System.out.println("Khong co khach hang thanh vien.");
		} else {
			for (int i = 0; i < customerList.size(); i++) {
				CustomerModel customer = customerList.get(i);
				dtm.addRow(customer.toObject());
			}
		}
		view.scrollPane_customer.jTable.setModel(dtm);
	}

	public void addCustomerToTable(CustomerModel model) {
		DefaultTableModel dtm = (DefaultTableModel) view.scrollPane_customer.jTable.getModel();
		;
		dtm.addRow(model.toObject());
	}

	public int addCustomerToDB(CustomerModel model) {
		return CustomerDAO.insertCustomer(model);
	}

	public CustomerModel getCustomerBySelected() {
		selectedRow = table.getRowSorter().convertRowIndexToModel(table.getSelectedRow());
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		String id = String.valueOf(tableModel.getValueAt(selectedRow, 0));
		return CustomerDAO.getCustomerByID(id);
	}

	public int deleteCustomerByIDFromDB(String id) {
		return CustomerDAO.deleteCustomerByID(id);
	}

	public void deleteCustomerFromTable() {
		DefaultTableModel dtm = (DefaultTableModel) view.scrollPane_customer.jTable.getModel();
		dtm.removeRow(selectedRow);
	}
	
	public int updateCustomerFromDB(CustomerModel customer) {
		return CustomerDAO.updateCustomer(customer.getCustomerID(), customer.getName(), customer.getPhoneNumber()); 
	}
	public void updateCustomerFromTable(CustomerModel customer) {
		DefaultTableModel dtm = (DefaultTableModel) view.scrollPane_customer.jTable.getModel();
		dtm.setValueAt(customer.getName(), selectedRow,1);
		dtm.setValueAt(customer.getPhoneNumber(), selectedRow, 2);
	}
	
	public int findRowIndexByColumnValue(JTable table, int column, Object value) {
	    for (int i = 0; i < table.getRowCount(); i++) {
	        if (table.getValueAt(i, column).equals(value)) {
	            return i;
	        }
	    }
	    return -1; // return -1 if the value is not found in any row of the column
	}
	
}
