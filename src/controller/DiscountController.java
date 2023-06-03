package controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import dao.DiscountDAO;
import dao.ProductDAO;
import diaglog.AppDialog;
import diaglog.AppOptionPaneDialog;
import model.DiscountModel;
import model.ProductModel;
import view.discount.DiscountInfoForm;
import view.discount.DiscountPageView;


public class DiscountController {
	DiscountPageView view;
	JTable table;
	DiscountInfoForm form; 
	int selectedRow; 

	public DiscountController(DiscountPageView view) {
		super();
		this.view = view;
		this.table = view.scrollPane_discount.jTable;

		displayDiscountListIntoTable();
		if (!LoginController.user.getPosition().equals("QUẢN LÝ")) view.btn_addDiscount.setVisible(false); 
		
		// khởi tạo cho tìm kiếm
		// search bar
				TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
				table.setRowSorter(sorter);
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
		
		//display  a discount to update and delete
		
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
				form = new DiscountInfoForm(); 
				getDiscountBySelectedAndDisplayIntoForm();
				
				//xóa discount
				form.btn_deleteDiscount.addActionListener(new ActionListener() {
					
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
								deleteDiscountAndUpdateTableView(); 
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
				
				//lưu discount đã sửa
				
				form.btn_saveDiscount.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int check = updateDiscountFromDatabaseAndDisplayIntoTable(); 
						if (check == 0) {
							AppOptionPaneDialog failDialog = new AppOptionPaneDialog("Lưu không thành công!", 5000);

						} else {
							AppOptionPaneDialog failDialog = new AppOptionPaneDialog("Lưu thành công!", 5000);
							AppController.showPage(view);

						}
					}
				});
			}
		});
		
		// add a discount
		
		view.btn_addDiscount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				form = new DiscountInfoForm();
				
				
				AppController.showPage(form);
				
				//save discount
				form.btn_saveDiscount.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						DiscountModel discount = getDiscountFromForm(); 
						int check = insertDiscountAndDisplayToTable(discount); 
						if (check ==1) {
							AppOptionPaneDialog dialog = new AppOptionPaneDialog(
									"Thêm thành công",5000);
							AppController.showPage(view); 
						}
						else {
							AppOptionPaneDialog dialog = new AppOptionPaneDialog(
									"Thêm không thành công",5000);
						}
					}
				});
				
				//hide delete btn
				form.btn_deleteDiscount.setVisible(false);
				
				
				
			}
		});

	}

	public void displayDiscountListIntoTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		List<DiscountModel> discountList = DiscountDAO.getDiscountList();
		dtm.setNumRows(0);
		if (discountList.isEmpty()) {
			System.out.println("Khong co khuyen mai.");
		} else {
			for (int i = 0; i < discountList.size(); i++) {
				DiscountModel discount = discountList.get(i);
				dtm.addRow(discount.toObject());
			}
		}
		table.setModel(dtm);
	}

	public int insertDiscountAndDisplayToTable(DiscountModel discount) {

		int check = DiscountDAO.insertDiscount(discount);
		DiscountModel insertedDiscount = DiscountDAO.getMaxIDDiscount();
		if (check == 1) {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.addRow(insertedDiscount.toObject());
		}
		return check;
	}
	
	
	// lấy dữ liệu product bằng cách chọn 1 dòng
	public ProductModel getProductModelBySelectingRow() {
		selectedRow = table.getRowSorter().convertRowIndexToModel(table.getSelectedRow());
		if (selectedRow == -1)
			return null;
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		String id = String.valueOf(tableModel.getValueAt(selectedRow, 0));
		return ProductDAO.getProductByID(id);
	}
	public void getDiscountBySelectedAndDisplayIntoForm() {
		selectedRow = table.getRowSorter().convertRowIndexToModel(table.getSelectedRow()); 
		if (selectedRow == -1) return; 
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		String id = String.valueOf(tableModel.getValueAt(selectedRow, 0));
		DiscountModel discount = DiscountDAO.getDiscountByID(id);
		if (discount!=null) {
			form.textField_name.setText(discount.getName());
			form.lbl_discountID.setText(discount.getDiscountID());
			form.spinner_percent.setValue(discount.getPercent());
			form.spinner_totalBill.setValue(discount.getTotalBill());
			form.startDay.setDate(discount.getStartDate());
			form.endDay.setDate(discount.getEndDate());
			form.comboBox.setSelectedItem(discount.getCustomerType());
		}
		if (!LoginController.user.getPosition().equals("QUẢN LÝ")) {form.btn_deleteDiscount.setVisible(false); form.btn_saveDiscount.setVisible(false);}
		AppController.showPage(form);
	}

	public DiscountModel getDiscountFromForm() {
		DiscountModel discount; 
		String name = form.textField_name.getText();
		double totalBill = form.spinner_totalBill.getNumber();
		double percentage = form.spinner_percent.getNumber(); 
		Date start = (Date) form.startDay.getDate();
		Date end = (Date) form.endDay.getDate(); 
		String customer = (String) form.comboBox.getSelectedItem(); 
		String discountID = form.lbl_discountID.getText(); 
		if (discountID.isEmpty()) discount = new DiscountModel(name, totalBill, percentage, start, end, customer); 
		else discount = new DiscountModel(discountID, name, totalBill, percentage, start, end, customer); 
		return discount; 
	}
	
	public int updateDiscountFromDatabaseAndDisplayIntoTable() {
		DiscountModel discount = getDiscountFromForm();
		int check = DiscountDAO.updateDiscount(discount);
		//nếu update được thì set vào table
		if (check== 1) {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.setValueAt(discount.getName(), selectedRow, 1);
			dtm.setValueAt(discount.getTotalBill(), selectedRow, 2);
			dtm.setValueAt(discount.getPercent(), selectedRow, 3);
			dtm.setValueAt(discount.getStartDate(), selectedRow, 4);
			dtm.setValueAt(discount.getEndDate(), selectedRow, 5);
			dtm.setValueAt(discount.getCustomerType(), selectedRow, 6);
			
		}
		return check; 
	}
	
	public int deleteDiscountAndUpdateTableView() {
		String id = form.lbl_discountID.getText();
		int check = DiscountDAO.deleteDiscountByID(id);
		if (check==1) {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.removeRow(selectedRow);
		}
		return check; 
		
	}
	
}
