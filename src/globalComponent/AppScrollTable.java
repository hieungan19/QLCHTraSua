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

	public JTable jTable;

	/**
	 * Create the panel.
	 */
	public AppScrollTable(DefaultTableModel tableModel) {
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jTable = new JTable();
		this.setViewportView(jTable);
		jTable.setBackground(ConstantValueView.background);
		jTable.setFont(new Font("Arial", Font.PLAIN, 14));
		jTable.setForeground(new Color(0, 0, 0));
		jTable.setModel(tableModel);
		TableColumn column = jTable.getColumnModel().getColumn(1); // get the first column
		column.setPreferredWidth(150);

		jTable.setFillsViewportHeight(true);
		// đổi màu chữ và nền cho cột bảng
		JTableHeader head = jTable.getTableHeader();
		head.setBackground(ConstantValueView.background);
		head.setForeground(Color.BLACK);
		head.setFont(ConstantValueView.h4);
	}

}
