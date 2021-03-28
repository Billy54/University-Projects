//Vasileios Gewrgoulas
//A.M. 2954


class TreeNode<T extends myComparable > {

	private T value;
	private TreeNode<T> parent;
	private TreeNode<T> rightchild;
	private TreeNode<T> leftchild;
	
	public TreeNode(T x){
		value=x;
	}
	public boolean isLeaf(){
		return (leftchild == null && rightchild == null);
	}
	public boolean isRightChild(){
		return (parent.value.compareTo(value)<=0);
	}
	public boolean isLeftChild(){
		return (parent.value.compareTo(value)>0);
	}
	public void setparent(TreeNode<T> Oparent){
		parent = Oparent;
	}
	public void setleftchild(TreeNode<T> Ochild){
		leftchild = Ochild;
	}
	public void setrightchild(TreeNode<T> Ochild){
		rightchild = Ochild;
	}
	public TreeNode<T> getparent(){
		return parent;
	}
	public TreeNode<T> getleftchild(){
		return leftchild;
	}
	public TreeNode<T> getrightchild(){
		return rightchild;
	}
	public T getnodevalue(){
		return value;
	}
	public void setnodevalue(T x){
		value = x;
	}
}
