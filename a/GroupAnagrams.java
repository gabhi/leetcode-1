// ["eat", "tea", "tan", "ate", "nat", "bat"], 
// Return 
// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// For the return value, each inner list's elements must follow the lexicographic order.
import java.util.*;
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) return result;
        Map<String, List<String>> map = new HashMap<>();
        Arrays.sort(strs);
        for(String s : strs) {
        	char[] c = s.toCharArray();
        	Arrays.sort(c);
        	String newStr = new String(c);
        	if(!map.containsKey(newStr)) map.put(newStr, new ArrayList<String>());
        	map.get(newStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
    	System.out.println("[info] " + "Anagrams");
    }
}