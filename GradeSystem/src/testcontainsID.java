import junit.framework.TestCase;

/************************************************************************
testgetNewWeights

@case 1	�ϥΪ̿�J ID 955002056	
@case 2	�ϥΪ̿�J ID 912345678
@case 3	�ϥΪ̿�J ID mkneatshit
************************************************************************/

public class testcontainsID extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	//Test Case 1�G input:955002056, expected output:true
	/*-----------------------------------------------------------------------
	 * testcontainsID1() 
	 * 
	 *	1.	expected result (ID 955002056 �s�b �Atrue)
	 * 	2.	�I�s GradeSystems.containsID (ID) �ˬdID�O�_�s�b
	 * 	3.	assert equal of the two results 
	 *-----------------------------------------------------------------------*/
	
	public void testcontainsID1() {
		String input = "955002056";		
		Boolean expected = true;
		
		GradeSystems aGradeSystems = new GradeSystems();	
		assertEquals(expected, aGradeSystems.containsID(input));
	}
	
	//Test Case 2�G input:912345678, expected output:false
	/*-----------------------------------------------------------------------
	 * testcontainsID2() 
	 * 
	 *  1.	expected result (ID 912345678���s�b �Afalse)
	 *	2.	�I�s GradeSystems.containsID (ID) �ˬdID�O�_�s�b
	 *	3.	assert equal of the two results 
	 -----------------------------------------------------------------------*/
	
	public void testcontainsID2() {
		String input = "912345678";		
		Boolean expected = false;
		
		GradeSystems aGradeSystems = new GradeSystems();	
		assertEquals(expected, aGradeSystems.containsID(input));
	}
	
	//Test Case 3�G input:912345678, expected output:false
	/*-----------------------------------------------------------------------
	 * testcontainsID3() 
	 * 
	 *  1.	expected result (ID mkneatshit���s�b �Afalse)
	 *	2.	�I�s GradeSystems.containsID (ID) �ˬdID�O�_�s�b
	 *	3.	assert equal of the two results 
	 -----------------------------------------------------------------------*/
	
	public void testcontainsID3() {
		String input = "mkneatshit";		
		Boolean expected = false;
		
		GradeSystems aGradeSystems = new GradeSystems();	
		assertEquals(expected, aGradeSystems.containsID(input));
	}
	

}
