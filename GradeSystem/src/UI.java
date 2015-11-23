import java.util.Scanner;

/*************************************************************************
 class UI (user interface) 
	checkID(ID)			ID����
	promptCommand()		���ϥΤ���
	promptID()			��JID����
	showFinishMsg()		��ܵ����T��
	showWelcomeMsg()	����w��T��
	UI() 				�غc�l�A�غc aGradeSystem
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
	 UI() �ϥΪ̤���
	 	
	 Time 		O(n) n �� aGradeSystem �����Z�H��
	 *************************************************************************/		
	public UI() throws NoSuchIDExceptions, NoSuchCommandExceptions
	{
		/*-----------------------------------------------------------------------
		 * 	UI()
		 *  try
		 * 	1. call GradeSystems() to �غc aGradeSystem
		 * 	2. loop1 until Q (Quit)
		 * 		1.	promptID() to get user ID  ��JID�� Q (�����ϥ�)�H 
		 * 		2.	checkID (ID) �� ID �O�_�b aGradeSystem��
		 * 		3.	showWelcomeMsg (ID)	ex. Welcome���§�
		 * 		4.	loop2 until E (Exit)
		 * 				promptCommand() to prompt for inputCommand 
		 * 	    end loop2
		 *     end loop1
		 *  3. showFinishMsg()	 �����F
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
		catch(NoSuchIDExceptions e1){System.out.print("ID���F!\r\n");}
		catch(NoSuchCommandExceptions e2){System.out.print("���O���F!\r\n");}
		finally {}	
	}
	
	/*************************************************************************
	 UI(Boolean forTestingUseOnly) �ϥΪ̤���
	 @note		���Ѵ��ծɨϥΪ��غc�l									   
	 
	 @parameter	forTestingUseOnly�C�b���ծɶǤJtrue�A�Ӫ�lUI class
	 Time 		O(n) n �� aGradeSystem �����Z�H��
	 *************************************************************************/		
	public UI(Boolean forTestingUseOnly) 
	{
		aGradeSystem = new GradeSystems();							
	}
	

	/*************************************************************************
	 checkID (ID) ID����
	 
	 @parameter	ID �Ǹ��C��: 123456789
	 @return	Boolean
	 @throws 	NoSuchIDExceptions
	 Time		O(n)  n �� aGradeSystem �����Z�H��
	*************************************************************************/	
	public Boolean checkID(String ID) throws NoSuchIDExceptions
	{
		/*-----------------------------------------------------------------------
		 * checkID (ID)
		 * 1. �naGradeSystem ��containsID(ID) �� ID �O�_�t�b aGradeSystem��
		 * 2. if not, throw an object of NoSuchIDExceptions
		 * 3. �^�� true 
		 *-----------------------------------------------------------------------*/
		if(!aGradeSystem.containsID(ID))
			throw new NoSuchIDExceptions();
		return true;
	}

	
	/*************************************************************************
	 promptCommand() ���ϥΤ���
	 
	 @return	Boolean�Ctrue:�~������L���O�Afalse:���}�t��
	 Time		O(n) n �� aGradeSystem �����Z�H��
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
		String message = "\r\n ��J���O\t 1) G ��ܦ��Z (Grade) " +
						 "\r\n\t 2) R ��ܱƦW (Rank) " +
						 "\r\n\t 3) W ��s�t�� (Weight) " +
						 "\r\n\t 4) E ���}��� (Exit) " +
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
	 promptID() ��JID����
	 
	 @return	Boolean�Ctrue:��J����ID�Afalse:��J����Q
	 Time		O(1)
	 *************************************************************************/		
	public Boolean promptID() 
	{
		/*-----------------------------------------------------------------------
		 * promptID() 
		 * 1. prompt user for ID Q (�����ϥ�)
		 * 2. if inputCommand is Q (Exit) then �^�� false
		 *    else: �]�waID����J��ID�A�^�� true
		 *    end if
		 *-----------------------------------------------------------------------*/
		String message = "��JID�� Q (�����ϥ�)�H\r\n";
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
	 showFinishMsg() ��ܵ����T��
	 
	 Time		O(1)
	 *************************************************************************/	
 	public void showFinishMsg()
 	{
 		/*-----------------------------------------------------------------------
 		 * showFinishMsg()
 		 * 1. �L�X�����T��
 		 *-----------------------------------------------------------------------*/
 		String message = "�����F\r\n";
		System.out.print(message);
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
		 * findGradebyID(String ID)
		 * 1. �ŧifoundGrade�x�s��쪺Grades Object�A��l��null
		 * 2. loop �baGradeSystem.aList���C�@��
		 * 		 if �ǤJ��ID���n�M�䪺ID, then �N��Grade�O����foundGrade�A���Xloop
		 * 		 end if	
		 * 	  end loop
		 * 3. �^��foundGrade
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
	 showWelcomeMsg() ����w��T��
	 
	 Time		O(1)
	 *************************************************************************/	
 	public void showWelcomeMsg(String ID) 
 	{
		/*-----------------------------------------------------------------------
		 * showWelcomeMsg()
		 * 1. ��findGradebyID�M��ǤJID��Grades Object
		 * 2. if �����Grades, then �L�X�w��T��
		 *    end if 
		 *-----------------------------------------------------------------------*/
 		Grades aGrade = findGradebyID(ID);
 		if( aGrade != null )
 			System.out.print("Welcome " + aGrade.name + "\r\n");
 	}
	

}
