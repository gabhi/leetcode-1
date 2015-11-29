class SmallestRectangleEnclosingBlackPixels {

	public int minArea(char[][] image, int x, int y) {
		// return null;
		int m = image.length, n = image[0].length;
		int colMin = binarySearch(image, true, 0, y, 0, m - 1, true);
		int colMax = binarySearch(image, true, y, n - 1, 0, m - 1, false);
		// System.out.println(colMin + " " + colMax);
		int rowMin = binarySearch(image, false, 0, x, colMin, colMax, true);
		int rowMax = binarySearch(image, false, x, m - 1, colMin, colMax, false);
		return (rowMax - rowMin) * (colMax - colMin);
    }

    public int binarySearch(char[][] image, boolean horizontal, int lower, int upper, int min, int max, boolean goLower) {
    	
    	if(lower == upper) return lower;
    	while(lower < upper) {
    		int mid = lower + (upper - lower) / 2;
    		System.out.println("mid" + mid + " lower" + lower + " upper" + upper);
    		boolean inside = false;
	    	for(int i = min; i <= max; i++) {
	    		System.out.println(min + " " + max + " " + i);
	    		if((horizontal ? image[i][mid] : image[mid][i]) == '1') { //
	   				inside = true; 
	   				break;
	   			}
	   		}
	   		// System.out.println(inside + " " + goLower);
    		if(inside && goLower) {
    			upper = mid;
    		} else {
    			lower = mid + 1;
    		}
    		System.out.println(lower + " " + upper);
    	}
    	System.out.println("lower" + lower);
    	return lower;

    }

	public static void main(String[] args) {
		// char[][] image = {{'0', '0', '1', '0'}, {'0', '1', '1', '0'}, {'0', '1', '0', '0'}};
		// int x = 0, y = 2;

		char[][] image = {{'0'}, {'1'}};
		int x = 1, y = 0;
		int min = new SmallestRectangleEnclosingBlackPixels().minArea(image, x, y);
		System.out.println("res" + min);
		
	}
}