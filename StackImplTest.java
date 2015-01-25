import static org.junit.Assert.*;

import org.junit.Test;


public class StackImplTest {

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
