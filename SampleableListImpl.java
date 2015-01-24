/**
 * A sampleable list can be sampled. 
 * 
 * @author PiJ
 */
public class SampleableListImpl extends ArrayList implements SampleableList {
	
	private Object[] sampleList;
	
	/**
	 * Returns a list containing the first, third, fifth...
	 * items of this list, or an empty list if the list is empty. 
	 * 
	 * @return a list containing the first, third, fifth... items of this list
	 */
	public SampleableListImpl sample(){
		SampleableListImpl returnList = new SampleableListImpl();
    	if(this.isEmpty() == false){
    		for(int i = 0; i < this.size(); i+=2){
    			returnList.add(listArray[i]);
    		}	
    			return returnList;
    	} else {
    		return returnList;
    	}
	}
}
