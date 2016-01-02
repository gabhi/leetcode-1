import java.util.*;

class MaxPoints {

    public int maxPoints(Point[] points) {
        if(points.length <= 1) return points.length;
        int max = 0;
        for(int i = 0; i < points.length ;i++) {
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int sameX = 1, sameP = 0;
            for(int j = i + 1; j < points.length; j++) {
                // if(i == j) continue;
                Point p1 = points[i], p2 = points[j];
                if(p1.x == p2.x) {
                    sameX++;
                    if(p1.y == p2.y) sameP++;
                } else {
                    double k =  (p2.y == p1.y) ? 0.0 :((double) (p2.y - p1.y) / (p2.x - p1.x));
                    int count = map.containsKey(k) ? (map.get(k) + 1) : 2;
                    map.put(k, count);
                }
            }

            int localMax = 0;
            for(Map.Entry<Double, Integer> entry : map.entrySet()) {
                int count = entry.getValue();
                if(count > localMax) localMax = count;
            }
             
            localMax += sameP;
            if(sameX > localMax) localMax = sameX; 
            if(localMax > max) max = localMax;
        }
        return max;
    }
    
    public static void main(String[] args) {
        // Point p1 = new Point(0, 0);
        // Point p2 = new Point(0, 0);
        // Point[] points = {p1, p2};

        Point p1 = new Point(2, 3);
        Point p2 = new Point(3, 3);
        Point p3 = new Point(-5, 3);
        Point[] points = {p1, p2, p3};
        int res = new MaxPoints().maxPoints(points);
        System.out.println("[info] " + res);
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}