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

}
