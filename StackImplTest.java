import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test class for the StackImpl class.
 */
public class StackImplTest {

	/**
	 * Stack impl list push test.
	 */
	@Test
	public void stackImplListPushTest(){
		List testLinkedList = new LinkedList();
		StackImpl testStack = new StackImpl(testLinkedList);
		testStack.push("a");
		testStack.push("b");
		testStack.push("c");
		testStack.push("d");
		testStack.push("e");
		testStack.push("f");
		testStack.pop();
		ReturnObject returObj = testStack.top();
		Object output = returObj.getReturnValue();
		Object expected = "e";
		assertEquals(expected, output);
	}
	
	/**
	 * Stack impl list pop test.
	 */
	@Test
	public void stackImplListPopTest(){
		List testLinkedList = new LinkedList();
		StackImpl testStack = new StackImpl(testLinkedList);
		testStack.push("a");
		testStack.push("b");
		testStack.push("c");
		testStack.push("d");
		testStack.push("e");
		testStack.push(null);
		testStack.pop();
		testStack.pop();
		testStack.pop();
		ReturnObject returObj = testStack.pop();
		Object output = returObj.getReturnValue();
		Object expected = "b";
		assertEquals(expected, output);
	}
	
	/**
	 * Null push test.
	 */
	@Test
	public void nullPushTest(){
		List testLinkedList = new LinkedList();
		StackImpl testStack = new StackImpl(testLinkedList);
		testStack.push(null);
		testStack.push(null);
		ReturnObject returObj = testStack.pop();
		ErrorMessage output = returObj.getError();
		ErrorMessage expected = ErrorMessage.EMPTY_STRUCTURE;
		assertEquals(expected, output);
	}
	
	/**
	 * Stack impl list size test.
	 */
	@Test
	public void stackImplListSizeTest(){
		List testLinkedList = new LinkedList();
		StackImpl testStack = new StackImpl(testLinkedList);
		testStack.push("a");
		testStack.push("b");
		testStack.push("c");
		testStack.push("d");
		testStack.push("e");
		testStack.push("f");
		int output = testStack.size();
		int expected = 6;
		assertEquals(expected, output);
	}
	
	/**
	 * Stack impl list is empty test.
	 */
	@Test
	public void stackImplListIsEmptyTest(){
		List testLinkedList = new LinkedList();
		StackImpl testStack = new StackImpl(testLinkedList);
		testStack.push("a");
		testStack.push("b");
		testStack.push("c");
		testStack.push("d");
		testStack.push("e");
		testStack.push("f");
		boolean output = testStack.isEmpty();
		boolean expected = false;
		assertEquals(expected, output);

	}
}
