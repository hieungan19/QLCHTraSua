package view.employee;

import javax.swing.JPanel;

import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.SearchBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import constant.ConstantValueView;

import java.awt.BorderLayout;

public class EmployeePageView extends JPanel {
	private JTable jTable_employee;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public EmployeePageView() {
		setPreferredSize(new Dimension(840, 740));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel jPanel_employeePage = new JPanel();
		jPanel_employeePage.setPreferredSize(new Dimension(840,740));
		jPanel_employeePage.setBackground(ConstantValueView.background);
		jPanel_employeePage.setPreferredSize(new Dimension(840, 740));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		jPanel_employeePage.setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(10, 10, 10, 10);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		jPanel_employeePage.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {200, 500, 100};
		gbl_panel.rowHeights = new int[] {40};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0};
		panel.setLayout(gbl_panel);
		
		AppLabel lblNewLabel_employee = new AppLabel("EMPLOYEE",32,true);
		GridBagConstraints gbc_lblNewLabel_employee = new GridBagConstraints();
		gbc_lblNewLabel_employee.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_employee.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_employee.gridx = 0;
		gbc_lblNewLabel_employee.gridy = 0;
		panel.add(lblNewLabel_employee, gbc_lblNewLabel_employee);
		
				SearchBar searchBar = new SearchBar();
				BorderLayout borderLayout = (BorderLayout) searchBar.getLayout();
				borderLayout.setHgap(10);
				GridBagConstraints gbc_searchBar = new GridBagConstraints();
				gbc_searchBar.fill = GridBagConstraints.BOTH;
				gbc_searchBar.gridx = 1;
				gbc_searchBar.gridy = 0;
				panel.add(searchBar, gbc_searchBar);
		
		AppButton btnAddEmployee = new AppButton("+");
		btnAddEmployee.setFont(new Font("Segoe UI Black", Font.BOLD, 32));
		GridBagConstraints gbc_btnAddEmployee = new GridBagConstraints();
		gbc_btnAddEmployee.anchor = GridBagConstraints.EAST;
		gbc_btnAddEmployee.insets = new Insets(0, 10, 0, 0);
		gbc_btnAddEmployee.fill = GridBagConstraints.BOTH;
		gbc_btnAddEmployee.gridx = 2;
		gbc_btnAddEmployee.gridy = 0;
		panel.add(btnAddEmployee, gbc_btnAddEmployee);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weightx = 9.0;
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
	
		gbc_panel_1.weighty = 9.0;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		jPanel_employeePage.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {820, 0};
		gbl_panel_1.rowHeights = new int[] {600, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
			scrollPane = new EmployeeScrollPane(null); 
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 0;
			panel_1.add(scrollPane, gbc_scrollPane);
			
			
		this.add(jPanel_employeePage); 
	}
}
