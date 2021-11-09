package oscilloscope.graphics;

import java.awt.AlphaComposite;
import java.awt.Color;

import oscilloscope.display.Display;
import oscilloscope.image.OpenImage;

public class Reference {
	
	public static void drawReference() {

		if(OpenImage.show) {
			Display.g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) OpenImage.translucency));
			Display.g.drawImage(OpenImage.referenceImage, OpenImage.x, OpenImage.y, 
					(int)(OpenImage.referenceImage.getWidth()*OpenImage.scale), 
					(int)(OpenImage.referenceImage.getHeight()*OpenImage.scale), null);
			Display.g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 1));
		}
		
		Display.g.setColor(new Color(30, 30, 30));
		Display.g.fillRect(0, 0, Display.frame.getWidth(), 60);
		Display.g.fillRect(0, 0, 60, Display.frame.getHeight());
		Display.g.fillRect(0, 870, Display.frame.getWidth(), Display.frame.getHeight()-870);
		Display.g.fillRect(870, 0, Display.frame.getWidth()-870, Display.frame.getHeight());
	}
}
