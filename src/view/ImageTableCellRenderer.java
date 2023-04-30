package view;

import java.awt.Component;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageTableCellRenderer extends DefaultTableCellRenderer {
	public ImageTableCellRenderer() {
	}
	 @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        
	        if (value instanceof ImageIcon) {
	            setIcon((ImageIcon) value);
	            setText(null);
	        } else {
	            setIcon(null);
	            setText(value != null ? value.toString() : "");
	        }
	        
	        setHorizontalAlignment(JLabel.CENTER); // Căn giữa ảnh trong ô
	        
	        return cellComponent;
	    }
	}
