
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

	
	public void mergeSort() {
		
		
		
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
