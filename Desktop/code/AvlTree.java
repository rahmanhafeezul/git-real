import java.util.ArrayList;

public class AvlNode{
public AvlNode leftchild;
public AvlNode rightchild;
public AvlNode parent;
public int key;
public int balance;
public AvlNode(int k){
leftchild=null;
rightchild=null;
parent=null;
balance=0;
key=k;
}
}
/**This class is the complete implementation of an AVL Tree**/
public class AvlTree
public AvlNode root;//the root node
/** Adding a new element into the tree**/
public void insert(int k)
{
	AvlNode node =new AvlNode(k);
	insertAVL(this.root,n);
}
public void insertAVL(AvlNode p,AvlNode q)
{
	if(p==null)
	{
		this.root=q;
	}
	else
	{
	if(q.key<p.key)
		{
			if(p.leftchild==null)
			{
				p.leftchild=q;
				q.parent=p;
				recursiveBalance(p);
			}
			else
			{
			insertAVL(p.leftchild,q);
			}
		}
	else if(q.key>p.key)
		{
			if(p.rightchild==null)
			{
				p.rightchild=q;
				q.parent=p;
				recursiveBalance(p);
			}
			else
			{
			insertAVL(p.rightchild,q);
			}
		}
	else
		{
		}
	}
}
/** Check the balance for each node recursivly and call required method until the balnced condition is satisfied till the root is reached**/
public void recursiveBalance(AvlNode cur)
{
	setBalance(cur);
	int balance=cur.balance;
	if(balance==-2)
	{
	if(height(cur.leftchild.leftchild)>=height(cur.leftchild.rightchild))
		{
			cur=rotateRight(cur);
		}
		else
		{
			cur=doubleRotateLeftRight(cur);
		}
	}
	else if(balance==2)
	{if(height(cur.rightchild.rightchild)>=height(cur.rightchild.leftchild))
	{
		cur=rotateLeft(cur);
	}
	else
	{
		cur=doubleRotateRightLeft(cur);
	}
	}
	if(cur.parent!=null)
	{
	recursiveBalance(cur.parent);
	}
	else
	{
	this.root=cur;
	System.out.println("------Balancing finished--------");
	}
	}
	public void remove(int k)
	{
	removeAVL(this.root,k);
	}
	public removeAVL(AvlNode p,int q)
	{
		if(p==null)
		{
			return;
		}
		else
		{
		if(p.key>q)
			{
			removeAVL(p.leftchild,q);
			}
		else if(p.key<q)
			{
			removeAVL(p.rightchild,q);
			}
		else if(p.key==q)
			{
			removeFoundNode(p);
			}
		}
	}
	public removeFoundNode(AvlNode q)
	{
		AvlNode r;
		if(q.leftchild==null||q.rightchild==null)
		{
			if(q.parent==null)
			{
				this.root=null;
				q=null;
				return;
			}
			r=q;
		}
		else
		{
		r=successor(q);
		q.key=r.key;
		}
		AvlNode p;
		if(r.leftchild!=null)
		{
			p=r.leftchild;
		}
		else
		{
			p=r.rightchild;
		}
		if(p!=null)
		{
		p.parent=r.parent;
		}
		if(r.parent==null)
		{
			this.root=p;
		}
		else
		{
		if(r==r.parent.leftchild)
		{
		r.parent.leftchild=p;
		}
		else
		{
		r.parent.rightchild=p;
		}
		recursiveBalance(r.parent);
		}
		r=null;
	}
	public AvlNode rotateLeft(AvlNode n)
	{
		AvlNode v=n.right;
		v.parent=n.parent;
		n.right=v.left;
		if(n.rightchild!=null)
		{
			n.rightchild.parent=n;
		
		}
		v.leftchild=n;
		n.parent=v;
		if(v.parent!=null)
		{
			if(v.parent.rightchild==n)
			{
			v.parent.rightchild=v;
			}
			else if(v.parent.leftchild==n)
			{
				v.parent.leftchild=v;
			}
		}
		setBalance(n);
		setBalance(v);
		
		return v;
		}
	public AvlNode rotateRight(AvlNode n)
		{
		AvlNode v=n.leftchild;
		v.parent=n.parent;
		n.leftchild=v.rightchild;
		if(n.leftchild!=null)
		{
		n.leftchild.parent=n;
		}
		v.rightchild=n;
		n.parent=v;
		if(v.parent!=null)
		{
		if(v.parent.rightchild==n)
			{
			v.parent.rightchild=v;
			}
		else if(v.parent.leftchild==n)
			{
			v.parent.leftchild=v;
			}
		}
		setBalnce(n);
		setBalnce(v);
		return v;
		}
	public AvlNode doubleRotateRightLeft(AvlNode u)
		{
		u.right=rotateRight(u.rightchild);
		return rotateLeft(u);
		}
	public AvlNode successor(AvlNode q)
		{
		if(q.rightchild!=null)
		{
			AvlNode r=q.rightchild;
			while(r.leftchild!=null)
			{
			r=r.leftchild;
			}
			return r;
		}
		else
		{
		AvlNode p=q.parent;
		while(p!=null && q==p.rightchild)
			{
			q=p;
			p=q.parent;
			}
			return p;
		}
	}
private int height(AvlNode cur)
	{
		if(cur==null)
		{
		return -1;
		}
		if(cur.leftchild==null && cur.rightchild==null)
			return 0;
		else if(cur.leftchild==null)
			return 1+height(cur.rightchild);
		else if(cur.rightchild==null)
			return 1+height(cur.leftchild);
		else
			return 1+maximum(height(cur.leftchild),height(cur.rightchild));
	}
	public void print(AvlNode n)
	{
		int l=0;
		int r=0;
		int p=0;
		if(n.leftchild!=null)
		{
			l=n.leftchild.key;
		}
		if(n.rightchild!=null)
		{
			r=n.rightchild.key;
		}
		if(n.parent!=null)
		{
			p=n.parent.key;
		}
		System.out.println("Leftchild:"+l+"  Key:"+n+"  Right:"+r+"  Parent:"+p+"  Balance:"+n.balance);
	if(n.leftchild!=null)
	{
		print(n.leftchild);
	}
	if(n.rightchild!=null)
	{
		print(n.rightchild);
	}
	}
private void setBalnce(AvlNode cur)
	cur.balance=height(cur.rightchild)-height(cur.leftchild);
	}
private int maximum(int a,int b)
	{
	if(a>=b)
		return a;
	else
		return b;
	}
				
			
			
				



		

