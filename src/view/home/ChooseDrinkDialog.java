package view.home;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JDialog;

import javax.swing.JPanel;

import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.NumberSpinner;
import model.ProductModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ChooseDrinkDialog extends JDialog {

	public final JPanel contentPanel = new JPanel();

	public AppButton btn_delete;
	public AppButton btn_save;

	public ChooseToppingPanel toppingPanel;

	public NumberSpinner spinner_amount;
	/**
	 * Create the dialog.
	 */
	
	public ChooseDrinkDialog(ProductModel pro) {
		spinner_amount = new NumberSpinner(new SpinnerNumberModel(1,0,100,1));
		setBounds(0, 0, 524, 400);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			DrinkCardComponent drinkImageCard = new DrinkCardComponent(pro);
			drinkImageCard.setBounds(10, 10, 166, 264);
			
			getContentPane().add(drinkImageCard); 
			
			//Cancel Button
			 btn_delete = new AppButton("XÓA");
			btn_delete.setBounds(226, 320, 106, 33);
			getContentPane().add(btn_delete); 
			
			//Save Button
			 btn_save = new AppButton("LƯU"); 
			btn_save.setBounds(350, 320, 106, 33);
			getContentPane().add(btn_save);
		
			
			
			
			
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(186, 10, 314, 280);
		getContentPane().add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{270, 0};
		gbl_panel_1.rowHeights = new int[] {40, 200};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panel_1.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		AppLabel lblNewLabel_1 = new AppLabel("Nhập số lượng");
		panel.add(lblNewLabel_1);
		
		
		panel.add(spinner_amount);
		
		toppingPanel = new ChooseToppingPanel();
		toppingPanel.btn_addTopping.setPreferredSize(new Dimension(30, 30));
		GridBagLayout gridBagLayout = (GridBagLayout) toppingPanel.getLayout();
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.columnWidths = new int[]{0};
		GridBagConstraints gbc_toppingPanel = new GridBagConstraints();
		gbc_toppingPanel.fill = GridBagConstraints.BOTH;
		gbc_toppingPanel.gridx = 0;
		gbc_toppingPanel.gridy = 1;
		panel_1.add(toppingPanel, gbc_toppingPanel);
		

		
		ArrayList<ChooseTopping> toppingList = new ArrayList<ChooseTopping>();
		toppingList.add(new ChooseTopping(pro)); 


	}
	
	
	
	
}

