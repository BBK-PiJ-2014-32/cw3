/**
 * An implementation of the improved stack interface. 
 *
 * 
 * @author P Hannant
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
	 * {@inheritDoc}
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
	 * {@inheritDoc}
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		if(internalList.size() == 0){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return stackSize;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(Object item) {
		internalList.add(item);
		stackSize++;
	}

	/**
	 * {@inheritDoc}
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

	/**
	 * {@inheritDoc}
	 */
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


