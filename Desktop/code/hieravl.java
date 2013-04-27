import java.util.*;
public class hieravl
{
final static String mainrootname="nikhil";
//Start of construction of avl tree
public static class AVLNode{
	AVLNode left;
	AVLNode right;
	AVLNode parent;
	String data;
	String parentname;
	int level;
	int height;
	public AVLNode(String name,int level,String parentname){
		this.data=name;
		this.level=level;
		this.parentname=parentname;
	}
}
/*public static class AVLNode{
		AVLNode parent ;
		String data;
		String parentname;
		AVLNode left; 
		AVLNode right;
		int height;
		int level;
		AVLNode(String name,int level,String parentname) {
			this(name,level,parentname, null, null,null);
		}
	public hieravl tree ;
	AVLNode(String name,int level,String parentname,AVLNode lt,AVLNode rt,AVLNode pr){
		data = name;
		parentname=parentname;
		level=level;
		left = lt;
		parent = pr ;
		right = rt;
		height = 0;
	}
}*/	
public static AVLNode root;
public hieravl( ) 
{
root = null;
}
public static void insert(String toinsert,int level,String parentname)
{
root = insert(toinsert,root,level,parentname);
}
public static boolean exists(String tosearch)
{
return search(tosearch, root);
}
public static void makeEmpty( ) 
{
root = null;
}
public static boolean isEmpty( )
{
return root == null;
}
public static void printTree( )
{
if( isEmpty( ) ){
System.out.println("Empty");
}
else{
printTree(root);
}}
public static AVLNode insert(String toinsert,AVLNode t,int level,String parent){
		if(t==null){
			AVLNode newavlnode=new AVLNode(toinsert,level,parent);
			newavlnode.left=null;
			newavlnode.right=null;
			newavlnode.parent=null;
			return newavlnode;
		}
		if(greater(t.data,toinsert)){
			t.left=insert(toinsert,t.left,level,parent);
			t.left.parent=t;
			if(height( t.right )-height( t.left ) == -2 )
				if(greater(t.left.data,toinsert))
					t = rotateLeft(t);
				else
					t = doubleLeft(t);
				}
			else if(greater(toinsert,t.data)){
				t.right = insert(toinsert,t.right,level,parent);
				t.right.parent =t ;
			if( height( t.left )-height( t.right ) == -2 )
				if(greater(toinsert,t.right.data))
					t = rotateRight( t );
				else
					t = doubleRight( t );
				}
			else
				t.height = Math.max(height(t.left),height(t.right)) + 1;
				return t ;
	}

private static boolean search(String tosearch,AVLNode t)
{
while( t != null )
{
if(greater(t.data,tosearch))
t = t.left;
else if(greater(tosearch,t.data))
t = t.right;
else
return true; 
}
return false;
}
private static void printTree( AVLNode t ) 
{

if( t != null )
{
printTree( t.left );
System.out.print( t.data );
printTree( t.right );
}
}
public static int height( AVLNode t )
{
if( t == null ){
return -1;}
else{
return t.height; }
}
private static AVLNode rotateLeft( AVLNode node2 )
{
AVLNode node1 = node2.left;
node2.left = node1.right;
node1.right = node2;
node2.height = Math.max(height(node2.left), height(node2.right))+1;
node1.height = Math.max(height(node1.left), node2.height)+1;
return node1;
}
private static AVLNode rotateRight( AVLNode node1 )
{
AVLNode node2 = node1.right;
node1.right = node2.left;
node2.left = node1;
node1.height = Math.max(height(node1.left), height(node1.right))+1;
node2.height = Math.max(height(node2.right), node1.height)+1;
return node2;
}
private static AVLNode doubleLeft( AVLNode node3 )
{
node3.left = rotateRight( node3.left );
return rotateLeft( node3 );
}
private static AVLNode doubleRight( AVLNode node1 )
{
node1.right = rotateLeft( node1.right );
return rotateRight( node1 );
}
public static void deleteKey(String todelete)
{
AVLNode node = (AVLNode) search2( root,todelete);
if (node != null)
delete1(node);
else
throw new NoSuchElementException("Not Found");
}
public static void delete1(AVLNode node)
{
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
if (x.left != null) x.left.parent = x;
if (x.right != null) x.right.parent = x;
} 
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
}

public static AVLNode search2(AVLNode node,String todelete)
{
while ((node != null) && (todelete != node.data)) {
if(greater(node.data,todelete))
node = node.left;
else
node = node.right;
} 
if (node != null){
return node;
}
else {
throw new NoSuchElementException("Not Found");
}
}
public static AVLNode treeMinimum(AVLNode x)
{
while (x.left != null)
x = x.left;
return x;
} 


public static AVLNode successor(AVLNode node)
{
AVLNode x = node;
if (x.right != null)
return treeMinimum(x.right);
AVLNode y = x.parent;
while (y != null && x == y.right) {
x = y;
y = y.parent;
}
return y;
} //successor
public static void delete5(String todelete, AVLNode t){
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
t.left.parent = t.parent ; }
else
t.parent.left = t.left ;
t.left.parent = t.parent ;
}
if (t.right != null){
if(greater(t.data,t.parent.data)){
t.parent.right = t.right ;
t.right.parent = t.parent ;
}
else
{	t.parent.left = t.right;
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
public static void update(AVLNode t){
while(t != root)
{ AVLNode g = t.parent ;
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
public static void updateheight(AVLNode t) {
t.height = Math.max( height( t.left ), height( t.right )) + 1;
}
public static void deletek(String todel)
{
AVLNode node = (AVLNode) search2( root,todel);
if (node != null)
delete5(todel,node);
else
throw new NoSuchElementException("Not Found");
}

public static int returnlevel(String name){
	return rtnlvl(name,root);
}
public static int rtnlvl(String name,AVLNode t){
		if(greater(t.data,name))
			return rtnlvl(name,t.left);
		else if(greater(name,t.data))
			return rtnlvl(name,t.right);	
		else
			return t.level; 
}
public static AVLNode returnnode(String name){
	return rtnnode(name,root);
}
public static AVLNode rtnnode(String name,AVLNode t){
	if(greater(t.data,name))
			return rtnnode(name,t.left);
		else if(greater(name,t.data))
			return rtnnode(name,t.right);	
		else
			return t; 
}
//End of construction of avl tree

//Tree according to level starts
static class Node{
		Node parent;
		List<Node> children;
		int level;
		String name;
		public Node(String name,int level,List<Node> children){
			this.name=name;
			this.level=level;
			this.children=children;
		}
	}
//End
public static Stack getpath(String rootname,Stack<String> path,String name){
	return getpath1(rootname,path,name,root);
}
public static Stack getpath1(String rootname,Stack<String> path,String name,AVLNode t){
	if (same(rootname,name))
		return path;
	else{
		AVLNode node=returnnode(name);
		String parent=node.parentname;
		path.push(parent);
		return getpath1(rootname,path,node.parentname,t);
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
public static boolean greater(String name1,String name2){
		int a=name1.compareTo(name2);
		if (a>0)
			return true;
		else
			return false;
}

	public static void main(String args[]){
		insert("nikhil",1,"noparent");
		List l=new ArrayList();
		Node Rootnode=new Node("nikhil",1,l);
		addEmployee(Rootnode,"Deepak","nikhil");
		addEmployee(Rootnode,"Anuj","Deepak");
		addEmployee(Rootnode,"Abhishek","Anuj");
		addEmployee(Rootnode,"Saurabh","Anuj");
		addEmployee(Rootnode,"Alok","Anuj");
		addEmployee(Rootnode,"Mukesh","Saurabh");
		addEmployee(Rootnode,"Vineet","Saurabh");
		addEmployee(Rootnode,"Utkarsh","Saurabh");
		addEmployee(Rootnode,"Ojasvi","Abhishek");
		addEmployee(Rootnode,"Rohan","Abhishek");
		addEmployee(Rootnode,"Jessica","Deepak");
		addEmployee(Rootnode,"Harvey","Jessica");
		addEmployee(Rootnode,"Louis","Jessica");
		addEmployee(Rootnode,"Mike","Harvey");
		addEmployee(Rootnode,"Dona","Harvey");
		addEmployee(Rootnode,"Rachel","Dona");
		addEmployee(Rootnode,"Trent","Louis");
		addEmployee(Rootnode,"Norma","Louis");
		addEmployee(Rootnode,"Sheldon","Deepak");
		addEmployee(Rootnode,"Alex","Sheldon");
		addEmployee(Rootnode,"Amy","Sheldon");
		addEmployee(Rootnode,"Leonard","Sheldon");
		addEmployee(Rootnode,"Leslie","Sheldon");
		addEmployee(Rootnode,"Raj","Leonard");
		addEmployee(Rootnode,"Wolowitz","Raj");
		addEmployee(Rootnode,"Penny","Wolowitz");
		addEmployee(Rootnode,"Stuart","Raj");
		printTree();
		printEmployees(Rootnode);
		deleteEmployee(Rootnode,"Saurabh","Abhishek");
		System.out.println("\n");
	}
	public static void addEmployee(Node rootnode,String toadd,String addunder){
	if (exists(addunder)){
		int level=returnlevel(addunder)+1;
		insert(toadd,level,addunder);
		Stack<String> path=new Stack();
		Stack finalpath=getpath(rootnode.name,path,addunder);
		inserttree(finalpath,rootnode,toadd,level,addunder);
	}
	else
		System.out.println(addunder +" is not there\n");
	}
	/*public static void inserttree(Stack<String> path,Node rootnode,String toadd,int level,String addunder){
		if (path.empty()){
			List<Node> l=rootnode.children;
			for (int i=0;i<l.size();i++){
				if same(addunder,l.get(i).name){
					finalnode=l.get(i);
					List<Node> child=new ArrayList();
					Node newnode=new Node(toadd,level,child);
					finalnode.children.add(newnode);
					newnode.parent=finalnode;
				}
			}
		}
		else{
			Stringpath.pop();
		}
	}*/
	public static void inserttree(Stack<String> path,Node rootnode,String toadd,int level,String addunder){
		if (path.empty()){
			List<Node> l=new ArrayList();
			Node newnode2=new Node(toadd,level,l);
			newnode2.parent=rootnode;
			(rootnode.children).add(newnode2);
		}
		else if (path.size()==1){
			List<Node> l=rootnode.children;
			for (int i=0;i<l.size();i++){
				Node node2=l.get(i);
				if (node2.name==addunder){
					List<Node> s=new ArrayList();
					Node newnode2=new Node(toadd,level,s);
					node2.children.add(newnode2);
					newnode2.parent=node2;
				}
			}
		}		
		else{
			String m=path.pop();
			String peekname=path.peek();
			List<Node> chillist=rootnode.children;
			for (int i=0;i<chillist.size();i++){
				if (same(chillist.get(i).name,peekname))
					inserttree(path,chillist.get(i),toadd,level,addunder);
			}
		}
	}
	public static void printEmployees(Node rootnode){
		System.out.println("rootnode:"+rootnode.name);
		Stack<Node> s1=new Stack();
		Stack<Node> s2=new Stack();
		List<Node> v=rootnode.children;
		if (v.isEmpty()){
			System.out.print("========================\n");
		}
		else{
			for (int i=0;i<v.size();i++){
				s1.push(v.get(i));
			}
			printfrmstack(rootnode,s1,s2);
		}
	}
	public static void printfrmstack(Node rootnode,Stack<Node> s1,Stack<Node> s2){
		if (s1.empty()==true && s2.empty()==true)
			System.out.print("========================\n");
		else if (s1.empty()==true){
			while (s2.empty()!=true){
				Node node=s2.pop();
				System.out.println(node.name);
				List<Node> v=node.children;
              			for (int i=0;i<v.size();i++){
                        		s1.push(v.get(i));
                		}
			}
			printfrmstack(rootnode,s1,s2);
		}

		else if (s2.empty()==true){
			while (s1.empty()!=true){
                                Node node=s1.pop();
                           System.out.println(node.name);
                                List<Node> v=node.children;
                                for (int i=0;i<v.size();i++){
                                        s2.push(v.get(i));
                                }
                        }
                        printfrmstack(rootnode,s1,s2);
		}
	}
	public static void lcb(Node rootnode,String name1,String name2){
		int lvl1=returnlevel(name1);
		int lvl2=returnlevel(name2);
		if (lvl1>lvl2){
			for (int i=1;i<lvl2;i++){
				String parent1=ithparent(name2,i);
				String parent2=ithparent(name1,lvl1-lvl2+i);
				if (same(parent1,parent2)){
					System.out.println("The least common boss of " + name1 + " and " + name2 + " is " + parent1);
					break;
				}
				else
					continue;
			}
		}
		else{
			for (int i=1;i<lvl1;i++){
				String parent1=ithparent(name1,i);
				String parent2=ithparent(name2,lvl2-lvl1+i);
				if (same(parent1,parent2)){
					System.out.println("The least common boss of " + name1 + " and " + name2 + " is "+parent1); 						break;
				}
				else
					continue;
			}
		}
	}
	public static String ithparent(String name,int number){
		if (number==1)
			return returnnode(name).parentname;
		else
			return ithparent(returnnode(name).parentname,number-1);
	}
	public static void deleteEmployee(Node rootnode,String todel,String changeto){
		if (exists(todel)){
			if (exists(changeto)){
				int lvl1=returnlevel(todel);
				int lvl2=returnlevel(changeto);
				if (lvl1!=lvl2){
					System.out.println(todel+ " and " + changeto + " are not in the same level\n");
					System.out.print("========================\n");
				}
				else{
					Stack<String> path1=new Stack();
					Stack<String> path2=new Stack();
					path1=getpath(mainrootname,path1,todel);
					path2=getpath(mainrootname,path2,changeto);
					deltree(rootnode,path1,todel,changeto);
					delempl(rootnode,rootnode,todel,changeto,path1,path2);
				}
			}
			else
				System.out.print(changeto + " doesn't exist");
		}
		else
			System.out.print(todel + " doesn't exist");
	}
	public static void deltree(Node rootnode,Stack<String> path,String todel,String changeto){
		deleteKey(todel);
		if (path.size()==1){
			List<Node> l=rootnode.children;
			for (int i=0;i<l.size();i++){
				if (same(l.get(i).name,todel)){
					Node req=l.get(i);
					List<Node> reqchildren=req.children;
					for (int j=0;j<reqchildren.size();j++){
						returnnode(reqchildren.get(i).name).parentname=changeto;
					}
				}
			}
		}
		else{
			String m=path.pop();
			String parent=path.peek();
			List<Node> l=rootnode.children;
			for (int i=0;i<l.size();i++){
				if (same(l.get(i).name,parent)){
					deltree(l.get(i),path,todel,changeto);
				}
			}
		}
	}
	public static void delempl(Node rootnode21,Node rootnode22,String todel,String changeto,Stack<String> path1,Stack<String> path2){
		if (path1.size()==1){
			List<Node> l=rootnode21.children;
			for (int i=0;i<l.size();i++){
				Node node=l.get(i);
				if (same(node.name,todel)){
					node.parent.children.remove(i);
					delemplf(rootnode22,node,changeto,path2);
				}
			}
		}
		else{
			String m=path1.pop();
			String namepeek=path1.peek();
			List<Node> l=rootnode21.children;
			for (int i=0;i<l.size();i++){
				if (same(l.get(i).name,namepeek))
					delempl(l.get(i),rootnode22,todel,changeto,path1,path2);
			}
		}
	}
	public static void delemplf(Node rootnode,Node node,String changeto,Stack<String> path){
		if (path.size()==1){
			List<Node> m=rootnode.children;
			for (int j=0;j<m.size();j++){
				Node noode=m.get(j);
				if (same(noode.name,changeto))
					noode.children.addAll(node.children);
			}
		}
		else{
			String m=path.pop();
			String peekname=path.peek();
			List<Node> child=rootnode.children;
			for (int j=0;j<child.size();j++){
				if (same(child.get(j).name,peekname))
					delemplf(child.get(j),node,changeto,path);
			}
		}
	}
}

