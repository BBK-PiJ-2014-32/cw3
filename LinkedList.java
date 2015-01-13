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
 * @author P Hannant
 */
public class LinkedList implements List {
	private Node first;
	private Node tempNode;
	private int indexCount;
	
	
	public LinkedList(){
		first = null;
		tempNode = null;
		indexCount = 0;
	}
	
	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty(){
		if (first == null){
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
		} else {
		Node thisNode = first;
			for(int i = 0; i <= index; i++){;
				thisNode = thisNode.next;
			} 
		ReturnObject returnObj = new ReturnObjectImpl(thisNode.objectValue, ErrorMessage.NO_ERROR);
		return returnObj;
		}
		return null;
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
		return null;
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
	
				
			} else {
				ReturnObject outOfBoundsMessage = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
				return outOfBoundsMessage;
			}
 		} else {
 			ReturnObject nullMessage = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
			return nullMessage;
 			} return null;
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
		//checks if item is null or not
		if(item != null){  
			//checks whether first node is null
			if (first == null){
				tempNode = new Node(item);
				first = tempNode;
				indexCount++;
				ReturnObject emptyObj = new ReturnObjectImpl(null, ErrorMessage.NO_ERROR);
				return emptyObj;
			}else {
				if(first.next == null){
					first.next = new Node(item);			
					indexCount++;
				} else {
					Node last = first.getLast();
					last.next = new Node(item);
					indexCount++;
				}
			 return null;
			}
 		} else {
 			ReturnObject nullMessage = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
			return nullMessage;
 			}
		}
	
	public class Node{
		protected Object objectValue;
		protected Node next;
		
		
		public Node(Object obj){
			this.objectValue = obj;
			this.next = null;
		}
		
		public Node getNext(Node current){
			return next;
		}
		
		public Node getLast(){
			Node returnNode = first;
				for(int i = 0; i < indexCount - 1; i++){
					returnNode = returnNode.next;;
				}
			return returnNode;
		}
	
		public void setNext(Node current){
			this.next = current;
		}
		
		public Node getNode(int index){
			Node returnNode = first;
			for(int i = 0; i < index - 1; i++){
				returnNode = returnNode.next;;
			}
			return returnNode;
		}
	}
	
}
