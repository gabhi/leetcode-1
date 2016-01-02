import java.util.*;

class ShortestDistanceFromAllBuildings {

	int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public int shortestDistance(int[][] grid) {
		if(grid == null || grid.length == 0) return - 1;
		int m = grid.length, n = grid[0].length;
		
		int buildings = 0;
		int[][] distance = new int[m][n]; // sum of distance from reached buildings
		int[][] count = new int[m][n];    // count of reached buildings

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 1) {
					buildings++;
					bfs(grid, distance, count, m, n, i, j);
				}
			}
		}

		int shortest = Integer.MAX_VALUE;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 0 && count[i][j] == buildings) {
					shortest = Math.min(shortest, distance[i][j]);
				} 
			}
		}
		return shortest == Integer.MAX_VALUE ? -1 : shortest;
	}

	public void bfs(int[][] grid, int[][] distance, int[][] count, 
		int m, int n, int i, int j) {
		boolean[][] visited = new boolean[m][n];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, j});
		int level = 0;
		while(!q.isEmpty()) {
			level++;
			int size = q.size();
			for(int k = 0; k < size; k++) {
				int[] p = q.poll();
				for(int[] dir : dirs) {
					int x = p[0] + dir[0];
					int y = p[1] + dir[1];
					if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] != 0) continue;
					distance[x][y] += level;
					count[x][y]++;
					visited[x][y] = true;
					q.add(new int[] {x, y});
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] grid = {
			{1, 0, 2, 0, 1},
			{0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0}
		};
		for(int[] r : grid) {
			for(int i : r) System.out.print(i + " ");
			System.out.println();
		}

		System.out.println();
		int res = new ShortestDistanceFromAllBuildings().shortestDistance(grid);
		System.out.println(res);
	}
}
