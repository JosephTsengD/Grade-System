import junit.framework.TestCase;

/************************************************************************
 testCalculateTotalGrade 
 aGrade: ID 955002056 name 許文馨  lab1 81  lab2 98  lab3 84  midTerm 90 finalExam 93

 @case 1		使用者輸入 lab1 0.1  lab2 0.1  lab3 0.1  midTerm 0.3  finalExam 0.4
 @case 2		使用者輸入 lab1 0.2  lab2 0.2  lab3 0.2  midTerm 0.2  finalExam 0.2
 @case 3		使用者輸入 lab1 0.1  lab2 0.1  lab3 0.0  midTerm 0.4  finalExam 0.4
 *************************************************************************/	
public class testCalculateTotalGrade extends TestCase {
	/**
	 * @uml.property  name="inputGrades" multiplicity="(0 -1)" dimension="1"
	 */
	private String inputGrades[] = {"955002056", "許文馨", "81", "98", "84", "90", "93"};
	
	protected void setUp() throws Exception {
		super.setUp();
				
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	//Test Case 1： input:{0.1,0.1,0.1,0.3,0.4}, expected output:91
	/*-----------------------------------------------------------------------
	 * testCalculateTotalGrade1() 
	 * 
	 * 	1.	手算 expected result (81*0.1+98*0.1+84*0.1+90*0.3+93*0.4=90.5四捨五入91)
	 * 	2.	呼叫 aGrade.calculateTotalGrade (weights) 算actual result
	 * 	3.	assert equal of the two results 
	 *-----------------------------------------------------------------------*/
	
	public void testCalculateTotalGrade1() {
		float input[] = {0.1f,0.1f,0.1f,0.3f,0.4f};		
		int expected = 91;
		
		Grades aGrade = new Grades(inputGrades);
	 	int aTotalGrade = aGrade.calculateTotalGrade(input);
		assertEquals(expected,aTotalGrade);
	}
	
	//Test Case 2： input:{0.2,0.2,0.2,0.2,0.2}, expected output:89
	/*-----------------------------------------------------------------------
	 * testCalculateTotalGrade2() 
	 * 
	 * 	1.	手算 expected result (81*0.2+98*0.2+84*0.2+90*0.2+93*0.2四捨五入89)
	 * 	2.	呼叫 aGrade.calculateTotalGrade (weights) 算actual result
	 * 	3.	assert equal of the two results
	 * -----------------------------------------------------------------------*/
	
	public void testCalculateTotalGrade2() {
		float input[] = {0.2f,0.2f,0.2f,0.2f,0.2f};		
		int expected = 89;

		Grades aGrade = new Grades(inputGrades);
		int aTotalGrade = aGrade.calculateTotalGrade(input);
		assertEquals(expected,aTotalGrade);
	}
	
	//Test Case 3： input:{0.1,0.1,0.0,0.4,0.4}, expected output:89
	/*-----------------------------------------------------------------------
	 * testCalculateTotalGrade3() 
	 * 
	 * 	1.	手算 expected result (81*0.1+98*0.1+84*0.0+90*0.4+93*0.4四捨五入91)
	 * 	2.	呼叫 aGrade.calculateTotalGrade (weights) 算actual result
	 * 	3.	assert equal of the two results
	 * -----------------------------------------------------------------------*/
	
	public void testCalculateTotalGrade3() {
		float input[] = {0.1f,0.1f,0.0f,0.4f,0.4f};		
		int expected = 91;
		
		Grades aGrade = new Grades(inputGrades);
		int aTotalGrade = aGrade.calculateTotalGrade(input);
		assertEquals(expected,aTotalGrade);
	}

}
