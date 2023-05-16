package view.inventory;



import javax.swing.JPanel;

import globalComponent.AppLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

import constant.AppValues;

import java.awt.Insets;
import java.awt.GridLayout;
import globalComponent.AppLineBorderTextField;
import globalComponent.NumberSpinner;
import model.CustomerModel;
import model.IngredientModel;
import globalComponent.AppButton;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


public class IngredientInfoForm extends JPanel {
	public AppLineBorderTextField textField_name;
	public AppButton btnDelete;
	public AppButton btnSave;
	public IngredientModel model;

	public NumberSpinner spinner_price;
	public NumberSpinner spinner_amount;
	public AppLabel lblNewLabel_ingredientID;
	public JComboBox comboBox_unit;

	

	/**
	 * Create the panel.
	 */
	public IngredientInfoForm(IngredientModel model) {
		this.model = model; 
		btnSave = new AppButton("LƯU");
		btnDelete = new AppButton("XÓA");
		lblNewLabel_ingredientID = new AppLabel("", 16, true);
		
		
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
		lblNewLabel.setText("THÔNG TIN NGUYÊN LIỆU");
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setHgap(10);
		panel.add(panel_2);
		
		AppLabel lblMKhchHng = new AppLabel("Mã khách hàng: ");
		lblMKhchHng.setText("Mã nguyên liệu:");
		panel_2.add(lblMKhchHng);
		
		
		panel_2.add(lblNewLabel_ingredientID);
		
		JPanel panel_info = new JPanel();
		GridBagConstraints gbc_panel_info = new GridBagConstraints();
		gbc_panel_info.insets = new Insets(0, 0, 5, 0);
		gbc_panel_info.fill = GridBagConstraints.BOTH;
		gbc_panel_info.gridx = 0;
		gbc_panel_info.gridy = 1;
		contentPanel.add(panel_info, gbc_panel_info);
		panel_info.setLayout(new GridLayout(5, 0, 0, 10));
		
		AppLabel lblNewLabel_1 = new AppLabel("Họ tên khách hàng");
		lblNewLabel_1.setText("Tên nguyên liệu");
		panel_info.add(lblNewLabel_1);
		
		textField_name = new AppLineBorderTextField();
		
		panel_info.add(textField_name);
		textField_name.setColumns(10);
	
		
		
		AppLabel lblNewLabel_5 = new AppLabel("Loại khách hàng:");
		lblNewLabel_5.setText("Đơn vị");
		panel_info.add(lblNewLabel_5);
		
		comboBox_unit = new JComboBox<>(AppValues.unit);
		panel_info.add(comboBox_unit);
		
		
		AppLabel lblNewLabel_2 = new AppLabel("Số điện thoại");
		lblNewLabel_2.setText("Giá/đơn vị");
		panel_info.add(lblNewLabel_2);
		
		spinner_price = new NumberSpinner(new SpinnerNumberModel(0, 0,1e9, 1000)); 
		panel_info.add(spinner_price);
		
		
		AppLabel lblNewLabel_4 = new AppLabel("Điểm thưởng: ");
		lblNewLabel_4.setText("Số lượng");
		panel_info.add(lblNewLabel_4);
		
		spinner_amount = new NumberSpinner(new SpinnerNumberModel(0, 0, 1e9, 1)); 
		panel_info.add(spinner_amount); 
		
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
