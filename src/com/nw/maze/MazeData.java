package com.nw.maze;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class MazeData {
	
	private int N, M;
	private int entranceX, entranceY;
	private char[][] maze;
	public boolean[][] path;
	public static final char WALL ='#';
	
	public MazeData(String fileName) {
		Scanner scanner = null;
		try {
			File file =new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
			String mnLine = scanner.nextLine();
			String[] nm = mnLine.trim().split("\\s+");
			N = Integer.parseInt(nm[0]);
			M = Integer.parseInt(nm[1]);
			maze = new char[N][M];
			path = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				String line = scanner.nextLine();
				for(int j = 0; j < M; j++) {
					maze[i][j] = line.charAt(j);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(scanner != null) {
				scanner.close();
			}
		}
	}
	
	public boolean inArea(int x, int y) {
		return x >= 0 && x < N && y >=0 && y < M;
	}
	
	public char getMazeChar(int i, int j) {
		return maze[i][j];
	}

	public int getEntranceX() {
		return entranceX;
	}

	public int getEntranceY() {
		return entranceY;
	}

	public int N() {
		return N;
	}

	public int M() {
		return M;
	}
	
	

}
