import static org.junit.Assert.*;

import org.junit.Test;


// TODO: Auto-generated Javadoc
/**
 * The Class ListTest.
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
	 * Array list multpile add and get single test.
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
		myArrayList.remove(2);
		ReturnObject returObj = myArrayList.get(2);
		Object output = returObj.getReturnValue();
		Object expected = "d";
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
	public void LinkedListRemoveTest(){
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
}
