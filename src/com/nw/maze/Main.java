package com.nw.maze;

public class Main {
	
	private static final String FILE_NAME = "src/com/nw/maze/maze_101_101.txt";
	private static final int BLOCK_SIZE = 6;
	
	MazeFrame frame;
	
	public void initFrame() {
		MazeData data = new MazeData(FILE_NAME);
		frame = new MazeFrame(
				"Maze Solver", data.M() * BLOCK_SIZE, data.N() * BLOCK_SIZE);
		frame.render(data);
	}

	public static void main(String[] args) {
		new Main().initFrame();
	}

}