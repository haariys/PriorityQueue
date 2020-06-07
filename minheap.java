package assignment;
import java.lang.*;
import java.io.*; 
import java.util.*;
public class minheap {

	public static List<job> jobs= new ArrayList<job>(1000);;
	public static ArrayList<Integer> Queue= new ArrayList<Integer>(1000);
	
	public static void main (String [] args)throws Exception 
	{
	heapify ob = new heapify(); int time=0;
	String s2 = "schedule";
	File file = new File("myfile.txt");
	BufferedReader br = new BufferedReader(new FileReader(file));
	String st; 
	  while ((st = br.readLine()) != null) 
	  {
	   String str_type = st.contains(" ") ? st.split(" ")[0] : st;
	   if (str_type.equals(s2)) 
	   {
	   
		   job job1 = new job();
		   String str_activity = st.contains(" ") ? st.split(" ")[1] : st;
		   job1.name=str_activity;
		   String str_deadline = st.contains(" ") ? st.split(" ")[2] : st;int i_deadline=Integer.parseInt(str_deadline);
		   job1.deadline=i_deadline;
		   Queue.add(job1.deadline);
		   String str_duration = st.contains(" ") ? st.split(" ")[3] : st;int i_duration=Integer.parseInt(str_duration);
		   job1.duration = i_duration;
		   jobs.add(job1);
		   System.out.println(time +" : adding "+ job1.getname() + "  with deadline "+ job1.getdeadline() +" and duration " + job1.getduration());
		   long t_start =System.nanoTime();
		   ob.sort(Queue);
		   long t_end =System.nanoTime();
		   int d = Queue.size();
		   int e = Queue.indexOf(job1.deadline);
		   int f =(d-e)/2;
		   long span=t_end-t_start;
		   System.out.println("\n################### Time consumed in heapsort = " + span+"   & levels traversed are = " + f +" ################### \n");
		   System.out.println("Updated Priority Queue = "+ Queue +"\n");
		   
	   }
	   else 
	   {
		   System.out.println("=========================================================");
		   String str_run = st.contains(" ") ? st.split(" ")[0] : st;
		   String str_limit = st.contains(" ") ? st.split(" ")[1] : st;int i_limit=Integer.parseInt(str_limit);
		   int size =Queue.size();
		   for(int i=0;i<size;i++)
		   {
		   int q = Queue.get(0);
		   Queue.remove(0);
		   for (int k =0;k<jobs.size();k++)
		   {
			   if (q == jobs.get(k).getdeadline())
				   {
				   
				   
				   System.out.println(time + " :   Doing = " + jobs.get(k).getname()+ "   Deadline = "+ jobs.get(k).getdeadline()+"   Duration = "+ jobs.get(k).getduration()+"\n");
				   if(i_limit<(time+jobs.get(k).getduration())) {
					   int j= i_limit-time;
					   int exceed = time+jobs.get(k).getduration();
					   int exceeded=exceed-i_limit;
					   System.out.println(i_limit+" : adding " + jobs.get(k).getname()+"  with deadline = " +jobs.get(k).getdeadline()+" and duration = "+exceeded+"\n" );
					   time=i_limit;
					  if (jobs.get(k).getdeadline()>=time+exceeded) {
					  	System.out.println(time + " :   Doing = " + jobs.get(k).getname()+ "   Deadline = "+ jobs.get(k).getdeadline()+"   Duration = "+ exceeded +"\n");
					    time=time+exceeded;
					    System.out.println(time + " :   Done with " + jobs.get(k).getname()+"\n");
					    System.out.println("Updated Priority Queue = "+ Queue +"\n");
					   } 
					   else 
					   {
						   System.out.println(time + " :   Doing = " + jobs.get(k).getname()+ "   Deadline = "+ jobs.get(k).getdeadline()+"   Duration = "+ exceeded +"\n");
						    time=time+exceeded;
						    System.out.println(time + " :   Done with " + jobs.get(k).getname()+" *****LATE***** \n");
						    System.out.println("Updated Priority Queue = "+ Queue +"\n");
					   }
					    	
					}
				   else
				   {  time = time+jobs.get(k).getduration();
					   if(time>jobs.get(k).getdeadline()) 
					   {   
					   System.out.println(time  + " :   done with  " + jobs.get(k).getname() +"*****LATE*****\n");
					   System.out.println("Updated Priority Queue = "+ Queue +"\n");
					   }
					   else 
					   {
					   	System.out.println(time  + " :   done with  " + jobs.get(k).getname() +"\n");
					   	System.out.println("Updated Priority Queue = "+ Queue +"\n");
				       }
					   
				   }   
				}
			}
		}
	}
}

	  int n = Queue.size();
	}
}
