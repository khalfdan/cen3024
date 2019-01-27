package assignment_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

//Author Name: Robert Kaye
//Date: 01/26/2019
//Program Name: Kaye_Spellcheck
//Purpose: Create a spell checker to compare 2 txt files

public class Kaye_Spellcheck {

	static String dictionary;
	static String dictionaryText;
	static String testFile;
	static String testFileText;
	static Scanner s;
	static Scanner keyboard;
	static ArrayList<String> dictArray;
	static ArrayList<String> testArray;

	public static void main(String[] args) throws Exception{
		// initializing scanner to get input from the user
		keyboard = new Scanner(System.in);

		// display text for user to interface with
		System.out.println("This program will read data from 2 txt files to compare them for spelling.");
		System.out.println("Enter the name of the Test file");
		// captures typed text and stores it in the testFile variable
		testFile = keyboard.nextLine();
		System.out.println("Enter the name of the Dictionary file");
		// captures typed text and stores it in the dictionary variable
		dictionary = keyboard.nextLine();

/*		Code used to easily test files without having to type filenames every time.
 * 		testFile = "testStates.txt";
		dictionary = "dictionary.txt";*/
		// runs readFileAsString method to convert both txt files into their respective String variables
		testFileText = readFileAsString(testFile);
		dictionaryText = readFileAsString(dictionary);

/*		This is the original method calls I had that read directly from the file to an ArrayList.
 * 		I saw later that the instructions said to read the files in String variables, so I created
 * 		new methods below.
 * 		oldreadTestFile();
		oldreadDictionary();*/

		// converts the String variables into ArrayLists
		readDictionary();
		readTestFile();

		// for loop that compares every index of both ArrayLists
		for (int i=0; i < dictArray.size(); i++)
		{
			// if the indexes contain the same information, do nothing
			if (dictArray.get(i).equals(testArray.get(i))) {
			}
			// if the indexes do not contain the same information, print word and unknown word text
			else
				System.out.println(testArray.get(i) + " is an unknown word");
		}
	}

	// method to convert a file to a String variable
	private static String readFileAsString(String fileName) {
		// sets the text String variable to blank
		String text = "";
		// try block to convert file to String
		try {
			text = new String(Files.readAllBytes(Paths.get(fileName)));
		}
		// throws an IOException of there is an error converting the file to a String
		catch (IOException e) {
			e.printStackTrace();
		}
		// returns the String to the method call
		return text;
	}

	// method to convert the testFile String variable into an ArrayList
	private static void readTestFile(){
		// puts the testFileText into the scanner object
		s = new Scanner(testFileText);
		// sets testArray Arraylist a blank ArrayList
		testArray = new ArrayList<String>();
		// adds each line of String into an ArrayList index
		while (s.hasNextLine())
			testArray.add(s.nextLine());
	}

	// method to convert the dictionary String variable into an ArrayList
	private static void readDictionary(){
		// puts the dictionaryText into the scanner object
		s = new Scanner(dictionaryText);
		// sets dictArray Arraylist a blank ArrayList
		dictArray = new ArrayList<String>();
		// adds each line of String into an ArrayList index
		while (s.hasNextLine())
			dictArray.add(s.nextLine());
	}
	// old method to convert directly from testStates.txt file to ArrayList
/*	private static void oldreadTestFile() throws FileNotFoundException {
		s = new Scanner(new File(testFile));
		testArray = new ArrayList<String>();
		while (s.hasNextLine())
			testArray.add(s.nextLine());
	}*/
	// old method to convert directly from dictionary.txt file to ArrayList
/*	private static void oldreadDictionary() throws FileNotFoundException {
		s = new Scanner(new File(dictionary));
		dictArray = new ArrayList<String>();
		while (s.hasNextLine())
			dictArray.add(s.nextLine());
	}*/


}