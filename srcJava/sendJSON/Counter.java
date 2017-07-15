package pse.sendJSON;

public class Counter {

	private static final int NUM_COUNT = 1;

	private int countMax;
	private int count;
	
	public Counter(){
		count = 0;
		countMax = NUM_COUNT;
	}

	public Counter(int countMax){
		count = 0;
		this.countMax = countMax;
	}
	
	public void incCount(){
		count++;
	}

	public void resetCount() {
		count = 0;
	}
	
	public boolean getSend(){
		return count >= countMax;
	}
}
