
public class AvlTree { 
 protected AvlNode root;   
 public void insert(int k) {  
  AvlNode n = new AvlNode(k);  
  insertion(this.root,n);
 }  
 public void insertion(AvlNode p, AvlNode q) {  
  if(p==null) {
   this.root=q;
  } else {      
   if(q.key<p.key) {
    if(p.leftchild==null) {
     p.leftchild = q;
     q.parent = p;       
     Balancing_function(p);
    } else {
     insertion(p.leftchild,q);
    }   
   } else if(q.key>p.key) {
    if(p.rightchild==null) {
     p.rightchild = q;
     q.parent = p;        
     Balancing_function(p);
    } else {
     insertion(p.rightchild,q);
    }
   } else {    
   }
  }
 } 
public void deletion(AvlNode p,int q) {
  if(p==null) {   
   return;
  } else {
   if(p.key>q)  {
    deletion(p.leftchild,q);
   } else if(p.key<q) {
    deletion(p.rightchild,q);
   } else if(p.key==q) {    
    if_found(p);
   }
  }
 } 
 public void Balancing_function(AvlNode current) {  
  setBalance(current);
  int balance = current.balance;  
  if(balance==-2) {   
   if(height(current.leftchild.leftchild)>=height(current.leftchild.rightchild)) {
    current = singlerotate1(current);
   } else {
    current = doubeRotate1(current);
   }
  } else if(balance==2) {
   if(height(current.rightchild.rightchild)>=height(current.rightchild.leftchild)) {
    current = singlerotate(current);
   } else {
    current = doubeRotate2(current);
   }
  }  
  if(current.parent!=null) {
   Balancing_function(current.parent);
  } else {
   this.root = current;   
  }
 } 
 public void remove(int k) { 
  deletion(this.root,k);
 }

 
 public void if_found(AvlNode q) {
  AvlNode r;  
  if(q.leftchild==null || q.rightchild==null) {   
   if(q.parent==null) {
    this.root=null;
    q=null;
    return;
   }
   r = q;
  } else {   
   r = successor(q);
   q.key = r.key;
  } 
  AvlNode p;
  if(r.leftchild!=null) {
   p = r.leftchild;
  } else {
   p = r.rightchild;
  } 
  if(p!=null) {
   p.parent = r.parent;
  } 
  if(r.parent==null) {
   this.root = p;
  } else {
   if(r==r.parent.leftchild) {
    r.parent.leftchild=p;
   } else {
    r.parent.rightchild = p;
   }  
   Balancing_function(r.parent);
  }
  r = null;
 } 
 public AvlNode singlerotate(AvlNode n) { 
  AvlNode v = n.rightchild;
  v.parent = n.parent; 
  n.rightchild = v.leftchild; 
  if(n.rightchild!=null) {
   n.rightchild.parent=n;
  } 
  v.leftchild = n;
  n.parent = v; 
  if(v.parent!=null) {
   if(v.parent.rightchild==n) {
    v.parent.rightchild = v;
   } else if(v.parent.leftchild==n) {
    v.parent.leftchild = v;
   }
  } 
  setBalance(n);
  setBalance(v); 
  return v;
 } 
 public AvlNode singlerotate1(AvlNode n) { 
  AvlNode v = n.leftchild;
  v.parent = n.parent; 
  n.leftchild = v.rightchild; 
  if(n.leftchild!=null) {
   n.leftchild.parent=n;
  } 
  v.rightchild = n;
  n.parent = v; 
  if(v.parent!=null) {
   if(v.parent.rightchild==n) {
    v.parent.rightchild = v;
   } else if(v.parent.leftchild==n) {
    v.parent.leftchild = v;
   }
  } 
  setBalance(n);
  setBalance(v); 
  return v;
 } 
 public AvlNode doubeRotate1(AvlNode u) {
  u.leftchild = singlerotate(u.leftchild);
  return singlerotate1(u);
 }
 public AvlNode doubeRotate2(AvlNode u) {
  u.rightchild = singlerotate1(u.rightchild);
  return singlerotate(u);
 }
 public AvlNode successor(AvlNode q) {
  if(q.rightchild!=null) {
   AvlNode r = q.rightchild;
   while(r.leftchild!=null) {
    r = r.leftchild;
   }
   return r;
  } else {
   AvlNode p = q.parent;
   while(p!=null && q==p.rightchild) {
    q = p;
    p = q.parent;
   }
   return p;
  }
 } 
 private int height(AvlNode current) {
  if(current==null) {
   return -1;
  }
  if(current.leftchild==null && current.rightchild==null) {
   return 0;
  } else if(current.leftchild==null) {
   return 1+height(current.rightchild);
  } else if(current.rightchild==null) {
   return 1+height(current.leftchild);
  } else {
   return 1+maximum(height(current.leftchild),height(current.rightchild));
  }
 } 
 private int maximum(int a, int b) {
  if(a>=b) {
   return a;
  } else {
   return b;
  }
 } 
 public void print(AvlNode n) {
  int l = 0;
  int r = 0;
  int p = 0;
  if(n.leftchild!=null) {
   l = n.leftchild.key;
  }
  if(n.rightchild!=null) {
   r = n.rightchild.key;
  }
  if(n.parent!=null) {
   p = n.parent.key;
  } 
  System.out.println("{   leftchild: "+l+" Key: "+n.key+" rightchild: "+r+" Parent: "+p+" Balance: "+n.balance+"   }");  
 } 
 private void setBalance(AvlNode current) {
  current.balance = height(current.rightchild)-height(current.leftchild);
 } 
 public void inorder(AvlNode n) {   	
  if (n == null) {
   return;
  }
  inorder(n.leftchild);
  print(n);
  inorder(n.rightchild);
 }
}
 class AvlNode {
 public AvlNode leftchild;
 public AvlNode rightchild;
 public AvlNode parent;
 
 public int key;
 public int balance;
 public AvlNode(int k) {
  leftchild = rightchild = parent = null;
  balance = 0;
  key = k;
 }
 
 }

