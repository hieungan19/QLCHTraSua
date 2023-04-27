package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import constant.ConstantValueView;

public class FilterMenuButton extends JButton{
	public FilterMenuButton(String filterText) {
		this.setText(filterText);
		this.setBounds(57, 341, 333, 47);
		this.setForeground(new Color(255, 250, 250));
		this.setFont(new Font("SansSerif", Font.BOLD, 20));
		this.setBorder(null);
		this.setBackground(ConstantValueView.btnColor);
	}

}
