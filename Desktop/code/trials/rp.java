import java.io.*;
public class rp
{	String output;
public static void main(String[] args)throws IOException
	{
		String input;
		while(true)
		{
			System.out.println("enter the expression to be calculated");
			InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader keybd=new BufferedReader(isr);
			input=keybd.readLine();
			if(input.equals(""))
			break;
		heya theTrans = new heya(input);
      String output = theTrans.doTrans(input); 
			
		Calc thecalc=new Calc(input);
		thecalc.calcu();
		}
	}
}
	
