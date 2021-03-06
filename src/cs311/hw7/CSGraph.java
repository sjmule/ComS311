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
	private List<String> verticesStrings;
	
	public CSGraph(boolean isDirected)
	{
		this.isDirected = isDirected;
		vertices = new HashMap<String, Vertex<S,T>>();
		edges = new ArrayList<Edge<T>>();
		verticesStrings = new ArrayList<String>();
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
		if(!verticesStrings.contains(vertexLabel))
		{
			Vertex<S,T> v = new Vertex<S,T>(vertexLabel, vertexData);
			vertices.put(vertexLabel, v);
			verticesStrings.add(vertexLabel);
		}
	}
	
	/**
	 * Removes the vertex and all edges associated with it
	 * from the graph.
	 * 
	 * @param vertexLabel The vertex to be removed.
	 */
	public void removeVertex(String vertexLabel)
	{
		if(verticesStrings.contains(vertexLabel))
		{
			Vertex<S,T> v = vertices.get(vertexLabel);
			Map<String, Edge<T>> ed = v.getNeighborsWithEdges();
			for(String s : ed.keySet())
			{
				edges.remove(ed.get(s)); // Remove all edges that vertex is a source of or if undirected source/target
			}
			if(isDirected)
			{
				List<Edge<T>> incoming = findIncomingEdges(vertexLabel);
				for(Edge<T> e : incoming)
				{
					vertices.get(e.getSource()).removeNeighbor(vertexLabel); // Remove this edge as a neighbor to all nodes that consider it to be one
					edges.remove(e); // Remove all edges for which this edge is a target
				}
			}
			else
			{	
				for(String s : v.getNeighbors())
				{
					vertices.get(s).removeNeighbor(vertexLabel); // If undirected remove vertex from neighbors' neighbor list
				}
			}
			vertices.remove(vertexLabel); // Delete the vertex
			verticesStrings.remove(vertexLabel);
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
		Edge<T> e = new Edge<T>(sourceLabel, targetLabel, edgeData);
		edges.add(e);
		
		vertices.get(sourceLabel).addNeighbor(targetLabel, e);
		if(!isDirected)
		{
			Edge<T> ed = new Edge<T>(targetLabel, sourceLabel, edgeData);
			vertices.get(targetLabel).addNeighbor(sourceLabel, ed);
			edges.add(ed);
		}
	}
	
	/**
	 * Returns the edge data associated with this edge.
	 * 
	 * @param sourceLabel  The source vertex of the edge.
	 * @param targetLabel  The target vertex of the edge.
	 */
	public T getEdgeData(String sourceLabel, String targetLabel)
	{
		return findEdge(sourceLabel, targetLabel).getData();
	}
	
	private Edge<T> findEdge(String sourceLabel, String targetLabel)
	{
		for(Edge<T> e : edges)
		{
			if(e.getSource().equals(sourceLabel))
				if(e.getTarget().equals(targetLabel))
					return e;
		}
		return null;
	}

	private List<Edge<T>> findIncomingEdges(String targetLabel)
	{
		List<Edge<T>> incoming = new ArrayList<Edge<T>>();
		for(Edge<T> e : edges)
		{
			if(e.getTarget().equals(targetLabel))
				incoming.add(e);
		}
		return incoming;
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
		return verticesStrings.size();
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
		return verticesStrings;
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
	
	public void removeEdge(Edge<T> edge)
	{
		vertices.get(edge.getSource()).removeNeighbor(edge.getTarget());
		if(!isDirected)
		{
			vertices.get(edge.getTarget()).removeNeighbor(edge.getSource());
			Edge<T> e = new Edge<T>(edge.getTarget(), edge.getSource(), edge.getData());
			edges.remove(e);
		}
		edges.remove(edge);
	}
	
	/**
	 * Returns a valid topological sort if the graph is a
	 * directed acyclic graph and returns null otherwise.
	 */
	public List<String> topologicalSort()
	{
		if(!isDirected)
			return null;
		List<String> list = new ArrayList<String>();
		List<String> toAlter = new ArrayList<String>();
		for(String s : verticesStrings)
		{
			vertices.get(s).setState(State.UNDISCOVERD); //Runs in O(|V|) time
			toAlter.add(s);
		}
		while(!toAlter.isEmpty())
			DFS(toAlter.get(0), list, toAlter); //Runs in O(|E|) time
		return list;
	}
	
	private void DFS(String vertex, List<String> resultList, List<String> workingList)
	{
		Vertex<S,T> v = vertices.get(vertex);
		for(String s : v.getNeighbors())
		{
			if(vertices.get(s).getState() == State.UNDISCOVERD)
			{
				vertices.get(s).setState(State.DISCOVERED);
				DFS(s, resultList, workingList);
			}
		}
		v.setState(State.PROCESSED);
		resultList.add(vertex);
		workingList.remove(vertex);
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
		List<String> closed = new ArrayList<String>();
		open.add(startLabel);
		
		for(String s : vertices.keySet())
		{
			vertices.get(s).setDist(Double.MAX_VALUE);
			vertices.get(s).setPred(null);
		}
		vertices.get(startLabel).setDist(0);
		
		while(!open.isEmpty())
		{
			Vertex<S,T> vert = getMin(open);
			closed.add(vert.getLabel());
			open.remove(vert.getLabel());
			for(String s : vert.getNeighbors())
			{
				if(!closed.contains(s))
				{
					double alt = vert.getDist() + measure.getCost(findEdge(vert.getLabel(), s).getData());
					if(alt < vertices.get(s).getDist())
					{
						open.add(s);
						vertices.get(s).setDist(alt);
						vertices.get(s).setPred(vert.getLabel());
					}
				}
			}
		}
		calculatePath(closed, startLabel, destLabel, path);
		
		return path;
	}
	
	private Vertex<S,T> getMin(List<String> list)
	{
		double minDist = Double.MAX_VALUE;
		Vertex<S,T> min = new Vertex<S,T>(null, null);
		for(String s : list)
		{
			if(vertices.get(s).getDist() < minDist)
			{
				min = vertices.get(s);
			}
		}
		
		return min;
	}
	
	private void calculatePath(List<String> verts, String start, String end, List<String> path)
	{
		if(end.equals(start))
		{
			path.add(end);
		}
		else
			calculatePath(verts, start, vertices.get(end).getPred(), path);
		path.equals(end);
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
		CSGraph<S,T> graph = new CSGraph<S,T>(false);
		List<Edge<T>> pq = mergeSort(edges); //Runs in O(|E|log|E|) time
		for(String s : verticesStrings)
		{
			graph.addVertex(s, vertices.get(s).getData());
		}
		while((!pq.isEmpty()) && (graph.getNumEdges() < graph.getNumVertices()-1))
		{
			Edge<T> edge = pq.remove(0);
			for(String s : graph.verticesStrings)
			{
				graph.vertices.get(s).setState(State.UNDISCOVERD);
			}
			if(graph.findCycles(graph.vertices.get(edge.getSource())))
			{
				graph.removeEdge(edge);
			}
		}
		return graph;
	}
	
	private List<Edge<T>> mergeSort(List<Edge<T>> list)
	{
		List<Edge<T>> toReturn = new ArrayList<Edge<T>>();
		Object[] array = recursiveMergeSort(list.toArray(), 0, toReturn.size()-1);
		for(int i = 0; i < array.length; i++)
		{
			toReturn.add((Edge<T>) array[i]);
		}
		return toReturn;
	}
	
	private Object[] recursiveMergeSort(Object[] array, int left, int right)
	{
		if(right > left)
		{
			int mid = (left + right) / 2;
			recursiveMergeSort(array, left, mid);
			recursiveMergeSort(array, mid+1, right);
			
			merge(array, left, mid+1, right);
		}
		return array;
	}
	
	private void merge(Object[] array, int left, int mid, int right)
	{
		Object[] temp = new Object[edges.size()];
		int left_end = (mid-1);
		int tmp_pos = left;
		int num_elements = right - left + 1;
		
		while((left<=left_end) && (mid <= right))
		{
			Edge<T> a = (Edge<T>) array[left];
			Edge<T> b = (Edge<T>) array[mid];
			if((Double)a.getData() <= (Double)b.getData())
				temp[tmp_pos++] = array[left++];
			else
				temp[tmp_pos++] = array[mid++];
		}
		
		while(left <= left_end)
			temp[tmp_pos++] = array[left++];
		
		while(mid <= right)
			temp[tmp_pos++] = array[mid++];
		
		for(int i = 0; i < num_elements; i++)
		{
			array[right] = temp[right];
			right--;
		}
	}
	
	private boolean findCycles(Vertex<S,T> vertex)
	{
		boolean loop = false;
		for(String s : vertex.getNeighbors())
		{
			if(vertices.get(s).getState() == State.UNDISCOVERD)
			{
				vertices.get(s).setState(State.DISCOVERED);
				loop = findCycles(vertices.get(s));
			}
			else
				loop = true;
		}
		vertex.setState(State.PROCESSED);
		return loop;
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