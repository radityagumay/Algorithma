package radittya.labs.classess;

public class SecondStack<T> {
	// T is the type parameter
	Node top; // topmost element of stack

	// defines each node of stack
	class Node {
		T value; // value of each node
		Node next; // pointer to next node

		public Node(T value) {
			this.value = value; // initializing
			next = null;
		}
	}

	// This function pushes new element
	public void push(T value) {
		Node current = new Node(value);
		if (isEmpty())
			top = current; // if empty stack
		else {
			current.next = top;
			top = current;
		}
	}

	// This function pops topmost element
	public T pop() {
		T value = null;
		if (!isEmpty()) {
			top = top.next;
			value = top.value;
		}
		return value; // returning popped value
	}

	// This function returns the entire stack
	public String toString() {
		Node current = top;
		StringBuilder s = new StringBuilder();
		while (current != null) {
			s.append(current.value + "  ");
			current = current.next;
		}

		return s.toString();
	}

	// This function returns topmost element
	public T peek() {
		return top.value;
	}

	// This function checks emptiness of stack
	public boolean isEmpty() {
		return (top == null) ? true : false;
	}
}