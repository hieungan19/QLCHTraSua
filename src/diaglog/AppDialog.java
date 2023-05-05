package diaglog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import globalComponent.AppButton;
import globalComponent.AppLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class AppDialog extends JDialog {
	public AppButton okButton;
	public AppButton cancelButton; 
	private final JPanel contentPanel = new JPanel();

	public AppDialog(String text) {
		this.setLocationRelativeTo(null);
		this.setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setSize(new Dimension(400,200));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
		{
			AppLabel lblNewLabel = new AppLabel(text);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new AppButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new AppButton("CANCEL");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
