package view.employee;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import constant.ConstantValueView;
import model.EmployeeModel;

public class EmployeeScrollPane extends JScrollPane {
	ArrayList<EmployeeModel> employeeList;
	private JTable jTable_employee;

	public EmployeeScrollPane(ArrayList<EmployeeModel> employeeList) {
		super();
		this.employeeList = employeeList;
		
		this.setBorder(null);
		this.setBackground(Color.LIGHT_GRAY);
		this.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setViewportBorder(new LineBorder(Color.LIGHT_GRAY));
		this.setPreferredSize(new Dimension(800, 600));
		
		jTable_employee = new JTable();
		jTable_employee.setBorder(null);
		jTable_employee.setSize(new Dimension(100, 100));
		jTable_employee.setGridColor(Color.LIGHT_GRAY);
		this.setViewportView(jTable_employee);
		jTable_employee.setBackground(ConstantValueView.background);
		jTable_employee.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jTable_employee.setForeground(new Color(0, 0, 0));
		jTable_employee.setModel(new DefaultTableModel(
			new Object[][] {
				{"001", null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "Ch\u1EE9c v\u1EE5", "Ng\u00E0y v\u00E0o l\u00E0m", "Email", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "H\u1EC7 s\u1ED1 l\u01B0\u01A1ng"
			}
		));
		jTable_employee.getColumnModel().getColumn(4).setPreferredWidth(125);
		jTable_employee.getColumnModel().getColumn(5).setPreferredWidth(116);
		jTable_employee.getColumnModel().getColumn(6).setPreferredWidth(95);
		
		
				jTable_employee.setFillsViewportHeight(true);
				
					jTable_employee.setRowHeight(30);
		
		
		
	}
	
	

}
