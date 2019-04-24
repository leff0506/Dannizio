package imagework;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class PhotosDB {
	public static Map<String, BufferedImage> stPhotos= new HashMap<>();
	public static BufferedImage getPhoto(String name) {
		if(stPhotos.containsKey(name)) {
			return stPhotos.get(name);
		}
		return null;
	}
	public static void upload(String path,String name) {
		try {
			stPhotos.put(name, ImageIO.read(new File(path)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
