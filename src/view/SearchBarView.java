package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.border.LineBorder;

import constant.ConstantValueView;

public class SearchBarView extends JPanel {

	/**
	 * Create the panel.
	 */
	JTextField searchField; 
	
	public SearchBarView() {
		this.setPreferredSize(new Dimension(370,40));
		this.setBorder(new LineBorder(ConstantValueView.primaryColor, 3));
		this.setLayout(new BorderLayout());
		searchField = new JTextField();
		searchField.setBorder(null);
		
		
		searchField.setForeground(Color.gray); 
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
		ImageIcon imageIcon = new ImageIcon(SearchBarView.class.getResource("/assets/search-icon.png"));
		JLabel label = new JLabel(imageIcon);
		label.setPreferredSize(new Dimension(24, 24));
		this.add(label, BorderLayout.EAST);
		
		
		
	}
	public String getSearchText() {
		return this.searchField.getText(); 
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("My Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SearchBarView());
        frame.pack();
        frame.setVisible(true);
	}

}
