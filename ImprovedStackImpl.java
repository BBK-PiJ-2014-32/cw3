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
	private List returnList;
	private int stackSize;
	private int itemsRemoved;
	
	public ImprovedStackImpl(List list){
		this.internalList = list;
		stackSize = 0;
		itemsRemoved = 0;
	}
	
	/**
	 * Returns a copy of this stack with the items reversed, the top
	 * elements on the original stack is at the bottom of the new
	 * stack and viceversa.
	 * 
	 * @return a copy of this stack with the items reversed. 
	 */
	public ImprovedStackImpl reverse(){
		if(internalList.isEmpty() == false){	
			returnList = internalList;
			for(int i = (stackSize - 1); i >= 0; i--){
				returnList.add(internalList.get(i).getReturnValue());
			}
			ImprovedStackImpl reverseStack = new ImprovedStackImpl(returnList);
			return reverseStack;
		} else {
			System.out.println(ErrorMessage.EMPTY_STRUCTURE);//type mismatch so error printed instead
			return null;
		}
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
		if(internalList.isEmpty() == false){
			for(int i = 0; i <= internalList.size(); i++){
				if(internalList.get(i).getReturnValue().equals(object)){
					internalList.remove(i);
					itemsRemoved++;
				}	
			} stackSize = stackSize - itemsRemoved;
		} else {
			System.out.println(ErrorMessage.EMPTY_STRUCTURE);//void method so error printed instead
		}
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
		if(internalList.isEmpty() == false){
			return internalList.get(internalList.size() - 1);
		} else {
			ReturnObject returnObj = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
			return returnObj;
		}
	}

	@Override
	public ReturnObject pop() {
		if(internalList.isEmpty() == false){
			ReturnObject returnObj = internalList.remove(internalList.size() - 1);
			stackSize--;
			return returnObj;
		} else {
			ReturnObject returnObj = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
			return returnObj;
		}
	}
}


