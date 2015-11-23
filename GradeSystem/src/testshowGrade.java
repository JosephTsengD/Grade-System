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
	 * 1. 預期螢幕顯示 : 
	 *    [
	 *    許文馨成績：lab1：	88
	 *    			 lab2：	92
	 *    			 lab3：	88 
	 *    			 mid-term : 	98 
	 *    			 final exam：	91
	 *    			 total grade : 	93
	 *    ]    
	 * 2. 呼叫GradeSystems.showGrade (ID) 印出成績
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowGrade1() {    
		String input = "955002056";		
		String expected = "許文馨成績：\t " +
							"lab1：\t 88 \r\n\t " +
							"lab2：\t 92 \r\n\t " +
							"lab3：\t 88 \r\n\t " +
							"mid-term : \t 98 \r\n\t " +
							"final exam：\t 91 \r\n\t " +
							"total grade : \t 93\r\n";

		GradeSystems aGradeSystems = new GradeSystems();
		aGradeSystems.showGrade("955002056");
		assertEquals(expected, outContent.toString());
	}

	//Test Case 2 : input:962001044
	/*-----------------------------------------------------------------------
	 * testshowGradeID2() 
	 * 
	 * 1. 預期螢幕顯示 : 
	 *    [
	 *    凌宗廷成績：lab1：	87
	 *    			 lab2：	86
	 *    			 lab3：	98 
	 *    			 mid-term : 	88 
	 *    			 final exam：	87
	 *    			 total grade : 	88
	 *    ]    
	 * 2. 呼叫GradeSystems.showGrade (ID) 印出成績
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowGrade2() {    
		String input = "962001044";		
		String expected = "凌宗廷成績：\t " +
							"lab1：\t 87 \r\n\t " +
							"lab2：\t 86 \r\n\t " +
							"lab3：\t 98 \r\n\t " +
							"mid-term : \t 88 \r\n\t " +
							"final exam：\t 87 \r\n\t " +
							"total grade : \t 88\r\n";

		GradeSystems aGradeSystems = new GradeSystems();
		aGradeSystems.showGrade("962001044");
		assertEquals(expected, outContent.toString());
	}
	
	//Test Case 3 : input:962001051
	/*-----------------------------------------------------------------------
	 * testshowGradeID3() 
	 * 
	 * 1. 預期螢幕顯示 : 
	 *    [
	 *    李威廷成績：lab1：	81
	 *    			 lab2：	98
	 *    			 lab3：	84 
	 *    			 mid-term : 	90 
	 *    			 final exam：	93
	 *    			 total grade : 	91
	 *    ]    
	 * 2. 呼叫GradeSystems.showGrade (ID) 印出成績
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testshowGrade3() {    
		String input = "962001051";		
		String expected = "李威廷成績：\t " +
							"lab1：\t 81 \r\n\t " +
							"lab2：\t 98 \r\n\t " +
							"lab3：\t 84 \r\n\t " +
							"mid-term : \t 90 \r\n\t " +
							"final exam：\t 93 \r\n\t " +
							"total grade : \t 91\r\n";

		GradeSystems aGradeSystems = new GradeSystems();
		aGradeSystems.showGrade("962001051");
		assertEquals(expected, outContent.toString());
	}
}
