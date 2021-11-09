package oscilloscope.Button.ButtonHandler;

public class ReleaseButtons {
	
	public static void release() {
		for(Button e : Buttons.BUTTONS) {
			e.press(false);
		}
	}
}
