import static org.junit.Assert.*;

import org.junit.Test;


public class FunctionalArrayListTest {

	@Test
	public void headTest() {
		FunctionalArrayList myArrayList = new FunctionalArrayList();
		myArrayList.add("A");
		ReturnObject output = myArrayList.head();
		ReturnObject expected = new ReturnObjectImpl("A", null);
		assertEquals(expected, output);
		
	}

}
