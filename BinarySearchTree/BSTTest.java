
class BSTTest
{
	public static void main(String[] args){
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(9);
		tree.insert(13);
		tree.insert(42);
		tree.insert(43);
		tree.insert(30);
		tree.insert(32);
		tree.insert(32);
		tree.insert(5);
		tree.insert(6);
		System.out.println(tree.contains(10));
		System.out.println(tree.contains(50));
		System.out.println(tree.contains(5));
		System.out.println(tree.contains(32));
		tree.print();
		tree.remove(42);
		tree.print();
		tree.remove(35);
		tree.print();
		tree.remove(32);
		tree.print();
		tree.remove(33);
		tree.print();
		tree.remove(30);
		tree.print();
		tree.remove(42);
		tree.print();
		tree.remove(43);
		tree.print();
		tree.remove(45);
		tree.print();
		
	}
}