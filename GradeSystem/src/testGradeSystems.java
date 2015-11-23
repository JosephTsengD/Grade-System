import junit.framework.TestCase;

/************************************************************************
testGradeSystems

@case 1	��Ū��	

************************************************************************/

public class testGradeSystems extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	//Test Case 1 
	/*-----------------------------------------------------------------------
	 * testGradeSystems1() 
	 * 
	 * 1. �w��Ū�����
	 *   			{"955002056","�\����","88","92","88","98","91"},
	 *				{"962001044","��v��","87","86","98","88","87"},
	 *				{"962001051","���§�","81","98","84","90","93"},
	 *				{"965002038","Ĭ���k","95","89","93","81","83"},
	 *				{"965002044","�Ӵ��L","85","86","80","81","88"}
	 * 2. �I�s GradeSystems() �غc�l
	 * 3. ���e���H�����Z assert equal of the two results 
	 * 
	 *-----------------------------------------------------------------------*/
	public void testGradeSystems1() {
		String[][] expected = {{"955002056","�\����","88","92","88","98","91"},
							   {"962001044","��v��","87","86","98","88","87"},
							   {"962001051","���§�","81","98","84","90","93"},
							   {"965002038","Ĭ���k","95","89","93","81","83"},
							   {"965002044","�Ӵ��L","85","86","80","81","88"}};		
				
		
		
		GradeSystems aGradeSystem = new GradeSystems();
		for(int i=0;i<5;i++)
		{
			
			assertEquals( expected[i][0], aGradeSystem.aList.get(i).ID);
			assertEquals( expected[i][1], aGradeSystem.aList.get(i).name);
			assertEquals( expected[i][2], Integer.toString(aGradeSystem.aList.get(i).lab1));
			assertEquals( expected[i][3], Integer.toString(aGradeSystem.aList.get(i).lab2));
			assertEquals( expected[i][4], Integer.toString(aGradeSystem.aList.get(i).lab3));
			assertEquals( expected[i][5], Integer.toString(aGradeSystem.aList.get(i).midTerm));
			assertEquals( expected[i][6], Integer.toString(aGradeSystem.aList.get(i).finalExam));
			
		}
	}

}
