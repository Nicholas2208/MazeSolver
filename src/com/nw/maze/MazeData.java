package com.nw.maze;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class MazeData {
	
	private int N, M;
	private char[][] maze;
	
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

	public int N() {
		return N;
	}

	public int M() {
		return M;
	}
	
	

}
