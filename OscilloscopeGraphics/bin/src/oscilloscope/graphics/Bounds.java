package oscilloscope.graphics;

import java.awt.Color;

import oscilloscope.display.Display;

public class Bounds {
	
	public static void bounds(Color color) {
		Display.g.setColor(color);
		Display.g.drawLine(0, 40, Display.frame.getWidth(), 40);
		Display.g.drawLine(900, 40, 900, 940);
		Display.g.drawLine(0, 940, Display.frame.getWidth(), 940);
		Display.g.drawLine(900, 300, Display.frame.getWidth(), 300);
		Display.g.drawLine(900, 560, Display.frame.getWidth(), 560);
		Display.g.drawLine(Display.frame.getWidth()-150, 560, Display.frame.getWidth()-150, 40);
		Display.g.drawRect(60, 60, 810, 810);
		Display.g.drawRect(950, 60, Display.frame.getWidth()-170-950, 220);
		Display.g.drawRect(950, 320, Display.frame.getWidth()-170-950, 220);
		Display.g.drawLine(15, 60, 15, 450);
		Display.g.drawLine(15, 480, 15, 870);
		Display.g.drawLine(60, 912, 435, 912);
		Display.g.drawLine(475, 912, 870, 912);
	}
}
