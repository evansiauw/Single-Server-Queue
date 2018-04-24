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
	    int numOfJobs = 1000;
	    int arrivalTime = 0;
	    double time = 0;
	    int meanLength = 10;
	    int meanArrival = 13;
	    int jobNum =0;
	    int count=0;
	    
        Random rand = new Random();
	    
        
    	 	while (count <= numOfJobs){
    	 		
    		    	jobNum++;

    	 	    	int interArrival = (int) (meanArrival *(-Math.log(1- rand.nextDouble())));
    	 	    	int jobLength = (int) (meanLength *(-Math.log(1 - rand.nextDouble())));
    	 		
    	 	    	// Checking if this is the first job that arrives, so arrival time is 0
    	 	    	if (jobQueue.size()==0) { 
    	 	  		arrivalTime += arrivalTime;
    	 	    	}
    	 	    	else{ // arrival time of the next job would be the arrival time of the previous job
    	 	    		  // plus the interarrival time
    	 	   	 	arrivalTime = jobQueue.getLast().arrivalTime + interArrival;
    	 	    	}
    	 	    	
    	 	    	// Creating new object and add them to the LinkedList
    	 	    	Job next = new Job(jobNum,arrivalTime,jobLength);
    	 	    	jobQueue.add(next);	
    	 	    	
    	 	    	// Advance from the current time to the next arrival time
    	 	    	while (time < jobQueue.getFirst().arrivalTime) {
    	 	    		time++;
    	 	    	}
    	 	    	
    	 	    	// If the current job length is less than 5, advance time and remove job from the Queue
    	 	    	// Increase the counter to keep track how many jobs has been completed
    	    		if(jobQueue.getFirst().jobLength <= 5 || count == numOfJobs) {
    	    			time += jobQueue.getFirst().jobLength;
    	    			jobQueue.getFirst().jobLength -= jobQueue.getFirst().jobLength;
    	    			jobQueue.remove();
    	    			count++;
    	    		}
    	    		else {// If the current job length is greater than 5, subtract job length by 5
    	    			  // and add them to the back of the Queue
    	    			time +=5;
    	    			jobQueue.getFirst().getService();
    	    			jobQueue.addLast(jobQueue.getFirst());
    	    			jobQueue.removeFirst();
    	    			
    	    		}
    	    		
	    }
    	 	
    		System.out.println("Completion time for " + numOfJobs + " jobs is: " + (time/1000));
 	  

	    }
	    
	}

