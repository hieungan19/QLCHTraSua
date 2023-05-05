package view.home;

import javax.swing.JPanel;

import constant.ConstantValueView;
import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppScrollTable;
import globalComponent.AppTextField;
import model.DrinkModel;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class CartPanel extends JPanel {
	private JTable table_cart;

	/**
	 * Create the panel.
	 */
	public CartPanel() {
		String[] titleList = { "M\u00E3 \u0111\u1ED3 u\u1ED1ng", "T\u00EAn \u0111\u1ED3 u\u1ED1ng", "Topping",
				"S\u1ED1 l\u01B0\u1EE3ng", "Giá", "Ghi chú" };
		Object[][] object = new Object[][] { { "1", null, "abcababababababababa", null, null, null },

		};

		this.setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {250};
		gridBagLayout.rowHeights = new int[] { 39, 114, 205, 75, 57, 71, 48, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		JLabel lblNewLabel_cart = new JLabel("CART");
		lblNewLabel_cart.setForeground(ConstantValueView.primaryDark);
		lblNewLabel_cart.setFont(new Font("Tahoma", Font.BOLD, 32));
		GridBagConstraints gbc_lblNewLabel_cart = new GridBagConstraints();
		gbc_lblNewLabel_cart.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_cart.gridwidth = 4;
		gbc_lblNewLabel_cart.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_cart.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_cart.gridx = 0;
		gbc_lblNewLabel_cart.gridy = 0;
		add(lblNewLabel_cart, gbc_lblNewLabel_cart);

		JPanel panel = new JPanel();
		panel.setOpaque(false);

		// text field thông tin khách hàng
		AppTextField customerName = new AppTextField("Tên khách hàng");
		panel.setLayout(new GridLayout(2, 1, 10, 0));
		AppTextField customerPhoneNumber = new AppTextField("Số điện thoại");
		panel.add(customerPhoneNumber);
		panel.add(customerName);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 4;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);

		// table
		AppScrollTable table_scrollPane = new AppScrollTable(new DefaultTableModel(object, titleList));
		GridBagConstraints gbc_table_scrollPane = new GridBagConstraints();
		gbc_table_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_table_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_table_scrollPane.gridwidth = 4;
		gbc_table_scrollPane.gridx = 0;
		gbc_table_scrollPane.gridy = 2;
		add(table_scrollPane, gbc_table_scrollPane);
		// String[] discountList = { "item1", "item2", "item3" };
		// JList<String> jListDiscount = new JList<String>(discountList);
		// add(jListDiscount);
		// scrollPane_discount.setViewportView(jListDiscount);

		AppLabel lblNewLabel = new AppLabel("Chọn khuyến mãi");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);

		JScrollPane scrollPane_discount = new JScrollPane();
		scrollPane_discount.setBackground(Color.WHITE);
		GridBagConstraints gbc_scrollPane_discount = new GridBagConstraints();
		gbc_scrollPane_discount.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_discount.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_discount.gridwidth = 4;
		gbc_scrollPane_discount.gridx = 0;
		gbc_scrollPane_discount.gridy = 3;
		add(scrollPane_discount, gbc_scrollPane_discount);

		AppTextField customerGaveMoney = new AppTextField("Tiền khách đưa");
		customerGaveMoney.setToolTipText("");
		GridBagConstraints gbc_customerGaveMoney = new GridBagConstraints();
		gbc_customerGaveMoney.fill = GridBagConstraints.BOTH;
		gbc_customerGaveMoney.insets = new Insets(0, 0, 5, 0);
		gbc_customerGaveMoney.gridwidth = 4;
		gbc_customerGaveMoney.gridx = 0;
		gbc_customerGaveMoney.gridy = 4;
		add(customerGaveMoney, gbc_customerGaveMoney);

		JPanel panel_total = new JPanel();
		panel_total.setOpaque(false);
		panel_total.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_panel_total = new GridBagConstraints();
		gbc_panel_total.fill = GridBagConstraints.BOTH;
		gbc_panel_total.insets = new Insets(0, 0, 5, 0);
		gbc_panel_total.gridwidth = 4;
		gbc_panel_total.gridx = 0;
		gbc_panel_total.gridy = 5;
		add(panel_total, gbc_panel_total);
		panel_total.setLayout(new GridLayout(3, 2, 0, 0));

		AppLabel lblNewLabel_estimateAmount = new AppLabel("Tạm tính: 200000 VND");
		panel_total.add(lblNewLabel_estimateAmount);

		AppLabel lblNewLabel_discountAmount = new AppLabel("Khuyến mãi: 10000 VND");
		panel_total.add(lblNewLabel_discountAmount);

		AppLabel lblNewLabel_totalAmount = new AppLabel("Tổng cộng: 190000 VND");
		panel_total.add(lblNewLabel_totalAmount);

		AppButton btnConfirm = new AppButton("XÁC NHẬN");
		btnConfirm.setBackground(ConstantValueView.primaryDark);
		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BillDialog bill = new BillDialog();
				bill.setVisible(true);
			}
		});

		GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
		gbc_btnConfirm.weightx = 1.0;
		gbc_btnConfirm.gridwidth = 2;
		gbc_btnConfirm.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirm.fill = GridBagConstraints.BOTH;
		gbc_btnConfirm.anchor = GridBagConstraints.WEST;
		gbc_btnConfirm.gridx = 2;
		gbc_btnConfirm.gridy = 6;
		add(btnConfirm, gbc_btnConfirm);
		/*
		 * btnConfirm.addActionListener(e -> { // Tạo JDialog và thiết lập thông tin
		 * JDialog dialog = new JDialog(root, "Pop-up Example", true);
		 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 * dialog.setSize(500, 350); dialog.setLocationRelativeTo(null); DrinkCardModel
		 * dummy = new DrinkCardModel("D01", "Tra sua Olong",20000 ,
		 * "Tra sua","/assets/bg-login.png", null, null); // Thêm nội dung vào JDialog
		 * ChooseDrinkDialog panelBill = new ChooseDrinkDialog(dummy);
		 * 
		 * dialog.add(panelBill);
		 * 
		 * // Hiển thị JDialog dialog.setVisible(true); });
		 */

	}
}
