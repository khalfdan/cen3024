package assignment_6;

import java.util.Scanner;

//Author Name: Robert Kaye
//Date: 02/24/2019
//Program Name: Kaye_FibonacciApp
//Purpose: Test the length of time it takes both the Iterative and Recursive methods to run the Fibonacci sequence

public class Kaye_FibonacciApp {

	public static void main(String[] args) {
		//initiate variables
		long testFib = 0;
		long result = 0;
		long duration = 0;
		Scanner keyboard = new Scanner(System.in);

		// anything above 50 will take a very long time to calculate using recursive
		// anything above 92 would need to be stored in a BigInteger, which would cause slowdowns in performance
		System.out.println("Enter Fib number between 0 and 50");
		// place the integer the user enters into the testFib variable
		testFib = keyboard.nextInt();
		// runs the Iterative test using the testFib variable, and places it in the result variable
		result = IterativeFib.iterFib(testFib);
		// calls the getDuration method within Iterative test to get the length of time in nanoseconds it took to run
		duration = IterativeFib.getDuration();
		// displays a blank line in between the user prompt and the Iterative results
		System.out.println();
		// display the time it took to run the Iterative test to the user
		System.out.println("The time it took to run the Iterative Fibonacci sequence was " + duration + " nano seconds");
		// display the Fibonacci number for the number the user input
		System.out.println("The Fibonacci number for " + testFib + " is " + result);
		// runs the Recursive test using the testFib variable, and places it in the result variable
		result = RecursiveFib.recurFib(testFib);
		// calls the getDuration method within Recursive test to get the length of time in nanoseconds it took to run
		duration = RecursiveFib.getDuration();
		// display the time it took to run the Recursive test to the user
		// displays a blank line in between the Iterative and Recursive results
		System.out.println();
		System.out.println("The time it took to run the Recursive Fibonacci sequence was " + duration + " nano seconds");
		// display the Fibonacci number for the number the user input
		System.out.println("The Fibonacci number for " + testFib + " is " + result);
		// close the keyboard input
		keyboard.close();
	}

}
