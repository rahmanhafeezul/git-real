public class lite
{
	public static void main(String[] args)
		{
			int[] c=new int[10];
			try{
				System.out.println(c[10]);
				}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("hi"+e.getCause());
			}
		}
	}
