import static org.junit.Assert.*;

import org.junit.Test;


/**
 * JUnit test Class for the FunctionalLinkedList Class.
 */
public class FunctionalLinkedListTest {

	/**
	 * Tests the head method.
	 */
	@Test
	public void headTest() {
		FunctionalLinkedList testLinkedList = new FunctionalLinkedList();
		testLinkedList.add("A");
		ReturnObject returnObj = testLinkedList.head();
		Object output = returnObj.getReturnValue();
		Object expected = "A";
		assertEquals(expected, output);
	}

	/**
	 * Tests the rest method.
	 */
	@Test
	public void restTest() {
		FunctionalLinkedList testLinkedList = new FunctionalLinkedList();
		testLinkedList.add("a");
		testLinkedList.add("b");
		testLinkedList.add("c");
		testLinkedList.add("d");
		testLinkedList.add("e");
		FunctionalLinkedList newLinkedList = testLinkedList.rest();
		int output = newLinkedList.size();
		int expected = 4;
		assertEquals(expected, output);
	}

	@Test
	public void fullTest() {
		FunctionalLinkedList myLinkedList = new FunctionalLinkedList();
		myLinkedList.add("a");
		myLinkedList.add("b");
		myLinkedList.add("c");
		myLinkedList.remove(2);
		myLinkedList.add("d");
		myLinkedList.add("e");
		myLinkedList.remove(2);
		myLinkedList.add("f");
		myLinkedList.add(123);
		myLinkedList.add(12);
		myLinkedList.add("something");
		myLinkedList.add(2);
		myLinkedList.remove(2);
		myLinkedList.add(187.12);
		myLinkedList.add("A");
		myLinkedList.add("B");
		myLinkedList.add("C");
		myLinkedList.add("D");
		myLinkedList.add("E");
		myLinkedList.remove(2);
		FunctionalLinkedList newLinkedList = myLinkedList.rest();
		System.out.println(myLinkedList.get(0).getReturnValue());
		System.out.println(newLinkedList.get(0).getReturnValue());
		
	}
}
