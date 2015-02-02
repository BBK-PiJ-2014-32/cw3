
/**
 * The Class LinkedListTest used initially before JUnit testing was used.
 */
public class LinkedListTest {
	//main primary test code
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		List testList = new LinkedList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(null);
		ReturnObject newErr = new ReturnObjectImpl(testList.add(null));
		ErrorMessage errorOut = newErr.getError();
		System.out.println(errorOut);
		int x = testList.size();
		System.out.println("size = " + x);
		ReturnObject newObj = new ReturnObjectImpl(testList.get(3));
		Object obj = newObj.getReturnValue();
		System.out.println(obj);
		Object newNode = new Object();
		newNode = "someString";
		System.out.println("add at 2");
		testList.add(2, newNode);
		System.out.println("remove 3");
		testList.remove(3);

	}
	
}
