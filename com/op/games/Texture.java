package com.op.games;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Texture {
	public int[] pixels;
	private String loc;
	public final int SIZE;
	
	public Texture(String location, int size) {
		loc = location;
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	private void load() {
		try {
			BufferedImage image = ImageIO.read(new File(loc));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Texture wood = new Texture("C:\\Users\\Austin\\Documents\\GitHub\\JavaOptest\\res\\GameAssets\\wood.png", 64);
	public static Texture brick = new Texture("C:\\Users\\Austin\\Documents\\GitHub\\JavaOptest\\res\\GameAssets\\redbrick.png", 64);
	public static Texture bluestone = new Texture("C:\\Users\\Austin\\Documents\\GitHub\\JavaOptest\\res\\GameAssets\\bluestone.png", 64);
	public static Texture stone = new Texture("C:\\Users\\Austin\\Documents\\GitHub\\JavaOptest\\res\\GameAssets\\greystone.png", 64);
}