package view.home;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

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

public class ChooseDrinkDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private AppButton btnCancel;
	private AppButton btnSave;
	/**
	 * Create the dialog.
	 */
	public ChooseDrinkDialog(DrinkModel drinkModel) {
		setBounds(0, 0, 480, 350);
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
			lblNewLabel.setBounds(203, 64, 92, 19);
			getContentPane().add(lblNewLabel);
			DrinkCardComponent drinkImageCard = new DrinkCardComponent(drinkModel);
			drinkImageCard.setBounds(10, 10, 166, 223);
			
			getContentPane().add(drinkImageCard); 
			
			//Cancel Button
			 btnCancel = new AppButton("HỦY BỎ");
			btnCancel.setBounds(40, 257, 106, 33);
			getContentPane().add(btnCancel); 
			
			//Save Button
			 btnSave = new AppButton("LƯU"); 
			btnSave.setBounds(271, 257, 106, 33);
			getContentPane().add(btnSave); 
			
			//Enter amount text field (number) 
		
			
			
			//Note text field
			
			AppTextField textfieldNote = new AppTextField("Ghi chú"); 
			textfieldNote.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textfieldNote.setBounds(203, 191, 253, 45); 
			getContentPane().add(textfieldNote);
			
			//ScrollPane Topping
			
			JScrollPane scrollPane_topping = new JScrollPane();
			scrollPane_topping.setBounds(203, 98, 253, 83);
			getContentPane().add(scrollPane_topping);
		
//			String[] toppingList = { "item1", "item2", "item3" };
//			JList<String> jListTopping = new JList<String>(toppingList);
//			add(jListTopping);
//			scrollPane_topping.setViewportView(jListTopping);
			
			
			
			
			
		}
		
		AppLabel lblNewLabel_1 = new AppLabel("Nhập số lượng");
		lblNewLabel_1.setBounds(203, 21, 106, 33);
		getContentPane().add(lblNewLabel_1);
		
		SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 100, 1);
		NumberSpinner spinner = new NumberSpinner(model);
		spinner.setLocation(319, 18);
		getContentPane().add(spinner);
	}

}
