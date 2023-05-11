package view.employee;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import constant.ConstantValueView;
import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppLineBorderTextField;
import globalComponent.DatePickerComponent;
import globalComponent.NumberSpinner;
import model.EmployeeModel;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants;


public class CalculateSalaryDialog extends JDialog {

	public final JPanel contentPanel = new JPanel();
	public NumberSpinner spinner_bonus;
	public DatePickerComponent endDate;
	public DatePickerComponent startDate;
	public AppLabel lbl_total;
	public AppLabel lbl_penalty;
	public AppLabel lbl_baseSalary;
	public AppButton btn_ok;
	public AppLabel lbl_hours;
	public AppButton btn_cancel;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public CalculateSalaryDialog() {
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
			
			btn_ok = new AppButton("OK");
			buttonPane.add(btn_ok);
			{
				 btn_cancel = new AppButton("Cancel");
				btn_cancel.setActionCommand("Cancel");
				buttonPane.add(btn_cancel);
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
					panel_1_1.setBounds(10, 10, 416, 121);
					panel_1_1.setPreferredSize(new Dimension(200, 10));
					panel_1.add(panel_1_1);
					panel_1_1.setLayout(new GridLayout(2, 2, 0, 5));
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
							startDate = new DatePickerComponent();
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
							
							endDate = new DatePickerComponent();
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
					panel_2.setLayout(new GridLayout(5, 0, 0, 0));
					
					AppLabel lblNewLabel_1 = new AppLabel("Số giờ làm:");
					panel_2.add(lblNewLabel_1);
					
					lbl_hours = new AppLabel("");
					panel_2.add(lbl_hours);
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
							lbl_baseSalary = new AppLabel("LƯƠNG",16,true);
							lbl_baseSalary.setText("");
							panel_3.add(lbl_baseSalary);
						}
					}
					{
						AppLabel lblNewLabel_penaltyForMisconduct = new AppLabel("Tiền trừ do sai phạm");
						lblNewLabel_penaltyForMisconduct.setText("Tiền trừ do sai phạm:");
						panel_2.add(lblNewLabel_penaltyForMisconduct);
					}
					{
						lbl_penalty = new AppLabel("TRỪ",16,true);
						lbl_penalty.setText("");
						panel_2.add(lbl_penalty);
					}
					{
						AppLabel lblNewLabel_bonus = new AppLabel("Tiền thưởng");
						panel_2.add(lblNewLabel_bonus);
						lblNewLabel_bonus.setText("Tiền thưởng:");
					}
					{
						spinner_bonus = new NumberSpinner(new SpinnerNumberModel(0.0, 0.0, 1e8, 1000)); 
			
						panel_2.add(spinner_bonus);
					
					}
					{
						AppLabel lblNewLabel_total = new AppLabel("Tổng cộng",16,true);
						lblNewLabel_total.setText("Tổng cộng:");
						lblNewLabel_total.setHorizontalAlignment(SwingConstants.LEFT);
						panel_2.add(lblNewLabel_total);
					}
					{
						lbl_total = new AppLabel("",16,true);
						panel_2.add(lbl_total);
					}
				}
			}
		}
	}
}
