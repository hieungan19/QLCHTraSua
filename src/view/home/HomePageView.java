package view.home;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import constant.ConstantValueView;
import globalComponent.SearchBar;
import model.DrinkModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.Color;

public class HomePageView extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePageView() {
		this.setPreferredSize(new Dimension(840, 740));
		this.setBackground(ConstantValueView.background);
		//cart 
		JPanel panel_bill = new JPanel();
		CartPanel cart = new CartPanel(); 
		cart.setBounds(0, 0, 351, 730);
		panel_bill.setBackground(ConstantValueView.primaryColor);
		
		// Menu tổng thể 
		JPanel panel_menuOder = new JPanel();
		panel_menuOder.setOpaque(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_menuOder, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_bill, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_bill, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
						.addComponent(panel_menuOder, GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_bill.setLayout(null);
		panel_bill.add(cart);
		
		//header bao gồm: MENU và user name, Date now
		
		JPanel panel_header = new JPanel();
		panel_header.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel_header.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(10);
		flowLayout.setHgap(20);
		
		// menu bao gồm thanh search, filter và main menu
		JPanel panel_menu = new JPanel();
		panel_menu.setOpaque(false);
		GroupLayout gl_panel_menuOder = new GroupLayout(panel_menuOder);
		gl_panel_menuOder.setHorizontalGroup(
			gl_panel_menuOder.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_header, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
				.addComponent(panel_menu, GroupLayout.PREFERRED_SIZE, 491, Short.MAX_VALUE)
		);
		gl_panel_menuOder.setVerticalGroup(
			gl_panel_menuOder.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_menuOder.createSequentialGroup()
					.addComponent(panel_header, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_menu, GroupLayout.PREFERRED_SIZE, 654, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JPanel panel_search = new JPanel();
		FlowLayout fl_panel_search = new FlowLayout(FlowLayout.LEFT, 30, 5);
		panel_search.setLayout(fl_panel_search);
		SearchBar searchBarView = new SearchBar();
		BorderLayout borderLayout = (BorderLayout) searchBarView.getLayout();
		borderLayout.setHgap(10);
		borderLayout.setVgap(10);
		searchBarView.setPreferredSize(new Dimension(450, 40));
		panel_search.add(searchBarView); 
		
		panel_search.setOpaque(false);
		
		//filter menu 
		JPanel panel_filter = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_filter.getLayout();
		flowLayout_1.setHgap(30);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_filter.setOpaque(false);
		FilterMenuButton filterBtn = new FilterMenuButton("MILK TEA");
		filterBtn.setPreferredSize(new Dimension(100,50));
		panel_filter.add(filterBtn);
		DrinkModel dummy = new DrinkModel("D01", "Tra sua Olong",20000 ,false,"/assets/bg-login.png", null,"Trà sữa", null);
		GroupLayout gl_panel_menu = new GroupLayout(panel_menu);
		gl_panel_menu.setHorizontalGroup(
			gl_panel_menu.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_filter, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
				.addGroup(gl_panel_menu.createSequentialGroup()
					.addComponent(panel_search, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_panel_menu.setVerticalGroup(
			gl_panel_menu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_menu.createSequentialGroup()
					.addComponent(panel_search, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_filter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(534, Short.MAX_VALUE))
		);
		panel_menu.setLayout(gl_panel_menu);
		
		//Main menu 
		MainMenuPanel mainMenu  = new MainMenuPanel();
		mainMenu.setOpaque(false); 
		mainMenu.setBounds(new Rectangle(0, 120, 490, 520));
		panel_menu.add(mainMenu);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setForeground(ConstantValueView.primaryDark);
		panel_header.add(lblNewLabel);
		
		JPanel panel_info = new JPanel();
		panel_info.setOpaque(false);;
		panel_header.add(panel_info);
		panel_info.setLayout(new GridLayout(2, 1, 0, 0));
		
		//user name
		JLabel lblNewLabel_userName = new JLabel("User Name");
		lblNewLabel_userName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_userName.setForeground(ConstantValueView.primaryColor);
		panel_info.add(lblNewLabel_userName);
	
		
		//date
		JLabel lblNewLabel_dateNow = new JLabel("Date");
		lblNewLabel_dateNow.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_dateNow.setForeground(ConstantValueView.primaryColor); 
		panel_info.add(lblNewLabel_dateNow);
		panel_menuOder.setLayout(gl_panel_menuOder);
		setLayout(groupLayout);
		
		
	}
}
