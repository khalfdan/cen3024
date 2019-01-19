package assignment_1;

import java.util.Scanner;

//Author Name: Robert Kaye
//Date: 01/09/2019
//Program Name: Kaye_Airplane
//Purpose: Simulation using "call" button, call attendant

public class Kaye_Airplane {
	//Initialize array with all seats set to 0 (light off)
	static int seats[] = {0,0,0,0,0};

	//initialize static variables
	static int response = 0;
	static int attendantResponse = 0;
	static int passengerResponse = 0;
	static int seatResponse = 0;
	static int state = 0;

	//initialize keyboard input
	static Scanner keyboard = new Scanner(System.in);

	//main method
	public static void main(String[] args) {
		//print welcome message
		System.out.println("Welcome to the virtual call attendant button simulation");
		//loop through main menu until option 3 is chosen
		do {
			//show menu and get response from user on main menu choice
			response = getChoice();

			//run code depending on the option chosen from the main menu
			switch (response) {

			case 1:
				//Passenger menu
				do {
					//call method to get choice from Passenger menu, and set it to the passengerResponse variable
					passengerResponse = getPassengerChoice();

					switch (passengerResponse) {

					//passenger seat 1
					case 1:
						System.out.println("You are sitting in Seat " + passengerResponse + ", the light is currently " + lightState(seats[passengerResponse - 1]));
						do {
							//call method to get choice from Seat menu, and set it to the seatReponse variable
							seatResponse = getSeatChoice();
							switch (seatResponse) {
							//toggle light on off for current seat (passengerResponse)
							case 1:
								toggleLight(passengerResponse - 1);
								System.out.println("Seat " + passengerResponse + "'s light is now " + lightState(seats[passengerResponse - 1]));
								break;
							//return to seat menu
							case 2:
								System.out.println("Returning to seat menu.");
								break;
							//error when a number besides 1-2 is chosen
							default:
								System.out.println("Invalid value. Enter a value 1-2");
								break;
							}
						}
						//end do while loop when 2 is chosen, return to previous menu
						while (seatResponse != 2);
						break;
					//passenger seat 2
					case 2:
						System.out.println("You are sitting in Seat " + passengerResponse + ", the light is currently " + lightState(seats[passengerResponse - 1]));
						do {
							//call method to get choice from Seat menu, and set it to the seatReponse variable
							seatResponse = getSeatChoice();
							switch (seatResponse) {
							//toggle light on off for current seat (passengerResponse)
							case 1:
								toggleLight(passengerResponse - 1);
								System.out.println("Seat " + passengerResponse + "'s light is now " + lightState(seats[passengerResponse - 1]));
								break;
							//return to seat menu
							case 2:
								System.out.println("Returning to seat menu.");
								break;
							//error when a number besides 1-2 is chosen
							default:
								System.out.println("Invalid value. Enter a value 1-2");
								break;
							}
						}
						//end do while loop when 2 is chosen, return to previous menu
						while (seatResponse != 2);
						break;
					//passenger seat 3
					case 3:
						System.out.println("You are sitting in Seat " + passengerResponse + ", the light is currently " + lightState(seats[passengerResponse - 1]));
						do {
							//call method to get choice from Seat menu, and set it to the seatReponse variable
							seatResponse = getSeatChoice();
							switch (seatResponse) {
							//toggle light on off for current seat (passengerResponse)
							case 1:
								toggleLight(passengerResponse - 1);
								System.out.println("Seat " + passengerResponse + "'s light is now " + lightState(seats[passengerResponse - 1]));
								break;
							//return to seat menu
							case 2:
								System.out.println("Returning to seat menu.");
								break;
							//error when a number besides 1-2 is chosen
							default:
								System.out.println("Invalid value. Enter a value 1-2");
								break;
							}
						}
						//end do while loop when 2 is chosen, return to previous menu
						while (seatResponse != 2);
						break;
					//passenger seat 4
					case 4:
						System.out.println("You are sitting in Seat " + passengerResponse + ", the light is currently " + lightState(seats[passengerResponse - 1]));
						do {
							//call method to get choice from Seat menu, and set it to the seatReponse variable
							seatResponse = getSeatChoice();
							switch (seatResponse) {
							//toggle light on off for current seat (passengerResponse)
							case 1:
								toggleLight(passengerResponse - 1);
								System.out.println("Seat " + passengerResponse + "'s light is now " + lightState(seats[passengerResponse - 1]));
								break;
							//return to seat menu
							case 2:
								System.out.println("Returning to seat menu.");
								break;
							//error when a number besides 1-2 is chosen
							default:
								System.out.println("Invalid value. Enter a value 1-2");
								break;
							}
						}
						//end do while loop when 2 is chosen, return to previous menu
						while (seatResponse != 2);
						break;
					//passenger seat 5
					case 5:
						System.out.println("You are sitting in Seat " + passengerResponse + ", the light is currently " + lightState(seats[passengerResponse - 1]));
						do {
							//call method to get choice from Seat menu, and set it to the seatReponse variable
							seatResponse = getSeatChoice();
							switch (seatResponse) {
							//toggle light on off for current seat (passengerResponse)
							case 1:
								toggleLight(passengerResponse - 1);
								System.out.println("Seat " + passengerResponse + "'s light is now " + lightState(seats[passengerResponse - 1]));
								break;
							//return to seat menu
							case 2:
								System.out.println("Returning to seat menu.");
								break;
							//error when a number besides 1-2 is chosen
							default:
								System.out.println("Invalid value. Enter a value 1-2");
								break;
							}
						}
						//end do while loop when 2 is chosen, return to previous menu
						while (seatResponse != 2);
						break;
					case 6:
						//return to the main menu
						System.out.println("Returning to the main menu.");
						break;
					default:
						//error when a number besides 1-6 is chosen
						System.out.println("Invalid value. Enter a value 1-6");
						break;
					}

				}
				//end do while loop when 6 is chosen, return to previous menu
				while (passengerResponse != 6);
				break;
			case 2:
				//Flight Attendant menu
				do {
					//call method to get choice from Flight Attendant menu, and set it to the attendantResponse variable
					attendantResponse = getAttendantChoice();

					switch (attendantResponse) {
					//toggle seat 1 light on/off
					case 1:
						toggleLight(attendantResponse - 1);
						System.out.println("Seat " + attendantResponse + "'s light is now " + lightState(seats[attendantResponse - 1]));
						break;
					//toggle seat 2 light on/off
					case 2:
						toggleLight(attendantResponse - 1);
						System.out.println("Seat " + attendantResponse + "'s light is now " + lightState(seats[attendantResponse - 1]));
						break;
					//toggle seat 3 light on/off
					case 3:
						toggleLight(attendantResponse - 1);
						System.out.println("Seat " + attendantResponse + "'s light is now " + lightState(seats[attendantResponse - 1]));
						break;
					//toggle seat 4 light on/off
					case 4:
						toggleLight(attendantResponse - 1);
						System.out.println("Seat " + attendantResponse + "'s light is now " + lightState(seats[attendantResponse - 1]));
						break;
					//toggle seat 5 light on/off
					case 5:
						toggleLight(attendantResponse - 1);
						System.out.println("Seat " + attendantResponse + "'s light is now " + lightState(seats[attendantResponse - 1]));
						break;
					//turn off all lights
					case 6:
						turnOffLights();
						System.out.println("All lights turned off");
						break;
					case 7:
						//return to previous menu
						System.out.println("Returning to the main menu.");
						break;
					default:
						//error when a number besides 1-7 is chosen
						System.out.println("Invalid value. Enter a value 1-7");
						break;
					}

				}
				//end do while loop when 7 is chosen, return to previous menu
				while (attendantResponse != 7);
				break;
			case 3:
				//end the program
				System.out.println("Thank you for using the call button simulation!");
				System.out.println("Goodbye!");
				break;
			default:
				//error when a number besides 1-3 is chosen
				System.out.println("Invalid value.  Enter a value 1-3");
				System.out.println("");
				break;

			}

		}
		//end do while loop when 3 is chosen, this will end the program
		while (response != 3);

	}

	//method to display menu, and ask for the choice for the passenger to choose while sitting in a seat
	private static int getSeatChoice() {
		System.out.println("Please select from the following options:");
		System.out.println("1. Toggle light on/off");
		System.out.println("2. Return to seat menu");
		return Integer.parseInt(keyboard.nextLine());
	}

	//method to display menu, and ask for the choice to be a Passenger, Flight Attendant, or end the program
	private static int getChoice() {
		System.out.println("Please select from the following options:");
		System.out.println("1. Passenger simulation");
		System.out.println("2. Flight Attendant simulation");
		System.out.println("3. Exit program");
		return Integer.parseInt(keyboard.nextLine());
	}

	//method to display menu, and ask for the choice for the passenger to choose which seat to sit in
	private static int getPassengerChoice() {
		System.out.println("Passenger simulation.");
		System.out.println("Choose the seat number (1-5) that you are currently sitting in.");
		System.out.println("This will toggle the call button on/off for your seat.");
		System.out.println("Choose 6 to return to the main menu.");
		return Integer.parseInt(keyboard.nextLine());
	}

	//method to display Flight Attendant menu, current light status for all seats, and options to choose a single light to toggle, or turn all lights off
	public static int getAttendantChoice() {
		System.out.println("Flight Attendant simulation.");
		System.out.println("Here is the current status of the call button lights");
		System.out.println("-----------------------------------------");
		System.out.println("| Seat1 | Seat2 | Seat3 | Seat4 | Seat5 |");
		System.out.println("|---------------------------------------|");
		System.out.println("|  " + lightState(seats[0]) + "  |  " + lightState(seats[1]) + "  |  "
				+ lightState(seats[2]) + "  |  " + lightState(seats[3]) + "  |  " + lightState(seats[4]) + "  |");
		System.out.println("-----------------------------------------");
		System.out.println("Choose a seat number to toggle, choose 6 to turn off all lights, or 7 to return to the main menu");
		return Integer.parseInt(keyboard.nextLine());
	}

	//method to get current light state (on or off)
	public static String lightState(int state) {
		if (state == 1)
			return "on ";

		else
			return "off";
	}

	//method to toggle the light from off to on, or on to off
	public static void toggleLight(int state) {
		if (seats[state] == 1)
			seats[state] = 0;
		else if (seats[state] == 0)
			seats[state] = 1;
	}

	//method to turn all lights off
	public static void turnOffLights() {
		seats[0] = 0;
		seats[1] = 0;
		seats[2] = 0;
		seats[3] = 0;
		seats[4] = 0;
	}
}
