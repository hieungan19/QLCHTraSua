package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import dao.ReportDAO;
import model.ProductModel;
import view.report.StatisticalReportPageView;

public class ReportController {

	StatisticalReportPageView view;

	public ReportController(StatisticalReportPageView view) {
		super();
		this.view = view;
		
		
		view.btn_report.addActionListener(new ActionListener() {
			
			private List<ProductModel> result = new ArrayList<>();

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date startDate = view.startDate.getDate();
				Date endDate = view.endDate.getDate(); 
				
				// set bill
				Map<String, Object> res = ReportDAO.getBillByDate(startDate,endDate); 
				view.bills.setText(res.get("count").toString());
				view.billTotal.setText(res.get("total").toString());
				
				//set customer
				view.num_mem.setText(String.valueOf(ReportDAO.getNumberOfCustomer(startDate, endDate))); 
				
				//set ingre
				view.ingreTotal.setText(String.valueOf(ReportDAO.getTotalAmountOfMoneySpentOnRawMaterials(startDate,endDate)));
				
				//chart
				for (int i = 0; i<result.size(); ++i) {
					view.dataset.removeColumn(i); 
				}
				result = ReportDAO.getListDrinkSaleDecs(startDate, endDate); 
			
				for (ProductModel pro: result) {
					System.out.println("SP: "+pro.getName());
					 view.dataset.setValue(pro.getAmount(), "Sales", pro.getProductID());
				}
					 
			    
			}
		});

		

	}
	
	
	public void setBill() {

	}
	
	
}
