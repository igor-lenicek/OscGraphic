package oscilloscope.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import oscilloscope.Button.ButtonActions.Actions;
import oscilloscope.display.Display;

public class Drawing {

	public static int lines = 0;
	public static Point[] array;
	public static String[] arrayObj;
	public static PrintWriter output;
	public static int number = 200;
	public static int[] objectNumber;
	public static boolean done = false;
	public static boolean imageDrawn = false;
	public static boolean currentDrawing = false;

	public static void drawing() {
		drawLines();
	}

	public static void clicked(Point point, int button) {
		if (point.x < 870 && point.x > 60 && point.y < 870 && point.y > 60 && currentDrawing) {

			if (button == 1) {
				lines++;
				array[lines - 1] = new Point((point.x - 465) / 4, -(point.y - 465) / 4);
				if (lines > 1) {
					arrayObj[lines - 2] = "f";
					Actions.updated = false;
				}
			}
			if (button == 3) {
				if (lines > 0) {
					lines--;
					array[lines] = null;
					arrayObj[lines] = null;
				}
				Actions.updated = false;
			}

			if (button == 2) {
				if (lines > 1) {
					arrayObj[lines - 1] = "n";
				}
				lines++;
				array[lines - 1] = new Point((point.x - 465) / 4, -(point.y - 465) / 4);
			}
			Actions.updated = false;
		}
	}

	public static void initArrs() {
		array = new Point[number];
		arrayObj = new String[number];
		objectNumber = new int[number];
	}

	public static void drawLines() {
		Display.g.setStroke(new BasicStroke(3));
		Display.g.setColor(new Color(100, 150, 100));
		if (array[0] != null) {
			for (int i = 0; i < lines - 1; i++) {
				if (arrayObj[i] == "f") {
					Display.g.drawLine(array[i].x * 4 + 465, -array[i].y * 4 + 465, array[i + 1].x * 4 + 465,
							-array[i + 1].y * 4 + 465);
				}
			}
			if (done == false) {
				if (Display.frame.getMousePosition() != null) {
					if (Display.frame.getMousePosition().x - 8 < 870 && Display.frame.getMousePosition().x - 8 > 60
							&& Display.frame.getMousePosition().y - 29 < 870
							&& Display.frame.getMousePosition().y - 29 > 60 && currentDrawing) {
						Display.g.drawLine(array[lines - 1].x * 4 + 465, -array[lines - 1].y * 4 + 465,
								Display.frame.getMousePosition().x - 8, Display.frame.getMousePosition().y - 29);
					}
				}
			}
		}
	}
	
	public static void createJSON(){
		  PrintWriter output = null;
		try {
			output = new PrintWriter(new File("D:\\temp\\crtez.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  output.println("[");
		  @SuppressWarnings("unused")
		int objects = 1;
		  for(int i = 0; i < arrayObj.length; i++){
		    if(arrayObj[i]=="n"){
		      objects++;
		    }
		  }
		  
		  arrayObj[lines-1] = "n";
		  
		  int br = 0;
		  int br2 = 0;
		  for(int i = 0; i < arrayObj.length; i++){
		    if(arrayObj[i]=="f"){
		      br++;
		    }else{
		      objectNumber[br2] = br;
		      br = 0;
		      br2++;
		    }
		  }
		 int br3 = 0;
		  for(int i = 0; i < objectNumber.length; i++){
		    if(objectNumber[i]!=0){
		    output.println("  [");
		    for(int j = 0; j < objectNumber[i]+1; j++){
		      output.print("    {\"x\":");
		      output.print(array[br3].x);
		      output.print(", \"y\":");
		      output.print(array[br3].y);
		      if(j==objectNumber[i]){
		        output.println("}");
		      }else{
		      output.println("},");
		    }
		      br3++;
		    }
		    if(objectNumber[i+1]==0){
		    output.println("  ]");
		    }else{
		      output.println("  ],");
		    }
		    }
		    
		  }
		   output.println("]");
		  
		  
		  
		  
		  output.flush();
		  output.close();
		}
	
	
	
}
