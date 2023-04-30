package globalComponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.border.LineBorder;

import constant.ConstantValueView;
import java.awt.Font;

public class SearchBar extends JPanel {

	/**
	 * Create the panel.
	 */
	JTextField searchField; 
	JComboBox<String> searchTypes; 
	
	public SearchBar(String[] types) {
		this.setPreferredSize(new Dimension(370,45));
		this.setBorder(new LineBorder(ConstantValueView.primaryColor, 3));
		this.setLayout(new BorderLayout());
		searchField = new JTextField();
		searchField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchField.setBorder(null);
		
		
		searchField.setForeground(Color.BLACK); 
		searchField.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        if (searchField.getText().equals("SEARCH")) {
		           searchField.setText("");
		           searchField.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (searchField.getText().isEmpty()) {
		        	searchField.setForeground(Color.GRAY);
		        	searchField.setText("SEARCH");
		        }
		    }
		});
		
		

		this.add(searchField, BorderLayout.CENTER);
		ImageIcon imageIcon = new ImageIcon(SearchBar.class.getResource("/assets/search-icon.png"));
		JLabel label = new JLabel(imageIcon);
		label.setPreferredSize(new Dimension(24, 24));
		this.add(label, BorderLayout.EAST);
		
		JComboBox comboBox = new JComboBox(types);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(comboBox, BorderLayout.WEST);
		
		
	}
	public String getSearchText() {
		return this.searchField.getText(); 
	}


}
