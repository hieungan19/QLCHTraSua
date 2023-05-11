package view.employee;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import java.awt.GridBagLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

import constant.AppValues;
import constant.ConstantValueView;
import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppLineBorderTextField;
import globalComponent.DatePickerComponent;
import globalComponent.NumberSpinner;

import java.awt.Insets;

import java.awt.GridLayout;
import javax.swing.SpinnerNumberModel;

import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class EmployeeInfoFormPanel extends JPanel {
	public AppLineBorderTextField textField_name;
	public ButtonGroup genderButtonGroup;
	public DatePickerComponent datePicker_birth;
	public AppLineBorderTextField textField_ID;
	public AppLineBorderTextField textField_phone;
	public AppLineBorderTextField textField_address;
	public NumberSpinner spinner_salary;
	public JComboBox<String> comboBox;
	public AppButton btn_save;
	public AbstractButton btn_delete;
	public DatePickerComponent datePicker_start;
	public JRadioButton femaleRadioButton;
	public JRadioButton maleRadioButton;
	public AppLabel lbl_empID;
	public JPasswordField textField_password;
	public JPasswordField textField_confirm;
	public JPanel panel_account;
	public AppButton btn_attendance;
	public AppButton btn_getSalary;

	/**
	 * Create the panel.
	 */
	public EmployeeInfoFormPanel() {
		JPanel contentPanel = new JPanel();
		contentPanel.setSize(700, 630);
		contentPanel.setLocation(50, 20);
		this.setLayout(null);
		this.add(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 1, 700, 46);
		contentPanel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		AppLabel lblNewLabel = new AppLabel("THÔNG TIN NHÂN VIÊN",24,true);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbl_empID = new AppLabel("",16,true);
		GridBagConstraints gbc_lbl_empID = new GridBagConstraints();
		gbc_lbl_empID.gridx = 0;
		gbc_lbl_empID.gridy = 1;
		panel_1.add(lbl_empID, gbc_lbl_empID);
		
		JPanel panel_form = new JPanel();
		panel_form.setBounds(0, 52, 700, 394);
		contentPanel.add(panel_form);
		panel_form.setLayout(new GridLayout(9, 2, 0, 5));
		
		AppLabel lblNewLabel_1 = new AppLabel("New label");
		lblNewLabel_1.setText("Họ tên");
		panel_form.add(lblNewLabel_1);
		
		textField_name = new AppLineBorderTextField();
		panel_form.add(textField_name);
		textField_name.setColumns(10);
		
		AppLabel lblNewLabel_6 = new AppLabel("New label");
		lblNewLabel_6.setText("Số CCCD");
		panel_form.add(lblNewLabel_6);
		
		textField_ID = new AppLineBorderTextField();
		textField_ID.setColumns(10);
		panel_form.add(textField_ID);
		
		AppLabel lblNewLabel_3 = new AppLabel("New label");
		lblNewLabel_3.setText("Số điện thoại");
		panel_form.add(lblNewLabel_3);
		
		textField_phone = new AppLineBorderTextField();
		textField_phone.setColumns(10);
		panel_form.add(textField_phone);
		
		AppLabel lblNewLabel_8 = new AppLabel("Địa chỉ");
		panel_form.add(lblNewLabel_8);
		
		textField_address = new AppLineBorderTextField();
		textField_address.setColumns(10);
		panel_form.add(textField_address);
		
		AppLabel lblNewLabel_4 = new AppLabel("Ngày sinh");
		panel_form.add(lblNewLabel_4);
		
		datePicker_birth = new DatePickerComponent();
		panel_form.add(datePicker_birth);
		
		
		AppLabel lblNewLabel_2 = new AppLabel("New label");
		lblNewLabel_2.setText("Giới tính");
		panel_form.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel_form.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		genderButtonGroup = new ButtonGroup(); 
		 femaleRadioButton = new JRadioButton("NỮ");
		 femaleRadioButton.setSelected(true);
		 femaleRadioButton.setFont(ConstantValueView.normalText);
		 panel.add(femaleRadioButton);
		 genderButtonGroup.add(femaleRadioButton);
		
		 
		 maleRadioButton = new JRadioButton("NAM");
		 maleRadioButton.setFont(ConstantValueView.normalText);
		 panel.add(maleRadioButton);
		 genderButtonGroup.add(maleRadioButton);
		
		AppLabel lblNewLabel_7 = new AppLabel("New label");
		lblNewLabel_7.setText("Lương cơ bản");
		panel_form.add(lblNewLabel_7);
		
		spinner_salary = new NumberSpinner(new SpinnerNumberModel(0,0,1e6,1000));	
		panel_form.add(spinner_salary);
		
		AppLabel lblNewLabel_5 = new AppLabel("New label");
		lblNewLabel_5.setText("Ngày vào làm");
		panel_form.add(lblNewLabel_5);
	  
	   


	   datePicker_start = new DatePickerComponent();
	   panel_form.add(datePicker_start);
	   
	   AppLabel lblNewLabel_1_1 = new AppLabel("New label");
	   lblNewLabel_1_1.setText("Chức vụ");
	   panel_form.add(lblNewLabel_1_1);
	   
	  panel_account = new JPanel();
	  panel_account.setBounds(150, 451, 400, 120);
	   panel_account.setPreferredSize(new Dimension(400, 120));
	   contentPanel.add(panel_account);
	   panel_account.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u1EA1o t\u00E0i kho\u1EA3n", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
	   panel_account.setLayout(new GridLayout(0, 2, 10, 5));
	   
	   AppLabel lblNewLabel_9 = new AppLabel("Nhập mật khẩu");
	   panel_account.add(lblNewLabel_9);
	   
	   textField_password = new JPasswordField();
	   panel_account.add(textField_password);
	   textField_password.setColumns(10);
	   
	   AppLabel lblNewLabel_10 = new AppLabel("Xác thực mật khẩu");
	   panel_account.add(lblNewLabel_10);
	   
	   textField_confirm = new JPasswordField();
	   panel_account.add(textField_confirm);
	   textField_confirm.setColumns(10);
	   
	
	   
	   
	   JPanel panel_3 = new JPanel();
	   panel_3.setBounds(0, 576, 700, 53);
	   FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
	   flowLayout.setAlignment(FlowLayout.TRAILING);
	   contentPanel.add(panel_3);
	  
	   btn_attendance = new AppButton("CHẤM CÔNG");
	  btn_attendance.setPreferredSize(new Dimension(120, 30));
	  panel_3.add(btn_attendance);
	  
	  btn_getSalary = new AppButton("TÍNH LƯƠNG");
	  btn_getSalary.setPreferredSize(new Dimension(120, 30));
	  panel_3.add(btn_getSalary);
	 
	   
	  btn_delete = new AppButton("New button");
	   btn_delete.setText("XÓA");
	   panel_3.add(btn_delete);
	   
	   btn_save = new AppButton("New button");
	   btn_save.setText("LƯU");
	   panel_3.add(btn_save);
	   
 
	   comboBox = new JComboBox<String>(AppValues.positionList); 
	   panel_form.add(comboBox);
	}
}
