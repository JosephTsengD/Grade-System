import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


/***************************************************************************
 class GradeSystems �x�s a list of student grades.
	GradeSystems() 		Ū�J���Z�ɡA�s�Jdoubly-linked list
	showGrade(ID) 		��ܳo ID �� grade
	showRank(ID) 		��ܳoID���ƦW
	updateWeights() 	��s�t��
	containsID(ID) 		�� ID �O�_�t�b aGradeSystem��
*************************************************************************** */
public class GradeSystems {
	
	/**
	 * @uml.property  name="weights" multiplicity="(0 -1)" dimension="1"
	 */
	float[] weights;
	/**
	 * @uml.property  name="aList"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="Grades"
	 */
	public LinkedList<Grades> aList;
	
	/*************************************************************************
	 GradeSystems() Ū�J���Z�ɡA�s�Jdoubly-linked list
	 
	 Time		O(n) n �� aGradeSystem �����Z�H��
	*************************************************************************/
	public GradeSystems ()
	{
		/*-----------------------------------------------------------------------
		 * GradeSystems ()
		 *	1. �}�� input file 
		 *	2. ��Java LinkedList�غcan empty list of grades�s aList
		 *	3. read line
		 *	4. while not endOfFile
		 *		1.call Grades() �غcaGrade
		 *		2.�� Java Scanner �� scan line ��U���s�JaGrade
		 *		3. aGrade.calculateTotalGrade(weights) �^��aTotalGrade�⥦�s�JaGrade
		 *		4. �� aGrade �s�J aList
		 *		5. if endOfLine then read line end if
		 *   end while
		 *-----------------------------------------------------------------------*/
		
		weights = new float[]{0.1f,0.1f,0.1f,0.3f,0.4f};
		aList = new LinkedList<Grades>();
		FileReader fin;
		try {
			fin = new FileReader("gradeInput.txt");
			Scanner JavaScanner = new Scanner(fin);		

			while(JavaScanner.hasNext())
			{				 
				 Grades aGrade = new Grades();
				 aGrade.ID = JavaScanner.next();
				 aGrade.name = JavaScanner.next();
				 aGrade.lab1 = JavaScanner.nextInt();
				 aGrade.lab2 = JavaScanner.nextInt();
				 aGrade.lab3 = JavaScanner.nextInt();
				 aGrade.midTerm = JavaScanner.nextInt();
				 aGrade.finalExam = JavaScanner.nextInt();
				 aGrade.totalGrade = aGrade.calculateTotalGrade(weights);

				 aList.add(aGrade);	
				 if(JavaScanner.hasNext())
					 JavaScanner.nextLine();		 
			}
			JavaScanner.close();
			fin.close();

		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
	
	
	
	/************************************************************************* 
	 findGradebyID(ID) �M��o ID �� Grades class
	 
	 @parameter	ID �Ǹ��C��: 955002056
	 @return 	Grades class
	 Time		O(n) n �� aGradeSystem �����Z�H��
	 *************************************************************************/
	private Grades findGradebyID(String ID)
	{
		/*-----------------------------------------------------------------------
		 * findGradebyID ()
		 * 	1. call Grades() �غcfoundGrade
		 *	2. for aList����
		 *		1. if ID equal to Grades ID
		 *			Grades����ID���Z
		 *			break
		 *	 end for
		 *			
		 *	3. �^�� foundGrade
		 *-----------------------------------------------------------------------*/
		Grades foundGrade = null; 
		for(Grades gradeItem : aList)
		{
			if( gradeItem.ID.equals(ID) )
			{
				foundGrade = gradeItem;
				break;
			}
		}
		return foundGrade;
	}
	
	/************************************************************************* 
	 showGrade(ID) ��ܳo ID �� grade
	 
	 @parameter	ID �Ǹ��C��: 955002056
	 Time		O(n) n �� aGradeSystem �����Z�H��
	 *************************************************************************/
	
	public void showGrade(String ID) {
		/*-----------------------------------------------------------------------
		 * showGrade ()
		 *	1. call Grades() �غcaGrade
		 *	2. aGrade = findGradebyID(ID)
		 *	3. �ù���ܦ�ID�����Z
		 *-----------------------------------------------------------------------*/
		Grades aGrade = findGradebyID(ID);		
		System.out.print(aGrade.name+"���Z�G\t lab1�G\t "+aGrade.lab1+" \r\n\t lab2�G\t "+ aGrade.lab2+" \r\n\t lab3�G\t "+aGrade.lab3+" \r\n\t mid-term : \t "+aGrade.midTerm+" \r\n\t final exam�G\t "+aGrade.finalExam+" \r\n\t total grade : \t "+aGrade.totalGrade+"\r\n" );
		
	}

	/*************************************************************************
	 showRank(ID) ��ܳoID���ƦW
	 
	 @parameter	ID �Ǹ��C��: 955002056
	 @return 	int �ƦW
	 Time		O(n) n �� aGradeSystem �����Z�H��
	 *************************************************************************/
	public int showRank(String ID)  
	{
		/*-----------------------------------------------------------------------
		 * showRank  
		 *	1. ���o�o ID �� theTotalGrade
		 *	2. �Orank �� 1 
		 *	3. loop aGrade in aList if aTotalGrade > theTotalGrade then rank�[1(�h1�W) end loop
		 *	4. �^�� rank
		 *-----------------------------------------------------------------------*/
		Grades aGrade = findGradebyID(ID);
		int aTotalGrade = aGrade.totalGrade;
		int rank = 1;
		
		for(Grades gradeItem : aList)
			if( aTotalGrade > gradeItem.totalGrade )
				rank++;
		
		System.out.print(aGrade.name+"�ƦW��"+rank+"\r\n");
		return rank;
	}
	
	/*************************************************************************
	 updateWeights () ��s�t��
	 
	 Time 		O(n) n �� aGradeSystem �����Z�H��
	 *************************************************************************/ 
	public void updateWeights() 
	{
		/*----------------------------------------------------------------------- 
		 * updateWeights
		 *	1. showOldWeights() 
		 *	2. getNewWeights() 
		 *	3. setWeights(weights)
		 *  4. loop aGrade in aList to calculateTotalGrade(weights) end loop
		 *-----------------------------------------------------------------------*/
		showOldWeights(); 
		float[] newWeights = getNewWeights(); 
		setWeights(newWeights);
		for(Grades gradeItem : aList)
			gradeItem.totalGrade = gradeItem.calculateTotalGrade(weights);
		
	}
	/*************************************************************************
	 showOldWeights () ����°t��
	 
	 Time		O(1)
	 *************************************************************************/ 
	private void showOldWeights() 
	{
		/*----------------------------------------------------------------------- 
		 * showOldWeights
		 *	1. �ù���� "�°t��"
		 *	2. loop �ù���ܦU���Z�t�� end loop
		 *-----------------------------------------------------------------------*/
		System.out.print("�°t�� \r\n");
		
		String[] printString= new String[]{"\tlab1\t\t","\tlab2\t\t","\tlab3\t\t","\tmid-term\t","\tfinal exam\t"};
		 
		for(int i=0 ; i<5 ; i++)
			 System.out.print(printString[i] + String.format("%d%%\r\n",(int)(weights[i]*100))); 	 
		 
	}
	
	/*************************************************************************
	 getNewWeights () �V�ϥΪ̮����s�t��
	 
	 @return 	float[] �s�t��
	 Time		O(1)
	 *************************************************************************/	 
	private float[] getNewWeights()
	{
		/*----------------------------------------------------------------------- 
		 * getNewWeights
		 *	1. while �t�������T
		 *      ��J�Ӧ��Z�s�t��
		 *		�߰ݰt���O�_���T
		 *		end while
		 *	2.�^�� newWeights
		 *-----------------------------------------------------------------------*/
		 float[] newWeights= new float[5];
		 String[] printString= new String[]{"\tlab1\t\t","\tlab2\t\t","\tlab3\t\t","\tmid-term\t","\tfinal exam\t"};
		 
		 Scanner scanInput = new Scanner(System.in);
		 Boolean reEnter = true;
		 while (reEnter)
		 {
			 System.out.print("��J�s�t��\r\n");	
			 for(int i=0 ; i<5 ; i++)
			 {
				 System.out.print(printString[i]);
				 newWeights[i] = Float.parseFloat(scanInput.nextLine())/100;		 
			 }
			 if(newWeights[0]+newWeights[1]+newWeights[2]+newWeights[3]+newWeights[4]==1)
			 {
				 System.out.print("�нT�{�s�t��\r\n");
				 for(int i=0 ; i<5 ; i++)
					 System.out.print(printString[i] + String.format("%d%%\r\n",(int)(newWeights[i]*100))); 	 
				 
				 System.out.print("�H�W���T��? Y (Yes) �� N (No)");
				 String inputCommand = scanInput.nextLine().toUpperCase();
				 if(inputCommand.equals("Y"))
				 	 reEnter = false;
			 }
			 else
				 System.out.print("�t����ҿ��~!\r\n");
			 		
		 }
		return newWeights;
	}
		
	/**
	 * setWeights () ��sweights�ܼ� Time		O(1)
	 * @uml.property  name="weights"
	 */	
	private void setWeights(float[] weights)
	{
		/*----------------------------------------------------------------------- 
		 * setWeights
		 *	1.�]�w�s��weights��
		 *-----------------------------------------------------------------------*/
		this.weights = weights;
	}
	     
	/*************************************************************************
	 containsID(ID) �� ID �O�_�t�b aGradeSystem��
	 
	 @parameter ID �Ǹ��C��: 955002056
	 @return 	Boolean�Ctrue:���]�t�Afalse:�S�]�t
	 Time		O(n) n �� aGradeSystem �����Z�H��
	 *************************************************************************/
	public Boolean containsID(String ID) 
	{
		/*----------------------------------------------------------------------- 
		 * containsID
		 *	1. if ID�s�b
		 *		�^�� true
		 *	2. else
		 *		�^��false
		 *-----------------------------------------------------------------------*/
		if( findGradebyID(ID) != null )
			return true;
		else
			return false;
	}

}
