package view.employee;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constant.ConstantValueView;
import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppLineBorderTextField;
import model.EmployeeModel;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class CalculateSalaryDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private AppLineBorderTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CalculateSalaryDialog dialog = new CalculateSalaryDialog(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CalculateSalaryDialog(EmployeeModel employeeModel) {
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(ConstantValueView.background);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			JLabel lblNewLabel = new AppLabel("THÔNG TIN LƯƠNG", 24, true);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(ConstantValueView.background);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				AppButton cancelButton = new AppButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(ConstantValueView.background);
			getContentPane().add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(ConstantValueView.background);
				panel_1.setLayout(null);
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.weighty = 2.0;
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.insets = new Insets(0, 0, 5, 0);
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = 0;
				panel.add(panel_1, gbc_panel_1);
				{
					JPanel panel_1_1 = new JPanel();
					panel_1_1.setBounds(10, 10, 416, 145);
					panel_1_1.setPreferredSize(new Dimension(200, 10));
					panel_1.add(panel_1_1);
					panel_1_1.setLayout(new GridLayout(5, 2, 0, 5));
					{
						AppLabel lblNewLabel_employeeID = new AppLabel("Mã nhân viên:");
						panel_1_1.add(lblNewLabel_employeeID);
					}
					{
						AppLabel lblNewLabel_employeeName = new AppLabel("Tên nhân viên: ");
						panel_1_1.add(lblNewLabel_employeeName);
					}
					{
						AppLabel lblNewLabel_employeePosition = new AppLabel("Chức vụ: ");
						panel_1_1.add(lblNewLabel_employeePosition);
					}
					{
						JPanel panel_2 = new JPanel();
						panel_1_1.add(panel_2);
						panel_2.setLayout(new GridLayout(0, 2, 0, 0));
						{
							AppLabel lblNewLabel_3 = new AppLabel("Ngày bắt đầu: ");
							panel_2.add(lblNewLabel_3);
						}
						panel_1_1.add(panel_2);
						{
							DatePickerComponent startDate = new DatePickerComponent();
							panel_2.add(startDate); 
						}
					}
					{
						JPanel panel_2 = new JPanel();
						panel_1_1.add(panel_2);
						panel_2.setLayout(new GridLayout(0, 2, 0, 0));
						{
							AppLabel lblNewLabel_4 = new AppLabel("Ngày kết thúc: ");
							panel_2.add(lblNewLabel_4);
							
							DatePickerComponent endDate = new DatePickerComponent();
							panel_2.add(endDate); 
						}
					}
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(ConstantValueView.background);
				panel_1.setLayout(null);
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.weighty = 2.0;
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = 1;
				panel.add(panel_1, gbc_panel_1);
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBounds(10, 0, 416, 174);
					panel_1.add(panel_2);
					panel_2.setLayout(new GridLayout(4, 0, 0, 0));
					{
						AppLabel lblNewLabel_baseSalary = new AppLabel("Lương cơ bản");
						lblNewLabel_baseSalary.setText("Lương cơ bản:");
						panel_2.add(lblNewLabel_baseSalary);
					}
					{
						JPanel panel_3 = new JPanel();
						panel_2.add(panel_3);
						panel_3.setLayout(new GridLayout(1, 1, 0, 0));
						{
							AppLabel lblNewLabel_bonus = new AppLabel("Tiền thưởng");
							panel_3.add(lblNewLabel_bonus);
							lblNewLabel_bonus.setText("Tiền thưởng:");
						}
						{
							textField = new AppLineBorderTextField();
						
							panel_3.add(textField);
							textField.setColumns(10);
						}
					}
					{
						AppLabel lblNewLabel_penaltyForMisconduct = new AppLabel("Tiền trừ do sai phạm");
						lblNewLabel_penaltyForMisconduct.setText("Tiền trừ do sai phạm:");
						panel_2.add(lblNewLabel_penaltyForMisconduct);
					}
					{
						AppLabel lblNewLabel_total = new AppLabel("Tổng cộng",16,true);
						lblNewLabel_total.setText("Tổng cộng:");
						lblNewLabel_total.setHorizontalAlignment(SwingConstants.TRAILING);
						panel_2.add(lblNewLabel_total);
					}
				}
			}
		}
	}
}
