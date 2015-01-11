public class ReturnObjectImplTest {
	
	public static void main(String[] args){
		ReturnObject testObject = new ReturnObjectImpl(34, null);
		ErrorMessage msg = testObject.getError();
		System.out.println(msg);
	}
}