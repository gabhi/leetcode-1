// https://leetcode.com/discuss/71785/imagine-the-process-of-flooding-easy-bfs-solution

import java.util.*;
class SurroundedRegions {
	int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
        	if(board[i][0] == 'O') bfs(board, i, 0);
        	if(board[i][n - 1] == 'O') bfs(board, i, n - 1);
        }
        for(int j = 0; j < n; j++) {
        	if(board[0][j] == 'O') bfs(board, 0, j);
        	if(board[m - 1][j] == 'O') bfs(board, m - 1, j);
        }
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(board[i][j] == '#') board[i][j] = 'O';   // being flooded by water
        		else if(board[i][j] == 'O') board[i][j] = 'X';   // Change inland water to land
        	}
        }
	}

	public void bfs(char[][] board, int i, int j) {
	    Queue<Integer> q = new LinkedList<Integer>();
		int m = board.length, n = board[0].length;
		board[i][j] = '#';
		q.add(i * n + j);
		while(!q.isEmpty()) {
			int point = q.poll();
			int x = point / n, y = point % n;
			for(int[] dir : dirs) {
				int xNb = x + dir[0], yNb = y + dir[1];
				if(xNb <= 0 || xNb >= m - 1 || yNb <= 0 || yNb >= n - 1) continue; 
				if(board[xNb][yNb] == 'O') {
					board[xNb][yNb] = '#';
					q.add(xNb * n + yNb);
				}
			}
		}
	}
    public static void main(String[] args) {
    	// char[][] board = {{'X', 'X', 'X'}, {'X', 'O', 'X'}, {'X', 'X', 'X'}};
    	char[][] board = {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
    	for(char[] row : board) {
    		for(char val : row) {
    			System.out.print(val + " ");
    		}
    		System.out.println();
    	}
    	
    	new SurroundedRegions().solve(board);	
    	System.out.println("\nAfter: ");
    	for(char[] row : board) {
    		for(char val : row) {
    			System.out.print(val + " ");
    		}
    		System.out.println();
    	}
    }
}
class Point {
	int x;
	int y;
}