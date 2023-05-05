package diaglog;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import constant.ConstantValueView;

public class AppOptionPaneDialog extends JOptionPane {

    public AppOptionPaneDialog(String message, int time) {
        super(message, JOptionPane.INFORMATION_MESSAGE);
        super.setFont(ConstantValueView.normalText);
        JDialog dialog = createDialog(null, "Thông báo");
        // Tạo một luồng mới để đóng thông báo sau 1 giây
        new Thread(() -> {
            try {
                Thread.sleep(time); // Đợi 1 giây
                dialog.dispose(); 
                // Tự động đóng thông báo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        dialog.setVisible(true);
    }
}
