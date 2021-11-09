package oscilloscope.main;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import oscilloscope.JSON.JSONReader;
import oscilloscope.display.Display;
import oscilloscope.graphics.Drawing;
import oscilloscope.image.InitImages;
import oscilloscope.keys.KeyHandler;

public class Main {
	
	public static String[] arrayObj;
	public static float[] arrayX;
	public static float[] arrayY;
	public static List<Float> finalX = new ArrayList<Float>();
	public static List<Float> finalY = new ArrayList<Float>();
	public static int steps = 1200;
	public static int jd = 100;
	public static boolean direction = true;
	public static boolean OUTPUT = false;
    public static byte[] buf = new byte[ 2 ];;
    public static AudioFormat af = new AudioFormat(44100, 8, 2, true, false);
    public static SourceDataLine sdl = null;
    
    
    
	public static void main(String[] args) throws LineUnavailableException, InterruptedException {
		JSONReader.init();
		try {
			Main.sdl = AudioSystem.getSourceDataLine( Main.af );
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
	    try {
			Main.sdl.open();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	    
	    Main.sdl.start();
	    Main.initArrs();
		Drawing.initArrs();
		KeyHandler.listener();
		InitImages.initImages();
		Display.displaySetup();
		
	}
	
	public static void createArray() {
		for(int i = 0; i < arrayX.length-1; i++) {
			int stepPerStep = steps/(arrayX.length-1);
			float difference = Math.abs(arrayX[i]-arrayX[i+1]);
			float increment = difference/stepPerStep;
			for(int j = 0; j < stepPerStep+1; j++) {
				if(arrayObj[i].equals("f")) {
				if(arrayX[i]<arrayX[i+1]) {
					finalX.add(arrayX[i]+increment*j);
				}else {
					finalX.add(arrayX[i]-increment*j);
				}
				}
			}
		}
		for(int i = 0; i < arrayY.length-1; i++) {
			int stepPerStep = steps/(arrayY.length-1);
			float difference = Math.abs(arrayY[i]-arrayY[i+1]);
			float increment = difference/stepPerStep;
			for(int j = 0; j < stepPerStep+1; j++) {
				if(arrayObj[i].equals("f")) {
				if(arrayY[i]<arrayY[i+1]) {
					finalY.add(arrayY[i]+increment*j);
				}else {
					finalY.add(arrayY[i]-increment*j);
				}
				}
			}
		}
    	
	}
	
	
	public static void initArrs() {
		arrayX = new float[JSONReader.arrX.size()];
		arrayY = new float[JSONReader.arrY.size()];
		arrayObj = new String[JSONReader.arrObj.size()];
		
		for(int k = 0; k < JSONReader.arrX.size(); k++) {
			arrayX[k]=JSONReader.arrX.get(k);
			arrayY[k]=JSONReader.arrY.get(k);
			arrayObj[k]=JSONReader.arrObj.get(k);
		}
	}
}
