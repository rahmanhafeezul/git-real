import java.util.*;
import java.io.*;
public class company{
	static class Node1{
		Node1 lchild;
		Node1 rchild;
		int level;
		String name;
		String parentname;
		public Node1(String name,int level,String parentname){
			this.name=name;
			this.level=level;
			this.parentname=parentname;
		}
	}
	static class Node2{//general tree node
		Node2 parent;
		List<Node2> children;
		int level;
		String name;
		public Node2(String name,int level,List<Node2> children){
			this.name=name;
			this.level=level;
			this.children=children;
		}
	}
	public static void main(String args[])throws InvalidNodeException,IOException{
		List<Node2> l2 =new ArrayList();
		
		Node1 rootnode1=new Node1("Deepak",1,"CEO");
		Node2 rootnode2=new Node2("Deepak",1,l2);
		addEmployee(rootnode1,rootnode2,"Anuj","Deepak");
		addEmployee(rootnode1,rootnode2,"Abhishek","Anuj");
		addEmployee(rootnode1,rootnode2,"Saurabh","Anuj");
		addEmployee(rootnode1,rootnode2,"Alok","Anuj");
		addEmployee(rootnode1,rootnode2,"Mukesh","Saurabh");
		addEmployee(rootnode1,rootnode2,"Utkarsh","Saurabh");
		addEmployee(rootnode1,rootnode2,"Vineet","Saurabh");
		addEmployee(rootnode1,rootnode2,"Ojasvi","Abhishek");
		addEmployee(rootnode1,rootnode2,"Rohan","Abhishek");
		addEmployee(rootnode1,rootnode2,"Jessica","Deepak");
		addEmployee(rootnode1,rootnode2,"Harvey","Jessica");
		addEmployee(rootnode1,rootnode2,"Louis","Jessica");
		addEmployee(rootnode1,rootnode2,"Mike","Harvey");
		addEmployee(rootnode1,rootnode2,"Dona","Harvey");
		addEmployee(rootnode1,rootnode2,"Rachel","Dona");
		addEmployee(rootnode1,rootnode2,"Trent","Louis");
		addEmployee(rootnode1,rootnode2,"Norma","Louis");
		addEmployee(rootnode1,rootnode2,"Sheldon","Deepak");
		addEmployee(rootnode1,rootnode2,"Alex","Sheldon");
		addEmployee(rootnode1,rootnode2,"Amy","Sheldon");
		addEmployee(rootnode1,rootnode2,"Leonard","Sheldon");
		addEmployee(rootnode1,rootnode2,"Leslie","Sheldon");
		addEmployee(rootnode1,rootnode2,"Raj","Leonard");
		addEmployee(rootnode1,rootnode2,"Wolowitz","Raj");
		addEmployee(rootnode1,rootnode2,"Penny","Wolowitz");
		addEmployee(rootnode1,rootnode2,"Stuart","Raj");
		
		System.out.println("\n\n");
		display_functions(rootnode1,rootnode2);
	}
	public static void display_functions(Node1 rootnode1,Node2 rootnode2)throws InvalidNodeException,IOException{
		Scanner take_input=new Scanner(System.in);
		System.out.print("Please enter one of the follwing:::\n\n");
		System.out.print("1.AddEmployee name1 name2\n");
		System.out.print("\n");
		System.out.print("2.DeleteEmployee name1 name2\n ");
		
		System.out.print("\n");
		System.out.print("3.PrintEmployees\n");
		System.out.print("\n");
		System.out.print("4.LowestCommonBoss name1 name2\n\n");
		
		System.out.print("*******************************************************************************");
		System.out.print("\n");
		String keybd=take_input.nextLine();
		String input[]=keybd.split(" ");
try{		if (same(input[0],"AddEmployee")){
			if (input.length==3)
				{
					addEmployee(rootnode1,rootnode2,input[1],input[2]);
				
				display_functions(rootnode1,rootnode2);
			}
			else{
				System.out.print("\nPlease type-in 2 names \n");
				display_functions(rootnode1,rootnode2);
			}
		}
		else if (same(input[0],"DeleteEmployee")){
			if (input.length==3){
				System.out.print("Deleting the specimens............................................\n");
				deleteEmployee(rootnode1,rootnode2,input[1],input[2]);
				
				display_functions(rootnode1,rootnode2);
			}
			else{
                              System.out.print("\nPlease type-in 2 names \n");
                              display_functions(rootnode1,rootnode2);
                     }
		}
		else if (same(input[0],"PrintEmployees")){
			printEmployees(rootnode1,rootnode2);
			display_functions(rootnode1,rootnode2);
		}
		else if (same(input[0],"LowestCommonBoss")){
			if (input.length==3){
				common_boss(rootnode1,rootnode2,input[1],input[2]);
				display_functions(rootnode1,rootnode2);
			}
			else{
				System.out.print("\nPlease type-in 2 names \n");
				display_functions(rootnode1,rootnode2);
			}
		}
		else{
			display_functions(rootnode1,rootnode2);
		}}
	catch(InvalidNodeException e){}
	}
	public static void adding_employee(Node1 rootnode1,Node2 rootnode2,String f,String g)throws InvalidNodeException
		{addEmployee(rootnode1,rootnode2,(String)f,(String)g);}
		
	public static void printEmployees(Node1 rootnode1,Node2 rootnode2)throws InvalidNodeException,IOException{
		System.out.println("\nThe employees currently working in the company are::");
		System.out.println("The CEO of the company is ::  "+rootnode2.name);
		Stack<Node2> s1=new Stack();
		Stack<Node2> s2=new Stack();
		List<Node2> v=rootnode2.children;
		
		
		if (v.isEmpty()){
			System.out.print("*******************************************************************************\n");
			display_functions(rootnode1,rootnode2);
		}
		else{
			for (int i=0;i<v.size();i++){
				s1.push(v.get(i));
			}
			stacking(rootnode1,rootnode2,s1,s2);
		}
	}
	public static void stacking(Node1 rootnode1,Node2 rootnode2,Stack<Node2> s1,Stack<Node2> s2)throws InvalidNodeException,IOException{
	try{	if (s1.empty()==true && s2.empty()==true){
			System.out.print("*******************************************************************************\n");
			display_functions(rootnode1,rootnode2);
		}
		else if (s1.empty()==true){
			System.out.println("The members at the next level in the company hierarchy are:");
			while (s2.empty()!=true){
				
				Node2 node2=s2.pop();
				System.out.println("\t"+node2.name);
				List<Node2> v=node2.children;
              			for (int i=0;i<v.size();i++){
                        		s1.push(v.get(i));
                		}
			}
			stacking(rootnode1,rootnode2,s1,s2);
		}

		else if (s2.empty()==true){
			System.out.println("The members at the next level in the company hierarchy are:");
			while (s1.empty()!=true){
                                Node2 node2=s1.pop();
                           System.out.println("\t"+node2.name);
                                List<Node2> v=node2.children;
                                for (int i=0;i<v.size();i++){
                                        s2.push(v.get(i));
                                }
                        }
                        stacking(rootnode1,rootnode2,s1,s2);
			
		}}
	catch(InvalidNodeException e){}
	}
	public static void addEmployee(Node1 rootnode1,Node2 rootnode2,String name_new,String head_person)throws InvalidNodeException{
		
		int level2add=returnlevel(rootnode1,head_person)+1;
		inserttree1(rootnode1,name_new,level2add,head_person);
		Stack path=new Stack();
		path=trace(path,rootnode1,head_person);
		inserttree2(path,rootnode2,name_new,level2add,head_person);
		System.out.print(" Inserted  " + name_new + "  under  " + head_person + "\n");
	}
	public static void inserttree1(Node1 rootnode1,String name_new,int level,String head_person)throws InvalidNodeException{
try{		if (compare(rootnode1.name,name_new)==true){
			if (rootnode1.lchild!=null)
				inserttree1(rootnode1.lchild,name_new,level,head_person);
			else{
				rootnode1.lchild=new Node1(name_new,level,head_person);
			}
		}
		else{
			if (rootnode1.rchild!=null)
				inserttree1(rootnode1.rchild,name_new,level,head_person);
			else{
				rootnode1.rchild=new Node1(name_new,level,head_person);
			}
		}}
	catch(InvalidNodeException e){}
	}
	public static void inserttree2(Stack<String> path,Node2 rootnode2,String name_new,int level,String head_person)throws InvalidNodeException{
	try{	if (path.empty()){
			List<Node2> l=new ArrayList();
			Node2 newnode2=new Node2(name_new,level,l);
			newnode2.parent=rootnode2;
			(rootnode2.children).add(newnode2);
		}
		else if (path.size()==1){
			List<Node2> l=rootnode2.children;
			for (int i=0;i<l.size();i++){
				Node2 node2=l.get(i);
				if (node2.name==head_person){
					List<Node2> s=new ArrayList();
					Node2 newnode2=new Node2(name_new,level,s);
					node2.children.add(newnode2);
					newnode2.parent=node2;
				}
			}
		}		
		else{
			String m=path.pop();
			String peekname=path.peek();
			List<Node2> chillist=rootnode2.children;
			for (int i=0;i<chillist.size();i++){
				if (same(chillist.get(i).name,peekname))
					inserttree2(path,chillist.get(i),name_new,level,head_person);
			}
		}}
	catch(InvalidNodeException e){}
	}
	public static Stack trace(Stack path,Node1 rootnode1,String name)throws InvalidNodeException{
		if (same(rootnode1.name,name))
			return path;
		else{
			String newtofind=returnnode(rootnode1,name).parentname;
			path.push(newtofind);
			return trace(path,rootnode1,newtofind);
		}
	}
	public static boolean compare(String name1,String name2)throws InvalidNodeException{
		for (int i=0;;i++){
			char a=name1.charAt(i);
			char b=name2.charAt(i);
			if (a>b)
				return true;
			else if (a==b)
				continue;
			else
				return false;
		}
	}
	public static boolean same(String name1,String name2)throws InvalidNodeException{
		if (name1.length()!=name2.length())
			return false;
		else{
			for (int i=0;i<name1.length();i++){
				char a= name1.charAt(i);
				char b= name2.charAt(i);
				if (a==b)
					continue;
				else
					return false;
			}
			return true;
		}
	}
	public static void common_boss(Node1 rootnode1,Node2 rootnode2,String name1,String name2)throws InvalidNodeException{
		int lvl1=returnlevel(rootnode1,name1);
		int lvl2=returnlevel(rootnode1,name2);
	try{	if (lvl1>lvl2){
			for (int i=1;i<lvl2;i++){
				String parent1=ithparent(rootnode1,name2,i);
				String parent2=ithparent(rootnode1,name1,lvl1-lvl2+i);
				if (same(parent1,parent2)){
					System.out.println("The least common boss of " + name1 + " and " + name2 + " is " + parent1+"\n\n");
					break;
				}
				else
					continue;
			}
		}
		else{
			for (int i=1;i<lvl1;i++){
				String parent1=ithparent(rootnode1,name1,i);
				String parent2=ithparent(rootnode1,name2,lvl2-lvl1+i);
				if (same(parent1,parent2)){
					System.out.println("The least common boss of " + name1 + " and " + name2 + " is "+parent1+"\n\n"); 						break;
				}
				else
					continue;
			}
		}}
	catch(InvalidNodeException e){}
	}
	public static int returnlevel(Node1 rootnode1,String name)throws InvalidNodeException{
		if (same(rootnode1.name,name))
			return rootnode1.level;
		else if (compare(rootnode1.name,name))

			return returnlevel(rootnode1.lchild,name);
		else
			return returnlevel(rootnode1.rchild,name);
	}
	public static Node1 returnnode(Node1 rootnode1,String name)throws InvalidNodeException{
		if (same(rootnode1.name,name))
			return rootnode1;
		else if (compare(rootnode1.name,name))
			return returnnode(rootnode1.lchild,name);
		else
			return returnnode(rootnode1.rchild,name);
	}
	public static String ithparent(Node1 rootnode1,String name,int number)throws InvalidNodeException{
		if (number==1)
			return returnnode(rootnode1,name).parentname;
		else
			return ithparent(rootnode1,returnnode(rootnode1,name).parentname,number-1);
	}
	public static void deleteEmployee(Node1 rootnode1,Node2 rootnode2,String to_delete,String replace_by)throws InvalidNodeException,IOException{
		int lvl1=returnlevel(rootnode1,to_delete);
		int lvl2=returnlevel(rootnode1,replace_by);
	try{	if (lvl1!=lvl2){
			System.out.println(to_delete+ " and " + replace_by + " are not in the same level\n");
			System.out.print("*******************************************************************************\n");
			display_functions(rootnode1,rootnode2);
		}
		else{
			Stack<String> path1=new Stack();
			Stack<String> path2=new Stack();
			path1=trace(path1,rootnode1,to_delete);
			path2=trace(path2,rootnode1,replace_by);
			delempl(rootnode2,rootnode2,to_delete,replace_by,path1,path2);
		}}
	catch(InvalidNodeException e){}
	}
	public static void delempl(Node2 rootnode21,Node2 rootnode22,String to_delete,String replace_by,Stack<String> path1,Stack<String> path2)throws InvalidNodeException{
	try{	if (path1.size()==1){
			List<Node2> l=rootnode21.children;
			System.out.println(l);
			for (int i=0;i<l.size();i++){
				Node2 node2=l.get(i);
				if (same(node2.name,to_delete)){
					//System.out.println("Names equal in Level\n");
					node2.parent.children.remove(i);
					delemplf(rootnode22,node2,replace_by,path2);
				}
			}
		}
		else{
			
			String m=path1.pop();
			String namepeek=path1.peek();
			List<Node2> l=rootnode21.children;
			System.out.println(l);
			for (int i=0;i<l.size();i++){
				if (same(l.get(i).name,namepeek))
					delempl(l.get(i),rootnode22,to_delete,replace_by,path1,path2);
			}
		}}
	catch(InvalidNodeException e){}
	}
	public static void delemplf(Node2 rootnode2,Node2 node2,String replace_by,Stack<String> path)throws InvalidNodeException{
	try{	if (path.size()==1){
			
			List<Node2> m=rootnode2.children;
			for (int j=0;j<m.size();j++){
				Node2 noode2=m.get(j);
				if (same(noode2.name,replace_by))
					noode2.children.addAll(node2.children);
			}
		}
		else{
			
			String m=path.pop();
			String peekname=path.peek();
			List<Node2> child=rootnode2.children;
			for (int j=0;j<child.size();j++){
				if (same(child.get(j).name,peekname))
					delemplf(child.get(j),node2,replace_by,path);
			}
		}}
	catch(InvalidNodeException e){}
	}
class avlcompany{
	class AVLNode{// for avl tree
		AVLNode parent ;
		String data;
		String parentname;
		AVLNode lchild; 
		AVLNode rchild;
		int height;
		int level;
		
		}

		
public AVLNode root;
	 {
		root = null;
	}
	public void insert(String toinsert)throws InvalidNodeException{
		root=insert(toinsert,root);
	}
	public boolean search( String tosearch )throws InvalidNodeException{
		return search( tosearch, root );
	}
	public void makeEmpty()throws InvalidNodeException {
		root = null;
	}
	public boolean isEmpty()throws InvalidNodeException{
		return root == null;
	}
	public void printTree()throws InvalidNodeException{
	try{	if( isEmpty()){
		System.out.println("Empty");
		}
		else{
		printTree(root);
		}}catch(InvalidNodeException e){}
	}
	public AVLNode insert(String toinsert,AVLNode t)throws InvalidNodeException{
		if( t == null )
			return null;
		if(compare(t.data,toinsert)){
			t.lchild = insert( toinsert, t.lchild );
			t.lchild.parent =t ;
			if(height( t.rchild )-height( t.lchild ) == -2 )
				if(compare(t.lchild.data,toinsert))
					t = rotateLeft( t );
				else
					t = doubleLeft( t );
				}
			else if(compare(toinsert,t.data))		{
				t.rchild = insert( toinsert, t.rchild );
				t.rchild.parent =t ;
			if( height( t.lchild )-height( t.rchild ) == -2 )
				if(compare(toinsert,t.rchild.data))
					t = rotateRight( t );
				else
					t = doubleRight( t );
				}
			else
				t.height = Math.max( height( t.lchild ), height( t.rchild )) + 1;
				return t ;
	}

	private boolean search(String tosearch, AVLNode t )throws InvalidNodeException{
		while( t != null ){
			if(compare(t.data,tosearch))
			t = t.lchild;
			else if(compare(t.data,tosearch))
			t = t.rchild;
			else
				return true; 
		}
		return false;
	}
	private void printTree( AVLNode t )throws InvalidNodeException {
		if( t != null ){
			printTree( t.lchild );
			System.out.print( t.data );
			printTree( t.rchild );
		}
	}
	public int height( AVLNode t )throws InvalidNodeException{
		if( t == null )
			return -1;
		else
			return t.height; 
	}
	private AVLNode rotateLeft( AVLNode node2 )throws InvalidNodeException{
		AVLNode node1 = node2.lchild;
		node2.lchild = node1.rchild;
		node1.rchild = node2;
		node2.height = Math.max(height(node2.lchild), height(node2.rchild))+1;
		node1.height = Math.max(height(node1.lchild), node2.height)+1;
		return node1;
	}
	private AVLNode rotateRight( AVLNode node1 )throws InvalidNodeException{
		AVLNode node2 = node1.rchild;
		node1.rchild = node2.lchild;
		node2.lchild = node1;
		node1.height = Math.max(height(node1.lchild), height(node1.rchild))+1;
		node2.height = Math.max(height(node2.rchild), node1.height)+1;
		return node2;
	}
	private AVLNode doubleLeft( AVLNode node3 )throws InvalidNodeException{
		node3.lchild = rotateRight( node3.lchild );
		return rotateLeft( node3 );
	}
	private AVLNode doubleRight( AVLNode node1 )throws InvalidNodeException{
		node1.rchild = rotateLeft( node1.rchild );
		return rotateRight( node1 );
	}
	public void deleteKey(String to_deleteete)throws InvalidNodeException{
		AVLNode node = (AVLNode) search2( root,to_deleteete);
		if (node != null)
			delete1(node);
		else
			throw new NoSuchElementException("No such element is found");
	}
	public void delete1(AVLNode node)throws InvalidNodeException{
	AVLNode z = node;
	if (z == null)
		throw new InvalidNodeException("Node is found to be empty");
		AVLNode x;

		if (z.lchild == null){ 
			x = z.rchild;
		}
		else if (z.rchild == null) 
			x = z.lchild;
		else { 
			x = (AVLNode) successor(z); 
			delete1(x); 
			x.lchild = z.lchild;
			x.rchild = z.rchild;
			if (x.lchild != null)
				x.lchild.parent = x;
				if (x.rchild != null)
					x.rchild.parent = x; 
					if (x != null)
						x.parent = z.parent;
						if (root == z)
root = x;
else{
if (z == z.parent.lchild)
z.parent.lchild = x;
else
z.parent.rchild = x;
}
}}
	public boolean compare(String name1,String name2)throws InvalidNodeException{
		for (int i=0;;i++){
			char a=name1.charAt(i);
			char b=name2.charAt(i);
			if (a>b)
				return true;
			else if (a==b)
				continue;
			else
				{throw new InvalidNodeException();}
		}			
	}
	public AVLNode search2(AVLNode node,String to_deleteete)throws InvalidNodeException{
		while ((node != null) && (to_deleteete != node.data)) {
			if(compare(node.data,to_deleteete))
				node = node.lchild;
			else
				node = node.rchild;
		} 
		if (node != null)
			return node;
		else
			throw new InvalidNodeException("Not Found");
	}
	public  AVLNode treeMinimum(AVLNode x)throws InvalidNodeException{
		while (x.lchild != null)
			x = x.lchild;
		return x;
	} 


	
	public void delete5(String to_deleteete, AVLNode t)throws InvalidNodeException{
		if (t.lchild==null && t.rchild==null){
			if(compare(t.data,t.parent.data)){
				t.parent.rchild = null ;
			}
			else{
				t.parent.lchild = null ;}
				updateheight(t.parent) ;
				update(t.parent) ;
			}
		if (t.lchild!=null || t.rchild!=null){
			if (t.lchild != null){
				if(compare(t.data,t.parent.data)){
					t.parent.rchild = t.lchild ;
					t.lchild.parent = t.parent ;
				}
				else
					t.parent.lchild = t.lchild ;
					t.lchild.parent = t.parent ;
			}
		if (t.rchild != null){
			if(compare(t.data,t.parent.data)){
				t.parent.rchild = t.rchild ;
				t.rchild.parent = t.parent ;
			}
			else{
				t.parent.lchild = t.rchild;
				t.rchild.parent = t.parent;}
			}
			updateheight(t.parent) ;
			update(t.parent) ;
		}
		if (t.lchild!=null && t.rchild!=null){
			AVLNode temp = t ;
			if (compare(t.parent.data,t.data)){
				temp=temp.lchild ;
				if (temp.rchild != null){
					temp=temp.rchild ;
				}
			if (temp.rchild ==null && temp.lchild != null){
				temp=temp.lchild ;
			}
			AVLNode x = temp.parent ;
			temp = t.rchild.parent ;
			temp.rchild = t.rchild ;
			temp=t.lchild.parent ;
			temp.lchild = t.lchild ;
			temp.parent.rchild= null ;
			temp.parent = t.parent ;
			temp =temp.parent.lchild ;
			temp.height=t.height ;
			updateheight(x) ;
			update(x) ;
		}
		else{
			if(compare(t.data,t.parent.data)){
				temp = temp.rchild ;
				if (temp.lchild != null){
					temp=temp.lchild ;
				}
				if (temp.lchild ==null && temp.rchild != null){
					temp=temp.rchild ;
				}
				AVLNode j = temp.parent ;
				temp = t.lchild.parent ;
				temp.lchild = t.lchild ;
				temp=t.rchild.parent ;
				temp.rchild = t.rchild ;
				temp.parent.lchild= null ;
				temp.parent = t.parent ;
				temp =temp.parent.rchild ;

				temp.height= t.height ;
				updateheight(j) ;
				update(j) ;
			}
			}
		}
	}
	public void update(AVLNode t)throws InvalidNodeException{
		while(t != root){
			AVLNode g = t.parent ;
			if ((height( t.rchild )-height( t.lchild ) == -2) ){
				if (height(t.lchild.lchild)> height(t.lchild.rchild)){
					t=rotateLeft(t) ;
				}
				else
					t=doubleLeft(t) ;
			}
			if ((height( t.lchild )-height( t.rchild ) == -2) ){
				if (height(t.rchild.lchild) < height(t.rchild.rchild)){
					t=rotateRight(t) ;
				}
				else
					t= doubleRight(t) ;
			}
			t=g;
		}
	}
	public void updateheight(AVLNode t)throws InvalidNodeException {
		t.height = Math.max( height( t.lchild ), height( t.rchild )) + 1;
	}
	public AVLNode successor(AVLNode node)throws InvalidNodeException{
		AVLNode x = node;
		if (x.rchild != null)
			return treeMinimum(x.rchild);
			AVLNode y = x.parent;
			while (y != null && x == y.rchild) {
				x = y;
				y = y.parent;
			}
			return y;
	} 	
	public void deletek(String to_delete)throws InvalidNodeException{
		AVLNode node = (AVLNode) search2( root,to_delete);
		if (node != null)
			delete5(to_delete,node);
		else
			throw new InvalidNodeException("Not Found");
	}


//End of Construction of avl tree
}}
