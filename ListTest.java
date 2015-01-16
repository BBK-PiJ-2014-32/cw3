import static org.junit.Assert.*;

import org.junit.Test;


public class ListTest {

	@Test
	public void arrayListAddTest() {
		List myArrayList = new ArrayList();
		myArrayList.add("a");
		ReturnObject returObj = myArrayList.get(0);
		Object output = returObj.getReturnValue();
		Object expected = "a";
		assertEquals(expected, output);
	}

	@Test
	public void arrayListMultpilAddGetTest(){
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
	
}
