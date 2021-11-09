package oscilloscope.keys;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import oscilloscope.display.Display;
import oscilloscope.image.OpenImage;

public class KeyHandler {
	
	public static void listener() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (Display.class) {
                    switch (ke.getID()) {
                    case KeyEvent.KEY_PRESSED:
                    	if (ke.getKeyCode() == KeyEvent.VK_CONTROL) {KeyPressed.CTRL = true;}
                        if (ke.getKeyCode() == KeyEvent.VK_UP) {if(KeyPressed.CTRL) {OpenImage.y-=15;}}
                        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {if(KeyPressed.CTRL) {OpenImage.y+=15;}}
                        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {if(KeyPressed.CTRL) {OpenImage.x-=15;}}
                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {if(KeyPressed.CTRL) {OpenImage.x+=15;}}
                        break;

                    case KeyEvent.KEY_RELEASED:
                    	if (ke.getKeyCode() == KeyEvent.VK_CONTROL) {KeyPressed.CTRL = false;}
                        break;
                    }
                    return false;
                }
            }
        });        
	}
}
