import java.io.*;
import java.util.Scanner;

class FileReverse{
	public static void main(String[] args) throws IOException{
		Scanner in = null;
		PrintWriter out = null;
		String line = null;
		String[] token = null;
		int i, n, lineNumber = 0;
		// check number of command line arguments is at least 2
		if(args.length < 2){
			System.out.println("Usage: FileCopy <input file> <output file>");
			System.exit(1);
		}
		// open files
		in = new Scanner(new File(args[0]));
		out = new PrintWriter(new 	FileWriter(args[1]));
		// read lines from in, write lines to out
		while( in.hasNextLine() ){
			lineNumber++;
			line = in.nextLine().trim() + " ";
			token = line.split("\\s+");
			n = token.length;
			//out.println( line ); This accidentally reposts the initial input
			for(i = 0; i < n; i++){
				out.println(stringReverse(token[i], token[i].length()));
			}
		}
		// close files
		in.close();
		out.close();
	}
	//I'm a goof and it took me forever to figure out the recursive method
	public static String stringReverse(String s, int n){
		if(s.length() == 1){
			return s;
		}
		else{ 
			return stringReverse(s.substring(1),n-1) + s.charAt(0);
		}
	}
}
