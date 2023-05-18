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

import controller.ReportController;

import javax.swing.UIManager;
import java.awt.SystemColor;

public class StatisticalReportPageView extends JPanel {

	ReportController report;
	public AppLabel num_mem;
	public AppLabel bills;
	public AppLabel ingreTotal;
	public AppLabel billTotal;
	public AppButton btn_report;
	public DatePickerComponent startDate;
	public DatePickerComponent endDate;
	public DefaultCategoryDataset dataset; 
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
		
		startDate = new DatePickerComponent();
		BorderLayout borderLayout = (BorderLayout) startDate.getLayout();
		panel.add(startDate);
		
		
		AppLabel lblNewLabel_2 = new AppLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setText("To:");
		panel.add(lblNewLabel_2);
		
		endDate = new DatePickerComponent();
		BorderLayout borderLayout_1 = (BorderLayout) endDate.getLayout();
		panel.add(endDate);
        Border roundedBorder = BorderFactory.createCompoundBorder();
        
        JPanel panel_3 = new JPanel();
        GridBagConstraints gbc_panel_3 = new GridBagConstraints();
        gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel_3.insets = new Insets(0, 0, 20, 0);
        gbc_panel_3.gridx = 0;
        gbc_panel_3.gridy = 2;
        contentPanel.add(panel_3, gbc_panel_3);
        panel_3.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 5));
        
        btn_report = new AppButton("New button");
        btn_report.setPreferredSize(new Dimension(180, 40));
        btn_report.setText("KẾT XUẤT BÁO CÁO");
        panel_3.add(btn_report);
        
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
        roundedPanel.setLayout(new GridLayout(4, 1, 0, 0));
        
                AppLabel lbl_NV = new AppLabel("DOANH THU",24,true);
                lbl_NV.setText("KHÁCH HÀNG");
                lbl_NV.setHorizontalAlignment(SwingConstants.CENTER);
                
                roundedPanel.add(lbl_NV);
                        
                        JPanel panel_4 = new JPanel();
                        panel_4.setOpaque(false);
                        FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
                        flowLayout.setAlignment(FlowLayout.LEFT);
                        roundedPanel.add(panel_4);
                
                        AppLabel label2 = new AppLabel("Doanh thu:");
                        label2.setText("KH Thành viên:");
                        panel_4.add(label2);
                        
                        num_mem = new AppLabel("New label");
                        num_mem.setText("");
                        panel_4.add(num_mem);
                        
                        AppLabel label = new AppLabel("");
                        panel_2.add(label);
                        
                        JPanel roundedPanel_1 = new JPanel();
                        roundedPanel_1.setPreferredSize(new Dimension(200, 150));
                        roundedPanel_1.setBorder(UIManager.getBorder("RadioButton.border"));
                        roundedPanel_1.setBackground(SystemColor.info);
                        panel_2.add(roundedPanel_1);
                        roundedPanel_1.setLayout(new GridLayout(4, 1, 0, 0));
                        
                        AppLabel label1_1 = new AppLabel("DOANH THU", 24, true);
                        label1_1.setText("HÓA ĐƠN");
                        label1_1.setHorizontalAlignment(SwingConstants.CENTER);
                        roundedPanel_1.add(label1_1);
                        
                        JPanel panel_7 = new JPanel();
                        panel_7.setOpaque(false);
                        FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
                        flowLayout_3.setAlignment(FlowLayout.LEFT);
                        roundedPanel_1.add(panel_7);
                        
                        AppLabel label2_1 = new AppLabel("Số hóa đơn:");
                        panel_7.add(label2_1);
                        
                        bills = new AppLabel("New label");
                        bills.setText("");
                        panel_7.add(bills);
                        
                        JPanel panel_5 = new JPanel();
                        panel_5.setOpaque(false);
                        FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
                        flowLayout_1.setAlignment(FlowLayout.LEFT);
                        roundedPanel_1.add(panel_5);
                        
                        AppLabel lblNewLabel_3 = new AppLabel("Tổng tiền hóa đơn:");
                        lblNewLabel_3.setText("Tổng tiền:");
                        panel_5.add(lblNewLabel_3);
                        
                        billTotal = new AppLabel("New label");
                        billTotal.setText("");
                        panel_5.add(billTotal);
                        
                        AppLabel label_1 = new AppLabel("");
                        panel_2.add(label_1);
                        
                        JPanel roundedPanel_1_1 = new JPanel();
                        roundedPanel_1_1.setPreferredSize(new Dimension(200, 150));
                        roundedPanel_1_1.setBorder(UIManager.getBorder("RadioButton.border"));
                        roundedPanel_1_1.setBackground(SystemColor.info);
                        panel_2.add(roundedPanel_1_1);
                        roundedPanel_1_1.setLayout(new GridLayout(4, 1, 0, 0));
                        
                        AppLabel label1_1_1 = new AppLabel("DOANH THU", 24, true);
                        label1_1_1.setText("NGUYÊN LIỆU");
                        label1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
                        roundedPanel_1_1.add(label1_1_1);
                        
                        JPanel panel_8 = new JPanel();
                        panel_8.setOpaque(false);
                        FlowLayout flowLayout_4 = (FlowLayout) panel_8.getLayout();
                        flowLayout_4.setAlignment(FlowLayout.LEFT);
                        roundedPanel_1_1.add(panel_8);
                        
                        AppLabel lblNewLabel_7 = new AppLabel("Tổng lương");
                        lblNewLabel_7.setText("Số tiền: ");
                        panel_8.add(lblNewLabel_7);
                        
                        ingreTotal = new AppLabel("New label");
                        ingreTotal.setText("");
                        panel_8.add(ingreTotal);
        
        dataset = new DefaultCategoryDataset();
      
        
        // Create chart
        JFreeChart chart = ChartFactory.createBarChart(
            "THỐNG KÊ THỨC UỐNG",
            "THỨC UỐNG",
            "SỐ LƯỢNG",
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
        report = new ReportController(this); 
	}
}
