package oscilloscope.schedule;

import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.RenderingHints;
import java.io.IOException;

import oscilloscope.Button.ButtonHandler.DrawButtons;
import oscilloscope.display.Display;
import oscilloscope.graphics.Background;
import oscilloscope.graphics.Bounds;
import oscilloscope.graphics.Channels;
import oscilloscope.graphics.Drawing;
import oscilloscope.graphics.Grid;
import oscilloscope.graphics.Panels;
import oscilloscope.graphics.Reference;

public class Render {
	
	public static void render() throws FontFormatException, IOException {
		Display.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Background.background(new Color(30, 30, 30));
		Reference.drawReference();
		
		Panels.panels();
		Grid.drawGrid();
		Bounds.bounds(new Color(70, 70, 70));
		Drawing.drawing();
		DrawButtons.draw();
		DrawOsc.draw();
		Channels.drawChannels();
	}
}
