import java.util.NoSuchElementException;

public class LinkedList<T> {

	protected Node head;
	protected Node tail;
	protected int size;

	// creating a node sets next to null

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
		}

		Node current = head;
		StringBuilder output = new StringBuilder();

		while (current != null) {

			output.append(current.data + " ");
			current = current.next;

		}

		return output.toString();
	}

	/*
	 * Returns the first item in the list. If the list is empty, throw a
	 * NoSuchElementException.
	 */
	public int getFirst() {

		try {

			if (isEmpty()) {
				throw new NoSuchElementException();
			}

		} catch (NoSuchElementException ex) {
			ex.getMessage();
		}

		return head.data;
	}

	/*
	 * Returns the last item in the list. If the list is empty, throw a
	 * NoSuchElementException.
	 */
	public int getLast() {

		try {

			if (isEmpty()) {
				throw new NoSuchElementException();
			}

		} catch (NoSuchElementException ex) {
			ex.getMessage();
		}

		Node current = head;

		while (current.next != null) {
			current = current.next;

		}

		return tail.data;

	}

	/*
	 * Returns the item at the specified index. If the index is not valid, throw an
	 * IndexOutOfBoundsException.
	 */
	public int getAt(int index) {

		if (index < 0 || index > size) {

			throw new IndexOutOfBoundsException();

		}

		Node current = head;

		for (int x = 0; x != index; x++) {

			current = current.next;

		}

		return current.data;
	}

	/*
	 * Inserts an item at the beginning of the list.
	 */
	public void insertFirst(int num) {

		if (isEmpty()) {
			Node newNode = new Node(num);

			head = newNode;
			tail = newNode;

			head.next = tail;

		} else {

			Node newNode = new Node(num);

			newNode.next = head;

			head = newNode;

		}

		tail.next = null;

		size++;
	}

	/*
	 * Inserts an item at the end of the list.
	 */


	/*
	 * Removes and returns the first element from the list. If the list is empty,
	 * throw a NoSuchElementException.
	 */
	public int removeFirst() {

		try {

			if (isEmpty()) {
				throw new NoSuchElementException();
			}

		} catch (NoSuchElementException ex) {
			ex.getMessage();
		}

		int oldData = head.data;

		if (size == 1) {

			head = null;
			tail = null;

		} else {

			head.data = (head.next).data;
			head.next = (head.next).next;
		}

		size--;

		return oldData;
	}

	/*
	 * Removes and returns the last element from the list. If the list is empty,
	 * throw a NoSuchElementException.
	 */


	/*
	 * Returns the number of elements in the list.
	 */
	public int getSize() {
		
		return size;
	}

	/*
	 * Returns true if the list is empty, and false otherwise.
	 */
	public boolean isEmpty() {

		if (size == 0) {

			return true;

		}

		return false;
	}

	// A private Node class. By making it an inner class,
	// the outer class can access it easily, but the client cannot.
	private class Node<T> {
		private int data;
		private Node next;

		// Constructs a new node with the specified data
		private Node(data) {
			this.data = data;
			this.next = null;
		}
	}
	
}
