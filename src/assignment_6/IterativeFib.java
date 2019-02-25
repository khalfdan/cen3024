package assignment_6;

//Author Name: Robert Kaye
//Date: 02/24/2019
//Program Name: Kaye_FibonacciApp
//Purpose: Run the Fibonacci sequence using the Iterative method

public class IterativeFib
{
	// initiate variables
	static long startTime = 0;
	static long endTime = 0;
	static long duration = 0;

	public static long iterFib (long inputFib)
	{
		// initiate variables
		long tempFib1 = 0;
		long tempFib2 = 1;
		long fibNumber = 1;

		// get the current time before running the sequence to use for the duration calculation
		startTime = System.nanoTime();

		// if the Fibonacci number entered by the user is 0, return 0 (no calculation needed)
		if (inputFib == 0)
		{
			fibNumber = 0;
		}
		// if the Fibonacci number entered by the user is 1 or 2, return 1 (no calculation needed)
		if (inputFib == 1 || inputFib == 2)
		{
			fibNumber = 1;
		}
		// if the Fibonacci number entered is higher than 2, do this
		for (int i = 3; i <= inputFib; i++)
		{
			tempFib1 = tempFib2;
			tempFib2 = fibNumber;
			fibNumber = tempFib1 + tempFib2;
		}
		// get the current time after running the sequence to use for the duration calculation
		endTime = System.nanoTime();
		// returns the number
		return fibNumber;
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
