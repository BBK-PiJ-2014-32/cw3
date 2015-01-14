
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
		ReturnObject newObj = new ReturnObjectImpl(testList.get(3), null);
		Object obj = newObj.getReturnValue();
		System.out.println(obj);
		Object newNode = new Object();
		newNode = "someString";
		testList.add(2, newNode);
		testList.remove(3);
		ReturnObject newObj2 = new ReturnObjectImpl(testList.get(3), null);
		Object obj2 = newObj2.getReturnValue();
		System.out.println(obj2);
	}
	
}
