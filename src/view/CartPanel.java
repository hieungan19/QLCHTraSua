package view;

import javax.swing.JPanel;

import constant.ConstantValueView;
import diaglog.BillDialog;
import diaglog.ChooseDrinkDialog;
import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppTextField;
import model.DrinkModel;

import java.awt.GridLayout;

import javax.swing.JLabel;


import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import component.DrinkScrollPaneTable;

import javax.swing.JFrame;


public class CartPanel extends JPanel {
	private JTable table_cart;

	/**
	 * Create the panel.
	 */
	public CartPanel(JFrame root) {
		this.setOpaque(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(7, 72, 322, 114);
		panel.setOpaque(false);
		JLabel lblNewLabel_cart = new JLabel("CART");
		lblNewLabel_cart.setBounds(10, 10, 86, 39);
		lblNewLabel_cart.setForeground(ConstantValueView.primaryDark);
		lblNewLabel_cart.setFont(new Font("Tahoma", Font.BOLD, 32));

		// table
		DrinkScrollPaneTable table_scrollPane = new DrinkScrollPaneTable();
		table_scrollPane.setBounds(7, 196, 324, 205);
		
		// text field thông tin khách hàng
		AppTextField customerName = new AppTextField("Tên khách hàng");
		panel.setLayout(new GridLayout(2, 1, 10, 0));
		AppTextField customerPhoneNumber = new AppTextField("Số điện thoại");
		panel.add(customerPhoneNumber);
		panel.add(customerName);
		setLayout(null);
		add(table_scrollPane);
		add(panel);
		add(lblNewLabel_cart);

		JScrollPane scrollPane_discount = new JScrollPane();
		scrollPane_discount.setBounds(9, 430, 323, 56);
		add(scrollPane_discount);
//		String[] discountList = { "item1", "item2", "item3" };
//		JList<String> jListDiscount = new JList<String>(discountList);
//		add(jListDiscount);
//		scrollPane_discount.setViewportView(jListDiscount);

		AppLabel lblNewLabel = new AppLabel("Chọn khuyến mãi");
		lblNewLabel.setBounds(9, 411, 123, 20);
		add(lblNewLabel);
		
		AppTextField customerGaveMoney = new AppTextField("Tiền khách đưa");
		customerGaveMoney.setToolTipText("");
		customerGaveMoney.setBounds(9, 494, 322, 57);
		add(customerGaveMoney);

		JPanel panel_total = new JPanel();
		panel_total.setOpaque(false);
		panel_total.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_total.setBounds(11, 561, 322, 71);
		add(panel_total);
		panel_total.setLayout(new GridLayout(3, 2, 0, 0));

		AppLabel lblNewLabel_estimateAmount = new AppLabel("Tạm tính: 200000 VND");
		panel_total.add(lblNewLabel_estimateAmount);

		AppLabel lblNewLabel_discountAmount = new AppLabel("Khuyến mãi: 10000 VND");
		panel_total.add(lblNewLabel_discountAmount);

		AppLabel lblNewLabel_totalAmount = new AppLabel("Tổng cộng: 190000 VND");
		panel_total.add(lblNewLabel_totalAmount);

		AppButton btnConfirm = new AppButton("XÁC NHẬN");
		btnConfirm.setBackground(ConstantValueView.primaryDark);
		/*btnConfirm.addActionListener(e -> {
            // Tạo JDialog và thiết lập thông tin
            JDialog dialog = new JDialog(root, "Pop-up Example", true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setSize(500, 350);
            dialog.setLocationRelativeTo(null);
             DrinkCardModel dummy = new DrinkCardModel("D01", "Tra sua Olong",20000 , "Tra sua","/assets/bg-login.png", null, null); 
            // Thêm nội dung vào JDialog
            ChooseDrinkDialog panelBill = new ChooseDrinkDialog(dummy); 
         
            dialog.add(panelBill);
            
            // Hiển thị JDialog
            dialog.setVisible(true);
        });*/
		btnConfirm.addActionListener(e ->{
			BillDialog bill = new BillDialog();
			bill.setVisible(true);

//			DrinkCardModel dummy = new DrinkCardModel("D01", "Tra sua Olong",20000 , "Tra sua","/assets/bg-login.png", null, null); 
//			ChooseDrinkDialog drink = new ChooseDrinkDialog(dummy);
//			drink.setVisible(true); 
			
		});
		btnConfirm.setBounds(218, 642, 116, 48);
		add(btnConfirm);

	}
}
