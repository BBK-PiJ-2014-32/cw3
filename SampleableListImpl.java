/**
 * A sampleable list can be sampled. 
 * 
 * @author P Hannant
 */
public class SampleableListImpl extends ArrayList implements SampleableList {
	
	
	/**
	 * {@inheritDoc} 
	 */
	public SampleableListImpl sample(){
		if (this.isEmpty() == false){
		SampleableListImpl returnList = new SampleableListImpl();
    		for(int i = 0; i < this.size(); i+=2){
    		returnList.add(listArray[i]);
    		}	
    		return returnList;
    	} else {
    		System.out.println(ErrorMessage.EMPTY_STRUCTURE);//type mismatch so error printed instead
    		return null;
    	}
	}
}
