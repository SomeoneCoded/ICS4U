import java.util.Arrays;

public class IntegerSet {
	private boolean[] set;

	public IntegerSet(int[] arr) {
		super();
		set = new boolean[101];
		for(int i : arr) {
			if(i < 0 || i > 100) continue;
			else set[i] = true;
		}
	}

	public IntegerSet() {
		set = new boolean[101];
	}

	public boolean[] getSet() {
		return set;
	}

	public void setSet(boolean[] set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "IntegerSet [set=" + Arrays.toString(set) + "]";
	}

	public IntegerSet union(IntegerSet set2) {
		IntegerSet set3 = new IntegerSet();
		for (int i = 0; i < this.set.length; i++) {
			if (this.getSet()[i] == true || set2.getSet()[i] == true) {
				set3.getSet()[i] = true;
			}
		}

		return set3;
	}

	public IntegerSet intersection(IntegerSet set2) {
		IntegerSet set3 = new IntegerSet();
		for (int i = 0; i < this.set.length; i++) {
			if (this.getSet()[i] == true && set2.getSet()[i] == true) {
				set3.getSet()[i] = true;
			}
		}

		return set3;

	}
	
	public void insertElement(int element) {
		set[element] = true;
		
	}
	
	public void deleteElement(int element) {
		set[element] = false;
		
	}
	
	public String toSetString() {
		String setResult = "";
		for(int i = 0; i < set.length; i++) {
			if(set[i] == true) setResult += i + " ";
		}
		
		return "{" + setResult + "}";
	}
	
	public boolean isEqualTo(IntegerSet set2) {
		for(int i = 0 ; i < this.set.length; i++) {
			if(this.set[i] != set2.set[i]) return false;
		}
		
		return true;
	}
}
