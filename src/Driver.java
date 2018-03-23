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
		
	    LinkedList<Job> jobList = new LinkedList<>();
	    int numOfJobs = 1000;
	    int arrivalTime = 7;
	    int jobLength = 7;
	    int time = 0;
	    
	    Job [] Jobs = new Job[numOfJobs];
	    
	    for(int i = 0; i < numOfJobs; i++){
	    	
	    	 	// need function for expo arrival time
		    // need function for expo job length
	    	
	        Jobs [i] = new Job(i,arrivalTime,jobLength); 
	        jobList.add(Jobs[i]);
	    }
	    
	    while (jobList.size() > 0){
	    	
	    		Job currentJob = jobList.getFirst();
	    		if(currentJob.jobLength <= 5 || jobList.size() == 1) {
	    			jobList.remove();
	    		}
	    		else {
	    			currentJob.getService();
	    			jobList.addLast(currentJob);
	    			jobList.removeFirst();
	    		}
	    		
	    }

	}

}
