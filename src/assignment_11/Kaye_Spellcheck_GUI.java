package assignment_11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
//Date: 04/13/2019
//Program Name: Kaye_Spellcheck_GUI
//Purpose: Create a spell checker to compare a file to a dictionary file loaded from a database with GUI

public class Kaye_Spellcheck_GUI extends Application implements EventHandler<ActionEvent> {
	// declaring variables
	Button buttonTestFile;
	Button buttonRun;
	Label labelTestFile = new Label("Test File");
	Label labelTextArea = new Label("Results");
	Label testFile = new Label();
	FileChooser fileName = new FileChooser();

	// declare static variables for database connection, edit these to match your DB info
	static String username = "user";
	static String password = "pass";
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/spelling";

	// declaring static variables
	static TextArea textArea = new TextArea();
	static Scanner s;
	static String testFileName2;
	static String testFileText;
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

	buttonRun = new Button();
	buttonRun.setText("Run Spellchecker");
	buttonRun.setOnAction(
		new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					// run method to connect to database and get the dictionary ArrayList
					getDictionary();
				} catch (Exception e) {
					e.printStackTrace();
				}
				// run method to compare test file with dictionary ArrayList
				runCompare(testFileName2);
			}
		}
	);

	// sets label width to 250
	testFile.setPrefWidth(250);

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

	@Override
	public void handle(ActionEvent event) {

	}

	public String runCompare(String testFileName2) {
		// runs readFileAsString method to convert both txt files into their respective String variables
		testFileText = readFileAsString(testFileName2);
		// converts the testFile String variable into an ArrayList
		readTestFile();
			// for loop that compares every index of both ArrayLists
		for (int i=0; i < dictArray.size(); i++) {
			// if the indexes contain the same information, do nothing
			if (dictArray.get(i).equals(testArray.get(i))) {
			}
			// if the indexes do not contain the same information, print word and unknown word text
			else {
				results += (testArray.get(i) + " is an unknown word \n");
				// textArea.appendText(testArray.get(i) + " is an unknown word \n");
			}
		}
		textArea.appendText(results);
		return results;
	}

	public static ArrayList<String> getDictionary() throws Exception {
		try {
			// creates a connection to the database
			Connection conn = getConnection();
			// creates a SQL statement to select the word column from the word table in the spelling database
			PreparedStatement statement = conn.prepareStatement("SELECT word FROM spelling.word");
			// runs the SQL query
			ResultSet result = statement.executeQuery();
			// returns each row as an item in the dictArray ArrayList
			dictArray = new ArrayList<String>();
			while(result.next()) {
				dictArray.add(result.getString("word"));
			}
			return dictArray;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static Connection getConnection() throws Exception {
		try {
			Class.forName(driver);
			// connect to the databse using the url, username and password
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
