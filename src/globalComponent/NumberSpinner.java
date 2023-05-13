package globalComponent;

import java.awt.Font;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;

import constant.ConstantValueView;

import java.awt.Color;
import java.awt.Dimension;

public class NumberSpinner extends JSpinner{
	public NumberSpinner(SpinnerNumberModel model) {
		super(model); 
		this.setFont(new Font("Arial", Font.PLAIN, 16));
		this.setSize(new Dimension(120,40) );
		this.setBorder(new LineBorder(ConstantValueView.primaryColor, 2));
		
	}
	public double getNumber() {
		return(Double) this.getValue(); 
	}
	
	public int getInt() {
		return (Integer) this.getValue(); 
	}
}
