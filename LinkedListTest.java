
public class LinkedListTest {
	
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
	}

}
