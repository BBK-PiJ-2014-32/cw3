import static org.junit.Assert.*;

import org.junit.Test;


/**
 * JUnit test Class for both the LinkedList and ArrayList classes.
 */
public class ListTest {

	/**
	 * Array list add test.
	 */
	@Test
	public void arrayListAddTest() {
		List myArrayList = new ArrayList();
		myArrayList.add("a");
		ReturnObject returObj = myArrayList.get(0);
		Object output = returObj.getReturnValue();
		Object expected = "a";
		assertEquals(expected, output);
	}

	/**
	 * Array list multiple add and get single test.
	 */
	@Test
	public void arrayListMultpileAddGetTest(){
		List myArrayList = new ArrayList();
		myArrayList.add("a");
		myArrayList.add("b");
		myArrayList.add("c");
		myArrayList.add("d");
		myArrayList.add("e");
		myArrayList.add("f");
		ReturnObject returObj = myArrayList.get(3);
		Object output = returObj.getReturnValue();
		Object expected = "d";
		assertEquals(expected, output);
	}
	
	/**
	 * Array list remove test.
	 */
	@Test
	public void arrayListRemoveTest(){
		List myArrayList = new ArrayList();
		myArrayList.add("a");
		myArrayList.add("b");
		myArrayList.add("c");
		myArrayList.add("d");
		myArrayList.add("e");
		myArrayList.add("f");
		ReturnObject returObj = myArrayList.remove(2);
		Object output = returObj.getReturnValue();
		Object expected = "c";
		assertEquals(expected, output);
	}
	
	/**
	 * Checks the last entry is null after it is rearranged after an element is removed.
	 */
	@Test
	public void arrayListCheckLast(){
		List myArrayList = new ArrayList();
		myArrayList.add("a");
		myArrayList.add("b");
		myArrayList.add("c");
		myArrayList.add("d");
		myArrayList.add("e");
		myArrayList.add("f");
		myArrayList.remove(2);
		ReturnObject returObj = myArrayList.get(5);
		Object output = returObj.getReturnValue();
		Object expected = null;
		assertEquals(expected, output);
	}
	
	/**
	 * Array list empty test.
	 */
	@Test
	public void arrayListEmptyTest(){
		List myArrayList = new ArrayList();
		boolean output = myArrayList.isEmpty();
		boolean expected = true;
		assertEquals(expected, output);
	}
	
	/**
	 * Array list size test.
	 */
	@Test
	public void arrayListSizeTest(){
		List myArrayList = new ArrayList();
		myArrayList.add("a");
		myArrayList.add("b");
		myArrayList.add("c");
		myArrayList.add("d");
		myArrayList.add("e");
		myArrayList.add("f");
		int output = myArrayList.size();
		int expected = 6;
		assertEquals(expected, output);
	}
	
	/*@Test No longer needed, visibility of method no changed to private
	public void arrayListIsFullTest(){
		ArrayList myArrayList = new ArrayList();
		myArrayList.add("a");
		myArrayList.add("b");
		myArrayList.add("c");
		myArrayList.add("d");
		myArrayList.add("e");
		myArrayList.add("f");
		myArrayList.add("g");
		myArrayList.add("h");
		myArrayList.add("i");
		myArrayList.add("j");
		boolean output = myArrayList.isArrayFull();
		boolean expected = true;
		assertEquals(expected, output);
	}*/
	
	@Test
	public void arrayLisSizeIncreaseTest(){
		List myArrayList = new ArrayList();
		myArrayList.add("a");
		myArrayList.add("b");
		myArrayList.add("c");
		myArrayList.add("d");
		myArrayList.add("e");
		myArrayList.add("f");
		myArrayList.add("g");
		myArrayList.add("h");
		myArrayList.add("i");
		myArrayList.add("j");
		myArrayList.add("k");
		myArrayList.add("l");
		myArrayList.add("m");
		int output = myArrayList.size();
		int expected = 13;
		assertEquals(expected, output);
	}
	
	@Test
	public void arrayLisSizeIncreaseRemoveGetTest(){
		List myArrayList = new ArrayList();
		myArrayList.add("a");
		myArrayList.add("b");
		myArrayList.add("c");
		myArrayList.add("d");
		myArrayList.add("e");
		myArrayList.add("f");
		myArrayList.add("g");
		myArrayList.add("h");
		myArrayList.add("i");
		myArrayList.add("j");
		myArrayList.add("k");
		myArrayList.add("l");
		myArrayList.add("m");
		myArrayList.remove(4);
		myArrayList.add(5, "new");
		myArrayList.remove(11);
		ReturnObject returObj = myArrayList.get(5);
		Object output = returObj.getReturnValue();
		Object expected = "new";
		assertEquals(expected, output);
	}
	
	@Test
	public void arrayListNullErrorTest() {
		List myArrayList = new ArrayList();
		ReturnObject returObj = myArrayList.add(null);
		Object output = returObj.getError();
		Object expected = ErrorMessage.INVALID_ARGUMENT;
		assertEquals(expected, output);
	}
	
	
	@Test
	public void arrayListOutofBoundsTest() {
		List myArrayList = new ArrayList();
		myArrayList.add("a");
		myArrayList.add("b");
		myArrayList.add("c");
		myArrayList.add("d");
		myArrayList.add("e");
		myArrayList.add("f");
		myArrayList.add("g");
		ReturnObject returObj = myArrayList.get(9);
		Object output = returObj.getError();
		Object expected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		assertEquals(expected, output);
	}
	
	
	/**
	 * Linked list test.
	 */
	@Test
	public void linkedListTest(){
		List myLinkedList = new LinkedList();
		myLinkedList.add("a");
		ReturnObject returObj = myLinkedList.get(0);
		Object output = returObj.getReturnValue();
		Object expected = "a";
		assertEquals(expected, output);
	}
	
	/**
	 * Multiply linked list test.
	 */
	@Test
	public void multiplyLinkedListTest(){
		List myLinkedList = new LinkedList();
		myLinkedList.add("a");
		myLinkedList.add("b");
		myLinkedList.add("c");
		myLinkedList.add("d");
		myLinkedList.add("e");
		myLinkedList.add("f");
		ReturnObject returObj = myLinkedList.get(4); //check indexcount in list
		Object output = returObj.getReturnValue();
		Object expected = "e";
		assertEquals(expected, output);
	}
	
	/**
	 * Mid linked list add test.
	 */
	@Test
	public void midLinkedListAddTest(){
		List myLinkedList = new LinkedList();
		myLinkedList.add("a");
		myLinkedList.add("b");
		myLinkedList.add("c");
		myLinkedList.add("d");
		myLinkedList.add("e");
		myLinkedList.add(2,"f");
		ReturnObject returObj = myLinkedList.get(3); //check indexcount in list
		Object output = returObj.getReturnValue();
		Object expected = "c";
		assertEquals(expected, output);
	}
	
	
	/**
	 * Linked list remove test.
	 */
	@Test
	public void linkedListRemoveTest(){
		List myLinkedList = new LinkedList();
		myLinkedList.add("a");
		myLinkedList.add("b");
		myLinkedList.add("c");
		myLinkedList.add("d");
		myLinkedList.add("e");
		myLinkedList.add("f");
		myLinkedList.remove(2);
		ReturnObject returObj = myLinkedList.get(2);
		Object output = returObj.getReturnValue();
		Object expected = "d";
		assertEquals(expected, output);
	}
	
	/**
	 * Linked list empty test.
	 */
	@Test
	public void linkedListEmptyTest(){
		List myLinkedList = new LinkedList();
		boolean output = myLinkedList.isEmpty();
		boolean expected = true;
		assertEquals(expected, output);
	}
	
	/**
	 * Linked list size test.
	 */
	@Test
	public void linkedListSizeTest(){
		List myLinkedList = new LinkedList();
		myLinkedList.add("a");
		myLinkedList.add("b");
		myLinkedList.add("c");
		myLinkedList.add("d");
		myLinkedList.add("e");
		myLinkedList.add("f");
		int output = myLinkedList.size();
		int expected = 6;
		assertEquals(expected, output);
	}
	
	@Test
	public void linkedListEmptyErrorTest(){
		List myLinkedList = new LinkedList();
		ReturnObject returObj = myLinkedList.get(0);
		ErrorMessage output = returObj.getError();
		ErrorMessage expected = ErrorMessage.EMPTY_STRUCTURE;
		assertEquals(expected, output);
	}
	
	@Test
	public void linkedListOutofBoundsErrorTest(){
		List myLinkedList = new LinkedList();
		myLinkedList.add("a");
		ReturnObject returObj = myLinkedList.get(5);
		ErrorMessage output = returObj.getError();
		ErrorMessage expected = ErrorMessage.INDEX_OUT_OF_BOUNDS;
		assertEquals(expected, output);
	}
	
	@Test
	public void dualListTest(){
		List myLinkedList = new LinkedList();
		myLinkedList.add("a");
		myLinkedList.add("b");
		myLinkedList.add("c");
		myLinkedList.add("d");
		myLinkedList.add("e");
		myLinkedList.add("f");
		myLinkedList.remove(3);
		List myArrayList = new ArrayList();
		myArrayList.add("a");
		myArrayList.add("b");
		myArrayList.add("c");
		myArrayList.add("d");
		myArrayList.add("e");
		myLinkedList.add(myArrayList);
		ReturnObject returObj = myLinkedList.get(5);
		Object output = returObj.getReturnValue();
		Object expected = myArrayList;
		assertEquals(expected, output);
	}
	
	@Test
	public void fullLinkedListDeleteTest(){
		List myLinkedList = new LinkedList();
		myLinkedList.add("a");
		myLinkedList.add("b");
		myLinkedList.add("c");
		myLinkedList.add("d");
		myLinkedList.add("e");
		myLinkedList.add("f");
		myLinkedList.remove(0);
		myLinkedList.remove(0);
		myLinkedList.remove(0);
		//myLinkedList.remove(0);
	//	myLinkedList.remove(0);
		ReturnObject returObj = myLinkedList.get(2);
		//ErrorMessage output = returObj.getError();
		//ErrorMessage expected = ErrorMessage.EMPTY_STRUCTURE;
		//int output = myLinkedList.size();
		//int expected = 6;
		//boolean output = myLinkedList.isEmpty();
		//boolean expected = true;
		Object output = returObj.getReturnValue();
		Object expected = "f";
		assertEquals(expected, output);
	}
}
