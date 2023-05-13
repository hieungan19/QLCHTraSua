package view.home;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;

import globalComponent.NumberSpinner;
import model.ProductModel;

public class ChooseTopping extends JPanel{
	public NumberSpinner spinner_toppingAmount;
	public ProductModel topping; 

	public ChooseTopping(ProductModel topping) {
		this.topping = topping; 
		// TODO Auto-generated constructor stub
		spinner_toppingAmount = new NumberSpinner(new SpinnerNumberModel(1,0,10,1));
		this.setPreferredSize(new Dimension(300, 40));
		this.setLayout(new GridLayout());
		JLabel text = new JLabel(topping.getName());
		text.setPreferredSize(new Dimension(100, 13));
		this.add(text); 
		this.setVisible(true);
		
		this.add(spinner_toppingAmount); 
		this.setVisible(true);
	}
}
