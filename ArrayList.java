
// TODO: Auto-generated Javadoc
/**
 * A list is a collection of objects that are sorted and can be
 * accessed by index. The first element in the list is at index 0.
 *
 * A list can store objects of any kind, and they can be of different
 * types: Integers, Doubles, String, or even other lists. However,
 * this list cannot store null objects.
 * 
 * There is no limit to the number of elements in the list (provided
 * that there is free memory in the Java Virtual Machine).
 * 
 * Not all operations on a list will always be successful. For
 * example, a programmer may try to remove an element from an empty
 * list, or from a position where there is nothing. Since we hace not
 * covered exceptions yet, we need another mechanism to report
 * errors. In order to do that, methods of this list will return a
 * {@see ReturnObject} that will contain either an object or an error
 * value of the right kind (as defined in {@see ErrorMessage}). 
 * 
 * @author PiJ
 */
public class ArrayList implements List {
	
	/** The list array. */
	protected Object[] listArray; 
	
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
		if(this.isEmpty() == false){	
			if(index < 0 || index + 1 > Count){
				ReturnObject errorObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
				return errorObj;
			} else {
				ReturnObject returnObj = new ReturnObjectImpl(listArray[index]);
				return returnObj;
			}
		} else {
			ReturnObject emptyStructureError = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
			return emptyStructureError;
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
		if (this.isEmpty() == false){	
			if(index > 0 || index < Count){
				ReturnObject removedObj = new ReturnObjectImpl(listArray[index]);
				arrayCopierRemove(index);
				Count--;
				listArray[Count] = null;
				return removedObj;
			} else {
				ReturnObject outOfBoundsMessage = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
				return outOfBoundsMessage;
			}
		} else {
			ReturnObject emptyStructureError = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
			return emptyStructureError;
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
		//checks if item is null or not
		if(item != null){  
			if(index > 0 || index < Count){
				arrayCopierAdd(index);
				listArray[index] = item;
				Count++;
				return new ReturnObjectImpl(null);
			} else {
				ReturnObject outOfBoundsMessage = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
				return outOfBoundsMessage;
			}
		} else {
			ReturnObject nullMessage = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return nullMessage;
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
		if(item != null){  
			//checks whether first node is null
			if (listArray[0] == null){
				listArray[0] = item;
				Count++;
				ReturnObject emptyObj = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
				return emptyObj;
			}else {
					if(isArrayFull() == true){
						increaseArraySize();
						listArray[Count] = item;
						Count++;	
						ReturnObject emptyObj = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
						return emptyObj;
					} else {
						listArray[Count] = item;
						Count++;	
						ReturnObject emptyObj = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
						return emptyObj;
				}
			}
 		} else {
 			ReturnObject nullMessage = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return nullMessage;
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
	private ReturnObjectImpl errorhecker(int index){
		if(this == null){
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

