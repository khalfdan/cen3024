package assignment_8;

import static org.junit.Assert.*;

import org.junit.Test;

//Author Name: Robert Kaye
//Date: 03/24/2019
//Program Name: Kaye_Spellcheck_GUI with J Unit Test
//Purpose: JUnit Test for Spellcheck_GUI

public class Kaye_Spellcheck_GUITest {

	@Test
	public void test() {
		Kaye_Spellcheck_GUI test = new Kaye_Spellcheck_GUI();
		String testFileName2 = "C:/temp/testStates.txt";
		String dictFileName2 = "C:/temp/dictionary.txt";
		String jUnitResults = "labama1 is an unknown word \nAlaka is an unknown word \nIwa is an unknown word \nMariland is an unknown word \n";
		String jUnitTestResults = test.runCompare(testFileName2, dictFileName2);
		assertEquals(jUnitResults, jUnitTestResults);
	}
}
