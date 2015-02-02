
// TODO: Auto-generated Javadoc
/**
 * An ArrayList implementation of the list interface .
 *
 * @author P Hannant
 */
public class ArrayList implements List {
	
	/** The list array. */
	protected Object[] listArray; 
	
	/** The temp array. */
	protected Object[] tempArray;
	
	/** The index count. */
	private int Count;
	
	/**
	 * Instantiates a new array list.
	 */
	public ArrayList(){
		this.listArray = new Object[10];
		Count = 0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean isEmpty(){
		if(listArray[0] == null){
			return true;
		} else {
		return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public int size(){
		return Count;
	}

	/**
	 * {@inheritDoc}
	 */
	public ReturnObject get(int index){
		ReturnObject returnObj = errorChecker(index);
		if(returnObj.hasError() != true){  
			ReturnObject getObj = new ReturnObjectImpl(listArray[index]);
			return getObj;
		} else {
			return returnObj;
		}
	}

	/**
	 *{@inheritDoc}
	 */
	public ReturnObject remove(int index){
		ReturnObject returnObj = errorChecker(listArray[index], index);
		if(returnObj.hasError() != true){  
			ReturnObject removedObj = new ReturnObjectImpl(listArray[index]);
			arrayCopierRemove(index);
			listArray[Count] = null;
			Count--;
			return removedObj;
		} else {
			return returnObj;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ReturnObject add(int index, Object item){
		ReturnObject returnObj = errorChecker(item, index);
		//checks if item is null or not
		if(returnObj.hasError() != true){  
			arrayCopierAdd(index);
			listArray[index] = item;
			Count++;
			return new ReturnObjectImpl(null);
		} else {
			return returnObj;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ReturnObject add(Object item){
		ReturnObject returnObj = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		if(item != null){  
			//checks whether first node is null
			if (listArray[0] == null){
				listArray[0] = item;
				Count++;
				return returnObj;
			}else {
					if(isArrayFull() == true){
						increaseArraySize();
						listArray[Count] = item;
						Count++;	
						return returnObj;
					} else {
						listArray[Count] = item;
						Count++;	
						return returnObj;
				}
			}
 		} else {
 			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			}
		}	
	
	/**
	 * Array copier remove.
	 *
	 * @param index the index
	 */
	private void arrayCopierRemove(int index){
		Object[] removeArray = new Object[Count];
		for(int i = 0; i < this.size(); i++){
			removeArray[i] = listArray[i];
		}
		for(int i = index; i < Count-1; i++){
			listArray[i] = removeArray[(i+1)];
		} 
	}
	
	/**
	 * Array copier add.
	 *
	 * @param index the index
	 */
	private void arrayCopierAdd(int index){
		for(int i = 0; i < this.size(); i++){
			tempArray[i] = listArray[i];
		}
		for(int i = index; i < Count; i++){
			listArray[(i+1)] = tempArray[i];
		}
	}
	
	/**
	 * Checks if is array full.
	 *
	 * @return true, if is array full
	 */
	private boolean isArrayFull(){
		if(Count == listArray.length){
			return true;
		} else{
			return false;
		}
	}
	
	/**
	 * Increases the array size.
	 */
	private void increaseArraySize(){
			tempArray = new Object[Count * 2]; 
			for(int i = 0; i < this.size(); i++){
				tempArray[i] = listArray[i];
			}
			listArray = new Object[Count * 2];
			for(int i = 0; i < this.size(); i++){
				listArray[i] = tempArray[i];
				}
			} 
	
	/**
	 * Checks the input for errors and returns the relevant error message.
	 *
	 * @param index the index
	 * @return the return object impl
	 */
	private ReturnObjectImpl errorChecker(int index){
		if (index < 0 || index >= Count){
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (this.isEmpty() == true){
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		}
	}
	
	
	
	/**
	 * Overloaded Error checker.
	 *
	 * @param item the item
	 * @param index the index
	 * @return the return object impl
	 */
	private ReturnObjectImpl errorChecker(Object item, int index){
		if(item == null){
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else if (index < 0 || index >= Count){
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (this.isEmpty() == true){
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		}
	}
	
	
}

