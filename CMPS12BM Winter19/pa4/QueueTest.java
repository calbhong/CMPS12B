public class QueueTest {
	public static void main (String[] args) {
		Queue A = new Queue();
		Queue Q = new Queue();

		System.out.println(A.isEmpty());
		A.enqueue((int)2);
		A.enqueue((int)4);
		A.enqueue((int)6);
		A.enqueue((int)8);

		System.out.println(A.isEmpty());
		System.out.println(A.length());
		System.out.println(A);
		A.dequeue();
		A.dequeue();

		System.out.println(A.isEmpty());
		System.out.println(A.length());
		System.out.println(A.peek());

		A.dequeueAll();
		System.out.println(A.isEmpty());
		System.out.println(A.length());

		Job j1 = new Job(3, 4);													
		Job j2 = new Job(1, 1);													
		Job j3 = new Job(2, 12);
		Q.enqueue(j1);														   
		Q.enqueue(j2);	   
		Q.enqueue(j3);
		System.out.println(Q.isEmpty());									 
		System.out.println(Q.length());									   
		System.out.println(Q.toString());		    
		System.out.println(Q.peek().toString());						  
		Q.dequeue();														     
		System.out.println(Q.toString());								     
		Q.dequeueAll();
		System.out.println(Q.isEmpty());     
		System.out.println(Q.length());
		
	}
}