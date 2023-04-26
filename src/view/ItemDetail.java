package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import model.CustomTextField;
import view.ItemDetail;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;

public class ItemDetail extends JInternalFrame {
	private CustomTextField textField_soluongItem;
	private CustomTextField textField_giaItem;
	private CustomTextField textField_ngaynhapItem;
	private CustomTextField textField_motaItem;
	private CustomTextField textField_plItem;
	private CustomTextField textField_nameItem;
	private JButton jbutton_saveItem;
	private JButton jbutton_deleteItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemDetail frame = new ItemDetail();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ItemDetail() {
		setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), null));
		setBackground(new Color(255, 255, 204));
		setTitle("Thêm mặt hàng");
		setForeground(new Color(204, 102, 0));
		setClosable(true);
		setResizable(false);
		setBounds(0, 0, 423, 433);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		panel.setBounds(0, 0, 412, 405);
		getContentPane().add(panel);

		Font font = new Font("Arial", Font.PLAIN, 18);
		// tao cac textfield nhập thông tin
		textField_ngaynhapItem = new CustomTextField(10);
		textField_ngaynhapItem.setBounds(10, 244, 147, 46);
		textField_ngaynhapItem.setToolTipText("Ngày nhập kho");
		textField_ngaynhapItem.setSelectionColor(Color.BLACK);
		textField_ngaynhapItem.setFont(new Font("Arial", Font.BOLD, 20));
		textField_ngaynhapItem.setColumns(5);
		textField_ngaynhapItem.setBorder(new TitledBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(139, 69, 19)),
				"Ngày nhập kho", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		((TitledBorder) textField_ngaynhapItem.getBorder()).setTitleFont(font);
		textField_ngaynhapItem.setPlaceholder("dd/mm/yyyy");
		textField_ngaynhapItem.setPlaceholderFont(new Font("Arial", Font.ITALIC, 12));
		textField_ngaynhapItem.setPlaceholderColor(Color.GRAY);
		panel.setLayout(null);
		panel.add(textField_ngaynhapItem);

		textField_plItem = new CustomTextField(10);
		textField_plItem.setBounds(216, 97, 165, 46);
		textField_plItem.setToolTipText("Phân loại");
		textField_plItem.setSelectionColor(Color.BLACK);
		textField_plItem.setFont(new Font("Arial", Font.BOLD, 20));
		textField_plItem.setColumns(5);
		textField_plItem.setBorder(new TitledBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(139, 69, 19)),
				"Phân loại", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		((TitledBorder) textField_ngaynhapItem.getBorder()).setTitleFont(font);
		textField_plItem.setPlaceholder("nguyên liệu/hương vị...");
		textField_plItem.setPlaceholderFont(new Font("Arial", Font.ITALIC, 12));
		textField_plItem.setPlaceholderColor(Color.GRAY);
		panel.setLayout(null);
		panel.add(textField_plItem);

		textField_giaItem = new CustomTextField(10);
		textField_giaItem.setBounds(10, 176, 147, 46);
		textField_giaItem.setToolTipText("Giá");
		textField_giaItem.setSelectionColor(Color.BLACK);
		textField_giaItem.setFont(new Font("Arial", Font.BOLD, 20));
		textField_giaItem.setColumns(5);
		textField_giaItem.setBorder(new TitledBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(139, 69, 19)), "Giá",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		((TitledBorder) textField_giaItem.getBorder()).setTitleFont(font);
		textField_giaItem.setPlaceholder("vnđ");
		textField_giaItem.setPlaceholderFont(new Font("Arial", Font.ITALIC, 12));
		textField_giaItem.setPlaceholderColor(Color.GRAY);
		panel.setLayout(null);
		panel.add(textField_giaItem);

		textField_soluongItem = new CustomTextField(10);
		textField_soluongItem.setBounds(216, 176, 165, 46);
		textField_soluongItem.setToolTipText("Số lượng");
		textField_soluongItem.setSelectionColor(Color.BLACK);
		textField_soluongItem.setFont(new Font("Arial", Font.BOLD, 20));
		textField_soluongItem.setColumns(5);
		textField_soluongItem.setBorder(new TitledBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(139, 69, 19)),
				"Số lượng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		((TitledBorder) textField_soluongItem.getBorder()).setTitleFont(font);
		textField_soluongItem.setPlaceholder("10,20,30,...");
		textField_soluongItem.setPlaceholderFont(new Font("Arial", Font.ITALIC, 12));
		textField_soluongItem.setPlaceholderColor(Color.GRAY);
		panel.setLayout(null);
		panel.add(textField_soluongItem);

		textField_nameItem = new CustomTextField(10);
		textField_nameItem.setBounds(216, 10, 165, 46);
		textField_nameItem.setToolTipText("Tên nguyên liệu");
		textField_nameItem.setSelectionColor(Color.BLACK);
		textField_nameItem.setFont(new Font("Arial", Font.BOLD, 20));
		textField_nameItem.setColumns(5);
		textField_nameItem.setBorder(new TitledBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(139, 69, 19)),
				"Tên nguyên liệu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		((TitledBorder) textField_nameItem.getBorder()).setTitleFont(font);
		textField_nameItem.setPlaceholder("Tên");
		textField_nameItem.setPlaceholderFont(new Font("Arial", Font.ITALIC, 12));
		textField_nameItem.setPlaceholderColor(Color.GRAY);
		panel.setLayout(null);
		panel.add(textField_nameItem);

		textField_motaItem = new CustomTextField(10);
		textField_motaItem.setBounds(10, 314, 198, 46);
		textField_motaItem.setToolTipText("Mô tả");
		textField_motaItem.setSelectionColor(Color.BLACK);
		textField_motaItem.setFont(new Font("Arial", Font.BOLD, 20));
		textField_motaItem.setColumns(5);
		textField_motaItem.setBorder(new TitledBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(139, 69, 19)),
				"Mô tả", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		((TitledBorder) textField_motaItem.getBorder()).setTitleFont(font);
		textField_motaItem.setPlaceholder("option");
		textField_motaItem.setPlaceholderFont(new Font("Arial", Font.ITALIC, 12));
		textField_motaItem.setPlaceholderColor(Color.GRAY);
		panel.setLayout(null);
		panel.add(textField_motaItem);

		// chèn ảnh vô khung
		JEditorPane jeditorPane_image = new JEditorPane();
		jeditorPane_image.setForeground(new Color(0, 0, 0));
		jeditorPane_image.setBounds(12, 10, 105, 95);
		jeditorPane_image.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.add(jeditorPane_image);

		JButton jbutton_chooseFile = new JButton("Chọn file");
		jbutton_chooseFile.setBackground(new Color(211, 211, 211));
		jbutton_chooseFile.setForeground(new Color(255, 250, 205));
		jbutton_chooseFile.setFont(new Font("Arial", Font.BOLD, 12));
		jbutton_chooseFile.setBounds(22, 114, 87, 27);
		panel.add(jbutton_chooseFile);

		// tạo nút lưu mặt hàng
		jbutton_saveItem = new JButton("Lưu");
		jbutton_saveItem.setFont(new Font("Arial", Font.BOLD, 15));
		jbutton_saveItem.setHorizontalTextPosition(JButton.RIGHT);
		jbutton_saveItem.setVerticalTextPosition(JButton.CENTER);
		jbutton_saveItem.setIcon(new ImageIcon(ItemDetail.class.getResource("/assets/save.png")));
		jbutton_saveItem.setIconTextGap(20);
		jbutton_saveItem.setForeground(new Color(255, 255, 255));
		jbutton_saveItem.setBackground(new Color(204, 102, 51));
		jbutton_saveItem.setBounds(277, 365, 121, 27);
		jbutton_saveItem.setBorder(null);
		panel.add(jbutton_saveItem);

		// tạo nút xóa mặt hàng
		jbutton_deleteItem = new JButton("Xóa");
		jbutton_deleteItem.setFont(new Font("Arial", Font.BOLD, 15));
		jbutton_deleteItem.setHorizontalTextPosition(JButton.RIGHT);
		jbutton_deleteItem.setVerticalTextPosition(JButton.CENTER);
		jbutton_deleteItem.setIcon(new ImageIcon(ItemDetail.class.getResource("/assets/delete.png")));
		jbutton_deleteItem.setIconTextGap(20);
		jbutton_deleteItem.setForeground(new Color(255, 255, 255));
		jbutton_deleteItem.setBackground(new Color(204, 102, 51));
		jbutton_deleteItem.setBounds(149, 365, 121, 27);
		jbutton_deleteItem.setBorder(null);
		panel.add(jbutton_deleteItem);

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
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						dialog.dispose();
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

				dialog.add(panel_dialog);
				dialog.pack();
				dialog.setVisible(true);
			}
		});

	}
}