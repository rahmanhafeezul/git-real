import java.io.*;
public class yo
{	public static void main(String[] args)throws IOException
	{
		String input;
		while(true)
		{
			System.out.println("enter the expression to be calculated");
			input=acceptString();
			if(input.equals(""))
			break;
		RPNcalc1 thecalc=new RPNcalc1(input);
		thecalc.calcu();
		}
	}

	public static String acceptString()throws IOException
	{InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader keybd=new BufferedReader(isr);
		String s=keybd.readLine();
		return s;
	}
}
