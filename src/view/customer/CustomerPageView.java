package view.customer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import constant.AppValues;
import constant.ConstantValueView;
import controller.CustomerController;
import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppScrollTable;
import globalComponent.SearchBar;
import model.CustomerModel;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class CustomerPageView extends JPanel {

	public AppScrollTable scrollPane_customer ;
	public Object[][] object;
	public CustomerController controller;
	public List<CustomerModel> customerList;
	public AppButton btn_addCustomer;
	public SearchBar searchBar; 

	/**
	 * Create the panel.
	 */
	public CustomerPageView() {
		btn_addCustomer = new AppButton("+");
		searchBar = new SearchBar();
		setBackground(Color.WHITE);
		DefaultTableModel defaultTableModel_customer = new DefaultTableModel(object, AppValues.customerAtributes); 
		scrollPane_customer = new AppScrollTable(defaultTableModel_customer);
		JPanel contentPanel = new JPanel();

		//controller
		controller = new CustomerController(this);
		controller.displayCustomerListToTable(); 
		

		contentPanel.setBounds(20, 20, 790, 630);
		this.setLayout(null);
		this.add(contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPanel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		AppLabel lblNewLabel = new AppLabel("KHÁCH HÀNG", 32, true);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		


		GridBagConstraints gbc_searchBar = new GridBagConstraints();
		gbc_searchBar.insets = new Insets(0, 20, 0, 20);
		gbc_searchBar.anchor = GridBagConstraints.NORTH;
		gbc_searchBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_searchBar.gridx = 1;
		gbc_searchBar.gridy = 0;
		gbc_searchBar.weightx = 3.0;
		panel_1.add(searchBar, gbc_searchBar); 
		
	
		btn_addCustomer.setFont(new Font("SansSerif", Font.BOLD, 32));
		GridBagConstraints gbc_btn_addCustomer = new GridBagConstraints();
		gbc_btn_addCustomer.fill = GridBagConstraints.VERTICAL;
		gbc_btn_addCustomer.insets = new Insets(0, 0, 0, 5);
		gbc_btn_addCustomer.gridx = 2;
		gbc_btn_addCustomer.gridy = 0;
		panel_1.add(btn_addCustomer, gbc_btn_addCustomer);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 20.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPanel.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		panel.add(scrollPane_customer); 
		
		

		
	}
}
