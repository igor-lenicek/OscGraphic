package oscilloscope.Button.ButtonHandler;

import java.awt.RenderingHints;

import oscilloscope.display.Display;

public class DrawButtons {
	
	public static void draw() {
		for(Button e : Buttons.BUTTONS) {
			Display.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
				e.draw();
		}
	}
}
