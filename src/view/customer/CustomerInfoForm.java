package view.customer;

import javax.swing.JPanel;

import globalComponent.AppLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.GridLayout;
import globalComponent.AppLineBorderTextField;
import model.CustomerModel;
import globalComponent.AppButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;


public class CustomerInfoForm extends JPanel {
	public AppLineBorderTextField textField_phoneNumber;
	public AppLineBorderTextField textField_name;
	public AppLabel lblNewLabel_point;
	public AppButton btnDelete;
	public AppButton btnSave;
	public AppLabel lblNewLabel_level;
	public CustomerModel model;
	public AppLabel lblNewLabel_customerID;
	public AppLabel lblNewLabel_registrationDate;
	

	/**
	 * Create the panel.
	 */
	public CustomerInfoForm(CustomerModel model) {
		this.model = model; 
		btnSave = new AppButton("LƯU");
		btnDelete = new AppButton("XÓA");
		
		JPanel contentPanel = new JPanel();
		contentPanel.setSize(600, 630);
		contentPanel.setLocation(110, 20);
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
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setHgap(10);
		panel.add(panel_2);
		
		AppLabel lblMKhchHng = new AppLabel("Mã khách hàng: ");
		panel_2.add(lblMKhchHng);
		
		lblNewLabel_customerID = new AppLabel("", 16, true);
		panel_2.add(lblNewLabel_customerID);
		
		AppLabel lblNewLabel_3 = new AppLabel("Ngày đăng kí:");
		lblNewLabel_3.setText("- Ngày đăng kí:");
		panel_2.add(lblNewLabel_3);
		
		 lblNewLabel_registrationDate = new AppLabel("");
		panel_2.add(lblNewLabel_registrationDate);
		
		JPanel panel_info = new JPanel();
		GridBagConstraints gbc_panel_info = new GridBagConstraints();
		gbc_panel_info.insets = new Insets(0, 0, 5, 0);
		gbc_panel_info.fill = GridBagConstraints.BOTH;
		gbc_panel_info.gridx = 0;
		gbc_panel_info.gridy = 1;
		contentPanel.add(panel_info, gbc_panel_info);
		panel_info.setLayout(new GridLayout(5, 0, 0, 10));
		
		AppLabel lblNewLabel_1 = new AppLabel("Họ tên khách hàng");
		panel_info.add(lblNewLabel_1);
		
		textField_name = new AppLineBorderTextField();
		if (model!=null) textField_name.setText(model.getName());
		panel_info.add(textField_name);
		textField_name.setColumns(10);
		
		AppLabel lblNewLabel_2 = new AppLabel("Số điện thoại");
		panel_info.add(lblNewLabel_2);
		
		textField_phoneNumber = new AppLineBorderTextField();
		if (model!=null) textField_phoneNumber.setText(model.getPhoneNumber());
		panel_info.add(textField_phoneNumber);
		textField_phoneNumber.setColumns(10);
		
		
		AppLabel lblNewLabel_5 = new AppLabel("Loại khách hàng:");
		panel_info.add(lblNewLabel_5);
		
		lblNewLabel_level = new AppLabel("MEMBERSHIP");
		panel_info.add(lblNewLabel_level);
		
		
		AppLabel lblNewLabel_4 = new AppLabel("Điểm thưởng: ");
		panel_info.add(lblNewLabel_4);
		
		lblNewLabel_point = new AppLabel("0");
		if (model!=null) lblNewLabel_point.setText(model.getPoint()+"");
		panel_info.add(lblNewLabel_point);
		
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
		

		panel_1.add(btnDelete);

	
		panel_1.add(btnSave);
		
	}
}
