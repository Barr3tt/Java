package chapter25;

public class TestBST {
	public static void main(String[] args) {
		var tree1 = new BST<KeyValue<String, Integer>>();
		tree1.insert(new KeyValue<String, Integer>("George", 15));
		tree1.insert(new KeyValue<String, Integer>("Michael", 10));
		tree1.insert(new KeyValue<String, Integer>("Tom", 20));
		tree1.insert(new KeyValue<String, Integer>("Adam", 5));
		tree1.insert(new KeyValue<String, Integer>("Jones", 32));
		tree1.insert(new KeyValue<String, Integer>("Peter", 34));
		tree1.insert(new KeyValue<String, Integer>("Daniel", 22));

		var tree2 = new BST<KeyValue<Integer, String>>();
		tree2.insert(new KeyValue<Integer, String>(15, "George"));
		tree2.insert(new KeyValue<Integer, String>(10, "Michael"));
		tree2.insert(new KeyValue<Integer, String>(20, "Tom"));
		tree2.insert(new KeyValue<Integer, String>(5, "Adam"));
		tree2.insert(new KeyValue<Integer, String>(5, "Tony"));
		tree2.insert(new KeyValue<Integer, String>(32, "Jones"));
		tree2.insert(new KeyValue<Integer, String>(34, "Peter"));
		tree2.insert(new KeyValue<Integer, String>(22, "Daniel"));

		// **********************************************************
		
		System.out.println("Output Sorted data using inorder traversal");
		tree1.inorder(e->System.out.println(e));
		System.out.println();
		tree2.inorder(e->System.out.println(e));
		System.out.println();
		
		// **********************************************************
		
		System.out.println("Output Sorted data using iterators");
		var it = tree1.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
		System.out.println();
		var it2 = tree2.iterator();
		while (it2.hasNext())
		{
			System.out.println(it2.next());
		}
		System.out.println();		
		
		// **********************************************************
		
		System.out.println("Output Sorted data using for each loops");
		for (var e : tree1)
			System.out.println(e);
		System.out.println();
		for (var e : tree2)
			System.out.println(e);
		System.out.println();
	}
}
