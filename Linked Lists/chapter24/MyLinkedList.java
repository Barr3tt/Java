package chapter24;
/*
 * Name: Barrett A. Williamson
 * Date: 12/2/2021
 * Course Number: CSC-220
 * Course Name: Data Structures
 * Problem Number: 10
 * Email: bawilliamson0001@student.stcc.edu
 * Linked List class with all main methods.
 */

public class MyLinkedList<E> implements MyList<E> {
	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data) {
			this(data, null);
		}

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head, tail;
	private int size = 0; // Number of datas in the list

	/** Create an empty list */
	public MyLinkedList() {
	}

	/** Create a list from an array of objects */
	public MyLinkedList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			this.add(objects[i]);
	}

	/** Return the head data in the list */
	public E getFirst() {
		if (head != null) {
			return head.data;
		}
		return null;
	}

	/** Return the last data in the list */
	public E getLast() {
		if (tail != null) {
			return tail.data;
		}
		return null;
	}

	/** Add an data to the beginning of the list */
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e); // Create a new node
		newNode.next = head; // link the new node with the head
		head = newNode; // head points to the new node
		size++; // Increase list size

		if (tail == null) // the new node is the only node in list
			tail = head;
	}

	/** Add an data to the end of the list */
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e); // Create a new for data e

		if (tail == null) {
			head = tail = newNode; // The new node is the only node in list
		} else {
			tail.next = newNode; // Link the new with the last node
			tail = newNode; // tail now points to the last node
		}

		size++; // Increase size
	}

	@Override /**
				 * Add a new data at the specified index in this list. The index of the head
				 * data is 0
				 */
	public void add(int index, E e) {
		if (index == 0) {
			addFirst(e);
		} else if (index >= size) {
			addLast(e);
		} else {
			Node<E> current = head;
			Node<E> prev = null;
			for (int i = 0; i < index; i++) {
				prev = current;
				current = current.next;
			}
			Node<E> newNode = new Node<>(e);
			prev.next = newNode;
			newNode.next = current;
			size++;
		}
	}

	/**
	 * Remove the head node and return the object that is contained in the removed
	 * node.
	 */
	public E removeFirst() {
		if (size == 0) {
			return null;
		} else {
			E temp = head.data;
			head = head.next;
			size--;
			if (head == null) {
				tail = null;
			}
			return temp;
		}
	}

	/**
	 * Remove the last node and return the object that is contained in the removed
	 * node.
	 */
	public E removeLast() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			E temp = head.data;
			head = tail = null;
			size = 0;
			return temp;
		} else {
			Node<E> current = head;

			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}

			E temp = tail.data;
			tail = current;
			tail.next = null;
			size--;
			return temp;
		}
	}

	@Override /**
				 * Remove the data at the specified position in this list. Return the data that
				 * was removed from the list.
				 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			return null;
		} else if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node<E> current = head;
			Node<E> prev = null;
			for (int i = 0; i < index; i++) {
				prev = current;
				current = current.next;
			}

			prev.next = current.next;
			size--;
			return current.data;
		}
	}

	@Override /** Override toString() to return datas in the list */
	public String toString() {
		StringBuilder result = new StringBuilder("[");

		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.data);
			current = current.next;
			if (current != null) {
				result.append(", "); // Separate two datas with a comma
			} else {
				result.append("]"); // Insert the closing ] in the string
			}
		}

		return result.toString();
	}

	@Override /** Clear the list */
	public void clear() {
		size = 0;
		head = tail = null;
	}

	@Override /** Return true if this list contains the data e */
	public boolean contains(Object e) {
		return indexOf(e) != -1;

	}

	@Override /** Return the data at the specified index */
	public E get(int index) {

		int currentIndex = 0;
		Node<E> current = head;
		while (currentIndex != index) {
			current = current.next;
			currentIndex++;
		}
		return current.data;
	}

	@Override /**
				 * Return the index of the head matching data in this list. Return -1 if no
				 * match.
				 */
	public int indexOf(Object e) {
		int index = 0;
		Node<E> current = head;
		while (current != null) {
			if (current.data.equals(e))
				return index;

			index++;
			current = current.next;

		}
		return -1;
	}

	@Override /**
				 * Return the index of the last matching data in this list. Return -1 if no
				 * match.
				 */
	public int lastIndexOf(E e) {
		int index = 0;
		int count = -1;

		Node<E> currentIndex = head;

		while (currentIndex.next != null) {
			if (currentIndex.data.equals(e)) {
				count = index;
			}
			index++;
			currentIndex = currentIndex.next;

			if (currentIndex.data.equals(e)) {
				count = index;

			}
		}

		return count;
	}

	@Override /**
				 * Replace the data at the specified position in this list with the specified
				 * data.
				 */
	public E set(int index, E e) {
		remove(index);
		add(index,e);
		return e;
		
	}

	@Override /** Return the number of datas in this list */
	public int size() {
		return size;
	}

	@Override /** Override iterator() defined in Iterable */
	public java.util.Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements java.util.Iterator<E> {
		private Node<E> current = head; // Current index

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public E next() {
			E e = current.data;
			current = current.next;
			return e;
		}

		@Override
		public void remove() {
			// Left as an exercise
		}
	}

}