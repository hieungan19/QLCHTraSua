package view.home;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import constant.ConstantValueView;
import diaglog.ChooseDrinkDialog;
import model.DrinkModel;

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
		DrinkModel dummy = new DrinkModel("D01", "Tra sua Olong",20000 ,false,"/assets/bg-login.png", null,"Trà sữa", null);
		for (int i =0; i<10; ++i) {
			DrinkCardComponent drinkCardComponent = new DrinkCardComponent(dummy);
			drinkCardComponent.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					ChooseDrinkDialog dialog = new ChooseDrinkDialog(dummy);
					dialog.setVisible(true);
					
				}
			}); 
			panel.add(drinkCardComponent);
			
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
