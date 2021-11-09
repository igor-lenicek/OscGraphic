package oscilloscope.Button.ButtonHandler;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Point;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import oscilloscope.Button.ButtonActions.Actions;
import oscilloscope.display.Display;
import oscilloscope.graphics.Panels;



public class Button {
	
	Point ORIGIN;
	int WIDTH;
	int HEIGHT;
	String NAME;
	boolean ACTIVITY;
	boolean PRESSED = false;
	String LABEL;
	int SHIFT;
	
	Button(Point origin, int width, int height, String name, String label, int shift) {
		ORIGIN = origin;
		NAME = name;
		WIDTH = width;
		HEIGHT = height;
		LABEL = label;
		SHIFT = shift;
	}
	
	public void activity(boolean bool) {
		ACTIVITY = bool;
	}
	
	public void draw() {
			if(PRESSED) {
				InputStream is2 = Panels.class.getResourceAsStream("/res/fonts/larabie.otf");
				Font font2 = null;
				try {
					font2 = Font.createFont(Font.TRUETYPE_FONT, is2);
				} catch (FontFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				font2 = font2.deriveFont(Font.PLAIN, 16);
				
				Display.g.setFont(font2);
				Display.g.setColor(new Color(40, 40, 40));
				Display.g.fillRect(ORIGIN.x, ORIGIN.y, WIDTH, HEIGHT);
				Display.g.setColor(new Color(100, 100, 100));
				Display.g.drawString(LABEL, ORIGIN.x+SHIFT, ORIGIN.y+HEIGHT/2+5);
			}else {
				InputStream is2 = Panels.class.getResourceAsStream("/res/fonts/larabie.otf");
				Font font2 = null;
				try {
					font2 = Font.createFont(Font.TRUETYPE_FONT, is2);
				} catch (FontFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				font2 = font2.deriveFont(Font.PLAIN, 16);
				
				Display.g.setFont(font2);
				Display.g.setColor(new Color(60, 60, 60));
				Display.g.fillRect(ORIGIN.x, ORIGIN.y, WIDTH, HEIGHT);
				Display.g.setColor(new Color(180, 180, 180));
				Display.g.drawString(LABEL, ORIGIN.x+SHIFT, ORIGIN.y+HEIGHT/2+5);
			}
	}
	
	public void press(boolean bool) {
		PRESSED = bool;
	}
	

	
	public Point getOrigin() {
		return ORIGIN;
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	public void startAction() {

		 try {
		        Method method = Actions.class.getDeclaredMethod(NAME);
		        method.invoke(this, new Object[] {});
		    } catch (SecurityException e) {
		        e.printStackTrace();
		    } catch (NoSuchMethodException e) {
		        e.printStackTrace();
		    } catch (IllegalArgumentException e) {
		        e.printStackTrace();
		    } catch (IllegalAccessException e) {
		        e.printStackTrace();
		    } catch (InvocationTargetException e) {
		        e.printStackTrace();
		    }
	}
}
