// Solve Sudoku by filling empty cells: '.'; only one unique solution.
// 5ms

class SudokuSolver {
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] blocks = new boolean[9][9];
    
	public void solveSudoku(char[][] board) {
		int n = board.length;
		for(int i = 0; i < board.length; i++) {
		    for(int j = 0; j < board[0].length; j++) {
		        if(board[i][j] != '.') {
		        	int num = board[i][j] - '1';
		        	int k = i / 3 * 3 + j / 3;
					rows[num][i] = cols[num][j] = blocks[num][k] = true;		        	
		        }
		    }
		}
        backtracking(board, 0);
    }

    public boolean backtracking(char[][] board, int index) {
    	if(index == 81) return true;
    	int i = index / 9, j = index % 9, k = i / 3 * 3 + j / 3;
    	if(board[i][j] != '.') return backtracking(board, index  + 1);
    	else {
    		for(int num = 0; num < board.length; num++) {
    			if(rows[num][i] || cols[num][j] || blocks[num][k]) continue;
    			rows[num][i] = cols[num][j] = blocks[num][k] = true;
    			board[i][j] = (char) ('1' + num);
    			if(backtracking(board, index + 1)) return true;
    			board[i][j] = '.';
    			rows[num][i] = cols[num][j] = blocks[num][k] = false;  // important
	    	} 
    	}
    	return false;
    }

    public static void main(String[] args) {}
}