package assignment_6;

//Author Name: Robert Kaye
//Date: 02/24/2019
//Program Name: Kaye_FibonacciApp
//Purpose: Run the Fibonacci sequence using the Recursive method

public class RecursiveFib {
	// initiate variables
	static long startTime = 0;
	static long endTime = 0;
	static long duration = 0;

	public static long recurFib (long inputFib)
	{
		// initiate variable
		long fibNumber = 0;
		// get the current time before running the sequence to use for the duration calculation
		startTime = System.nanoTime();
		// run the Fibonacci sequence
		fibNumber = calcFib(inputFib);
		// get the current time after running the sequence to use for the duration calculation
		endTime = System.nanoTime();
		// returns the number
		return fibNumber;
	}

	public static long calcFib (long fibNumber)
	{
		// if the Fibonacci number entered by the user is 0, return 0 (no calculation needed)
		if (fibNumber == 0)
			return 0;
		// if the Fibonacci number entered by the user is 1 or 2, return 1 (no calculation needed)
		if (fibNumber == 1 || fibNumber == 2)
			return 1;
		// if the Fibonacci number entered is higher than 2, do this
		return calcFib(fibNumber - 1) + calcFib(fibNumber - 2);
	}

	// method to get the time it took to run the sequence
	public static long getDuration()
	{
		// set the duration equal to the end time minus the start time
		duration = endTime - startTime;
		// return the total time it took to run the sequence
		return duration;
	}
}
