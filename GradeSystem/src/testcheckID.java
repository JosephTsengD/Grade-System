import junit.framework.TestCase;

/************************************************************************
testcheckID

@case 1	使用者輸入 ID 955002056	
@case 2	使用者輸入 ID 912345678		
@case 3	
************************************************************************/

public class testcheckID extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	//Test Case 1： input:955002056, expected output:true
	/*-----------------------------------------------------------------------
	 * testcheckID1() 
	 *  1.	expected result (ID 955002056正確  ，true)
	 *	2.	呼叫 UI.checkID (ID) 檢查ID
	 *	3.	assert equal of the two results 
	 *-----------------------------------------------------------------------*/
	
	public void testcheckID1() {
		String input = "955002056";		
		Boolean expected = true;
			
		UI aUI = new UI(true);
		try {
			assertEquals(expected, aUI.checkID(input));
		} catch (NoSuchIDExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Test Case 2： input:912345678, expected output:NoSuchIDExceptions
	/*-----------------------------------------------------------------------
	 * testcheckID2() 
	 *  1.	expected result (ID 912345678錯誤  ，跳出NoSuchIDExceptions)
	 *	2.	呼叫 UI.checkID (ID) 檢查ID
	 *	3.	assert equal of the two results 
	 *-----------------------------------------------------------------------*/
	public void testcheckID2() {
		String input = "912345678";		
		UI aUI;
	    try {	
	    	aUI = new UI(true);
	    	aUI.checkID(input);
	    }
	    catch (NoSuchIDExceptions success) {	
	    	assertNotNull(success.getMessage());	
		}
	}
}
