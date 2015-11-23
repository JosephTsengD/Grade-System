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
	
	//Test Case 1 : input:955002056, expected output:�\���ɱƦW��51
	/*-----------------------------------------------------------------------
	 * testshowRank1() 
	 * 
	 * 1. �w���ù���� : 
	 *    [�\���ɱƦW��51]    
	 * 2. �I�sGradeSystems.showRank (ID) �L�X�ƦW
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowRank1() {    
		String input = "955002056";		
		String expected = "�\���ɱƦW��51\r\n";
		
		GradeSystems aGradeSystems = new GradeSystems();
		aGradeSystems.showRank("955002056");
		assertEquals(expected, outContent.toString());
	}

	//Test Case 2 : input:962001044, expected output:��v�ʱƦW��19
	/*-----------------------------------------------------------------------
	 * testshowRank2() 
	 * 
	 * 1. �w���ù���� : 
	 *    [��v�ʱƦW��19]    
	 * 2. �I�sGradeSystems.showRank (ID) �L�X�ƦW
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowRank2() {    
		String input = "962001044";		
		String expected = "��v�ʱƦW��19\r\n";
		
		GradeSystems aGradeSystems = new GradeSystems();
		aGradeSystems.showRank("962001044");
		assertEquals(expected, outContent.toString());
	}
	
	//Test Case 3 : input:962001051, expected output:���§ʱƦW��39
	/*-----------------------------------------------------------------------
	 * testshowRank3() 
	 * 
	 * 1. �w���ù���� : 
	 *    [���§ʱƦW��39]    
	 * 2. �I�sGradeSystems.showRank (ID) �L�X�ƦW
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowRank3() {    
		String input = "962001051";		
		String expected = "���§ʱƦW��39\r\n";
		
		GradeSystems aGradeSystems = new GradeSystems();
		aGradeSystems.showRank("962001051");
		assertEquals(expected, outContent.toString());
	}
}
