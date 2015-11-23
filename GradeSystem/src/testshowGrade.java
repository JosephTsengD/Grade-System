import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

/************************************************************************
testshowGrade

@case 1		ID 955002056
@case 2		ID 962001044
@case 3 	ID 962001051
************************************************************************/
public class testshowGrade extends TestCase {
	
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
	
	//Test Case 1 : input:955002056
	/*-----------------------------------------------------------------------
	 * testshowGradeID1() 
	 * 
	 * 1. �w���ù���� : 
	 *    [
	 *    �\���ɦ��Z�Glab1�G	88
	 *    			 lab2�G	92
	 *    			 lab3�G	88 
	 *    			 mid-term : 	98 
	 *    			 final exam�G	91
	 *    			 total grade : 	93
	 *    ]    
	 * 2. �I�sGradeSystems.showGrade (ID) �L�X���Z
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowGrade1() {    
		String input = "955002056";		
		String expected = "�\���ɦ��Z�G\t " +
							"lab1�G\t 88 \r\n\t " +
							"lab2�G\t 92 \r\n\t " +
							"lab3�G\t 88 \r\n\t " +
							"mid-term : \t 98 \r\n\t " +
							"final exam�G\t 91 \r\n\t " +
							"total grade : \t 93\r\n";

		GradeSystems aGradeSystems = new GradeSystems();
		aGradeSystems.showGrade("955002056");
		assertEquals(expected, outContent.toString());
	}

	//Test Case 2 : input:962001044
	/*-----------------------------------------------------------------------
	 * testshowGradeID2() 
	 * 
	 * 1. �w���ù���� : 
	 *    [
	 *    ��v�ʦ��Z�Glab1�G	87
	 *    			 lab2�G	86
	 *    			 lab3�G	98 
	 *    			 mid-term : 	88 
	 *    			 final exam�G	87
	 *    			 total grade : 	88
	 *    ]    
	 * 2. �I�sGradeSystems.showGrade (ID) �L�X���Z
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowGrade2() {    
		String input = "962001044";		
		String expected = "��v�ʦ��Z�G\t " +
							"lab1�G\t 87 \r\n\t " +
							"lab2�G\t 86 \r\n\t " +
							"lab3�G\t 98 \r\n\t " +
							"mid-term : \t 88 \r\n\t " +
							"final exam�G\t 87 \r\n\t " +
							"total grade : \t 88\r\n";

		GradeSystems aGradeSystems = new GradeSystems();
		aGradeSystems.showGrade("962001044");
		assertEquals(expected, outContent.toString());
	}
	
	//Test Case 3 : input:962001051
	/*-----------------------------------------------------------------------
	 * testshowGradeID3() 
	 * 
	 * 1. �w���ù���� : 
	 *    [
	 *    ���§ʦ��Z�Glab1�G	81
	 *    			 lab2�G	98
	 *    			 lab3�G	84 
	 *    			 mid-term : 	90 
	 *    			 final exam�G	93
	 *    			 total grade : 	91
	 *    ]    
	 * 2. �I�sGradeSystems.showGrade (ID) �L�X���Z
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowGrade3() {    
		String input = "962001051";		
		String expected = "���§ʦ��Z�G\t " +
							"lab1�G\t 81 \r\n\t " +
							"lab2�G\t 98 \r\n\t " +
							"lab3�G\t 84 \r\n\t " +
							"mid-term : \t 90 \r\n\t " +
							"final exam�G\t 93 \r\n\t " +
							"total grade : \t 91\r\n";

		GradeSystems aGradeSystems = new GradeSystems();
		aGradeSystems.showGrade("962001051");
		assertEquals(expected, outContent.toString());
	}
}
