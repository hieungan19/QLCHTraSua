package globalComponent;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import constant.ConstantValueView;

public class AppTextField extends JTextField{
	public AppTextField(String text) {
		setFont(ConstantValueView.normalText);
		Font font = new Font("Arial", Font.PLAIN, 16);
		this.setOpaque(false);
		this.setColumns(10);
		this.setBorder(new TitledBorder(new MatteBorder(0, 0, 2, 0,ConstantValueView.primaryDark ),
				text, TitledBorder.LEADING, TitledBorder.TOP, null, ConstantValueView.primaryDark));
		((TitledBorder) this.getBorder()).setTitleFont(font);
		// TODO Auto-generated constructor stub
	}
	
}
