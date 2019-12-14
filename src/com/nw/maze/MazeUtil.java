package com.nw.maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class MazeUtil {

	public static final Color Red = new Color(0xF44336);
	public static final Color LightBlue = new Color(0x03A9F4);
	public static final Color Yellow = new Color(0xFFEB3B);
	public static final Color White = new Color(0xFFFFFF);
	
	private Graphics2D g2d;

	private MazeUtil(Graphics2D g2d) {
		this.g2d = g2d;
	}
	
	public static MazeUtil getInstance(Graphics g) {
		return new MazeUtil((Graphics2D) g);
	}
	
	public void setColor(Color color) {
		this.g2d.setColor(color);
	}
	
	public void fillRectangle(int x, int y, int w, int h) {
		Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
		g2d.fill(rectangle);
	}

}
