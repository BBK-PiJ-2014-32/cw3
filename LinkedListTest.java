
public class LinkedListTest {
	//main primary test code
	public static void main(String[] args){
		List testList = new LinkedList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(null);
		ReturnObject newErr = new ReturnObjectImpl(testList.add(null), ErrorMessage.INDEX_OUT_OF_BOUNDS);
		ErrorMessage errorOut = newErr.getError();
		System.out.println(errorOut);
		int x = testList.size();
		System.out.println("size = " + x);
		ReturnObject newObj = new ReturnObjectImpl(testList.get(2), null);
		Object obj = newObj.getReturnValue();
		System.out.println(obj);
		Object newNode = new Object();
		newNode = "someString";
		testList.add(2, newNode);
		newObj = testList.get(3);
		newNode = newObj.getReturnValue();
		System.out.println(testList.get(1));
	}

}
