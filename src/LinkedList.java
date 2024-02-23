
public class LinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	/*
	 * Creates an empty list.
	 */
	public LinkedList() {

	}

	/*
	 * Returns a space-separated list of the elements in the list. If the list
	 * contains no elements, return an empty string ""
	 */
	public String toString() {

		if (isEmpty()) {

			return "";

		} else {

			Node<T> current = head;
			String returnString = "";

			while (current != null) {

				returnString = returnString + "\n" + (current.data).toString();

				current = current.next;

			}

			return returnString;
		}
	}

	public void insertFirst(T num) {

		// if list is empty, head and tail point to the same link
		if (isEmpty()) {
			Node<T> newNode = new Node<T>(num);

			head = newNode;
			tail = newNode;

		} else {

			Node<T> newNode = new Node<T>(num);

			newNode.next = head;

			head = newNode;

		}

		size++;

	}

	public void insertLast(T num) {

		// if list is empty, head and tail point to the same link
		if (isEmpty()) {
			Node<T> newNode = new Node<T>(num);

			head = newNode;
			tail = newNode;

			size++;

		} else {

			Node<T> newNode = new Node<T>(num);

			Node<T> current = head;

			while (current.next != null) {

				current = current.next;

			}

			current.next = tail;
			tail.next = newNode;
			tail = newNode;

			size++;

		}

	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {

		if (size == 0) {

			return true;

		}

		return false;
	}

	public void mergeSortStarter() {
		head = mergeSort(head);
	}

	
	//parts of this method came from https://www.geeksforgeeks.org/merge-sort-for-linked-list/
	private Node<T> mergeSort(Node<T> passedNode) {

		if (passedNode == null || passedNode.next == null) {
			return passedNode;
		}

		// Find middle node
		Node<T> middle = getMiddle(passedNode);
		Node<T> nextOfMiddle = middle.next;
		middle.next = null;

		// Apply mergeSort on left list
		Node<T> left = mergeSort(passedNode);

		// Apply mergeSort on right list
		Node<T> right = mergeSort(nextOfMiddle);

		// Merge the left and right lists
		return sortedMerge(left, right);
	}

	
	//parts of this method came from https://www.geeksforgeeks.org/merge-sort-for-linked-list/
	@SuppressWarnings("unchecked")
	private Node<T> sortedMerge(Node<T> a, Node<T> b) {
		
		Node<T> result = null;

		if (a == null) {
			return b;
		}
		
		if (b == null) {
			return a;
		}

		// Choose either a or b and recur
		if (((Comparable<T>) a.data).compareTo(b.data) <= 0) {
			
			result = a;
			result.next = sortedMerge(a.next, b);
		
		} else {
			
			result = b;
			
			result.next = sortedMerge(a, b.next);
		}
		
		return result;
	}

	//parts of this method came from https://www.geeksforgeeks.org/merge-sort-for-linked-list/
	private Node<T> getMiddle(Node<T> node) {
		if (node == null) {
			return node;
		}

		Node<T> slow = node;
		Node<T> fast = node.next;

		while (fast != null && fast.next != null) {
		
			slow = slow.next;
		
			fast = fast.next.next;
		
		}
		
		return slow;
	}

	// A private Node class. By making it an inner class,
	// the outer class can access it easily, but the client cannot.
	private class Node<E> {
		private E data;
		private Node<E> next;

		// Constructs a new node with the specified data
		private Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
}
