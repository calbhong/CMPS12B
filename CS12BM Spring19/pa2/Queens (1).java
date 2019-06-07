class Queens {

    static void placeQueen(int[][] B, int i, int j){
        int count = 0;
        for(int r = 1; r <= B.length; r++){
            if(r < B.length){
                if (B[i][r] == 0) {
                    B[i][0] = r;
                    B[i][r] = 1;
                    if (i == B.length - 1) {
                        printBoard(B);
                        return;
                    }
                    for(int k = i + 1; k < B.length; k++) {
                            B[k][r] = B[k][r] - 1;
                    }
                    for(int x = 1; x < B.length; x++){
                        if((i + x) < B.length && (r + x) < B.length) {
                            B[i + x][r + x] = B[i + x][r + x] - 1;
                        }
                    }
                    for(int x = 1; x < B.length; x++){
                        if((i - x) < B.length && (r - x) < B.length) {
                            B[i - x][r - x] = B[i - x][r - x] - 1;
                        }
                    }
                    placeQueen(B, i++, 1);
                    removeQueen(B, i--, 0);
                }
                count++;
            }

        }
        if(count < 1){
            removeQueen(B, i--, 0);
        }
    }

    static void removeQueen(int[][] B, int i, int j){
        int x = B[i][j];

    }
    static void printBoard(int[][] B){
        System.out.print("(");
        for(int j = 1; j < B.length;j++){
            if( j != 4) {
                System.out.print(B[0][j] + ", ");
            }
            else{
                System.out.print(B[0][j] + ")");
            }
        }
    }

    static int findSolutions(int[][] B, int i, String mode){
        int n = 0;
        if(mode.compareTo("-v") == 0){
            while(i < B.length){
                placeQueen(B, i,1);
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
            if(args.length < 1) {
                System.out.println("Usage: Queens [-v] number");
                System.exit(1);
            }
            int n;
            if(args[0].compareTo("-v") == 0){
                int[][] B = new int[Integer.parseInt(args[1]) + 1][Integer.parseInt(args[1]) + 1];
                findSolutions(B, 1, args[0]);
            } else {
                int[][] B = new int[Integer.parseInt(args[0]) + 1][Integer.parseInt(args[0]) + 1];
                findSolutions(B, 1, "");
            }
    }

}