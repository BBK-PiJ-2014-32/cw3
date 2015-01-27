public class ReturnObjectImplTest {
	
	public static void main(String[] args){
		ReturnObject testObject = new ReturnObjectImpl(null);
		ErrorMessage msg = testObject.getError();
		System.out.println(msg);
		ReturnObject testObject2 = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		ErrorMessage msg2 = testObject2.getError();
		System.out.println(msg2);
	}
}