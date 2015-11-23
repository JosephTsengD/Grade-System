import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

/************************************************************************
testshowFinishMsg

@case 1		�L�X���}�T��
************************************************************************/
public class testshowFinishMsg extends TestCase {

	/**
	 * @uml.property  name="outContent"
	 */
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	protected void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		super.setUp();
	}

	protected void tearDown() throws Exception {
		System.setOut(null);
		super.tearDown();
	}
	
	//Test Case 1 : 
	/*-----------------------------------------------------------------------
	 * testshowFinishMsg1() 
	 * 
	 * 1. �w���ù���� : 
	 *    [�����F]    
	 * 2. �I�s UI.showFinishMsg() �L�X�����T��
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowFinishMsg1() { 
		String expected = "�����F\r\n";
		
		UI aUI = new UI(true);
		aUI.showFinishMsg();
		assertEquals(expected, outContent.toString());			
	}

}
