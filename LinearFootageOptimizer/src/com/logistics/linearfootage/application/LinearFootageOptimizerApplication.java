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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.logistics.linearfootage.model.LineItem;
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
			System.out.println("Enter the dimensions of the truck (width in inches, height in inches):");
			int truckWidthInches = scanner.nextInt();
			int truckHeightInches = scanner.nextInt();

			System.out.println("Enter the number of skids/line items:");
			int itemCount = scanner.nextInt();

			List<LineItem> lineItems = new ArrayList<>();
			for (int i = 1; i <= itemCount; i++) {
				System.out.println("Enter dimensions for Line Item " + i + " (length, width, height in inches):");
				int lengthInches = scanner.nextInt();
				int widthInches = scanner.nextInt();
				int heightInches = scanner.nextInt();
				System.out.println("Item Stackable or Not (true/false):");
				boolean stackable = scanner.nextBoolean();
				lineItems.add(new LineItem(lengthInches, widthInches, heightInches, 1, stackable, false));
			}

			LinearFootageOptimizer linearFootageOptimizer = new LinearFootageOptimizer();
			int linearFeet = linearFootageOptimizer.calculateLinearFootage(lineItems, truckWidthInches,
					truckHeightInches);
			System.out.println("Linear footage: " + linearFeet + " feet");
		}

	}

}
