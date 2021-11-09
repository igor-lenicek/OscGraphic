package oscilloscope.image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class InitImages {
	
	public static void initImages() {
		BufferedImage img = null;
		try {
			 URL url = InitImages.class.getResource(Image.CH1);
			img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Images.CH1 = img;
		
		BufferedImage img2 = null;
		try {
			 URL url = InitImages.class.getResource(Image.CH2);
			img2 = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Images.CH2 = img2;
		
	}
}
