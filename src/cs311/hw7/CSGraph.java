package cs311.hw7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSGraph<S,T> implements Graph<S,T>
{
	private boolean isDirected;
	private Map<String, Vertex<S,T>> vertices;
	private List<Edge<T>> edges;
	
	public CSGraph(boolean isDirected)
	{
		this.isDirected = isDirected;
		vertices = new HashMap<String, Vertex<S,T>>();
		edges = new ArrayList<Edge<T>>();
	}
	
	/**
	 * If this returns true, the graph is a directed
	 * graph. If false, it is undirected.
	 */
	public boolean isDirected()
	{
		return isDirected;
	}

	/**
	 * Adds a new vertex to the graph that is identified by the
	 * label and has the given vertex data attached to it.
	 * 
	 * @param vertexLabel  The identifying label of the graph.
	 * 
	 * @param vertexData   The data attached to the vertex.
	 */
	public void addVertex(String vertexLabel, S vertexData)
	{
		Vertex<S,T> v = new Vertex(vertexLabel, vertexData);
		vertices.put(vertexLabel, v);
	}
	
	/**
	 * Removes the vertex and all edges associated with it
	 * from the graph.
	 * 
	 * @param vertexLabel The vertex to be removed.
	 */
	public void removeVertex(String vertexLabel)
	{
		if(vertices.containsKey(vertexLabel))
		{
			if(!isDirected)
			{
				Vertex<S,T> v = vertices.get(vertexLabel);
				for(String s : v.getNeighbors())
				{
					vertices.get(s).removeNeighbor(vertexLabel);
				}
			}
			vertices.remove(vertexLabel);
		}
	}
	
	/**
	 * Adds an edge to the graph from the source vertex to the
	 * target vertex. The edge also has the given data stored
	 * in it.
	 * 
	 * If the graph is undirected, both vertices become
	 * neighbors of one another. If it is directed, the target
	 * vertex is added as a neighbor to source.
	 * 
	 * @param sourceLabel  The label of the source vertex of
	 *                     the edge.
	 *                     
	 * @param targetLabel  The label of the target vertex of
	 *                     the edge.
	 *                     
	 * @param edgeData     The data attached to the edge.
	 */
	public void addEdge(String sourceLabel, String targetLabel, T edgeData)
	{
		Edge<T> e = new Edge(sourceLabel, targetLabel, edgeData);
		edges.add(e);
		
		vertices.get(sourceLabel).addNeighbor(targetLabel, e);
		if(!isDirected)
			vertices.get(targetLabel).addNeighbor(sourceLabel, e);
	}
	
	/**
	 * Returns the edge data associated with this edge.
	 * 
	 * @param sourceLabel  The source vertex of the edge.
	 * @param targetLabel  The target vertex of the edge.
	 */
	public T getEdgeData(String sourceLabel, String targetLabel)
	{
		for(Edge<T> e : edges)
		{
			if(e.getSource().equals(sourceLabel))
				if(e.getTarget().equals(targetLabel))
					return e.getData();
		}
		return null;
	}
	
	/**
	 * Returns the vertex data associated with this vertex.
	 * 
	 * @param label  The label of the vertex.
	 */
	public S getVertexData(String label)
	{
		return vertices.get(label).getData();
	}
	

	/**
	 * Returns the number of vertices in the graph.
	 */
	public int getNumVertices()
	{
		return vertices.size();
	}
	

	/**
	 * Returns the number of edges in the graph.
	 */
	public int getNumEdges()
	{
		return edges.size();
	}
	
	
	/**
	 * Returns a collection of the labels of all the vertices
	 * in the graph.
	 */
	public Collection<String> getVertices()
	{
		return vertices.keySet();
	}
	
	
	/**
	 * Returns a collection of all the adjacent vertices of the
	 * given vertex.
	 * 
	 * @param label  The label of the vertex.
	 */
	public Collection<String> getNeighbors(String label)
	{
		return vertices.get(label).getNeighbors();
	}
	
	
	/**
	 * Returns a valid topological sort if the graph is a
	 * directed acyclic graph and returns null otherwise.
	 */
	public List<String> topologicalSort()
	{
		if(!isDirected)
			return null;
		
		List<String> returnList = new ArrayList<String>();
		//TODO
		return returnList;
	}
	
	
	/**
	 * Returns the shortest path from the start vertex to
	 * the destination vertex where "short" is defined by
	 * the edge measure object. The path is a list of the
	 * vertex labels in the path starting with the start
	 * vertex and ending with the end vertex.
	 * 
	 * @param startLabel  Starting vertex label.
	 * @param destLabel   Destination vertex label.
	 * @param measure     Measure that defines the weight
	 *                    of every edge in the graph.
	 *                    
	 * @return The shortest path from start to destination.
	 */
	public List<String> shortestPath(String startLabel, String destLabel, EdgeMeasure<T> measure)
	{
		List<String> path = new ArrayList<String>();
		List<String> open = new ArrayList<String>();
		path.add(startLabel);
		
		//TODO 10/29
		for(String s : vertices.keySet())
		{
			open.add(s);
			vertices.get(s).setDist(Double.MAX_VALUE);
			vertices.get(s).setPred(null);
		}
		vertices.get(startLabel).setDist(0);
		String v = startLabel;
		
		while(!open.isEmpty())
		{
			List<String> contained = new ArrayList<String>();
			for(String s : open)
			{
				if(vertices.get(v).getNeighbors().contains(s))
					contained.add(s);
			}
			if(contained.size() > 0)
				getMin(contained);
		}
		
		return path;
	}
	
	private double getMin(List<String> list)
	{
		double min = 0;
		
		
		return min;
	}
	
	
	/**
	 * Returns a minimum spanning tree for the graph with
	 * respect to the edge measure object. This tree is returned
	 * as a undirected graph.
	 * 
	 * @param Measure that defines the weight of every edge
	 *        in the graph.
	 */
	public Graph<S,T> minimumSpanningTree(EdgeMeasure<T> measure)
	{
		
	}
	
	
	/**
	 * Computes the total cost of the graph. The total cost is
	 * the sum of the costs of every edge in the graph.
	 * 
	 * @param measure The measure for how to determine the cost
	 *                of an edge.
	 */
	public double getTotalCost(EdgeMeasure<T> measure)
	{
		double cost = 0;
		for(Edge<T> e : edges)
		{
			cost += measure.getCost(e.getData());
		}
		return cost;
	}
}