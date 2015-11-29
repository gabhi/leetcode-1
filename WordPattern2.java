// 11: 19

// pattern = "abab", str = "redblueredblue" should return true.
// pattern = "aaaa", str = "asdasdasdasd" should return true.
// pattern = "aabb", str = "xyzabcxzyabc" should return false.
 import java.util.*;
class WordPattern2 {
    public boolean wordPatternMatch(String pattern, String str) {
        return matched(pattern, 0, str, 0, new HashMap<Character, String>(), new HashSet<String>());
    }
    public boolean matched(String pat, int pi, String str, int si, Map<Character, String> map, Set<String> seen) {
    	if(pi == pat.length() && si == str.length()) return true;
    	if(pi == pat.length() || si == str.length()) return false;
    	
    	char c = pat.charAt(pi);
    	if(map.containsKey(c)) {
    		String s = map.get(c);
    		if(!str.startsWith(s, si)) return false;
    		return matched(pat, pi + 1, str, si + s.length(), map, seen);
    	}

    	for(int i = si; i < str.length(); i++) {
    		String s = str.substring(si, i + 1);
    		if(seen.contains(s)) continue;
    		map.put(c, s);
    		seen.add(s);
    		if (matched(pat, pi + 1, str, i + 1, map, seen)) return true; // cannot directly return
    		seen.remove(s);
    		map.remove(c);
    	}
    	return false;

    }
    
	public static void main(String[] args) {
		String str = "redblueredblue";
		String pattern = "abab";
		System.out.println("[test] " + " Testing startsWith");
		System.out.println("[test] " + str.startsWith("red", 7)); // First one is the substring, 2nd is the index
		System.out.println("[test] " + str.startsWith("redd", 7));

		System.out.println("\n[info]" + " Word Pattern2");
		System.out.println("[info] " + str.startsWith("red", 7)); //
	}
}