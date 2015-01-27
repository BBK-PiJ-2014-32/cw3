import static org.junit.Assert.*;

import org.junit.Test;


/**
 * JUnit test class for the SampleableListImpl class..
 */
public class SampleableListImplTest {

	/**
	 * Sample test.
	 */
	@Test
	public void sampleTest() {
		SampleableListImpl testSampleList = new SampleableListImpl();
		testSampleList.add("a");
		testSampleList.add("b");
		testSampleList.add("c");
		testSampleList.add("d");
		testSampleList.add("e");
		testSampleList.add("f");
		testSampleList.add("g");
		testSampleList.add("h");
		testSampleList.add("i");
		SampleableListImpl newSampleList = testSampleList.sample();
		int output = newSampleList.size();
		int expected = 5;
		assertEquals(expected, output);
	}

}
