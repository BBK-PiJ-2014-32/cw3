import static org.junit.Assert.*;

import org.junit.Test;


public class FunctionalArrayListTest {

	/**
	 * Head test.
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
	 * Rest test.
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
		int expected = 5;
		assertEquals(expected, output);
	}

}
