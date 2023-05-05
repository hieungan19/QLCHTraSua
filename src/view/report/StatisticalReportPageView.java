package view.report;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import globalComponent.AppButton;
import globalComponent.AppLabel;
import globalComponent.DatePickerComponent;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JLabel;

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
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[] {0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0};
		contentPanel.setLayout(gbl_contentPanel);
		
		AppLabel lblNewLabel = new AppLabel("New label",24, true);
		lblNewLabel.setText("BÁO CÁO THỐNG KÊ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weighty = 2.0;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPanel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new GridLayout(1, 1, 20, 20));
		
		AppLabel lblNewLabel_1 = new AppLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setText("From: ");
		panel.add(lblNewLabel_1);
		
		DatePickerComponent startDay = new DatePickerComponent();
		BorderLayout borderLayout = (BorderLayout) startDay.getLayout();
		panel.add(startDay);
		
		
		AppLabel lblNewLabel_2 = new AppLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setText("To:");
		panel.add(lblNewLabel_2);
		
		DatePickerComponent endDay = new DatePickerComponent();
		BorderLayout borderLayout_1 = (BorderLayout) endDay.getLayout();
		panel.add(endDay);
        Border roundedBorder = BorderFactory.createCompoundBorder();
        
        JPanel panel_3 = new JPanel();
        GridBagConstraints gbc_panel_3 = new GridBagConstraints();
        gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel_3.insets = new Insets(0, 0, 20, 0);
        gbc_panel_3.gridx = 0;
        gbc_panel_3.gridy = 2;
        contentPanel.add(panel_3, gbc_panel_3);
        panel_3.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 5));
        
        AppButton btnNewButton = new AppButton("New button");
        btnNewButton.setPreferredSize(new Dimension(180, 40));
        btnNewButton.setText("KẾT XUẤT BÁO CÁO");
        panel_3.add(btnNewButton);
        
        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.insets = new Insets(0, 0, 5, 0);
        gbc_panel_2.gridx = 0;
        gbc_panel_2.gridy = 3;
        contentPanel.add(panel_2, gbc_panel_2);
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
        
        JPanel roundedPanel = new JPanel();
        panel_2.add(roundedPanel);
        roundedPanel.setBackground(SystemColor.info);
        roundedPanel.setPreferredSize(new Dimension(200, 150));
        roundedPanel.setBorder(UIManager.getBorder("RadioButton.border"));
        roundedPanel.setLayout(new GridLayout(0, 1, 0, 0));
        
                AppLabel label1 = new AppLabel("DOANH THU",24,true);
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                
                roundedPanel.add(label1);
                
                        AppLabel label2 = new AppLabel("Doanh thu:");
                        roundedPanel.add(label2);
                        
                        AppLabel lblNewLabel_3 = new AppLabel("Chi phí:");
                        roundedPanel.add(lblNewLabel_3);
                        
                        AppLabel lblNewLabel_4 = new AppLabel("Lợi nhuận:");
                        roundedPanel.add(lblNewLabel_4);
                        
                        AppLabel label = new AppLabel("");
                        panel_2.add(label);
                        
                        JPanel roundedPanel_1 = new JPanel();
                        roundedPanel_1.setPreferredSize(new Dimension(200, 150));
                        roundedPanel_1.setBorder(UIManager.getBorder("RadioButton.border"));
                        roundedPanel_1.setBackground(SystemColor.info);
                        panel_2.add(roundedPanel_1);
                        roundedPanel_1.setLayout(new GridLayout(0, 1, 0, 0));
                        
                        AppLabel label1_1 = new AppLabel("DOANH THU", 24, true);
                        label1_1.setText("KHÁCH HÀNG");
                        label1_1.setHorizontalAlignment(SwingConstants.CENTER);
                        roundedPanel_1.add(label1_1);
                        
                        AppLabel label2_1 = new AppLabel("Tổng hóa đơn");
                        roundedPanel_1.add(label2_1);
                        
                        AppLabel lblNewLabel_5 = new AppLabel("Số khách hàng thành viên:");
                        roundedPanel_1.add(lblNewLabel_5);
                        
                        AppLabel lblNewLabel_6 = new AppLabel("Số khách hàng VIP:");
                        roundedPanel_1.add(lblNewLabel_6);
                        
                        AppLabel label_1 = new AppLabel("");
                        panel_2.add(label_1);
                        
                        JPanel roundedPanel_1_1 = new JPanel();
                        roundedPanel_1_1.setPreferredSize(new Dimension(200, 150));
                        roundedPanel_1_1.setBorder(UIManager.getBorder("RadioButton.border"));
                        roundedPanel_1_1.setBackground(SystemColor.info);
                        panel_2.add(roundedPanel_1_1);
                        roundedPanel_1_1.setLayout(new GridLayout(0, 1, 0, 0));
                        
                        AppLabel label1_1_1 = new AppLabel("DOANH THU", 24, true);
                        label1_1_1.setText("NHÂN VIÊN");
                        label1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
                        roundedPanel_1_1.add(label1_1_1);
                        
                        AppLabel label2_1_1 = new AppLabel("Tổng số nhân viên:");
                        roundedPanel_1_1.add(label2_1_1);
                        
                        AppLabel lblNewLabel_7 = new AppLabel("Tổng lương");
                        roundedPanel_1_1.add(lblNewLabel_7);
                        
                        JLabel lblNewLabel_8 = new JLabel("");
                        roundedPanel_1_1.add(lblNewLabel_8);
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(5, "Sales", "Product 1");
        dataset.setValue(10, "Sales", "Product 2");
        dataset.setValue(15, "Sales", "Product 3");
        dataset.setValue(20, "Sales", "Product 4");
        
        // Create chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Product Sales",
            "Product",
            "Sales",
            dataset,
            PlotOrientation.VERTICAL,
            false,
            true,
            false);
        
        // Customize chart appearance
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(java.awt.Color.BLACK);
        
        // Display chart
        ChartPanel chartPanel = new ChartPanel(chart);
        GridBagConstraints gbc_chartPanel = new GridBagConstraints();
        gbc_chartPanel.insets = new Insets(0, 0, 5, 0);
        gbc_chartPanel.gridx = 0;
        gbc_chartPanel.gridy = 4;
        contentPanel.add(chartPanel, gbc_chartPanel);
        chartPanel.setPreferredSize(new Dimension(790, 300));
	}
}
