import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


/***************************************************************************
 class GradeSystems 儲存 a list of student grades.
	GradeSystems() 		讀入成績檔，存入doubly-linked list
	showGrade(ID) 		顯示這 ID 的 grade
	showRank(ID) 		顯示這ID的排名
	updateWeights() 	更新配分
	containsID(ID) 		看 ID 是否含在 aGradeSystem內
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
	 GradeSystems() 讀入成績檔，存入doubly-linked list
	 
	 Time		O(n) n 為 aGradeSystem 內全班人數
	*************************************************************************/
	public GradeSystems ()
	{
		/*-----------------------------------------------------------------------
		 * GradeSystems ()
		 *	1. 開檔 input file 
		 *	2. 用Java LinkedList建構an empty list of grades叫 aList
		 *	3. read line
		 *	4. while not endOfFile
		 *		1.call Grades() 建構aGrade
		 *		2.用 Java Scanner 來 scan line 把各欄位存入aGrade
		 *		3. aGrade.calculateTotalGrade(weights) 回傳aTotalGrade把它存入aGrade
		 *		4. 把 aGrade 存入 aList
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
	 findGradebyID(ID) 尋找這 ID 的 Grades class
	 
	 @parameter	ID 學號。例: 955002056
	 @return 	Grades class
	 Time		O(n) n 為 aGradeSystem 內全班人數
	 *************************************************************************/
	private Grades findGradebyID(String ID)
	{
		/*-----------------------------------------------------------------------
		 * findGradebyID ()
		 * 	1. call Grades() 建構foundGrade
		 *	2. for aList長度
		 *		1. if ID equal to Grades ID
		 *			Grades為此ID成績
		 *			break
		 *	 end for
		 *			
		 *	3. 回傳 foundGrade
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
	 showGrade(ID) 顯示這 ID 的 grade
	 
	 @parameter	ID 學號。例: 955002056
	 Time		O(n) n 為 aGradeSystem 內全班人數
	 *************************************************************************/
	
	public void showGrade(String ID) {
		/*-----------------------------------------------------------------------
		 * showGrade ()
		 *	1. call Grades() 建構aGrade
		 *	2. aGrade = findGradebyID(ID)
		 *	3. 螢幕顯示此ID的成績
		 *-----------------------------------------------------------------------*/
		Grades aGrade = findGradebyID(ID);		
		System.out.print(aGrade.name+"成績：\t lab1：\t "+aGrade.lab1+" \r\n\t lab2：\t "+ aGrade.lab2+" \r\n\t lab3：\t "+aGrade.lab3+" \r\n\t mid-term : \t "+aGrade.midTerm+" \r\n\t final exam：\t "+aGrade.finalExam+" \r\n\t total grade : \t "+aGrade.totalGrade+"\r\n" );
		
	}

	/*************************************************************************
	 showRank(ID) 顯示這ID的排名
	 
	 @parameter	ID 學號。例: 955002056
	 @return 	int 排名
	 Time		O(n) n 為 aGradeSystem 內全班人數
	 *************************************************************************/
	public int showRank(String ID)  
	{
		/*-----------------------------------------------------------------------
		 * showRank  
		 *	1. 取得這 ID 的 theTotalGrade
		 *	2. 令rank 為 1 
		 *	3. loop aGrade in aList if aTotalGrade > theTotalGrade then rank加1(退1名) end loop
		 *	4. 回傳 rank
		 *-----------------------------------------------------------------------*/
		Grades aGrade = findGradebyID(ID);
		int aTotalGrade = aGrade.totalGrade;
		int rank = 1;
		
		for(Grades gradeItem : aList)
			if( aTotalGrade > gradeItem.totalGrade )
				rank++;
		
		System.out.print(aGrade.name+"排名第"+rank+"\r\n");
		return rank;
	}
	
	/*************************************************************************
	 updateWeights () 更新配分
	 
	 Time 		O(n) n 為 aGradeSystem 內全班人數
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
	 showOldWeights () 顯示舊配分
	 
	 Time		O(1)
	 *************************************************************************/ 
	private void showOldWeights() 
	{
		/*----------------------------------------------------------------------- 
		 * showOldWeights
		 *	1. 螢幕顯示 "舊配分"
		 *	2. loop 螢幕顯示各成績配分 end loop
		 *-----------------------------------------------------------------------*/
		System.out.print("舊配分 \r\n");
		
		String[] printString= new String[]{"\tlab1\t\t","\tlab2\t\t","\tlab3\t\t","\tmid-term\t","\tfinal exam\t"};
		 
		for(int i=0 ; i<5 ; i++)
			 System.out.print(printString[i] + String.format("%d%%\r\n",(int)(weights[i]*100))); 	 
		 
	}
	
	/*************************************************************************
	 getNewWeights () 向使用者拿取新配分
	 
	 @return 	float[] 新配分
	 Time		O(1)
	 *************************************************************************/	 
	private float[] getNewWeights()
	{
		/*----------------------------------------------------------------------- 
		 * getNewWeights
		 *	1. while 配分不正確
		 *      輸入個成績新配分
		 *		詢問配分是否正確
		 *		end while
		 *	2.回傳 newWeights
		 *-----------------------------------------------------------------------*/
		 float[] newWeights= new float[5];
		 String[] printString= new String[]{"\tlab1\t\t","\tlab2\t\t","\tlab3\t\t","\tmid-term\t","\tfinal exam\t"};
		 
		 Scanner scanInput = new Scanner(System.in);
		 Boolean reEnter = true;
		 while (reEnter)
		 {
			 System.out.print("輸入新配分\r\n");	
			 for(int i=0 ; i<5 ; i++)
			 {
				 System.out.print(printString[i]);
				 newWeights[i] = Float.parseFloat(scanInput.nextLine())/100;		 
			 }
			 if(newWeights[0]+newWeights[1]+newWeights[2]+newWeights[3]+newWeights[4]==1)
			 {
				 System.out.print("請確認新配分\r\n");
				 for(int i=0 ; i<5 ; i++)
					 System.out.print(printString[i] + String.format("%d%%\r\n",(int)(newWeights[i]*100))); 	 
				 
				 System.out.print("以上正確嗎? Y (Yes) 或 N (No)");
				 String inputCommand = scanInput.nextLine().toUpperCase();
				 if(inputCommand.equals("Y"))
				 	 reEnter = false;
			 }
			 else
				 System.out.print("配分比例錯誤!\r\n");
			 		
		 }
		return newWeights;
	}
		
	/**
	 * setWeights () 更新weights變數 Time		O(1)
	 * @uml.property  name="weights"
	 */	
	private void setWeights(float[] weights)
	{
		/*----------------------------------------------------------------------- 
		 * setWeights
		 *	1.設定新的weights值
		 *-----------------------------------------------------------------------*/
		this.weights = weights;
	}
	     
	/*************************************************************************
	 containsID(ID) 看 ID 是否含在 aGradeSystem內
	 
	 @parameter ID 學號。例: 955002056
	 @return 	Boolean。true:有包含，false:沒包含
	 Time		O(n) n 為 aGradeSystem 內全班人數
	 *************************************************************************/
	public Boolean containsID(String ID) 
	{
		/*----------------------------------------------------------------------- 
		 * containsID
		 *	1. if ID存在
		 *		回傳 true
		 *	2. else
		 *		回傳false
		 *-----------------------------------------------------------------------*/
		if( findGradebyID(ID) != null )
			return true;
		else
			return false;
	}

}
