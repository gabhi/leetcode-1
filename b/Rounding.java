/*
// Rounding

// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=146539&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D37%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

// Given an array of numbers A = [x1, x2, ..., xn] and T = Round(x1+x2+... +xn). -google 1point3acres
// We want to find a way to round each element in A such that after rounding we get a new array B = [y1, y2, ...., yn] such that y1+y2+...+yn = T where  yi = Floor(xi) or Ceil(xi), ceiling or floor of xi.
// We also want to minimize sum |x_i-y_i|. 1point 3acres 
*/

import java.util.*;

class Rounding {

	public int[] round(Double[] input) {
		if(input == null || input.length == 0) return new int[0];

		Queue<Double> minCeil = new PriorityQueue<Double>(input.length, new Comparator<Double>() {
			public int compare(Double x, Double y) {
				return Double.compare(Math.ceil(x) - x, Math.ceil(y) - y);
			}
		});
		// Get offset
		Double sum = 0.0;
		int floorSum = 0;
		int[] res = new int[input.length];
		for(int i = 0; i < input.length; i++) {
			sum += input[i];
			int floor = (int) Math.floor(input[i]);
			floorSum += floor;
			res[i] = floor;
			minCeil.add(input[i]);
		}
		// Numbers contributing to larger
		int offset = (int) Math.round(sum) - floorSum;
		Set<Double> mins = new HashSet<>();
		for(int i = 0; i < offset; i++) {
			mins.add(minCeil.poll());
		}

		for(int i = 0; i < res.length && offset > 0; i++) {
			if(mins.contains(input[i])) {
				res[i]++;
				offset--;
			}
		}
		return res;
	}


    public static void main(String[] args) {
    	Rounding s = new Rounding();
    	Double[] input = {1.6, 1.4 , 1.5, 1.6};
    	int[] res = s.round(input);               
  		for (int val : res) {
    		System.out.print(val + " ");
    	}
    }
}

