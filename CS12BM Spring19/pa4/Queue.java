public class Queue implements QueueInterface{
	private class Node{
		Object item;
		Node next;

		Node(Object newItem){
			item = newItem;
			next = null;
		}
	}
	private Node head;
	private int numItems;

	public Queue(){
		head = null;
		numItems = 0;
	}

	public boolean isEmpty(){
		return(numItems == 0);
	}

	public int length(){
		return numItems;
	}

	public void enqueue(Object newItem){
		if(isEmpty()){
			head = new Node(newItem);
		}else{
			Node N = head;
			while(N.next != null){
				N = N.next;
			}
			N.next = new Node(newItem);
		}
		numItems++;
	}

	public Object dequeue() throws QueueEmptyException{
		if(isEmpty()){
			throw new QueueEmptyException("Queue: Cannot dequeue() on an empty Queue");
		}else{
			Node N = head;
			head = N.next;
			numItems--;
			return N.item;
		}
	}

	public Object peek() throws QueueEmptyException{
		if(isEmpty()){
			throw new QueueEmptyException("Queue: Cannot peek() on an empty Queue");
		}else{
			return head.item;
		}
	}

	public void dequeueAll() throws QueueEmptyException{
		if(isEmpty()){
			throw new QueueEmptyException("Queue: Cannot dequeueAll() on an empty Queue");
		}else{
			head = null;
			numItems = 0;
		}
	}

	public String toString(){
		String s = "";
		Node N = head;

		while(N != null){
			s += N.item + " ";
			N = N.next;
		}
		return s;
	}
}