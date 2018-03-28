import java.util.LinkedList;
import java.util.Random;
import java.lang.Math;

/* Single Queue With Feedback
 * 
 * Joshua Goldstein, Iwan Siauw, Orlando Calle
 * 
 * This program simulates jobs service in a FCFS order
 *
 * 1. The total number of jobs to serve is 1000.
 * 2. Jobs comes to the system with an exponential time of (mean 13 milliseconds).
 * 3. Each job has a limited service time of at most 5 milliseconds. Otherwise, if the job is not complete
 *    they go back to the queue.
 * 
*/

public class Driver {

	public static void main(String[] args) {
		
	    LinkedList<Job> jobList = new LinkedList<>();
	    int numOfJobs = 1000;
	    int arrivalTime = 0;
	    double time = 0;
	    int meanLength = 10;
	    int meanArrival = 13;
	    
	    Job [] Jobs = new Job[numOfJobs];
	    
	    for(int i = 0; i < numOfJobs; i++){
	    	
	    		Random rand = new Random();
	    		double randomValue1 = 0.3 + (0.5 - 0.3) * rand.nextDouble();
	    		double randomValue2 = 0.22 + (0.37 - 0.22) * rand.nextDouble();

	    	 	int interArrival = (int) (meanArrival *(-Math.log(randomValue2)));
	    	 	int jobLength = (int) (meanLength *(-Math.log(randomValue1)) );
	    	 	
	    	 	if(i == 0) {
	    	 		arrivalTime += interArrival;
	    		    Jobs [i] = new Job(i,arrivalTime,jobLength); 
	    		    jobList.add(Jobs[i]);
	    	 	} else {
	    	 		arrivalTime = jobList.getFirst().arrivalTime + interArrival;
	    		    Jobs [i] = new Job(i,arrivalTime,jobLength); 
	    		    jobList.add(Jobs[i]);
	    	 	}
	    }
	    
	    while (jobList.size() > 0){
	    	
	    		Job currentJob = jobList.getFirst();
	    		if(currentJob.jobLength <= 5 || jobList.size() == 1) {
	    			System.out.println("Time: " + time/1000 + " second" + ", Processing Job " + currentJob.jobNumber);
	    			time += currentJob.jobLength;
	    			System.out.println("Job Length: " + currentJob.jobLength);
	    			currentJob.jobLength -= currentJob.jobLength;
	    			System.out.println("Jobs served \n");
	    			jobList.remove();
	    			
	    		}
	    		else {
	    			System.out.println("Time: " + time/1000 + " second" + ", Processing Job " + currentJob.jobNumber);
	    			time +=5;
	    			System.out.println("Job Length: " + currentJob.jobLength);
	    			currentJob.getService();
	    			System.out.println("Job Length Remaining time: " + currentJob.jobLength);
	    			System.out.println("Goes back to the end of the queue\n");
	    			jobList.addLast(currentJob);
	    			jobList.removeFirst();
	    		}
	    		
	    }

	}

}
