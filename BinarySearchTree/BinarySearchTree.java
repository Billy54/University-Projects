//Vasileios Gewrgoulas
//A.M. 2954


class BinarySearchTree {
	
	private TreeNode root;
	
	public boolean contains(int x){
		if(root==null){return false;}
		return contains(x,root);
	}
	private boolean contains(int x,TreeNode t){
		if(t==null){
			return false;
		}
		else if(t.getnodevalue()==x){
			return true;
		}
		else if(x>t.getnodevalue()){
			return contains(x,t.getrightchild());
		}
		return contains(x,t.getleftchild());
	}
	public void insert(int x){
		TreeNode TN = new TreeNode(x);{
			if(root == null){
				root = TN;
			}
			else{
				insert(root,TN);}
		}
	}
	private void insert(TreeNode t,TreeNode node){
		if(t.getnodevalue()<node.getnodevalue()){
			if(t.getrightchild()==null){
				node.setparent(t);
				t.setrightchild(node);
			}
			else{
				insert(t.getrightchild(),node);
			}
		}
		else if(t.getnodevalue()>node.getnodevalue()){
			if(t.getleftchild()==null){
				node.setparent(t);
				t.setleftchild(node);
			}
			else{
				insert(t.getleftchild(), node);
			}
		}
	}
	public void print(){
		System.out.print("[");
		orderedPrint(root);
		System.out.println("]");
	}
	private void orderedPrint(TreeNode t){
		if(t==null){return;}
		orderedPrint(t.getleftchild());
		System.out.print(t.getnodevalue()+",");
		orderedPrint(t.getrightchild());
	}
	public void remove(int x){
		if(!contains(x)){return;}
		TreeNode node = find(x,root);
		if(node.isLeaf()){
			removeLeaf(node);
		}
		else if(node.getrightchild()!=null && node.getleftchild()!=null){
			removeNode2(node);
		}
		else{
			removeNode1(node);
		}
	}
	private void removeLeaf(TreeNode node){
		if(node==root){
			root=null;
		}
		else if(node.isRightChild()){
			node.getparent().setrightchild(null);				//case1 : node is a leaf
		}
		else{
			node.getparent().setleftchild(null);
		}
	}
	private void removeNode1(TreeNode node){
		if(node.getrightchild()!=null){
			node.getrightchild().setparent(node.getparent());
			if(node!=root){
				if(node.getrightchild().getnodevalue()<node.getparent().getnodevalue()){
					node.getparent().setleftchild(node.getrightchild());
				}
				else{
					node.getparent().setrightchild(node.getrightchild());
				}
			}
			else{root=node.getrightchild();}
		}
		else{															//case2 : node has a child
			node.getleftchild().setparent(node.getparent());
			if(node!=root){
				if(node.getleftchild().getnodevalue()<node.getparent().getnodevalue()){
					node.getparent().setleftchild(node.getleftchild());
				}
				else{
					node.getparent().setrightchild(node.getleftchild());
				}
			}
			else{root=node.getleftchild();}
		}	
	}
	private void removeNode2(TreeNode node){
		TreeNode t=node.getrightchild();
		while(t.getleftchild()!=null){
			t=t.getleftchild();
		}													//case3 : node has two children
		node.setnodevalue(t.getnodevalue());	
		if(t.isLeaf()){removeLeaf(t);}
	 	else{removeNode1(t);}
	}
	private TreeNode find(int x,TreeNode t){
		if(t.getnodevalue()==x){
			return t;
		}
		else if(x>t.getnodevalue()){
			return find(x,t.getrightchild());
		}
		return find(x,t.getleftchild());
	}
}
