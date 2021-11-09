package oscilloscope.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.RenderingHints;
import java.io.IOException;
import java.io.InputStream;

import oscilloscope.Button.ButtonActions.Actions;
import oscilloscope.display.Display;
import oscilloscope.image.OpenImage;
import oscilloscope.main.Main;

public class Panels {
	
	public static void panels() throws FontFormatException, IOException {
		
		InputStream is = Panels.class.getResourceAsStream("/res/fonts/teko.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, is);
		font = font.deriveFont(Font.PLAIN, 20);
		
		InputStream is2 = Panels.class.getResourceAsStream("/res/fonts/larabie.otf");
		Font font2 = Font.createFont(Font.TRUETYPE_FONT, is2);
		font2 = font2.deriveFont(Font.PLAIN, 16);
		

		Display.g.setFont(font);
		Display.g.setColor(new Color(16,80,70,80));
		Display.g.fillRect(60, 60, 810, 810);
		Display.g.fillRect(950, 60, Display.frame.getWidth()-170-950, 220);
		Display.g.fillRect(950, 320, Display.frame.getWidth()-170-950, 220);
		Display.g.setColor(new Color(150, 150, 150));
		for(int i = 0; i < 21; i++) {
			float f = 200/(float)4.98;
			Display.g.drawString(Integer.toString(100-i*10), 30, (int) (70+i*f));
			Display.g.drawString(Integer.toString(-100+i*10), (int) (70+i*f*1.01)-22, 896);
		}
		
		for(int i = 0; i < 11; i++) {
			float f = 200/(float)9.3;
			Display.g.drawString(Integer.toString(100-i*20), 910, (int) (70+i*f));
			Display.g.drawString(Integer.toString(100-i*20), 910, (int) (70+i*f)+260);
		}
		Display.g.setFont(font2);
		Display.g.drawString("Channel 1", 1795, 60);
		Display.g.drawString("Channel 2", 1795, 320);
		Display.g.drawString("X", 1830, 80);
		Display.g.drawString("Y", 1830, 340);
		Display.g.drawString("Y", 11, 472);
		Display.g.drawString("X", 452, 918);
		Display.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		Display.g.drawString(OpenImage.finalPath, 1170, 620);
		Display.g.setFont(font);
		Display.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Display.g.drawString(Integer.toString((int)(OpenImage.translucency*100))+"%", 1170, 740);
		Display.g.drawString("X: " +Integer.toString(OpenImage.x-60) + ", Y: "+Integer.toString(OpenImage.y-60), 1060, 850);
		Display.g.drawString(Integer.toString((int)(OpenImage.scale*100))+"%", 920, 850);
		Display.g.drawString(Integer.toString(Main.steps), 1348, 861);
		Display.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		Display.g.setFont(font2);
		Display.g.drawString("Translucency", 1051, 710);
		Display.g.drawString("Move", 1090, 790);
		Display.g.drawString("Scale", 945, 790);
		Display.g.drawString("Steps", 1268, 830);
		Display.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(Drawing.currentDrawing) {
			Display.g.setColor(new Color(150, 200, 150, 150));
		}else {
			Display.g.setColor(new Color(200, 150, 150, 150));
		}
		Display.g.fillRect(1350, 645, 10, 60);
		Display.g.fillArc(1350, 640, 10, 10, 0, 180);
		Display.g.fillArc(1350, 700, 10, 10, 180, 180);
		
		if(Main.OUTPUT) {
			Display.g.setColor(new Color(150, 200, 150, 150));
		}else {
			Display.g.setColor(new Color(200, 150, 150, 150));
		}
		Display.g.fillArc(1350, 770, 10, 10, 0, 360);
		
		if(Actions.updated) {
			Display.g.setColor(new Color(150, 200, 150, 150));
		}else {
			Display.g.setColor(new Color(200, 150, 150, 150));
		}
		
		Display.g.fillArc(1350, 730, 10, 10, 0, 360);
		
		
	}
}
