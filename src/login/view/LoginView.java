//LOGIN VIEW
package login.view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.border.TitledBorder;

import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_username;
	private JTextField textField_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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

	public LoginView() {
		setSize(1040, 740);
		Image logo = new ImageIcon(LoginView.class.getResource("/assets/tea-logo.png")).getImage();
		this.setIconImage(logo);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Font font = new Font("Arial", Font.PLAIN, 18);

		JLabel lblNewLabel_1 = new JLabel("WELCOME");
		lblNewLabel_1.setForeground(new Color(139, 69, 19));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 60));
		lblNewLabel_1.setBounds(81, 151, 314, 77);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(
				"<html><div style='text-align: center;'>HỆ THỐNG QUẢN LÝ<br>CỬA HÀNG KINH DOANH TRÀ SỮA</div></html");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel_2.setBounds(545, 34, 448, 86);
		contentPane.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(545, 156, 448, 433);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_3.setBounds(0, 0, 448, 156);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(139, 69, 19));
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 36));
		panel_1.add(lblNewLabel_3);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(21, 156, 405, 156);
		panel.setBackground(SystemColor.control);
		panel_1.add(panel);
		panel.setLayout(new GridLayout(0, 1, 20, 20));

		textField_username = new JTextField();
		textField_username.setToolTipText("Enter your username");
		textField_username.setSelectionColor(Color.BLACK);
		textField_username.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField_username.setColumns(10);
		textField_username.setBorder(new TitledBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(139, 69, 19)),
				"User name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(139, 69, 19)));
		((TitledBorder) textField_username.getBorder()).setTitleFont(font);

		panel.add(textField_username);

		textField_password = new JTextField();
		textField_password.setToolTipText("Enter your password");
		textField_password.setColumns(10);
		textField_password.setBorder(new TitledBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(139, 69, 19)),
				"Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(139, 69, 19)));
		((TitledBorder) textField_password.getBorder()).setTitleFont(font);
		panel.add(textField_password);

		JButton jButton_login = new JButton("Login");
		jButton_login.setHorizontalTextPosition(SwingConstants.CENTER);
		jButton_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jButton_login.setBounds(57, 341, 333, 47);
		jButton_login.setForeground(new Color(255, 250, 250));
		jButton_login.setFont(new Font("SansSerif", Font.BOLD, 20));
		jButton_login.setBorder(null);
		jButton_login.setBackground(new Color(139, 69, 19));
		panel_1.add(jButton_login);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/assets/bg-login.png")));
		lblNewLabel.setBounds(0, 0, 726, 703);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_4 = new JLabel("Copyright © 2023 Dilamdoan");
		lblNewLabel_4.setForeground(new Color(128, 128, 128));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(754, 668, 262, 25);
		contentPane.add(lblNewLabel_4);

	}
}
