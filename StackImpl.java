// TODO: Auto-generated Javadoc
/**
 * CLass that extends AbstractStack and implements the methods of stack.
 * 
 * @author P Hannant
 */
public class StackImpl extends AbstractStack implements Stack {
    
	/** The stack size. */
	private int stackSize;
	
	/**
	 * Instantiates a new stack impl.
	 *
	 * @param list the list
	 */
	public StackImpl(List list){
		super(list);
		stackSize = 0;
	}

	/* (non-Javadoc)
	 * @see Stack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		if(stackSize == 0){
			return true;
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see Stack#size()
	 */
	@Override
	public int size() {
		return stackSize;
	}

	/* (non-Javadoc)
	 * @see Stack#push(java.lang.Object)
	 */
	@Override
	public void push(Object item) {
		internalList.add(item);
		stackSize++;
	}

	/* (non-Javadoc)
	 * @see Stack#top()
	 */
	@Override
	public ReturnObject top() {
		if(internalList.isEmpty() == false){
			return internalList.get(internalList.size() - 1);
		} else {
			ReturnObject returnObj = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
			return returnObj;
		}
	}

	/* (non-Javadoc)
	 * @see Stack#pop()
	 */
	@Override
	public ReturnObject pop() {
		if(internalList.isEmpty() == false){
			ReturnObject returnObj = internalList.remove(internalList.size()-1);
			stackSize--;
			return returnObj;
		} else {
			ReturnObject returnObj = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
			return returnObj;
		}
	}
}

