package view.home;

import javax.swing.JPanel;

import constant.ConstantValueView;

import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppScrollTable;
import globalComponent.AppTextField;
import globalComponent.NumberSpinner;

import java.awt.GridLayout;

import javax.swing.JComboBox;

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
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class CartPanel extends JPanel {
	private JTable table_cart;
	public AppScrollTable scrollPane_cart;
	public AppTextField cusPhoneNumber;
	public AppLabel cusName;
	public AppButton btn_confirm;
	public NumberSpinner spinner_cusPaymentAmount;
	public JComboBox<String> comboBox_discount;
	public AppLabel cusID;

	/**
	 * Create the panel.
	 */
	public CartPanel() {
		String[] titleList = { "Mã", "Tên", "Topping", "Giá" };
		Object[][] object = new Object[][] { { "1", null, "abcababababababababa", null, null, null },

		};
		btn_confirm = new AppButton("XÁC NHẬN");
		this.setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 250 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 250, 0, 0, 0 };
		setLayout(gridBagLayout);
		AppLabel lblNewLabel_cart = new AppLabel("CART");
		lblNewLabel_cart.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_cart.setForeground(ConstantValueView.primaryDark);
		lblNewLabel_cart.setFont(new Font("Tahoma", Font.BOLD, 32));
		GridBagConstraints gbc_lblNewLabel_cart = new GridBagConstraints();
		gbc_lblNewLabel_cart.gridwidth = 2;
		gbc_lblNewLabel_cart.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_cart.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_cart.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_cart.gridx = 0;
		gbc_lblNewLabel_cart.gridy = 0;
		add(lblNewLabel_cart, gbc_lblNewLabel_cart);

		JPanel panel = new JPanel();
		panel.setOpaque(false);

		// text field thông tin khách hàng
		panel.setLayout(new GridLayout(2, 1, 10, 0));
		cusPhoneNumber = new AppTextField("Số điện thoại");
		panel.add(cusPhoneNumber);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));

		cusID = new AppLabel("CUS ID");
		panel_1.add(cusID);

		cusName = new AppLabel("Tên khách hàng");
		panel_1.add(cusName);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		scrollPane_cart = new AppScrollTable(new DefaultTableModel(object, titleList));
		scrollPane_cart.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// table

		GridBagConstraints gbc_scrollPane_cart = new GridBagConstraints();
		gbc_scrollPane_cart.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_cart.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_cart.gridwidth = 2;
		gbc_scrollPane_cart.gridx = 0;
		gbc_scrollPane_cart.gridy = 2;
		add(scrollPane_cart, gbc_scrollPane_cart);
		// String[] discountList = { "item1", "item2", "item3" };
		// JList<String> jListDiscount = new JList<String>(discountList);
		// add(jListDiscount);
		// comboBox_discount.setViewportView(jListDiscount);

		AppLabel lblNewLabel = new AppLabel("Chọn khuyến mãi");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);

		comboBox_discount = new JComboBox<String>();
		comboBox_discount.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox_discount = new GridBagConstraints();
		gbc_comboBox_discount.fill = GridBagConstraints.BOTH;
		gbc_comboBox_discount.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_discount.gridwidth = 2;
		gbc_comboBox_discount.gridx = 0;
		gbc_comboBox_discount.gridy = 4;
		add(comboBox_discount, gbc_comboBox_discount);

		btn_confirm.setBackground(ConstantValueView.primaryDark);
		btn_confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BillDialog bill = new BillDialog();
				bill.setVisible(true);
			}
		});

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 5;
		add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 10));

		AppLabel label_2 = new AppLabel("Số tiền khách đưa");
		label_2.setText("Số tiền khách đưa:");
		panel_2.add(label_2);

		spinner_cusPaymentAmount = new NumberSpinner(new SpinnerNumberModel(0, 0, 1e9, 1000));
		panel_2.add(spinner_cusPaymentAmount);
		spinner_cusPaymentAmount.setToolTipText("");

		AppLabel lblNewLabel_estimateAmount = new AppLabel("Tạm tính: 200000 VND");
		lblNewLabel_estimateAmount.setText("Tạm tính:");
		panel_2.add(lblNewLabel_estimateAmount);

		AppLabel subtotal = new AppLabel("New label");
		panel_2.add(subtotal);

		AppLabel lblNewLabel_discountValue = new AppLabel("Khuyến mãi: 10000 VND");
		lblNewLabel_discountValue.setText("Khuyến mãi: ");
		panel_2.add(lblNewLabel_discountValue);

		AppLabel discountValue = new AppLabel("New label");
		panel_2.add(discountValue);

		AppLabel lblNewLabel_totalAmount = new AppLabel("Tổng cộng: 190000 VND");
		lblNewLabel_totalAmount.setText("Tổng cộng: ");
		panel_2.add(lblNewLabel_totalAmount);

		AppLabel total = new AppLabel("New label");
		panel_2.add(total);

		GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
		gbc_btnConfirm.weightx = 1.0;
		gbc_btnConfirm.fill = GridBagConstraints.BOTH;
		gbc_btnConfirm.anchor = GridBagConstraints.WEST;
		gbc_btnConfirm.gridx = 1;
		gbc_btnConfirm.gridy = 11;
		add(btn_confirm, gbc_btnConfirm);
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
