/**
 * Class: LinkedList
 * 
 * @author natepaprocki
 * @version 1.0
 * Course: CSE 274 - Spring 2024
 * Written: March 3, 2024
 * 
 * Purpose: This generic class creates, modifies, and sorts a singly
 *          linked list.
 */

public class LinkedList<T extends Comparable<T>>  {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	/*
	 * This constructor method creates an empty list.
	 */
	public LinkedList() {

	}

	/*
	 * This method returns a space-separated list of the elements in the list. If
	 * the list contains no elements, return an empty string ""
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

	/**
	 * This method inserts a new object into front of Linked List.
	 * 
	 * @param num Object to be added
	 */

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

	/**
	 * This method appends a new object to Linked List.
	 * 
	 * @param num Object to be added
	 */

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

	/**
	 * This method returns the size of linked list.
	 * 
	 * @return size Size of the list
	 */

	public int getSize() {
		return size;
	}

	/**
	 * This method checks if the list is empty
	 * 
	 * @return true if list is empty and false otherwise
	 */

	public boolean isEmpty() {

		if (size == 0) {

			return true;

		}

		return false;
	}

	/**
	 * This method calls the mergeSort methods
	 */

	public void sort() {
		head = mergeSort(head);
	}

	/**
	 * This method recursively sorts the linked list using merge sort
	 * 
	 * Note: This method is modified from code found at
	 *       www.geeksforgeeks.org/merge-sort-for-linked-list/
	 * 
	 * @param passedNode The head node to be sorted
	 * @return The head node of the sorted list
	 */

	private Node<T> mergeSort(Node<T> passedNode) {

		if (passedNode == null || passedNode.next == null) {
			return passedNode;
		}

		// Find middle node
		Node<T> middle = getMiddle(passedNode);
		Node<T> nextOfMiddle = middle.next;
		middle.next = null;

		// Apply mergeSort on left list (i.e. passedNode to middle)
		Node<T> left = mergeSort(passedNode);

		// Apply mergeSort on right list (i.e. middle.next to tail)
		Node<T> right = mergeSort(nextOfMiddle);

		// Merge the left and right lists
		return sortedMerge(left, right);
	}

	/**
	 * Merges two sorted linked list into a single list
	 * 
	 * Note: This method is modified from code found at
	 * 		 www.geeksforgeeks.org/merge-sort-for-linked-list/
	 * 
	 * @param a The head of the first sorted linked list
	 * @param b The head of the second sorted linked list
	 * @return a or b The head of the merged sorted linked list
	 */

	private Node<T> sortedMerge(Node<T> a, Node<T> b) {

		Node<T> result = null;

		if (a == null) {
			return b;
		}

		if (b == null) {
			return a;
		}

		// Choose either a or b and recur
		if ((a.data).compareTo(b.data) <= 0) {

			result = a;
			result.next = sortedMerge(a.next, b);

		} else {

			result = b;

			result.next = sortedMerge(a, b.next);
		}

		return result;
	}

	/**
	 * This method gets the middle node of the linked list
	 * 
	 * Note: This method is modified from code found at
	 * 		 www.geeksforgeeks.org/merge-sort-for-linked-list/
	 * 
	 * @param node The head node of the list
	 * @return slow The middle node
	 */
	
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
