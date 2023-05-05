package view.home;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import constant.ConstantValueView;
import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.AppTextField;
import globalComponent.NumberSpinner;
import model.DrinkModel;
import javax.swing.JComboBox;

public class ChooseDrinkDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private AppButton btnCancel;
	private AppButton btnSave;
	/**
	 * Create the dialog.
	 */
	
	public ChooseDrinkDialog(DrinkModel drinkModel) {
		setBounds(0, 0, 480, 400);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			// bên trong dialog
			AppLabel lblNewLabel = new AppLabel("Chọn topping");
			lblNewLabel.setFont(ConstantValueView.normalText);
			lblNewLabel.setBounds(204, 69, 92, 19);
			getContentPane().add(lblNewLabel);
			DrinkCardComponent drinkImageCard = new DrinkCardComponent(drinkModel);
			drinkImageCard.setBounds(10, 10, 166, 223);
			
			getContentPane().add(drinkImageCard); 
			
			//Cancel Button
			 btnCancel = new AppButton("HỦY BỎ");
			btnCancel.setBounds(204, 274, 106, 33);
			getContentPane().add(btnCancel); 
			
			//Save Button
			 btnSave = new AppButton("LƯU"); 
			btnSave.setBounds(332, 274, 106, 33);
			getContentPane().add(btnSave); 
			
			//Enter amount text field (number) 
		
			
			
			//Note text field
			
			AppTextField textfieldNote = new AppTextField("Ghi chú"); 
			textfieldNote.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textfieldNote.setBounds(10, 261, 166, 45); 
			getContentPane().add(textfieldNote);
		
//			String[] toppingList = { "item1", "item2", "item3" };
//			JList<String> jListTopping = new JList<String>(toppingList);
//			add(jListTopping);
//			scrollPane_topping.setViewportView(jListTopping);
			
			
			
			
			
		}
		
		AppLabel lblNewLabel_1 = new AppLabel("Nhập số lượng");
		lblNewLabel_1.setBounds(203, 21, 106, 33);
		getContentPane().add(lblNewLabel_1);
		
		SpinnerNumberModel model = new SpinnerNumberModel(1, 0, 100, 1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(204, 98, 181, 30);
		getContentPane().add(comboBox);
		

		
		JPanel panel = new JPanel();
		
		panel.setBounds(0, 0, 10, 10);
		getContentPane().add(panel);
		NumberSpinner spinner = new NumberSpinner(model);
		spinner.setLocation(319, 18);
		getContentPane().add(spinner);
		
		ArrayList<ChooseTopping> toppingList = new ArrayList<ChooseTopping>();
		toppingList.add(new ChooseTopping(drinkModel)); 
		DrinkModel dummy = new DrinkModel("D01", "TS",20000 ,false,"/assets/bg-login.png", null,"Trà sữa", null);
		toppingList.add(new ChooseTopping(dummy)); 
		
		JScrollPane scrollPane = new JScrollPane(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 5));
		scrollPane.setBounds(204, 152, 235, 81);
		getContentPane().add(scrollPane);
		
		for (Iterator iterator = toppingList.iterator(); iterator.hasNext();) {
			ChooseTopping chooseTopping = (ChooseTopping) iterator.next();
			panel.add(chooseTopping); 
		}
		
		
		AppButton btn_addTopping = new AppButton("+");
		btn_addTopping.setBounds(395, 98, 45, 30);
		getContentPane().add(btn_addTopping);
		
		
	}
	
	
	
	
}

