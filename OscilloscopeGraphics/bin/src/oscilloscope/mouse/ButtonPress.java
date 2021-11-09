package oscilloscope.mouse;

import java.awt.Point;

import oscilloscope.Button.ButtonHandler.Button;
import oscilloscope.Button.ButtonHandler.Buttons;

public class ButtonPress {
	
	public static Button check(Point clickPoint) {
		int x = clickPoint.x;
		int y = clickPoint.y;
		
		for(Button e : Buttons.BUTTONS) {
			int x1 = e.getOrigin().x;
			int y1 = e.getOrigin().y;
			int bWidth = e.getWidth();
			int bHeight = e.getHeight();		
			if((x > x1 && x < x1+bWidth) && (y > y1 && y < y1+bHeight)) {
					e.press(true);
					e.startAction();
			}
		}
		
		
		return null;
	}
}
