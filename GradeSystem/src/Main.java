
/** ##################################################################
  ��Grade system ���ϥΪ�(�ǥ�)���o�L���`���Ztotal grade �αƦW rank.
 
	Total grade ���t��weights �Ӻ� �� weights�i�Hupdate. 
	Rank ��ܦ� total grade �b���Z�ǥͪ����ƱƧ�

	Input file: ���Z�ǥͪ����� 	
		�Ҧp:	962001044 ��v�� 87 86 98 88 87
				962001051 ���§� 81 98 84 90 93
              �`�N data field names �p�U: 
          		ID  name  lab1  lab2  lab3  midTerm  finalExam
#################################################################### */
public class Main extends Object {
	
	public static void main (String args[]) throws NoSuchCommandExceptions 
	{
		/*-----------------------------------------------------------------------
		 * main (String args[]) throws NoSuchCommandExceptions 
		 *    try { call UI() �غc aUI } 
		 *    end try
		 *    catch (NoSuchIDExceptions e1) {print ID���~��T} 
		 *    catch (NoSuchCommandExceptions e2) {print  ���O���~��T}
		 *-----------------------------------------------------------------------*/		
		try{		
			UI aUI = new UI();
		}
		catch (NoSuchIDExceptions e1) {
			System.out.print("ID���F!\r\n");
		} 
		catch (NoSuchCommandExceptions e2) {
			System.out.print("���O���F!\r\n");
		}				
	}	
}

