package oscilloscope.display;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DisplaySize {
	
	public static void setFullscreen(JFrame frame) {
		 GraphicsEnvironment graphics =
		 GraphicsEnvironment.getLocalGraphicsEnvironment();
		 GraphicsDevice device = graphics.getDefaultScreenDevice();
		 device.setFullScreenWindow(frame);
	}
	
	public static void setWindowed(JFrame frame) {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(size);
		frame.setVisible(true);
	}
	
}
