package view.customer;

import javax.swing.JPanel;

import globalComponent.AppLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.GridLayout;
import globalComponent.AppLineBorderTextField;
import globalComponent.AppButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import constant.ConstantValueView;

import java.awt.Color;

public class CustomerInfoForm extends JPanel {
	private AppLineBorderTextField textField;
	private AppLineBorderTextField textField_1;
	private AppLineBorderTextField textField_2;

	/**
	 * Create the panel.
	 */
	public CustomerInfoForm() {
		String[] options = {"MEMBERSHIP","VIP"}; 
		JPanel contentPanel = new JPanel();
		contentPanel.setSize(790, 630);
		contentPanel.setLocation(20, 20);
		this.setLayout(null);
		this.add(contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPanel.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		AppLabel lblNewLabel = new AppLabel("THÔNG TIN KHÁCH HÀNG", 24, true);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		AppLabel lblNewLabel_6 = new AppLabel("MÃ KHÁCH HÀNG", 16, true);
		lblNewLabel_6.setText("MÃ KHÁCH HÀNG: ");
		panel.add(lblNewLabel_6);
		
		JPanel panel_info = new JPanel();
		GridBagConstraints gbc_panel_info = new GridBagConstraints();
		gbc_panel_info.insets = new Insets(0, 0, 5, 0);
		gbc_panel_info.fill = GridBagConstraints.BOTH;
		gbc_panel_info.gridx = 0;
		gbc_panel_info.gridy = 1;
		contentPanel.add(panel_info, gbc_panel_info);
		panel_info.setLayout(new GridLayout(5, 0, 0, 10));
		
		AppLabel lblNewLabel_1 = new AppLabel("New label");
		lblNewLabel_1.setText("Họ tên");
		panel_info.add(lblNewLabel_1);
		
		textField_1 = new AppLineBorderTextField();
		panel_info.add(textField_1);
		textField_1.setColumns(10);
		
		AppLabel lblNewLabel_2 = new AppLabel("Số điện thoại");
		panel_info.add(lblNewLabel_2);
		
		textField = new AppLineBorderTextField();
		panel_info.add(textField);
		textField.setColumns(10);
		
		AppLabel lblNewLabel_3 = new AppLabel("Email");
		panel_info.add(lblNewLabel_3);
		
		textField_2 = new AppLineBorderTextField();
		panel_info.add(textField_2);
		textField_2.setColumns(10);
		
		AppLabel lblNewLabel_5 = new AppLabel("Loại khách hàng:");
		panel_info.add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox(options);
		comboBox.setBorder(new LineBorder(ConstantValueView.primaryColor, 2));
		panel_info.add(comboBox);
		
		
		AppLabel lblNewLabel_4 = new AppLabel("New label");
		lblNewLabel_4.setText("Điểm thưởng:");
		panel_info.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weighty = 4.0;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		contentPanel.add(panel_1, gbc_panel_1);
		
		AppButton btnDelete = new AppButton("XÓA");
		panel_1.add(btnDelete);
		
		AppButton btnSave = new AppButton("LƯU");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnSave);
		
	}
}
