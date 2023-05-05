package view.discount;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import globalComponent.AppLabel;
import globalComponent.AppLineBorderTextField;
import globalComponent.DatePickerComponent;
import globalComponent.NumberSpinner;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;
import globalComponent.AppButton;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class DiscountInfoForm extends JPanel {
	private AppLineBorderTextField textField;
	private AppLineBorderTextField textField_1;
	private AppLineBorderTextField textField_2;
	private AppLineBorderTextField textField_3;

	/**
	 * Create the panel.
	 */
	public DiscountInfoForm() {
		JPanel contentPanel = new JPanel();
		contentPanel.setSize(790, 630);
		contentPanel.setLocation(20, 20);
		this.setLayout(null);
		this.add(contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		AppLabel lblNewLabel = new AppLabel("THÔNG TIN KHUYẾN MÃI", 24, true);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		AppLabel lblNewLabel_9 = new AppLabel("Mã nhân viên: ",16,true);
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 1;
		contentPanel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JPanel panel_info = new JPanel();
		GridBagConstraints gbc_panel_info = new GridBagConstraints();
		gbc_panel_info.weighty = 4.0;
		gbc_panel_info.insets = new Insets(0, 0, 5, 0);
		gbc_panel_info.fill = GridBagConstraints.BOTH;
		gbc_panel_info.gridx = 0;
		gbc_panel_info.gridy = 2;
		contentPanel.add(panel_info, gbc_panel_info);
		panel_info.setLayout(new GridLayout(8, 0, 0, 10));
		
		AppLabel lblNewLabel_2 = new AppLabel("Mã khuyến mãi");
		panel_info.add(lblNewLabel_2);
		
		textField = new AppLineBorderTextField();
		panel_info.add(textField);
		textField.setColumns(10);
		
		AppLabel lblNewLabel_3 = new AppLabel("Tên khuyến mãi");
		panel_info.add(lblNewLabel_3);
		
		textField_1 = new AppLineBorderTextField();
		panel_info.add(textField_1);
		textField_1.setColumns(10);
		
		AppLabel lblNewLabel_4 = new AppLabel("Số tiền khuyến mãi");
		panel_info.add(lblNewLabel_4);
		NumberSpinner discountAmountSpinner = new NumberSpinner(new SpinnerNumberModel(0,0,100000,1000)); 
		panel_info.add(discountAmountSpinner); 
		
		
		AppLabel lblNewLabel_1 = new AppLabel("Phần trăm khuyến mãi");
		panel_info.add(lblNewLabel_1);
		
		NumberSpinner discountPercentageSpinner = new NumberSpinner(new SpinnerNumberModel(0,0,100,5));
		panel_info.add(discountPercentageSpinner); 
		
		AppLabel lblNewLabel_5 = new AppLabel("Mô tả chi tiết");
		panel_info.add(lblNewLabel_5);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 12));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setRows(1);
		JScrollPane jScrollPane = new JScrollPane(textArea); 
		panel_info.add(jScrollPane);
		
		AppLabel lblNewLabel_6 = new AppLabel("Ngày bắt đầu khuyến mãi");
		panel_info.add(lblNewLabel_6);
		
		DatePickerComponent startDay = new DatePickerComponent();
		panel_info.add(startDay); 
		
		AppLabel lblNewLabel_7 = new AppLabel("Ngày kết thúc khuyến mãi");
		panel_info.add(lblNewLabel_7);
		DatePickerComponent endDay = new DatePickerComponent(); 
		panel_info.add(endDay); 
		
		AppLabel lblNewLabel_8 = new AppLabel("Đối tượng áp dụng");
		panel_info.add(lblNewLabel_8);
		
		JPanel panel_button = new JPanel();
		GridBagConstraints gbc_panel_button = new GridBagConstraints();
		gbc_panel_button.insets = new Insets(0, 0, 5, 0);
		gbc_panel_button.weighty = 2.0;
		gbc_panel_button.fill = GridBagConstraints.BOTH;
		gbc_panel_button.gridx = 0;
		gbc_panel_button.gridy = 3;
		contentPanel.add(panel_button, gbc_panel_button);
		panel_button.setLayout(new FlowLayout(FlowLayout.TRAILING, 20, 5));
		
		AppButton btnNewButton_1 = new AppButton("XÓA");
		panel_button.add(btnNewButton_1);
		
		AppButton btnNewButton = new AppButton("LƯU");
		panel_button.add(btnNewButton);
//		
//		String qualifyingCustomersList[] = {"ALL","MEMBERSHIP","VIP"};
//		JComboBox<String> comboBox = new JComboBox<>(qualifyingCustomersList); 
//		panel_info.add(comboBox); 
		
	}
}
