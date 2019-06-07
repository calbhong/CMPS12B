class Subset{
	public static void main(String[] args){
		int n = 0;
		int k = 0; 
		int i = 1;
		String s;

		if(args.length>2 || args.length<0){
			err();
		}
		if(args.length == 2){
			try{
				n = Integer.parseInt(args[0]);
				k = Integer.parseInt(args[1]);
			}catch(NumberFormatException e){
				err();
			}
		}
		if(args.length == 1){
			err(); 	
		}
		if(args.length == 0){
			err();
		}
		if(n < k){
			err();
		}
		int[] B = new int[n+1]; 
		printSubsets(B, k, i);
	}
	static String setToString(int[] B){
		String s = "{";
		for (int i = 0; i < B.length; i++) {
			if(B[i] == 1){
				s = s + i + ", ";
			}
		}
		if(s.length() > 1){
			s = s.substring(0,s.length()-2);
		}
		s = s + "}";		
		return s;
	}
	static void printSubsets(int[] B, int k, int i){
		if(k == 0){
			System.out.println(setToString(B));
		}
		else if (k != 0 && i < B.length){
			B[i] = 1;
			printSubsets(B, k-1, i+1);
			B[i] = 0;
			printSubsets(B, k, i+1);
		}
	}
	static void err(){
		System.err.println("Usage: Java Subset <int> <int>");
		System.exit(1);
	}

}