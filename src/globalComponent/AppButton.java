package globalComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

import constant.ConstantValueView;

public class AppButton extends JButton{
	public AppButton(String text) {
		this.setText(text);
		this.setBorderPainted(false);
		this.setPreferredSize(new Dimension(100,30));
		this.setForeground(ConstantValueView.background);
		this.setFont(new Font("SansSerif", Font.BOLD, 16));
		this.setBorder(null);
		this.setBackground(ConstantValueView.btnColor);
		// TODO Auto-generated constructor stub
	}
}
