package cs311.hw4;

import java.util.Comparator;

public class IntComparator<T> implements Comparator<T>
{
	public int compare(T a, T b)
	{
		if(a == null)
			throw new NullPointerException();
		if(b == null)
			throw new NullPointerException();
		if(!a.getClass().equals(b.getClass()))
			throw new ClassCastException();
		Integer a1 = (Integer) a;
		Integer b1 = (Integer) b;
		return a1.intValue() - b1.intValue();
	}
}
