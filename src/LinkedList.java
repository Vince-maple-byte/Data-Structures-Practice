/*
	 * The goal of this class is to practice linked list by creating my own data structure
	 * The classes I need to implement:
	 * 
	 * addFirst, addLast, removeFirst, removeLast, remove and find, peek, 
	 * 
	 * 
	 * */

public class LinkedList<E>{
	private Node<E> head;
	private int currentSize;
	
	public LinkedList() {
		this.head = null;
		this.currentSize = 0;
	}
	
	public void addFirst(E obj) {
		Node<E> node = new Node<E>(obj);
		if(head == null) {
			this.head = node;
			this.currentSize++;
			return;
		}
		
	}
	
	public void addLast(E obj) {
		
	}
	
	public E removeFirst() {
		E obj = null;
		return obj; 
	}
	
	public E removeLast() {
		E obj = null;
		return obj;
	}
	
	public E removeAndFind(E obj) {
		return obj;
	}

	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}

	public int getCurrentSize() {
		return currentSize;
	}
	
	
	
}
