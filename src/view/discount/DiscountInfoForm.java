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
	public AppLineBorderTextField textField_name;
	public JComboBox comboBox;
	public String[] customerTypeList;
	public NumberSpinner spinner_percent;
	public DatePickerComponent startDay;
	public DatePickerComponent endDay;
	public NumberSpinner spinner_totalBill;
	public AppButton btn_deleteDiscount;
	public AppButton btn_saveDiscount;
	public AppLabel lbl_discountID;

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
		
		lbl_discountID = new AppLabel("",16,true);
		GridBagConstraints gbc_lbl_discountID = new GridBagConstraints();
		gbc_lbl_discountID.anchor = GridBagConstraints.WEST;
		gbc_lbl_discountID.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_discountID.gridx = 0;
		gbc_lbl_discountID.gridy = 1;
		contentPanel.add(lbl_discountID, gbc_lbl_discountID);
		
		JPanel panel_info = new JPanel();
		GridBagConstraints gbc_panel_info = new GridBagConstraints();
		gbc_panel_info.weighty = 4.0;
		gbc_panel_info.insets = new Insets(0, 0, 5, 0);
		gbc_panel_info.fill = GridBagConstraints.BOTH;
		gbc_panel_info.gridx = 0;
		gbc_panel_info.gridy = 2;
		contentPanel.add(panel_info, gbc_panel_info);
		panel_info.setLayout(new GridLayout(8, 0, 0, 10));
		
		AppLabel lblNewLabel_3 = new AppLabel("Tên khuyến mãi");
		panel_info.add(lblNewLabel_3);
		
		textField_name = new AppLineBorderTextField();
		panel_info.add(textField_name);
		textField_name.setColumns(10);
		
		AppLabel lblNewLabel_ = new AppLabel("Tổng giá trị tối thiểu của hóa đơn");
		panel_info.add(lblNewLabel_);
		spinner_totalBill = new NumberSpinner(new SpinnerNumberModel(0,0,1e9,1000)); 
		panel_info.add(spinner_totalBill); 
		
		
		AppLabel lblNewLabel_1 = new AppLabel("Phần trăm khuyến mãi");
		panel_info.add(lblNewLabel_1);
		
		spinner_percent = new NumberSpinner(new SpinnerNumberModel(0,0,100,5));
		spinner_percent.setModel(new SpinnerNumberModel(0.0, 0.0, 100.0, 5.0));
		panel_info.add(spinner_percent);
		
		AppLabel lblNewLabel_6 = new AppLabel("Ngày bắt đầu khuyến mãi");
		panel_info.add(lblNewLabel_6);
		
		startDay = new DatePickerComponent();
		panel_info.add(startDay); 
		
		AppLabel lblNewLabel_7 = new AppLabel("Ngày kết thúc khuyến mãi");
		panel_info.add(lblNewLabel_7);
		endDay = new DatePickerComponent(); 
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
		
		btn_deleteDiscount = new AppButton("XÓA");
		panel_button.add(btn_deleteDiscount);
		
		btn_saveDiscount = new AppButton("LƯU");
		panel_button.add(btn_saveDiscount);
		
		customerTypeList= new String[] {"ALL","MEMBERSHIP","VIP"};
		comboBox = new JComboBox<>(customerTypeList); 
		panel_info.add(comboBox); 

//		
	}
}
