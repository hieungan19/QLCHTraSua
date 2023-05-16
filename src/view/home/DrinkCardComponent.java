package view.home;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.ProductModel;

import javax.swing.SwingConstants;
import constant.ConstantValueView;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Font;

public class DrinkCardComponent extends JPanel {

	/**
	 * Create the panel.
	 */
	private ProductModel data;
	private ImageIcon scaledIcon;
	public DrinkCardComponent(ProductModel pro ) {
		this.data = pro; 
		this.setPreferredSize(new Dimension(150, 180));
		this.setLayout(new BorderLayout(10,10));
		this.setBackground(ConstantValueView.primaryColor);
		if (pro.getImageUri()!=null && !pro.getImageUri().isEmpty()) {
			scaledIcon = new ImageIcon(new ImageIcon(pro.getImageUri()).getImage()
					.getScaledInstance(120, 140, Image.SCALE_DEFAULT));
		}
	
        // Create a label for the image
        JLabel imageLabel = new JLabel(scaledIcon);
        
        imageLabel.setVerticalAlignment(JLabel.TOP);

        // Add the labels to the panel
        add(imageLabel, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        add(panel, BorderLayout.SOUTH);
        panel.setLayout(new GridLayout(2, 1, 0, 0));
        panel.setOpaque(false);
        
        JTextArea name = new JTextArea(data.getName());
        name.setLineWrap(true); // bật wrap text tự động xuống dòng
        name.setWrapStyleWord(true); // wrap text theo từ
        name.setFont(new Font("Tahoma", Font.BOLD, 12));
        name.setForeground(ConstantValueView.primaryDark );
        name.setOpaque(false);
        panel.add(name);
       
        
        JLabel priceLabel = new JLabel(Double.toString(data.getPrice())+" VND");
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        priceLabel.setForeground(SystemColor.info);
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(priceLabel);
        
		
	}
	
}
