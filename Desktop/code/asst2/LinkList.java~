class Link
{
	public int iData;
	public double dData;
	public Link next;
	public Link parent;
	public AvlNode ref_to_avl;
	public AvlNode dummy_ref;
	
	public Link(int id,double dd)
	{
		iData=id;
		dData=dd;
	}
	public void displayLink()
	{
		System.out.println("{"+iData+","+dData+"}");
	}}
class LinkList
{	private Link first;
public LinkList<Link> children;
	
	
	public LinkList()
	{first=null;
	}
	public boolean isEmpty()
	{return (first==null);
	}
	public void insertFirst(int id,double dd)
	{
	Link newLink=new Link(id,dd);
	newLink.next=first;
	first=newLink;
	}
	public Link deleteFirst()
	{
	Link temp=first;
	first=first.next;
	return temp;
	}
	public void displayList()
	{	System.out.println("List(First-->last):");
		Link current=first;
		while(current!=null)
		{
			current.displayLink();
			current=current.next;
		}
		System.out.println(" ");
	}}
	
