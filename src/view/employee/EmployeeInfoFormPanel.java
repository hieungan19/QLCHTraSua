package view.employee;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

import constant.ConstantValueView;
import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppLineBorderTextField;
import globalComponent.AppTextField;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JTextField;

import java.awt.FlowLayout;

public class EmployeeInfoFormPanel extends JPanel {
	private AppLineBorderTextField textField;
	private ButtonGroup genderButtonGroup;

	/**
	 * Create the panel.
	 */
	public EmployeeInfoFormPanel() {
		setLayout(null);
		
		
		
		JPanel panel_info = new JPanel();
		panel_info.setBounds(54, 22, 552, 475);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0};
		panel_info.setLayout(gridBagLayout);
		this.add(panel_info); 
		
		
		AppLabel lblNewLabel = new AppLabel("THÔNG TIN NHÂN VIÊN",24,true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.weightx = 1.0;
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_info.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_form = new JPanel();
		GridBagConstraints gbc_panel_form = new GridBagConstraints();
		gbc_panel_form.weighty = 10.0;
		gbc_panel_form.insets = new Insets(0, 0, 5, 0);
		gbc_panel_form.fill = GridBagConstraints.BOTH;
		gbc_panel_form.gridx = 0;
		gbc_panel_form.gridy = 1;
		panel_info.add(panel_form, gbc_panel_form);
		panel_form.setLayout(new GridLayout(9, 2, 0, 5));
		
		AppLabel lblNewLabel_1 = new AppLabel("New label");
		lblNewLabel_1.setText("Họ tên");
		panel_form.add(lblNewLabel_1);
		
		textField = new AppLineBorderTextField();
		panel_form.add(textField);
		textField.setColumns(10);
		
		AppLabel lblNewLabel_3 = new AppLabel("New label");
		lblNewLabel_3.setText("Số điện thoại");
		panel_form.add(lblNewLabel_3);
		
		AppLineBorderTextField textField_1 = new AppLineBorderTextField();
		textField_1.setColumns(10);
		panel_form.add(textField_1);
		
		AppLabel lblNewLabel_6 = new AppLabel("New label");
		lblNewLabel_6.setText("Số CCCD");
		panel_form.add(lblNewLabel_6);
		
		AppLineBorderTextField textField_3 = new AppLineBorderTextField();
		textField_3.setColumns(10);
		panel_form.add(textField_3);
		
		AppLabel lblNewLabel_2 = new AppLabel("New label");
		lblNewLabel_2.setText("Giới tính");
		panel_form.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel_form.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		genderButtonGroup = new ButtonGroup(); 
		 JRadioButton femaleRadioButton = new JRadioButton("Female");
		 femaleRadioButton.setFont(ConstantValueView.normalText);
		 panel.add(femaleRadioButton);
		 genderButtonGroup.add(femaleRadioButton);
		
		 
		 JRadioButton maleRadioButton = new JRadioButton("Male");
		 maleRadioButton.setFont(ConstantValueView.normalText);
		 panel.add(maleRadioButton);
		 genderButtonGroup.add(maleRadioButton);
		
		AppLabel lblNewLabel_4 = new AppLabel("New label");
		lblNewLabel_4.setText("Email");
		panel_form.add(lblNewLabel_4);
		
		AppLineBorderTextField textField_2 = new AppLineBorderTextField();
		textField_2.setColumns(10);
		panel_form.add(textField_2);
		
		AppLabel lblNewLabel_7 = new AppLabel("New label");
		lblNewLabel_7.setText("Lương cơ bản");
		panel_form.add(lblNewLabel_7);
		
		AppLineBorderTextField textField_4 = new AppLineBorderTextField();
		textField_4.setColumns(10);
		panel_form.add(textField_4);
		
		AppLabel lblNewLabel_5 = new AppLabel("New label");
		lblNewLabel_5.setText("Ngày vào làm");
		panel_form.add(lblNewLabel_5);
	  
	   


	   DatePickerComponent startWorkingDay = new DatePickerComponent();
	   panel_form.add(startWorkingDay); 
	   
	   AppLabel lblNewLabel_8 = new AppLabel("Địa chỉ");
	   panel_form.add(lblNewLabel_8);
	   
	   AppLineBorderTextField textField_4_1 = new AppLineBorderTextField();
	   textField_4_1.setColumns(10);
	   panel_form.add(textField_4_1);
	   
	   AppLabel lblNewLabel_1_1 = new AppLabel("New label");
	   lblNewLabel_1_1.setText("Chức vụ");
	   panel_form.add(lblNewLabel_1_1);
	   
	   JPanel panel_2 = new JPanel();
	   panel_form.add(panel_2);
	   panel_2.setLayout(new GridLayout(0, 3, 10, 0));
	   
	   
	   JPanel panel_3 = new JPanel();
	   FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
	   flowLayout.setAlignment(FlowLayout.TRAILING);
	   GridBagConstraints gbc_panel_3 = new GridBagConstraints();
	   gbc_panel_3.insets = new Insets(0, 0, 5, 0);
	   gbc_panel_3.fill = GridBagConstraints.BOTH;
	   gbc_panel_3.gridx = 0;
	   gbc_panel_3.gridy = 2;
	   panel_info.add(panel_3, gbc_panel_3);
	   
	   AppButton btnNewButton_delete = new AppButton("New button");
	   btnNewButton_delete.setText("SỬA");
	   panel_3.add(btnNewButton_delete);
	   
	   AppButton btnNewButton_update = new AppButton("New button");
	   btnNewButton_update.setText("XÓA");
	   panel_3.add(btnNewButton_update);
	   
	   AppButton btnNewButton_add = new AppButton("New button");
	   btnNewButton_add.setText("THÊM");
	   panel_3.add(btnNewButton_add);
	   
	   String[] options = {"Option 1", "Option 2", "Option 3"};

       // Tạo dropdown list và đặt giá trị mặc định
       JComboBox<String> comboBox = new JComboBox<>(options);
       comboBox.setSelectedIndex(0);

       // Tạo trường văn bản để cho phép thêm tùy chọn mới
       textField = new AppLineBorderTextField();

       // Tạo nút để thêm tùy chọn mới
       JButton addButton = new JButton("Add");
       addButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String newOption = textField.getText();
            if (!newOption.isEmpty()) {
                comboBox.addItem(newOption);
                comboBox.setSelectedIndex(comboBox.getItemCount()-1);
                textField.setText("");
            }
		}
       }); 
	}

}