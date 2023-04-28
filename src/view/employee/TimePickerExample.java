package view.employee;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimePickerExample extends JFrame {
    private JSpinner timeSpinner;

    public TimePickerExample() {
        super("Time Picker Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(300, 100);

        SpinnerDateModel spinnerDateModel = new SpinnerDateModel();
        spinnerDateModel.setCalendarField(Calendar.MINUTE);
        timeSpinner = new JSpinner(spinnerDateModel);
        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, "hh:mm:ss a"));

        add(timeSpinner);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TimePickerExample();
    }
}