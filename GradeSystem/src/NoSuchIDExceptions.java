/*************************************************************************
 NoSuchIDExceptions() 	當輸入不存在的ID時，會進入此Exception
*************************************************************************/
public class NoSuchIDExceptions extends Exception {
	
	public NoSuchIDExceptions()
	{ 
		super("throw NoSuchIDExceptions!");
	}
	public String getMessage()
    {
        return super.getMessage();
    }
}
