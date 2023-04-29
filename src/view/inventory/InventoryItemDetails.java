package view.inventory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import constant.ConstantValueView;
import diaglog.AppOptionPaneDialog;
import globalComponent.AppTextField;
import javax.swing.JComboBox;

public class InventoryItemDetails extends JPanel {

	/**
	 * Create the panel.
	 */

	private JButton jbutton_saveItem;
	private JButton jbutton_deleteItem;
	private AppTextField jTextField_type;
	public InventoryItemDetails() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(840, 740));
		this.setBackground(new Color(245, 222, 179));

		
		Font font = new Font("Arial", Font.PLAIN, 18);
		// tao cac textfield nhập thông tin
		AppTextField jTextField_inputDate = new AppTextField("Ngày nhập"); 
		jTextField_inputDate.setBounds(10, 381, 192, 55);
		jTextField_inputDate.setToolTipText("dd/mm/yyyy");
		this.add(jTextField_inputDate); 
			
		JComboBox<String> comboBox_unitItem = new JComboBox<String>();
		comboBox_unitItem.addItem("Cái");
		comboBox_unitItem.addItem("Kg");
		comboBox_unitItem.setName("Đơn vị tính");
		comboBox_unitItem.setBounds(515, 196, 165, 46);
		this.add(comboBox_unitItem);
		// Lấy giá trị đơn vị tính được chọn
		String unitItem = comboBox_unitItem.getSelectedItem().toString();
		JLabel jLabel_unitItem = new JLabel("Đơn vị tính");
		jLabel_unitItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel_unitItem.setForeground(ConstantValueView.primaryDark);
		jLabel_unitItem.setBounds(515, 159, 78, 27);
		add(jLabel_unitItem);



//		AppTextField jTextField_unitItem = new AppTextField("Đơn vị tính");
//		jTextField_unitItem.setBounds(216, 97, 165, 46);
//		jTextField_unitItem.setToolTipText("Cái/Kg");
//		this.add(jTextField_unitItem);

		AppTextField jTextField_priceItem = new AppTextField("Giá");
		jTextField_priceItem.setBounds(10, 273, 192, 55);
		jTextField_priceItem.setToolTipText("VNĐ");
		this.add(jTextField_priceItem);
		
		AppTextField jTextField_Itemquantity = new AppTextField("Số lượng");
		jTextField_Itemquantity.setBounds(515, 273, 229, 55);
		jTextField_Itemquantity.setToolTipText("10,20,...");
		this.add(jTextField_Itemquantity);
		
		AppTextField jTextField_nameItem = new AppTextField("Tên mặt hàng");
		jTextField_nameItem.setBounds(515, 73, 239, 55);
		jTextField_nameItem.setToolTipText("tên");
		this.add(jTextField_nameItem);
		
		AppTextField jTextField_desItem = new AppTextField("Mô tả");
		jTextField_desItem.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jTextField_desItem.setBounds(10, 495, 315, 55);
		jTextField_desItem.setToolTipText("option");
		this.add(jTextField_desItem);

		// chèn ảnh vô khung
		JEditorPane jeditorPane_image = new JEditorPane();
		jeditorPane_image.setForeground(new Color(0, 0, 0));
		jeditorPane_image.setBounds(20, 40, 138, 121);
		jeditorPane_image.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(jeditorPane_image);

		JButton jbutton_chooseFile = new JButton("Chọn file");
		jbutton_chooseFile.setBackground(new Color(211, 211, 211));
		jbutton_chooseFile.setForeground(new Color(255, 255, 102));
		jbutton_chooseFile.setFont(new Font("Arial", Font.BOLD, 16));
		jbutton_chooseFile.setBounds(34, 177, 105, 46);
		this.add(jbutton_chooseFile);
		
		// tạo nút lưu mặt hàng
		jbutton_saveItem = new JButton("Lưu");
		jbutton_saveItem.setFont(new Font("Arial", Font.BOLD, 25));
		jbutton_saveItem.setHorizontalTextPosition(JButton.RIGHT);
		jbutton_saveItem.setVerticalTextPosition(JButton.CENTER);
		jbutton_saveItem.setIcon(new ImageIcon(getClass().getResource("/assets/save.png")));
		jbutton_saveItem.setIconTextGap(20);
		jbutton_saveItem.setForeground(new Color(255, 255, 255));
		jbutton_saveItem.setBackground(new Color(204, 102, 51));
		jbutton_saveItem.setBounds(597, 615, 147, 60);
		jbutton_saveItem.setBorder(null);
		this.add(jbutton_saveItem);

		// tạo nút xóa mặt hàng
		jbutton_deleteItem = new JButton("Xóa");
		jbutton_deleteItem.setFont(new Font("Arial", Font.BOLD, 25));
		jbutton_deleteItem.setHorizontalTextPosition(JButton.RIGHT);
		jbutton_deleteItem.setVerticalTextPosition(JButton.CENTER);
		jbutton_deleteItem.setIcon(new ImageIcon(getClass().getResource("/assets/delete.png")));
		jbutton_deleteItem.setIconTextGap(20);
		jbutton_deleteItem.setForeground(new Color(255, 255, 255));
		jbutton_deleteItem.setBackground(new Color(204, 102, 51));
		jbutton_deleteItem.setBounds(353, 615, 147, 60);
		jbutton_deleteItem.setBorder(null);
		this.add(jbutton_deleteItem);
		
		

		// tạo hộp thoại xóa
		jbutton_deleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JDialog dialog = new JDialog();
				dialog.setTitle("Xác nhận xóa nguyên liệu đã chon?");
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setSize(500, 300);
				dialog.setLocationRelativeTo(null);
				dialog.setBackground(new Color(245, 222, 179));
				dialog.setFont(new Font("Arial", Font.BOLD, 15));
				dialog.setForeground(new Color(139, 69, 19));
				dialog.setResizable(false);

				JPanel panel_dialog = new JPanel(new GridLayout(2, 1));
				JLabel label_dialog = new JLabel("Lưu ý dữ liệu sẽ bị xóa hoàn toàn và không thể khôi phục.");
				label_dialog.setHorizontalAlignment(SwingConstants.CENTER);
				label_dialog.setVerticalAlignment(SwingConstants.CENTER);

				JPanel panel_buttons = new JPanel(new FlowLayout());
				JButton okButton = new JButton("Xác nhận");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Xử lý khi người dùng xác nhận xóa
						//đóng dialog yêu cầu xác nhận xóa
						Window window = SwingUtilities.getWindowAncestor(panel_dialog);
				        window.dispose(); 
				        
						AppOptionPaneDialog dialog = new AppOptionPaneDialog("Xóa thành công"); 
						
						
					}
				});

				JButton cancelButton = new JButton("Hủy bỏ");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Xử lý khi người dùng hủy bỏ
						dialog.dispose();
					}
				});

				panel_buttons.add(okButton);
				panel_buttons.add(cancelButton);

				panel_dialog.add(label_dialog);
				panel_dialog.add(panel_buttons);

				dialog.getContentPane().add(panel_dialog);
				dialog.pack();
				dialog.setVisible(true);
			}
		});

		this.setVisible(true); 
	}
}
