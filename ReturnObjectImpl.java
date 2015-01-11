/**
 * A wrapper containing either an object (the result of an operation
 * on a data structure) or an error value.
 *
 * @author PiJ
 */
public class ReturnObjectImpl implements ReturnObject {
	private Object returnObject;
	private ErrorMessage error;
	
	public ReturnObjectImpl(Object object, ErrorMessage error){
		this.returnObject = object;
		this.error = null;
	}
	/**
	 * Returns whether there has been an error
	 * @return whether there has been an error
	 */
	public boolean hasError(){
		if (error == null || error.equals(ErrorMessage.NO_ERROR)){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Returns the error message. 
	 * 
	 * This method must return NO_ERROR if and only if
	 * {@hasError} returns false.
	 * 
	 * @return the error message
	 */
	public ErrorMessage getError(){
		if (hasError() == false){
			return ErrorMessage.NO_ERROR;
		} else {
			return null;//Need to add else ifs for other errors.
		}
	}

	/**
	 * Returns the object wrapped in this ReturnObject, i.e. the
	 * result of the operation if it was successful, or null if
	 * there has been error.
	 * 
	 * Note that the output of this method must be null if {@see
	 * hasError} returns true, but the opposite is not true: if
	 * {@see hasError} returns false, this method may or may not
	 * return null.
	 * 
	 * @return the return value from the method or null if there has been an
	 *         error
	 */
	public Object getReturnValue(){
		if (hasError() == true){
			return null;
		} else {
			return returnObject;
		}

	}
}
