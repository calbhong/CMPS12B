// Question 1
class Node{
	int item;
	Node next;
	Node(int x){
		item = x;
		next = null;
	}
}
// In some class in the same package as Node:

	static int product(Node H){
	 // Your code goes here
		 if(H == null){
			return 1;
		}
		else{
			return H.item * product(H);
		}
	 }
