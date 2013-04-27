import java.util.*;
 class Test
{public static void main(String[] args)

	{Scanner s= new Scanner(System.in);
	Vector<Integer> v= new Vector<Integer>();
	while(s.hasNextInt())
	{v.add(s.nextInt());
	}
	Iterator<Integer> it=v.iterator();
System.out.println(v.get(0));
	while(it.hasNext())
	{if(it.next()!=42 )
		
		System.out.println(it.next());
	
else 
break;
	}
}}
	











	
