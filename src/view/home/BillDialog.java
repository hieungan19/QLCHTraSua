package view.home;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.BillController;
import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppScrollTable;

import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class BillDialog extends JDialog {

	public final JPanel contentPanel = new JPanel();
	public AppLabel billID;
	public AppLabel billDate;
	public AppLabel empName;
	public AppLabel cusName;
	public AppLabel cusPhoneNumber;
	public AppScrollTable scrollPane_bill;
	public AppLabel subtotal;
	public AppLabel discountValue;
	public AppLabel total;
	public AppLabel point;
	public AppLabel customerPayment;
	public AppLabel change;
	BillController controller; 

	public BillDialog() {
		String[] titleList = {
				"STT", "Tên món", "Số lượng", "Đơn giá", "Thành tiền"};
		Object[][] object = new Object[][] {
			{"1", null, "abcababababababababa", null, null,null},
			
		}; 
		
		setBounds(0,0, 550, 719);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(3, 0, 0, 0));
		{
			JPanel panel_infoStaffAndCustomer = new JPanel();
			contentPanel.add(panel_infoStaffAndCustomer);
			panel_infoStaffAndCustomer.setLayout(new GridLayout(2, 0, 0, 0));
			{
				JPanel panel_infoStaff = new JPanel();
				panel_infoStaffAndCustomer.add(panel_infoStaff);
				panel_infoStaff.setLayout(new GridLayout(3, 0, 0, 0));
				{
					AppLabel lblNewLabel_detailBillText = new AppLabel("CHI TIẾT HÓA ĐƠN",24,true);
					lblNewLabel_detailBillText.setHorizontalAlignment(SwingConstants.CENTER);
					panel_infoStaff.add(lblNewLabel_detailBillText);
				}
				{
					JPanel panel_billInfo = new JPanel();
					FlowLayout flowLayout = (FlowLayout) panel_billInfo.getLayout();
					flowLayout.setAlignment(FlowLayout.RIGHT);
					flowLayout.setHgap(30);
					panel_infoStaff.add(panel_billInfo);
					{
						billID = new AppLabel("Mã hóa đơn:");
						panel_billInfo.add(billID);
					}
					{
						billDate = new AppLabel("Ngày giờ: ");
						billDate.setText("Ngày:");
						panel_billInfo.add(billDate);
					}
				}
				{
					JPanel panel = new JPanel();
					FlowLayout flowLayout = (FlowLayout) panel.getLayout();
					flowLayout.setAlignment(FlowLayout.LEADING);
					panel_infoStaff.add(panel);
					{
						AppLabel lblNewLabel_staffName = new AppLabel("Nhân viên: ");
						panel.add(lblNewLabel_staffName);
					}
					{
						empName = new AppLabel("New label");
						empName.setText("");
						panel.add(empName);
					}
				}
			}
			{
				JPanel panel_infoCustomer = new JPanel();
				panel_infoStaffAndCustomer.add(panel_infoCustomer);
				panel_infoCustomer.setLayout(new GridLayout(2, 0, 0, 0));
				{
					JPanel panel = new JPanel();
					FlowLayout flowLayout = (FlowLayout) panel.getLayout();
					flowLayout.setAlignment(FlowLayout.LEADING);
					panel_infoCustomer.add(panel);
					{
						AppLabel lblNewLabel_customerName = new AppLabel("Tên khách hàng: ");
						panel.add(lblNewLabel_customerName);
					}
					{
						cusName = new AppLabel("New label");
						cusName.setText("");
						panel.add(cusName);
					}
				}
				{
					JPanel panel_1 = new JPanel();
					FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
					flowLayout.setAlignment(FlowLayout.LEFT);
					panel_infoCustomer.add(panel_1);
					{
						AppLabel lblNewLabel_phoneNumber = new AppLabel("Số điện thoại: ");
						panel_1.add(lblNewLabel_phoneNumber);
					}
					{
						cusPhoneNumber = new AppLabel("New label");
						cusPhoneNumber.setText("");
						panel_1.add(cusPhoneNumber);
					}
				}
			}
		}
		{
			JPanel panel_tableDrink = new JPanel();
			panel_tableDrink.setLayout(new GridLayout(0, 1, 0, 0));
			scrollPane_bill = new AppScrollTable(new DefaultTableModel(object, titleList));
			scrollPane_bill.jTable.setModel(new DefaultTableModel(
				new Object[][] {
					{"1", null, "abcababababababababa", null, null},
				},
				new String[] {
					"STT", "T\u00EAn m\u00F3n", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
				}
			));
			scrollPane_bill.jTable.getColumnModel().getColumn(1).setPreferredWidth(150);
			scrollPane_bill.setEnabled(false);
			panel_tableDrink.add(scrollPane_bill); 
			contentPanel.add(panel_tableDrink);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(6, 0, 0, 10));
			{
				AppLabel lblNewLabel_estimateAmount = new AppLabel("Tạm tính");
				lblNewLabel_estimateAmount.setText("Tạm tính:");
				panel.add(lblNewLabel_estimateAmount);
			}
			{
				subtotal = new AppLabel("New label");
				panel.add(subtotal);
			}
			{
				AppLabel lblNewLabel_discountedPrice = new AppLabel("");
				lblNewLabel_discountedPrice.setText("Giảm giá: ");
				panel.add(lblNewLabel_discountedPrice);
			}
			{
				discountValue = new AppLabel("New label");
				panel.add(discountValue);
			}
			{
				AppLabel lblNewLabel_total = new AppLabel("New label");
				lblNewLabel_total.setText("Tổng cộng: ");
				panel.add(lblNewLabel_total);
			}
			{
				total = new AppLabel("New label");
				panel.add(total);
			}
			{
				AppLabel lblNewLabel_point = new AppLabel("New label");
				lblNewLabel_point.setToolTipText("");
				lblNewLabel_point.setText("Điểm thưởng: ");
				panel.add(lblNewLabel_point);
			}
			{
				point = new AppLabel("New label");
				panel.add(point);
			}
			{
				AppLabel lblNewLabel_customerGaveMoney = new AppLabel("Tiền khách đưa");
				panel.add(lblNewLabel_customerGaveMoney);
			}
			{
				customerPayment = new AppLabel("New label");
				panel.add(customerPayment);
			}
			{
				AppLabel lblNewLabel_changeMoney = new AppLabel("New label");
				lblNewLabel_changeMoney.setText("Tiền thối: ");
				panel.add(lblNewLabel_changeMoney);
			}
			{
				change = new AppLabel("New label");
				panel.add(change);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(null);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 1, 0, 0));
			{
				AppButton cancelButton = new AppButton("IN HÓA ĐƠN");
				cancelButton.setBorder(null);
				cancelButton.setActionCommand("Print");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}

}
