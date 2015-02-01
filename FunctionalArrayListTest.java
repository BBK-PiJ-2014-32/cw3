import static org.junit.Assert.*;

import org.junit.Test;


/**
 * The JUnit test Class for the FunctionalArrayList Class.
 */
public class FunctionalArrayListTest {

	/**
	 * Tests the head method.
	 */
	@Test
	public void headTest() {
		FunctionalArrayList myArrayList = new FunctionalArrayList();
		myArrayList.add("A");
		ReturnObject returnObj = myArrayList.head();
		Object output = returnObj.getReturnValue();
		Object expected = "A";
		assertEquals(expected, output);
	}
	
	/**
	 * Tests the rest method.
	 */
	@Test
	public void restTest() {
		FunctionalArrayList myArrayList = new FunctionalArrayList();
		myArrayList.add("a");
		myArrayList.add("b");
		myArrayList.add("c");
		myArrayList.add("d");
		myArrayList.add("e");
		FunctionalArrayList newArrayList = myArrayList.rest();
		int output = newArrayList.size();
		int expected = 4;
		assertEquals(expected, output);
	}

	@Test
	public void restValueTest() {
		FunctionalArrayList myArrayList = new FunctionalArrayList();
		myArrayList.add("a");
		myArrayList.add("b");
		myArrayList.add("c");
		myArrayList.add("d");
		myArrayList.add("e");
		FunctionalArrayList newArrayList = myArrayList.rest();
		ReturnObject returnObj = newArrayList.get(0);
		Object output = returnObj.getReturnValue();
		Object expected = "b";
		assertEquals(expected, output);
	}
	
}
