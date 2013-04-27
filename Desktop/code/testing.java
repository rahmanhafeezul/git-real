import java.io.*;
public class testing
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
		System.out.print("Enter an element to insert:::");
		AvlTree tree =new AvlTree();
		String input=br.readLine();
		if(input=="q")
			brek;
		}
		tree.inorder();
	}
}
