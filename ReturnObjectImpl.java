/**
 * The wrapper class containing either the object or the error message.
 *
 * @author P Hannant
 */
public class ReturnObjectImpl implements ReturnObject {
	
	/** The return object. */
	private Object returnObject;
	
	/** The error. */
	private ErrorMessage error;
	
	/**
	 * Instantiates a new return object impl.
	 *
	 * @param object the object
	 */
	public ReturnObjectImpl(Object object){
		if(object == ErrorMessage.EMPTY_STRUCTURE || object == ErrorMessage.INDEX_OUT_OF_BOUNDS || object == ErrorMessage.INVALID_ARGUMENT){
			this.error = (ErrorMessage) object;
		} else {
			this.returnObject = object;
			this.error = ErrorMessage.NO_ERROR;
		}
		}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean hasError(){
		if (error == ErrorMessage.NO_ERROR){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ErrorMessage getError(){
		if (hasError() == false){
			return ErrorMessage.NO_ERROR;
		} else {
			return error;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getReturnValue(){
		if (hasError() == true){
			return null;
		} else {
			return returnObject;
		}
	}
}
