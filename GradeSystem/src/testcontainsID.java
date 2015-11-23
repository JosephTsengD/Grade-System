import junit.framework.TestCase;

/************************************************************************
testgetNewWeights

@case 1	使用者輸入 ID 955002056	
@case 2	使用者輸入 ID 912345678
@case 3	使用者輸入 ID mkneatshit
************************************************************************/

public class testcontainsID extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	//Test Case 1： input:955002056, expected output:true
	/*-----------------------------------------------------------------------
	 * testcontainsID1() 
	 * 
	 *	1.	expected result (ID 955002056 存在 ，true)
	 * 	2.	呼叫 GradeSystems.containsID (ID) 檢查ID是否存在
	 * 	3.	assert equal of the two results 
	 *-----------------------------------------------------------------------*/
	
	public void testcontainsID1() {
		String input = "955002056";		
		Boolean expected = true;
		
		GradeSystems aGradeSystems = new GradeSystems();	
		assertEquals(expected, aGradeSystems.containsID(input));
	}
	
	//Test Case 2： input:912345678, expected output:false
	/*-----------------------------------------------------------------------
	 * testcontainsID2() 
	 * 
	 *  1.	expected result (ID 912345678不存在 ，false)
	 *	2.	呼叫 GradeSystems.containsID (ID) 檢查ID是否存在
	 *	3.	assert equal of the two results 
	 -----------------------------------------------------------------------*/
	
	public void testcontainsID2() {
		String input = "912345678";		
		Boolean expected = false;
		
		GradeSystems aGradeSystems = new GradeSystems();	
		assertEquals(expected, aGradeSystems.containsID(input));
	}
	
	//Test Case 3： input:912345678, expected output:false
	/*-----------------------------------------------------------------------
	 * testcontainsID3() 
	 * 
	 *  1.	expected result (ID mkneatshit不存在 ，false)
	 *	2.	呼叫 GradeSystems.containsID (ID) 檢查ID是否存在
	 *	3.	assert equal of the two results 
	 -----------------------------------------------------------------------*/
	
	public void testcontainsID3() {
		String input = "mkneatshit";		
		Boolean expected = false;
		
		GradeSystems aGradeSystems = new GradeSystems();	
		assertEquals(expected, aGradeSystems.containsID(input));
	}
	

}
