/**
 * LinearFootageOptimizerApplication serves as the entry point for the
 * Linear Footage Optimizer application. This class contains the main
 * method that initiates and runs the application.
 *
 * @author Akhil Gopinathan Nair
 * @version 1.0
 * @since 2023-11-01
 */

package com.logistics.linearfootage.application;

import java.util.Scanner;

import com.logistics.linearfootage.input.ShipmentInputData;
import com.logistics.linearfootage.util.LinearFootageOptimizer;

public class LinearFootageOptimizerApplication {

	/**
	 * The main method of the application. It is called when the program is
	 * executed.
	 * 
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("******************** WELCOME TO LINEAR FOOTAGE OPTIMIZER********************");

			// ---Collecting the INPUTS from the user---
			ShipmentInputData shipmentInputData = new ShipmentInputData();
			shipmentInputData.gatherUserInput();

			// Invoke the linear footage algorithm to to calculate the linear footage for
			// the given Line items and the dimensions of trailer in consideration
			LinearFootageOptimizer linearFootageOptimizer = new LinearFootageOptimizer();
			int linearFeet = linearFootageOptimizer.calculateLinearFootage(shipmentInputData.getItems(),
					shipmentInputData.getTruckWidthInches(), shipmentInputData.getTruckHeightInches());

			// ---Display the OUTPUT after processing---
			System.out.println("The LINEAR FOOTAGE of the Shipment is : " + linearFeet + " feet");

			System.out.println("********************************************************************");
			System.out.println("Thank you for using the Linear Footage Optimizer. Have a great day!");

		}
	}
}
