import static org.junit.Assert.*;

import org.junit.Test;
 
/**
 * The Class ReturnObjectImplTest.
 */
public class ReturnObjectImplTest {
	
	/**
	 * Null object test.
	 */
	@Test
	public void nullObjectTest(){
		ReturnObject testObject = new ReturnObjectImpl(null);
		ErrorMessage output = testObject.getError();
		ErrorMessage expected = ErrorMessage.NO_ERROR;
		assertEquals(expected, output);
	}
	
	/**
	 * Gets the object value test.
	 *
	 * @return the object value test
	 */
	@Test
	public void getObjectValueTest(){
		ReturnObject testObject = new ReturnObjectImpl("Testing!");
		Object output = testObject.getReturnValue();
		Object expected = "Testing!";
		assertEquals(expected, output);
	}
}