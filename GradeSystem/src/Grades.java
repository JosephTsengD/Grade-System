/************************************************************************
 class Grades �x�s ID, name, lab1, lab2, lab3, midTerm, finalExam, and totalGrade
	Grades()  	�غc�l
	calculateTotalGrade(weights)	�p���`���Z
 ************************************************************************/
public class Grades {
	/**
	 * @uml.property  name="name"
	 */
	String name;
	/**
	 * @uml.property  name="iD"
	 */
	String ID; 
	/**
	 * @uml.property  name="lab1"
	 */
	int lab1;
	/**
	 * @uml.property  name="lab2"
	 */
	int lab2;
	/**
	 * @uml.property  name="lab3"
	 */
	int lab3;
	/**
	 * @uml.property  name="midTerm"
	 */
	int midTerm;
	/**
	 * @uml.property  name="finalExam"
	 */
	int finalExam;
	/**
	 * @uml.property  name="totalGrade"
	 */
	int totalGrade;
	
	public Grades(){}

	/*************************************************************************
	 Grades( String[] aData ) ��l Grade class
	 @note		���Ѵ��ծɨϥΪ��غc�l
	 
	 @parameter aData�}�C�C�̧ǩ�Jname�BID�Blab1�Blab2�Blab3�BmidTerm�BfinalExam
	 Time		O(1)
	 *************************************************************************/	
	public Grades( String[] aData ) {
		name = aData[0];
		ID =  aData[1];
		lab1 = Integer.parseInt( aData[2] );
		lab2 = Integer.parseInt( aData[3] );
		lab3 = Integer.parseInt( aData[4] );
		midTerm = Integer.parseInt( aData[5] );
		finalExam = Integer.parseInt( aData[6] );
		totalGrade = 0;
	}

	/*************************************************************************
	 calculateTotalGrade() �p���`���Z
	 
	 @parameter	wights �C���t��,�̧ǬOlab1, lab2, lab3, midTerm, finalExam�C��: 0.1f,0.1f,0.1f,0.3f,0.4f
	 @return	int �`���Z
	 Time		O(1)
	 *************************************************************************/	
	public int calculateTotalGrade(float[] weights) {
		//�N�C�����Z�������weights�ۭ��[�`�A�|�ˤ��J���JaTotalGrade
		int aTotalGrade = Math.round(lab1*weights[0] + lab2*weights[1] + lab3*weights[2] + midTerm*weights[3] + finalExam*weights[4]);
		return aTotalGrade;
	}

}
