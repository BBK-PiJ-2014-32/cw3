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

	}
}
