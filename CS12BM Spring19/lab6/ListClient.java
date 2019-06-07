//-----------------------------------------------------------------------------
// ListClient.java
// A test client for the List ADT
//-----------------------------------------------------------------------------

public class ListClient{

	public static void main(String[] args){
		List<String> A = new List<String>();
		List<String> B = new List<String>();
		List<List<String>> C = new List<List<String>>();
		int i, j, k;	

		A.add(1, "one");
		A.add(2, "two");
		A.add(3, "three");
		B.add(1, "ten");
		B.add(2, "twenty");
		B.add(3, "thirty");
		C.add(1, A);
		C.add(2, B);

		System.out.println("A: "+A);
		System.out.println("B: "+B);
		System.out.println("C: "+C);
		System.out.println("A.equals(A) is "+A.equals(A));
		System.out.println("A.equals(B) is "+A.equals(B));
		System.out.println("A.equals(C) is "+A.equals(C));
		System.out.println("A.size() is "+A.size());
		System.out.println("B.size() is "+B.size());
		System.out.println("C.size() is "+C.size());

		A.remove(1);
		B.remove(2);

		System.out.println("A.size() is "+A.size());
		System.out.println("B.size() is "+B.size());
		System.out.println("B.get(1) is "+B.get(1));
		System.out.println("C: "+C);
		System.out.println();
		try{
			System.out.println(A.get(200));
		}catch(ListIndexOutOfBoundsException e){
			System.out.println("Caught Exception: ");
			System.out.println(e);
			System.out.println("Continuing without interruption");
		}
		System.out.println();
		System.out.println("A.get(2) is "+A.get(2));
		System.out.println("C.get(1) is "+C.get(1));
	}
}