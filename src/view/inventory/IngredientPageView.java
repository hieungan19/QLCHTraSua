package view.inventory;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;



import javax.swing.table.DefaultTableModel;

import constant.AppValues;
import controller.IngredientController;
import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppScrollTable;
import globalComponent.SearchBar;
import javax.swing.BoxLayout;

public class IngredientPageView extends JPanel {

	public AppButton btn_addIngredient;
	public SearchBar searchBar;
	public AppScrollTable scrollPane_ingredient;
	public IngredientController controller; 
	public Object[][] object;
	public AppScrollTable scrollPane_import;
	public AppScrollTable scrollPane_export;
	

	/**
	 * Create the panel.
	 */
	public IngredientPageView() {
		scrollPane_ingredient = new AppScrollTable(new DefaultTableModel(
				object, AppValues.inventoryItemAttributes
		));
		scrollPane_export = new AppScrollTable(new DefaultTableModel(
				object,new String[] {"MÃ NL","Ngày xuất","Số lượng"}
		));

		scrollPane_import = new AppScrollTable(new DefaultTableModel(
				object,new String[] {"MÃ NL","Ngày nhập","Số lượng",}
		)); 
		
		btn_addIngredient = new AppButton("+");
		JPanel contentPanel = new JPanel();
		searchBar = new SearchBar();
		
		//controller
		controller = new IngredientController(this); 
		
		contentPanel.setBounds(20, 20, 790, 630);
		this.setLayout(null);
		this.add(contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPanel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		AppLabel lblNewLabel = new AppLabel("KHO HÀNG", 32, true);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		

		GridBagConstraints gbc_searchBar = new GridBagConstraints();
		gbc_searchBar.insets = new Insets(0, 20, 0, 20);
		gbc_searchBar.anchor = GridBagConstraints.NORTH;
		gbc_searchBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_searchBar.gridx = 1;
		gbc_searchBar.gridy = 0;
		gbc_searchBar.weightx = 3.0;
		panel_1.add(searchBar, gbc_searchBar); 

		btn_addIngredient.setFont(new Font("SansSerif", Font.BOLD, 32));
		GridBagConstraints gbc_btn_addIngredient = new GridBagConstraints();
		gbc_btn_addIngredient.fill = GridBagConstraints.VERTICAL;
		gbc_btn_addIngredient.insets = new Insets(0, 0, 0, 5);
		gbc_btn_addIngredient.gridx = 2;
		gbc_btn_addIngredient.gridy = 0;
		panel_1.add(btn_addIngredient, gbc_btn_addIngredient);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 20.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPanel.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 1, 0, 10));
		panel.add(scrollPane_ingredient);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 10, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		AppLabel lblNewLabel_1 = new AppLabel("CHI TIẾT NHẬP KHO",16,true);
		panel_3.add(lblNewLabel_1);
		
		panel_3.add(scrollPane_import);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		AppLabel lblNewLabel_2 = new AppLabel("CHI TIẾT XUẤT KHO",16,true);
		panel_4.add(lblNewLabel_2);
		
	
		panel_4.add(scrollPane_export);
		
	}
	
}
