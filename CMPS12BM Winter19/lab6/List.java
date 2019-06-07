

@SuppressWarnings("overrides")
public class List<T> implements ListInterface<T>{
	private class Node<T>{
		T item;
		Node<T> next;

		Node(T x){
			item = x;
			next = null;
		}
	}
	private Node<T> head;
	private int numItems;

	public List(){
		head = null;
		numItems = 0;
	}

	public boolean isEmpty(){
		return(numItems == 0);
	}

	public int size(){
		return numItems;
	}

	public T get(int index) throws ListIndexOutOfBoundsException{
		if( index<1 || index>numItems ){
			throw new ListIndexOutOfBoundsException("get() called on invalid index: " + index);
		}
		Node<T> N = head;
		for(int i = 1; i<index; i++){
			N = N.next;
		}
		return N.item;
	}

	private Node<T> find(int index){
		Node<T> N = head;
		for(int i = 1; i<index; i++){
			N = N.next;
		}
		return N;
	}

	public void add(int index, T newItem) throws ListIndexOutOfBoundsException{
		if( index<1 || index>(numItems+1) ){
			throw new ListIndexOutOfBoundsException("add() called on invalid index: " + index);
		}
		if(index==1){
				Node<T> N = new Node(newItem);
				N.next = head;
				head = N;
		}
		else{
				Node<T> P = find(index-1);
				Node<T> Q = P.next;
				P.next = new Node(newItem);
				P = P.next;
				P.next = Q;
		}
		numItems++;
	}

	public void remove(int index) throws ListIndexOutOfBoundsException{
		 if( index<1 || index>numItems ){
		 	throw new ListIndexOutOfBoundsException("remove() called on invalid index: " + index);
		}
		if(index==1){
				Node<T> N = head;
				head = head.next;
				N.next = null;
		}
		else{
				Node<T> M = find(index-1);
				Node<T> N = M.next;
				M.next = N.next;
				N.next = null;
		}
		numItems--;
	}

	public void removeAll(){
		head = null;
		numItems = 0;
	}

	public String toString(){
		StringBuffer sb = new StringBuffer();
		Node N = head;

		for( ; N!=null; N=N.next){
			sb.append(N.item).append(" ");
		}
		return new String(sb);
	}
	@SuppressWarnings("unchecked")
	public boolean equals(Object rhs){
		boolean eq = false;
		List R = null;
		Node N = null;
		Node M = null;

		if(this.getClass()==rhs.getClass()){
			R = (List)rhs;
			eq = ( this.numItems == R.numItems );

			N = this.head;
			M = R.head;
			while(eq && N!=null){
				eq = (N.item == M.item);
				N = N.next;
				M = M.next;
			}
		}
		return eq;
	}
}