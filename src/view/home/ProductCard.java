package view.home;

import javax.swing.JPanel;

import globalComponent.AppLabel;
import model.ProductModel;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;

import constant.ConstantValueView;

public class ProductCard extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProductCard(ProductModel p) {
		setBackground(ConstantValueView.background);
		setSize(new Dimension(300,60));
		setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		AppLabel drink = new AppLabel(p.getName(),16, true);
		panel.add(drink, BorderLayout.WEST);
		
		AppLabel amount = new AppLabel(String.valueOf(p.getAmount()));
		amount.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(amount, BorderLayout.CENTER);
		
		AppLabel total = new AppLabel(String.valueOf(p.getTotal()));
		panel.add(total, BorderLayout.EAST);
		
		AppLabel topping = new AppLabel(p.toStringToppingList());
		add(topping);

	}

}
