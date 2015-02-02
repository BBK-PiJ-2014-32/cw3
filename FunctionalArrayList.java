/**
 * Array list implementation of functional list interface
 * 
 * @author P Hannant
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {
	
	/** The my func array list. */
	private Object[] myFuncArrayList;
	
		/**
		 * Instantiates a new functional array list.
		 */
		public FunctionalArrayList (){
			this.myFuncArrayList = new Object[10];
		}
    /**
     * {@inheritDoc}
     */
    public ReturnObject head(){
    	if(this.isEmpty() == false){
    		myFuncArrayList = listArray;
    		ReturnObject returnObj = new ReturnObjectImpl(myFuncArrayList[0]);
			return returnObj;
    	}else {
    		ReturnObject returnObj = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
			return returnObj;
    	}
    }

    /**
     * {@inheritDoc}
     */
    public FunctionalArrayList rest(){
    	FunctionalArrayList returnList = new FunctionalArrayList();
    	if(this.isEmpty() == false){
    		for(int i = 0; i < this.size(); i++){
    			returnList.add(listArray[i+1]);
    		}	
    			return returnList;
    	} else {
    		return returnList;
    	}
    }
}
