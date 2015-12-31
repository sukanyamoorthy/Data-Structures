package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Binary_Tree {
	
static Node root;



Binary_Tree(){
	root=null;
}
public static void insert(int data){
	Node new_node=new Node(data);
	if(root==null)
		root=new_node;
	else
		insert_node(root,data);
	
}
public static void insert_node(Node curr, int data){
	if(curr.getdata()>data){
		if(curr.left==null){
			curr.setleft(new Node(data));
		}
		else
		insert_node(curr.getleft(),data);
	}
	else if (curr.getdata()<data){
		if(curr.getright()==null)
			curr.setright(new Node(data));
		else
		insert_node(curr.getright(),data);
	}
	
}
public static void preorder(Node root){
	if(root==null)return;
	System.out.print(root.data+" ");
	preorder(root.getleft());
	preorder(root.getright());
}
public static void iterative_preorder(Node curr){
	Stack<Node> stack= new Stack<Node>();
	while(curr!=null){
		System.out.print(curr.data+" ");
		stack.push(curr);
		curr=curr.left;
	}
	while(stack.size()>0){
		Node out=stack.pop();
		
		if(out.right!=null){
			out=out.right;
			while(out!=null){
				System.out.print(out.data+" ");
				stack.push(out);
				out=out.left;
			}
		}
		
		
	}
}
public static void postorder(Node root){
	if(root==null)return;
	postorder(root.getleft());
	
	postorder(root.getright());
	System.out.print(root.data+" ");
}
public static void iterative_postorder(Node curr){
	Stack<Node> stack= new Stack<Node>();
	while(curr!=null){
		stack.push(curr);
		curr=curr.left;
	}
	while(stack.size()>0){
		Node out=stack.pop();
		Node parent=out;
		//System.out.print(out.data+" ");
		if(out.right!=null){
			out=out.right;
			while(out!=null){
				stack.push(out);
				out=out.left;
			}
		}
		
		
	}
}
public static void level_order(Node curr){
	Queue<Node> q = new LinkedList<Node>();
	q.add(curr);
	while(!q.isEmpty()){
		Node tmp=q.remove();
		System.out.print(tmp.data+" ");
		if(tmp.left!=null)
			q.add(tmp.left);
		if(tmp.right!=null)
			q.add(tmp.right);
	}
}
public static void inorder(Node root){
	if(root==null)return;
	inorder(root.getleft());
	System.out.print(root.data+" ");
	inorder(root.getright());
}
public static int sizeoftree(Node curr){

	if (curr==null){
		
	return 0;
	}
	else {
		
		return 1+sizeoftree(curr.left)+sizeoftree(curr.right);}
}
	
public static void iterative_inorder(Node curr){
	Stack<Node> stack= new Stack<Node>();
	while(curr!=null){
		stack.push(curr);
		curr=curr.left;
	}
	while(stack.size()>0){
		Node out=stack.pop();
		System.out.print(out.data+" ");
		if(out.right!=null){
			out=out.right;
			while(out!=null){
				stack.push(out);
				out=out.left;
			}
		}
		
		
	}
}
public String toString(){
if(root!=null){
	
	return root.toString();
}
return "";
}
public static Node searchnode(Node root,int data){
	
	return root;
}
public static int height(Node curr){
	//iterative level order - incr count at each level;
	if(curr==null)
	return 0;
	else return 1+Math.max(height(curr.left), height(curr.right));
}
public static boolean structural_identical(Node root1, Node root2){
	if(root1==root2)
		return true;
	else if((root1==null)||(root2==null))
		return false;
	else return ((root1.data==root2.data) &&(structural_identical(root1.left,root2.left))&&(structural_identical(root1.right,root2.right)));
}
public static void main(String args[]){
	Binary_Tree tree= new Binary_Tree();
	tree.insert(20);
	tree.insert(10);
	tree.insert(5);
	tree.insert(11);
	tree.insert(30);
	tree.insert(25);
	tree.insert(40);
	//System.out.println(root);
	System.out.println("inorder");
	inorder(root);
	System.out.println("");
	System.out.println("i inorder");
	iterative_inorder(root);
	System.out.println("");
	System.out.println("preorder");
	preorder(root);
	System.out.println("");
	System.out.println("i preorder");
	iterative_preorder(root);
	System.out.println("");
	System.out.println("level");
	level_order(root);
	System.out.println("");
	System.out.println("size");
	System.out.print(sizeoftree(root));
	System.out.println("");
	System.out.println("identical");
	System.out.println(structural_identical(root,root));
	System.out.println("height");
	System.out.println(height(root));
}


}
