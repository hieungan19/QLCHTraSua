package controller;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dao.BillDAO;
import model.BillModel;
import model.CustomerModel;
import model.DashboardOption;
import model.EmployeeModel;
import model.ProductModel;
import view.AppView;
import view.bill.BillPageView;
import view.home.BillDialog;

public class BillController {
	BillPageView view;
	JTable table;
	List<BillModel> billList;

	public BillController(BillPageView view) {
		super();
		this.view = view;
		this.table = view.scrollPane_bill.jTable;
		
		
		// search
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);
		
		//add bill -> navigate to home
		addActionListenerToAddBillBtn(); 
		
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
		// hien thi toan bo hoa don

		getBillListAndDisplayToTable();
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
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					String id = String.valueOf(tableModel.getValueAt(selectedRow, 0));
					BillModel bill = getBillByID(id);
					BillDialog dialog = new BillDialog(bill);
					
					

					
				}
			}
		});
	}

	public void getBillListAndDisplayToTable() {
		billList = BillDAO.getAllBill();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setNumRows(0);
		if (billList.isEmpty()) {
			System.out.println("Khong co hoa don.");
		} else {
			for (int i = 0; i < billList.size(); i++) {
				BillModel bill = billList.get(i);
				dtm.addRow(bill.toOject());
			}
		}
		table.setModel(dtm);

	}

	public BillModel getBillByID(String id) {
		BillModel bill = BillDAO.getBillByID(id);
		System.out.println(bill.toStringConsoleTest());
		for (ProductModel pro : bill.getProductList()) {
			System.out.println(pro.toStringConsoleTest());
			System.out.println("TOPPING: ");
			for (ProductModel topping : pro.getToppingList()) {
				System.out.println(topping.toStringConsoleTest());
			}
		}
		return bill;
	}

	
	public void addActionListenerToAddBillBtn() {
		view.btnAddBill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AppController.setView(AppView.homeOption);
			}
		});
	}
	
	
	
	

}
