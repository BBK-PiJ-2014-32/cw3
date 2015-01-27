import static org.junit.Assert.*;

import org.junit.Test;

public class ReturnObjectImplTest {
	
	@Test
	public void emptyObjectTest(){
		ReturnObject testObject = new ReturnObjectImpl(null);
		ErrorMessage output = testObject.getError();
		ErrorMessage expected = ErrorMessage.NO_ERROR;
		assertEquals(expected, output);
	}
	
	
	/*public static void main(String[] args){
		ReturnObject testObject = new ReturnObjectImpl(null);
		ErrorMessage msg = testObject.getError();
		System.out.println(msg);
		ReturnObject testObject2 = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		ErrorMessage msg2 = testObject2.getError();
		System.out.println(msg2);
	}*/
}