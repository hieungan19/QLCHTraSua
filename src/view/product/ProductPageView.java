package view.product;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;


import javax.swing.JPanel;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import constant.AppValues;
import controller.ProductController;

import javax.swing.ImageIcon;

import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppScrollTable;
import globalComponent.MultiLineTableCellRenderer;
import globalComponent.SearchBar;
import view.ImageTableCellRenderer;

public class ProductPageView extends JPanel{

	public AppScrollTable scrollPane_product;
	Object[][] object ; 
	ProductController controller;
	public AppButton btn_addProduct;
	public SearchBar searchBar; 

	public ProductPageView() {

		scrollPane_product = new AppScrollTable(new DefaultTableModel(
				object, AppValues.productAttributes
		));
		 searchBar = new SearchBar();
		
		scrollPane_product.jTable.setDefaultRenderer(String.class, new MultiLineTableCellRenderer());
		JPanel contentPanel = new JPanel();
		
		scrollPane_product.jTable.setRowHeight(120);
		TableColumn imageColumn = scrollPane_product.jTable.getColumnModel().getColumn(1); // "Ảnh" column
		imageColumn.setCellRenderer(new ImageTableCellRenderer());
		imageColumn.setMaxWidth(120);
		
		btn_addProduct = new AppButton("+");
		controller = new ProductController(this); 
		
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
		
		AppLabel lblNewLabel = new AppLabel("QUẢN LÝ KHUYẾN MÃI", 32, true);
		lblNewLabel.setText("SẢN PHẨM");
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
		
	
		btn_addProduct.setFont(new Font("SansSerif", Font.BOLD, 32));
		GridBagConstraints gbc_btn_addProduct = new GridBagConstraints();
		gbc_btn_addProduct.fill = GridBagConstraints.VERTICAL;
		gbc_btn_addProduct.insets = new Insets(0, 0, 0, 5);
		gbc_btn_addProduct.gridx = 2;
		gbc_btn_addProduct.gridy = 0;
		panel_1.add(btn_addProduct, gbc_btn_addProduct);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 20.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPanel.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(scrollPane_product);
		
	// Set the cell renderer for the "Ảnh" column


	// Set an image for a specific row and column

	}

}
