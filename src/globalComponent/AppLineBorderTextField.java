package globalComponent;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import constant.ConstantValueView;

public class AppLineBorderTextField  extends JTextField{
	
	public AppLineBorderTextField() {
		super();
		this.setFont(ConstantValueView.normalText);
		this.setBorder(new LineBorder(ConstantValueView.primaryColor, 2));
		this.setSize(new Dimension(400,40));
		
	}

}
