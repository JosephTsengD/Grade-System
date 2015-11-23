import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

/************************************************************************
 testpromptCommand  

 @case 1		�ϥΪ̿�J �t�Ϋ��O(E)
 @case 2		�ϥΪ̿�J ���~���O
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
	
	//Test Case 1�G 
	/*-----------------------------------------------------------------------
	 * testpromptCommand1() 
	 * 1. �w���ù����
	 * 	  [
	 *		 ��J���O	1) G ��ܦ��Z (Grade) 
	 * 					2) R ��ܱƦW (Rank) 
	 *					3) W��s�t�� (Weight) 
	 *					4) E ���}��� (Exit) 
	 *	  ]
	 * 2.	�I�s UI.promptCommand () �L�X���O��Ū���ϥΪ̭n��J�����O
	 * 3.	assert equal of the two results 
	 *-----------------------------------------------------------------------*/
	
	public void testpromptCommand1() {  
		String input = "E\r\n";
		String expectedString = "\r\n ��J���O\t 1) G ��ܦ��Z (Grade) " +
						 "\r\n\t 2) R ��ܱƦW (Rank) " +
						 "\r\n\t 3) W ��s�t�� (Weight) " +
						 "\r\n\t 4) E ���}��� (Exit) " +
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

	//Test Case 2�G 
	/*-----------------------------------------------------------------------
	 * testpromptCommand2() 
	 * 1. �w���ù����
	 * 	  [
	 *		��J���O	1) G ��ܦ��Z (Grade) 
	 * 					2) R ��ܱƦW (Rank) 
	 *					3) W��s�t�� (Weight) 
	 *					4) E ���}��� (Exit) 
	 *	  ]
	 * 2.	�I�s UI.promptCommand () �L�X���O��Ū���ϥΪ̭n��J�����O
	 * 3.	assert equal of the two results 
	 *-----------------------------------------------------------------------*/
	public void testpromptCommand2() {  
		String input = "A\r\n";	
		
		inContent = new ByteArrayInputStream(input.getBytes());
		System.setIn(inContent);	
		
		UI aUI = new UI(true);
	    try {
	    	aUI.promptCommand();
	    	fail("Did��t catch the expected exception !");
	    }
	    catch (NoSuchCommandExceptions success) {	
	    	assertNotNull(success.getMessage());	
		}
	}

}

