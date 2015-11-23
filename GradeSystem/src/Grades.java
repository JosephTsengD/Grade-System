/************************************************************************
 class Grades 儲存 ID, name, lab1, lab2, lab3, midTerm, finalExam, and totalGrade
	Grades()  	建構子
	calculateTotalGrade(weights)	計算總成績
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
	 Grades( String[] aData ) 初始 Grade class
	 @note		提供測試時使用的建構子
	 
	 @parameter aData陣列。依序放入name、ID、lab1、lab2、lab3、midTerm、finalExam
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
	 calculateTotalGrade() 計算總成績
	 
	 @parameter	wights 每項配分,依序是lab1, lab2, lab3, midTerm, finalExam。例: 0.1f,0.1f,0.1f,0.3f,0.4f
	 @return	int 總成績
	 Time		O(1)
	 *************************************************************************/	
	public int calculateTotalGrade(float[] weights) {
		//將每項成績跟對應的weights相乘加總，四捨五入後放入aTotalGrade
		int aTotalGrade = Math.round(lab1*weights[0] + lab2*weights[1] + lab3*weights[2] + midTerm*weights[3] + finalExam*weights[4]);
		return aTotalGrade;
	}

}
