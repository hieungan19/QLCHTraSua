package dao;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.BillModel;
import model.CustomerModel;
import model.EmployeeModel;
import model.ProductModel;
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
					BillDialog dialog = new BillDialog();
					setDataToBillDialog(dialog, bill);
					dialog.show();

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

	public void setDataToBillDialog(BillDialog dialog, BillModel bill) {
		int count = 0;
		CustomerModel cus = CustomerDAO.getCustomerByID(bill.getCustomerID());

		String billID = bill.getBillID();
		dialog.billID.setText(billID);
		
		String billDate = bill.getBillDate().toString();
		dialog.billDate.setText(billDate);
		
		
		
		if (bill.getCustomerID() != null) {
			dialog.cusName.setText(cus.getName());
			dialog.cusPhoneNumber.setText(cus.getPhoneNumber());
		}

		
		EmployeeModel emp = EmployeeDAO.getEmployeeByEmpID(bill.getEmployeeID());
		dialog.empName.setText(emp.getName());
		
		
		DefaultTableModel dtm = (DefaultTableModel) dialog.scrollPane_bill.jTable.getModel();
		dtm.setRowCount(0);
		for (ProductModel pro : bill.getProductList()) {
			++count;
			Object[] proOject = new Object[] { count, pro.getName(), pro.getAmount(), pro.getPrice(),
					pro.getPrice() * pro.getAmount() };
			dtm.addRow(proOject);
			for (ProductModel topping : pro.getToppingList()) {
				Object[] toppingObject = new Object[] { "", topping.getName(), topping.getAmount(), topping.getPrice(),
						topping.getAmount() * pro.getAmount() * topping.getPrice() };
				dtm.addRow(toppingObject);
			}
		}
		
		
		dialog.subtotal.setText(String.valueOf (bill.getSubtotal()));
		dialog.total.setText(String.valueOf(bill.getTotal()));
		dialog.discountValue.setText(String.valueOf(bill.getDiscountValue()));
		dialog.customerPayment.setText(String.valueOf(bill.getTenderAmount()));
		dialog.change.setText(String.valueOf(bill.getTenderAmount() - bill.getTotal()));
		
		int point = (int) Math.round(bill.getTotal()/5000); 
		dialog.point.setText(String.valueOf(point)); 
		
	}

}
