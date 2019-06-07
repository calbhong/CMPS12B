public class Dictionary implements DictionaryInterface{
	class Node{
		Pair p;
		Node next;
		
		Node(String k, String v){
			p = new Pair(k, v);
			next = null;
		}
	}
	class Pair{
		String key;
		String value;
		Pair(String k, String v){
			key = k;
			value = v;
		}
	}
	private Node head;
	private Node tail;
	private int num;

	public Dictionary(){
		head = null;
		tail = null;
		num = 0;
	}

	private Node findKey(String key){
		Node n = head; 
		while( n != null){
			if(n.p.key != key){
				n = n.next;
			}
			else{
				return n;
			}
		}
		return null;
	}

	public boolean isEmpty(){
		return (num == 0);
	}
	
	public int size(){
		return num;
	}
	

	public String lookup(String key){
		String value = null;
		Node n = head;
		boolean found = false;
		while( !found && n != null ){
			if(n.p.key.equals(key)){
				value = n.p.value;
				found = true;
			}
			n = n.next;
		}		
		return value;
	}
	
	public void insert(String key, String value) throws DuplicateKeyException{
		
		if(lookup(key) != null){
			throw new DuplicateKeyException(" cannot insert duplicate keys ");
		}
		
		Node new_node = new Node(key, value);
		
		if(isEmpty()){
			head = new_node;
			tail = new_node;
		}
		else{
			tail.next = new_node;
			tail = tail.next;
		}
		num++;
	}
	
	public void delete(String key) throws KeyNotFoundException{
		if( lookup(key) == null){
			throw new KeyNotFoundException(" cannot delete non-existent key ");
		}
		
		Node current  = head;
		Node previous = head;
		boolean found = false;
		if(num == 1){
			head = tail = null;
		}
		else{
			while(!found){
				if(current.p.key.equals(key)){
					found = true;
					if(current == head){
						head = head.next;
					}
					else if(current == tail){
						tail = previous;
						previous.next = null;
					}
					else{
						previous.next = current.next;
						current.next = null;
					}
				}
				else{
					if(current == head){
						current = current.next;
					}
					else{
						current  = current.next;
						previous = previous.next;
					}
				}
			}
		}
		num--;
	}

	public void makeEmpty(){
		head = tail = null;
		num = 0;
	}
	
	public String toString(){
		Node n = head;
		String S = "";
		for(; n != null; n = n.next ){
			S += n.p.key+" "+n.p.value+"\n";
		}
		return S;
	}
	
	
}