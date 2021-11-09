package oscilloscope.graphics;

import java.awt.Color;

import oscilloscope.display.Display;

public class Background {
	
	public static void background(Color color) {
		Display.g.setColor(color);
		Display.g.fillRect(0, 0, Display.frame.getWidth(), Display.frame.getHeight());
	}
}
