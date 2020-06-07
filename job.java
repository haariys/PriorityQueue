package assignment;

public class job {
	
	public String name="NULL error no value set";
	public int duration=007, deadline=007;
	
	public void newjob(String name,int duration, int deadline) 
	{
		
		this.name=name;
		this.duration = duration;
		this.deadline=deadline;
	}
	
	public String getname() 
	{
			return name;
		
	}
	public int getduration() 
	{
		return duration;
	}
	public int getdeadline() 
	{
		return deadline;
	}

	public void getall() 
	{
		System.out.println(getname()+getduration()+getdeadline());
	}
}
