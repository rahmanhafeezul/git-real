public class stackx
{private int maxsize;
private Object[] stackarray;
private int top;
public stackx(int max)
{maxsize=max;
stackarray=new Object[maxsize];
top=-1;
}
public void push(Object j)
{stackarray[++top]=j;
}
public Object pop()
{return stackarray[top--];
}
public Object top()
{return stackarray[top];
}
public boolean isEmpty()
{if(top==-1)
return true;
else 
return false;
}
}

