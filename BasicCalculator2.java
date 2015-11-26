// "3+2*2" = 7
// " 3/2 " = 1
// " 3+5 / 2 " = 5

// 1 * 2 * 3 - 4 * 5 * 6 + 7 - 8
// + (1 * 2 * 3) - (4 * 5 * 6) + (7) - (8)
// 遇到＋ －，result += current; current = 0;
// 遇到数字, lastOps eval 本数字
// 注意跳过空格

class BasicCalculator2 {

  public int calculate(String s) {
		if(s == null || s.length() == 0) return 0;
		int result = 0, current = 0;
		char lastOps = '+';
		s += '+';

		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				int num = s.charAt(i) - '0';
				while(++i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				    num = num * 10 + s.charAt(i) - '0';
				}
				while(s.charAt(i) == ' ') i++;
				switch(lastOps) {
				    case '+': current += num; break;
				    case '-': current -= num; break;
				    case '*': current *= num; break;
				    case '/': current /= num; break;
				}
				lastOps = s.charAt(i);
			}
			if(s.charAt(i) == '+' || s.charAt(i) == '-') {
				result += current;
				current = 0;
				lastOps = s.charAt(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int res = new BasicCalculator2().calculate(" 3+5 / 2 ");
		System.out.println("Result: " + res);
	}	
}