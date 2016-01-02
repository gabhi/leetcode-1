import java.util.*;

class BestMeetingPoint {
	public int minTotalDistance(int[][] grid) {
		List<Integer> I = new ArrayList<>();
		for(int i = 0; i < grid.length; i++) { 
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1) I.add(i);
			}
		}

		List<Integer> J = new ArrayList<>();
		for(int j = 0; j < grid[0].length; j++) { 
			for(int i = 0; i < grid.length; i++) {
				if(grid[i][j] == 1) J.add(j);
			}
		}

		return min(grid, I) + min(grid, J);
	}

	public int min(int[][] grid, List<Integer> list) {
		int sum = 0, i = 0, j = list.size() - 1;
		while(i < j) {
			sum += list.get(j--) - list.get(i++);
		}
		return sum;
	}

	public static void main(String[] args) {}
}