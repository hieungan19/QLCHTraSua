package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JList;
import javax.swing.JScrollPane;


public class ProductViewDetails extends JPanel {

	/**
	 * Create the panel.
	 */

	private JButton jbutton_saveProduct;
	private JButton jbutton_deleteProduct;
	private AppTextField jTextField_type;
	public ProductViewDetails () {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(840, 740));
		this.setBackground(new Color(245, 222, 179));

		
		Font font = new Font("Arial", Font.PLAIN, 18);
		
		//Tạo comboBox chọn loại sản phẩm
		JComboBox<String> comboBox_unitProduct = new JComboBox<String>();
		comboBox_unitProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_unitProduct.addItem("Trà sữa");
		comboBox_unitProduct.addItem("Đá xay");
		comboBox_unitProduct.addItem("Trà");
		comboBox_unitProduct.addItem("Kem");
		comboBox_unitProduct.addItem("Bánh");
		comboBox_unitProduct.addItem("Topping");
		comboBox_unitProduct.setName("Phân loại");
		comboBox_unitProduct.setBackground(new Color(245, 222, 179));
		comboBox_unitProduct.setBounds(515, 196, 165, 35);
		this.add(comboBox_unitProduct);
		// Lấy giá trị đơn vị tính được chọn
		String unitProduct = comboBox_unitProduct.getSelectedItem().toString();
		//nhãn Phân loại
		JLabel jLabel_unitProduct = new JLabel("Phân loại");
		jLabel_unitProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel_unitProduct.setForeground(ConstantValueView.primaryDark);
		jLabel_unitProduct.setBounds(515, 159, 78, 27);
		add(jLabel_unitProduct);
		
		//Tạo jlist chọn topping
		String [] listTopping = {"Trân trâu đen", "Trân trâu trắng", "Sương sáo"};
		JList list_selectTopping = new JList(listTopping);
		list_selectTopping.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list_selectTopping.setSelectionBackground(Color.LIGHT_GRAY);
		list_selectTopping.setBackground(new Color(245, 222, 179));
		list_selectTopping.setBounds(515, 312, 165, 46);
		add(list_selectTopping);
		
		JScrollPane scrollPane_topping = new JScrollPane(list_selectTopping);
		scrollPane_topping.setLocation(515, 295);
     	scrollPane_topping.setSize(165, 25);
		add(scrollPane_topping);
		
		//nhãn Topping
		JLabel jLabel_selectTopping = new JLabel("Topping");
		jLabel_selectTopping.setFont(new Font("Tahoma", Font.PLAIN,16));
		jLabel_selectTopping.setForeground(ConstantValueView.primaryDark);
		jLabel_selectTopping.setBounds(515,  258, 78, 27);
		add(jLabel_selectTopping);


		//Tạo các textfield 
		AppTextField jTextField_priceProduct = new AppTextField("Giá");
		jTextField_priceProduct.setBounds(10, 333, 172, 55);
		jTextField_priceProduct.setToolTipText("VNĐ");
		this.add(jTextField_priceProduct);
		
		AppTextField jTextField_nameProduct = new AppTextField("Tên sản phẩm");
		jTextField_nameProduct.setBounds(515, 73, 239, 55);
		jTextField_nameProduct.setToolTipText("tên");
		this.add(jTextField_nameProduct);
		
		AppTextField jTextField_desProduct = new AppTextField("Mô tả");
		jTextField_desProduct.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jTextField_desProduct.setBounds(10, 432, 343, 55);
		jTextField_desProduct.setToolTipText("option");
		this.add(jTextField_desProduct);

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
		jbutton_saveProduct = new JButton("Lưu");
		jbutton_saveProduct.setFont(new Font("Arial", Font.BOLD, 25));
		jbutton_saveProduct.setHorizontalTextPosition(JButton.RIGHT);
		jbutton_saveProduct.setVerticalTextPosition(JButton.CENTER);
		jbutton_saveProduct.setIcon(new ImageIcon(getClass().getResource("/assets/save.png")));
		jbutton_saveProduct.setIconTextGap(20);
		jbutton_saveProduct.setForeground(new Color(255, 255, 255));
		jbutton_saveProduct.setBackground(new Color(204, 102, 51));
		jbutton_saveProduct.setBounds(597, 615, 147, 60);
		jbutton_saveProduct.setBorder(null);
		this.add(jbutton_saveProduct);

		// tạo nút xóa mặt hàng
		jbutton_deleteProduct = new JButton("Xóa");
		jbutton_deleteProduct.setFont(new Font("Arial", Font.BOLD, 25));
		jbutton_deleteProduct.setHorizontalTextPosition(JButton.RIGHT);
		jbutton_deleteProduct.setVerticalTextPosition(JButton.CENTER);
		jbutton_deleteProduct.setIcon(new ImageIcon(getClass().getResource("/assets/delete.png")));
		jbutton_deleteProduct.setIconTextGap(20);
		jbutton_deleteProduct.setForeground(new Color(255, 255, 255));
		jbutton_deleteProduct.setBackground(new Color(204, 102, 51));
		jbutton_deleteProduct.setBounds(353, 615, 147, 60);
		jbutton_deleteProduct.setBorder(null);
		this.add(jbutton_deleteProduct);
		
		
		
		
		

		// tạo hộp thoại xóa
		jbutton_deleteProduct.addActionListener(new ActionListener() {
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