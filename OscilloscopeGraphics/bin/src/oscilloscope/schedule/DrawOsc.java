package oscilloscope.schedule;
import oscilloscope.main.Main;

public class DrawOsc {
	
	
	public static long lastTime = 0;
	public static long newTime = 0;
	
	public static void draw(){
	    	if(Main.OUTPUT) {
	    		Main.createArray();
	    	for(int m = 0; m < Main.finalX.size(); m++) {
	    		if(Main.direction) {
			    	Main.buf[ 0 ] = (byte)(Math.cos(0)*Main.finalX.get(m));
			    	Main.buf[ 1 ] = (byte)(Math.cos(0)*Main.finalY.get(m));
	    		}else {
	    			Main.buf[ 1 ] = (byte)(Math.cos(0)*Main.finalX.get(m));
			    	Main.buf[ 0 ] = (byte)(Math.cos(0)*Main.finalY.get(m));
	    		}

		    	Main.sdl.write(Main.buf, 0, 2);
			    lastTime = newTime;
			    newTime = System.currentTimeMillis();
	    	}


	    	}
	    	

	}
}
