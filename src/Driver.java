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
		
	    LinkedList<Job> jobQueue = new LinkedList<>();
	    int numOfJobs = 200;
	    int arrivalTime = 0;
	    double time = 0;
	    int meanLength = 10;
	    int meanArrival = 13;
	    
	    Job [] Jobs = new Job[numOfJobs];
	    
        Random rand = new Random();
	    
        //for each job 
	    for(int jobNum = 0; jobNum < numOfJobs; jobNum++){
	        // generating a random number between 0.3 and 0.5 since we want the
	        // job length to have a mean of 10 milliseconds
    		double randomValueJobLength = 0.3 + (0.5 - 0.3) * rand.nextDouble(); 
    		
    		// generating a random number between 0.22 and 0.37 since we want the
    		// interarrival time with a mean of 13 millisconds
    		double randomValueInterArrival = 0.22 + (0.37 - 0.22) * rand.nextDouble(); 

    		// calculating interarrival time and job length based on previous computed random values
    	 	int interArrival = (int) (meanArrival *(-Math.log(randomValueInterArrival)));
    	 	int jobLength = (int) (meanLength *(-Math.log(randomValueJobLength)) );
    	 	
    	 	// add jobs to job queue
	 	    if (jobNum == 0) arrivalTime += interArrival; // for the first job
	 	    else arrivalTime = jobQueue.getFirst().arrivalTime + interArrival; // for all other jobs
		    Jobs [jobNum] = new Job(jobNum,arrivalTime,jobLength); 
		    jobQueue.add(Jobs[jobNum]);
		    
    	 	
	    }
	    
	    int counter = 0;
	    // keep serving jobs as long as there are jobs to be served in the list
	    while (jobQueue.size() > 0){
	    	
    		Job currentJob = jobQueue.getFirst(); //get the job at the beginning of the list (FCFS)
    		counter++;
    		//output this if job is done being served
    		if(currentJob.jobLength <= 5 || jobQueue.size() == 1) {
    			time += currentJob.jobLength;
    			currentJob.jobLength -= currentJob.jobLength;
    			jobQueue.remove();
    			
    		}
    		//output this if job is not being done served
    		else {
    			time +=5;
    			currentJob.getService();
    			jobQueue.addLast(currentJob);
    			jobQueue.removeFirst();
    			//counter--;
    		}
    		  
    		
    		if(time == 1000) {
    			System.out.println(time);
    			System.out.println(counter);
    		}

	    }
	    
	    System.out.println(numOfJobs + " Jobs completed in " + time/1000 + " second");
	    	System.out.println(counter);	

	}

}
