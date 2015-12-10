package cs311.hw7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Vertex<S,T> 
{
	private String label;
	private S data;
	private Map<String, Edge<T>> neighbors;
	private String pred;
	private double dist;
	private State state;
	
	public Vertex(String label, S data)
	{
		this.label = label;
		this.data = data;
		neighbors = new HashMap<String, Edge<T>>();
	}
	
	public String getLabel()
	{
		return label;
	}
	
	public S getData()
	{
		return data;
	}
	
	public void addNeighbor(String neighbor, Edge<T> edge)
	{
		neighbors.put(neighbor, edge);
	}
	
	public Set<String> getNeighbors()
	{
		return neighbors.keySet();
	}
	
	public void removeNeighbor(String neighbor)
	{
		neighbors.remove(neighbor);
	}
	
	public Map<String, Edge<T>> getNeighborsWithEdges()
	{
		return neighbors;
	}
	
	public void setPred(String pred)
	{
		this.pred = pred;
	}
	
	public String getPred()
	{
		return pred;
	}
	
	public void setDist(double dist)
	{
		this.dist = dist;
	}
	
	public double getDist()
	{
		return dist;
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
