package view.employee;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import constant.ConstantValueView;

public class TimePickerComponent extends JPanel {

	private JSpinner timeSpinner;

	/**
	 * Create the panel.
	 */
	public TimePickerComponent() {
		this.setPreferredSize(new Dimension(100,40));
		this.setLayout(new GridLayout());
		
		 SpinnerDateModel spinnerDateModel = new SpinnerDateModel();
	        spinnerDateModel.setCalendarField(Calendar.MINUTE);
	        
	        // Set default value to midnight
	        Calendar calendar = Calendar.getInstance();
	        calendar.set(Calendar.HOUR_OF_DAY, 0);
	        calendar.set(Calendar.MINUTE, 0);
	        calendar.set(Calendar.SECOND, 0);
	        calendar.set(Calendar.MILLISECOND, 0);
	        spinnerDateModel.setValue(calendar.getTime());
	        timeSpinner = new JSpinner(spinnerDateModel);
	        timeSpinner.setBorder(null);
	        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, "HH:mm:ss"));
	        timeSpinner.setFont(ConstantValueView.normalText);
	        this.add(timeSpinner);
	        setVisible(true);
		 
	}
	
	public String getTimeString() {
		
	    Date time = (Date) timeSpinner.getValue();
	    Date now = new Date(); 
	    time.setDate(now.getDate());
	    time.setMonth(now.getMonth());
	    time.setYear(now.getYear());
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    return formatter.format(time);
	}

	

}
