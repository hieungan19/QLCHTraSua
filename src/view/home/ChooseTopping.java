package view.home;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;

import globalComponent.NumberSpinner;
import model.DrinkModel;

public class ChooseTopping extends JPanel{
	public ChooseTopping(DrinkModel topping) {
		// TODO Auto-generated constructor stub
		this.setPreferredSize(new Dimension(200,30));
		this.setLayout(new GridLayout());
		JLabel text = new JLabel(topping.getDrinkName());
		this.add(text); 
		this.setVisible(true);
		NumberSpinner spinner = new NumberSpinner(new SpinnerNumberModel(1,0,10,1));
		this.add(spinner); 
		this.setVisible(true);
	}
}
