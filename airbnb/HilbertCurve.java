package companies.airbnb;
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*Hilbert Curve
  
  
  https://www.google.com/search?q=hilbert+curve&sa=X&espv=2&biw=1497&bih=1212&tbm=isch&imgil=TS1hWHzh31OOxM%253A%253BJFXmuIuccwA7cM%253Bhttp%25253A%25252F%25252Fcorte.si%25252F%252525252Fposts%25252Fcode%25252Fhilbert%25252Fportrait%25252Findex.html&source=iu&pf=m&fir=TS1hWHzh31OOxM%253A%252CJFXmuIuccwA7cM%252C_&dpr=0.9&usg=__Mp8DCZbYcejXOiEt-bWUdA0DA-I%3D&ved=0CDMQyjdqFQoTCO660cvyi8kCFQz3YwodAjUGVg&ei=gw1FVq7tIIzujwOC6piwBQ#imgrc=pQ5LprUsRHMe9M%3A&usg=__Mp8DCZbYcejXOiEt-bWUdA0DA-I%3D
  
1  12
   03
   
2 5 6 9  10
  4 7 8  11
  3 2 13 12
  0 1 14 15

3 
*/

class HilbertCurve {


  public static int[][] generateHC(int n) {
    int width = (int) Math.pow(2, n);
    int[][] res = new int[width][width];
    res[0][0] = 1;
    res[0][1] = 2;
    res[1][0] = 0;
    res[1][1] = 3;
    if(n <= 1) return res;
    
    int w = 2;
    for(int i = 2; i <= n; i++) {
      w *= 2;  //4 
      
      // top left
      copy(res, w, 0, 0, w / 4, w / 4);   // [0, 0] -> [1, 1]
      // top right
      copy(res, 2 * w, 0, w / 2, w / 2 - 1, w - 1);  // [0, 2] -> [1, 3]
    }  
    return res;
  } 
  
  public static void copy(int[][] res, int offset, int x1, int y1, int x2, int y2) {
    System.out.println("index: " + x1 + " " + x2 + " " + y1 + " " + y2);
    for(int x = x1; x <= x2; x++) {
      for(int y = y1; y <= y2; y++) {
        // System.out.println(x + " " + y);
        res[x][y] = res[x][y] + offset;
      }
    }
  }

  public static void main(String[] args) {
    int n = 2;
    int[][] result = generateHC(n);
    for(int[] row : result) {
      for(int elem : row) {
        System.out.print(elem + " ");
      }
      System.out.println();
    }
  
    
  }
}
