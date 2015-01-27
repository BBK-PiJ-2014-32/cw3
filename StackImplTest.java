import static org.junit.Assert.*;

import org.junit.Test;


/**
 * The Class StackImplTest, tests all of the functions of the stack implementation.
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
		ReturnObject returObj = testStack.top();
		Object output = returObj.getReturnValue();
		Object expected = "f";
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
		testStack.push("f");
		testStack.pop();
		testStack.pop();
		testStack.pop();
		ReturnObject returObj = testStack.pop();
		Object output = returObj.getReturnValue();
		Object expected = "c";
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
