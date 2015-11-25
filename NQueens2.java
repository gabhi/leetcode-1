import java.util.*;

public class NQueens2 {
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> solution = new ArrayList<String>();
        boolean[] cols = new boolean[n];       //  columns
        boolean[] d1 = new boolean[2 * n];     //  diagonal \
        boolean[] d2 = new boolean[2 * n];     //  diagonal /
        backtracking(result, solution, 0, cols, d1, d2, n);
        return result;
    }
    
    public void backtracking(List<List<String>> result, List<String> solution, 
        int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
        if(row == n) result.add(new ArrayList<String>(solution));
        
        // for current row, iterate each column
        for(int col = 0; col < n; col++) {
            int id1 = col - row + n;   // adding padding to make id from 0 -> n
            int id2 = col + row;
            if(cols[col] || d1[id1] || d2[id2]) continue;
            
            char[] r = new char[n];
            Arrays.fill(r, '.');
            r[col] = 'Q';
            solution.add(new String(r));
            
            cols[col] = true; d1[id1] = true; d2[id2] = true;
            backtracking(result, solution, row + 1, cols, d1, d2, n);
            cols[col] = false; d1[id1] = false; d2[id2] = false;
            solution.remove(solution.size() - 1);
            
        }
    }
    
    public static void main(String[] args) {}   
}