//Vasileios Gewrgoulas
//A.M. 2954


class BinarySearchTree<T extends myComparable> {
	
	private TreeNode<T> root;
	
	public boolean contains(T x){
		if(root==null){return false;}
		return contains(x,root);
	}
	private boolean contains(T x,TreeNode<T> t){
		if(t==null){
			return false;
		}
		else if(t.getnodevalue().compareTo(x)==0){
			return true;
		}
		else if(x.compareTo(t.getnodevalue())>0){
			return contains(x,t.getrightchild());
		}
		return contains(x,t.getleftchild());
	}
	public void insert(T x){
		TreeNode<T> TN = new TreeNode<T>(x);
			if(root == null){
				root = TN;
			}
			else{
				insert(root,TN);}
	}
	private void insert(TreeNode<T> t,TreeNode<T> node){
		if(t.getnodevalue().compareTo(node.getnodevalue())<0){
			if(t.getrightchild()==null){
				node.setparent(t);
				t.setrightchild(node);
			}
			else{
				insert(t.getrightchild(),node);
			}
		}
		else if(t.getnodevalue().compareTo(node.getnodevalue())>0){
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
		orderedPrint(root);
	}
	private void orderedPrint(TreeNode<T> t){
		if(t==null){return;}
		orderedPrint(t.getleftchild());
		System.out.println(t.getnodevalue());
		orderedPrint(t.getrightchild());
	}
	public void remove(T x){
		if(!contains(x)){return;}
		TreeNode<T> node = find(x,root);
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
	private void removeLeaf(TreeNode<T> node){
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
	private void removeNode1(TreeNode<T> node){
		if(node.getrightchild()!=null){
			node.getrightchild().setparent(node.getparent());
			if(node!=root){
				if(node.getrightchild().getnodevalue().compareTo(node.getparent().getnodevalue())<0){
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
				if(node.getleftchild().getnodevalue().compareTo(node.getparent().getnodevalue())<0){
					node.getparent().setleftchild(node.getleftchild());
				}
				else{
					node.getparent().setrightchild(node.getleftchild());
				}
			}
			else{root=node.getleftchild();}
		}	
	}
	private void removeNode2(TreeNode<T> node){
		TreeNode<T> t=node.getrightchild();
		while(t.getleftchild()!=null){
			t=t.getleftchild();
		}													//case3 : node has two children
		node.setnodevalue(t.getnodevalue());	
		if(t.isLeaf()){removeLeaf(t);}
	 	else{removeNode1(t);}
	}
	private TreeNode<T> find(T x,TreeNode<T> t){
		if(t.getnodevalue().compareTo(x)==0){
			return t;
		}
		else if(x.compareTo(t.getnodevalue())>0){
			return find(x,t.getrightchild());
		}
		return find(x,t.getleftchild());
	}
}
