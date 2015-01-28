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
 * @author P Hannant
 */
public class LinkedList implements List {
	
	/** The first. */
	protected Node first;

	/** The temp node. */
	private Node tempNode;
	
	private Node previous; 
	
	/** The index count. */
	private int indexCount;
	
	
	/**
	 * Instantiates a new linked list.
	 */
	public LinkedList(){
		first = null;
		previous = null;
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
		if(this.isEmpty() == false){
			if(index < 0 || index - 1 > indexCount){
				ReturnObject errorObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
				return errorObj;
			} else {
				Node thisNode = first;
				for(int i = 0; i < index; i++){;
					thisNode = thisNode.next;
				} 
				ReturnObject returnObj = new ReturnObjectImpl(thisNode.objectValue);
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
		if(this.isEmpty() == false){
			if(index > 0 || index < indexCount){
				Node current = new Node(null);
				current = current.getNode(index);
				previous = current.getNode(index-1);
				previous.next = current.next;
				indexCount--;
				ReturnObject removedObj = new ReturnObjectImpl(current.objectValue);
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
			if(index > 0 || index < indexCount){
				Node current = new Node(null);
				current = current.getNode(index-1);
				tempNode = current.next;
				current.next = new Node(item);
				current.next.next = tempNode;
				indexCount++;
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
		//checks if item is null or not
		if(item != null){  
			//checks whether first node is null
			if (first == null){
				tempNode = new Node(item);
				first = tempNode;
				indexCount++;
				ReturnObject emptyObj = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
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
 			ReturnObject nullMessage = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return nullMessage;
 			}
		}
	

	/**
	 * The Class Node.
	 */
	public class Node{
		
		/** The object value. */
		protected Object objectValue;
		
		/** The next. */
		protected Node next;
		
		
		/**
		 * Instantiates a new node.
		 *
		 * @param obj the obj
		 */
		public Node(Object obj){
			this.objectValue = obj;
			this.next = null;
		}
		
		/**
		 * Gets the next.
		 *
		 * @return the next
		 */
		public Node getNext(){
			return next;
		}
		
		/**
		 * Gets the last.
		 *
		 * @return the last
		 */
		public Node getLast(){
			Node returnNode = first;
				for(int i = 0; i < indexCount - 1; i++){
					returnNode = returnNode.next;;
				}
			return returnNode;
		}
	
		/**
		 * Sets the next.
		 *
		 * @param current the new next
		 */
		public void setNext(Node current){
			this.next = current;
		}
		
		/**
		 * Gets the node.
		 *
		 * @param index the index
		 * @return the node
		 */
		public Node getNode(int index){
			Node returnNode = first;
			for(int i = 0; i < index; i++){
				returnNode = returnNode.next;
			}
			return returnNode;
		}
	}
	

	
}
