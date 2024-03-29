// Given an array of numbers A = [x1, x2, ..., xn] and T = Round(x1+x2+... +xn). -google 1point3acres
// We want to find a way to round each element in A such that after rounding we get a new array B = [y1, y2, ...., yn] such that y1+y2+...+yn = T where  yi = Floor(xi) or Ceil(xi), ceiling or floor of xi.
// We also want to minimize sum |x_i-y_i|. 1point 3acres 
import java.util.*;

public class Temp {
        // 思路就是先把所有floor加起来，然后看差多少，然后把多少个floor转成ceil
        // 转的时候按照num本身与ceil的距离排序
        public static int[] getNearlyArrayWithSameSum(double[] arr) {
                NumWithDiff[] arrWithDiff = new NumWithDiff[arr.length];
                double sum = 0.0;
                int floorSum = 0;
                for (int i = 0; i < arr.length; i++) {
                        int floor = (int)arr[i];
                        int ceil = floor;
                        if (floor < arr[i]) ceil++; // 查是不是4.0这种floor/ceil都是本身的
                        floorSum += floor;
                        sum += arr[i];
                        arrWithDiff[i] = new NumWithDiff(ceil, ceil - arr[i]); // 把ceil都放在数组里面进行比较. more info on 1point3acres.com
                }
                int num = (int) Math.round(sum);
                int diff = num - floorSum;
                Arrays.sort(arrWithDiff, new Comparator<NumWithDiff>() {
                        public int compare(NumWithDiff n1, NumWithDiff n2) {
                                if (n1.diffWithCeil <= n2.diffWithCeil) return -1;
                                else return 1;
                        }
                });
                int[] res = new int[arr.length];
                int i = 0;
                for (; i < diff; i++) {
                        res[i] = arrWithDiff[i].num; // 这些放ceil. from: 1point3acres.com/bbs 
                }
                for (; i < arr.length; i++) {
                        res[i] = arrWithDiff[i].num - 1; // 剩下的只放floor
                }
                return res;
        }
        public static void main(String[] args) {
                double[] arr = { 1.2, 3.7, 2.3, 4.8 };
                int[] res = getNearlyArrayWithSameSum(arr);
                for (int i : res) System.out.print(i + " ");
                
        }
}
class NumWithDiff {
        int num;
        double diffWithCeil;
        public NumWithDiff(int n, double c) {
                this.num = n;
                this.diffWithCeil = c;
        }
}