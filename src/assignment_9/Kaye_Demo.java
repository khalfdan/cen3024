package assignment_9;

//Author Name: Robert Kaye / Youtube
//Date: 03/31/2019
//Program Name: Kaye_Demo
//Purpose: Demo code from youtube video

public class Kaye_Demo {
	// declare variables
	private static int count = 0;

	// method to increase count, needed for synchonization
	public static synchronized void incCount() {
		count++;
	}

	// main method
	public static void main(String[] args) {
		// instantiates a new Thread and makes it runnable
		Thread t1 = new Thread (new Runnable() {
			@Override
			public void run() {
				// method to increase count by 1 10,000 times
				for(int i=0; i<10000; i++) {
					incCount();
				}
			}
		});

		// instantiates another new Thread and makes it runnable
		Thread t2 = new Thread (new Runnable() {
			@Override
			public void run() {
				// method to increase count by 1 10,000 times
				for(int i=0; i<10000; i++) {
					incCount();
				}
			}
		});
		//start both Threads
		t1.start();
		t2.start();

		// try catch block using join to make both Threads finish before next step
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// print out final count after running both Threads
		System.out.println("Value of count: " + count);
	}
}
