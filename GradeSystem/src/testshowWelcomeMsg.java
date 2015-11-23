import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

/************************************************************************
testshowWelcomeMsg

@case 1		ID 955002056
@case 2		ID 962001044
@case 3 	ID 962001051
************************************************************************/
public class testshowWelcomeMsg extends TestCase {

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

	//Test Case 1 : input:955002056, expected output:Welcome 許文馨
	/*-----------------------------------------------------------------------
	 * testshowWelcomeMsg1() 
	 * 
	 * 1. 預期螢幕顯示 : 
	 *    [Welcome 許文馨]    
	 * 2. 呼叫 UI.showWelcomeMsg() 印出歡迎訊息
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowWelcomeMsg1() { 		
		String input = "955002056";	
		String expected = "Welcome 許文馨\r\n";
	
		UI aUI = new UI(true);
		aUI.showWelcomeMsg(input);
		assertEquals(expected, outContent.toString());
	}
	
	//Test Case 2 : input:962001044, expected output:Welcome 凌宗廷
	/*-----------------------------------------------------------------------
	 * testshowWelcomeMsg2() 
	 * 
	 * 1. 預期螢幕顯示 : 
	 *    [Welcome 凌宗廷]    
	 * 2. 呼叫 UI.showWelcomeMsg() 印出歡迎訊息
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowWelcomeMsg2() { 		
		String input = "962001044";	
		String expected = "Welcome 凌宗廷\r\n";
	
		UI aUI = new UI(true);
		aUI.showWelcomeMsg(input);
		assertEquals(expected, outContent.toString());
	}
	
	//Test Case 3 : input:962001051, expected output:Welcome 李威廷
	/*-----------------------------------------------------------------------
	 * testshowWelcomeMsg3() 
	 * 
	 * 1. 預期螢幕顯示 : 
	 *    [Welcome 李威廷]    
	 * 2. 呼叫 UI.showWelcomeMsg() 印出歡迎訊息
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowWelcomeMsg3() { 		
		String input = "962001051";	
		String expected = "Welcome 李威廷\r\n";
	
		UI aUI = new UI(true);
		aUI.showWelcomeMsg(input);
		assertEquals(expected, outContent.toString());
	}
}
