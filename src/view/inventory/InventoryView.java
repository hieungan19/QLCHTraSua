package view.inventory;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.JScrollPane;


import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.AppController;
import model.InventoryModel;

import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import globalComponent.SearchBar;
import javax.swing.LayoutStyle.ComponentPlacement;

public class InventoryView extends JPanel {
	private JTable jtable_Item;
	private InventoryModel inventoryModel;

	/**
	 * Create the panel.
	 */
	public InventoryView() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(245, 222, 179));
		setLayout(null);
		// Tạo label INVENTORY
		JLabel jLabel_inventory = new JLabel("INVENTORY");
		jLabel_inventory.setBounds(20, 20, 180, 60);
		jLabel_inventory.setForeground(new Color(139, 69, 19));
		jLabel_inventory.setFont(new Font("Tahoma", Font.BOLD, 29));
		add(jLabel_inventory);
		// Tạo nút thêm
		JButton jbutton_addItem = new JButton("+");
		jbutton_addItem.setBounds(647, 24, 173, 51);
		
		jbutton_addItem.setBorder(null);
		jbutton_addItem.setBackground(new Color(205, 133, 63));
		jbutton_addItem.setForeground(new Color(248, 248, 255));
		jbutton_addItem.setFont(new Font("Tahoma", Font.PLAIN, 33));
		add(jbutton_addItem);

		// Tạo bảng

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(752, 123);
		scrollPane.setLocation(45, 126);;
		add(scrollPane);

		jtable_Item = new JTable();
		scrollPane.setViewportView(jtable_Item);
		jtable_Item.setBackground(new Color(245, 222, 179));
		jtable_Item.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtable_Item.setForeground(new Color(0, 0, 0));
		jtable_Item.setModel(new DefaultTableModel(
				new Object[][] { { "001", null, null, null, null, null }, { "", null, null, null, null, null },
						{ "", null, null, null, null, null }, { "", null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "Mã hàng", "Ngày nhập", "Tên mặt hàng", "Phân loại", "Số lượng", "Giá(VNĐ)" }));

		jtable_Item.setFillsViewportHeight(true);
		// đổi màu chữ và nền cho cột bảng
		JTableHeader head = jtable_Item.getTableHeader();
		head.setBackground(new Color(245, 222, 179));
		head.setForeground(Color.BLACK);
		head.setFont(new Font("Tahome", Font.BOLD, 15));

		// tạo trang Thêm mặt hàng
		
		jbutton_addItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				ItemDetail itemDetail = new ItemDetail();
//				desktopPane.add(itemDetail);
				
				InventoryItemDetails addItemPanel = new InventoryItemDetails();
				
				AppController.root.removeAll();
				AppController.root.setLayout(new GridBagLayout()); 
				GridBagConstraints gbc = new GridBagConstraints();

		        // Set the constraints to center the child panel
		        gbc.gridx = 0;
		        gbc.gridy = 0;
		        gbc.fill = GridBagConstraints.WEST;

		        // Add the child panel to the parent panel
		        AppController.root.add(addItemPanel, gbc);
				
				AppController.root.revalidate();
				AppController.root.repaint();
				addItemPanel.setVisible(true);
			}
		});
		SearchBar searchBarPanel = new SearchBar();
	    add(searchBarPanel);

	    // use GroupLayout to position the components
	    GroupLayout layout = new GroupLayout(this);
	    layout.setHorizontalGroup(
	    	layout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(layout.createSequentialGroup()
	    			.addGap(4)
	    			.addComponent(jLabel_inventory, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
	    			.addPreferredGap(ComponentPlacement.UNRELATED)
	    			.addComponent(searchBarPanel, GroupLayout.PREFERRED_SIZE, 523, GroupLayout.PREFERRED_SIZE)
	    			.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
	    			.addComponent(jbutton_addItem, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
	    			.addGap(20))
	    		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
	    			.addContainerGap())
	    );
	    layout.setVerticalGroup(
	    	layout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(layout.createSequentialGroup()
	    			.addGap(27)
	    			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
	    				.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
	    					.addGroup(Alignment.LEADING, layout.createSequentialGroup()
	    						.addPreferredGap(ComponentPlacement.RELATED)
	    						.addComponent(searchBarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    					.addComponent(jLabel_inventory, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
	    				.addComponent(jbutton_addItem, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
	    			.addGap(71)
	    			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
	    			.addGap(40))
	    );
	    setLayout(layout);
	}
	
}
