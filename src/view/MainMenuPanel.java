package view;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import component.DrinkCardComponentView;
import constant.ConstantValueView;
import model.DrinkCardModel;
import javax.swing.ScrollPaneConstants;

public class MainMenuPanel extends JPanel {

	private JScrollPane jScrollPane1; 
	private JPanel panel; 

	/**
	 * Create the panel.
	 */
	public void setDummyData() {
		
		GridLayout gl_panel = new GridLayout(2,2);
		gl_panel.setVgap(10);
		gl_panel.setHgap(10);
		panel.setLayout(gl_panel);
		panel.setOpaque(false);
		DrinkCardModel dummy = new DrinkCardModel("D01", "Tra sua Olong",20000 , "Tra sua","/assets/bg-login.png", null, null);
		for (int i =0; i<10; ++i) {
			panel.add(new DrinkCardComponentView(dummy));
		}

		panel.revalidate();
        panel.repaint();
	}
	public MainMenuPanel() {
		
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        panel = new javax.swing.JPanel();


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
        
        setDummyData();
        

	}

}
