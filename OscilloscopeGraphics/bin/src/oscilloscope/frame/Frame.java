package oscilloscope.frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import oscilloscope.Button.ButtonHandler.ReleaseButtons;
import oscilloscope.display.Display;
import oscilloscope.display.DisplaySize;
import oscilloscope.graphics.Drawing;
import oscilloscope.mouse.ButtonPress;

@SuppressWarnings("serial")
public class Frame extends JFrame implements MouseListener{

	public Frame(){
		this.setTitle("Render");
		this.add(Display.display);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Display.display.addMouseListener(this);
		DisplaySize.setWindowed(this);
		Display.display.start();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		ButtonPress.check(arg0.getPoint());
		Drawing.clicked(arg0.getPoint(), arg0.getButton());
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		ReleaseButtons.release();

	}
}
