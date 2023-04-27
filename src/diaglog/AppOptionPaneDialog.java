package diaglog;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class AppOptionPaneDialog extends JOptionPane {

    public AppOptionPaneDialog(String message) {
        super(message, JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = createDialog(null, "Thông báo");
        // Tạo một luồng mới để đóng thông báo sau 1 giây
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Đợi 1 giây
                dialog.dispose(); 
                // Tự động đóng thông báo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        dialog.setVisible(true);
    }
}
