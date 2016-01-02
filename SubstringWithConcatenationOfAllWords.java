import java.util.*;

// 3: 45
//  b a r f o o t h e f o o b a r m a n, ["foo", "bar"]
// [0 ...      ]     [9 ...      ]  

public class SubstringWithConcatenationOfAllWords {
        
    // This is sliding window approach O(N)
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || words == null || words.length == 0) return res;
        
        Map<String, Integer> map = new HashMap<>();
        for(String w : words) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);  // new API
        
        // int n = words.length, delta = words[0].length(), len = n * delta;
        // for(int i = 0; i + len < s.length(); i++) {
        //     Map<String, Integer> copy = new HashMap<>(map);
        //     for(int k = 0; k < n; k++) { //
        //         String sub = s.substring(i + k * delta, i + (k + 1) * delta);
        //         if(copy.containsKey(sub)) {
        //             int count = copy.get(sub);
        //             if(count == 1) copy.remove(sub);
        //             else copy.put(sub, count - 1);
        //             if(copy.isEmpty()) {
        //                 res.add(i); 
        //                 break;
        //             }
        //         } else break;
        //     } 
        // }
        return res;   
    }

    // This is O(N ^ 2) which got TLE
    public List<Integer> findSubstringTLE(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || words == null || words.length == 0) return res;
        
        Map<String, Integer> map = new HashMap<>();
        for(String w : words) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);  // new API
        
        int n = words.length, delta = words[0].length(), len = n * delta;
        for(int i = 0; i + len < s.length(); i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for(int k = 0; k < n; k++) { //
                String sub = s.substring(i + k * delta, i + (k + 1) * delta);
                if(copy.containsKey(sub)) {
                    int count = copy.get(sub);
                    if(count == 1) copy.remove(sub);
                    else copy.put(sub, count - 1);
                    if(copy.isEmpty()) {
                        res.add(i); 
                        break;
                    }
                } else break;
            } 
        }
        return res;   
    }


    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> res = new SubstringWithConcatenationOfAllWords().findSubstring(s, words);
        for(int i : res) System.out.println(i);

    }
}