package cs311.hw4;

import java.util.Random;

public class IntTest
{

	public static void main(String[] args)
	{
		testOne();
		testTwo();
		testThree();
		testFour();
		testFive();
		testSix();
		testSeven();
		testEight();
		testNine();
		testTen();
		testEleven();
		testTwelve();
		testThirteen();
		testFourteen();
		testFifteen();
		testSixteen();
		testSeventeen();
		testEighteen();
		testNineteen();
		testTwenty();
	}

	public static void testOne()
	{
		System.out.println("Test one:");

		Random rand = new Random();
		int n = 100;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");

	}

	public static void testTwo()
	{
		System.out.println("Test two:");

		Random rand = new Random();
		int n = 500;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}

	public static void testThree()
	{
		System.out.println("Test three:");

		Random rand = new Random();
		int n = 1000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}

	public static void testFour()
	{
		System.out.println("Test four:");

		Random rand = new Random();
		int n = 5000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}

	public static void testFive()
	{
		System.out.println("Test five:");

		Random rand = new Random();
		int n = 10000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}

	public static void testSix()
	{
		System.out.println("Test six:");

		Random rand = new Random();
		int n = 50000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}

	public static void testSeven()
	{
		System.out.println("Test seven:");

		Random rand = new Random();
		int n = 100000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}

	public static void testEight()
	{
		System.out.println("Test eight:");

		Random rand = new Random();
		int n = 500000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}

	public static void testNine()
	{
		System.out.println("Test nine:");

		Random rand = new Random();
		int n = 1000000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}

	public static void testTen()
	{
		System.out.println("Test ten:");

		Random rand = new Random();
		int n = 5000000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}
	
	public static void testEleven()
	{
		System.out.println("Test eleven:");

		Random rand = new Random();
		int n = 7500000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}
	
	public static void testTwelve()
	{
		System.out.println("Test twelve:");

		Random rand = new Random();
		int n = 10000000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}
	
	public static void testThirteen()
	{
		System.out.println("Test thirteen:");

		Random rand = new Random();
		int n = 15000000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}
	
	public static void testFourteen()
	{
		System.out.println("Test fourteen:");

		Random rand = new Random();
		int n = 20000000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}
	
	public static void testFifteen()
	{
		System.out.println("Test fifteen:");

		Random rand = new Random();
		int n = 25000000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}
	
	public static void testSixteen()
	{
		System.out.println("Test sixteen:");

		Random rand = new Random();
		int n = 30000000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}
	
	public static void testSeventeen()
	{
		System.out.println("Test seventeen:");

		Random rand = new Random();
		int n = 35000000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}
	
	public static void testEighteen()
	{
		System.out.println("Test eightteen:");

		Random rand = new Random();
		int n = 40000000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}
	
	public static void testNineteen()
	{
		System.out.println("Test nineteen:");

		Random rand = new Random();
		int n = 45000000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}
	
	public static void testTwenty()
	{
		System.out.println("Test twenty:");

		Random rand = new Random();
		int n = 50000000;
		Integer[] arr = new Integer[n];
		System.out.println("Creating array with " + n + " integers");

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(1000);
		}

		long start = System.currentTimeMillis();
		InsertionSort<Integer> sort = new InsertionSort<>();
		sort.sort(arr, 0, n-1, new IntComparator<Integer>());
		long end = System.currentTimeMillis();
		long runtime = end - start;

		System.out.println("Array sorted in " + runtime + " milliseconds");
	}
}

