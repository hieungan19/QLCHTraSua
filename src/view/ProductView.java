package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.ImageIcon;

import constant.ConstantValueView;
import controller.AppController;
import globalComponent.SearchBar;
import view.ProductViewDetails;

public class ProductView extends JPanel{
	private JTable jtable_Product;

	public ProductView() {
		// TODO Auto-generated constructor stub
		setForeground(new Color(0, 0, 0));
		setBackground(ConstantValueView.background);
		setPreferredSize(new Dimension(840, 740));

		// Tạo label product
		JLabel jLabel_product = new JLabel("PRODUCT");
		jLabel_product.setBounds(20, 20, 180, 60);
		jLabel_product.setForeground(ConstantValueView.primaryDark);
		jLabel_product.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(jLabel_product);
		// Tạo nút thêm
		JButton jbutton_addProduct = new JButton("+");
		jbutton_addProduct.setBounds(647, 24, 173, 51);
		
		jbutton_addProduct.setBorder(null);
		jbutton_addProduct.setBackground(new Color(205, 133, 63));
		jbutton_addProduct.setForeground(new Color(248, 248, 255));
		jbutton_addProduct.setFont(new Font("Tahoma", Font.PLAIN, 33));
		add(jbutton_addProduct);

		// Tạo bảng

		JScrollPane scrollPane_product = new JScrollPane();
		scrollPane_product.setSize(752, 123);
		scrollPane_product.setLocation(45, 126);
		add(scrollPane_product);

		jtable_Product = new JTable();
		scrollPane_product.setViewportView(jtable_Product);
		jtable_Product.setBackground(ConstantValueView.background);
		jtable_Product.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtable_Product.setForeground(new Color(0, 0, 0));
		jtable_Product.setModel(new DefaultTableModel(
		        new Object[][] {
		                { "001", null, "Trà sữa hoa lài-L", "Trà sữa", "38000", null },
		                { "", null, null, null, null, null },
		                { "", null, null, null, null, null },
		                { "", null, null, null, null, null },
		                { null, null, null, null, null, null },
		                { null, null, null, null, null, null },
		        },
		        new String[] { "Mã món", "Ảnh", "Tên sản phẩm", "Phân loại", "Đơn giá", "Topping" }
		)); 

	// Set the cell renderer for the "Ảnh" column
	TableColumn imageColumn = jtable_Product.getColumnModel().getColumn(1); // "Ảnh" column
	imageColumn.setCellRenderer(new ImageTableCellRenderer());

	// Set an image for a specific row and column
	
	ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/assets/tamthoitea.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
	jtable_Product.getModel().setValueAt(imageIcon, 0, 1); // row and column indices start from 0
	
	jtable_Product.setFillsViewportHeight(true);

		// đổi màu chữ và nền cho cột bảng
		JTableHeader head = jtable_Product.getTableHeader();
		head.setBackground(ConstantValueView.background);
		head.setForeground(Color.BLACK);
		head.setFont(new Font("Tahome", Font.BOLD, 15));

		// tạo trang Thêm mặt hàng
		
		jbutton_addProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				ItemDetail itemDetail = new ItemDetail();
//				desktopPane.add(itemDetail);
				
				ProductViewDetails addProductPanel = new ProductViewDetails();
				
				AppController.root.removeAll();
				AppController.root.setLayout(new GridLayout()); 

		        // Add the child panel to the parent panel
		        AppController.root.add(addProductPanel);
				
				AppController.root.revalidate();
				AppController.root.repaint();
				addProductPanel.setVisible(true);
			}
		});
		
		//add searchbar vào
		SearchBar searchBarPanel = new SearchBar();
	    add(searchBarPanel);

	    // use GroupLayout to position the components
	    GroupLayout layout = new GroupLayout(this);
	    layout.setHorizontalGroup(
	    	layout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(layout.createSequentialGroup()
	    			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
	    				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
	    					.addContainerGap()
	    					.addComponent(scrollPane_product))
	    				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
	    					.addGap(4)
	    					.addComponent(jLabel_product)
	    					.addPreferredGap(ComponentPlacement.UNRELATED)
	    					.addComponent(searchBarPanel, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
	    					.addGap(18)
	    					.addComponent(jbutton_addProduct, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
	    			.addContainerGap(49, Short.MAX_VALUE))
	    );
	    layout.setVerticalGroup(
	    	layout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(layout.createSequentialGroup()
	    			.addGap(27)
	    			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
	    				.addComponent(jbutton_addProduct, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
	    				.addComponent(searchBarPanel, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
	    				.addComponent(jLabel_product, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
	    			.addGap(71)
	    			.addComponent(scrollPane_product, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
	    			.addGap(469))
	    );
	    setLayout(layout);
	}

}
