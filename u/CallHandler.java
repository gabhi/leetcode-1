import java.util.*;

public class CallHandler {
	private static CallHandler instance;
	
	private static final int NUM_LEVELS = 3;
	private static final int NUM_RESPS = 10;
	private static final int NUM_MANAGERS = 4;
	private static final int NUM_DIRECTORS = 2;

	List<Queue<Employee>> availableEmps = new ArrayList<Queue<Employee>>();
	List<Queue<Call>> waitingCalls = new ArrayList<Queue<Call>>();

	public static CallHandler getInstance() {
		if(instance == null) instance = new CallHandler();
		return instance;
	}

	// this cannot be public 
	protected CallHandler() {
		Queue<Employee> resps = new LinkedList<Employee>();
		for(int i = 0; i < NUM_RESPS; i++) {
			resps.add(new Respondent());
		}
		availableEmps.add(resps);

		Queue<Employee> managers = new LinkedList<Employee>();
		for(int i = 0; i < NUM_MANAGERS; i++) {
			managers.add(new Manager());
		}
		availableEmps.add(managers);

		// must use Child type instead
		Queue<Employee> directors = new LinkedList<Employee>();
		for(int i = 0; i < NUM_DIRECTORS; i++) {
			directors.add(new Respondent());
		}
		availableEmps.add(directors);
	}

	public void dispatchCall(Caller caller) {
		Call call = new Call(caller);
		dispatchCall(call);
	}

	public void dispatchCall(Call call) {
		Employee e = nextAvailable(call);
		if(e != null) {
			e.receiveCall(call);
			call.setEmployee(e);
		// Place into call queue
		} else {
			int id = call.getRank().getValue();
			waitingCalls.get(id).add(call);
		}
	}

	// Get next smallest rank emp
	public Employee nextAvailable(Call call) {
		for(int i = call.getRank().getValue(); i < NUM_LEVELS; i--) {
			if(availableEmps.get(i) != null && !availableEmps.get(i).isEmpty()) {
				return availableEmps.get(i).poll();
			} 
		}
		return null;
	}

	// An empolyee is free. Look for a waiting call.
	// Start from the highest rank this employee can serve.
	public boolean assignCall(Employee employee) {
		for(int i = employee.getRank().getValue(); i >= 0; i--) {
			Queue<Call> q = waitingCalls.get(i);
			if(!q.isEmpty()) {
				employee.receiveCall(q.poll());
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		CallHandler callCenter = new CallHandler();
		callCenter.dispatchCall(new Caller("Alan"));
	}
}

enum Rank {
	RESPONDENT(0), MANAGER(1), DIRECTOR(2);
	int rank;
	private Rank(int rank) {
		this.rank = rank;
	}
	public int getValue() {
		return this.rank;
	}
}

// Just a wrapper
class Call {
	Rank minRank;
	Caller caller;
	Employee employee;
	public Call(Caller caller) {
		this.caller = caller;
		minRank = Rank.RESPONDENT;
	}
	public Rank getRank() {
		return minRank;
	}
	public void setEmployee(Employee e) {
		this.employee = e;
	}
	public Rank incrementRank() {
		if(minRank == Rank.RESPONDENT) {
			minRank = Rank.MANAGER;
		} else if(minRank == Rank.MANAGER) {
			minRank = Rank.DIRECTOR;
		}
		return minRank;
	}
}

class Caller {
	String name;
	public Caller(String n) {
		this.name = n;
	}
}

class Employee {
	Rank rank;
	Call currentCall;
	public Employee() {}
	public void receiveCall(Call call) {
		this.currentCall = currentCall;
	}
	
	// Important usage of singleton pattern!
	public Rank getRank() {
		return rank;
	}
	public void finishCall() {
		if(currentCall != null) {
			currentCall = null;
			CallHandler.getInstance().assignCall(this);
		}
	}
	public void escalateCall() {
		if(currentCall != null) {
			currentCall.incrementRank();
			currentCall = null;
			CallHandler.getInstance().assignCall(this);	
		}
	}
}

class Respondent extends Employee {
	public Respondent() {
		rank = Rank.RESPONDENT;
	}
}
class Manager extends Employee {
	public Manager() {
		rank = Rank.MANAGER;
	}
}

class Director extends Employee {
	public Director() {
		rank = Rank.DIRECTOR;
	}
}