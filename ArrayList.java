
/**
 * An ArrayList implementation of the list interface 
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
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty(){
		if(listArray[0] == null){
			return true;
		} else {
		return false;
		}
	}

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	public int size(){
		return Count;
	}

	/**
	 * Returns the elements at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
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
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
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
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
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
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
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
	
	private boolean isArrayFull(){
		if(Count == listArray.length){
			return true;
		} else{
			return false;
		}
	}
	
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
	
	private ReturnObjectImpl errorChecker(int index){
		if (index < 0 || index >= Count){
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (this.isEmpty() == true){
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		}
	}
	
	
	
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

