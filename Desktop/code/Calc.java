import java.io.*;
public class Calc
	{
		private String input;
		public Calc(String i)
		{
			input=i;
		}
		public void calcu()
		{
			int arraySize=input.length();
			stackx s=new stackx(arraySize);
			String c="";int y;
			for(int j=0;j<input.length();j++)
			{
			String ch=Character.toString(input.charAt(j));
			switch(ch)
			{
			case"+":s.push((int)s.pop()+(int)s.pop());break;
			case"-":s.push(((int)s.pop()-(int)s.pop())*(-1));break;
			case"*":s.push((int)s.pop()*(int)s.pop());
				break;
			case" ":y=Integer.parseInt(c);System.out.println(y);
				s.push(y);				
				break;
			default:c=ch;
				
			}
			}
			System.out.println(s.pop());
			if(!s.isEmpty())
			{System.out.println("error");
			}
	}
	}	
