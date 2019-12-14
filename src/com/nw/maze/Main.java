package com.nw.maze;

import java.util.LinkedList;

import org.springframework.util.CollectionUtils;

public class Main {

	private static final int directions[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	private static final String FILE_NAME = "src/com/nw/maze/maze_101_101.txt";
	private static final int BLOCK_SIZE = 6;

	MazeFrame frame;
	MazeData data;

	public void initFrame() {
		data = new MazeData(FILE_NAME);
		frame = new MazeFrame("Maze Solver", data.M() * BLOCK_SIZE, data.N() * BLOCK_SIZE);
		frame.render(data);
		run();
	}

	private void run() {
		LinkedList<Position> queue = new LinkedList<>();
		Position entrance = new Position(data.getEntranceX(), data.getEntranceY());
		queue.addLast(entrance);
		while (!CollectionUtils.isEmpty(queue)) {
			Position curPos = queue.pop();
			setData(curPos.x, curPos.y, true);
			for (int[] direction : directions) {
				int newX = curPos.x + direction[0];
				int newY = curPos.y + direction[1];
				if (data.inArea(newX, newY) && !data.visited[newX][newY]
						&& data.getMazeChar(newX, newY) == MazeData.ROAD) {
					queue.addLast(new Position(newX, newY));
					data.visited[newX][newY] = true;
				}
			}
		}
		
		setData(-1, -1, false);
	}

	private void setData(int x, int y, boolean isPath) {
		if (data.inArea(x, y)) {
			data.path[x][y] = isPath;
		}
		frame.render(data);
		MazeUtil.pause(10);
	}

	private class Position {
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
