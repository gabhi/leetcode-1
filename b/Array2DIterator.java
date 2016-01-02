import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// boolean hasNext() -> returns whether there is next element in the Array2DIterator
// int next() => returns the next element in the iterator
// void remove () -> delete the last element returned by next()
// input: [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[],[]]
//               /\
// input: [[],[1,3],[4,5],[],[],[6],[7,8],[],[9],[10],[],[]]

// array[i][j] = 0; 
// hasNext() => true
// next() => 1
// hasNext() => true
// hasNext() => true
// next() => 2
// next() => 3
// next() => 4
// ...
// next() => 10
// hasNext() => false
// next() => throw excepiton

// List<List<Integer>> iter2D
// List<Integer> iter
// List<Iterator> iters Queue<Interator> q
// while(!isEmpty(q)) {
//   Iterator it = q.peek();
     // if(!it.hasNext()) return fa
     // if(it.hasNext()) it.remove();
     // else iter.
// }

// iterator

  // You still tehere?
// call dropped. calling back
// Can you call again? Network bad?

import java.util.*;

class Array2DIterator {
  List<List<Integer>> input;
  int current = 0;
  int row = 0;
  int col = 0;
  
  public Array2DIterator(List<List<Integer>> input) {  
    this.input = input;
  }
  
  public int next() {
    return current;
  }
  
  public boolean hasNext() {
    // Skip empty rows
    while(row < input.size() && col >= input.get(row).size()) {
      row++;
      col = 0;
    } 
    if(row < input.size()) {
      current = input.get(row).get(col);
      col++; 
      return true;
    }  else {
      return false;
    }
  }
  
  public void remove() {
    while(row < input.size() && col >= input.get(row).size()) row++;
    if(row < input.size() && col < input.get(row).size()) {
      input.get(row).remove(col);
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> input = new ArrayList<List<Integer>>();
    // input.add(new ArrayList<Integer>());
    input.add(new ArrayList<Integer>());
    input.add(new ArrayList<Integer>());
    List<Integer> row2=  new ArrayList<Integer>();
    row2.add(1); row2.add(2); row2.add(3);
    input.add(row2);


    Array2DIterator sol = new Array2DIterator(input);
    sol.remove();
    while(sol.hasNext()) {
       System.out.print(sol.next() + " ");
    }
    
    
  }
 
}
