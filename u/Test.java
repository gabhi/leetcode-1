import java.util.*;

enum Suit {
	Spade(3), Heart(2), Diamond(1), Club(0);
	private int value;
	private Suit(int i) {
		this.value = i;
	}
	public int getValue() {
		return this.value;
	}
}

abstract class Animal {
	protected String name;
	public Animal(String n) {name = n;}
	abstract public String name();
}
class Dog extends Animal {
	public Dog(String n) {super(n);}
	public String name() {
		return "dog: " + name;
	}
}

class Cat extends Animal {
	public Cat(String n) {super(n);}
	public String name() {
		return "cat: " + name;
	}
}

class Test {
	public static void main(String[] args) {
		for(Suit s : Suit.values()) {
			System.out.println(s);
		}
		Animal a = new Dog("dog");
		Animal b = new Cat("cat");
		System.out.println(a.name());
		System.out.println(Suit.Spade instanceof Suit);
	}
}