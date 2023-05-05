package constant;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static String getStringDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // Format the date as a string using the SimpleDateFormat object
        String dateString = sdf.format(date);
        return dateString; 
	}
}
