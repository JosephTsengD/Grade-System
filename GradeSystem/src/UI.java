import java.util.Scanner;

/*************************************************************************
 class UI (user interface) 
	checkID(ID)			ID驗證
	promptCommand()		選單使用介面
	promptID()			輸入ID介面
	showFinishMsg()		顯示結束訊息
	showWelcomeMsg()	顯示歡迎訊息
	UI() 				建構子，建構 aGradeSystem
 *************************************************************************/
public class UI {
	
	/**
	 * @uml.property  name="aGradeSystem"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public GradeSystems aGradeSystem;
	/**
	 * @uml.property  name="aID"
	 */
	public String aID;
	
	/*************************************************************************
	 UI() 使用者介面
	 	
	 Time 		O(n) n 為 aGradeSystem 內全班人數
	 *************************************************************************/		
	public UI() throws NoSuchIDExceptions, NoSuchCommandExceptions
	{
		/*-----------------------------------------------------------------------
		 * 	UI()
		 *  try
		 * 	1. call GradeSystems() to 建構 aGradeSystem
		 * 	2. loop1 until Q (Quit)
		 * 		1.	promptID() to get user ID  輸入ID或 Q (結束使用)？ 
		 * 		2.	checkID (ID) 看 ID 是否在 aGradeSystem內
		 * 		3.	showWelcomeMsg (ID)	ex. Welcome李威廷
		 * 		4.	loop2 until E (Exit)
		 * 				promptCommand() to prompt for inputCommand 
		 * 	    end loop2
		 *     end loop1
		 *  3. showFinishMsg()	 結束了
		 *  end try
		 *  finally {}
		 *-----------------------------------------------------------------------*/
		try{
			aGradeSystem = new GradeSystems();						
			while(promptID())
			{
				checkID(aID);
				showWelcomeMsg(aID);
				while(promptCommand());				
			}
			showFinishMsg();
		}
		catch(NoSuchIDExceptions e1){System.out.print("ID錯了!\r\n");}
		catch(NoSuchCommandExceptions e2){System.out.print("指令錯了!\r\n");}
		finally {}	
	}
	
	/*************************************************************************
	 UI(Boolean forTestingUseOnly) 使用者介面
	 @note		提供測試時使用的建構子									   
	 
	 @parameter	forTestingUseOnly。在測試時傳入true，來初始UI class
	 Time 		O(n) n 為 aGradeSystem 內全班人數
	 *************************************************************************/		
	public UI(Boolean forTestingUseOnly) 
	{
		aGradeSystem = new GradeSystems();							
	}
	

	/*************************************************************************
	 checkID (ID) ID驗證
	 
	 @parameter	ID 學號。例: 123456789
	 @return	Boolean
	 @throws 	NoSuchIDExceptions
	 Time		O(n)  n 為 aGradeSystem 內全班人數
	*************************************************************************/	
	public Boolean checkID(String ID) throws NoSuchIDExceptions
	{
		/*-----------------------------------------------------------------------
		 * checkID (ID)
		 * 1. 要aGradeSystem 做containsID(ID) 看 ID 是否含在 aGradeSystem內
		 * 2. if not, throw an object of NoSuchIDExceptions
		 * 3. 回傳 true 
		 *-----------------------------------------------------------------------*/
		if(!aGradeSystem.containsID(ID))
			throw new NoSuchIDExceptions();
		return true;
	}

	
	/*************************************************************************
	 promptCommand() 選單使用介面
	 
	 @return	Boolean。true:繼續執行其他指令，false:離開系統
	 Time		O(n) n 為 aGradeSystem 內全班人數
	 *************************************************************************/	
	public Boolean promptCommand() throws NoSuchCommandExceptions
	{
		/*-----------------------------------------------------------------------
		 * promptCommand()
		 * 1. prompt user for inputCommand
		 * 2. if inputCommand is not G (Grade),R (Rank), W (Weights), or E (Exit),
		 *    throws an object of NoSuchCommandException
		 * 3. if inputCommand is E (Exit) then break
		 *    else: G aGradeSystem.showGrade(ID), R showRank(ID), W updateWeights()
		 *    end if
		 *-----------------------------------------------------------------------*/
		String message = "\r\n 輸入指令\t 1) G 顯示成績 (Grade) " +
						 "\r\n\t 2) R 顯示排名 (Rank) " +
						 "\r\n\t 3) W 更新配分 (Weight) " +
						 "\r\n\t 4) E 離開選單 (Exit) " +
						 "\r\n";  
		System.out.print(message);
		
		Scanner scanInput = new Scanner(System.in);
		String inputCommand = scanInput.nextLine().toUpperCase();
		
		if( !inputCommand.equals("G") && !inputCommand.equals("R") && !inputCommand.equals("W") && !inputCommand.equals("E"))
			throw new NoSuchCommandExceptions();			

		if(inputCommand.equals("E"))
			return false;
		else if(inputCommand.equals("G"))
			aGradeSystem.showGrade(aID);
		else if(inputCommand.equals("R"))
			aGradeSystem.showRank(aID);
		else if(inputCommand.equals("W"))
			aGradeSystem.updateWeights();

		return true;
	}
	
	
	/*************************************************************************
	 promptID() 輸入ID介面
	 
	 @return	Boolean。true:輸入的為ID，false:輸入的為Q
	 Time		O(1)
	 *************************************************************************/		
	public Boolean promptID() 
	{
		/*-----------------------------------------------------------------------
		 * promptID() 
		 * 1. prompt user for ID Q (結束使用)
		 * 2. if inputCommand is Q (Exit) then 回傳 false
		 *    else: 設定aID為輸入的ID，回傳 true
		 *    end if
		 *-----------------------------------------------------------------------*/
		String message = "輸入ID或 Q (結束使用)？\r\n";
		System.out.print(message);
		
		Scanner scanInput = new Scanner(System.in);
		String inputCommand = scanInput.nextLine().toUpperCase();
		if(inputCommand.equals("Q"))
		{
			return false;
		}
		else
		{
			aID = inputCommand;
			return true;
		}
	}
	
	
	/*************************************************************************
	 showFinishMsg() 顯示結束訊息
	 
	 Time		O(1)
	 *************************************************************************/	
 	public void showFinishMsg()
 	{
 		/*-----------------------------------------------------------------------
 		 * showFinishMsg()
 		 * 1. 印出結束訊息
 		 *-----------------------------------------------------------------------*/
 		String message = "結束了\r\n";
		System.out.print(message);
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
		 * findGradebyID(String ID)
		 * 1. 宣告foundGrade儲存找到的Grades Object，初始為null
		 * 2. loop 在aGradeSystem.aList的每一筆
		 * 		 if 傳入的ID為要尋找的ID, then 將此Grade記錄到foundGrade，跳出loop
		 * 		 end if	
		 * 	  end loop
		 * 3. 回傳foundGrade
		 *-----------------------------------------------------------------------*/
		Grades foundGrade = null; 
		GradeSystems aGradeSystem = new GradeSystems();
		for(Grades gradeItem : aGradeSystem.aList)
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
	 showWelcomeMsg() 顯示歡迎訊息
	 
	 Time		O(1)
	 *************************************************************************/	
 	public void showWelcomeMsg(String ID) 
 	{
		/*-----------------------------------------------------------------------
		 * showWelcomeMsg()
		 * 1. 用findGradebyID尋找傳入ID的Grades Object
		 * 2. if 有找到Grades, then 印出歡迎訊息
		 *    end if 
		 *-----------------------------------------------------------------------*/
 		Grades aGrade = findGradebyID(ID);
 		if( aGrade != null )
 			System.out.print("Welcome " + aGrade.name + "\r\n");
 	}
	

}
