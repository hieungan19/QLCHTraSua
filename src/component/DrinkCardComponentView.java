package component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DrinkModel;
import javax.swing.SwingConstants;

import constant.ConstantValueView;

import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Font;

public class DrinkCardComponentView extends JPanel {

	/**
	 * Create the panel.
	 */
	private DrinkModel data; 
	public DrinkCardComponentView(DrinkModel drink) {
		this.data = drink; 
		this.setPreferredSize(new Dimension(150, 180));
		this.setLayout(new BorderLayout(10,10));
		this.setBackground(ConstantValueView.primaryColor);
		
		ImageIcon imgIcon = new ImageIcon(DrinkCardComponentView.class.getResource(drink.getImageUri()));
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
	
	
	public static void main(String[] args) {
        JFrame frame = new JFrame("My Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrinkModel dummy = new DrinkModel("D01", "Tra sua Olong",20000 , "Tra sua","/assets/bg-login.png", null, null); 
        frame.getContentPane().add(new DrinkCardComponentView(dummy));
        frame.pack();
        frame.setVisible(true);
    }

}
