package view;

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

import diaglog.AppOptionPaneDialog;
import globalComponent.AppTextField;

public class InventoryItemDetails extends JPanel {

	/**
	 * Create the panel.
	 */

	private JButton jbutton_saveItem;
	private JButton jbutton_deleteItem;
	public InventoryItemDetails() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(420,420));
		
		Font font = new Font("Arial", Font.PLAIN, 18);
		// tao cac textfield nhập thông tin
		AppTextField jTextField_inputDate = new AppTextField("Ngày nhập"); 
		jTextField_inputDate.setBounds(10, 244, 147, 46);
		jTextField_inputDate.setToolTipText("dd/mm/yyyy");
		this.add(jTextField_inputDate); 
			
		AppTextField jTextField_unitItem = new AppTextField("Đơn vị tính");
		jTextField_unitItem.setBounds(216, 97, 165, 46);
		jTextField_unitItem.setToolTipText("Cái/Kg");
		this.add(jTextField_unitItem);

		AppTextField jTextField_priceItem = new AppTextField("Giá");
		jTextField_priceItem.setBounds(10, 176, 147, 46);
		jTextField_priceItem.setToolTipText("VNĐ");
		this.add(jTextField_priceItem);
		
		AppTextField jTextField_quantityItem = new AppTextField("Số lượng");
		jTextField_quantityItem.setBounds(216, 176, 165, 46);
		jTextField_quantityItem.setToolTipText("10,20,...");
		this.add(jTextField_quantityItem);

		AppTextField jTextField_nameItem = new AppTextField("Tên mặt hàng");
		jTextField_nameItem.setBounds(216, 10, 165, 46);
		jTextField_nameItem.setToolTipText("Tên");
		this.add(jTextField_nameItem);
		
		AppTextField jTextField_desItem = new AppTextField("Mô tả");
		jTextField_desItem.setBounds(10, 314, 198, 46);
		jTextField_desItem.setToolTipText("Option");
		this.add(jTextField_desItem);

		// chèn ảnh vô khung
		JEditorPane jeditorPane_image = new JEditorPane();
		jeditorPane_image.setForeground(new Color(0, 0, 0));
		jeditorPane_image.setBounds(12, 10, 105, 95);
		jeditorPane_image.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(jeditorPane_image);

		JButton jbutton_chooseFile = new JButton("Chọn file");
		jbutton_chooseFile.setBackground(new Color(211, 211, 211));
		jbutton_chooseFile.setForeground(new Color(255, 250, 205));
		jbutton_chooseFile.setFont(new Font("Arial", Font.BOLD, 12));
		jbutton_chooseFile.setBounds(22, 114, 87, 27);
		this.add(jbutton_chooseFile);
		
		// tạo nút lưu mặt hàng
		jbutton_saveItem = new JButton("Lưu");
		jbutton_saveItem.setFont(new Font("Arial", Font.BOLD, 15));
		jbutton_saveItem.setHorizontalTextPosition(JButton.RIGHT);
		jbutton_saveItem.setVerticalTextPosition(JButton.CENTER);
		jbutton_saveItem.setIcon(new ImageIcon(getClass().getResource("/assets/save.png")));
		jbutton_saveItem.setIconTextGap(20);
		jbutton_saveItem.setForeground(new Color(255, 255, 255));
		jbutton_saveItem.setBackground(new Color(204, 102, 51));
		jbutton_saveItem.setBounds(277, 365, 121, 27);
		jbutton_saveItem.setBorder(null);
		this.add(jbutton_saveItem);

		// tạo nút xóa mặt hàng
		jbutton_deleteItem = new JButton("Xóa");
		jbutton_deleteItem.setFont(new Font("Arial", Font.BOLD, 15));
		jbutton_deleteItem.setHorizontalTextPosition(JButton.RIGHT);
		jbutton_deleteItem.setVerticalTextPosition(JButton.CENTER);
		jbutton_deleteItem.setIcon(new ImageIcon(getClass().getResource("/assets/delete.png")));
		jbutton_deleteItem.setIconTextGap(20);
		jbutton_deleteItem.setForeground(new Color(255, 255, 255));
		jbutton_deleteItem.setBackground(new Color(204, 102, 51));
		jbutton_deleteItem.setBounds(149, 365, 121, 27);
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
