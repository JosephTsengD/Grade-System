import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

/************************************************************************
testpromptID

@case 1		使用者輸入ID	955002056
@case 2		使用者輸入 Q(結束使用)
************************************************************************/
public class testpromptID extends TestCase {

	/**
	 * @uml.property  name="outContent"
	 */
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	/**
	 * @uml.property  name="inContent"
	 */
	private ByteArrayInputStream inContent; 
	
	protected void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		super.setUp();
	}

	protected void tearDown() throws Exception {
		System.setOut(null);
		super.tearDown();
	}
	
	//Test Case 1 : input:955002056, expected output:true
	/*-----------------------------------------------------------------------
	 * testpromptID1() 
	 * 
	 * 1. expected result : true (輸入類型為ID，true)
	 *    預期螢幕顯示 : 
	 *    [輸入ID或 Q (結束使用)？]    
	 * 2. 呼叫 UI.promptID() 印出訊息
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testpromptID1() { 
		String input = "955002056\r\n";	
		Boolean expected = true;
		String expectedString = "輸入ID或 Q (結束使用)？\r\n";
		
		inContent = new ByteArrayInputStream(input.getBytes());
		System.setIn(inContent);
		
		UI aUI = new UI(true);		
		assertEquals(aUI.promptID(), expected);
		assertEquals(expectedString, outContent.toString());
	}
	
	//Test Case 2 : input:Q , expected output:false
	/*-----------------------------------------------------------------------
	 * testpromptID2() 
	 * 
	 * 1. expected result : false (輸入離開指令，false) 
	 * 	     預期螢幕顯示 : 
	 *    [輸入ID或 Q (結束使用)？]
	 * 2. 呼叫 UI.promptID() 印出訊息
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testpromptID2() { 
		String input = "Q\r\n";		
		Boolean expected = false;
	
		inContent = new ByteArrayInputStream(input.getBytes());
		System.setIn(inContent);
		
		UI aUI = new UI(true);
		assertEquals(expected, aUI.promptID());		
	}
}
