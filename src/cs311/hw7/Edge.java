package cs311.hw7;

public class Edge<T>
{
	private String source;
	private String target;
	private T data;
	private State state;
	
	public Edge(String source, String target, T data)
	{
		this.source = source;
		this.target = target;
		this.data = data;
	}
	
	public String getSource()
	{
		return source;
	}
	
	public String getTarget()
	{
		return target;
	}
	
	public T getData()
	{
		return data;
	}
	
	public void setState(State state)
	{
		this.state = state;
	}
	
	public State getState()
	{
		return state;
	}
}
