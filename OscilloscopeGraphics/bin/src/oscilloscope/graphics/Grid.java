package oscilloscope.graphics;

import java.awt.Color;
import java.awt.RenderingHints;

import oscilloscope.display.Display;
import oscilloscope.image.Images;
import oscilloscope.image.OpenImage;
import oscilloscope.main.Main;

public class Grid {
	
	public static boolean show = true;
	public static Color color = new Color(70, 100, 70);;
	public static boolean cross = true;
	
	public static void drawGrid() {
		

		
		
		if(show) {
			Display.g.setColor(color);
			Display.g.drawLine(60, 465, 870, 465);
			Display.g.drawLine(465, 60, 465, 870);
			float number = (float)10;
			for(int i = 0; i < number; i++) {
				Display.g.drawLine(60, (int)(60+(i+1)*(810/number)), 870, (int)(60+(i+1)*(810/number)));
				Display.g.drawLine((int)(60+(i+1)*(810/number)), 60, (int)(60+(i+1)*(810/number)), 870);
			}}
			
			if(cross) {
				Display.g.setColor(color);
				Display.g.drawLine(60, 465, 870, 465);
				Display.g.drawLine(465, 60, 465, 870);
			Display.g.drawLine(60, 466, 870, 466);
			Display.g.drawLine(466, 60, 466, 870);

			for(int i = 0; i < 50;i++) {
				Display.g.drawLine(460, (int)(60+(i+1)*(820/50)*1.0137), 470, (int)(60+(i+1)*(820/50)*1.0137));
				Display.g.drawLine((int)(60+(i+1)*(820/50)*1.0137), 460, (int)(60+(i+1)*(820/50)*1.0137), 470);
			}
			
		}
		if(show) {
			Display.g.setColor(new Color(150, 200, 150, 150));
		}else {
			Display.g.setColor(new Color(200, 150, 150, 150));
		}
		
		Display.g.fillArc(1030, 610, 10, 10, 0, 360);
		Display.g.setColor(new Color(150, 200, 150, 150));
		Display.g.fillRect(1030, (int)(710-color.getGreen()/(float)210*65), 10, (int)(color.getGreen()/(float)210*65));
		Display.g.fillArc(1030, (int)(710-color.getGreen()/(float)210*65)-5, 10, 10, 0, 180);
		Display.g.fillArc(1030, 704, 10, 10, 180, 180);
		
		if(cross) {
			Display.g.setColor(new Color(150, 200, 150, 150));
		}else {
			Display.g.setColor(new Color(200, 150, 150, 150));
		}
			Display.g.fillArc(1030, 730, 10, 10, 0, 360);
		
			Display.g.setColor(new Color(70, 100, 70));
		for(int i = 1; i < 100;i++) {
			int step = (Display.frame.getWidth()-170-950)/100;
			Display.g.drawLine((int)(950+step*i), 170, (int)(950+step*(i+0.5)), 170);
			Display.g.drawLine((int)(950+step*i), 430, (int)(950+step*(i+0.5)), 430);
		}
		
		if(OpenImage.show) {
			Display.g.setColor(new Color(150, 200, 150, 150));
		}else {
			Display.g.setColor(new Color(200, 150, 150, 150));
		}
			Display.g.fillArc(1170, 650, 10, 10, 0, 360);
			Display.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			if(Main.direction) {
				Display.g.drawImage(Images.CH2, 1805, 90, 200, 200, null);
				Display.g.drawImage(Images.CH1, 1805, 350, 200, 200, null);
			}else {
				Display.g.drawImage(Images.CH1, 1805, 90, 200, 200, null);
				Display.g.drawImage(Images.CH2, 1805, 350, 200, 200, null);
			}
	}
}
