/**
 * Linked list implementation of functional list interface
 * 
 * @author P Hannant
 */
public class FunctionalLinkedList extends LinkedList implements FunctionalList {
	
	/** The Func linked list obj. */
	private Object FuncLinkedListObj;
	
    /**
     * {@inheritDoc}
     */
    public ReturnObject head(){
    	if(this.first != null){
    		FuncLinkedListObj = this.first.objectValue;
    		ReturnObject returnObj = new ReturnObjectImpl(FuncLinkedListObj);
			return returnObj;
    	}else {
    		ReturnObject returnObj = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
			return returnObj;
    	}
    }

    /**
     *{@inheritDoc}
     */
    public FunctionalLinkedList rest(){
    	FunctionalLinkedList returnList = new FunctionalLinkedList();
    	if(this.isEmpty() == false){
    		for(int i = 1; i < this.size(); i++){
    			ReturnObject newListObj = this.get(i);
    			Object item = newListObj.getReturnValue();
    			returnList.add(item);
    		}	
    			return returnList;
    	} else {
    		return returnList;
    	}
    }
}
