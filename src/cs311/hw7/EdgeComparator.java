package cs311.hw7;

import java.util.Comparator;

public class EdgeComparator<T> implements Comparator<T>
{
	public int compare(T a, T b)
	{
		if(a == null)
			throw new NullPointerException();
		if(b == null)
			throw new NullPointerException();
		if(!a.getClass().equals(b.getClass()))
			throw new ClassCastException();
		Edge<T> a1 = (Edge<T>) a;
		Edge<T> b1 = (Edge<T>) b;
		Double ad = (Double) a1.getData();
		Double bd = (Double) b1.getData();
		Double re = ad - bd;
		return re.intValue();
	}
}
