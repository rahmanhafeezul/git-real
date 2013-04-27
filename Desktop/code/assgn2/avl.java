class NoSuchEmployeeFoundException extends Exception 
{
    	NoSuchEmployeeFoundException(String input) 
	{
	        System.out.println("No employee exists by the name " + input);
	}
}

class DuplicateException extends Exception
{
	DuplicateException(String data)
	{
		System.out.println("An entry already exists by the name "+data);
	}
}

class NotAtSameLevelException extends Exception{}

class InvalidInput extends Exception
{
	InvalidInput()
	{
		System.out.println("Invalid Input, all employees must have different names");
	}
}

class node
{
	companynode link;
	Object key;
	node parent;
	node right;
	node left;
	int height;
	node()
	{
		link=null;
		key=null;
		parent=null;
		right=null;
		left=null;
	}
}

class avl
{
	node root= new node();

	node higher(node p,node t)
	{
		if(p==null)
			return t;
		else if (t==null)
			return p;
		if(p.height>t.height)	
			return p;
		return t;
	}

	int max(int x,int y)
	{
		if(x>y)
			return x;
		return y;
	}

	void updateheight(node p)
	{
		if(p.left==null && p.right==null)
			p.height=0;
		else if(p.left==null && p.right!=null)
			p.height=p.right.height+1;
		else if(p.left!=null && p.right==null)
			p.height=p.left.height+1;
		else
			p.height=max(p.left.height,p.right.height)+1;
	}

	int mod(int x)
	{
		if(x<0)
			return -x;
		return x;
	}

	void rotate(node z)
	{
		node y = higher(z.left,z.right);
		node x = higher(y.left,y.right);
//RIGHT RIGHT CASE
		if(((String)x.key).compareTo((String)y.key)>0 && ((String)y.key).compareTo((String)z.key)>0)
		{
			node temp;
			temp=y.left;
			y.left=z;
			y.parent=z.parent;
			z.parent=y;
			z.right=temp;
			if(z.right!=null)
				z.right.parent=z;
			if(y.parent!=null)
			{
				if(((String)y.key).compareTo((String)y.parent.key)<0)
					y.parent.left=y;
				else
					y.parent.right=y;
			}
			updateheight(x);
			updateheight(z);
			updateheight(y);
		}
//RIGHT LEFT CASE
		if(((String)x.key).compareTo((String)y.key)<0 && ((String)y.key).compareTo((String)z.key)>0)
		{
			node temp1,temp2;
			temp1=x.left;
			temp2=x.right;
			x.left=z;
			x.right=y;
			x.parent=z.parent;
			z.parent=x;
			y.parent=x;
			z.right=temp1;
			y.left=temp2;	
			if(z.right!=null)
				z.right.parent=z;
			if(y.left!=null)
				y.left.parent=y;
			if(x.parent!=null)
			{
				if(((String)x.key).compareTo((String)x.parent.key)<0)
					x.parent.left=x;
				else
					x.parent.right=x;
			}
			updateheight(z);
			updateheight(y);
			updateheight(x);
		}
//LEFT RIGHT CASE
		if(((String)x.key).compareTo((String)y.key)>0 && ((String)y.key).compareTo((String)z.key)<0)
		{	
			node temp1,temp2;
			temp1=x.left;
			temp2=x.right;
			x.right=z;
			x.left=y;
			x.parent=z.parent;
			z.parent=x;
			y.parent=x;
			z.left=temp2;
			y.right=temp1;
			if(z.left!=null)
				z.left.parent=z;
			if(y.right!=null)
				y.right.parent=y;
			if(x.parent!=null)
			{
				if(((String)x.key).compareTo((String)x.parent.key)<0)
					x.parent.left=x;
				else
					x.parent.right=x;
			}
			updateheight(z);
			updateheight(y);
			updateheight(x);
		}
//LEFT LEFT CASE
		if(((String)x.key).compareTo((String)y.key)<0 && ((String)y.key).compareTo((String)z.key)<0)
		{	
			node temp;
			temp=y.right;
			y.right=z;
			y.parent=z.parent;
			z.parent=y;
			z.left=temp;
			if(z.left!=null)
				z.left.parent=z;
			if(y.parent!=null)
			{
				if(((String)y.key).compareTo((String)y.parent.key)<0)
					y.parent.left=y;
				else
					y.parent.right=y;
			}
			updateheight(x);
			updateheight(z);
			updateheight(y);
		}
	}

	void insert(Object data,node immediateboss) throws DuplicateException, InvalidInput
	{
		if(((String)data).equals((String)immediateboss.key))
			throw new InvalidInput();
		if(root.key==null)
		{
			root.key=data;
			root.height=0;
		}

		else
		{
			node p;
			p=root;
			while(true)
			{
				if(((String)data).equals((String)p.key))
				{
					throw new DuplicateException((String)data);
				}
				else if(((String)data).compareTo((String)p.key)<0)
				{
					if(p.left==null)
					{
						p.left=new node();
						p.left.key=data;
						p.left.parent=p;
						p.left.height=0;
						p.left.link=immediateboss.link.insertunder((String)data);
						break;
					}
					p=p.left;
				}
				else
				{
					if(p.right==null)
					{
						p.right=new node();
						p.right.key=data;
						p.right.parent=p;
						p.right.height=0;
						p.right.link=immediateboss.link.insertunder((String)data);
						break;
					}
					p=p.right;
				}
			}
			while(p!=null)
			{
				if((p.left==null && p.right!=null) || (p.left!=null && p.right==null))
				{
					if(p.left==null)
					{
						if(p.right.height>=1)
							rotate(p);
					}
					else if(p.right==null)
					{
						if(p.left.height>=1)
							rotate(p);
					}
				}
				else if(mod(p.left.height-p.right.height)>=2)
					rotate(p);
				updateheight(p);
				if(p.parent==null)
					root=p;
				p=p.parent;
			}
		}
	}

	void delete(Object data,node other) throws NoSuchEmployeeFoundException, NotAtSameLevelException, InvalidInput
	{
		if(((String)data).equals((String)other.key))
			throw new InvalidInput();
		node p;
		p=root;
//searching the required node
		while(p!=null)
		{
			if(((String)data).equals((String)p.key))
			{
				if(p.link.level!=other.link.level)
					throw new NotAtSameLevelException();
				companynode.delete(p.link,other.link);
				break;
			}
			else if(((String)data).compareTo((String)p.key)<0)
				p=p.left;
			else
				p=p.right;
		}
		if(p==null)
			throw new NoSuchEmployeeFoundException((String)data);
//deletion starts here
		else
		{
			if(p==root && !(p.left!=null && p.right!=null))
			{
				if(p.left==null && p.right==null)
					p.key=null;
				else if(p.left==null && p.right!=null)
				{
					root=p.right;
					p=null;
				}
				else if(p.left!=null && p.right==null)
				{
					root=p.right;
					p=null;
				}
			}
			else
			{
				node start=new node();
				if(p.left!=null && p.right!=null)
				{
					node r;
					r=p.right;
					while(r.left!=null)
						r=r.left;
					p.key=r.key;
					p.link=r.link;
					p=r;
				}
				if(p.left==null && p.right!=null)
				{
					if(((String)p.key).compareTo((String)p.parent.key)<0)
					{
						p.parent.left=p.right;
						p.right.parent=p.parent;
						start=p.parent;
						updateheight(start);
						p=null;
					}
					else
					{
						p.parent.right=p.right;
						p.right.parent=p.parent;
						start=p.parent;
						updateheight(start);
						p=null;
					}
				}
				else if(p.left!=null && p.right==null)
				{
					if(((String)p.key).compareTo((String)p.parent.key)<0)
					{
						p.parent.left=p.left;
						p.left.parent=p.parent;
						start=p.parent;
 						updateheight(start);
						p=null;
					}
					else
					{
						p.parent.right=p.left;
						p.left.parent=p.parent;
						start=p.parent;
 						updateheight(start);
						p=null;
					}
				}
				else if(p.right==null && p.left==null)
				{
					if(((String)p.key).compareTo((String)p.parent.key)<0)
						p.parent.left=null;
					else
						p.parent.right=null;
					start=p.parent;
					updateheight(start);
					p=null;
				}
				while(true)
				{
					if((start.left==null && start.right!=null) || (start.left!=null && start.right==null))
					{
						if(start.left==null)
						{
							if(start.right.height>=1)
								rotate(start);
						}
						else if(start.right==null)
						{
							if(start.left.height>=1)
								rotate(start);
						}
					}
					else if(start.left!=null && start.right!=null)
					{
						if (mod(start.left.height-start.right.height)>=2)
						rotate(start);
					}
					updateheight(start);
					if(start.parent==null)
						break;
					start=start.parent;
				}
				root=start;
			}		
		}
	}
	
	node search(Object data) throws NoSuchEmployeeFoundException
	{
		node p=root;
		while(p!=null)
		{
			if(((String)data).equals((String)p.key))
				break;
			else if(((String)data).compareTo((String)p.key)<0)
			{
				p=p.left;
			}
			else
			{
				p=p.right;
			}
		}
		if(p==null)
			throw new NoSuchEmployeeFoundException((String)data);
		return p;
	}
	
	static void lowestcommonboss(companynode n1,companynode n2) throws InvalidInput
	{
		if(n1.name.equals(n2.name))
			throw new InvalidInput();
		while(n1.level!=n2.level)
		{
			if(n1.level<n2.level)
				n2=n2.boss;
			else
				n1=n1.boss;
		}
		if(n1==n2 && n1.level>1)
			System.out.println("Lowest Common Boss : "+n1.boss.name);
		else if(n1==n2 && n1.level==1)
			System.out.println("No one is boss of "+n1.name);
		else
		{
			while(n1!=n2)
			{
				n1=n1.boss;
				n2=n2.boss;
			}
			System.out.println("Lowest Common Boss : "+n1.name);
		}
	}
}
