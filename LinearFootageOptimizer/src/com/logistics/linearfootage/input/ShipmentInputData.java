/**
 * Represents the input data for a shipment.
 * This class encapsulates the dimensions of the truck or trailer used for shipment
 * and a list of items (e.g., skid's or pallet's) with their respective dimensions.
 *
 * @author Akhil Gopinathan Nair
 * @version 1.0
 * @since 2023-11-02
 */

package com.logistics.linearfootage.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.logistics.linearfootage.model.LineItem;

public class ShipmentInputData {
	private int truckWidthInches; // Width of the truck or trailer in inches
	private int truckHeightInches; // Height of the truck or trailer in inches
	private int numberOfItems; // Number of items in the shipment
	private List<LineItem> items = new ArrayList<>();; // List of items in the shipment

	/**
	 * Default constructor for ShipmentInputData. Creates an instance with default
	 * values for fields.
	 */
	public ShipmentInputData() {
	}

	/**
	 * Constructs a ShipmentInputData object with the provided input data.
	 * 
	 * @param truckWidthInches  Width of the truck or trailer in inches
	 * @param truckHeightInches Height of the truck or trailer in inches
	 * @param numberOfItems     Number of items in the shipment
	 * @param items             List of items in the shipment
	 */
	public ShipmentInputData(int truckWidthInches, int truckHeightInches, int numberOfItems, List<LineItem> items) {
		this.truckWidthInches = truckWidthInches;
		this.truckHeightInches = truckHeightInches;
		this.numberOfItems = numberOfItems;
		this.items = items;
	}

	/**
	 * Get the width of the truck or trailer in inches.
	 * 
	 * @return Width of the truck or trailer in inches
	 */
	public int getTruckWidthInches() {
		return truckWidthInches;
	}

	/**
	 * Gathers user input to populate the ShipmentInputData object with truck
	 * dimensions, the number of items, and individual skid (item) details for the
	 * shipment. Assumes that the user will provide input for truck dimensions and
	 * each item.
	 */
	public void gatherUserInput() {
		try (Scanner scanner = new Scanner(System.in)) {
			// Input 1: Dimensions of the truck/trailer used for shipment.
			System.out.println("Enter the dimensions of the TRUCK (Width in inches, Height in inches)");
			System.out.println("Width:");
			this.truckWidthInches = scanner.nextInt();
			System.out.println("Height:");
			this.truckHeightInches = scanner.nextInt();

			// Input 2: Count of the skid's/pallet's in consideration for the shipment.
			System.out.println("Enter the number of skids:");
			this.numberOfItems = scanner.nextInt();

			// Creating an ArrayList to hold the list of skid's along with their
			// dimensions and properties
			for (int i = 1; i <= this.numberOfItems; i++) {
				// Input 3: Individual Dimensions and Properties of each skid in consideration
				// for the shipment
				System.out.println("Enter dimensions of Skid " + i + " (length, width, height in inches):");
				System.out.println("Length:");
				int lengthInches = scanner.nextInt();
				System.out.println("Width:");
				int widthInches = scanner.nextInt();
				System.out.println("Height:");
				int heightInches = scanner.nextInt();

				System.out.println("Is the Skid Stackable (Y/N):");
				String stackableInput = scanner.next().trim();
				boolean stackable = stackableInput.equalsIgnoreCase("Y");

				// Adding each item as a LineItem object to the list invoking the parameterized
				// constructor for LineItem class
				this.items.add(new LineItem(lengthInches, widthInches, heightInches, 1, stackable, false));
			}
		}
	}

	/**
	 * Get the height of the truck or trailer in inches.
	 * 
	 * @return Height of the truck or trailer in inches
	 */
	public int getTruckHeightInches() {
		return truckHeightInches;
	}

	/**
	 * Get the number of items in the shipment.
	 * 
	 * @return Number of items in the shipment
	 */
	public int getNumberOfItems() {
		return numberOfItems;
	}

	/**
	 * Get the list of items in the shipment.
	 * 
	 * @return List of items in the shipment
	 */
	public List<LineItem> getItems() {
		return items;
	}

}
