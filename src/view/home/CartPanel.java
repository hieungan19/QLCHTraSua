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
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;


public class CartPanel extends JPanel {
	
	public AppTextField cusPhoneNumber;
	public AppLabel cusName;
	public NumberSpinner spinner_cusPaymentAmount;
	public JComboBox<String> comboBox_discount;
	public AppLabel cusID;
	public AppButton btn_confirm; 
	public JPanel cart;
	public AppScrollTable scrollPane_cart;
	public AppButton btn_calc;
	public AppLabel subtotal;
	public AppLabel discountValue;
	public AppLabel total; 

	/**
	 * Create the panel.
	 */
	public CartPanel() {
		String[] titleList = { "Mã", "Tên đồ uống","Topping","Thành tiền" };
		Object[][] object = new Object[][] { { "1", null, "abcababababababababa", null, null, null },

		};
		scrollPane_cart = new AppScrollTable(new DefaultTableModel(object,titleList));
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public void setValue(Object value) {
                setToolTipText(value != null ? value.toString() : null);
                setText(value != null ? value.toString() : "");
            }
        };

        // Set the custom cell renderer for the specific column
        scrollPane_cart.jTable.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		
		this.setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {250};
		gridBagLayout.rowHeights = new int[] {30, 50, 250, 50, 100, 40, 30};
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0, 0.0 };
		setLayout(gridBagLayout);
		AppLabel lblNewLabel_cart = new AppLabel("CART");
		lblNewLabel_cart.setForeground(ConstantValueView.primaryDark);
		lblNewLabel_cart.setFont(new Font("Tahoma", Font.BOLD, 32));
		GridBagConstraints gbc_lblNewLabel_cart = new GridBagConstraints();
		gbc_lblNewLabel_cart.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_cart.gridwidth = 2;
		gbc_lblNewLabel_cart.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_cart.insets = new Insets(5, 10, 5, 0);
		gbc_lblNewLabel_cart.gridx = 0;
		gbc_lblNewLabel_cart.gridy = 0;
		add(lblNewLabel_cart, gbc_lblNewLabel_cart);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new GridLayout(2, 1, 10, 0));
		cusPhoneNumber = new AppTextField("Số điện thoại");
		panel.add(cusPhoneNumber);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 10, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		cusID = new AppLabel("New label");
		cusID.setText("");
		panel_1.add(cusID);
		
		cusName= new AppLabel("New label");
		cusName.setText("");
		panel_1.add(cusName);
		
		
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 2;
		gbc_panel_4.insets = new Insets(0, 10, 5, 10);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 2;
		add(scrollPane_cart, gbc_panel_4);
		
		
	
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 10, 5, 10);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 3;
		add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		AppLabel lblNewLabel = new AppLabel("Chọn khuyến mãi");
		panel_2.add(lblNewLabel);
		
		comboBox_discount = new JComboBox();
		panel_2.add(comboBox_discount);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 2;
		gbc_panel_3.insets = new Insets(0, 10, 5, 10);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 4;
		add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(4, 0, 0, 0));
		
		AppLabel lblNewLabel_1 = new AppLabel("New label");
		lblNewLabel_1.setText("Khách hàng đưa");
		panel_3.add(lblNewLabel_1);
		spinner_cusPaymentAmount  = new NumberSpinner(new SpinnerNumberModel(0.0, 0.0, 1e9, 1000.0)); 
		panel_3.add(spinner_cusPaymentAmount); 
		
		AppLabel lblNewLabel_2 = new AppLabel("New label");
		lblNewLabel_2.setText("Tạm tính");
		panel_3.add(lblNewLabel_2);
		
		subtotal = new AppLabel("New label");
		subtotal.setText("");
		panel_3.add(subtotal);
		
		AppLabel lblNewLabel_4 = new AppLabel("New label");
		lblNewLabel_4.setText("Số tiền khuyến mãi");
		panel_3.add(lblNewLabel_4);
		
		discountValue= new AppLabel("New label");
		discountValue.setText("");
		panel_3.add(discountValue);
		
		AppLabel lblNewLabel_6 = new AppLabel("Tổng cộng");
		panel_3.add(lblNewLabel_6);
		
		total = new AppLabel("", 16, true);
		panel_3.add(total);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridwidth = 2;
		gbc_panel_5.weightx = 10.0;
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 5;
		add(panel_4, gbc_panel_5);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btn_calc = new AppButton("TẠM TÍNH");
		btn_calc.setBackground(new Color(95, 158, 160));
		btn_calc.setForeground(SystemColor.menu);
		panel_4.add(btn_calc);
		
				btn_confirm = new AppButton("XÁC NHẬN");
				btn_confirm.setEnabled(false);
				panel_4.add(btn_confirm);
				btn_confirm.setBackground(new Color(128,128,128));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 0, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 7;
		
		
	

	}
}



