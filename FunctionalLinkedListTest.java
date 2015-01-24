import static org.junit.Assert.*;

import org.junit.Test;


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

}
