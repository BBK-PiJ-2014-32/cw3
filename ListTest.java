import static org.junit.Assert.*;

import org.junit.Test;


public class ListTest {

	@Test
	public void arrayListAddTest() {
		List myArrayList = new ArrayList();
		myArrayList.add("a");
		Object output = myArrayList.get(0);
		Object expected = "a";
		assertEquals(expected, output);
	}

}
