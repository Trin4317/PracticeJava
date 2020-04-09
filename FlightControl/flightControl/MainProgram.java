package flightControl;

import java.util.Scanner;

import flightControl.logic.FlightControl;
import flightControl.ui.TextUI;

public class MainProgram {

	public static void main(String[] args) {
		FlightControl flightControl = new FlightControl();
		Scanner scanner = new Scanner(System.in);
		TextUI mainProgram = new TextUI(flightControl, scanner);
		mainProgram.start();
	}

}
