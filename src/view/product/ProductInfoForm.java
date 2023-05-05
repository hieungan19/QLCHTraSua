package view.product;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import constant.ConstantValueView;
import diaglog.AppOptionPaneDialog;
import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppTextField;
import globalComponent.DatePickerComponent;
import globalComponent.NumberSpinner;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;


public class ProductInfoForm extends JPanel {

	public ProductInfoForm () {
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(20, 20, 790, 630);
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
		
		AppLabel lblNewLabel_ID = new AppLabel("MÃ SẢN PHẨM : ",16,true);
		GridBagConstraints gbc_lblNewLabel_ID = new GridBagConstraints();
		gbc_lblNewLabel_ID.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_ID.gridx = 0;
		gbc_lblNewLabel_ID.gridy = 0;
		panel_imagePicker.add(lblNewLabel_ID, gbc_lblNewLabel_ID);
		
		JEditorPane jeditorPane_image = new JEditorPane();
		jeditorPane_image.setPreferredSize(new Dimension(200, 200));
		GridBagConstraints gbc_jeditorPane_image = new GridBagConstraints();
		gbc_jeditorPane_image.insets = new Insets(0, 0, 5, 0);
		gbc_jeditorPane_image.weighty = 1.0;
		gbc_jeditorPane_image.gridx = 0;
		gbc_jeditorPane_image.gridy = 1;
		panel_imagePicker.add(jeditorPane_image, gbc_jeditorPane_image);
		jeditorPane_image.setForeground(Color.BLACK);
		jeditorPane_image.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		AppButton jbutton_chooseFile = new AppButton("Chọn file");
		
		GridBagConstraints gbc_jbutton_chooseFile = new GridBagConstraints();
		gbc_jbutton_chooseFile.anchor = GridBagConstraints.NORTH;
		gbc_jbutton_chooseFile.weighty = 1.0;
		gbc_jbutton_chooseFile.gridx = 0;
		gbc_jbutton_chooseFile.gridy = 2;
		panel_imagePicker.add(jbutton_chooseFile, gbc_jbutton_chooseFile);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.weightx = 1.0;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		panel_form.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(8, 0, 0, 20));
		
		AppTextField jTextField_nameItem = new AppTextField("Tên mặt hàng");
		jTextField_nameItem.setToolTipText("tên");
		panel_2.add(jTextField_nameItem);
		
		AppTextField jTextField_desItem = new AppTextField("Mô tả");
		jTextField_desItem.setToolTipText("option");
		jTextField_desItem.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel_2.add(jTextField_desItem);
		
		SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 100, 1);
		
		JPanel panel_unit = new JPanel();
		panel_2.add(panel_unit);
		panel_unit.setLayout(new BoxLayout(panel_unit, BoxLayout.X_AXIS));
		
		JLabel jLabel_unitItem = new JLabel("Đơn vị tính");
		jLabel_unitItem.setPreferredSize(new Dimension(100, 13));
		panel_unit.add(jLabel_unitItem);
		jLabel_unitItem.setForeground(new Color(80, 43, 15));
		jLabel_unitItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JComboBox<String> comboBox_unitItem = new JComboBox<String>();
		comboBox_unitItem.setBorder(new LineBorder(ConstantValueView.primaryColor, 2));
		comboBox_unitItem.setName("Đơn vị tính");
		comboBox_unitItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_unitItem.setBackground(Color.WHITE);
		panel_unit.add(comboBox_unitItem);
		
		JPanel panel_quantity = new JPanel();
		panel_2.add(panel_quantity);
		panel_quantity.setLayout(new BoxLayout(panel_quantity, BoxLayout.X_AXIS));
		
		AppLabel lblNewLabel_3 = new AppLabel("Số lượng");
		lblNewLabel_3.setPreferredSize(new Dimension(100, 19));
		panel_quantity.add(lblNewLabel_3);
		NumberSpinner spinner_quantity = new NumberSpinner(model);
		panel_quantity.add(spinner_quantity); 
		
		JPanel panel_date = new JPanel();
		panel_2.add(panel_date);
		panel_date.setLayout(new BoxLayout(panel_date, BoxLayout.X_AXIS));
		
		AppLabel lblNewLabel_1 = new AppLabel("Ngày nhập");
		lblNewLabel_1.setPreferredSize(new Dimension(100, 19));
		panel_date.add(lblNewLabel_1);
		
		DatePickerComponent datePicker = new DatePickerComponent();
		panel_date.add(datePicker);
		
		JPanel panel_button = new JPanel();
		GridBagConstraints gbc_panel_button = new GridBagConstraints();
		gbc_panel_button.gridx = 1;
		gbc_panel_button.gridy = 1;
		panel_form.add(panel_button, gbc_panel_button);
		FlowLayout fl_panel_button = (FlowLayout) panel_button.getLayout();
		fl_panel_button.setHgap(55);
		fl_panel_button.setAlignment(FlowLayout.RIGHT);
		
		AppButton jbutton_deleteItem = new AppButton("XÓA");
		panel_button.add(jbutton_deleteItem); 
		
		AppButton jbutton_saveItem = new AppButton("LƯU");
		panel_button.add(jbutton_saveItem);


		this.setVisible(true); 
	}
}