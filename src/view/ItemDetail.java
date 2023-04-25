package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.DropMode;

public class ItemDetail extends JInternalFrame {
	private JTextField textField_soluongItem;
	private JTextField textField_giaItem;
	private JTextField textField_ngaynhapItem;
	private JTextField textField_motaItem;
	private JTextField textField_plItem;

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
		setBackground(new Color(240, 248, 255));
		setTitle("Thêm mặt hàng");
		setClosable(true);
		setResizable(false);
//		setNormalBounds(new Rectangle(15, 20, 420, 420));
		setBounds(0, 0, 416, 432);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(0, 0, 408, 405);
		getContentPane().add(panel);
		
		Font font = new Font("Arial", Font.PLAIN, 18);
		
		JTextField textField_nameItem;
		textField_ngaynhapItem =new JTextField();
		textField_ngaynhapItem.setBounds(10, 208, 109, 46);
		textField_ngaynhapItem.setToolTipText("Ngày nhập kho");
		textField_ngaynhapItem.setSelectionColor(Color.BLACK);
		textField_ngaynhapItem.setFont(new Font("Arial", Font.BOLD, 20));
		textField_ngaynhapItem.setColumns(5);
		textField_ngaynhapItem.setBorder(new TitledBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(139, 69, 19)), "Ngày nhập kho", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		((TitledBorder) textField_ngaynhapItem.getBorder()).setTitleFont(font);
		panel.setLayout(null);
		panel.add(textField_ngaynhapItem);
		
		textField_plItem =new JTextField();
		textField_plItem.setBounds(277, 97, 121, 46);
		textField_plItem.setToolTipText("Phân loại");
		textField_plItem.setSelectionColor(Color.BLACK);
		textField_plItem.setFont(new Font("Arial", Font.BOLD, 20));
		textField_plItem.setColumns(5);
		textField_plItem.setBorder(new TitledBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(139, 69, 19)), "Phân loại", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		((TitledBorder) textField_ngaynhapItem.getBorder()).setTitleFont(font);
		panel.setLayout(null);
		panel.add(textField_plItem);
		
		textField_giaItem =new JTextField();
		textField_giaItem.setBounds(10, 137, 109, 46);
		textField_giaItem.setToolTipText("Giá");
		textField_giaItem.setSelectionColor(Color.BLACK);
		textField_giaItem.setFont(new Font("Arial", Font.BOLD, 20));
		textField_giaItem.setColumns(5);
		textField_giaItem.setBorder(new TitledBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(139, 69, 19)), "Giá", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		((TitledBorder) textField_giaItem.getBorder()).setTitleFont(font);
		panel.setLayout(null);
		panel.add(textField_giaItem);
		
		textField_soluongItem =new JTextField();
		textField_soluongItem.setBounds(277, 185, 121, 46);
		textField_soluongItem.setToolTipText("Số lượng");
		textField_soluongItem.setSelectionColor(Color.BLACK);
		textField_soluongItem.setFont(new Font("Arial", Font.BOLD, 20));
		textField_soluongItem.setColumns(5);
		textField_soluongItem.setBorder(new TitledBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(139, 69, 19)), "Số lượng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		((TitledBorder) textField_soluongItem.getBorder()).setTitleFont(font);
		panel.setLayout(null);
		panel.add(textField_soluongItem);
		
		textField_nameItem = new JTextField();
		textField_nameItem.setBounds(277, 10, 121, 46);
		textField_nameItem.setToolTipText("Tên nguyên liệu");
		textField_nameItem.setSelectionColor(Color.BLACK);
		textField_nameItem.setFont(new Font("Arial", Font.BOLD, 20));
		textField_nameItem.setColumns(5);
		textField_nameItem.setBorder(new TitledBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(139, 69, 19)), "Tên nguyên liệu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		((TitledBorder) textField_nameItem.getBorder()).setTitleFont(font);
		panel.setLayout(null);
		
		panel.add(textField_nameItem);
		
		textField_motaItem =new JTextField();
		textField_motaItem.setBounds(10, 279, 109, 46);
		textField_motaItem.setToolTipText("Mô tả");
		textField_motaItem.setSelectionColor(Color.BLACK);
		textField_motaItem.setFont(new Font("Arial", Font.BOLD, 20));
		textField_motaItem.setColumns(5);
		textField_motaItem.setBorder(new TitledBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(139, 69, 19)), "Mô tả", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		((TitledBorder) textField_motaItem.getBorder()).setTitleFont(font);
		panel.setLayout(null);
		
		panel.add(textField_motaItem);


	}

}

