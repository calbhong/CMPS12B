//-----------------------------------------------------------------------------
// ListInterface.java
// interface for the List ADT
//-----------------------------------------------------------------------------

public interface ListInterface<T>{

	// isEmpty
	// pre: none
	// post: returns true if this List is empty, false otherwise
	public boolean isEmpty();

	// size
	// pre: none
	// post: returns the number of elements in this List
	public int size();

	// get
	// pre: 1 <= index <= size()
	// post: returns item at position index
	public T get(int index) throws ListIndexOutOfBoundsException;

	// add
	// inserts newItem in this List at position index
	// pre: 1 <= index <= size()+1
	// post: !isEmpty(), items to the right of newItem are renumbered
	public void add(int index, T newItem) throws ListIndexOutOfBoundsException;

	// remove
	// deletes item from position index
	// pre: 1 <= index <= size()
	// post: items to the right of deleted item are renumbered
	public void remove(int index) throws ListIndexOutOfBoundsException;

	// removeAll
	// pre: none
	// post: isEmpty()
	public void removeAll();

}