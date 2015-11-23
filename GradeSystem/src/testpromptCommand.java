import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

/************************************************************************
 testpromptCommand  

 @case 1		使用者輸入 系統指令(E)
 @case 2		使用者輸入 錯誤指令
 *************************************************************************/	
public class testpromptCommand extends TestCase {
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
	
	//Test Case 1： 
	/*-----------------------------------------------------------------------
	 * testpromptCommand1() 
	 * 1. 預期螢幕顯示
	 * 	  [
	 *		 輸入指令	1) G 顯示成績 (Grade) 
	 * 					2) R 顯示排名 (Rank) 
	 *					3) W更新配分 (Weight) 
	 *					4) E 離開選單 (Exit) 
	 *	  ]
	 * 2.	呼叫 UI.promptCommand () 印出指令並讀取使用者要輸入的指令
	 * 3.	assert equal of the two results 
	 *-----------------------------------------------------------------------*/
	
	public void testpromptCommand1() {  
		String input = "E\r\n";
		String expectedString = "\r\n 輸入指令\t 1) G 顯示成績 (Grade) " +
						 "\r\n\t 2) R 顯示排名 (Rank) " +
						 "\r\n\t 3) W 更新配分 (Weight) " +
						 "\r\n\t 4) E 離開選單 (Exit) " +
						 "\r\n"; 		
		Boolean expected = false;

		inContent = new ByteArrayInputStream(input.getBytes());
		System.setIn(inContent);	
		UI aUI = new UI(true);	
		try 
		{
			assertEquals(aUI.promptCommand(), expected);
			
		} catch (NoSuchCommandExceptions success) {			
			assertNull(success.getMessage());	
		}
		assertEquals(expectedString, outContent.toString());
	}

	//Test Case 2： 
	/*-----------------------------------------------------------------------
	 * testpromptCommand2() 
	 * 1. 預期螢幕顯示
	 * 	  [
	 *		輸入指令	1) G 顯示成績 (Grade) 
	 * 					2) R 顯示排名 (Rank) 
	 *					3) W更新配分 (Weight) 
	 *					4) E 離開選單 (Exit) 
	 *	  ]
	 * 2.	呼叫 UI.promptCommand () 印出指令並讀取使用者要輸入的指令
	 * 3.	assert equal of the two results 
	 *-----------------------------------------------------------------------*/
	public void testpromptCommand2() {  
		String input = "A\r\n";	
		
		inContent = new ByteArrayInputStream(input.getBytes());
		System.setIn(inContent);	
		
		UI aUI = new UI(true);
	    try {
	    	aUI.promptCommand();
	    	fail("Did’t catch the expected exception !");
	    }
	    catch (NoSuchCommandExceptions success) {	
	    	assertNotNull(success.getMessage());	
		}
	}

}

