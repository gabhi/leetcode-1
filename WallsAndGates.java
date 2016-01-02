class WallsAndGates {

	int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public void wallsAndGates(int[][] rooms) {
		if(rooms == null || rooms.length == 0) return;
		int m = rooms.length, n = rooms[0].length;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(rooms[i][j] == 0) {
					dfs(rooms, m, n, i, j);
				}
			}
		}
	}

	public void dfs(int[][] rooms, int m, int n, int i, int j) {
		int distance = rooms[i][j];
		for(int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			System.out.println("Trying... " + x + " " + y);
			if(x < 0 || x >= m || y < 0 || y >= m || rooms[x][y] == -1 || rooms[x][y] <= distance) continue;
			rooms[x][y] = distance + 1;
			dfs(rooms, m, n, x, y);
		}

	}
	
	public static void main(String[] args) {
		int[][] rooms = {
			{2147483647, -1, 0, 2147483647}, 
			{2147483647, 2147483647, 2147483647, -1},
			{2147483647, -1, 2147483647, -1},
			{0, -1, 2147483647, 2147483647}
		};
		for(int[] r : rooms) {
			for(int i : r) System.out.print(i + " ");
			System.out.println();
		}

		new WallsAndGates().wallsAndGates(rooms);
		for(int[] r : rooms) {
			for(int i : r) System.out.print(i + " ");
			System.out.println();
		}
	}
}
