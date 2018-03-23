import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/* Jobs come into the system, arriving with an exponential interarrival time 
 * (mean 13 milliseconds) , and have an exponential amount of work with 
 * a mean of 10 milliseconds. They wait their turn for service in FCFS order. 
 * Once they have the attention of the server, they are served 
 * but for not more than 5 milliseconds. If their required work is not completed 
 * they go to the back of the jobs waiting for service. 

 * Run the system for 100 seconds. 
 * Output the amount of time until completion for each 1000 jobs.
*/

public class Driver {

	public static void main(String[] args) {
		
	    LinkedList<Job> jobs = new LinkedList<>();
	    int numOfJobs = 1000;
	    int numOfJobsCompleted = 0;
	    int arrivalTime = 0;
	    int jobLength = 0;
	    int serviceTime = 5;
	    
	    for(int i = 1; i <= numOfJobs; i++){
	    	
	    	 	// need function for expo arrival time
		    // need function for expo job length
	    	
	        Job j = new Job(i,arrivalTime, jobLength); 
	        jobs.add(j);
	    }
	    
	    while (jobs.size() > 0){
	    	
	    		Job currentJob = jobs.getFirst();
	    		if(currentJob.jobLength <= 5);
	    		
	    }

	}

}
