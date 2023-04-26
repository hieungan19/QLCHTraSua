package model;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.AppView;

public class DashboardOption {
	String text;
	String imageUri;
	JLabel jLabelOption; 
	JPanel jPanelOption; 
	
	public DashboardOption(String text, String imageUri, JPanel jPanelOption) {
		// TODO Auto-generated constructor stub
		this.text = text;
		this.imageUri = imageUri; 
		
		
		ImageIcon icon = new ImageIcon(AppView.class.getResource(imageUri)); 
		// Lấy hình ảnh từ biểu tượng
		Image image = icon.getImage();

		// Thay đổi kích thước của hình ảnh
		Image scaledImage = image.getScaledInstance(24,24 , Image.SCALE_SMOOTH);

		// Tạo một biểu tượng mới từ hình ảnh đã thay đổi kích thước
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		// Sử dụng biểu tượng mới để hiển thị hình ảnh đã thay đổi kích thước
		
		this.jLabelOption = new JLabel(text, scaledIcon, JLabel.LEFT);
		this.jPanelOption = jPanelOption; 

	}
	
	
	

	public JLabel getjLabelOption() {
		return jLabelOption;
	}




	public void setjLabelOption(JLabel jLabelOption) {
		this.jLabelOption = jLabelOption;
	}




	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}




	public JPanel getjPanelOption() {
		return jPanelOption;
	}




	public void setjPanelOption(JPanel jPanelOption) {
		this.jPanelOption = jPanelOption;
	}

}
