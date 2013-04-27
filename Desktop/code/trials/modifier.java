import java.io.*;
public class modifier
	
	{
		public static void main(String[] args)throws IOException
		{int i;
			BufferedReader keybd=new BufferedReader(new InputStreamReader(System.in));
			String input=keybd.readLine();
			String output="";
			for(i=0;i<input.length()-1;i++)
			{
				char ch=input.charAt(i);
				char j=input.charAt(i+1);
				
				int a=(int)ch;
				int b=(int)j;
				if(((a<=57)&&(a>=48))&&((j<=57)&&(j>=48)))
					output=output+Character.toString(ch);
				if(((a<=57)&&(a>=48))&&(j==32))
					output=output+Character.toString(ch);
				if((a==32)&&((j<=57)&&(j>=48)))
					output=output+Character.toString(ch);
				if((a==32)&&((j<=45)&&(j>=42)))
					output=output+" ";
				if(((a<=45)&&(a>=42))&&(j==32))
					output=output+Character.toString(ch);
				if(((a<=45)&&(a>=42))&&((j<=45)&&(j>=42)))
					output=output+Character.toString(ch);
				if(((a<=57)&&(a>=48))&&((j<=45)&&(j>=42)))
					output=output+Character.toString(ch)+" ";
				if(((a<=57)&&(a>=48))&&((j<=45)&&(j>=42))&&(i==input.length()-2));
					output=output+Character.toString(ch)+" "+Character.toString(j);
				}
					
					
				System.out.println(output);
}}
