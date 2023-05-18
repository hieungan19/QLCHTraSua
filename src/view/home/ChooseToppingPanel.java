package view.home;

import javax.swing.JPanel;

import globalComponent.AppButton;
import globalComponent.AppLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JComboBox;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;


public class ChooseToppingPanel extends JPanel {

	public JPanel panel_topping;
	public JComboBox comboBox_topList;
	public AppButton btn_addTopping;

	/**
	 * Create the panel.
	 */
	public ChooseToppingPanel() {
		// TODO Auto-generated constructor stub
	
		panel_topping = new JPanel();
		
		comboBox_topList = new JComboBox();
		comboBox_topList.setMaximumSize(new Dimension(100, 32767));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {100, 0};
		gridBagLayout.rowHeights = new int[] {0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 1, 10, 0));
		
		AppLabel lblNewLabel = new AppLabel("Chọn nguyên liệu");
		lblNewLabel.setText("Chọn topping");
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
	
		panel_2.add(comboBox_topList);
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		btn_addTopping = new AppButton("+");
		panel_1.add(btn_addTopping);
		
		
		
		JScrollPane scrollPane = new JScrollPane(panel_topping);
		panel_topping.setLayout(new GridLayout(3, 1, 0, 5));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weighty = 8.0;
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		
	}
}
