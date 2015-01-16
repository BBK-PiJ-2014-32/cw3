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
	
}
