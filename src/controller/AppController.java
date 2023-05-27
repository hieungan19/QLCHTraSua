package controller;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import constant.ConstantValueView;
import model.DashboardOption;
import view.AppView;
import view.LoginView;
import view.bill.BillPageView;
import view.customer.CustomerPageView;
import view.discount.DiscountPageView;
import view.employee.EmployeePageView;
import view.home.CartPanel;
import view.home.HomePageView;
import view.product.ProductPageView;
import view.report.StatisticalReportPageView;

import javax.swing.GroupLayout;



public class AppController {
	public static AppView view; 
	private static String optionSelectedText;
	private List<DashboardOption> listItem = null;
	private DashboardOption logout; 
	private static DashboardOption selectedItem; 
	public AppController(AppView view) {
		// TODO Auto-generated constructor stub
		this.view = view; 
		view.root.setLayout(new GroupLayout(view.root));
		view.logout.getjLabelOption().addMouseListener(new MouseListener() {
			
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
				
				logout();

			}
		});


	}
	public static void logout() {
		LoginView loginView = new LoginView();
        loginView.setSize(1040, 740);
        loginView.setLocationRelativeTo(null);
        loginView.setVisible(true); 
        view.setVisible(false); 
	}
	
	public static void showPage(JPanel jpanel) {
		AppController.view.root.removeAll();
		AppController.view.root.setLayout(new GridLayout());
		AppController.view.root.add(jpanel);
		AppController.view.root.validate();
		AppController.view.root.repaint();
	}

	public static void setView( DashboardOption optionItem) {
		JPanel jpnItem = optionItem.getjPanelOption(); 
		if (selectedItem!=null) {
			selectedItem.getjLabelOption().setBackground(ConstantValueView.primaryColor);
			selectedItem.getjLabelOption().setOpaque(true);
		}
		optionSelectedText = optionItem.getText();
		optionItem.getjLabelOption().setBackground(ConstantValueView.background);
		optionItem.getjLabelOption().setOpaque(true);
		view.root.removeAll();
		view.root.add(jpnItem);		
		view.root.validate();
		view.root.repaint();
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
		String oldOptionText; 

		public LabelEvent(DashboardOption optionItem) {
			super();

			this.optionItem = optionItem;
			this.optionText = optionItem.getText();
			

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(optionText) {
			case "BILLS":
				optionItem.setjPanelOption(new BillPageView());
				break;	
			case "CUSTOMER":
				optionItem.setjPanelOption(new CustomerPageView());
				break;
				
			case "PRODUCT":
				optionItem.setjPanelOption(new ProductPageView());
				break;
			case "EMPLOYEE":
				optionItem.setjPanelOption(new EmployeePageView());
				break;
			case "DISCOUNT":
				optionItem.setjPanelOption(new DiscountPageView());
				break; 

			case "HOME":
				HomePageView home = (HomePageView) optionItem.getjPanelOption();
				System.out.println("APP CONTROLLER: HOME.CART - " + home.cart.spinner_cusPaymentAmount.getValue().toString());

				CartPanel currentCart = home.cart; // Lưu trữ tham chiếu đến cart hiện tại

				HomePageView newHome = new HomePageView(); // Tạo một HomePageView mới
				
				
				JTable table = currentCart.scrollPane_cart.jTable;
				DefaultTableModel dtm = (DefaultTableModel) newHome.cart.scrollPane_cart.jTable.getModel(); 
				for (int i = 0; i< table.getRowCount();++i) {
					Object[] obj = new Object[] {table.getValueAt(i, 0),table.getValueAt(i, 1),table.getValueAt(i, 2),table.getValueAt(i, 3)}; 
					dtm.addRow(obj); 
				}
				
				newHome.controller.cartProducts = home.controller.cartProducts; 

				newHome.revalidate(); // Cập nhật giao diện
				newHome.repaint();

				System.out.println("APP CONTROLLER: NEW_HOME.CART - " + newHome.cart.spinner_cusPaymentAmount.getValue().toString());
				optionItem.setjPanelOption(newHome);

				optionItem.setjPanelOption(newHome);
				break;
			case "STATISTIC REPORT":
				optionItem.setjPanelOption(new StatisticalReportPageView());
				break;
			}
			
			node = optionItem.getjPanelOption();
			optionSelectedText = optionText;
			selectedItem = optionItem; 
			view.root.removeAll();
			view.root.setLayout(new GridLayout());
			setView(optionItem);
			setChangeBackground(optionText);
			view.root.validate();
			view.root.repaint();
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
			optionItem.getjLabelOption().setBackground(ConstantValueView.background);
			optionItem.getjLabelOption().setOpaque(true);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		private void setChangeBackground(String optionText) {
			for (DashboardOption item : listItem) {
				if (item.getText().equalsIgnoreCase(optionText)) {
					item.getjLabelOption().setBackground(ConstantValueView.background);
					item.getjLabelOption().setOpaque(true);
				} else {
					item.getjLabelOption().setBackground(ConstantValueView.primaryColor);
					item.getjLabelOption().setOpaque(true);
				}
			}
		}
	}
}
