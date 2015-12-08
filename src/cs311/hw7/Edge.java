package cs311.hw7;

public class Edge 
{
	private String source;
	private String target;
	private double distance;
	
	public Edge(String source, String target, double distance)
	{
		this.source = source;
		this.target = target;
		this.distance = distance;
	}
	
	public String getSource()
	{
		return source;
	}
	
	public String getTarget()
	{
		return target;
	}
	
	public double getDistance()
	{
		return distance;
	}
	
}
