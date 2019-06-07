//Queens.java
//Calvin Hong
//cbhong
//pa2
class Queens{
	public static void main(String[] args){
		//input & -v check
		int n = 0;
		String mode = "";
		if(args.length>2 || args.length<0){
			err();
		}
		if(args.length == 2){
			if(args[0].equals("-v")){
				mode = "verbose";
			}else err();
			try{
				n = Integer.parseInt(args[1]);
			}catch(NumberFormatException e){
				err();
			}
		}
		if(args.length == 1){
			try{
				n = Integer.parseInt(args[0]);
			}catch(NumberFormatException e){
				err(); 	
			}
		}
		if(args.length == 0){
			err();
		}
		//initialize B[n+1][n+1] for 0;
		int[][] B = new int[n+1][n+1];
		System.out.println(n + "-Queens has " + findSolutions(B, 1 , mode) +" solutions");
	}
	static void placeQueen(int[][] B, int i ,int j){
		B[i][j]++;
		B[i][0] = j;
		for(int k = 1; k < B.length - 1; k++){
			if((i+k)< B.length){
				B[i+k][j]--;				
			}
			if ((i+k)<B.length && (j+k)<B.length) {
				B[i+k][j+k]--;					
			}
			if ((i+k)<B.length && (j-k)>0) {
				B[i+k][j-k]--;					
			}
		}			
	}
	static void removeQueen(int[][] B, int i , int j){
		B[i][j]--;
		B[i][0] = 0;
		for(int k = 1; k < B.length - 1; k++){
			if((i+k)< B.length){
				B[i+k][j]++;				
			}	
			if ((i+k)<B.length && (j+k)<B.length) {
				B[i+k][j+k]++;					
			}
			if ((i+k)<B.length && (j-k)>0) {
				B[i+k][j-k]++;					
			}
		}	
	}
	static void printBoard(int[][] B){
		System.out.print("(");
		for(int i = 1; i < B.length; i++){
			if(i != B.length - 1){
				System.out.print(B[i][0] + ", ");
			}
			else{
				System.out.print(B[i][0]);
			}
		}
		System.out.print(")");
		System.out.println();
	}
	static int findSolutions(int[][] B, int i, String mode){
		//counter: B[0][0]
		if(i > B.length - 1){
			B[0][0]++;
			if(mode.equals("verbose")){
				printBoard(B);

			}
			return 1;7
		}
		else{
			for(int j = 1; j < B[i].length; j++){
				if(B[i][j] == 0){
					placeQueen(B, i, j);
					findSolutions(B, i+1, mode);
					removeQueen(B, i, j);
				}
			}
		}
		return B[0][0];
	}
	static void err(){
		System.err.println("Usage: Queens [-v] number");
		System.err.println("Option:  -v   verbose output, print all solutions");
		System.exit(1);
	}
}