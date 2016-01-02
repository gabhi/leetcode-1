class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		int n = board.length;
		boolean[][] row = new boolean[n][n], col = new boolean[n][n], box = new boolean[n][n];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == '.' || board[i][j] < '1' || board[i][j] > '9') continue;
				int num = board[i][j] - '0' - 1, k = i / 3 * 3 + j / 3;
				if(row[num][i] || col[num][j] || box[num][k]) return false;
				row[num][i] = col[num][j] = box[num][k] = true;
			}
		}
		return true;
 	}

 	public static void main(String[] args) {}
}