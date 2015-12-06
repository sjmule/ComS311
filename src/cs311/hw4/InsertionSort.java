package cs311.hw4;

import java.util.Comparator;

public class InsertionSort<T> implements ISort<T>
{

	public void sort(T[] arr, int start, int end, Comparator<T> comp)
	{
		// Do some argument checking
		if (arr.length == 0 || arr == null)
			throw new IllegalArgumentException();
		if (start > end || start < 0 || end >= arr.length)
			throw new IllegalArgumentException();
		if (comp == null)
			throw new IllegalArgumentException();

		// The sorting
		for (int i = start + 1; i <= end; i++)
		{
			// Run from the current to the last element in our defined points
			for (int j = i; j > start; j--)
			{
				// Check if the current element is bigger than the previous one
				if (comp.compare(arr[j - 1], arr[j]) > 0)
				{
					// Swap
					T temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
