public class RPNcalc1
	{
		private String input;
		public RPNcalc1(String i)
		{
			input=i;
		}
		public void calcu()
		{
			int arraySize=input.length();
			Stack s=new Stack(arraySize);
			int t=0;
			for(int j=0;j<input.length();j++)
			{
			char ch=input.charAt(j);
			switch(ch)
			{
			case'+':s.push((int)s.pop()+(int)s.pop());break;
			case'-':s.push(((int)s.pop()-(int)s.pop())*(-1));break;
			case'*':s.push((int)s.pop()*(int)s.pop());
				break;
			case' ':s.push(0);break;

			case '1':case '2':case '3':case '4':case'5':case'6':case'7':case'8':case'9':case'0':if(t==0)
					{s.push((int)ch-48);t++;break;
					}
				if((s.top()!=0)||(t!=0))
					{s.push((int)(s.pop())*10+((int)ch-48));break;
					}
				if(s.top()==0)
					{s.pop();
					s.push((int)ch-48);}
			}
			}
			
			System.out.println(s.pop());
			if(!s.isEmpty())
			{System.out.println("error");
			}
	}
	}	
