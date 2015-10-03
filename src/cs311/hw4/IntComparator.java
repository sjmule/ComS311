package cs311.hw4;

import java.util.Comparator;

public class IntComparator<T extends Comparable<? super T>> implements Comparator<T>
{
	public int compare(T a, T b)
	{
		if(a == null)
			throw new NullPointerException();
		if(b == null)
			throw new NullPointerException();
		if(!a.getClass().equals(b.getClass()))
			throw new ClassCastException();
		return this.compare(a, b);
	}
	
	public boolean equals(Object obj)
	{
		return this.equals(obj);
	}
}
