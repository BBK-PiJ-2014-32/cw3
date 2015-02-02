
/**
 * Linked list implementation of the List interface.
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
	private int Count;
	
	
	/**
	 * Instantiates a new linked list.
	 */
	public LinkedList(){
		first = null;
		previous = null;
		tempNode = null;
		Count = 0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean isEmpty(){
		if (first == null){
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
			Node thisNode = first;
				for(int i = 0; i < index; i++){;
					thisNode = thisNode.next;
					} 
				ReturnObject getObj = new ReturnObjectImpl(thisNode.objectValue);
				return getObj;
		} else {
			return returnObj;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ReturnObject remove(int index){
		ReturnObject returnObj = errorChecker(index);
		if(returnObj.hasError() != true){ 
			if(index == 0){
				if(first.next == null){
					ReturnObject removedObj = new ReturnObjectImpl(first.objectValue);
					first = null;
					Count--;
					return removedObj;
				} else{ 
					ReturnObject removedObj = new ReturnObjectImpl(first.objectValue);
					first = first.next;
					Count--;
					return removedObj;
				}
			} else {
				Node current = tempNode.getNode(index);
				previous = current.getNode(index-1);
				previous.next = previous.next.next;
				Count--;
				ReturnObject removedObj = new ReturnObjectImpl(current.objectValue);
				return removedObj;
			}
		} else {
			return returnObj;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ReturnObject add(int index, Object item){
		ReturnObject returnObj = errorChecker(item, index);
		if(returnObj.hasError() != true){  
			Node current = new Node(null);
			current = current.getNode(index-1);
			tempNode = current.next;
			current.next = new Node(item);
			current.next.next = tempNode;
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
		//checks if item is null or not
		if(item != null){  
			//checks whether first node is null
			if (first == null){
				tempNode = new Node(item);
				first = tempNode;
				Count++;
				return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
			}else {
				if(first.next == null){
					first.next = new Node(item);			
					Count++;
					return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
				} else {
					Node last = first.getLast();
					last.next = new Node(item);
					Count++;
					return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
				}
			}
 		} else {
 			ReturnObject nullMessage = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return nullMessage;
 			}
		}
	
	/**
	 * Checks the input for errors and returns the relevant error message.
	 *
	 * @param index the index
	 * @return the return object impl
	 */
	private ReturnObjectImpl errorChecker(int index){
		if (this.isEmpty() == true){
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else if (index < 0 || index >= Count){
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
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
				for(int i = 0; i < Count - 1; i++){
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
