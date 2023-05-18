package view;


import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDialog;

public class TestPrint {
    
	public static void convertToImage(JDialog dialog, String outputFilePath) {
        try {
            // Capture the screenshot of the dialog
            Rectangle dialogBounds = dialog.getBounds();
            BufferedImage dialogImage = new Robot().createScreenCapture(dialogBounds);

            // Save the screenshot as a PNG image file
            File outputFile = new File("src/assets/bills/"+outputFilePath);
            ImageIO.write(dialogImage, "png", outputFile);

            System.out.println("Dialog saved as an image: " + outputFile.getAbsolutePath());
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
                Desktop.getDesktop().open(outputFile);
            } else {
                System.out.println("Opening the image in a viewer is not supported on this platform.");
            }
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JDialog dialog = new JDialog();
        // Set up your dialog here
        dialog.setSize(100,100);
        convertToImage(dialog, "dialog.png");
    }
}