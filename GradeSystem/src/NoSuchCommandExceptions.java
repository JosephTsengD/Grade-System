/*************************************************************************
 NoSuchCommandExceptions() 	當輸入指令錯誤時，會進入此Exception
*************************************************************************/
public class NoSuchCommandExceptions extends Exception {
	
	public NoSuchCommandExceptions()
	{ 
		super("throw NoSuchCommandExceptions!");
	}
	public String getMessage()
    {
        return super.getMessage();
    }

}
