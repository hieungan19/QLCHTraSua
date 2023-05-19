package view;

import java.awt.Dimension;

import javax.swing.JPanel;

import constant.ConstantValueView;
import globalComponent.AppLabel;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class EmptyView extends JPanel {

	/**
	 * Create the panel.
	 */
	public EmptyView() {
		this.setPreferredSize(new Dimension(840, 740));
		this.setBackground(ConstantValueView.background);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		AppLabel lblNewLabel = new AppLabel("BẠN KHÔNG CÓ QUYỀN TRUY CẬP TRANG NÀY.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setMaximumSize(new Dimension(400, 19));
		lblNewLabel.setPreferredSize(new Dimension(400, 32));
		
		add(lblNewLabel);
	}

}
