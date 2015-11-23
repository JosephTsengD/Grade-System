import java.io.ByteArrayInputStream;

import junit.framework.TestCase;

/************************************************************************
testupdateWeights

@case 1		lab1 20   lab2 20   lab3 20  mid-term 20   finalExam 20
@case 2		lab1  0   lab2 10   lab3 20  mid-term 30   finalExam 40
@case 3 	lab1  0   lab2  0   lab3  0  mid-term  0   finalExam 100
************************************************************************/
public class testupdateWeights extends TestCase {

	/**
	 * @uml.property  name="inContent"
	 */
	private ByteArrayInputStream inContent; 
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	//Test Case 1 : input:{20,20,20,20,20}
	/*-----------------------------------------------------------------------
	 * testupdateWeights1() 
	 * 
	 * 1. expected result : 更新Weights之後的totalGrades
	 * 	     預期螢幕顯示 : 
	 *    [
	 *    請確認新配分 
	 *    	lab1		20%
	 *    	lab2		20%
	 *    	lab3 		20%
	 *    	mid-term	20%
	 *    	final exam 	20%
	 *    以上正確嗎? Y (Yes) 或 N (No)	
	 *    ]    
	 * 2. 呼叫 GradeSystems.updateWeights() 更新Weights，並重新計算totalGrade
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testupdateWeights1() {  
		String input = "20\r\n20\r\n20\r\n20\r\n20\r\nY\r\n";
		int[] expected = {91,89,89,88,84,89,87,87,91,90,95,89,90,92,89,91,88,87,87,92,84,93,91,86,88,93,89,90,90,92,90,90,87,89,88,93,92,90,88,90,87,92,86,93,88,91,93,91,86,90,92,92,88,88,93,88,93,90,84,88,86,89,96,88,87};
	
		inContent = new ByteArrayInputStream(input.getBytes());
		System.setIn(inContent);
		
		GradeSystems aGradeSystems = new GradeSystems();
		aGradeSystems.updateWeights();
		
		for(int i=0 ; i<aGradeSystems.aList.size() ; i++ )
			assertEquals( expected[i], aGradeSystems.aList.get(i).totalGrade);
	}
	
	//Test Case 2 : input:{ 0,10,20,30,40}
	/*-----------------------------------------------------------------------
	 * testupdateWeights2() 
	 * 
	 * 1. expected result : 更新Weights之後的totalGrades
	 * 	     預期螢幕顯示 : 
	 *    [
	 *    請確認新配分 
	 *    	lab1		0%
	 *    	lab2		10%
	 *    	lab3 		20%
	 *    	mid-term	30%
	 *    	final exam 	40%
	 *    以上正確嗎? Y (Yes) 或 N (No)	
	 *    ]    
	 * 2. 呼叫 GradeSystems.updateWeights() 更新Weights，並重新計算totalGrade
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testupdateWeights2() {  
		String input = "0\r\n10\r\n20\r\n30\r\n40\r\nY\r\n";
		int[] expected = {93,89,91,85,84,87,86,87,91,90,95,91,90,92,89,93,89,89,87,91,86,92,92,85,85,95,85,90,90,93,95,91,86,88,87,92,92,91,87,91,86,93,84,89,88,90,93,90,87,90,93,91,87,88,92,88,97,88,85,89,85,88,95,89,88};
		
		inContent = new ByteArrayInputStream(input.getBytes());
		System.setIn(inContent);
		
		GradeSystems aGradeSystems = new GradeSystems();
		aGradeSystems.updateWeights();						

		for(int i=0 ; i<aGradeSystems.aList.size() ; i++ )
			assertEquals( expected[i], aGradeSystems.aList.get(i).totalGrade );
	}
	
	//Test Case 3 : input:{ 0, 0, 0, 0,100}
	/*-----------------------------------------------------------------------
	 * testupdateWeights3() 
	 * 
	 * 1. expected result : 更新Weights之後的totalGrades
	 * 	     預期螢幕顯示 : 
	 *    [
	 *    請確認新配分 
	 *    	lab1		0%
	 *    	lab2		0%
	 *    	lab3 		0%
	 *    	mid-term	0%
	 *    	final exam 	100%
	 *    以上正確嗎? Y (Yes) 或 N (No)	
	 *    ]    
	 * 2. 呼叫 GradeSystems.updateWeights() 更新Weights，並重新計算totalGrade
	 * 3. assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testupdateWeights3() {  
		String input = "0\r\n0\r\n0\r\n0\r\n100\r\nY\r\n";
		int[] expected = {91,87,93,83,88,90,84,85,89,95,94,87,94,95,80,99,90,92,86,94,90,96,88,86,87,95,80,89,90,95,98,94,80,89,80,99,94,89,85,92,91,94,87,87,89,89,92,88,90,89,97,93,82,85,95,88,99,81,85,89,85,86,91,91,93};
		
		inContent = new ByteArrayInputStream(input.getBytes());
		System.setIn(inContent);
			
		GradeSystems aGradeSystems = new GradeSystems();
		aGradeSystems.updateWeights();

		for(int i=0 ; i<aGradeSystems.aList.size() ; i++ )
			assertEquals( expected[i], aGradeSystems.aList.get(i).totalGrade );		
	}
}
