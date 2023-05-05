package globalComponent;

import com.toedter.calendar.JDateChooser;

import constant.ConstantValueView;
import java.util.Date;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

public class DatePickerComponent extends JDateChooser {
   

    public DatePickerComponent() {
    	super(); 
    	getCalendarButton().setPreferredSize(new Dimension(60, 17));
        this.getCalendarButton().setBorder(null);
        this.setBorder(new LineBorder(ConstantValueView.primaryColor, 2));
        this.setFont(ConstantValueView.normalText);
        this.setDateFormatString("dd-MM-yyyy");
        this.setSize(new Dimension(100,40));
        // Set default date to today
        this.setDate(new Date());
    }
    public Date getDate() {
    	return this.getDate(); 
    }
    
}
