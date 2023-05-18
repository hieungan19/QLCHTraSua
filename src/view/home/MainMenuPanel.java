package view.home;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


import javax.swing.ScrollPaneConstants;
import java.awt.Color;

public class MainMenuPanel extends JPanel {

	private JScrollPane jScrollPane1; 
	public JPanel panel; 

	/**
	 * Create the panel.
	 */
	public void setDummyData() {
		

	}
	public MainMenuPanel() {

		panel = new javax.swing.JPanel();
		panel.setBackground(new Color(138, 43, 226));
		panel.setOpaque(false);
		
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
     
		jScrollPane1.setOpaque(false);

        jScrollPane1.setBorder(null);


        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1)
                .addGap(30, 30, 30))
        );
        
		GridLayout gl_panel = new GridLayout(2,3);
		gl_panel.setVgap(10);
		gl_panel.setHgap(10);
		panel.setLayout(gl_panel);
        

	}

}
