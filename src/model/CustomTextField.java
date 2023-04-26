package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CustomTextField extends JTextField {
    private String placeholder = "";
    private Font placeholderFont = new Font("Arial", Font.ITALIC, 12);
    private Color placeholderColor = Color.GRAY;

    public CustomTextField(int columns) {
        super(columns);
        Border border = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        );
        this.setBorder(border);
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public void setPlaceholderFont(Font font) {
        this.placeholderFont = font;
    }

    public void setPlaceholderColor(Color color) {
        this.placeholderColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.getText().isEmpty() && !this.hasFocus()) {
            g.setColor(this.placeholderColor);
            g.setFont(this.placeholderFont);
            g.drawString(this.placeholder, this.getInsets().left, g.getFontMetrics().getMaxAscent() + this.getInsets().top);
        }
    }
}   
    