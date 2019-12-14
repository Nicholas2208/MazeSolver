package com.nw.maze;

public class Main {
	
	private static final String FILE_NAME = "src/com/nw/maze/maze_101_101.txt";
	private static final int BLOCK_SIZE = 6;
	
	MazeFrame frame;
	MazeData data;
	
	public void initFrame() {
		data = new MazeData(FILE_NAME);
		frame = new MazeFrame(
				"Maze Solver", data.M() * BLOCK_SIZE, data.N() * BLOCK_SIZE);
		frame.render(data);
		run();
	}
	
	private void run() {
		Position entrance = new Position(data.getEntranceX(), data.getEntranceY());
		setData(entrance.x, entrance.y, true);
	}
	
	private void setData(int x, int y, boolean isPath) {
		if(data.inArea(x, y)) {
			data.path[x][y] = isPath;
		}
		frame.render(data);
	}
	
	private class Position{
		private int x, y;
		private Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		new Main().initFrame();
	}

}
