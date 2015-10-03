package cs311.hw4;

import java.util.Comparator;



public class InsertionSort<T> implements ISort<T>
{

	public void main(String[] args)
	{
		Integer[] arr = { 1, 3, 6 };
		Comparator<Integer> comp = new IntComparator<Integer>();

		//sort(arr, 0, 2, comp);
	}


	public void sort(T[] arr, int start, int end, Comparator<T> comp)
	{
		if (arr.length == 0 || arr == null)
			throw new IllegalArgumentException();
		if (start < end || start < 0 || end >= arr.length)
			throw new IllegalArgumentException();
		if (comp == null)
			throw new IllegalArgumentException();

		for (int i = start + 1; i <= end; i++)
		{
			int j = i;
			while (j > 0 && comp.compare(arr[j - 1], arr[j]) > 0)
			{
				T temp = arr[j - 1];
				arr[j - 1] = arr[j];
				arr[j] = temp;
			}
		}
	}
}
