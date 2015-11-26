// Anonymous INNER classes can implement interfaces 
// That's the only time a class can implement an interface without "implement" keyword

// An anonymous inner class is a subclass
// by creating an anonymous inner class, we can override one or more methods of a superclass
// Useful when you only need to override a small amount of functionality (like just one method) in a superclass

// http://www.programmerinterview.com/index.php/java-questions/anonymous-class-interface

import java.util.*;

interface Operator {
	int eval(int x, int y);
}

public class Eval {
	public static final Map<Character, Operator> OPERATORS = new HashMap<Character, Operator>() {{
		put('+', new Operator() {public int eval(int x, int y){return x + y;}});
		put('-', new Operator() {public int eval(int x, int y){return x - y;}});
		put('*', new Operator() {public int eval(int x, int y){return x * y;}});
		put('/', new Operator() {public int eval(int x, int y){return x / y;}});
	}};
	public static void test() {
		char token = '*';
		int res = OPERATORS.get(token).eval(2, 3);
		System.out.println(res);
	}

	public static void main(String[] args) {test();}
}


