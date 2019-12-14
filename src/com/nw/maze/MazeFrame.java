package com.nw.maze;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MazeFrame  extends JFrame{
	
	private int canvasWidth;
	private int canvasHeight;
	
	private MazeData data;
	
	public MazeFrame(String title, int canvasWidth, int canvasHeight) {
		super(title);
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		MazeCanvas canvas = new MazeCanvas();
		this.setContentPane(canvas);
		
		this.pack();
		this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	
	public void render(MazeData data) {
		this.data = data;
	}
	
	public void paint(MazeUtil util) {
		int w = canvasWidth / data.M();
		int h = canvasHeight / data.N();
		for(int i = 0; i < data.N(); i++) {
			for(int j = 0; j < data.M(); j++) {
				if(data.getMazeChar(i, j) == MazeData.WALL) {
					util.setColor(MazeUtil.LightBlue);
				}else {
					util.setColor(MazeUtil.White);
				}
				util.fillRectangle(j * w, i * h, w, h);
			}
		}
	}
	
	private class MazeCanvas extends JPanel{

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			MazeUtil util = MazeUtil.getInstance(g);
			if(data != null) {
				MazeFrame.this.paint(util);
			}
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth, canvasHeight);
		}
		
		
	}

}
