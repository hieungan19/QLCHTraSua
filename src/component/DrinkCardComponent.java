package component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.DrinkModel;
import javax.swing.SwingConstants;
import constant.ConstantValueView;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Font;

public class DrinkCardComponent extends JPanel {

	/**
	 * Create the panel.
	 */
	private DrinkModel data; 
	public DrinkCardComponent(DrinkModel drink) {
		this.data = drink; 
		this.setPreferredSize(new Dimension(150, 180));
		this.setLayout(new BorderLayout(10,10));
		this.setBackground(ConstantValueView.primaryColor);
		
		ImageIcon imgIcon = new ImageIcon(DrinkCardComponent.class.getResource(drink.getImageUri()));
		Image image = imgIcon.getImage();
		Image scaledImage = image.getScaledInstance(130,150 , Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
        // Create a label for the image
        JLabel imageLabel = new JLabel(scaledIcon);
        
        imageLabel.setVerticalAlignment(JLabel.TOP);

        // Add the labels to the panel
        add(imageLabel, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        add(panel, BorderLayout.SOUTH);
        panel.setLayout(new GridLayout(2, 1, 0, 0));
        panel.setOpaque(false);
        
        JLabel nameLabel = new JLabel(data.getDrinkName());
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(nameLabel);
        
        JLabel priceLabel = new JLabel(Integer.toString(data.getDrinkPrice())+" VND");
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        priceLabel.setForeground(SystemColor.info);
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(priceLabel);
        
		
	}
	
}
