package imagework;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



import gui.GUI;

public class AnimPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7612782985517266375L;
	private File file;
	private File[] dataF;
	private Image[] data;
	private Image current;
	private int currentI=0;
	private static final int TARGET_FPS = 15;
	private static final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
	public boolean isRunning = true;
	public AnimPanel(File file) {
		if(file.isDirectory()) {
			
			this.file=file;
			dataF = file.listFiles();
			data = new Image[dataF.length];
			for(int i = 0 ; i < data.length;i++) {
				try {
					data[i] = ImageIO.read(dataF[i]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			current = data[0];
			currentI++;
		}else {
			throw new IllegalArgumentException(file.getAbsolutePath());
		}
	}
	public AnimPanel(String fileStr) {
		this(new File(fileStr));
	}
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(current, this.getX(), this.getY(), this.getWidth(), this.getHeight(),null);
	}
	public void nextImg() {
		
		if(currentI==data.length) {
			currentI=0;
		}
		current = data[currentI];
		currentI++;
		if(currentI==data.length) {
			currentI=0;
		}
	}
	public void stop() {
		isRunning=false;
	}
	public void start() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				long lastLoopTime = System.nanoTime();

				int lastFpsTime = 0;
				int lastFpsTime1 = 0;
				int fps = 0;
				while(isRunning) {
					long now = System.nanoTime();
					long updateLength = now - lastLoopTime;
					lastLoopTime = now;

					// update the frame counter
					lastFpsTime += updateLength;
					lastFpsTime1 += updateLength;

					// update our FPS counter if a second has passed since
					// we last recorded
					if (lastFpsTime >= 1000000000) {
						System.out.println("(FPS: " + fps + ")");
						lastFpsTime = 0;
						fps = 0;
					}
					if (lastFpsTime1 > OPTIMAL_TIME) {
						fps++;
						nextImg();
						GUI.frame.repaint();
						lastFpsTime1 = 0;
						
					}
					

				}
			}
			
			
		}).start();;
	}
	
}
