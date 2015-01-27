import static org.junit.Assert.*;

import org.junit.Test;

public class ReturnObjectImplTest {
	
	@Test
	public void nullObjectTest(){
		ReturnObject testObject = new ReturnObjectImpl(null);
		ErrorMessage output = testObject.getError();
		ErrorMessage expected = ErrorMessage.NO_ERROR;
		assertEquals(expected, output);
	}
	
	@Test
	public void getObjectValueTest(){
		ReturnObject testObject = new ReturnObjectImpl("Testing!");
		Object output = testObject.getReturnValue();
		Object expected = "Testing!";
		assertEquals(expected, output);
	}
}