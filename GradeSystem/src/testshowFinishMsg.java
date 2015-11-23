import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

/************************************************************************
testshowFinishMsg

@case 1		印出離開訊息
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
	 * 1. 預期螢幕顯示 : 
	 *    [結束了]    
	 * 2. 呼叫 UI.showFinishMsg() 印出結束訊息
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowFinishMsg1() { 
		String expected = "結束了\r\n";
		
		UI aUI = new UI(true);
		aUI.showFinishMsg();
		assertEquals(expected, outContent.toString());			
	}

}
