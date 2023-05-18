package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
				view.num_mem.setText(String.valueOf(ReportDAO.getNumberOfCustomer(endDate))); 
				
				//set ingre
				view.ingreTotal.setText(String.valueOf(ReportDAO.getTotalAmountOfMoneySpentOnRawMaterials(endDate,startDate)));
				
				//chart
				List<ProductModel> result = ReportDAO.getListDrinkSaleDecs(startDate, endDate); 
				System.out.println("SAN PHAM BAN RA: ");
				for (ProductModel pro: result) {
					 view.dataset.setValue(pro.getAmount(), "Sales", pro.getProductID());
					
				}
				
				 
			    
			}
		});

		

	}
	
	
	public void setBill() {

	}
	
	
}
