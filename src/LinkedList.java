/*
	 * The goal of this class is to practice linked list by creating my own data structure
	 * The classes I need to implement:
	 * 
	 * addFirst, addLast, removeFirst, removeLast, remove and find, peek, addFirst, addAfter
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
		//The ordering when adding the first element is very important
		//We first have to set the next of the node that we want to add first as head
		//and then we can simply set head = node;
		node.setNext(head);
		head = node;
		currentSize++;
	}
	
	public void addLast(E obj) {
		//We have to first check if head is null
		if(head == null) {
			this.addFirst(obj);
			return;
		}
		//Temp acts as a pointer for the linked list
		//This allows for use to traverse the linked list without moving the head to the end.
		//causing us to only be able to access the last node of the linked list
		Node<E> node = new Node<E>(obj);
		Node<E> temp = head; 
		//This stops at the last node since the node.next would be null
		while(temp.getNext() != null) { 
			temp = temp.getNext();
		}
		temp.setNext(node);
		this.currentSize++;
	}
	
	//This function adds an element after an element matching to the key is found
	//Ex. 1 -> 2 -> 3 -> 4 Key = 2 Obj = 6; New List: 1 -> 2 -> 6 -> 3 -> 4
	@SuppressWarnings("unchecked")
	public void addAfter(E key, E obj) {
		if(obj == null || key == null) {
			return;
		}
		else if(this.currentSize == 0) {
			this.addFirst(obj);
		}
		Node<E> current = head;
		Node<E> add = new Node<E>(obj);
		
		while(current != null) {
			if((((Comparable<E>) key).compareTo(current.getData()) == 0)) {
				if(current == head) {
					this.addLast(obj);
				}
				//We need to first set the next of add to the next of current
				//Then we set the next of current to be add;
				add.setNext(current.getNext());
				current.setNext(add);
				this.currentSize++;
				return;
			}
			current = current.getNext();
		}
	}
	
	public void addBefore(E key, E obj) {
		if(obj == null || key == null) {
			return;
		}
		else if(this.currentSize == 0) {
			this.addFirst(obj);
		}
		Node<E> current = head;
		Node<E> previous = null;
		Node<E> add = new Node<E>(obj);
		
		while(current != null) {
			if((((Comparable<E>) key).compareTo(current.getData()) == 0)) {
				if(current == head) {
					this.addFirst(obj);
				}
				//We need to first set the next of add to current
				//Then we set the next of previous to be add;
				add.setNext(current);
				previous.setNext(add);
				this.currentSize++;
				return;
			}
			previous = current;
			current = current.getNext();
		}
	}
	
	public E removeFirst() {
		E removeVal = null;
		if(this.currentSize == 0) {
			return null;
		}
		else if(this.getCurrentSize() == 1) {
			removeVal = head.getData();
			this.head = null;
			this.currentSize--;
			return removeVal;
		}
		else {
			//We simply need to save the element to a temporary variable and then set head to be equal to head.next
			removeVal = this.head.getData();
			this.head = this.head.getNext();
			this.currentSize--;
			return removeVal;
		}
		
		
	}
	
	public E removeLast() {
		E removeVal = null;
		if(this.currentSize == 0) {
			return null;
		}
		else if(this.getCurrentSize() == 1) {
			return removeFirst();
		}
		else {
			//
			Node<E> temp = head;
			
			//Has to be temp.next.next because we want to stop at the second to last element,
			//so that we can just set that elements .next to be null effectively removing the last element
			while(temp.getNext().getNext() != null) {
				temp = temp.getNext();
			}
			
			removeVal = temp.getNext().getData();
			temp.setNext(null);
			this.currentSize--;
			return removeVal;
		}
	}
	
	public E removeAndFind(E obj) {
		if(obj == null) {
			return null;
		}
		else if(this.currentSize == 0) {
			return null;
		}
		Node<E> current = head;
		Node<E> previous = null;
		E removeVal = null;
		
		while(current != null) {
			if((((Comparable<E>) obj).compareTo(current.getData()) == 0)) {
				if(current == head) {
					return this.removeFirst();
				}
				//We need to set the next of previous to the next of current and finally return the value of current
				removeVal = current.getData();
				previous.setNext(current.getNext());
				this.currentSize--;
				return removeVal;
			}
			previous = current;
			current = current.getNext();
		}
		return removeVal;
	}
	
	public E peek() {
		return this.getHead().getData();
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
	
	public static void main(String[] args) {
		String i = "Hello ";
		LinkedList<String> test = new LinkedList<String>();
		
		test.addFirst(i);
		//System.out.println("First element: " + test.getHead().getData());
		test.addFirst("Why baby");
		test.addFirst("Justin is a pig");
		test.addFirst("Stella beer is weak");
		test.addFirst("Turnstile is lit");
		test.addLast("I Don't Wanna Be Blind");
		test.addLast("100 gecs");
		test.addFirst("The Dead Kennedys");
		System.out.println("First element after i: " + test.getHead().getData());
		System.out.println("List size " + test.getCurrentSize());
		System.out.println("Element removed: " + test.removeAndFind("Hello "));
		System.out.println("List size " + test.getCurrentSize());
		test.addBefore("Why baby", "Fugazi");
		test.addAfter("Why baby", "Black Sabbath");
		Node<String> temp = test.getHead();
		//Setting it as temp != null will go through the entire linked list and temp will become null
		while(temp != null) { 
			System.out.println("Current element: " + temp.getData());
			temp = temp.getNext();
		}
		System.out.println("Current head element: " + test.peek());
		
		
	}

	
}
