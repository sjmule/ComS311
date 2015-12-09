package cs311.hw7;

public class CSEdgeMeasure<T> implements EdgeMeasure<T>
{
	/**
	 * Computes the cost (sometimes referred to as the
	 * weight) of the edge.
	 */
	public double getCost(T edgeData)
	{
		return (Double)edgeData;
	}
}
