import java.util.Scanner;
import java.io.*;

class Main
{
	public static void main(String[] args)
	{
		try
		{
			Scanner s = new Scanner(new File("Input.txt"));
			Scanner i = new Scanner(System.in);
			String str = new String();
			str=s.nextLine();
			System.out.println(str);
			trie t = new trie(str);
			String pattern = new String();
			String choice=new String("y");
			while(choice.equals("y") || choice.equals("Y"))
			{
				System.out.println("\nType the pattern you want to search in the file : ");
				pattern=i.nextLine();
				t.lookup(pattern);
				System.out.println("\nDo you want to search for other patterns? (Enter y for yes) : ");
				choice=i.nextLine();
				System.out.println("\n*************************************************************************\n");
			}
		}
		catch(FileNotFoundException e)
		{
			System.err.println("No File exists by that name!!");
		}
	}
}
