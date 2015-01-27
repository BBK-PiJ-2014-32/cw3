import static org.junit.Assert.*;

import org.junit.Test;


/**
 * JUnit test Class for the ImprovedStackImpl Class.
 */
public class ImprovedStackImplTest {

	/**
	 * ImprovedStackImpl reverse test.
	 */
	@Test
	public void ImprovedStackImplReverseTest(){
		List testLinkedList = new LinkedList();
		ImprovedStackImpl testStack = new ImprovedStackImpl(testLinkedList);
		testStack.push("a");
		testStack.push("b");
		testStack.push("c");
		testStack.push("d");
		testStack.push("e");
		testStack.push("f");
		testStack.reverse();
		ReturnObject returnObj = testStack.top();
		Object output = returnObj.getReturnValue();
		Object expected = "a";
		assertEquals(expected, output);
	}
	
	/**
	 * ImprovedStackImpl remove test.
	 */
	@Test
	public void ImprovedStackImplRemoveTest(){
		List testLinkedList = new LinkedList();
		ImprovedStackImpl testStack = new ImprovedStackImpl(testLinkedList);
		testStack.push("a");
		testStack.push("b");
		testStack.push("a");
		testStack.push("d");
		testStack.push("e");
		testStack.push("a");
		testStack.remove("a");
		int output = testStack.size();
		int expected = 3;
		assertEquals(expected, output);
	}
	
	
	/**
	 * ImprovedStackImpl list push test.
	 */
	@Test
	public void ImprovedStackImplListPushTest(){
		List testLinkedList = new LinkedList();
		ImprovedStackImpl testStack = new ImprovedStackImpl(testLinkedList);
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
	 * ImprovedStackImpl list pop test.
	 */
	@Test
	public void ImprovedStackImplListPopTest(){
		List testLinkedList = new LinkedList();
		ImprovedStackImpl testStack = new ImprovedStackImpl(testLinkedList);
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
	 * ImprovedStackImpl list size test.
	 */
	@Test
	public void ImprovedStackImplListSizeTest(){
		List testLinkedList = new LinkedList();
		ImprovedStackImpl testStack = new ImprovedStackImpl(testLinkedList);
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
	 * ImprovedStackImpl list is empty test.
	 */
	@Test
	public void ImprovedStackImplListIsEmptyTest(){
		List testLinkedList = new LinkedList();
		ImprovedStackImpl testStack = new ImprovedStackImpl(testLinkedList);
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
