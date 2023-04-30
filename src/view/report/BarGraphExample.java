package view.report;

import javax.swing.JFrame;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

public class BarGraphExample {
    public static void main(String[] args) {
        // Create dataset
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
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(chartPanel);
        frame.setVisible(true);
    }
}
