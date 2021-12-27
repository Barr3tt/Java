package chapter25;

import java.util.*;

public class BST<E extends Comparable<E>> implements Tree<E> {

	protected static class TreeNode<E> {
		public E data;
		public TreeNode<E> left = null;
		public TreeNode<E> right = null;

		public TreeNode(E e) {
			this.data = e;
		}
	}
	
	protected TreeNode<E> root = null;
	protected int size = 0;

	/** Create a default binary tree */
	public BST() {
	}

	/** Create a binary tree from an array of objects */
	public BST(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	/** Recursively duplicate tree */
	private TreeNode<E> copy(TreeNode<E> p) {
		TreeNode<E> temp = null;
		if (p != null) {
			temp = new TreeNode<E>(p.data);
			temp.left = copy(p.left);
			temp.right = copy(p.right);
		}
		return temp;
	}

	public void copyTree(BST<E> p) {
		root = copy(p.root);
	}


	@Override /** Remove all elements from the tree */
	public void clear() {
		root = null;
		size = 0;
	}

	@Override /** Get the number of nodes in the tree */
	public int getSize() {
		return size;
	}

	/** Returns the root of the tree */
	public TreeNode<E> getRoot() {
		return root;
	}
	
	// **************************************************************************************************
	// Traversals
//	@Override
//	public void inorder() {
//		inorder(root, new Execution<E>() {
//			public void execute(E e) {
//				System.out.println(e);
//			}});
//	}	
	
	@Override
	public void inorder() {
		inorder(root, e -> System.out.println(e));
	}
	
	public void inorder(Execution<E> e) {
		inorder(root, e);
	}	
	
	@Override
	public void preorder() {
		preorder(root, e -> System.out.println(e));
	}

	public void preorder(Execution<E> e) {
		preorder(root, e);
	}

	@Override
	public void postorder() {
		postorder(root, e -> System.out.println(e));
	}
	
	public void postorder(Execution<E> e) {
		postorder(root, e);
	}
	

	private void inorder(TreeNode<E> p, Execution<E> e) {
		if (p != null) {
			inorder(p.left, e);
			e.execute(p.data);
			inorder(p.right, e);
		}
	}

	private void preorder(TreeNode<E> p, Execution<E> e) {
		if (p != null) {
			e.execute(p.data);
			preorder(p.left, e);
			preorder(p.right, e);
		}
	}

	private void postorder(TreeNode<E> p, Execution<E> e) {
		if (p != null) {
			postorder(p.left, e);
			postorder(p.right, e);
			e.execute(p.data);
		}
	}

	// **************************************************************************************************
	// Recursive Counting Routines

	public int treeHeight() {
		return height(root);
	}

	public int treeNodeCount() {
		return nodeCount(root);
	}

	public int treeLeavesCount() {
		return leavesCount(root);
	}

	private int height(TreeNode<E> p) {
		if (p == null)
			return 0;
		else
			return 1 + Math.max(height(p.left), height(p.right));
	}

	private int nodeCount(TreeNode<E> p) {
		if (p == null)
			return 0;
		else
			return 1 + nodeCount(p.left) + nodeCount(p.right);
	}

	private int leavesCount(TreeNode<E> p) {
		if (p == null)
			return 0;
		else if (p.left == null && p.right == null)
			return 1;
		else
			return leavesCount(p.left) + leavesCount(p.right);
	}

	@Override /** Returns true if the data is in the tree */
	public boolean search(E e) {
		TreeNode<E> current = root; // Start from the root

		while (current != null) {
			if (e.compareTo(current.data) < 0) {
				current = current.left;
			} else if (e.compareTo(current.data) > 0) {
				current = current.right;
			} else // data matches current.data
				return true; // data is found
		}

		return false;
	}

	public boolean recSearch(E searchItem) {
		return recSearch(root, searchItem);
	}

	private boolean recSearch(TreeNode<E> ptr, E searchItem) {
		if (ptr == null)
			return false;
		else if (searchItem.equals(ptr.data))
			return true;
		else if (searchItem.compareTo(ptr.data) < 0)
			return recSearch(ptr.left, searchItem);
		else
			return recSearch(ptr.right, searchItem);
	}	
	
	@Override /**
				 * Insert data e into the binary tree Return true if the data is inserted
				 * successfully
				 */
	public boolean insert(E e) {
		if (root == null)
			root =  new TreeNode<E>(e); // Create a new root
		else {
			// Locate the parent node
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null)
				if (e.compareTo(current.data) < 0) {
					parent = current;
					current = current.left;
				} else if (e.compareTo(current.data) > 0) {
					parent = current;
					current = current.right;
				} else
					return false; // Duplicate node not inserted

			// Create the new node and attach it to the parent node
			if (e.compareTo(parent.data) < 0)
				parent.left = new TreeNode<E>(e);
			else
				parent.right = new TreeNode<E>(e);
		}

		size++;
		return true; // data inserted successfully
	}

	public void recinsert(E e) {
		root = recinsertHelper(root, e);
	}

	private TreeNode<E> recinsertHelper(TreeNode<E> p, E e) {
		TreeNode<E> retval;
		if (p == null) {
			TreeNode<E> newNode = new TreeNode<E>(e);
			retval = newNode;
		} else if (e.compareTo(p.data) < 0) {
			p.left = recinsertHelper(p.left, e);
			retval = p;
		} else if (e.compareTo(p.data) == 0)
			retval = p;
		else {
			p.right = recinsertHelper(p.right, e);
			retval = p;
		}
		return retval;
	}

	/** Returns a path from the root leading to the specified data */
	public ArrayList<TreeNode<E>> path(E e) {
		var list = new ArrayList<TreeNode<E>>();
		TreeNode<E> current = root; // Start from the root

		while (current != null) {
			list.add(current); // Add the node to the list
			if (e.compareTo(current.data) < 0) {
				current = current.left;
			} else if (e.compareTo(current.data) > 0) {
				current = current.right;
			} else
				break;
		}

		return list; // Return an array list of nodes
	}

	@Override /**
				 * Delete an data from the binary tree. Return true if the data is deleted
				 * successfully Return false if the data is not in the tree
				 */
	public boolean delete(E e) {
		// Locate the node to be deleted and also locate its parent node
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		while (current != null) {
			if (e.compareTo(current.data) < 0) {
				parent = current;
				current = current.left;
			} else if (e.compareTo(current.data) > 0) {
				parent = current;
				current = current.right;
			} else
				break; // data is in the tree pointed at by current
		}

		if (current == null)
			return false; // data is not in the tree

		// Case 1: current has no left child
		if (current.left == null) {
			// Connect the parent with the right child of the current node
			if (parent == null) {
				root = current.right;
			} else {
				if (e.compareTo(parent.data) < 0)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		} else {
			// Case 2: The current node has a left child
			// Locate the rightmost node in the left subtree of
			// the current node and also its parent
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;

			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right; // Keep going to the right
			}

			// Replace the data in current by the data in rightMost
			current.data = rightMost.data;

			// Eliminate rightmost node
			if (parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else
				// Special case: parentOfRightMost == current
				parentOfRightMost.left = rightMost.left;
		}

		size--;
		return true; // data deleted successfully
	}

	public void recdelete(E e) {
		root = recdeleteHelper(root, e);
	}

	private TreeNode<E> recdeleteHelper(TreeNode<E> p, E e) {
		TreeNode<E> retval;
		if (p == null)
			retval = null;
		else if (e.compareTo(p.data) < 0) { // p.data > insertItem
			p.left = recdeleteHelper(p.left, e);
			retval = p;
		} else if (e.compareTo(p.data) < 0) {
			p.right = recdeleteHelper(p.right, e);
			retval = p;
		} else { // Found Item to delete!!!
			size--;
			if (p.left == null && p.right == null)
				retval = null;
			else if (p.left == null)
				retval = p.right;
			else if (p.right == null)
				retval = p.left;
			else {
				// Find Item whose value is immediately before p.data
				TreeNode<E> current = p.left;
				while (current.right != null)
					current = current.right;
				p.data = current.data;
				p.left = recdeleteHelper(p.left, current.data);
				retval = p;
			}
		}
		return retval;
	}

	// Create code to support Iteration through this data Structure
	@Override 
	public Iterator<E> iterator() {
		return new InorderIterator();
	}

	// Inner class InorderIterator
	private class InorderIterator implements Iterator<E> {
		// Store the elements in a list
		private ArrayList<E> list = new ArrayList<>();
		private int current = 0; // Point to the current data in list

		public InorderIterator() {
			inorder(); // Traverse binary tree and store elements in list
		}

		/** Inorder traversal from the root */
		private void inorder() {
			inorder(root);
		}

		/** Inorder traversal from a subtree */
		private void inorder(TreeNode<E> root) {
			if (root == null)
				return;
			inorder(root.left);
			list.add(root.data);
			inorder(root.right);
		}

		@Override /** More elements for traversing? */
		public boolean hasNext() {
			return current < list.size();
		}

		@Override /** Get the current data and move to the next */
		public E next() {
			return list.get(current++);
		}

		@Override // Remove the data returned by the last next()
		public void remove() {
			if (current == 0) // next() has not been called yet
				throw new IllegalStateException();

			delete(list.get(--current));
			list.clear(); // Clear the list
			inorder(); // Rebuild the list
		}
	}

}
