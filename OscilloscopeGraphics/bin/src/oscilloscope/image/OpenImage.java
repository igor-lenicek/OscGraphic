package oscilloscope.image;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class OpenImage {
	
	public static int x = 60;
	public static int y = 60;
	public static boolean show = false;
	public static float translucency = (float) 0.5;
	public static String finalPath = "";
	public static BufferedImage referenceImage;
	public static float scale = 1;
	
	public static String open() {
		 JFileChooser chooser = new JFileChooser();
		    chooser.setCurrentDirectory(new File("."));

		    chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {


			@Override
			public boolean accept(File arg0) {
				return false;
			}

			@Override
			public String getDescription() {
				return null;
			}
		    });

		    int r = chooser.showOpenDialog(new JFrame());
		    if (r == JFileChooser.APPROVE_OPTION) {
		      String path = chooser.getSelectedFile().getAbsolutePath();
		      return path;
		    }
		    
		    return null;
	}
}
