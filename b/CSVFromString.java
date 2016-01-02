

// https://hellosmallworld123.wordpress.com/2015/09/04/abnb-%E9%9D%A2%E7%BB%8F%E6%80%BB%E7%BB%93/
/*
Parse CSV

csv parser
如果有逗号，转化成|
如果有引号，把不考虑引号里逗号，把引号里的内容去引号整体打印。
如果有两重引号，只去掉一重引号。

例子
aa, bb, “aa”,”aa,bb”, “aa””aa”””
输出
aa|bb|aa|aa,bb|aa”aa”

*/
 // Parse an escaped string into csv format. 

// AIRBNB确实有题库，店面就是那个parser csv，可惜lz 之前看到了没有认真写，keng keng ba ba 写完了，到最后有个bug，被白人小哥指出来，最后也通过了test case。
// 九成挂，就怪自己功夫不到家，同学们加油把。

 
// 贴一个，过了那几个测试。不知道符不符合要求。

// public List<String> parse(String s) {
//         List<String> res = new ArrayList<String>();
//         char quote = '0';
//         int i = 0;. visit 1point3acres.com for more.
//         int j = 0;
//         int len = s.length();

//         while (i < len) {
//             char c = s.charAt(i);
//             switch (c) {
//             case '\'':
//             case '\"':
//                 if (quote == '0') {.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
//                     quote = c;
//                     j = i + 1;
//                 } else {
//                     if (quote == c) {
//                         res.add(s.substring(j, i));
//                         j = i + 1;
//                         quote = '0';
//                     }
//                 }
//                 break;
//             case ',' :
//                 if (quote == '0') {. from: 1point3acres.com/bbs 
//                     j = i + 1;
//                 }
// . Waral 鍗氬鏈夋洿澶氭枃绔�,
//                 break;
//             default:.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
//             }
//             ++i;
//         }. Waral 鍗氬鏈夋洿澶氭枃绔�,

//         return res;
//     }











import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class CSVFromString {
  //12:11
//   例子
// aa, bb, "aa","aa,aa,bb,cc", "aa"aa""
// 输出
// aa|bb|aa|aa,bb,cc|aa”aa”
    
  public static String stringToCSV (String str) {
    if(str == null || str.length() == 0) return "";
    StringBuilder sb = new StringBuilder();
    int i = 0, j = 0, quotes = 0; 

    while(j < str.length()) {
      char c = str.charAt(j);
      if(c == '"') quotes++;
      if(c == ',' && quotes % 2 == 0) {
        sb.append(trimQuotes(str, i, j));
        sb.append("|");
        i = j + 1;
        quotes = 0;
      }
      j++;
    }
    sb.append(trimQuotes(str, i, j));
    return sb.toString();
  }
  
  private static String trimQuotes(String str, int i, int j) {
    String sub = str.substring(i, j).trim();
    if(sub.charAt(0) == '\"') {
      sub = sub.substring(1, sub.length() - 1);
    }
    sub.replace("\"\"", "\"");
    return sub;
  }
  
  
  public static void main(String[] args) {
    String input = "aa, bb, \"aa\",\"aa,bb\", \"aa\"\"aa\"\"\"";
    String res = stringToCSV(input);
    System.out.println(res);
  }
}
