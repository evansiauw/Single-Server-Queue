import java.util.LinkedList;
import java.util.Random;
import java.lang.Math;

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
	    int arrivalTime = 0;
	    double time = 0;
	    int meanLength = 10;
	    int meanArrival = 13;
	    
	    Job [] Jobs = new Job[numOfJobs];
	    
	    for(int i = 0; i < numOfJobs; i++){
	    	
	    	 	int interArrival = (int) (meanArrival *(-Math.log(Math.random()))) + 1;
	    	 	int jobLength = (int) (meanLength *(-Math.log(Math.random())) ) + 1;
	    	 	
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
