package view.product;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;

import globalComponent.NumberSpinner;
import model.IngredientModel;

public class ChooseIngredientDetail extends JPanel {

	/**
	 * Create the panel.
	 */
	public IngredientModel ingredient;
	public NumberSpinner spinner; 
	
	public ChooseIngredientDetail(IngredientModel ingredient) {
		this.ingredient = ingredient; 
		spinner = new NumberSpinner(new SpinnerNumberModel(1,0,1e9,1));
		this.setPreferredSize(new Dimension(200,30));
		GridLayout gridLayout = new GridLayout();
		gridLayout.setHgap(10);
		this.setLayout(gridLayout);
		JLabel text = new JLabel(ingredient.getName());
		this.add(text); 
		this.setVisible(true);
		
		this.add(spinner); 
		
		JLabel lblNewLabel = new JLabel(ingredient.getUnit());
		add(lblNewLabel);
		this.setVisible(true);
	}

}
