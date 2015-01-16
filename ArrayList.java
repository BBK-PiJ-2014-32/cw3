
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
	private Object[] listArray; 
	
	/** The index count. */
	private int indexCount;
	
	/**
	 * Instantiates a new array list.
	 */
	public ArrayList(){
		this.listArray = new Object[10];
		indexCount = 0;
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
		return indexCount;
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
		if(index < 0 || index - 1 > indexCount){
			ReturnObject errorObj = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return errorObj;
		} else {
			ReturnObject returnObj = new ReturnObjectImpl(listArray[index], ErrorMessage.NO_ERROR);
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
		if(index > 0 || index < indexCount){
			arrayCopierRemove(index);
			listArray[indexCount] = null; 
			ReturnObject removedObj = new ReturnObjectImpl(null, null);
			return removedObj;
		} else {
			ReturnObject outOfBoundsMessage = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return outOfBoundsMessage;
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
			if(index > 0 || index < indexCount){
				arrayCopierAdd(index);
				listArray[index] = item;
				indexCount++;
				return new ReturnObjectImpl(null, null);
			} else {
				ReturnObject outOfBoundsMessage = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
				return outOfBoundsMessage;
			}
		} else {
			ReturnObject nullMessage = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
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
				indexCount++;
				ReturnObject emptyObj = new ReturnObjectImpl(null, ErrorMessage.NO_ERROR);
				return emptyObj;
			}else {
				listArray[indexCount] = item;
				indexCount++;
				ReturnObject emptyObj = new ReturnObjectImpl(null, ErrorMessage.NO_ERROR);
				return emptyObj;
				}
 		} else {
 			ReturnObject nullMessage = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
			return nullMessage;
 			}
	}
	
	/**
	 * Array copier remove.
	 *
	 * @param index the index
	 */
	public void arrayCopierRemove(int index){
		for(int i = index; i < indexCount; i++){
			listArray[i] = listArray[(i+1)];
		}
	}
	
	/**
	 * Array copier add.
	 *
	 * @param index the index
	 */
	public void arrayCopierAdd(int index){
		for(int i = index; i < indexCount; i++){
			listArray[(i+1)] = listArray[i];
		}
	}
}

