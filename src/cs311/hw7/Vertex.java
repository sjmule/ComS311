package cs311.hw7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Vertex 
{
	private String lat;
	private String lon;
	private Map<String, Double> neighbors;
	
	public Vertex(String lat, String lon)
	{
		this.lat = lat;
		this.lon = lon;
		neighbors = new HashMap<String, Double>();
	}
	
	public String getLatitude()
	{
		return lat;
	}
	
	public String getLongitude()
	{
		return lon;
	}
	
	public void addNeighbor(String neighbor, double cost)
	{
		neighbors.put(neighbor, cost);
	}
	
	public Set<String> getNeighbors()
	{
		return neighbors.keySet();
	}
	
	public double getEdgeCost(String edge)
	{
		return neighbors.get(edge);
	}
}
