package component;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class DrinkScrollPaneTable extends JScrollPane {
	public DrinkScrollPaneTable() {
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", null, "abcababababababababa", null, null},
				{null, null, "", null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 \u0111\u1ED3 u\u1ED1ng", "T\u00EAn \u0111\u1ED3 u\u1ED1ng", "Topping", "S\u1ED1 l\u01B0\u1EE3ng", "T\u1ED5ng gi\u00E1"
			}
		));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(5, 174, 421, -100);

		setViewportView(table);
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
	}
	
}
