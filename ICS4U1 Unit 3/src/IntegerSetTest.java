
public class IntegerSetTest {

	public static void main(String[] args) {
		int [] arr1 = {13, 214, 35, 25, 32, 12};
		int [] arr2 = {13, 214, 35, 25, 32, 12};
		
		IntegerSet set1 = new IntegerSet(arr1);
		IntegerSet set2 = new IntegerSet(arr2);
		
		System.out.println(set1.toSetString());
		System.out.println(set2.toSetString());	
		
		System.out.println(set1.union(set2).toSetString());
		System.out.println(set1.intersection(set2).toSetString());
		
		System.out.println(set1.isEqualTo(set2));

	}

}
