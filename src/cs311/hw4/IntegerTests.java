package cs311.hw4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.joda.time.DateTime;

public class IntegerTests
{

	public static void main(String[] args) throws IOException
	{
		String now = DateTime.now().toString("MMddyyyy-HH:mm:ss");
		File output = new File(".\\", "output_" + now + ".txt");
		output.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(output.getAbsolutePath()));

		testOne(writer);
		testTwo(writer);
		testThree(writer);
		testFour(writer);
		testFive(writer);
		testSix(writer);
		testSeven(writer);
		testEight(writer);
		testNine(writer);
		testTen(writer);
	}

	public static void testOne(BufferedWriter writer) throws IOException
	{
		writer.append("Test one:\r\n");

		Random rand = new Random();
		int n = rand.nextInt(100);
		Integer[] arr = new Integer[n];
		writer.append("Creating array with " + n + " integers\r\n");
		writer.append(arr.toString());

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;
		writer.append(arr.toString());

		writer.append("Array sorted in " + runtime + " milliseconds\r\n\r\n");

	}

	public static void testTwo(BufferedWriter writer) throws IOException
	{
		writer.append("Test two:\r\n");

		Random rand = new Random();
		int n = rand.nextInt(100);
		Integer[] arr = new Integer[n];
		writer.append("Creating array with " + n + " integers\r\n");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		writer.append("Array sorted in " + runtime + " milliseconds\r\n\r\n");
	}

	public static void testThree(BufferedWriter writer) throws IOException
	{
		writer.append("Test three:\r\n");

		Random rand = new Random();
		int n = rand.nextInt(100);
		Integer[] arr = new Integer[n];
		writer.append("Creating array with " + n + " integers\r\n");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		writer.append("Array sorted in " + runtime + " milliseconds\r\n\r\n");
	}

	public static void testFour(BufferedWriter writer) throws IOException
	{
		writer.append("Test four:\r\n");

		Random rand = new Random();
		int n = rand.nextInt(100);
		Integer[] arr = new Integer[n];
		writer.append("Creating array with " + n + " integers\r\n");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		writer.append("Array sorted in " + runtime + " milliseconds\r\n\r\n");
	}

	public static void testFive(BufferedWriter writer) throws IOException
	{
		writer.append("Test five:\r\n");

		Random rand = new Random();
		int n = rand.nextInt(100);
		Integer[] arr = new Integer[n];
		writer.append("Creating array with " + n + " integers\r\n");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		writer.append("Array sorted in " + runtime + " milliseconds\r\n\r\n");
	}

	public static void testSix(BufferedWriter writer) throws IOException
	{
		writer.append("Test six:\r\n");

		Random rand = new Random();
		int n = rand.nextInt(100);
		Integer[] arr = new Integer[n];
		writer.append("Creating array with " + n + " integers\r\n");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		writer.append("Array sorted in " + runtime + " milliseconds\r\n\r\n");
	}

	public static void testSeven(BufferedWriter writer) throws IOException
	{
		writer.append("Test seven:\r\n");

		Random rand = new Random();
		int n = rand.nextInt(100);
		Integer[] arr = new Integer[n];
		writer.append("Creating array with " + n + " integers\r\n");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		writer.append("Array sorted in " + runtime + " milliseconds\r\n\r\n");
	}

	public static void testEight(BufferedWriter writer) throws IOException
	{
		writer.append("Test eight:\r\n");

		Random rand = new Random();
		int n = rand.nextInt(100);
		Integer[] arr = new Integer[n];
		writer.append("Creating array with " + n + " integers\r\n");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		writer.append("Array sorted in " + runtime + " milliseconds\r\n\r\n");
	}

	public static void testNine(BufferedWriter writer) throws IOException
	{
		writer.append("Test nine:\r\n");

		Random rand = new Random();
		int n = rand.nextInt(100);
		Integer[] arr = new Integer[n];
		writer.append("Creating array with " + n + " integers\r\n");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		writer.append("Array sorted in " + runtime + " milliseconds\r\n\r\n");
	}

	public static void testTen(BufferedWriter writer) throws IOException
	{
		writer.append("Test ten:\r\n");

		Random rand = new Random();
		int n = rand.nextInt(100);
		Integer[] arr = new Integer[n];
		writer.append("Creating array with " + n + " integers\r\n");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		writer.append("Array sorted in " + runtime + " milliseconds\r\n\r\n");
	}
}
