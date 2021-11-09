package oscilloscope.Button.ButtonActions;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import oscilloscope.Button.ButtonHandler.Buttons;
import oscilloscope.JSON.JSONReader;
import oscilloscope.display.Display;
import oscilloscope.graphics.Drawing;
import oscilloscope.graphics.Grid;
import oscilloscope.image.OpenImage;
import oscilloscope.main.Main;

public class Actions {
	public static int level = 100;
	public static boolean updated = false;
	public static String outputPath;

	public static void show_grid() {
		if (Grid.show) {
			Grid.show = false;
		} else {
			Grid.show = true;
		}
	}

	public static void lighten() {
		if (Grid.color.getGreen() < 210) {
			float amount = (float) 0.8;
			Color color = Grid.color;
			int red = (int) (color.getRed() / amount);
			int green = (int) (color.getGreen() / amount);
			int blue = (int) (color.getBlue() / amount);
			Grid.color = new Color(red, green, blue);
			level++;
			System.out.println(level);
		}
	}

	public static void darken() {
		if (Grid.color.getGreen() > 5) {
			float amount = (float) 1.25;
			Color color = Grid.color;
			int red = (int) (color.getRed() / amount);
			int green = (int) (color.getGreen() / amount);
			int blue = (int) (color.getBlue() / amount);
			Grid.color = new Color(red, green, blue);
			level--;
			System.out.println(level);
		}
	}

	public static void cross() {
		if (Grid.cross) {
			Grid.cross = false;
		} else {
			Grid.cross = true;
		}
	}

	public static void openImage() {
		OpenImage.finalPath = OpenImage.open();
		Buttons.OPENIMAGE.press(false);
	}

	public static void showImage() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(OpenImage.finalPath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		OpenImage.referenceImage = img;

		if (OpenImage.show) {
			OpenImage.show = false;
		} else {
			OpenImage.show = true;
		}

	}

	public static void translucencyUp() {
		if (OpenImage.translucency <= 0.9) {
			OpenImage.translucency += 0.1;
		}
	}

	public static void translucencyDown() {
		if (OpenImage.translucency > 0.1) {
			OpenImage.translucency -= 0.1;
		}
	}

	public static void translucencyMax() {
		OpenImage.translucency = 1;
	}

	public static void goToOrigin() {
		OpenImage.x = 60;
		OpenImage.y = 60;
	}

	public static void scaleUp() {
		OpenImage.scale *= 1.2;
	}

	public static void scaleDown() {
		OpenImage.scale /= 1.2;
	}

	public static void scaleFull() {
		OpenImage.scale = 1;
	}

	public static void chSwap() {
		if (Main.direction) {
			Main.direction = false;
		} else {
			Main.direction = true;
		}
	}

	public static void draw() {
		Drawing.currentDrawing = true;
	}

	public static void finish() {
		Drawing.currentDrawing = false;
	}

	public static void update() {
		Drawing.createJSON();
		JSONReader.path = "D:\\temp\\crtez.json";
		updated = true;
		Main.finalX.clear();
		Main.finalY.clear();
		Main.arrayX = new float[] {};
		Main.arrayY = new float[] {};
		JSONReader.arrX.clear();
		JSONReader.arrY.clear();
		JSONReader.arrObj.clear();
		JSONReader.init();
		Main.initArrs();
	}

	public static void plot() {

		if (Main.OUTPUT) {
			Main.OUTPUT = false;
		} else {
			Main.OUTPUT = true;
		}
	}

	public static void stepsUp() {
		update();
		Main.steps += 100;
	}

	public static void stepsDown() {
		update();
		Main.steps -= 100;
	}

	public static void stepsNormal() {
		update();
		Main.steps = 1200;
	}

	public static void saveJSON() {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		int userSelection = fileChooser.showSaveDialog(Display.frame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			outputPath = fileToSave.getAbsolutePath();
		}

		PrintWriter output = null;
		try {
			output = new PrintWriter(new File(outputPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		output.println("[");
		@SuppressWarnings("unused")
		int objects = 1;
		for (int i = 0; i < Drawing.arrayObj.length; i++) {
			if (Drawing.arrayObj[i] == "n") {
				objects++;
			}
		}

		Drawing.arrayObj[Drawing.lines - 1] = "n";

		int br = 0;
		int br2 = 0;
		for (int i = 0; i < Drawing.arrayObj.length; i++) {
			if (Drawing.arrayObj[i] == "f") {
				br++;
			} else {
				Drawing.objectNumber[br2] = br;
				br = 0;
				br2++;
			}
		}
		int br3 = 0;
		for (int i = 0; i < Drawing.objectNumber.length; i++) {
			if (Drawing.objectNumber[i] != 0) {
				output.println("  [");
				for (int j = 0; j < Drawing.objectNumber[i] + 1; j++) {
					output.print("    {\"x\":");
					output.print(Drawing.array[br3].x);
					output.print(", \"y\":");
					output.print(Drawing.array[br3].y);
					if (j == Drawing.objectNumber[i]) {
						output.println("}");
					} else {
						output.println("},");
					}
					br3++;
				}
				if (Drawing.objectNumber[i + 1] == 0) {
					output.println("  ]");
				} else {
					output.println("  ],");
				}
			}
		}
		output.println("]");
		output.flush();
		output.close();
	}

}
