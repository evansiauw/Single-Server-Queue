import java.util.ArrayList;
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
		
	    ArrayList<Job> jobs = new ArrayList<>();
	    int numOfJobs = 1000;
	    int numOfJobsCompleted = 0;
	    int ArrivalTime = 0;
	    int JobLength = 0;
	    
	    for(int i = 1; i <= numOfJobs; i++){
	    	
	    	 	// need function for expo arrival time
		    // need function for expo job length
	    	
	        Job j = new Job(i,ArrivalTime, JobLength); 
	        jobs.add(j);
	    }
	    
	    while (jobs.size() > 0){
	    	
	    		if()
	    }

	}

}
