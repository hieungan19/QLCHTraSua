package view.product;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import javax.swing.JEditorPane;
import javax.swing.JPanel;


import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppLineBorderTextField;
import globalComponent.AppTextField;
import globalComponent.NumberSpinner;

import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;


public class ProductInfoForm extends JPanel {
	public AppLineBorderTextField textField_type;
	public AppButton btn_chooseFile;
	public JEditorPane editorPane_image;
	public ChooseIngredientPanel chooseIngredientPanel;
	public AppButton btn_saveProduct;
	public AppLineBorderTextField textField_name;
	public NumberSpinner spinner_price;
	public String imageUri;
	public AppButton btn_deleteProduct;
	public AppLabel lblNewLabel_ID; 
	

	public ProductInfoForm () {
		lblNewLabel_ID = new AppLabel("",16,true);
		btn_deleteProduct = new AppButton("XÓA");
		btn_saveProduct = new AppButton("LƯU");
		btn_chooseFile = new AppButton("Chọn file");
		editorPane_image = new JEditorPane(); 
		editorPane_image.setEditable(false);
		editorPane_image.setContentType("text/html");
		spinner_price = new NumberSpinner(new SpinnerNumberModel(0, 0, 1e9, 5000));
		
		chooseIngredientPanel = new ChooseIngredientPanel(); 
		chooseIngredientPanel.setVisible(false); 
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(0, 20, 790, 630);
		this.setLayout(null);
		this.add(contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		
		AppLabel lblNewLabel = new AppLabel("THÔNG TIN SẢN PHẨM",24, true);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weighty = 2.0;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_form = new JPanel();
		GridBagConstraints gbc_panel_form = new GridBagConstraints();
		gbc_panel_form.insets = new Insets(0, 0, 5, 0);
		gbc_panel_form.weighty = 1.0;
		gbc_panel_form.fill = GridBagConstraints.BOTH;
		gbc_panel_form.gridx = 0;
		gbc_panel_form.gridy = 1;
		contentPanel.add(panel_form, gbc_panel_form);
		GridBagLayout gbl_panel_form = new GridBagLayout();
		gbl_panel_form.columnWidths = new int[] {250, 350};
		gbl_panel_form.rowHeights = new int[]{445, 0, 0};
		gbl_panel_form.columnWeights = new double[]{0.0, 0.0};
		gbl_panel_form.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_form.setLayout(gbl_panel_form);
		
		JPanel panel_imagePicker = new JPanel();
		GridBagConstraints gbc_panel_imagePicker = new GridBagConstraints();
		gbc_panel_imagePicker.fill = GridBagConstraints.BOTH;
		gbc_panel_imagePicker.insets = new Insets(0, 0, 5, 5);
		gbc_panel_imagePicker.gridx = 0;
		gbc_panel_imagePicker.gridy = 0;
		panel_form.add(panel_imagePicker, gbc_panel_imagePicker);
		GridBagLayout gbl_panel_imagePicker = new GridBagLayout();
		gbl_panel_imagePicker.columnWidths = new int[]{395, 0};
		gbl_panel_imagePicker.rowHeights = new int[] {0};
		gbl_panel_imagePicker.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_imagePicker.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel_imagePicker.setLayout(gbl_panel_imagePicker);
		
		
		GridBagConstraints gbc_lblNewLabel_ID = new GridBagConstraints();
		gbc_lblNewLabel_ID.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_ID.gridx = 0;
		gbc_lblNewLabel_ID.gridy = 0;
		panel_imagePicker.add(lblNewLabel_ID, gbc_lblNewLabel_ID);
		
		
		editorPane_image.setPreferredSize(new Dimension(200, 200));
		GridBagConstraints gbc_editorPane_image = new GridBagConstraints();
		gbc_editorPane_image.insets = new Insets(0, 0, 5, 0);
		gbc_editorPane_image.weighty = 1.0;
		gbc_editorPane_image.gridx = 0;
		gbc_editorPane_image.gridy = 1;
		panel_imagePicker.add(editorPane_image, gbc_editorPane_image);
		editorPane_image.setForeground(Color.BLACK);
		editorPane_image.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		
		GridBagConstraints gbc_btn_chooseFile = new GridBagConstraints();
		gbc_btn_chooseFile.anchor = GridBagConstraints.NORTH;
		gbc_btn_chooseFile.weighty = 1.0;
		gbc_btn_chooseFile.gridx = 0;
		gbc_btn_chooseFile.gridy = 2;
		panel_imagePicker.add(btn_chooseFile, gbc_btn_chooseFile);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.weightx = 1.0;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		panel_form.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{390, 0};
		gbl_panel_2.rowHeights = new int[]{46, 46, 46, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel_2.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		AppLabel lblNewLabel_1 = new AppLabel("Tên sản phẩm");
		panel_1.add(lblNewLabel_1);
		textField_name = new AppLineBorderTextField();
		panel_1.add(textField_name);
		
		
		textField_name.setToolTipText("tên");
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		panel_2.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		AppLabel lblNewLabel_2 = new AppLabel("Loại sản phẩm");
		panel_3.add(lblNewLabel_2);
		textField_type = new AppLineBorderTextField();
		panel_3.add(textField_type);
		textField_type.setColumns(10);
		
		JPanel panel_price = new JPanel();
		GridBagConstraints gbc_panel_price = new GridBagConstraints();
		gbc_panel_price.insets = new Insets(0, 0, 5, 0);
		gbc_panel_price.fill = GridBagConstraints.BOTH;
		gbc_panel_price.gridx = 0;
		gbc_panel_price.gridy = 2;
		panel_2.add(panel_price, gbc_panel_price);
		panel_price.setLayout(new GridLayout(0, 2, 0, 0));
		
		AppLabel lblNewLabel_3 = new AppLabel("Giá");
		lblNewLabel_3.setPreferredSize(new Dimension(100, 19));
		panel_price.add(lblNewLabel_3);
		panel_price.add(spinner_price);
		
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		panel_2.add(panel, gbc_panel);
		
	
		
		JPanel panel_button = new JPanel();
		GridBagConstraints gbc_panel_button = new GridBagConstraints();
		gbc_panel_button.gridx = 1;
		gbc_panel_button.gridy = 1;
		panel_form.add(panel_button, gbc_panel_button);
		FlowLayout fl_panel_button = (FlowLayout) panel_button.getLayout();
		fl_panel_button.setHgap(55);
		fl_panel_button.setAlignment(FlowLayout.RIGHT);
		
	
		panel_button.add(btn_deleteProduct); 
	
		panel_button.add(btn_saveProduct);
		panel.setLayout(new GridLayout(0, 1, 0, 0));


		
		panel.add(chooseIngredientPanel); 
		this.setVisible(true); 
	}
}