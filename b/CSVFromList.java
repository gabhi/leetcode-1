package companies.airbnb;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class CSVFromList {
  //10:37
  
  public static String listToCSV (List<List<String>> data) {
    if(data == null || data.size() == 0) return "";
    
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < data.size(); i++) {
      List<String> row = data.get(0);
      if(row == null || row.size() == 0) continue;

      if(i != 0) sb.append("\n");
      sb.append(row.get(0));
      for(int j = 0; j < row.size(); j++) {
        sb.append("|");
        sb.append(row.get(j));
      }
    }
                
    return sb.toString();
  }
  
  public static void main(String[] args) {
    ArrayList<List<String>> data = new ArrayList<List<String>>();
    data.add(Arrays.asList("John", "Smith", "johnsmith@gmail.com", "Los Angelas, CA"));
    data.add(Arrays.asList("Jane", "Roberts", "janer@msn.com", "San Francisco, CA", "0"));

    String res = listToCSV(data);
    System.out.println(res);
  }
}
