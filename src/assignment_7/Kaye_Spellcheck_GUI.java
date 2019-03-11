package assignment_7;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

//Author Name: Robert Kaye
//Date: 03/10/2019
//Program Name: Kaye_Spellcheck_GUI
//Purpose: Create a spell checker to compare 2 txt files through a GUI

public class Kaye_Spellcheck_GUI extends Application implements EventHandler<ActionEvent> {
	// declaring variables
	Button buttonTestFile;
	Button buttonDictFile;
	Button buttonRun;
	Label labelTestFile = new Label("Test File");
	Label labelDictFile = new Label("Dictionary File");
	Label labelTextArea = new Label("Results");
	Label testFile = new Label();
	Label dictFile = new Label();
	FileChooser fileName = new FileChooser();
	
	// declaring static variables
	static TextArea textArea = new TextArea();
	static Scanner s;
	static String testFileName2;
	static String dictFileName2;
	static String testFileText;
	static String dictFileText;
	static ArrayList<String> dictArray;
	static ArrayList<String> testArray;
	static ArrayList<String> resultsArray;
	static String results = "";
		
	// main method, just launches JavaFX application
	public static void main(String[] args) {
		launch(args);
	}
	
	// start method containing primaryStage for JavaFX application
	@Override
	public void start(Stage primaryStage) throws Exception {
	// sets the title for the JavaFX application
	primaryStage.setTitle("Spell Checker GUI");
	
	// sets the details for the top button (test file) 
	buttonTestFile = new Button();
	buttonTestFile.setText("Browse");
	buttonTestFile.setOnAction(
		new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(event.getSource()==buttonTestFile) {
					// opens File Chooser dialog
					File testFileName = fileName.showOpenDialog(primaryStage);
					// converts filename to string
					testFileName2 = testFileName.toString();
					// if the filename is not empty, sets the label with the filename
					if (testFileName != null) {
						testFile.setText(testFileName2);
					}
				}
			
			}
		}
	);
	
	// sets teh details for the middle button (dictionary file)
	buttonDictFile = new Button();
	buttonDictFile.setText("Browse");
	buttonDictFile.setOnAction(
		new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(event.getSource()==buttonDictFile) {
					// opens File Chooser dialog
					File testDictName = fileName.showOpenDialog(primaryStage);
					dictFileName2 = testDictName.toString();
					// if the filename is not empty, sets the label with the filename
					if (testDictName != null) {
						dictFile.setText(dictFileName2);
					}
				}
			
			}
		}
	);
	
	buttonRun = new Button();
	buttonRun.setText("Run Spellchecker");
	buttonRun.setOnAction(
		new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(event.getSource()==buttonRun) {
					// runs readFileAsString method to convert both txt files into their respective String variables
					testFileText = readFileAsString(testFileName2);
					dictFileText = readFileAsString(dictFileName2);
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
						else {
							textArea.appendText(testArray.get(i) + " is an unknown word \n");
						}
					}
				}
			}
		}
	);
	
	// sets label width to 250 
	testFile.setPrefWidth(250);
	dictFile.setPrefWidth(250);
	
	// sets pane information for scene
	BorderPane mainLayout = new BorderPane();
	GridPane subLayout = new GridPane();
	FlowPane resultsPane = new FlowPane();
	mainLayout.setCenter(subLayout);
	mainLayout.setBottom(textArea);
	subLayout.setPadding(new Insets(10, 10, 10, 10));
	subLayout.setHgap(15);
	subLayout.setVgap(5);
	
	// adds labels and buttons to GridPane
	subLayout.add(labelTestFile, 0, 0);
	subLayout.add(testFile, 1, 0);
	subLayout.add(buttonTestFile, 2, 0);
	subLayout.add(labelDictFile, 0, 1);
	subLayout.add(dictFile, 1, 1);
	subLayout.add(buttonDictFile, 2, 1);
	subLayout.add(buttonRun, 1, 2);
	subLayout.setHalignment(buttonRun, HPos.CENTER);
	
	// sets the scene
	Scene mainScene = new Scene(mainLayout, 435, 300);
	primaryStage.setScene(mainScene);
	
	// starts the show
	primaryStage.show();
	}

		// code from the original assignment 3 spellchecker
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
			s = new Scanner(dictFileText);
			// sets dictArray Arraylist a blank ArrayList
			dictArray = new ArrayList<String>();
			// adds each line of String into an ArrayList index
			while (s.hasNextLine())
				dictArray.add(s.nextLine());
		}

		@Override
		public void handle(ActionEvent event) {
			
		}

}
