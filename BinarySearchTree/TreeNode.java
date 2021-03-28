//Vasileios Gewrgoulas
//A.M. 2954


class TreeNode {
	
	private int nodevalue;
	private TreeNode parent;
	private TreeNode rightchild;
	private TreeNode leftchild;
	
	public TreeNode(int x){
		nodevalue=x;
	}
	public boolean isLeaf(){
		return (leftchild == null && rightchild == null);
	}
	public boolean isRightChild(){
		return (parent.nodevalue <= nodevalue);
	}
	public boolean isLeftChild(){
		return (parent.nodevalue > nodevalue);
	}
	public void setparent(TreeNode Oparent){
		parent = Oparent;
	}
	public void setleftchild(TreeNode Ochild){
		leftchild = Ochild;
	}
	public void setrightchild(TreeNode Ochild){
		rightchild = Ochild;
	}
	public TreeNode getparent(){
		return parent;
	}
	public TreeNode getleftchild(){
		return leftchild;
	}
	public TreeNode getrightchild(){
		return rightchild;
	}
	public int getnodevalue(){
		return nodevalue;
	}
	public void setnodevalue(int x){
		nodevalue = x;
	}
}
