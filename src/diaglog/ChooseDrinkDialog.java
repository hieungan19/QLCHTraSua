package diaglog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import component.DrinkCardComponentView;
import globalComponent.AppButton;
import globalComponent.AppTextField;
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
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			// bên trong dialog
			JLabel lblNewLabel = new JLabel("Chọn topping");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(203, 135, 68, 15);
			getContentPane().add(lblNewLabel);
			DrinkCardComponentView drinkImageCard = new DrinkCardComponentView(drinkModel);
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
			AppTextField textfieldAmount = new AppTextField("Nhập số lượng"); 
			textfieldAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textfieldAmount.setText("1");
			textfieldAmount.setBounds(203, 10, 119, 45); 
			getContentPane().add(textfieldAmount); 
			
			//Note text field
			
			AppTextField textfieldNote = new AppTextField("Ghi chú"); 
			textfieldNote.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textfieldNote.setBounds(203, 80, 237, 45); 
			getContentPane().add(textfieldNote);
			
			//ScrollPane Topping
			
			JScrollPane scrollPane_topping = new JScrollPane();
			scrollPane_topping.setBounds(203, 160, 237, 73);
			getContentPane().add(scrollPane_topping);
		
			String[] toppingList = { "item1", "item2", "item3" };
			JList<String> jListTopping = new JList<String>(toppingList);
			add(jListTopping);
			scrollPane_topping.setViewportView(jListTopping);
		}
	}

}
