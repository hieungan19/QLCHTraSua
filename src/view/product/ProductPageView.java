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
import javax.swing.ImageIcon;

import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppScrollTable;
import globalComponent.SearchBar;
import view.ImageTableCellRenderer;

public class ProductPageView extends JPanel{

	public ProductPageView() {
		String[] titleList  = new String[] {
				"Mã món", "Ảnh", "Tên sản phẩm", "Phân loại", "Đơn giá", "Nguyên liệu"
			};
		JPanel contentPanel = new JPanel();
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
		
		SearchBar searchBar = new SearchBar(titleList);

		GridBagConstraints gbc_searchBar = new GridBagConstraints();
		gbc_searchBar.insets = new Insets(0, 20, 0, 20);
		gbc_searchBar.anchor = GridBagConstraints.NORTH;
		gbc_searchBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_searchBar.gridx = 1;
		gbc_searchBar.gridy = 0;
		gbc_searchBar.weightx = 3.0;
		panel_1.add(searchBar, gbc_searchBar); 
		
		AppButton btnNewButton = new AppButton("+");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 32));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 20.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPanel.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		Object[][] object = new Object[][] {
			 { "001", null, "Trà sữa hoa lài-L", "Trà sữa", "38000", null },
		};
		
 
		
		AppScrollTable scrollPane_product = new AppScrollTable(new DefaultTableModel(
				object, titleList
		));
	
		panel.add(scrollPane_product);
		
		
	scrollPane_product.jTable.setRowHeight(100);
	// Set the cell renderer for the "Ảnh" column
	TableColumn imageColumn = scrollPane_product.jTable.getColumnModel().getColumn(1); // "Ảnh" column
	imageColumn.setCellRenderer(new ImageTableCellRenderer());

	// Set an image for a specific row and column
	
	ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/assets/tamthoitea.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	scrollPane_product.jTable.getModel().setValueAt(imageIcon, 0, 1); // row and column indices start from 0
	


		
	    
	}

}
