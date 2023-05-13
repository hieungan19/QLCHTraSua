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

import constant.AppValues;
import constant.ConstantValueView;
import controller.HomeController;
import controller.LoginController;
import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.SearchBar;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

public class HomePageView extends JPanel {

	public MainMenuPanel mainMenu;
	public JLabel lblNewLabel_userName;
	public CartPanel cart; 
	public HomeController controller; 
	/**
	 * Create the panel.
	 */
	public HomePageView() {
		this.setPreferredSize(new Dimension(840, 740));
		this.setBackground(ConstantValueView.background);
		lblNewLabel_userName = new JLabel("");
		cart = new CartPanel();
		mainMenu = new MainMenuPanel();
		controller = new HomeController(this); 
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{420, 420, 0};
		gridBagLayout.rowHeights = new int[]{740, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		// Menu tổng thể 
		JPanel panel_menuOder = new JPanel();
		panel_menuOder.setOpaque(false);
		GridBagLayout gbl_panel_menuOder = new GridBagLayout();
		gbl_panel_menuOder.columnWidths = new int[] {600, 0};
		gbl_panel_menuOder.rowHeights = new int[] {60, 0, 0, 0};
		gbl_panel_menuOder.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_menuOder.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		panel_menuOder.setLayout(gbl_panel_menuOder);
		
		//header bao gồm: MENU và user name, Date now
		
		JPanel panel_header = new JPanel();
		panel_header.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel_header.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(10);
		flowLayout.setHgap(20);
		
		AppLabel lblNewLabel_menu = new AppLabel("MENU",32,true);
		panel_header.add(lblNewLabel_menu);
		
		JPanel panel_info = new JPanel();
		panel_info.setOpaque(false);
		panel_header.add(panel_info);
		panel_info.setLayout(new GridLayout(2, 1, 0, 0));
		
		//user name

		lblNewLabel_userName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_userName.setForeground(ConstantValueView.primaryColor);
		panel_info.add(lblNewLabel_userName);
		
			
			//date
			JLabel lblNewLabel_dateNow = new JLabel("Date");
			lblNewLabel_dateNow.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_dateNow.setForeground(ConstantValueView.primaryColor); 
			panel_info.add(lblNewLabel_dateNow);
			GridBagConstraints gbc_panel_header = new GridBagConstraints();
			gbc_panel_header.anchor = GridBagConstraints.NORTH;
			gbc_panel_header.fill = GridBagConstraints.HORIZONTAL;
			gbc_panel_header.insets = new Insets(0, 0, 5, 0);
			gbc_panel_header.gridx = 0;
			gbc_panel_header.gridy = 0;
			panel_menuOder.add(panel_header, gbc_panel_header);
			
			SearchBar searchBarView = new SearchBar();
			GridBagConstraints gbc_searchBarView = new GridBagConstraints();
			gbc_searchBarView.weighty = 1.0;
			gbc_searchBarView.insets = new Insets(0, 20, 5, 20);
			gbc_searchBarView.fill = GridBagConstraints.BOTH;
			gbc_searchBarView.gridx = 0;
			gbc_searchBarView.gridy = 1;
			panel_menuOder.add(searchBarView, gbc_searchBarView);
			
			JPanel panel = new JPanel();
			panel.setBackground(ConstantValueView.background);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.weighty = 2.0;
			gbc_panel.insets = new Insets(10, 20, 0, 20);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 2;
			panel_menuOder.add(panel, gbc_panel);
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			
			JPanel panel_filterButton = new JPanel();
			
			
			JScrollPane scrollPane = new JScrollPane(panel_filterButton);
			scrollPane.setPreferredSize(new Dimension(12, 50));
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			panel.add(scrollPane);
			panel_filterButton.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
			
			
			for (int i = 0; i<(AppValues.productTypes.length); ++i) {
				panel_filterButton.add(new AppButton(AppValues.productTypes[i])); 
			}

			
			JPanel panel_menu = new JPanel();
			panel_menu.setOpaque(false);
			GridBagConstraints gbc_panel_menu = new GridBagConstraints();
			gbc_panel_menu.insets = new Insets(0, 0, 5, 0);
			gbc_panel_menu.weighty = 30.0;
			gbc_panel_menu.fill = GridBagConstraints.BOTH;
			gbc_panel_menu.gridx = 0;
			gbc_panel_menu.gridy = 3;
			panel_menuOder.add(panel_menu, gbc_panel_menu);
			panel_menu.setLayout(new GridLayout(0, 1, 0, 0));
			
			
			mainMenu.setOpaque(false);
			mainMenu.setBounds(new Rectangle(0, 120, 490, 520));
			panel_menu.add(mainMenu);
			GridBagConstraints gbc_panel_menuOder = new GridBagConstraints();
			gbc_panel_menuOder.weightx = 3.0;
			gbc_panel_menuOder.fill = GridBagConstraints.BOTH;
			gbc_panel_menuOder.insets = new Insets(0, 0, 0, 5);
			gbc_panel_menuOder.gridx = 0;
			gbc_panel_menuOder.gridy = 0;
			add(panel_menuOder, gbc_panel_menuOder);
		//cart 
		JPanel panel_bill = new JPanel();
	
		GridBagLayout gridBagLayout_1 = (GridBagLayout) cart.getLayout();
		gridBagLayout_1.columnWidths = new int[] {250};
		panel_bill.setBackground(ConstantValueView.primaryColor);
		panel_bill.setLayout(new GridLayout(0, 1, 0, 0));
		panel_bill.add(cart);
		GridBagConstraints gbc_panel_bill = new GridBagConstraints();
		gbc_panel_bill.weightx = 1.0;
		gbc_panel_bill.fill = GridBagConstraints.BOTH;
		gbc_panel_bill.gridx = 1;
		gbc_panel_bill.gridy = 0;
		add(panel_bill, gbc_panel_bill);
		
		
	}
}
