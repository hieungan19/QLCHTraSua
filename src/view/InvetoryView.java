package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import model.InventoryModel;
import test.ItemDetail;

import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;

public class InvetoryView extends JPanel {
	private JTable jtable_Item;
	private InventoryModel inventoryModel;

	/**
	 * Create the panel.
	 */
	public InvetoryView() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(245, 222, 179));
		setLayout(null);
		// Tạo label INVENTORY
		JLabel jLabel_inventory = new JLabel("INVENTORY");
		jLabel_inventory.setForeground(new Color(139, 69, 19));
		jLabel_inventory.setFont(new Font("Tahoma", Font.BOLD, 29));
		jLabel_inventory.setBounds(20, 20, 180, 60);
		add(jLabel_inventory);
		// Tạo nút thêm
		JButton jbutton_addItem = new JButton("+");
		jbutton_addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jbutton_addItem.setBorder(null);
		jbutton_addItem.setBackground(new Color(205, 133, 63));
		jbutton_addItem.setForeground(new Color(248, 248, 255));
		jbutton_addItem.setFont(new Font("Tahoma", Font.PLAIN, 33));
		jbutton_addItem.setBounds(647, 24, 173, 51);
		add(jbutton_addItem);

		// Tạo bảng

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(752, 123);
		scrollPane.setLocation(45, 126);
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
		head.setForeground(new Color(248, 248, 255));
		head.setFont(new Font("Tahome", Font.BOLD, 15));

		// tạo trang Thêm mặt hàng
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(212, 259, 420, 520);
		add(desktopPane);
		jbutton_addItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ItemDetail itemDetail = new ItemDetail();
				desktopPane.add(itemDetail);
				itemDetail.setVisible(true);
			}
		});

	}
}
