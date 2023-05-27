package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.AppController;
import controller.LoginController;
import globalComponent.AppLabel;
import model.DashboardOption;
import view.bill.BillPageView;

import view.customer.CustomerPageView;

import view.discount.DiscountPageView;

import view.employee.EmployeePageView;
import view.home.HomePageView;
import view.inventory.IngredientPageView;
import view.product.ProductPageView;
import view.report.StatisticalReportPageView;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import constant.ConstantValueView;

public class AppView extends JFrame {

	private JPanel contentPane;
	ArrayList<DashboardOption> optionList = new ArrayList<>();
	public static  AppController appController;
	public JPanel root;
	public DashboardOption logout;
	public static DashboardOption homeOption;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppView frame = new AppView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public AppView() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1040, 740);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// init list option

		JPanel panel_dashboard = new JPanel();
		panel_dashboard.setPreferredSize(new Dimension(200, 0));
		panel_dashboard.setBackground(ConstantValueView.primaryColor);
		contentPane.add(panel_dashboard, BorderLayout.WEST);

		// Ten nhom
		AppLabel lblNewLabel = new AppLabel("DILAMDOAN", 32, true);
		lblNewLabel.setBounds(0, 0, 200, 95);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trajan Pro", Font.BOLD, 16));
		panel_dashboard.add(lblNewLabel);
	
		// Options
		JPanel panel_options = new JPanel();
		panel_options.setOpaque(false);
		panel_options.setBounds(10, 120, 180, 441);
		panel_dashboard.add(panel_options, BorderLayout.WEST);
		GridLayout gridLayout = new GridLayout(8, 1, 0, 20);
		panel_options.setLayout(gridLayout);

		panel_dashboard.setLayout(new BorderLayout());
		root = new JPanel();
		contentPane.add(root, BorderLayout.CENTER);

		// HOME Option

		EmptyView emptyView  = new EmptyView(); 
		DashboardOption menuOption = new DashboardOption("MENU", "/assets/menu.png", emptyView);
		DashboardOption invetoryOption = new DashboardOption("INVETORY", "/assets/collection.png", emptyView);
		DashboardOption employeeOption = new DashboardOption("EMPLOYEE", "/assets/users.png", emptyView);
		DashboardOption discountOption = new DashboardOption("DISCOUNT", "/assets/ticket.png", emptyView);
		
		if (LoginController.user.getPosition().equals("QUẢN LÝ")) {
			menuOption = new DashboardOption("MENU", "/assets/menu.png", new ProductPageView());
			invetoryOption = new DashboardOption("INVETORY", "/assets/collection.png", new IngredientPageView());
			employeeOption = new DashboardOption("EMPLOYEE", "/assets/users.png", new EmployeePageView());
			discountOption = new DashboardOption("DISCOUNT", "/assets/ticket.png", new DiscountPageView());
		}
		homeOption = new DashboardOption("HOME", "/assets/home.png", new HomePageView());
		
		DashboardOption ordersOption = new DashboardOption("BILLS", "/assets/shopping-cart.png", new BillPageView());
		DashboardOption customerOption = new DashboardOption("CUSTOMER", "/assets/customer.png", new CustomerPageView());
		DashboardOption statisticReportOption = new DashboardOption("STATISTIC REPORT", "/assets/chart-pie.png",
				new StatisticalReportPageView());

		logout = new DashboardOption("LOG OUT", "/assets/logout.png", new HomePageView()); 


		optionList.add(homeOption);
		optionList.add(menuOption);
		optionList.add(invetoryOption);
		optionList.add(ordersOption);
		optionList.add(customerOption);
		optionList.add(customerOption);
		optionList.add(employeeOption);
		optionList.add(statisticReportOption);
		optionList.add(discountOption);

		appController = new AppController(this); 
		root.setLayout(new GridLayout());		

		appController.setView(homeOption);
		appController.setEvent(optionList);

		panel_options.add(homeOption.getjLabelOption());
		panel_options.add(menuOption.getjLabelOption());
		panel_options.add(invetoryOption.getjLabelOption());
		panel_options.add(ordersOption.getjLabelOption());
		panel_options.add(customerOption.getjLabelOption());
		panel_options.add(employeeOption.getjLabelOption());
		panel_options.add(statisticReportOption.getjLabelOption());
		panel_options.add(discountOption.getjLabelOption());

		
		// Logout
		JPanel panel_logout = new JPanel();
		panel_logout.setBounds(10, 585, 180, 95);
		
		panel_dashboard.add(panel_logout);
		JLabel jLabel_logoutOption = logout
				.getjLabelOption();
		panel_dashboard.add(jLabel_logoutOption);
		panel_logout.add(jLabel_logoutOption);
		panel_logout.setOpaque(false);
		panel_logout.setLayout(new GridLayout(1, 0, 0, 0));


	}

	
}
