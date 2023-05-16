package controller;

import java.util.Date;
import java.util.List;

import dao.ReportDAO;
import model.ProductModel;
import view.report.StatisticalReportPageView;

public class ReportController {

	StatisticalReportPageView view;

	public ReportController(StatisticalReportPageView view) {
		super();
		this.view = view;
		System.out.println("DOANH THU: "+ ReportDAO.getBillByDate(new Date(), new Date()) );
		System.out.println("LUONG TRA CHO NV: "+ReportDAO.getAllSalary(new Date(), new Date()));
		List<ProductModel> result = ReportDAO.getListDrinkSaleDecs(new Date(), new Date()); 
		System.out.println("SAN PHAM BAN RA: ");
		for (ProductModel pro: result) {
			System.out.println("MASP: "+pro.getProductID());
			System.out.println("SOLUONGSP: "+pro.getAmount());
		}
	}
	
	
	
}
