/**
 * An implementation of a stack with additional methods. 
 * 
 * Classes implementing this interface must use a {@see List} as the
 * underlying data structure to store the elements on the stack. 
 * 
 * Not all operations on a stack will always be successful. For
 * example, a programmer may try to pop an element from an empty
 * stack. Since we hace not covered exceptions yet, we need another
 * mechanism to report errors. In order to do that, methods of this
 * list will return a {@see ReturnObject} that will contain either an
 * object or an error value of the right kind (as defined in {@see
 * ErrorMessage}).
 * 
 * @author PiJ
 */
public class ImprovedStackImpl implements ImprovedStack {
	
	private List internalList;
	private int stackSize;
	
	public ImprovedStackImpl(List list){
		this.internalList = list;
		stackSize = 0;
	}
	
	/**
	 * Returns a copy of this stack with the items reversed, the top
	 * elements on the original stack is at the bottom of the new
	 * stack and viceversa.
	 * 
	 * @return a copy of this stack with the items reversed. 
	 */
	public ImprovedStackImpl reverse(){
		ImprovedStackImpl reverseStack = new ImprovedStackImpl(null);
		for(int i = (stackSize - 1); i >= 0; i--){
			ReturnObject returnObj = internalList.get(i);
			Object inputObj = returnObj.getReturnValue();
			reverseStack.push(inputObj);
		}
		return reverseStack;
	}

	/**
	 * Removes the given object from the stack if it is
	 * there. Multiple instances of the object are all removed.
	 *
	 * Classes implementing this method must use method .equals() to
	 * check whether the item is in the stack or not.
	 * 
	 * @param object the object to remove
	 */
	public void remove(Object object){
		
	}

	@Override
	public boolean isEmpty() {
		if(internalList.size() == 0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return stackSize;
	}

	@Override
	public void push(Object item) {
		internalList.add(item);
		stackSize++;
	}

	@Override
	public ReturnObject top() {
		return internalList.get(internalList.size() - 1);
	}

	@Override
	public ReturnObject pop() {
		ReturnObject returnObj = internalList.remove(internalList.size() - 1);
		stackSize--;
		return returnObj;
		
	}
}


