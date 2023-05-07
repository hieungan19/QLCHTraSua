package globalComponent;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import constant.ConstantValueView;

public class AppLabel extends JLabel {
	
	public AppLabel(String text, int fontSize, Color fontColor,boolean isBold) {
		// TODO Auto-generated constructor stub
		this.setOpaque(false);
		this.setText(text);
		this.setFont(new Font("Arial", (isBold?Font.BOLD:Font.PLAIN), fontSize));
		this.setForeground(fontColor);
	}
	
	

	public AppLabel(String text) {
		// TODO Auto-generated constructor stub
		this.setOpaque(false);
		this.setText(text);
		this.setFont(new Font("Arial", Font.PLAIN, 16));
		this.setForeground(ConstantValueView.primaryDark);
	}
	

	public AppLabel(String text, int fontSize, boolean isBold) {
		// TODO Auto-generated constructor stub
		this.setOpaque(false);
		this.setText(text);
		this.setFont(new Font("Arial", (isBold?Font.BOLD:Font.PLAIN), fontSize));
		this.setForeground(ConstantValueView.primaryDark);
	}

	public AppLabel(String text,  Color fontColor) {
		this.setOpaque(false);
		// TODO Auto-generated constructor stub
		this.setText(text);
		this.setFont(new Font("Arial", Font.PLAIN, 16));
		this.setForeground(fontColor);
	}
	public AppLabel(String text, boolean isSmall) {
		this.setOpaque(false);
		this.setText(text);
		this.setFont(new Font("Arial", Font.PLAIN, 12));
		this.setForeground(ConstantValueView.primaryDark);
	}
}
