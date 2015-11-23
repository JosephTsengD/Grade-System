import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

/************************************************************************
testpromptID

@case 1		�ϥΪ̿�JID	955002056
@case 2		�ϥΪ̿�J Q(�����ϥ�)
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
	 * 1. expected result : true (��J������ID�Atrue)
	 *    �w���ù���� : 
	 *    [��JID�� Q (�����ϥ�)�H]    
	 * 2. �I�s UI.promptID() �L�X�T��
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testpromptID1() { 
		String input = "955002056\r\n";	
		Boolean expected = true;
		String expectedString = "��JID�� Q (�����ϥ�)�H\r\n";
		
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
	 * 1. expected result : false (��J���}���O�Afalse) 
	 * 	     �w���ù���� : 
	 *    [��JID�� Q (�����ϥ�)�H]
	 * 2. �I�s UI.promptID() �L�X�T��
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
