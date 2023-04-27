package controller;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import model.DashboardOption;

public class AppController {
	public static JFrame appJFrame; 
	public static  JPanel root;
	private String optionSelectedText;
	private List<DashboardOption> listItem = null;

	public AppController(JPanel root) {
		// TODO Auto-generated constructor stub
		this.root = root;

	}

	public void setView( DashboardOption optionItem) {
		JPanel jpnItem = optionItem.getjPanelOption(); 
		optionSelectedText = optionItem.getText();
		optionItem.getjLabelOption().setBackground(Color.white);
		optionItem.getjLabelOption().setOpaque(true);
		root.removeAll();
		root.add(jpnItem);
		root.validate();
		root.repaint();

	}

	public void setEvent(List<DashboardOption> listItem) {
		this.listItem = listItem;
		for (DashboardOption item : listItem) {
			item.getjLabelOption().addMouseListener(new LabelEvent(item));
		}
	}

	class LabelEvent implements MouseListener {
		private JPanel node;
		private String optionText;
		private DashboardOption optionItem;

		public LabelEvent(DashboardOption optionItem) {
			super();

			this.optionItem = optionItem;
			this.optionText = optionItem.getText();

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			node = optionItem.getjPanelOption();
			optionSelectedText = optionText;
			root.removeAll();
			root.setLayout(new GridLayout());
			setView(optionItem);
			setChangeBackground(optionText);
			root.validate();
			root.repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			
				if (!optionSelectedText.equalsIgnoreCase(optionText)) {
					optionItem.getjLabelOption().setOpaque(false);
				}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

			optionSelectedText = optionText;
			optionItem.getjLabelOption().setBackground(Color.white);
			optionItem.getjLabelOption().setOpaque(true);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		private void setChangeBackground(String optionText) {
			for (DashboardOption item : listItem) {
				if (item.getText().equalsIgnoreCase(optionText)) {
					item.getjLabelOption().setBackground(Color.white);
					item.getjLabelOption().setOpaque(true);
				} else {
					item.getjLabelOption().setBackground(new Color(183, 150, 107));
					item.getjLabelOption().setOpaque(true);
				}
			}
		}
	}
}
