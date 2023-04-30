package view.customer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import constant.ConstantValueView;
import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.SearchBar;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class CustomerPageView extends JPanel {

	/**
	 * Create the panel.
	 */
	public CustomerPageView() {
		setBackground(Color.WHITE);
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
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		AppLabel lblNewLabel = new AppLabel("THÔNG TIN KHÁCH HÀNG", 24, true);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setText("KHÁCH HÀNG");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.weightx = 1.0;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		SearchBar searchBar = new SearchBar();

		GridBagConstraints gbc_searchBar = new GridBagConstraints();
		gbc_searchBar.anchor = GridBagConstraints.NORTH;
		gbc_searchBar.fill = GridBagConstraints.VERTICAL;
		gbc_searchBar.gridx = 1;
		gbc_searchBar.gridy = 0;
		gbc_searchBar.weightx = 3.0;
		panel.add(searchBar, gbc_searchBar); 
		
		AppButton btnNewButton = new AppButton("+");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 32));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weighty = 20.0;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPanel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JScrollPane scrollPane_inventory = new JScrollPane();
		panel_1.add(scrollPane_inventory);

		
		JTable jtable_Item = new JTable();
		scrollPane_inventory.setViewportView(jtable_Item);
		jtable_Item.setBackground(ConstantValueView.background);
		jtable_Item.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtable_Item.setForeground(new Color(0, 0, 0));
		jtable_Item.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null, null},
				{"", null, null, null, null},
				{"", null, null, null, null},
				{"", null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng", "S\u0111t", "\u0110i\u1EC3m t\u00EDch l\u0169y", "Lo\u1EA1i kh\u00E1ch h\u00E0ng"
			}
		));

		jtable_Item.setFillsViewportHeight(true);
		// đổi màu chữ và nền cho cột bảng
		JTableHeader head = jtable_Item.getTableHeader();
		head.setBackground(ConstantValueView.background);
		head.setForeground(Color.BLACK);
		head.setFont(new Font("Tahome", Font.BOLD, 15));
		
	}
}
