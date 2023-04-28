package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import constant.ConstantValueView;
import diaglog.AppOptionPaneDialog;
import globalComponent.AppButton;
import globalComponent.SearchBar;
import model.OrdersModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrdersView extends JPanel{
	private OrdersModel ordersModel;
	private JTable jtable_orders;
	
	/**
	 * Create the panel.
	 */
	public OrdersView() {
		setForeground(new Color(0, 0, 0));
		setBackground(ConstantValueView.background);
		setPreferredSize(new Dimension(840, 740));
		// Tạo label INVENTORY
		JLabel jLabel_inventory = new JLabel("ORDERS");
		jLabel_inventory.setBounds(20, 20, 180, 60);
		jLabel_inventory.setForeground(ConstantValueView.primaryDark);
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
		
		// Tạo nút xóa đơn hàng
		AppButton jbutton_deleteOrders = new AppButton("Xóa đơn hàng");
		jbutton_deleteOrders.setBounds(660, 500, 148, 51);
		add(jbutton_deleteOrders);
		
		 // Tạo bảng

		JScrollPane scrollPane_orders = new JScrollPane();
		scrollPane_orders.setSize(752, 123);
		scrollPane_orders.setLocation(45, 126);
		add(scrollPane_orders);

		jtable_orders = new JTable();
		scrollPane_orders.setViewportView(jtable_orders);
		jtable_orders.setBackground(ConstantValueView.background);
		jtable_orders.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtable_orders.setForeground(new Color(0, 0, 0));
		jtable_orders.setModel(new DefaultTableModel(
				new Object[][] { { "001", null, null, null, null, null }, { "", null, null, null, null, null },
						{ "", null, null, null, null, null }, { "", null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "Mã hàng", "Ngày tạo", "Điểm tích lũy", "Nhân viên tạo", "Tổng thanh toán" }));

		jtable_orders.setFillsViewportHeight(true);
		// đổi màu chữ và nền cho cột bảng
		JTableHeader head = jtable_orders.getTableHeader();
		head.setBackground(ConstantValueView.background);
		head.setForeground(Color.BLACK);
		head.setFont(new Font("Tahome", Font.BOLD, 15));


		//add searchbar vào
				SearchBar searchBarPanel = new SearchBar();
			    add(searchBarPanel);

			    // use GroupLayout to position the components
			    GroupLayout layout = new GroupLayout(this);
			    layout.setHorizontalGroup(
			    	layout.createParallelGroup(Alignment.LEADING)
			    		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
			    			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
			    				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
			    					.addContainerGap()
			    					.addComponent(scrollPane_orders, GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE))
			    				.addGroup(layout.createSequentialGroup()
			    					.addGap(4)
			    					.addComponent(jLabel_inventory, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
			    					.addPreferredGap(ComponentPlacement.UNRELATED)
			    					.addComponent(searchBarPanel, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
			    					.addGap(18)
			    					.addComponent(jbutton_addItem, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
			    			.addGap(20))
			    );
			    layout.setVerticalGroup(
			    	layout.createParallelGroup(Alignment.LEADING)
			    		.addGroup(layout.createSequentialGroup()
			    			.addGap(54)
			    			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
			    				.addComponent(searchBarPanel, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
			    				.addComponent(jLabel_inventory, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
			    				.addComponent(jbutton_addItem, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
			    			.addGap(73)
			    			.addComponent(scrollPane_orders, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
			    			.addGap(456))
			    );
			    setLayout(layout);
			    
			 // tạo hộp thoại xóa
				jbutton_deleteOrders.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						JDialog dialog = new JDialog();
						dialog.setTitle("Xác nhận xóa đơn hàng đã chọn?");
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setSize(500, 300);
						dialog.setLocationRelativeTo(null);
						dialog.setBackground(new Color(245, 222, 179));
						dialog.setFont(new Font("Arial", Font.BOLD, 15));
						dialog.setForeground(new Color(139, 69, 19));
						dialog.setResizable(false);

						JPanel panel_dialog = new JPanel(new GridLayout(2, 1));
						JLabel label_dialog = new JLabel("Lưu ý dữ liệu sẽ bị xóa hoàn toàn và không thể khôi phục.");
						label_dialog.setHorizontalAlignment(SwingConstants.CENTER);
						label_dialog.setVerticalAlignment(SwingConstants.CENTER);

						JPanel panel_buttons = new JPanel(new FlowLayout());
						JButton okButton = new JButton("Xác nhận");
						okButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// Xử lý khi người dùng xác nhận xóa
								//đóng dialog yêu cầu xác nhận xóa
								Window window = SwingUtilities.getWindowAncestor(panel_dialog);
						        window.dispose(); 
						        
								AppOptionPaneDialog dialog = new AppOptionPaneDialog("Xóa thành công"); 
								
								
							}
						});

						JButton cancelButton = new JButton("Hủy bỏ");
						cancelButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// Xử lý khi người dùng hủy bỏ
								dialog.dispose();
							}
						});

						panel_buttons.add(okButton);
						panel_buttons.add(cancelButton);

						panel_dialog.add(label_dialog);
						panel_dialog.add(panel_buttons);

						dialog.getContentPane().add(panel_dialog);
						dialog.pack();
						dialog.setVisible(true);
					}
				});

				this.setVisible(true); 
	}
}
