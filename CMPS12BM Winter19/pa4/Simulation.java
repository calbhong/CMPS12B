import java.io.*;
import java.util.Scanner;

public class Simulation{
	public static void main(String[] args) throws IOException{
		Scanner in = null;
		PrintWriter report = null;
		PrintWriter trace = null;
		Queue[] processorQ = null;


		if (args.length != 1) {
			System.err.println("Usage: Simulation infile");
			System.exit(1);
		}

		try{
			in = new Scanner(new File(args[0]));
		}
		catch(IOException e){
			throw new IOException("Failed to open specified input file");
		}
		try{
			report = new PrintWriter(new FileWriter(args[0]+".rpt"));
			trace  = new PrintWriter(new FileWriter(args[0]+".trc"));
		}
		catch(IOException e){
			throw new IOException("Failed to create report and/or trace file(s)");
		}

		int m = numOfJobs(in);
		int time = 0;
		Job j = null;
		Queue storage = new Queue();
		Queue backup = new Queue();
		Queue finish = new Queue();	 
		
		while(in.hasNextLine()){
			j = getJob(in);
			backup.enqueue(j);
		}

		trace.println("Trace file: " + (args[0] + ".trc"));
		trace.println(m + " Jobs:");
		trace.println(backup.toString());
		trace.println();

		report.println("Report file: " + (args[0] + ".rpt"));
		report.println(m + " Jobs:");
		report.println(backup.toString());
		report.println();
		report.println("*****************************");

		for(int n = 1; n < m; n++){
			int totalWait = 0;
			int maxWait = 0;
			double avgWait = 0.0;

			for(int i = 1; i < backup.length()+1; i++){
				j = (Job)backup.dequeue();
				j.resetFinishTime();
				storage.enqueue(j);
				backup.enqueue(j);
			}

			int processors = n;
			processorQ = new Queue[n+2];
			processorQ[0] = storage;
			processorQ[n+1] = finish;
			for(int i = 1; i < n+1; i++){
				processorQ[i] = new Queue();
			}
			trace.println("*****************************");
			if(processors == 1){
				trace.println(processors + " processor:");
			}
			else{
				trace.println(processors + " processors:");
			}
			trace.println("*****************************");
			trace.println("time=" + time);
			trace.println("0: " + backup.toString());
			for(int i = 1; i < processors+1; i++) {
				trace.println(i + ": " + processorQ[i]);
			}
			while(finish.length() != m){
				int compare, length, lengthF, index;
				int compareF = Integer.MAX_VALUE;
				Job comp = null;
				compare = -1;
				length = -1;
				lengthF = -1;
				index = 1;


				for(int i = 1; i < processors+1; i++){
					if(processorQ[i].length() != 0){
						comp = (Job)processorQ[i].peek();
						compare = comp.getFinish();
					}else if(compare < compareF){
						compareF = compare;
						index = i;
					}
					time = compareF;
				}
				
				if(!storage.isEmpty()){
					comp = (Job)storage.peek();
					compareF = comp.getArrival();
					index = 0;
				}


				if(index == 0){
					int tempIndex = 1;
					lengthF = processorQ[tempIndex].length();
					for(int i = 1; i < processors+1; i++){
						length = processorQ[i].length();
						if(length<lengthF){
							lengthF = length;
							tempIndex = i;
						}
					}

					comp = (Job)storage.dequeue();
					processorQ[tempIndex].enqueue(comp);
					if(processorQ[tempIndex].length() == 1){
						compare = (int)processorQ[tempIndex].peek();
						comp.computeFinishTime(time);
					}

				}else{
					comp = (Job)processorQ[index].dequeue();
					finish.enqueue(comp);
					if(comp.getWaitTime() > maxWait){
						maxWait = comp.getWaitTime();
					}
					maxWait += comp.getWaitTime();

					if(processorQ[index].length() >= 1){
						comp = (Job)processorQ[index].peek();
						comp.computeFinishTime(time);
					}
				}
				
				trace.println();
				trace.println("time=" + time);
				trace.println("0: " + storage.toString());
				for(int i = 1; i < processors+1; i++){
					trace.println(i + ":" + processorQ[i]);
				}
			}
			avgWait = ((double)totalWait/m);
			avgWait = (double)Math.round(avgWait*100)/100;
			trace.println();
			if (processors == 1){
				report.println(processors + " processor: totalWait=" + totalWait + ", maxWait=" + maxWait + ", averageWait=" + avgWait);
			}else{
				report.println(processors + " processors: totalWait=" + totalWait + ", maxWait=" + maxWait + ", averageWait=" + avgWait);
			}
			time = 0;
			finish.dequeueAll();
		}
		in.close();
		report.close();
		trace.close();
	}
	public static int numOfJobs(Scanner in){
		String s = in.nextLine();
		int x = Integer.parseInt(s);
		return x;
	}
	public static Job getJob(Scanner in) {
		String[] s = in.nextLine().split(" ");
		int a = Integer.parseInt(s[0]);
		int d = Integer.parseInt(s[1]);
		return new Job(a, d);
	}

}
