import java.util.*;

public class AlienDictionary {
private final int N = 26;
public String alienOrder(String[] words) {
    List<Set<Integer>> adj = new ArrayList<>(N);
    int[] degree = new int[N];
    buildGraph(words, adj, degree);
    for(int i = 0; i < N; i++) {
        Set<Integer> set = adj.get(i);
        if(!set.isEmpty()) {
            for(int t : set) {
                System.out.println(t);
            }
        }
    }
    StringBuilder sb = new StringBuilder();
    Queue<Integer> q = new LinkedList<>();
    for(int i = 0; i < N; i++) {
        if(degree[i] == 0) q.add(i);
    }
    // peeling 0 indegree nodes
    while(!q.isEmpty()) {
        int i = q.poll();
        sb.append((char) ('a' + i));
        for(int j : adj.get(i)) {
            if(--degree[j] == 0) {
                q.add(j);
            }
        }
    }
    for(int d : degree) if(d > 0) return "";  // invalid
    return sb.toString();
}

public void buildGraph(String[] words, List<Set<Integer>> adj, int[] degree) {
    for(int i = 0; i < N; i++) adj.add(new HashSet<Integer>());
    Arrays.fill(degree, -1);

    for(int i = 0; i < words.length; i++) {
        for(char c : words[i].toCharArray()) { 
            if(degree[c - 'a'] < 0) degree[c - 'a'] = 0;
        }
        if(i > 0) {
            String w1 = words[i - 1], w2 = words[i];
            int len = Math.min(w1.length(), w2.length());
            for(int j = 0; j < len; j++) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    int c1 = w1.charAt(j) - 'a', c2 = w2.charAt(j) - 'a';
                    if(!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        degree[c2]++;
                        break;
                    }
                }
            }
        }
    }
}

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        // String[] words = {"a", "b", "a"};
        String res = new AlienDictionary().alienOrder(words);
        System.out.println(res);
    }
} 
