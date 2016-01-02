import java.util.*;

class RemoveInvalidParentheses {


    // DFS 9ms
    // To remove min num of parentheses, count the nums beforehead.
	public List<String> removeInvalidParentheses(String s) {
		Set<String> res = new HashSet<>();
		int rmL = 0, rmR = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') rmL++;
		    if(s.charAt(i) == ')') {
		    	if(rmL != 0) rmL--;
		    	else rmR++;
		    }
		}
		DFS(res, s, 0, rmL, rmR, 0, new StringBuilder());
        return new ArrayList<String>(res);	
    }

    public void DFS(Set<String> res, String s, int i, int rmL, int rmR, int open, StringBuilder sb) {
	    if(i == s.length() && rmL == 0 && rmR == 0 && open == 0) {
	    	res.add(sb.toString());
	    	return;
	    }
	    if(i == s.length() || rmL < 0 || rmR < 0 || open < 0) return;
	    
	    char c = s.charAt(i);
        int len = sb.length();
        
    	if(c == '(') {
    		DFS(res, s, i + 1, rmL - 1, rmR, open, sb);
    		DFS(res, s, i + 1, rmL, rmR, open + 1, sb.append(c)); 
    		
    	} else if(c == ')') {
    		DFS(res, s, i + 1, rmL, rmR - 1, open, sb);
    		DFS(res, s, i + 1, rmL, rmR, open - 1, sb.append(c));
    		
    	} else {
    		DFS(res, s, i + 1, rmL, rmR, open, sb.append(c)); 
    	}
    	
    	sb.setLength(sb.length() - 1);
    }



	// BFS

	public List<String> removeInvalidParenthesesBFS(String s) {
        List<String> res = new ArrayList<>();
        if(s == null) return res;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(s);
        visited.add(s);
        boolean found = false;
        while(!queue.isEmpty()) {
            s = queue.poll();
            if(isValid(s)) {
                res.add(s);
                found = true; 
            }
            if(found) continue;  // Got Neareast Level Nodes
            
            for(int i = 0; i < s.length(); i++) {   // Neighbors
                if(s.charAt(i) == '(' || s.charAt(i) == ')') {
                    String t = s.substring(0, i) + s.substring(i + 1);
                    if(!visited.contains(t)) {
                        queue.add(t);
                        visited.add(t);
                    }
                }
            }
        }
        return res;
    }
    
    public boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') count++;
            if(s.charAt(i) == ')') {
                if(count == 0) return false;
                count --;
            }
        }
        return count == 0;
    }
    public static void main(String[] args) {
    	System.out.println("[info] " + "RemoveInvalidParentheses");
    }
}