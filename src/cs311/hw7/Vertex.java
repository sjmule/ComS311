package cs311.hw7;

import java.util.ArrayList;
import java.util.List;

public class Vertex 
{
	private String lat;
	private String lon;
	private List<String> neighbors;
	
	public Vertex(String lat, String lon)
	{
		this.lat = lat;
		this.lon = lon;
		neighbors = new ArrayList<String>();
	}
	
	public String getLatitude()
	{
		return lat;
	}
	
	public String getLongitude()
	{
		return lon;
	}
	
	public List<String> getNeighbors()
	{
		return neighbors;
	}
}
