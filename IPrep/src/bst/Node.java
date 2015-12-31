package bst;


class Node{
	int data;
	Node left;
	Node right;

Node(int n){
	this.data=n;
	left=null;
	right=null;
}
public void setleft(Node node){
	this.left=node;
	
}
public void setright(Node node){
	this.right=node;
	
}
public Node getright(){
	return right;
	
}
public Node getleft(){
	return left;
	
}
public void setdata(int val){
	this.data=val;
	
}
public int getdata(){
	return data;
}

Node(int n,Node left,Node right){
	this.data=n;
	this.left=left;
	this.right=right;
} 

public String toString(){
	String tree_node = data+" ";
	if(left!=null){
		tree_node=left+ "-"+tree_node;
	}
	if(right !=null){
		tree_node =tree_node+ "-"+right;
	}
	return tree_node;
}
}
