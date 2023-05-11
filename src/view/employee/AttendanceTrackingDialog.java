package view.employee;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.NumberSpinner;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.LineBorder;

import constant.ConstantValueView;

public class AttendanceTrackingDialog extends JDialog {

	public final JPanel contentPanel = new JPanel();
	public JTextField textField;
	public TimePickerComponent startTime;
	public TimePickerComponent endTime;
	public NumberSpinner spinner_penalty;
	public AppButton okButton;
	public AppButton cancelButton;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			AttendanceTrackingDialog dialog = new AttendanceTrackingDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public AttendanceTrackingDialog() {
		setBackground(Color.WHITE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		FlowLayout fl_contentPanel = new FlowLayout();
		contentPanel.setLayout(fl_contentPanel);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			AppLabel lblNewLabel_3 = new AppLabel("CHẤM CÔNG", 24, true);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel,BorderLayout.CENTER);
			panel.setLayout(new GridLayout(3, 2, -40, 20));
			{
				AppLabel lblNewLabel = new AppLabel("New label");
				lblNewLabel.setText("Thời gian bắt đầu");
				panel.add(lblNewLabel);
			}
			
			startTime = new TimePickerComponent();
			startTime.setBorder(new LineBorder(ConstantValueView.primaryColor,2));
			startTime.setPreferredSize(new Dimension(50, 40));
			panel.add(startTime); 
			{
				AppLabel lblNewLabel_2 = new AppLabel("New label");
				lblNewLabel_2.setText("Thời gian kết thúc");
				panel.add(lblNewLabel_2);
			}
			{
				endTime = new TimePickerComponent();
				endTime.setBorder(new LineBorder(ConstantValueView.primaryColor, 2));
				endTime.setPreferredSize(new Dimension(50, 40));
				panel.add(endTime);
			}
			{
				AppLabel lblNewLabel_1 = new AppLabel("New label");
				lblNewLabel_1.setText("Tiền trừ");
				panel.add(lblNewLabel_1);
			}
			{
				 spinner_penalty = new NumberSpinner(new SpinnerNumberModel(0.0, 0.0, 1e8, 1000)); 
			
				panel.add(spinner_penalty);
				
			}
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new AppButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new AppButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.WEST);
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.EAST);
		}
	}

}
