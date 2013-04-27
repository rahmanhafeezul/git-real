import java.util.*;
 import java.io.*;
public class LZW {
	public String readTextFile(String filename)
	{String returnValue="";
	FileReader file=null;
	String line="";
	try{
		file=new FileReader(filename);
		BufferedReader reader=new BufferedReader(file);
		while((line=reader.readLine())!=null){
			returnValue+=line+"\n";
		}
		}catch(FileNotFoundException e){
			throw new RuntimeException("File not found");
	}catch(IOException e){
		throw new RuntimeException("IO Error occured");
		
	}finally{
		if(file!=null){
			try{
				file.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}return returnValue;
	}
    /** Compress a string to a list of output symbols. */
    public static List<Integer> compress(String uncompressed) {
        // Build the dictionary.
        int dictSize = 256;
	int m=prime(54+uncompressed.length());
	System.out.println(m);
	Node[] hashtable=new Node[m];
	for(int g=0;g<m;g++)
	{
		hashtable[g]=new Node();
		
	}
        Map<String,Integer> dictionary = new HashMap<String,Integer>();
        for (int i = 65; i <= 90; i++)
            dictionary.put("" + (char)i, i);
 		//LZW.put("" + Character.toString((char)i), i,hashtable);
	for (int j = 97; j < 122; j++)
		dictionary.put("" + (char)j, j);
		//LZW.put("" + Character.toString((char)j), j,hashtable);
	//for(int b=0;b<89;b++)
		//LZW.put("" + Character.toString((char)b), b,hashtable);
		//System.out.println(hashtable[b].key+" "+hashtable[b].code);
        String w = "";
        List<Integer> result = new ArrayList<Integer>();
        for (char c : uncompressed.toCharArray()) {
            String wc = w + c;
            if (LZW.containsKey(wc,hashtable))
                w = wc;
            else {
                //result.add(dictionary.get(w));
		result.add(LZW.get(w,hashtable));
                // Add wc to the dictionary.
                //dictionary.put(wc, dictSize++);
		LZW.put(wc,dictSize++,hashtable);
                w = "" + c;
            }
        }
 
        // Output the code for w.
        if (!w.equals(""))
            result.add(LZW.get(w,hashtable));
        return result;
    }
 
 /**   
    public static String decompress(List<Integer> compressed) {
        // Build the dictionary.
        int dictSize = 256;
	
        Map<Integer,String> dictionary = new HashMap<Integer,String>();
        for (int i = 0; i < 256; i++)
            dictionary.put(i, "" + (char)i);
 
        String w = "" + (char)(int)compressed.remove(0);
        String result = w;
        for (int k : compressed) {
            String entry;
            if (dictionary.containsKey(k))
                entry = dictionary.get(k);
            else if (k == dictSize)
                entry = w + w.charAt(0);
            else
                throw new IllegalArgumentException("Bad compressed k: " + k);
 
            result += entry;
 
            // Add w+entry[0] to the dictionary.
            dictionary.put(dictSize++, w + entry.charAt(0));
 
            w = entry;
        }
        return result;
    }*/
 
    public static void main(String[] args)throws IOException {
	LZW myfile=new LZW();
	System.out.println("Please enter the text file that you want to compress::");
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	String file=br.readLine();
		String input=myfile.readTextFile(file);
	
        List<Integer> compressed = compress(input);
        System.out.println(compressed);
        //String decompressed = decompress(compressed);
        //System.out.println(decompressed);
    }


public static int  prime(int k)
	{
		
		while(true)
		{
			if(rime(k))
				{return k;
				
				}
			else
				k++;
		}
	}
	
public static boolean rime(int n)
	{int c=0;
	
	for(int i=1;i<=n;i++)
		{
		if(n%i==0)
			c++;
		}
	if(c==2)
		return true;
	else 
		return false;
	}
	
public static void put(String ch,int i,Node[] hashtable)
{	int g=hashtable.length;
	
	int h=0;int o=0;
	while(o<g)
	{
		int j=i%g;
		if(hashtable[j].code==0)
			{
				hashtable[j].key=(ch);
				hashtable[j].code=i;
				return;
			}
		else
			{i=i+h*h;
			h++;o++;}
	}
}
public static boolean containsKey(String s,Node[] hashtable)
{	int g=hashtable.length;
	int h=0;
int i=0;
		for(int f=0;f<s.length();f++)
		{
			i+=(int)s.charAt(f);
}
	while(h<=g)
	{
		int j=i%g;
		if(hashtable[j].key==s)
			{
				return true;
				
			}
		else
			{i=i+h*h;
			h++;}
	}
		
return false;
}
public static int get(String s,Node[] hashtable)
	{int i=0;
		for(int f=0;f<s.length();f++)
		{
			i+=(int)s.charAt(f);
}
		int g=hashtable.length;
	int h=0;
	while(h<=g)
	{
		int j=i%g;
		if(hashtable[j].key==s)
			{
				return hashtable[j].code;
		
			}
		
			i=i+h*h;
			h++;
	
		
}
return 0;
}}

class Node{
String key;
int code;
Node()
{
key=null;
code=0;
}}
