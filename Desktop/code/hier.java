import java.util.*;
public class hier{
	static class Node1{
		Node1 left;
		Node1 right;
		int level;
		String name;
		String parentname;
		public Node1(String name,int level,String parentname){
			this.name=name;
			this.level=level;
			this.parentname=parentname;
		}
	}
	static class Node2{
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
	public static void main(String args[]){
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
	public static void display_functions(Node1 rootnode1,Node2 rootnode2){
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
		if (same(input[0],"AddEmployee")){
			if (input.length==3){
				adding_employee(rootnode1,rootnode2,(String)input[1],(String)input[2]);
				
				display_functions(rootnode1,rootnode2);
			}
			else{
				System.out.print("\nPlease type-in 2 names \n");
				display_functions(rootnode1,rootnode2);
			}
		}
		else if (same(input[0],"DeleteEmployee")){
			if (input.length==3){
				System.out.print("Deleting......\n");
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
				lcb(rootnode1,rootnode2,input[1],input[2]);
				display_functions(rootnode1,rootnode2);
			}
			else{
				System.out.print("\nPlease type-in 2 names \n");
				display_functions(rootnode1,rootnode2);
			}
		}
		else{
			display_functions(rootnode1,rootnode2);
		}
	}
	public static void adding_employee(Node1 rootnode1,Node2 rootnode2,String f,String g)
		{addEmployee(rootnode1,rootnode2,(String)f,(String)g);}
		
	public static void printEmployees(Node1 rootnode1,Node2 rootnode2){
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
			printfrmstack(rootnode1,rootnode2,s1,s2);
		}
	}
	public static void printfrmstack(Node1 rootnode1,Node2 rootnode2,Stack<Node2> s1,Stack<Node2> s2){
		if (s1.empty()==true && s2.empty()==true){
			System.out.print("*******************************************************************************\n");
			display_functions(rootnode1,rootnode2);
		}
		else if (s1.empty()==true){
			System.out.println("The members at the next level in the hierarchy are:");
			while (s2.empty()!=true){
				
				Node2 node2=s2.pop();
				System.out.println("\t"+node2.name);
				List<Node2> v=node2.children;
              			for (int i=0;i<v.size();i++){
                        		s1.push(v.get(i));
                		}
			}
			printfrmstack(rootnode1,rootnode2,s1,s2);
		}

		else if (s2.empty()==true){
			System.out.println("The members at the next level in the hierarchy are:");
			while (s1.empty()!=true){
                                Node2 node2=s1.pop();
                           System.out.println("\t"+node2.name);
                                List<Node2> v=node2.children;
                                for (int i=0;i<v.size();i++){
                                        s2.push(v.get(i));
                                }
                        }
                        printfrmstack(rootnode1,rootnode2,s1,s2);
			
		}
	}
	public static void addEmployee(Node1 rootnode1,Node2 rootnode2,String name_new,String head_person){
		
		int level2add=returnlevel(rootnode1,head_person)+1;
		inserttree1(rootnode1,name_new,level2add,head_person);
		Stack path=new Stack();
		path=getpath(path,rootnode1,head_person);
		inserttree2(path,rootnode2,name_new,level2add,head_person);
		System.out.print(" Inserted  " + name_new + "  under  " + head_person + "\n");
	}
	public static void inserttree1(Node1 rootnode1,String name_new,int level,String head_person){
		if (greater(rootnode1.name,name_new)==true){
			if (rootnode1.left!=null)
				inserttree1(rootnode1.left,name_new,level,head_person);
			else{
				rootnode1.left=new Node1(name_new,level,head_person);
			}
		}
		else{
			if (rootnode1.right!=null)
				inserttree1(rootnode1.right,name_new,level,head_person);
			else{
				rootnode1.right=new Node1(name_new,level,head_person);
			}
		}
	}
	public static void inserttree2(Stack<String> path,Node2 rootnode2,String name_new,int level,String head_person){
		if (path.empty()){
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
		}
	}
	public static Stack getpath(Stack path,Node1 rootnode1,String name){
		if (same(rootnode1.name,name))
			return path;
		else{
			String newtofind=returnnode(rootnode1,name).parentname;
			path.push(newtofind);
			return getpath(path,rootnode1,newtofind);
		}
	}
	public static boolean greater(String name1,String name2){
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
	public static boolean same(String name1,String name2){
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
	public static void lcb(Node1 rootnode1,Node2 rootnode2,String name1,String name2){
		int lvl1=returnlevel(rootnode1,name1);
		int lvl2=returnlevel(rootnode1,name2);
		if (lvl1>lvl2){
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
		}
	}
	public static int returnlevel(Node1 rootnode1,String name){
		if (same(rootnode1.name,name))
			return rootnode1.level;
		else if (greater(rootnode1.name,name))

			return returnlevel(rootnode1.left,name);
		else
			return returnlevel(rootnode1.right,name);
	}
	public static Node1 returnnode(Node1 rootnode1,String name){
		if (same(rootnode1.name,name))
			return rootnode1;
		else if (greater(rootnode1.name,name))
			return returnnode(rootnode1.left,name);
		else
			return returnnode(rootnode1.right,name);
	}
	public static String ithparent(Node1 rootnode1,String name,int number){
		if (number==1)
			return returnnode(rootnode1,name).parentname;
		else
			return ithparent(rootnode1,returnnode(rootnode1,name).parentname,number-1);
	}
	public static void deleteEmployee(Node1 rootnode1,Node2 rootnode2,String todel,String changeto){
		int lvl1=returnlevel(rootnode1,todel);
		int lvl2=returnlevel(rootnode1,changeto);
		if (lvl1!=lvl2){
			System.out.println(todel+ " and " + changeto + " are not in the same level\n");
			System.out.print("*******************************************************************************\n");
			display_functions(rootnode1,rootnode2);
		}
		else{
			Stack<String> path1=new Stack();
			Stack<String> path2=new Stack();
			path1=getpath(path1,rootnode1,todel);
			path2=getpath(path2,rootnode1,changeto);
			delempl(rootnode2,rootnode2,todel,changeto,path1,path2);
		}
	}
	public static void delempl(Node2 rootnode21,Node2 rootnode22,String todel,String changeto,Stack<String> path1,Stack<String> path2){
		if (path1.size()==1){
			List<Node2> l=rootnode21.children;
			System.out.println(l);
			for (int i=0;i<l.size();i++){
				Node2 node2=l.get(i);
				if (same(node2.name,todel)){
					System.out.println("Names equal in Level\n");
					node2.parent.children.remove(i);
					delemplf(rootnode22,node2,changeto,path2);
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
					delempl(l.get(i),rootnode22,todel,changeto,path1,path2);
			}
		}
	}
	public static void delemplf(Node2 rootnode2,Node2 node2,String changeto,Stack<String> path){
		if (path.size()==1){
			
			List<Node2> m=rootnode2.children;
			for (int j=0;j<m.size();j++){
				Node2 noode2=m.get(j);
				if (same(noode2.name,changeto))
					noode2.children.addAll(node2.children);
			}
		}
		else{
			
			String m=path.pop();
			String peekname=path.peek();
			List<Node2> child=rootnode2.children;
			for (int j=0;j<child.size();j++){
				if (same(child.get(j).name,peekname))
					delemplf(child.get(j),node2,changeto,path);
			}
		}
	}
class avlhier{
	class AVLNode{// for avl tree
		AVLNode parent ;
		String data;
		String parentname;
		AVLNode left; 
		AVLNode right;
		int height;
		int level;
		
		}

		
public AVLNode root;
	 {
		root = null;
	}
	public void insert(String toinsert){
		root=insert(toinsert,root);
	}
	public boolean search( String tosearch ){
		return search( tosearch, root );
	}
	public void makeEmpty() {
		root = null;
	}
	public boolean isEmpty(){
		return root == null;
	}
	public void printTree(){
		if( isEmpty()){
		System.out.println("Empty");
		}
		else{
		printTree(root);
		}
	}
	public AVLNode insert(String toinsert,AVLNode t){
		if( t == null )
			return null;
		if(greater(t.data,toinsert)){
			t.left = insert( toinsert, t.left );
			t.left.parent =t ;
			if(height( t.right )-height( t.left ) == -2 )
				if(greater(t.left.data,toinsert))
					t = rotateLeft( t );
				else
					t = doubleLeft( t );
				}
			else if(greater(toinsert,t.data))		{
				t.right = insert( toinsert, t.right );
				t.right.parent =t ;
			if( height( t.left )-height( t.right ) == -2 )
				if(greater(toinsert,t.right.data))
					t = rotateRight( t );
				else
					t = doubleRight( t );
				}
			else
				t.height = Math.max( height( t.left ), height( t.right )) + 1;
				return t ;
	}

	private boolean search(String tosearch, AVLNode t ){
		while( t != null ){
			if(greater(t.data,tosearch))
			t = t.left;
			else if(greater(t.data,tosearch))
			t = t.right;
			else
				return true; 
		}
		return false;
	}
	private void printTree( AVLNode t ) {
		if( t != null ){
			printTree( t.left );
			System.out.print( t.data );
			printTree( t.right );
		}
	}
	public int height( AVLNode t ){
		if( t == null )
			return -1;
		else
			return t.height; 
	}
	private AVLNode rotateLeft( AVLNode node2 ){
		AVLNode node1 = node2.left;
		node2.left = node1.right;
		node1.right = node2;
		node2.height = Math.max(height(node2.left), height(node2.right))+1;
		node1.height = Math.max(height(node1.left), node2.height)+1;
		return node1;
	}
	private AVLNode rotateRight( AVLNode node1 ){
		AVLNode node2 = node1.right;
		node1.right = node2.left;
		node2.left = node1;
		node1.height = Math.max(height(node1.left), height(node1.right))+1;
		node2.height = Math.max(height(node2.right), node1.height)+1;
		return node2;
	}
	private AVLNode doubleLeft( AVLNode node3 ){
		node3.left = rotateRight( node3.left );
		return rotateLeft( node3 );
	}
	private AVLNode doubleRight( AVLNode node1 ){
		node1.right = rotateLeft( node1.right );
		return rotateRight( node1 );
	}
	public void deleteKey(String todelete){
		AVLNode node = (AVLNode) search2( root,todelete);
		if (node != null)
			delete1(node);
		else
			throw new NoSuchElementException("Not Found");
	}
	public void delete1(AVLNode node){
	AVLNode z = node;
	if (z == null)
		throw new NoSuchElementException("empty node");
		AVLNode x;

		if (z.left == null){ 
			x = z.right;
		}
		else if (z.right == null) 
			x = z.left;
		else { 
			x = (AVLNode) successor(z); 
			delete1(x); 
			x.left = z.left;
			x.right = z.right;
			if (x.left != null)
				x.left.parent = x;
				if (x.right != null)
					x.right.parent = x; 
					if (x != null)
						x.parent = z.parent;
						if (root == z)
root = x;
else{
if (z == z.parent.left)
z.parent.left = x;
else
z.parent.right = x;
}
}}
	public boolean greater(String name1,String name2){
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
	public AVLNode search2(AVLNode node,String todelete){
		while ((node != null) && (todelete != node.data)) {
			if(greater(node.data,todelete))
				node = node.left;
			else
				node = node.right;
		} 
		if (node != null)
			return node;
		else
			throw new NoSuchElementException("Not Found");
	}
	public  AVLNode treeMinimum(AVLNode x){
		while (x.left != null)
			x = x.left;
		return x;
	} 


	public AVLNode successor(AVLNode node){
		AVLNode x = node;
		if (x.right != null)
			return treeMinimum(x.right);
			AVLNode y = x.parent;
			while (y != null && x == y.right) {
				x = y;
				y = y.parent;
			}
			return y;
	} 	
	public void delete5(String todelete, AVLNode t){
		if (t.left==null && t.right==null){
			if(greater(t.data,t.parent.data)){
				t.parent.right = null ;
			}
			else{
				t.parent.left = null ;}
				updateheight(t.parent) ;
				update(t.parent) ;
			}
		if (t.left!=null || t.right!=null){
			if (t.left != null){
				if(greater(t.data,t.parent.data)){
					t.parent.right = t.left ;
					t.left.parent = t.parent ;
				}
				else
					t.parent.left = t.left ;
					t.left.parent = t.parent ;
			}
		if (t.right != null){
			if(greater(t.data,t.parent.data)){
				t.parent.right = t.right ;
				t.right.parent = t.parent ;
			}
			else{
				t.parent.left = t.right;
				t.right.parent = t.parent;}
			}
			updateheight(t.parent) ;
			update(t.parent) ;
		}
		if (t.left!=null && t.right!=null){
			AVLNode temp = t ;
			if (greater(t.parent.data,t.data)){
				temp=temp.left ;
				if (temp.right != null){
					temp=temp.right ;
				}
			if (temp.right ==null && temp.left != null){
				temp=temp.left ;
			}
			AVLNode x = temp.parent ;
			temp = t.right.parent ;
			temp.right = t.right ;
			temp=t.left.parent ;
			temp.left = t.left ;
			temp.parent.right= null ;
			temp.parent = t.parent ;
			temp =temp.parent.left ;
			temp.height=t.height ;
			updateheight(x) ;
			update(x) ;
		}
		else{
			if(greater(t.data,t.parent.data)){
				temp = temp.right ;
				if (temp.left != null){
					temp=temp.left ;
				}
				if (temp.left ==null && temp.right != null){
					temp=temp.right ;
				}
				AVLNode j = temp.parent ;
				temp = t.left.parent ;
				temp.left = t.left ;
				temp=t.right.parent ;
				temp.right = t.right ;
				temp.parent.left= null ;
				temp.parent = t.parent ;
				temp =temp.parent.right ;

				temp.height= t.height ;
				updateheight(j) ;
				update(j) ;
			}
			}
		}
	}
	public void update(AVLNode t){
		while(t != root){
			AVLNode g = t.parent ;
			if ((height( t.right )-height( t.left ) == -2) ){
				if (height(t.left.left)> height(t.left.right)){
					t=rotateLeft(t) ;
				}
				else
					t=doubleLeft(t) ;
			}
			if ((height( t.left )-height( t.right ) == -2) ){
				if (height(t.right.left) < height(t.right.right)){
					t=rotateRight(t) ;
				}
				else
					t= doubleRight(t) ;
			}
			t=g;
		}
	}
	public void updateheight(AVLNode t) {
		t.height = Math.max( height( t.left ), height( t.right )) + 1;
	}
	public void deletek(String todel){
		AVLNode node = (AVLNode) search2( root,todel);
		if (node != null)
			delete5(todel,node);
		else
			throw new NoSuchElementException("Not Found");
	}


//End of Construction of avl tree
}}
