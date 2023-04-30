package globalComponent;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import constant.ConstantValueView;

public class AppScrollTable extends JScrollPane {

	public JTable jtable_Item;

	/**
	 * Create the panel.
	 */
	public AppScrollTable(DefaultTableModel tableModel) {
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jtable_Item = new JTable();
		this.setViewportView(jtable_Item);
		jtable_Item.setBackground(ConstantValueView.background);
		jtable_Item.setFont(new Font("Arial", Font.PLAIN, 14));
		jtable_Item.setForeground(new Color(0, 0, 0));
		jtable_Item.setModel(tableModel);
		TableColumn column = jtable_Item.getColumnModel().getColumn(1); // get the first column
		column.setPreferredWidth(150);

		jtable_Item.setFillsViewportHeight(true);
		// đổi màu chữ và nền cho cột bảng
		JTableHeader head = jtable_Item.getTableHeader();
		head.setBackground(ConstantValueView.background);
		head.setForeground(Color.BLACK);
		head.setFont(ConstantValueView.h4);
	}

}
