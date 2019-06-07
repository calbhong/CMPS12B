import java.io.*;
import java.util.Scanner;


// spaghetti coding my way to victory;
// Honestly, was having a rough time getting the main method working
// since a lot of it was chopping up bits and pieces of the examples
// and massging it out to where it needs to be
class Search{
	public static void main(String[] args) throws IOException{
		Scanner in = null;
		String t = "";
		int count = 1;
		int lineNum = 0;

		if(args.length < 2){
			System.out.println("Search file target1 [target2 target3 ..]");
			System.exit(1);
		}	
		//had one too many issues here since i put count++ instead, which caused an out of bounds exception
		in = new Scanner(new File(args[0]));
		while(in.hasNextLine()){
			in.nextLine();
			lineNum++;
		}

		int[] lineNumber = new int[lineNum];
		String[] A = new String[lineNum];
		
		for(int i = 0; i < lineNum; i++){
			lineNumber[i] = count;
			count++;
		}

		in = new Scanner(new File(args[0]));
		for(int i = 0; i < lineNum; i++){
			A[i] = in.nextLine();
		}
		//String[] A was originally word to stay continuous with the 
		//methods but it turned out it got really complicated naming convetion-wise
		mergeSort(A, lineNumber, 0, A.length -1);
		for(int i = 1; i < args.length; i++){
			t = args[i];
			int b = binarySearch(A, 0, A.length, t);
			if(b == -1){
				System.out.println(t + " not found");
			}
			else{
				System.out.println(t + " found on line " + lineNumber[b]);
			}
		}
	}
	static int binarySearch(String[] A, int p, int r, String t){
		int q;
		if(p > r){
			return -1;
		}
		//worked with different versions using trim but settled with comparedTo instead
		else{
			q = (p+r)/2;
			if(A[q].compareTo(t) == 0){
				return q;
			}
			else if(A[q].compareTo(t) < 0){
				return binarySearch(A, p, q-1, t);
			}
			else{
				return binarySearch(A, q+1, r, t);
			}
		}
	}
	static void mergeSort(String[] A, int[] lineNumber, int p, int r){
		int q;
		if(p < r){
			q = (p+r)/2;
			mergeSort(A, lineNumber, p, q);
			mergeSort(A, lineNumber, q+1, r);
			merge(A, lineNumber, p, q, r);
		}
	}
	static void merge(String[] A, int[] lineNumber, int p, int q, int r) {
		int n1 = q-p+1;
		int n2 = r-q;
		String[] left = new String[n1];
		String[] right = new String[n2];
		int[] leftNum = new int[n1];
		int[] rightNum = new int[n2];
		int i, j, k;
		//added the int[] array for the line count
		for(i=0; i<n1; i++){
			left[i] = A[p+i];
			leftNum[i] = lineNumber[p+i];
		}
		for(j=0; j<n2; j++){
			right[j] = A[q+j+1];
			rightNum[j] = lineNumber[q+j+1];
		}

		i = 0;
		j = 0;
	
		for(k=p; k<=r; k++){
			if( i<n1 && j<n2){
				if( left[i].compareTo(right[j])>0 ){
					A[k] = left[i];
					lineNumber[k] = leftNum[i]; 
					i++;
				}
				else{
					A[k] = right[j];
					lineNumber[k] = rightNum[j];
					j++;
				} 
			}
			else if( i<n1){
				A[k] = left[i];
				lineNumber[k] = leftNum[i];
				i++;
			}
			else{  // j<n2
				A[k] = right[j];
				lineNumber[k] = rightNum[j];
				j++;
			} 
		}
	}
}