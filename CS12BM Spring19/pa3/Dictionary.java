public class Dictionary implements DictionaryInterface{
	class Node{
		String key;
		String val;
		Node next;

		Node(String k, String v){
			key = k;
			val = v;
			next = null;
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

	public boolean isEmpty(){
		return (num == 0);
	}

	public int size(){
		return num;
	}

	public String lookup(String key){
		String result = null;
		Node n = head;
		boolean found = false;
		while(!found && n != null){
			if(n.key.equals(key)){
				result = n.val;
				found = true;
			}
			n = n.next;
		}
		return result;
	}

	public void insert(String key, String value){
		if(lookup(key) != null){
			throw new DuplicateKeyException("cannot insert duplicate keys");	
		}
		Node n = new Node(key, value);

		if(isEmpty()){
			head = n;
			tail = n;
		}else{
			tail.next = n;
			tail = tail.next;
		}
		num++;
	}

	public void delete(String key){
		if(lookup(key) == null){
			throw new KeyNotFoundException("cannot delete non-existent key");
		}
		Node cursor = head;
		Node prev = head;
		boolean found = false;
		if(num == 1){
			head = null;
			tail = null;
		}else{
			while(!found){
				if(cursor.key.equals(key)){
					found = true;
					if(cursor == head){
						head = head.next;
					}else if(cursor == tail){
						tail = prev;
						prev.next = null;
					}else{
						prev.next = cursor.next;
						cursor.next = null;
					}
				}else{
					if(cursor == head){
						cursor = cursor.next;
					}else{
						cursor = cursor.next;
						prev = prev.next;
					}
				}
			}
		}
		num--;
	}

	public void makeEmpty(){
		head = null;
		tail = null;
		num = 0;
	}

	public String toString(){
		Node n = head;
		String out = "";
		while( n != null){
			out += n.key + " " + n.val + "\n";
			n = n.next;
		}
		return out;
	}


}