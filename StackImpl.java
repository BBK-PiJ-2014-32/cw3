/**
 * An implementation of a stack that uses a {@List} as the underlying
 * data structure.
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
public class StackImpl extends AbstractStack implements Stack {
    
	private int stackSize;
	
	public StackImpl(List list){
		super(list);
		stackSize = 0;
	}

	@Override
	public boolean isEmpty() {
		if(stackSize == 0){
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
		return null;
	}
}

