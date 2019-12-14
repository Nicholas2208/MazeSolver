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
		Position entrance = new Position(data.getEntranceX(), data.getEntranceY(), null);
		queue.addLast(entrance);
		
		boolean isSolved = false;
		
		while (!CollectionUtils.isEmpty(queue)) {
			Position curPos = queue.pop();
			setData(curPos.x, curPos.y, true);
			if(curPos.x == data.getExitX() && curPos.y == data.getExitY()) {
				isSolved = true;
				findPath(curPos);
				break;
			}
			for (int[] direction : directions) {
				int newX = curPos.x + direction[0];
				int newY = curPos.y + direction[1];
				if (data.inArea(newX, newY) && !data.visited[newX][newY]
						&& data.getMazeChar(newX, newY) == MazeData.ROAD) {
					queue.addLast(new Position(newX, newY, curPos));
					data.visited[newX][newY] = true;
				}
			}
		}
		
		if(!isSolved) {
			System.out.println("The maze has NO solution!");
		}
		setData(-1, -1, false);
	}

	private void findPath(Position p) {
		Position cur = p;
		while(cur != null) {
			data.result[cur.x][cur.y] = true;
			cur = cur.prev;
		}
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
		private Position prev;

		private Position(int x, int y, Position prev) {
			this.x = x;
			this.y = y;
			this.prev = prev;
		}
	}

	public static void main(String[] args) {
		new Main().initFrame();
	}

}
