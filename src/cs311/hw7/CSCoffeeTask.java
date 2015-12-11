package cs311.hw7;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSCoffeeTask<S,T> implements CoffeeTask
{
	private CSGraph<S,T> dep;
	private Map<String, Integer> mappings;
	
	public CSCoffeeTask()
	{
		mappings = new HashMap<String, Integer>();
		mappings.put("A", 981);
		mappings.put("B", 1653);
		mappings.put("C", 524);
		mappings.put("D", 1864);
		mappings.put("E", 1119);
		mappings.put("F", 1104);
		dep = new CSGraph<S,T>(true);
		dep.addVertex("A", null);
		dep.addVertex("B", null);
		dep.addVertex("C", null);
		dep.addVertex("D", null);
		dep.addVertex("E", null);
		dep.addVertex("F", null);
		dep.addEdge("C", "A", null);
		dep.addEdge("C", "B", null);
		dep.addEdge("C", "F", null);
		dep.addEdge("D", "B", null);
		dep.addEdge("D", "C", null);
		dep.addEdge("E", "C", null);
		dep.addEdge("E", "F", null);
		
	}
	
	/**
	 * You must construct a graph representing the ingredient
	 * dependencies specified in the homework and then use
	 * topological sort to find a valid sorting.
	 * 
	 * The list returned is the list of vertex ids of the locations
	 * of each ingredient in the valid sorting.
	 */
	public List<Integer> getSortedIngredientLocations()
	{
		List<String> top = dep.topologicalSort();
		List<Integer> topz = new ArrayList<Integer>();
		for(String s : top)
		{
			topz.add(mappings.get(s));
		}
		return topz;
	}
	
	/**
	 * Given a File to the Ames data and an ordering of
	 * ingredient location vertex ids, you are to parse the Ames file
	 * and create a directed graph, then find the shortest route from
	 * your location picking up the ingredients in the order specified,
	 * and then delivering them to Jim's location.
	 * 
	 * You are to use the distance provided in each edge of the Ames
	 * data as the weights of the edges.
	 * 
	 * The list returned is the order of vertex ids visited in the
	 * shortest path starting with your location and ending with
	 * Jim's location.
	 */
	public List<Integer> getShortestRoute(File amesFile, List<Integer> ingList)
	{
		
	}
	
	/**
	 * Given a File to the Ames data, you are to parse the file
	 * and create an undirected graph, then find a minimum spanning
	 * tree of the city, and return the total cost of the spanning
	 * tree.
	 * 
	 * Use the distance of every edge in the Ames file as the cost
	 * of the edges. The total cost is the sum of all the edge costs
	 * of the edges in the minimum spanning tree.
	 */
	public double getMSTCost(File amesFile)
	{
		
	}
}
