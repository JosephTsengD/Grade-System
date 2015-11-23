import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

/************************************************************************
testshowRank

@case 1		ID 955002056
@case 2		ID 962001044
@case 3 	ID 962001051
************************************************************************/
public class testshowRank extends TestCase {
	
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
	
	//Test Case 1 : input:955002056, expected output:許文馨排名第51
	/*-----------------------------------------------------------------------
	 * testshowRank1() 
	 * 
	 * 1. 預期螢幕顯示 : 
	 *    [許文馨排名第51]    
	 * 2. 呼叫GradeSystems.showRank (ID) 印出排名
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowRank1() {    
		String input = "955002056";		
		String expected = "許文馨排名第51\r\n";
		
		GradeSystems aGradeSystems = new GradeSystems();
		aGradeSystems.showRank("955002056");
		assertEquals(expected, outContent.toString());
	}

	//Test Case 2 : input:962001044, expected output:凌宗廷排名第19
	/*-----------------------------------------------------------------------
	 * testshowRank2() 
	 * 
	 * 1. 預期螢幕顯示 : 
	 *    [凌宗廷排名第19]    
	 * 2. 呼叫GradeSystems.showRank (ID) 印出排名
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowRank2() {    
		String input = "962001044";		
		String expected = "凌宗廷排名第19\r\n";
		
		GradeSystems aGradeSystems = new GradeSystems();
		aGradeSystems.showRank("962001044");
		assertEquals(expected, outContent.toString());
	}
	
	//Test Case 3 : input:962001051, expected output:李威廷排名第39
	/*-----------------------------------------------------------------------
	 * testshowRank3() 
	 * 
	 * 1. 預期螢幕顯示 : 
	 *    [李威廷排名第39]    
	 * 2. 呼叫GradeSystems.showRank (ID) 印出排名
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowRank3() {    
		String input = "962001051";		
		String expected = "李威廷排名第39\r\n";
		
		GradeSystems aGradeSystems = new GradeSystems();
		aGradeSystems.showRank("962001051");
		assertEquals(expected, outContent.toString());
	}
}
