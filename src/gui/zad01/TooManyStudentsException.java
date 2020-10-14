package gui.zad01;

public class TooManyStudentsException extends Exception
{
	private static final long serialVersionUID = 1L;
	public TooManyStudentsException()
	{
		System.out.println("Za dużo studentów w grupie!");
	}
}
