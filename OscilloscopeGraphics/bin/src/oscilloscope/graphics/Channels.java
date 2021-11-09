package oscilloscope.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.RenderingHints;

import oscilloscope.Button.ButtonActions.Actions;
import oscilloscope.display.Display;
import oscilloscope.main.Main;

public class Channels {
	
	public static void drawChannels() {
		if(Actions.updated) {
			Display.g.setColor(new Color(100, 150, 100));
			Display.g.setStroke(new BasicStroke(1));
			Display.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			int width = Display.frame.getWidth()-170-950;
			int increments = Main.arrayX.length-1;
			float space = width / (float)increments;
			for(int i = 0; i < increments; i++) {
				if(Main.arrayObj[i].equals("f")) {
					Display.g.drawLine((int)(i * space) + 950, 280-(int)(Main.arrayX[i]+100), (int)((i+1) * space) + 950, 280-(int)(Main.arrayX[i+1]+100));
				}
			}
			for(int i = 0; i < increments; i++) {
				if(Main.arrayObj[i].equals("f")) {
				Display.g.drawLine((int)(i * space) + 950, 540-(int)(Main.arrayY[i]+100), (int)((i+1) * space) + 950, 540-(int)(Main.arrayY[i+1]+100));
				}
			}
		}
	}
}
