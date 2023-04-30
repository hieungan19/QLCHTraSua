package view.home;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppScrollTable;

import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class BillDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public BillDialog() {
		String[] titleList = {
				"M\u00E3 \u0111\u1ED3 u\u1ED1ng", "T\u00EAn \u0111\u1ED3 u\u1ED1ng", "Topping", "S\u1ED1 l\u01B0\u1EE3ng", "T\u1ED5ng gi\u00E1"
			, "Ghi chú"};
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
						AppLabel lblNewLabel_billID = new AppLabel("Mã hóa đơn:");
						panel_billInfo.add(lblNewLabel_billID);
					}
					{
						AppLabel lblNewLabel_billDateTime = new AppLabel("Ngày giờ: ");
						panel_billInfo.add(lblNewLabel_billDateTime);
					}
				}
				{
					AppLabel lblNewLabel_staffName = new AppLabel("Nhân viên: ");
					
					panel_infoStaff.add(lblNewLabel_staffName);
				}
			}
			{
				JPanel panel_infoCustomer = new JPanel();
				panel_infoStaffAndCustomer.add(panel_infoCustomer);
				panel_infoCustomer.setLayout(new GridLayout(2, 0, 0, 0));
				{
					AppLabel lblNewLabel_customerName = new AppLabel("Tên khách hàng: ");
					panel_infoCustomer.add(lblNewLabel_customerName);
				}
				{
					JPanel panel = new JPanel();
					panel_infoCustomer.add(panel);
					panel.setLayout(new GridLayout(0, 2, 0, 0));
					{
						AppLabel lblNewLabel_currentPoint = new AppLabel("Điểm tích lũy: ");
						panel.add(lblNewLabel_currentPoint);
					}
					{
						AppLabel lblNewLabel_phoneNumber = new AppLabel("Số điện thoại: ");
						panel.add(lblNewLabel_phoneNumber);
					}
				}
			}
		}
		{
			JPanel panel_tableDrink = new JPanel();
			panel_tableDrink.setLayout(new GridLayout(0, 1, 0, 0));
			AppScrollTable table_scrollPane = new AppScrollTable(new DefaultTableModel(object, titleList));
			table_scrollPane.setEnabled(false);
			panel_tableDrink.add(table_scrollPane); 
			contentPanel.add(panel_tableDrink);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(6, 0, 0, 0));
			{
				AppLabel lblNewLabel_estimateAmount = new AppLabel("Tạm tính");
				lblNewLabel_estimateAmount.setText("Tạm tính:");
				panel.add(lblNewLabel_estimateAmount);
			}
			{
				AppLabel lblNewLabel_discountedPrice = new AppLabel("");
				lblNewLabel_discountedPrice.setText("Giảm giá: ");
				panel.add(lblNewLabel_discountedPrice);
			}
			{
				AppLabel lblNewLabel_total = new AppLabel("New label");
				lblNewLabel_total.setText("Tổng cộng: ");
				panel.add(lblNewLabel_total);
			}
			{
				AppLabel lblNewLabel_point = new AppLabel("New label");
				lblNewLabel_point.setToolTipText("");
				lblNewLabel_point.setText("Điểm thưởng: ");
				panel.add(lblNewLabel_point);
			}
			{
				AppLabel lblNewLabel_customerGaveMoney = new AppLabel("Tiền khách đưa");
				panel.add(lblNewLabel_customerGaveMoney);
			}
			{
				AppLabel lblNewLabel_changeMoney = new AppLabel("New label");
				lblNewLabel_changeMoney.setText("Tiền thối: ");
				panel.add(lblNewLabel_changeMoney);
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
