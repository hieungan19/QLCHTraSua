package controller;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

import dao.CustomerDAO;
import dao.EmployeeDAO;
import model.BillModel;
import model.CustomerModel;
import model.EmployeeModel;
import model.ProductModel;
import view.home.BillDialog;

public class BillDialogController {
	BillDialog dialog;

	public BillDialogController(BillDialog dialog) {
		super();
		this.dialog = dialog;
		setDataToBillDialog(dialog, dialog.bill);
		dialog.show();
		
		dialog.printButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				convertToImage(dialog, dialog.bill.getBillID()+".png"); 
			}
		}); 
	}
	
	public static void convertToImage(JDialog dialog, String outputFilePath) {
        try {
            // Capture the screenshot of the dialog
            Rectangle dialogBounds = dialog.getBounds();
            BufferedImage dialogImage = new Robot().createScreenCapture(dialogBounds);

            // Save the screenshot as a PNG image file
            File outputFile = new File("src/assets/bills/"+outputFilePath);
            ImageIO.write(dialogImage, "png", outputFile);

            System.out.println("Dialog saved as an image: " + outputFile.getAbsolutePath());
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
                Desktop.getDesktop().open(outputFile);
            } else {
                System.out.println("Opening the image in a viewer is not supported on this platform.");
            }
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void setDataToBillDialog(BillDialog dialog, BillModel bill) {
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
				Object[] toppingObject = new Object[] { "", topping.getName(), topping.getAmount()*pro.getAmount(), topping.getPrice(),
						topping.getAmount() * pro.getAmount() * topping.getPrice() };
				dtm.addRow(toppingObject);
			}
		}
		
		dialog.discountID.setText(bill.getDiscountID());
		dialog.subtotal.setText(String.valueOf (bill.getSubtotal()));
		dialog.total.setText(String.valueOf(bill.getTotal()));
		dialog.discountValue.setText(String.valueOf(bill.getDiscountValue()));
		dialog.customerPayment.setText(String.valueOf(bill.getTenderAmount()));
		dialog.change.setText(String.valueOf(bill.getTenderAmount() - bill.getTotal()));
		
		int point = (int) Math.round(bill.getTotal()/5000); 
//		dialog.point.setText(String.valueOf(point)); 
		
	}
	
}
