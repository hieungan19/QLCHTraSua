package view.statisticalReport;

import java.awt.Color;

import javax.swing.JPanel;

public class StatisticalReportPageView extends JPanel {

	/**
	 * Create the panel.
	 */
	public StatisticalReportPageView() {
		setBackground(Color.WHITE);
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(20, 20, 790, 630);
		this.setLayout(null);
		this.add(contentPanel);
	}

}
