package dao;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.BillModel;
import view.bill.BillPageView;

public class BillController {
	BillPageView view;
	JTable table; 
	List<BillModel> billList; 

	public BillController(BillPageView view) {
		super();
		this.view = view;
		this.table = view.scrollPane_bill.jTable;
		
		//hien thi toan bo hoa don
		
		getBillListAndDisplayToTable();
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
	
	
	
	
}
