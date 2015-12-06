package cs311.hw4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.joda.time.DateTime;

public class IntegerTests
{

	public static void main(String[] args) throws IOException
	{
		String now = DateTime.now().toString("MMddyyyy-HH-mm-ss");
		String _fileName = "output_" + now + ".csv";
		File logFile = new File(_fileName);
		PrintStream printStream = new PrintStream(new FileOutputStream(logFile), true, "UTF-8");

		//printStream.println("Best case:");
		//testOne(printStream);
		//printStream.println("Worse case:");
		//testTwo(printStream);
		printStream.println("Average case:");
		testThree(printStream);
		
		printStream.close();
		System.out.println("done");
	}

	public static void testOne(PrintStream writer)
	{
		List<String> size = new ArrayList<String>();
		List<String> runTime = new ArrayList<String>();
		for(int i = 2; i <= 10002; i += 100)
		{
			Integer[] arr = new Integer[i];
			for(int j = 0; j < i; j++)
			{
				arr[j] = j;
				//System.out.print(arr[j] + ", ");
			}
			//System.out.println("");
			long start = System.currentTimeMillis();
			InsertionSort<Integer> sort = new InsertionSort<>();
			sort.sort(arr, 0, i-1, new IntComparator<Integer>());
			long end = System.currentTimeMillis();
			long runtime = end - start;
			size.add(i + ", ");
			runTime.add(runtime + ", ");
		}
		for(String s : size)
		{
			writer.print(s);
		}
		writer.println("");
		for(String s : runTime)
		{
			writer.print(s);
		}
		writer.println("");
	}

	public static void testTwo(PrintStream writer)
	{
		List<String> size = new ArrayList<String>();
		List<String> runTime = new ArrayList<String>();
		for(int i = 2; i <= 10002; i += 100)
		{
			Integer[] arr = new Integer[i];
			int k = 0;
			for(int j = i; j > 0; j--)
			{
				arr[k++] = j;
				//System.out.print(arr[k-1] + ", ");
			}
			//System.out.println("");
			long start = System.currentTimeMillis();
			InsertionSort<Integer> sort = new InsertionSort<>();
			sort.sort(arr, 0, i-1, new IntComparator<Integer>());
			long end = System.currentTimeMillis();
			long runtime = end - start;
			size.add(i + ", ");
			runTime.add(runtime + ", ");
		}
		for(String s : size)
		{
			writer.print(s);
		}
		writer.println("");
		for(String s : runTime)
		{
			writer.print(s);
		}
		writer.println("");
	}

	public static void testThree(PrintStream writer)
	{
		List<String> size = new ArrayList<String>();
		List<String> avgList = new ArrayList<String>();
		long avg = 0;
		Random rand = new Random();
		for(int i = 2; i <= 10002; i += 100)
		{
			for(int j = 0; j < 100; j++)
			{
				Integer[] arr = new Integer[i];
				for(int k = 0; k < i; k++)
				{
					arr[k] = rand.nextInt(1000);
				}
				long start = System.currentTimeMillis();
				InsertionSort<Integer> sort = new InsertionSort<>();
				sort.sort(arr, 0, i-1, new IntComparator<Integer>());
				long end = System.currentTimeMillis();
				long runtime = end - start;
				avg += runtime;
			}
			avg = avg/100;
			size.add(i + ", ");
			avgList.add(avg + ", ");
			avg = 0;
		}
		for(String s : size)
		{
			writer.print(s);
		}
		writer.println("");
		for(String s : avgList)
		{
			writer.print(s);
		}
		writer.println("");
	}
}
