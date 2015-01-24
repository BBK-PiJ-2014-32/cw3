import static org.junit.Assert.*;

import org.junit.Test;


public class FunctionalArrayListTest {

	@Test
	public void headTest() {
		FunctionalArrayList myArrayList = new FunctionalArrayList();
		myArrayList.add("A");
		ReturnObject returnObj = myArrayList.head();
		Object output = returnObj.getReturnValue();
		Object expected = "A";
		assertEquals(expected, output);
		
	}

}
