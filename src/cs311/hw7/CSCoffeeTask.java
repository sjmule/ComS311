package cs311.hw7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSCoffeeTask<S,T> implements CoffeeTask
{
	private CSGraph<S,T> dep;
	
	public CSCoffeeTask()
	{
//		mappings.put(981, "A");
//		mappings.put(1653, "B");
//		mappings.put(524, "C");
//		mappings.put(1864, "D");
//		mappings.put(1119, "E");
//		mappings.put(1104, "F");
		dep = new CSGraph<S,T>(true);
		dep.addVertex("981", null);
		dep.addVertex("1653", null);
		dep.addVertex("524", null);
		dep.addVertex("1864", null);
		dep.addVertex("1119", null);
		dep.addVertex("1104", null);
		dep.addEdge("524", "981", null);
		dep.addEdge("524", "1653", null);
		dep.addEdge("524", "1104", null);
		dep.addEdge("1864", "1653", null);
		dep.addEdge("1864", "524", null);
		dep.addEdge("1119", "524", null);
		dep.addEdge("1119", "1104", null);
		
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
			topz.add(Integer.parseInt(s));
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
		List<Integer> route = new ArrayList<Integer>();
		CSGraph<S,T> graph = parseFile(amesFile, true);
		List<String> path = graph.shortestPath("1067", ingList.get(0).toString(), new CSEdgeMeasure<T>());
		for(String s : path)
		{
			route.add(Integer.parseInt(s));
		}
		for(int i = 0; i < ingList.size()-1; i++)
		{
			List<String> pat = graph.shortestPath(ingList.get(i).toString(), ingList.get(i+1).toString(), new CSEdgeMeasure<T>());
			for(String s : pat)
			{
				route.add(Integer.parseInt(s));
			}
		}
		List<String> pat = graph.shortestPath(ingList.get(ingList.size()-1).toString(), "826", new CSEdgeMeasure<T>());
		for(String s : pat)
		{
			route.add(Integer.parseInt(s));
		}
		return route;
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
		CSGraph<S,T> graph = parseFile(amesFile, false);
		CSGraph<S,T> min = (CSGraph) graph.minimumSpanningTree(new CSEdgeMeasure<T>());
		return min.getTotalCost(new CSEdgeMeasure<T>());
	}
	
	private CSGraph<S,T> parseFile(File file, boolean directed)
	{
		CSGraph<S,T> graph = new CSGraph<S,T>(directed);
		try
		{
			Scanner scanner = new Scanner(file);
			String line = scanner.nextLine();
			String[] parts = line.split("\\s+");
			int verts = Integer.parseInt(parts[1]);
			for(int i = 0; i < verts; i++)
			{
				line = scanner.nextLine();
				String[] par = line.split(",");
				String data = par[1] + par[2];
				graph.addVertex(par[0], (S)data);
			}
			line = scanner.nextLine();
			String[] partz = line.split("\\s+");
			int edgez = Integer.parseInt(partz[1]);
			for(int i = 0; i < edgez; i++)
			{
				line = scanner.nextLine();
				String[] par = line.split(",");
				Double data = Double.parseDouble(par[2]);
				graph.addEdge(par[0], par[1], (T)data);
			}
			scanner.close();
		}
		catch(Exception e){}
		return graph;
	}
}
